package com.lcl.erefill.core.utils;

import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lcl.erefill.core.constants.ERefillConstants;

public final class DateFormatUtils {

	private static final Logger log = LoggerFactory.getLogger(DateFormatUtils.class);

	public String removeSpacesOperatingHours(String dateWithSpace) {

		log.debug("removeAdditionalSpaces in Pharmacy Operating Hours :: DateFormatUtils");
		String withoutSpace = "";
		String token1 = "", token2 = "", token3 = "", token4 = "", token5 = "";
		int countLoop2 = 1, countLoop1 = 1;
		if (!dateWithSpace.contains(ERefillConstants.DELIMITER_DATEFORMAT)) {
			withoutSpace = dateWithSpace;
		} else {
			StringTokenizer st1 = new StringTokenizer(dateWithSpace, " ");
			while (st1.hasMoreElements()) {
				if (countLoop1 == 1)
					token1 = (String) st1.nextElement();
				else if (countLoop1 == 2)
					token2 = (String) st1.nextElement();
				else if (countLoop1 == 3)
					token3 = (String) st1.nextElement();
				countLoop1++;
			}
			StringTokenizer st2 = new StringTokenizer(token2, "-");
			while (st2.hasMoreElements()) {
				if (countLoop2 == 1)
					token4 = (String) st2.nextElement();
				else if (countLoop2 == 2)
					token5 = (String) st2.nextElement();
				countLoop2++;
			}
			withoutSpace = token1 + token4 + " - " + token5 + token3;
		}

		return withoutSpace;
	}

}
