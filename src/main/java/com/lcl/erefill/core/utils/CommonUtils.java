package com.lcl.erefill.core.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lcl.erefill.core.common.entity.PrescriptionsBO;
import com.lcl.erefill.core.common.entity.RefillPrescriptionVO;
import com.lcl.erefill.core.constants.ERefillConstants;
import com.lcl.erefill.core.exception.ERefillBusinessException;
import com.lcl.erefill.core.vo.PharmaDeptVO;
import com.lcl.erefill.core.vo.PharmacyVO;
import com.lcl.erefill.core.vo.PrescDetailsView;
import com.lcl.erefill.core.vo.UserSession;
import com.lcl.erefill.generated.telus.operation.rxassystlib_contracts.ExpectedEvent;

public class CommonUtils {

	private static final Logger log = LoggerFactory.getLogger(CommonUtils.class);

	private enum RestrictionTypes {
		NoRefill("lbl_eta_no_refill"), Expired("lbl_eta_expired");

		private final String value;

		RestrictionTypes(String value) {
			this.value = value;
		}
	}

	public static boolean isNullOrBlank(final String value) {
		if (null == value || "".equals(value))
			return true;
		return false;
	}

	public static boolean isNullOrEmpty(
			@SuppressWarnings("rawtypes") final List list) {
		if (null != list && !list.isEmpty()) {
			return false;
		}
		return true;
	}

	public static boolean areEquals(String strFirst, String strSecond) {
		boolean blnRetVal = false;
		if (null != strFirst && strFirst.equals(strSecond)) {
			blnRetVal = true;
		}
		return blnRetVal;
	}

	public static boolean isStringNullOrEmpty(String testString) {
		if (null == testString || (null != testString && testString.isEmpty())) {
			return true;
		} else {
			return false;
		}
	}

	public static String formatStringInUTF8(String strInpVal) {
		String strRetVal = null;
		if (!isStringNullOrEmpty(strInpVal)) {
			byte[] byteData = Charset.forName("UTF-8")
					.encode(CharBuffer.wrap(strInpVal.toCharArray())).array();
			try {
				strRetVal = new String(byteData, "UTF-8");
				strRetVal = strRetVal.trim();
			} catch (UnsupportedEncodingException encodExe) {
				encodExe.printStackTrace();
			}
		}
		return strRetVal;
	}

	public static Date getCustomFormatDate(String strDateVal, String strFormat)
			throws ParseException {
		Date retDtVal = null;
		if (null != strDateVal && null != strFormat) {
			SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
			retDtVal = sdf.parse(strDateVal);
		}
		return retDtVal;
	}
	public static String getFormatDateFr(Date dateStr)
			throws ParseException {
		
	    DateFormat readFormat = new SimpleDateFormat( "EEE MMM d HH:mm:ss zzz yyyy"); 

	    DateFormat writeFormat = new SimpleDateFormat( "dd MMM yyyy",Locale.CANADA_FRENCH);
	    Date date = null;
	    try {
	       date = readFormat.parse( dateStr.toString() );
	    } catch ( ParseException e ) {
	        e.printStackTrace();
	    }

	    String formattedDate = "";
	    if( date != null ) {
	    formattedDate = writeFormat.format(date);
		}
return formattedDate;
	}

	public static String createCacheKey(String keyName, String userName) {
		return keyName + "|" + userName;
	}

