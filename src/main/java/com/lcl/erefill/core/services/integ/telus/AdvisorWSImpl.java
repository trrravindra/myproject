package com.lcl.erefill.core.services.integ.telus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import javax.xml.ws.Holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcl.erefill.core.common.entity.PrescriptionsBO;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillApplicationException;
import com.lcl.erefill.core.exception.ErrorHandler;
import com.lcl.erefill.core.exception.NoCounsellingSheetException;
import com.lcl.erefill.core.services.BaseService;
import com.lcl.erefill.core.utils.CommonUtils;
import com.lcl.erefill.core.utils.HTMLParseLister;
import com.lcl.erefill.core.utils.PropertyUtil;
import com.lcl.erefill.core.vo.Details;
import com.lcl.erefill.core.vo.DrugHeaderView;
import com.lcl.erefill.core.vo.DrugInformation;
import com.lcl.erefill.generated.telus.advisor.advisorsheets.IAdvisorSheetsSvcGetMedCounsellingSheetErrorFaultFaultMessage;
import com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib.ELanguage;
import com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts.CounsellingSheetLanguage;
import com.lcl.erefill.generated.telus.advisor.advisorsheets.rxassystlib_contracts.UserToken;

@Service
public class AdvisorWSImpl extends BaseService {

	@Autowired
	ProfileWSImpl profileService;

	private static final Logger log = LoggerFactory.getLogger(AdvisorWSImpl.class);

	private enum SiteLanguage {
		en_CA(ELanguage.ENGLISH), fr_CA(ELanguage.FRENCH);
		private final ELanguage value;

		SiteLanguage(ELanguage value) {
			this.value = value;
		}
	}

	public DrugHeaderView getDrugOverlayHeader(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String patientOID, String strDIN, String strLocale) {
		DrugHeaderView retDrugHeader = null;
		List<PrescriptionsBO> tempList = profileService.getPrescriptions(
				userToken, strLocale, patientOID);

		if (!CommonUtils.isNullOrEmpty(tempList)
				&& !CommonUtils.isStringNullOrEmpty(strDIN)) {
			for (PrescriptionsBO cachePresc : tempList) {
				if (null != cachePresc.getDIN()
						&& cachePresc.getDIN().equals(strDIN)) {
					retDrugHeader = new DrugHeaderView();
					retDrugHeader.setDin(strDIN);
					retDrugHeader.setName(cachePresc.getName());
					retDrugHeader.setGenericName(cachePresc.getGenericName());
					retDrugHeader.setStrength(cachePresc.getStrength());
					retDrugHeader.setRxNum(cachePresc.getRxNumber());
					retDrugHeader.setInstructions(cachePresc.getSigDecoded());
					break;
				}
			}
		}
		return retDrugHeader;
	}

	private ELanguage getLanguage(String strPgLang) {
		ELanguage elangRetVal = null;
		for (SiteLanguage langEnum : SiteLanguage.values()) {
			if (langEnum.toString().equals(strPgLang)) {
				elangRetVal = langEnum.value;
				break;
			}
		}
		return elangRetVal;
	}

	public DrugInformation getMedCouncellingSheet(
			com.lcl.erefill.core.common.entity.UserToken userToken,
			String strLang, String strDIN) {
		log.debug("executing getMedCouncellingSheet() start");
		DrugInformation retDrugInfo = null;
		if (!CommonUtils.isStringNullOrEmpty(strDIN)) {
			try {
				Holder<UserToken> tokenHolder = prepareAdvisorSheetsTokenHolder(userToken);
				log.debug("performing prepareAdivosrSheetsTokenHolder() end");
				CounsellingSheetLanguage counsellingSheetLanguage = new CounsellingSheetLanguage();
				counsellingSheetLanguage
						.setLanguage(null != getLanguage(strLang) ? getLanguage(strLang)
								: ELanguage.ENGLISH);
				Holder<String> url = new Holder<String>();
				Holder<String> checkSum = new Holder<String>();
				Holder<String> imageURL = new Holder<String>();
				Holder<String> imageCheckSum = new Holder<String>();
				long startTime = System.currentTimeMillis();
				log.debug("performing advServ.getMedCounsellingSheet start");
				getAdvisorSheetsService().getMedCounsellingSheet(tokenHolder,
						strDIN, counsellingSheetLanguage, url, checkSum,
						imageURL, imageCheckSum);
				log.debug("performing advServ.getMedCounsellingSheet end");
				log.info(ERefillConstants.EXTERNAL_SRVC_GETMEDCOUNSELLINGSHEET
						+ "|" + CommonUtils.executionTime(startTime));
				userToken.setStatus(tokenHolder.value.getStatus().get(0));
				userToken.setToken(CommonUtils
						.byteArrayAsString(tokenHolder.value.getToken()
								.getValue()));
				retDrugInfo = new DrugInformation();
				if (null != url && !CommonUtils.isNullOrBlank(url.value)) {
					retDrugInfo.setCompleteHtml(
							parseDrugInformationURL( getUrl(url.value), true)
							);
				}
				if (null != imageURL) {
					retDrugInfo.setImageURL(getUrl(imageURL.value));
				}

			} catch (IAdvisorSheetsSvcGetMedCounsellingSheetErrorFaultFaultMessage advSvcExe) {
				log.error("Entered the Fault Block:::::"
						+ advSvcExe.getMessage());

				userToken.setStatus(advSvcExe.getFaultInfo().getUserToken()
						.getValue().getStatus().get(0));
				userToken.setToken(CommonUtils.byteArrayAsString(advSvcExe
						.getFaultInfo().getUserToken().getValue().getToken()
						.getValue()));
				retDrugInfo = null;
				ErrorHandler.handleException(advSvcExe);

			} catch ( NoCounsellingSheetException nce) {
				
				log.error("No counselling exception ");
						
				userToken.setStatus(nce.getStatus() );
				userToken.setToken(nce.getToken());
				throw nce;
				
			}catch (Exception e) {
				log.error("Entering into the Exception Block" + e.getMessage()
						+ "class::" + e.getClass());
				/*retDrugInfo = null;
								
				if (e.getMessage().contains("NoCounsellingSheetException")
						|| e.getCause().toString()
								.contains("NoCounsellingSheetException")) {					*/
					NoCounsellingSheetException nce = ( NoCounsellingSheetException )e.getCause();
					userToken.setStatus(nce.getStatus() );
					userToken.setToken(nce.getToken());
					throw nce;
					
				//} 
				//throw ErrorHandler.handleError(e );
			}

		}
		log.debug("executing getMedCouncellingSheet() end");
		return retDrugInfo;
	}

