package com.lcl.erefill.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.lcl.erefill.core.common.entity.PrescriptionsBO;
import com.lcl.erefill.core.config.ERefillConfigService;
import com.lcl.erefill.core.constants.ERefillConstants;

public class ServiceUtils {
	
	private ServiceUtils(){
		//Do nothing
	}
	
	private enum PrescriptionStatus {
		Pending, Received, Accepted, Declined, AcceptedWithoutInfo, None, ReceivedETARequired;
	}

	public static List<PrescriptionsBO> filterValidPrescriptions(List<PrescriptionsBO> lstToProcess, String dateFilter) throws ParseException {
		List<PrescriptionsBO> retLstPresc = null;
		SimpleDateFormat sdf = null;
		if(null != lstToProcess && lstToProcess.size() != 0) {
			retLstPresc = new ArrayList<PrescriptionsBO>();
			retLstPresc.addAll(lstToProcess);
			if(!dateFilter.equalsIgnoreCase(ERefillConstants.ALL_DAYS)) {
				Date[] arrFromToDate = CommonUtils.getFromAndToDate(dateFilter);
				Date fromDate = arrFromToDate[0];
				Date toDate = arrFromToDate[1];
				for (int i = 0; i < retLstPresc.size(); i++) {
					if (null != retLstPresc.get(i)) {
						if(retLstPresc.get(i).getLocale().equals(Locale.CANADA_FRENCH)) {
							sdf = new SimpleDateFormat(ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR, retLstPresc.get(i).getLocale());
						} else {
							sdf = new SimpleDateFormat(ERefillConstants.DATE_FORMAT_PRESCRIPTION, retLstPresc.get(i).getLocale());
						}
						Date lastFilledDate = sdf.parse(retLstPresc.get(i).getLastFilledDate().toString());
						boolean flagDate = CommonUtils.isValidDate(lastFilledDate, fromDate, toDate);
						if (!flagDate) {
							retLstPresc.remove(i);
							i--;
						}
					}
				}
			}
		}
		return retLstPresc;
	}
	
	public static List<PrescriptionsBO> filterValidPrescriptions(List<PrescriptionsBO> lstToProcess, Date fromDate, Date toDate) throws ParseException {
		List<PrescriptionsBO> retLstPresc = null;
		SimpleDateFormat sdf = null;
		if(null != lstToProcess && lstToProcess.size() != 0) {
			retLstPresc = new ArrayList<PrescriptionsBO>();
			retLstPresc.addAll(lstToProcess);
			for (int i = 0; i < retLstPresc.size(); i++) {
				if (null != retLstPresc.get(i)) {
					if(retLstPresc.get(i).getLocale().equals(Locale.CANADA_FRENCH)) {
						sdf = new SimpleDateFormat(ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR, retLstPresc.get(i).getLocale());
					} else {
						sdf = new SimpleDateFormat(ERefillConstants.DATE_FORMAT_PRESCRIPTION, retLstPresc.get(i).getLocale());
					}
					Date lastFilledDate = sdf.parse(retLstPresc.get(i).getLastFilledDate().toString());
					boolean flagDate = CommonUtils.isValidDate(lastFilledDate, fromDate, toDate);
					if (!flagDate) {
						retLstPresc.remove(i);
						i--;
					}
				}
			}
		}
		return retLstPresc;
	}
	
	public static List<PrescriptionsBO> getSortedPrescriptions(List<PrescriptionsBO> listPresc, String sortValue, int pageNum, boolean sortOrder) throws ParseException {

		/****************** Sort Array Base on sort parameter ***************/
		Comparator<PrescriptionsBO> compField = null;
		if (sortValue.equalsIgnoreCase(ERefillConstants.NEXT_FILL_DATE)) {
			//compField = PrescriptionsBO.nextFilledComp;
			if(listPresc.get(0).getLocale().equals(Locale.CANADA_FRENCH)) {
				compField = PrescriptionsBO.getNextFilledComp(ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR, listPresc.get(0).getLocale());
			} else {
				compField = PrescriptionsBO.getNextFilledComp(ERefillConstants.DATE_FORMAT_PRESCRIPTION, listPresc.get(0).getLocale());
			}
		} else if (sortValue.equalsIgnoreCase(ERefillConstants.MEDICATION_NAME)) {
			compField = PrescriptionsBO.medNameComp;
			sortOrder = ERefillConstants.ORDER_ASCENDING;
		} else {
			//compField = PrescriptionsBO.lastFilledComp;
			if(listPresc.get(0).getLocale().equals(Locale.CANADA_FRENCH)) {
				compField = PrescriptionsBO.getLastFilledComp(ERefillConstants.DATE_FORMAT_PRESCRIPTION_FR, listPresc.get(0).getLocale());
			} else {
				compField = PrescriptionsBO.getLastFilledComp(ERefillConstants.DATE_FORMAT_PRESCRIPTION, listPresc.get(0).getLocale());
			}
		}
		CommonUtils.sortEntities(listPresc, compField, sortOrder);
		/*************************** Sorting Done ***************************/

		/************************** Pagination ****************************/
		String pageSize = ERefillConfigService.PAGE_LENGTH_MYPRESCRIPTION;
		List<PrescriptionsBO> childList = null;
		childList=listPresc;
		if(null != pageSize){
			childList = pagination(listPresc, Integer.parseInt(pageSize), pageNum);	
		}
		/*********************** Pagination Ends **************************/
		return childList;
	}

	public static List<PrescriptionsBO> pagination(List<PrescriptionsBO> listToPage, int pageSize, int pageNum) {
		List<PrescriptionsBO> retChildList = null;
		if(null != listToPage) {
			int numOfPages = CommonUtils.getNumberOfPages(listToPage.size(), pageSize);
			if (pageNum < numOfPages) {
				retChildList = listToPage.subList(((pageNum - 1) * pageSize), (pageNum * pageSize));
			} else if (pageNum == numOfPages) {
				retChildList = listToPage.subList(((pageNum - 1) * pageSize), listToPage.size());
			} else {
				retChildList = listToPage;
			}
		}
		return retChildList;
	}
	
	
	public static List<String> getPagination(List<String> refillLst,int pageSize,int pageNum){
		List<String> retChildList = null;
		if(null != refillLst) {
			int numOfPages = CommonUtils.getNumberOfPages(refillLst.size(), pageSize);
			if (pageNum < numOfPages) {
				retChildList = refillLst.subList(((pageNum - 1) * pageSize), (pageNum * pageSize));
			} else if (pageNum == numOfPages) {
				retChildList = refillLst.subList(((pageNum - 1) * pageSize), refillLst.size());
			} else {
				retChildList = refillLst;
			}
		}
		return retChildList;
	}
	
	public static boolean isPrescriptionDisable(String prescStatus) {
		boolean blnRetVal = false;
		if(null != prescStatus) {
			if(PrescriptionStatus.Received.name().equals(prescStatus) || PrescriptionStatus.Pending.name().equals(prescStatus)) {
				blnRetVal = true;
			}
		}
		return blnRetVal;
	}
}