	public static String createCacheKey(HttpServletRequest req,
			String strKeyName) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie tmpCookie : cookies) {
				if (tmpCookie.getName().equalsIgnoreCase(
						ERefillConstants.COOKIE_UNIQUIE_NAME)) {
					return strKeyName + "|" + tmpCookie.getValue();
				}

			}
		}
		return strKeyName + "|" + "";
	}

	public static List<String> getSecAnswerAsList(String secAnswer, int choice) {

		List<String> lstSecAns = new ArrayList<String>(2);

		for (int i = 0; i < 3; i++) {
			if (i == choice) {
				lstSecAns.add(secAnswer);
			} else {
				lstSecAns.add(new String());
			}
		}

		return lstSecAns;
	}

	// public static String createCacheKey(Cookie[] cookies, String strKeyName)
	// {
	// if(CookieUtils.getCookie(cookies, ERefillConstants.COOKIE_UNIQUIE_NAME)
	// != null)
	// return strKeyName + "|" + CookieUtils.getCookie(cookies,
	// ERefillConstants.COOKIE_UNIQUIE_NAME).getValue();
	// else
	// return null;
	// }

	public static String formatPhone(final String phone) {
		String formattedPhone = phone;
		if (!CommonUtils.isNullOrBlank(phone) && phone.length() == 10) {
			formattedPhone = phone.substring(0, 3) + "-"
					+ phone.substring(3, 6) + "-" + phone.substring(6, 10);
		}
		return formattedPhone;
	}

	public static int getNumberOfPages(int totalRecords) {
		int numOfPages = 1;
		String pageSize = "10";
		if (null != pageSize) {
			numOfPages = totalRecords % Integer.parseInt(pageSize) == 0 ? totalRecords
					/ Integer.parseInt(pageSize)
					: (totalRecords / Integer.parseInt(pageSize)) + 1;
		}
		return numOfPages;
	}

	public static int getNumberOfPages(int totalRecords, int pageSize) {
		int numOfPages = totalRecords % pageSize == 0 ? totalRecords / pageSize
				: (totalRecords / pageSize) + 1;
		return numOfPages;
	}

	/**
	 * Encodes the byte array into base64 string
	 * 
	 * @param imageByteArray
	 *            - byte array
	 * @return String a {@link java.lang.String}
	 */
	public static String byteArrayAsString(byte[] bytes) {
		return Base64.encodeBase64String(bytes);
	}

	public static String executionTime(long startTime) {
		long totalTime = (System.currentTimeMillis() - startTime) ;
		return String.format("Execution time in mins: %d, in sec: %d, in millis: %d", 
				TimeUnit.MILLISECONDS.toMinutes(totalTime),
			    TimeUnit.MILLISECONDS.toSeconds(totalTime),
			    TimeUnit.MILLISECONDS.toMillis(totalTime));
	}

	public static String encodeURL(String url) {
		try {
			return URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new ERefillBusinessException(e);
		}
	}

	public static String decodeURL(String url) {
		try {
			return URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new ERefillBusinessException(e);
		}
	}

	/**
	 * This method returns the decoded value of password
	 */
	public static String decodeString(String str) {
		byte[] decodedBytes = new Base64().decode(str);
		return new String(decodedBytes);

	}

	public enum ErefillLocales {
		en_CA(Locale.ENGLISH), fr_CA(Locale.CANADA_FRENCH);
		private final Locale value;

		ErefillLocales(Locale value) {
			this.value = value;
		}
	}

	public static Locale getLocaleFromString(String strLocale) {
		Locale locRetVal = Locale.ENGLISH;
		for (ErefillLocales c : ErefillLocales.values()) {
			if (c.toString().equals(strLocale)) {
				locRetVal = c.value;
				break;
			}
		}
		return locRetVal;
	}

	public static String getFormattedDate(int numInputDt, String strFormat,
			String strLocale) throws ParseException {
		String strRetDt = null;
		String strInputDt = new Integer(numInputDt).toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				ERefillConstants.DATE_FORMAT_CUSTOM);
		Date retDate = dateFormat.parse(strInputDt);
		SimpleDateFormat retDtFormat = new SimpleDateFormat(strFormat,
				getLocaleFromString(strLocale));
		strRetDt = retDtFormat.format(retDate);
		return strRetDt;
	}

	public static int getNextFillDate(int numLastFill, int daysSupply)
			throws ParseException {
		int numRetVal;
		String strInputDt = new Integer(numLastFill).toString();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				ERefillConstants.DATE_FORMAT_CUSTOM);
		Date dtLastFill = dateFormat.parse(strInputDt);
		Calendar cal = new GregorianCalendar();
		cal.setTime(dtLastFill);
		cal.add(Calendar.DAY_OF_MONTH, daysSupply);
		Date dtEstNextFill = cal.getTime();
		String strTempRetDt = dateFormat.format(dtEstNextFill);
		numRetVal = Integer.parseInt(strTempRetDt);
		return numRetVal;
	}

	public static String getLastStateDate(XMLGregorianCalendar cal,
			String strLocale) {
		SimpleDateFormat dateformat = null;
		if (strLocale.equals(ERefillConstants.STR_FRENCH_LOCALE)) {
			dateformat = new SimpleDateFormat(
					ERefillConstants.DATE_FORMAT_ORDER_HIST_FR,
					getLocaleFromString(strLocale));
		} else {
			dateformat = new SimpleDateFormat(
					ERefillConstants.DATE_FORMAT_ORDER_HIST,
					getLocaleFromString(strLocale));
		}
		return dateformat.format(cal.toGregorianCalendar().getTime());
	}

	public static String[] getSelectorsOnPharmaPopUp(String strReqURI) {
		String[] retStrArr = null;
		String strStoreId = null;
		String strDepttId = null;
		if (strReqURI.indexOf("/") != -1) {
			strReqURI = strReqURI.replace("/", "");
		}
		String[] tempStrArr = strReqURI.split("\\.");
		if (null != tempStrArr && tempStrArr.length != 0) {
			retStrArr = new String[2];
			strStoreId = tempStrArr[2];
			strDepttId = tempStrArr[3];
			retStrArr[0] = strStoreId;
			retStrArr[1] = strDepttId;
		}

		return retStrArr;
	}

	/**
	 * Decodes the base64 string into byte array
	 * 
	 * @param imageDataString
	 *            - a {@link java.lang.String}
	 * @return byte array
	 */
	public static byte[] stringAsByteArray(String value) {
		return Base64.decodeBase64(value);
	}

	public static Date[] getFromAndToDate(String dateFilter) {
		Date toDate = new Date();
		Date fromDate = null;
		Calendar cal = new GregorianCalendar();
		cal.setTime(toDate);
		if (dateFilter.equals(ERefillConstants.LAST_30_DAYS)) {
			cal.add(Calendar.DAY_OF_MONTH, -30);
			fromDate = cal.getTime();
		} else if (dateFilter.equals(ERefillConstants.LAST_90_DAYS)) {
			cal.add(Calendar.DAY_OF_MONTH, -90);
			fromDate = cal.getTime();
		} else if (dateFilter.equals(ERefillConstants.LAST_180_DAYS)) {
			cal.add(Calendar.DAY_OF_MONTH, -180);
			fromDate = cal.getTime();
		} else if (dateFilter.equals(ERefillConstants.LAST_730_DAYS)) {
			cal.add(Calendar.DAY_OF_MONTH, -730);
			fromDate = cal.getTime();
		}
		return new Date[] { fromDate, toDate };
	}

	public static boolean isValidDate(Date prescDate, Date fromDate, Date toDate) {
		return (prescDate.after(fromDate) && prescDate.before(toDate))
				|| prescDate.equals(fromDate) || prescDate.equals(toDate);
	}

	/**
	 * @author nbahad This method takes Object array and sorts it in ascending
	 *         order (if flagOrder == CommonUtils.ORDER_ASCENDING) or descending
	 *         order (if flagOrder == CommonUtils.ORDER_DESCENDING)
	 * 
	 * @param arrToSort
	 * @param comp
	 * @param flagOrder
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object[] sortEntities(Object[] arrToSort,
			@SuppressWarnings("rawtypes") Comparator comp, boolean flagOrder) {
		Arrays.sort(arrToSort, comp);
		if (flagOrder) {
			return arrToSort;
		} else {
			return reverseArrayOrder(arrToSort);
		}
	}

	/**
	 * @author nbahad This method takes List and sorts it in ascending order (if
	 *         flagOrder == CommonUtils.ORDER_ASCENDING) or descending order (if
	 *         flagOrder == CommonUtils.ORDER_DESCENDING)
	 * 
	 * @param lstToSort
	 * @param comp
	 * @param flagOrder
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List sortEntities(List lstToSort, Comparator comp,
			boolean flagOrder) {
		Collections.sort(lstToSort, comp);
		if (flagOrder) {
			return lstToSort;
		} else {
			Collections.reverse(lstToSort);
			return lstToSort;
		}
	}

	/**
	 * @author nbahad This method is reverse the order of the input array!!
	 * @param arrToReverse
	 * @return
	 */
	private Object[] reverseArrayOrder(Object[] arrToReverse) {
		for (int i = 0; i < arrToReverse.length; i++) {
			if (i == arrToReverse.length / 2)
				break;
			Object temp = arrToReverse[i];
			arrToReverse[i] = arrToReverse[arrToReverse.length - (i + 1)];
			arrToReverse[arrToReverse.length - (i + 1)] = temp;
		}
		return arrToReverse;
	}

	public static XMLGregorianCalendar getDateTime(String dateStr) {
		XMLGregorianCalendar xmlGregcal = null;
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			date = format.parse(dateStr);
			GregorianCalendar gregCal = new GregorianCalendar();
			gregCal.setTime(date);
			xmlGregcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					gregCal);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);

		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage(), e);
		}
		return xmlGregcal;
	}
	
	public static XMLGregorianCalendar getDateTimeFormat(String dateStr) {
		XMLGregorianCalendar xmlGregcal = null;
		try {
			DateFormat format = new SimpleDateFormat("MMM dd yyyy");
			Date date = null;
			date = format.parse(dateStr);
			GregorianCalendar gregCal = new GregorianCalendar();
			gregCal.setTime(date);
			xmlGregcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					gregCal);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);

		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage(), e);
		}
		return xmlGregcal;
	}
	
	public static XMLGregorianCalendar getFormattedFrDate(String strInputDt, String dtFormat) {
		XMLGregorianCalendar xmlGregcal = null;
		SimpleDateFormat retDtFormat = new SimpleDateFormat(dtFormat,Locale.CANADA_FRENCH);
		Date parsedDt = null;
		try {
			parsedDt = retDtFormat.parse(strInputDt);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}
		GregorianCalendar gregCal = new GregorianCalendar();
		gregCal.setTime(parsedDt);
		try {
			xmlGregcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregCal);
		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage(), e);
		}

		 return xmlGregcal;
	}


	public static XMLGregorianCalendar getDateTime(Date date) {

		XMLGregorianCalendar xmlGregcal = null;
		try {
			GregorianCalendar gregCal = new GregorianCalendar();
			gregCal.setTime(date);
			xmlGregcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					gregCal);
		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage(), e);
		}
		return xmlGregcal;
	}

	public static XMLGregorianCalendar getDateTime(String dateStr, String time) {
		XMLGregorianCalendar xmlGregcal = null;
		try {
			//time = "600";
			String[] date = null;
			if (null != dateStr) {
				date = dateStr.split("-");
			}
			String hrs = "";
			String min = "";
			if (null != time) {
				if (time.length() > 0) {
					char[] ch = time.toCharArray();
					if (time.length() == 3) {
						hrs = "0" + Character.toString(ch[0]);
						min = Character.toString(ch[1])
								+ Character.toString(ch[2]);
					}
					if (time.length() == 4) {
						hrs = Character.toString(ch[0])
								+ Character.toString(ch[1]);
						min = Character.toString(ch[2])
								+ Character.toString(ch[3]);
					}
				}
			}
			GregorianCalendar gregCal = new GregorianCalendar();
			gregCal.set(Integer.parseInt(date[0]),
					Integer.parseInt(date[1]) - 01, Integer.parseInt(date[2]),
					Integer.parseInt(hrs), Integer.parseInt(min));
			xmlGregcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					gregCal);
		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage(), e);
		}
		return xmlGregcal;
	}

	public static Map<String, List<RefillPrescriptionVO>> sortDescOrderHistoryMap(
			Map<String, List<RefillPrescriptionVO>> model, String strLocale)
			throws ParseException {
		SimpleDateFormat sdfCustom = null;
		if (strLocale.equals(ERefillConstants.STR_FRENCH_LOCALE)) {
			sdfCustom = new SimpleDateFormat(
					ERefillConstants.DATE_FORMAT_ORDER_HIST_FR,
					getLocaleFromString(strLocale));
		} else {
			sdfCustom = new SimpleDateFormat(
					ERefillConstants.DATE_FORMAT_ORDER_HIST,
					getLocaleFromString(strLocale));
		}
		List<Date> lstKeyDate = new ArrayList<Date>();
		Map<String, List<RefillPrescriptionVO>> retMapVal = new LinkedHashMap<String, List<RefillPrescriptionVO>>();
		if (null != model && !model.isEmpty()) {
			Set<String> keySet = model.keySet();
			for (String key : keySet) {
				if (null != key) {
					Date dtKey = sdfCustom.parse(key);
					lstKeyDate.add(dtKey);
				}
			}

			Collections.sort(lstKeyDate);
			Collections.reverse(lstKeyDate);

			for (int i = 0; i < lstKeyDate.size(); i++) {
				retMapVal.put(sdfCustom.format(lstKeyDate.get(i)),
						model.get(sdfCustom.format(lstKeyDate.get(i))));
			}
		}
		return retMapVal;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JAXBElement prepareJAXBElement(final String qname,
			final String localPart, Class declaredType, Object value) {
		return new JAXBElement(new QName(qname, localPart), declaredType, value);
	}

	public static String formatStringInISO885915(String strInpVal) {
		String strRetVal = null;
		if (!isStringNullOrEmpty(strInpVal)) {
			byte[] byteData;
			try {
				byteData = strInpVal.getBytes("ISO-8859-15");
				strRetVal = new String(byteData, "UTF-8");
			} catch (UnsupportedEncodingException encodExe) {
				encodExe.printStackTrace();
			}
		}
		return strRetVal;
	}

	public static String prepareURL(String appContext, String pageUrl, 
			String language, final String... queryParams) {

		StringBuffer url = new StringBuffer();
		
		if (null != pageUrl) {
			if (pageUrl.contains(".html"))
				pageUrl = pageUrl.replace(".html", "");
			log.info("pageUrl is not null" + pageUrl);
			url.append(appContext).append("/").append(language)
					.append(pageUrl).append("/").append(pageUrl);
		} else {
			log.info("pageUrl is  null" + pageUrl);
			url.append(appContext).append("/").append(language);
		}

		if (null != queryParams) {
			int i = 0;
			for (String queryParam : queryParams) {
				if (i == 0) {
					url.append("?");
				} else {
					url.append("&");
				}
				url.append(queryParam);
				i++;
			}
		}

		log.info("redirect Url" + url.toString());
		return url.toString();

	}

	public static XMLGregorianCalendar currentDatePlusOne(
			XMLGregorianCalendar date) {

		Calendar c = Calendar.getInstance();
		XMLGregorianCalendar xmlGregcal = null;
		c.setTime(date.toGregorianCalendar().getTime()); // today date.
		c.add(Calendar.DATE, 1); // Adding 1 day

		GregorianCalendar gregCal = new GregorianCalendar();
		gregCal.setTime(c.getTime());
		try {
			xmlGregcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					gregCal);
		} catch (DatatypeConfigurationException e) {
			log.error("Error: " + e);
		}
		return xmlGregcal;
	}

	/**
	 * getFormattedDate
	 * 
	 * @param cal
	 * @param strLocale
	 * @return
	 */
	public static String getFormattedDate(XMLGregorianCalendar cal,
			String strLocale) {

		log.info(">>>>> getForrmattedDate >>>>>>>>");
		try {
			SimpleDateFormat dateformat = null;
			if (null != strLocale) {
				log.info("locale is not null >>>> " + strLocale);
				if (strLocale.equals(ERefillConstants.STR_FRENCH_LOCALE)) {
					dateformat = new SimpleDateFormat(
							ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR,
							getLocaleFromString(strLocale));
				} else {
					dateformat = new SimpleDateFormat(
							ERefillConstants.DATE_FORMAT_PRESCRIPTION,
							getLocaleFromString(strLocale));
				}
			} else {
				log.info("locale is  null >>>> default using english locale >>>");
				dateformat = new SimpleDateFormat(
						ERefillConstants.DATE_FORMAT_PRESCRIPTION,
						getLocaleFromString(strLocale));
			}
			return dateformat.format(cal.toGregorianCalendar().getTime());
		} catch (Exception exc) {
			log.info(">>>> exception while parsing the date >>> "
					+ exc.getMessage());
			log.error(">>>> exception while parsing the date >>> "
					+ exc.getMessage());
			if (log.isDebugEnabled()) {
				log.debug(">>>> exception while parsing the date >>> "
						+ exc.getMessage());
			}
			return "";
		}
	}

	/**
	 * getFormattedDate
	 * 
	 * @param cal
	 * @param dateformat
	 * @return
	 */
	public static String getFormattedDate(XMLGregorianCalendar cal,
			SimpleDateFormat dateformat) {

		log.info(">>>>> getForrmattedDate >>>>>>>>");
		try {
			return dateformat.format(cal.toGregorianCalendar().getTime());
		} catch (Exception exc) {
			log.info(">>>> exception while parsing the date >>> {}"
					+ exc.getMessage());
			log.error(">>>> exception while parsing the date >>> {}"
					+ exc.getMessage());
			if (log.isDebugEnabled()) {
				log.debug(">>>> exception while parsing the date >>> {}"
						+ exc.getMessage());
			}
			return "";
		}
	}

	/**
	 * createPrescInfoString
	 * 
	 * @param prescBO
	 * @return
	 */
	public static String createPrescInfoString(PrescriptionsBO prescBO) {

		String strRetVal = null;
		StringBuffer strBuff = new StringBuffer();
		strBuff.append(prescBO.getPrescOID());
		strBuff.append(ERefillConstants.SPLIT_CHAR);
		strBuff.append(prescBO.getName());
		strBuff.append(ERefillConstants.SPLIT_CHAR);
		strBuff.append(prescBO.getGenericName());
		strBuff.append(ERefillConstants.SPLIT_CHAR);
		strBuff.append(prescBO.getStrength());
		strBuff.append(ERefillConstants.SPLIT_CHAR);
		strBuff.append(prescBO.getRxNumber());
		strBuff.append(ERefillConstants.SPLIT_CHAR);
		strBuff.append(prescBO.getDIN());
		strRetVal = strBuff.toString();
		return strRetVal;
	}

	/**
	 * populateRefillReqView
	 * 
	 * @param prescInfo
	 * @return
	 */
	public static PrescDetailsView populateRefillReqView(String[] prescInfo) {
		PrescDetailsView retValueObj = null;
		if (null != prescInfo && prescInfo.length != 0) {
			retValueObj = new PrescDetailsView();
			retValueObj.setOid(prescInfo[0]);
			retValueObj.setName(prescInfo[1]);
			retValueObj.setGenericName(prescInfo[2]);
			retValueObj.setStrength(prescInfo[3]);
			retValueObj.setRxNumber(prescInfo[4]);
			retValueObj.setDin(prescInfo[5]);
		}
		return retValueObj;
	}

	/**
	 * normalizeString
	 * 
	 * @param ipString
	 * @return
	 */
	public static String normalizeString(String ipString) {
		String strRetVal = null;
		if (null != ipString) {
			String nfdNormalizedString = Normalizer.normalize(ipString,
					Normalizer.Form.NFD);
			Pattern pattern = Pattern
					.compile("\\p{InCombiningDiacriticalMarks}+");
			strRetVal = pattern.matcher(nfdNormalizedString).replaceAll("");
		}
		return strRetVal;
	}

	/**
	 * getETAMessage
	 * 
	 * @param strKey
	 * @return
	 */
	public static String getETAMessage(String strKey) {
		String strRetVal = null;
		for (RestrictionTypes c : RestrictionTypes.values()) {
			if (c.toString().equals(strKey)) {
				strRetVal = c.value;
				break;
			}
		}
		return strRetVal;
	}

	/**
	 * getFrenchDate
	 * 
	 * @param strDate
	 * @param strFormat
	 * @return
	 * @throws ParseException
	 */
	public static String getFrenchDate(String strDate, String strFormat)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		Date dt = sdf.parse(strDate);
		SimpleDateFormat frenchSDF = new SimpleDateFormat(strFormat,
				Locale.CANADA_FRENCH);
		String strRetVal = frenchSDF.format(dt);
		return strRetVal;
	}

	/**
	 * getNextDate
	 * 
	 * @param expectedEvents
	 * @return
	 */
	public static XMLGregorianCalendar getNextDate(List<ExpectedEvent> expectedEvents) {
		List<XMLGregorianCalendar> dateList = new ArrayList<XMLGregorianCalendar>();
		for (ExpectedEvent e : expectedEvents) {
			dateList.add(e.getDate());
		}
		XMLGregorianCalendar nextDate = CommonUtils.getDateTime(new Date());
		XMLGregorianCalendar currentDate = nextDate;
		boolean flag = false;
		for (XMLGregorianCalendar d : dateList) {
			if (flag) {
				if (d.compare(nextDate) == DatatypeConstants.LESSER
						&& d.compare(currentDate) == DatatypeConstants.GREATER) {
					nextDate = d;
				}
			} else {
				if (d.compare(nextDate) == DatatypeConstants.GREATER
						|| d.compare(nextDate) == DatatypeConstants.EQUAL) {
					nextDate = d;
					flag = true;
				}
			}
		}
		if (flag) {
			return nextDate;
		}
		return null;
	}

	public static XMLGregorianCalendar getRxDateDaysSupply(String rxDate, String daysSupply) {
		if(null == rxDate || null == daysSupply){
			return getDateTime(new Date());
		} else if("0".equals(rxDate)) {
			return getDateTime(new Date());
		}
		StringBuilder sb = new StringBuilder(rxDate);
		sb.insert(4, '-').insert(7, '-');
		XMLGregorianCalendar formattedDate = getFormattedRxDate(sb.toString());
		formattedDate = addSupplyDays(formattedDate, daysSupply);
		
		return formattedDate;
	}
	
	private static XMLGregorianCalendar getFormattedRxDate(String string) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(string);
		} catch (ParseException e1) {
			return getDateTime(new Date());
		}
		XMLGregorianCalendar xmlGregcal = null;
		try {
			GregorianCalendar gregCal = new GregorianCalendar();
			gregCal.setTime(date);
			xmlGregcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					gregCal);
		} catch (DatatypeConfigurationException e) {
			return getDateTime(new Date());
		}
		return xmlGregcal;
	}
	
	private static XMLGregorianCalendar addSupplyDays(XMLGregorianCalendar rxDate, String supplyDays) {
		Calendar c = Calendar.getInstance();
		XMLGregorianCalendar xmlGregcal = null;
		c.setTime(rxDate.toGregorianCalendar().getTime()); // today date.
		c.add(Calendar.DATE, Integer.parseInt(supplyDays)); // Adding suply days

		GregorianCalendar gregCal = new GregorianCalendar();
		gregCal.setTime(c.getTime());
		try {
			xmlGregcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregCal);
		} catch (DatatypeConfigurationException e) {
			return getDateTime(new Date());
		}
		return xmlGregcal;
	}
	
	public static int getDaysDiff(Date date1,Date date2){
		
		 final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
		 int diffInDays = (int) ((date1.getTime() - date2.getTime())/ DAY_IN_MILLIS );
		 //log.info(">>>>> Difference in Days >>> {}"+diffInDays);
	     return diffInDays;
	     
	}
	
	public static String getStoreLogoUrl(HttpServletRequest request,
			String locale) {
		HttpSession session = request.getSession(false);
		UserSession userSession = null;
		PharmacyVO pharmaVO = null;
		log.debug("checking pharma ");
		String logoUrl = "/resources/images/global/centre_sante.png";
		if (session != null) {
			Object us = session.getAttribute(ERefillConstants.MAP_KEY_USER);
			if (us != null) {
				userSession = (UserSession) us;
				String patientOid = null;
				PharmaDeptVO pharmaDeptVO = null;

				if (StringUtils.isNotBlank(userSession.getOid())
						&& !userSession.getOid().equalsIgnoreCase(
								StringUtils.trimToEmpty(userSession
										.getSelectedPatientOid()))) {
					patientOid = userSession.getSelectedPatientOid();
				}
				Map<String, PharmaDeptVO> pharmaDeptVOs = userSession
						.getPharmaDeptVOs();
				if (pharmaDeptVOs != null && !pharmaDeptVOs.isEmpty()) {
					if (StringUtils.isBlank(patientOid)) {
						pharmaDeptVO = pharmaDeptVOs.get("DEFAULT");
					} else {
						pharmaDeptVO = pharmaDeptVOs.get(patientOid);
					}
				}
				if (pharmaDeptVO != null) {
					pharmaVO = pharmaDeptVO.getPharmaVO();
					String selectedProvince = pharmaVO.getProvince();
					if (selectedProvince == null) {
						selectedProvince = "QC";
					}
					log.debug( "selected province "+ selectedProvince);
					if (selectedProvince.equalsIgnoreCase("QC")) {
						logoUrl = "/resources/images/global/centre_sante.png";
					} else {
						if (locale != null) {
							log.debug("Locale " + locale);
							if (locale.equalsIgnoreCase("en_CA")) {
								log.debug( "fetching english logo "+ pharmaVO.getPharmacyLogo());
								logoUrl = pharmaVO.getPharmacyLogo();
							} else if (locale.equalsIgnoreCase("fr_CA")) {
								log.debug( "fetching french logo "+ pharmaVO.getPharmacyLogoFR());
								logoUrl = pharmaVO.getPharmacyLogoFR();
							} else {
								logoUrl = pharmaVO.getPharmacyLogo();
								log.debug( "Locale not matched. So displaying en logo  "+ pharmaVO.getPharmacyLogo());
							}
						} else {
							log.debug( "Locale is null. So displaying en logo  "+ pharmaVO.getPharmacyLogo());
							logoUrl = pharmaVO.getPharmacyLogo();
						}
					}
				}
				log.debug( "URL for logo to be displayed: "+ logoUrl);
			}
		}
		return logoUrl;
	}
}



