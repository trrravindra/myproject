<%@ include file="../global.jsp"%>
<%@ page session="false"%>
<%@ page import="com.lcl.erefill.core.utils.CommonUtils"%>

<%
    String logoUrl="/resources/images/global/centre_sante.png";
    Object r = request.getAttribute("javax.servlet.forward.request_uri");
 	String url = null;
    if( r !=null ) {
    	url= (String)r;
    	if (url!= null && url.contains("prescription")
    			|| url.contains("orderhistory")
    			|| url.contains("mymedicationrecord")
    			|| url.contains("refillrequest")) {
     		logoUrl = CommonUtils.getStoreLogoUrl( request, locale );
    	}
    }






  %>

<!-- Banner / Header Component -->
<div class="banner">
	<%-- <img class="logo print" alt=" " title="" src="<c:url value='/resources/images/global/centre_sante.png'/>"> --%>

	<img class="logo print" alt="centre sante logo image"
		src="<c:url value= "<%=logoUrl %>"/>">

	<!--<a href='en_CA.html' target="_parent"> -->
	<c:choose>
		<c:when test="${'fr_CA' eq locale}">

			<img class="logo" alt="Your Health Matters Here logo image"
				src="<c:url value='/resources/images/erefill/LCL_eRefill_YHMHheader_FR2.jpg'/>"
				alt=" ">

		</c:when>
		<c:otherwise>

			<img class="logo" alt="Your Health Matters Here logo image"
				src="<c:url value='/resources/images/erefill/Header_Image.png'/>"
				alt=" ">

		</c:otherwise>
	</c:choose>

	<div class="locale">
		<c:if test="${urlInEnglish ne null && urlInFrench ne null}">
			<c:choose>
				<c:when test="${locale eq 'en_CA'}">
					<span class="active"><spring:message code="english.label" />
					</span> | <a class="no-click" href="${urlInFrench}" title="French"> <spring:message
							code="french.label" /></a>
				</c:when>
				<c:otherwise>
					<a class="no-click" href="${urlInEnglish}" title="English"><spring:message
							code="english.label" /> </a> | <span class="active"> <spring:message
							code="french.label" /></span>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>

	<input type="hidden" id="loadingMessage"
		value="<spring:message code="loading.label" />" />

	<!--<div class="locale"> <a class="active"> English</a> | <a class="no-click" href="welcome.html"> Fran&ccedil;ais</a></div> -->
	<div id="showOverlayLoaderImage" style="display: none;">
		<div class='loader-image' style='z-index: 2147483647; color: #2792C3;'>
			<div style='font-size: 18px; color: #000;' id="loadingMessage">
				<spring:message code="loading.label" />
			</div>
			<div style='margin-left: 20px; margin-top: 5px;'>
				<img src="<c:url value='/resources/images/global/ajax-loader.gif'/>"
					style='width: 32px; height: 32px;' alt="loading Image" />
			</div>
		</div>
		<div class='overlay-screen loader-screen'
			style='z-index: 9999999; top: 0px;'>
			<div></div>
		</div>
	</div>
</div>
<!-- Banner / Header Component ends -->