	/**
	 * @param value
	 * @return
	 */
	private String getUrl(String value) {
		
		return getEnvironmentBasedUrl( value );
		//return value.replace("loblawceq", "loblaw");
		//return value;
	}

	private String getEnvironmentBasedUrl(String value) {

		String environment = PropertyUtil.getErefillEnv();
		if( (environment.equalsIgnoreCase("dev") || environment.equalsIgnoreCase("qa") ) ) {
			value = value.replace("loblawceq", "loblaw");
		}
		return value;
	}

	private String parseDrugInformationURL(String strURL, boolean val)  {
		log.info("executing parseDrugInformationURL() start1111");
		log.info("strURL-->" + strURL);
		BufferedReader bReader = null;
		String returningHtml = null;
		StringBuilder lineItems = new StringBuilder();
		try {
			URL endPiontURL = new URL(strURL);
			bReader = new BufferedReader(new InputStreamReader(endPiontURL.openStream()));
			String lineItem = null;
			while ((lineItem = bReader.readLine()) != null) {
				log.info("lineItem-->" + lineItem);
				lineItems.append(lineItem).append("\n");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			log.error("BAD URL Received for drug information processing {}"
					+ strURL);
			throw new ERefillApplicationException(
					"BAD URL Received for drug information processing");
		} finally {
			if (null != bReader){
				try {
					bReader.close();
				} catch (IOException e) {
				
					log.error("Error reading drug information {}"
							+ strURL);
					throw new ERefillApplicationException(
							"Error reading drug information");
					
				}
			}
		}
		if (lineItems.indexOf("<body>") != -1){
			returningHtml = lineItems.substring(lineItems.indexOf("<body>"), lineItems.indexOf("</body>"));
		} else {
			returningHtml = lineItems.toString();
		}
		return returningHtml;
	}

	/*private List<Details> parseDrugInformationURL(String strURL)
			throws IOException {
		log.debug("executing parseDrugInformationURL() start");
		Reader reader = null;
		try {
			LinkedHashMap<String, String> hmTemp = new LinkedHashMap<String, String>();
			List<Details> retListVal = null;

			if (strURL.indexOf("://") > 0) {
				URL u = new URL(strURL);
				Object content = null;
				try {
					content = u.getContent();
				} catch (Exception e) {
					log.error("BAD URL Received for drug information processing {}"
							+ strURL);
					throw new ERefillApplicationException(
							"BAD URL Received for drug information processing");
				}
				if (content instanceof InputStream) {
					reader = new InputStreamReader((InputStream) content);
				} else if (content instanceof Reader) {
					reader = (Reader) content;
				} else {
					log.error("BAD URL Received for drug information processing {}"
							+ strURL);
					throw new ERefillApplicationException(
							"BAD URL Received for drug information processing");
				}
			} else {
				reader = new FileReader(strURL);
			}
			HTMLEditorKit.Parser parser;
			parser = new ParserDelegator();
			parser.parse(reader, new HTMLParseLister(hmTemp), true);
			if (!hmTemp.isEmpty()) {
				retListVal = new ArrayList<Details>();
				Set<String> keySet = hmTemp.keySet();
				for (String title : keySet) {
					Details drugDetails = new Details();
					String strDesc = hmTemp.get(title).toString();
					if (null != strDesc && !strDesc.isEmpty()) {
						drugDetails.setTitle(title);
						drugDetails
								.setDescription(strDesc
										.split(ERefillConstants.DRUG_INFO_SPLIT_STRING));
					}
					retListVal.add(drugDetails);
				}
			}
			log.debug("executing parseDrugInformationURL() end");
			return retListVal;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ERefillApplicationException(e);
		} catch (Error e) {
			log.error(e.getMessage(), e);
			throw new ERefillApplicationException(e);
		} finally {
			if (null != reader)
				reader.close();
		}
	}*/
}
