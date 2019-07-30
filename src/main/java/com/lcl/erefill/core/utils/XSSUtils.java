package com.lcl.erefill.core.utils;

import java.util.regex.Pattern;

import org.apache.cxf.common.util.UrlUtils;
import org.springframework.stereotype.Component;

@Component
public class XSSUtils {

	
	 /**
	  * 
	  */
	private static Pattern[] patterns = new Pattern[] {
	
		// Script fragments
        Pattern.compile("<(.*?)script(.*?)>(.*?)</(.*?)script(.*?)>", Pattern.CASE_INSENSITIVE),
        // src='...'
        Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                | Pattern.DOTALL),
        Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                | Pattern.DOTALL),
        // lonely script tags
        Pattern.compile("</script(.*?)>", Pattern.CASE_INSENSITIVE),
        Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        // eval(...)
        Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        // expression(...)
        Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        // javascript:...
        Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
        // vbscript:...
        Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
        // onload(...)=...
        Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
        Pattern.compile("<(\\s*)(/\\s*)?script(\\s*)>", Pattern.CASE_INSENSITIVE),
        Pattern.compile("%3Cscript%3E", Pattern.CASE_INSENSITIVE),
        Pattern.compile("alert(\\s*)\\(", Pattern.CASE_INSENSITIVE),
        Pattern.compile("alert%28", Pattern.CASE_INSENSITIVE), Pattern.compile("<img", Pattern.CASE_INSENSITIVE),
        Pattern.compile("%3Cimg", Pattern.CASE_INSENSITIVE), Pattern.compile("alert%7D", Pattern.CASE_INSENSITIVE),
        Pattern.compile("alert}", Pattern.CASE_INSENSITIVE),
        Pattern.compile("document(.*)\\.(.*)cookie", Pattern.CASE_INSENSITIVE),
        Pattern.compile("eval(\\s*)\\(", Pattern.CASE_INSENSITIVE),
        Pattern.compile("setTimeout(\\s*)\\(", Pattern.CASE_INSENSITIVE),
        Pattern.compile("setInterval(\\s*)\\(", Pattern.CASE_INSENSITIVE),
        Pattern.compile("execScript(\\s*)\\(", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)javascript(?-i):", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onclick(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)ondblclick(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onmouseover(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onmousedown(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onmouseup(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onmousemove(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onmouseout(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onchange(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onfocus(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onblur(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onkeypress(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onkeyup(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onkeydown(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onload(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onreset(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onselect(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onsubmit(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("(?i)onunload(?-i)", Pattern.CASE_INSENSITIVE),
        Pattern.compile("&#x61;&#x6C;&#x65;&#x72;&#x74;", Pattern.CASE_INSENSITIVE),
     // for pattern "space characters followed by style="background:expression(alert(123))           
        Pattern.compile("\"(\\s*)style=\"(.*):(.*)", Pattern.CASE_INSENSITIVE),
        // for anything with pattern <crappy content>
        
        // for pattern "crappy content"> or <"crap "
        Pattern.compile("\'(.*)>", Pattern.CASE_INSENSITIVE),
        Pattern.compile("\"(.*)>", Pattern.CASE_INSENSITIVE),
        Pattern.compile("<(.*)>", Pattern.CASE_INSENSITIVE),
        Pattern.compile("<\"(.*)", Pattern.CASE_INSENSITIVE)
      
       
       
	};
	
	public static boolean detectXSS(String value) {
		if (value != null) {
			// NOTE: It's highly recommended to use the ESAPI library and
			// uncomment the following line to
			// avoid encoded attacks.
			// value = ESAPI.encoder().canonicalize(value);
			//decode encoded attacks
			value = UrlUtils.urlDecode(value, "UTF-8");

			// Avoid null characters
			value = value.replaceAll("\0", "");			
			boolean match = false;
			// Remove all sections that match a pattern
			for (Pattern scriptPattern : patterns) {
				match = scriptPattern.matcher(value).find();
				if( match ) {
					return match;
				}
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		String value = "Pentester1%27%22%3E%3Ciframe+id%3D1339+src%3Dhttp%3A%2F%2Fdemo.testfire.net%2Fphishing.html%eE";
		//String value= "All'\"><iframe id=963 src=http://demo.testfire.net/phishing.html>";
		//String value = "abc3383838";
		//System.out.println(UrlUtils.urlDecode(value, "UTF-8"));
		
		System.out.println(  detectXSS(value));
	}
	
}
