package com.lcl.erefill.core.utils;

import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lcl.erefill.core.constants.ERefillConstants;

public class HTMLParseLister extends HTMLEditorKit.ParserCallback{
	
	private static final Logger log = LoggerFactory.getLogger(HTMLParseLister.class);

	int titlePos = 0;
	boolean aFlag = false;
	boolean ulFlag = false;
	boolean liFlag = false;
	boolean nobrFlag = false;
	boolean fontFlag = false;
	boolean flgTrim = false;
	String strKey = null;
	StringBuffer strValue = new StringBuffer();
	LinkedHashMap<String, String> details = null;
	
	public HTMLParseLister(LinkedHashMap<String, String> details) {
		this.details = details;
	}

	public void handleText(char[] charData, int pos) {
		
		String strData = null;
		byte[] byteData = Charset.forName(ERefillConstants.ENCODING_UTF8).encode(CharBuffer.wrap(charData)).array();
		try {
			strData = new String(byteData, ERefillConstants.ENCODING_UTF8);
			if(strData.length() != strData.trim().length()) {
				flgTrim = true;
			}
			strData = strData.trim();
		} catch (UnsupportedEncodingException encodExe) {
			log.error("UnsupportedEncodingException exception occured in HTMLParseLister Class", encodExe);
			strData = new String(byteData);
		}
		
		if(aFlag && pos > titlePos) {
			strKey = strData;
			strValue = new StringBuffer();
		}
		
		if(ulFlag && liFlag && pos > titlePos) {
			if(nobrFlag || fontFlag) {
				if(strValue.lastIndexOf(ERefillConstants.DRUG_INFO_SPLIT_STRING) != -1) {
					strValue.delete(strValue.lastIndexOf(ERefillConstants.DRUG_INFO_SPLIT_STRING), strValue.length());
				}
				if(flgTrim) {
					strValue.append(" " + strData);
				} else {
					strValue.append(strData);
				}
			} else {
				strValue.append(strData).append(ERefillConstants.DRUG_INFO_SPLIT_STRING);
			}
		}
		
		details.put(strKey, strValue.toString());
	}

	public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
		if(t.toString().equals("a")) {
			aFlag = true;
			titlePos = pos;
		}
		
		if(t.toString().equals("ul")) {
			ulFlag = true;
		}
		
		if(t.toString().equals("li")) {
			liFlag = true;
		}
		
		if(t.toString().equals("nobr")) {
			nobrFlag = true;
		}
		
		if(t.toString().equals("font")) {
			fontFlag = true;
		}
	}

	public void handleEndTag(HTML.Tag t, int pos) {
		if(t.toString().equals("a")) {
			aFlag = false;
		}
		
		if(t.toString().equals("ul")) {
			ulFlag = false;
		}
		
		if(t.toString().equals("li")) {
			liFlag = false;
		}
		
		if(t.toString().equals("nobr")) {
			nobrFlag = false;
		}
		
		if(t.toString().equals("font")) {
			fontFlag = false;
		}
	}

}
