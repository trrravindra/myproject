<%@ include file="global.jsp"%>
<%@ page session="false"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="${locale}" class="no-js lt-ie10 lt-ie9 lt-ie8 lt-ie7 ie" > <![endif]-->
<!--[if IE 7]>         <html lang="${locale}" class="no-js lt-ie10 lt-ie9 lt-ie8 ie" > <![endif]-->
<!--[if IE 8]>         <html lang="${locale}" class="no-js lt-ie10 lt-ie9 ie" > <![endif]-->
<!--[if IE 9]>         <html lang="${locale}" class="no-js lt-ie10 ie" > <![endif]-->
<!--[if gt IE 9]><!-->
<html lang="${locale}" class="no-js ie">
<!--<![endif]-->


<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet"
	href="<c:url value='/resources/styles/pages/erefill/global.css'/>">
<script src="<c:url value='/resources/js/vendor/modernizr.js'/>"></script>
<script id="require-js"
	data-main="${pageContext.request.contextPath}/resources/js/erefill-home"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
<title><c:if test="${not empty title}">
		<spring:message code="${title}" />
	</c:if></title>

</head>
<body
	data-page-analytics='{"pageCategory" : "","pageName" : "${pageName}","pageTemplate" : "","brand" : "","campaign" : ""}'>

	<c:set var="selectedProvince"
		value='${cookie["erefill-selected-province"].value}' scope="request" />
	<!-- MAIN -->

	<section class="container">
		<!-- Parent Div -->
		<div class="page page-home">
			<tiles:insertAttribute name="header" />

			<!-- Hero Div -->
			<%
			 		Enumeration<String> errorEnum = request.getParameterNames();//("signinerror");
                   	String genericError= "";
                   	boolean isError = false;
                   	while( errorEnum.hasMoreElements() ) {
                   		genericError = errorEnum.nextElement();
                   		if(genericError.indexOf("error")!=-1){
                   			genericError = request.getParameter(genericError);
                   			isError=true;	
                   		}else{
                   			genericError="";
                   		}
                   		continue;
                   	}
			 	 %>
			<% if(isError) { %>
			<div class="hero no-shadow error">
				<% } else {  %>
				<div class="hero no-shadow">
					<% } %>
					<tiles:insertAttribute name="mycarousel" />
					<tiles:insertAttribute name="mylogin_sidebar" />

				</div>
				<!-- Hero Div Ends -->
				<c:if test="${selectedProvince ne null && selectedProvince == 'QC'}">
					<tiles:insertAttribute name="reservedSection" />
				</c:if>

				<c:choose>
					<c:when
						test="${selectedProvince ne null && selectedProvince == 'QC'}">
						<tiles:insertAttribute name="my2columncard_2_QC" />
					</c:when>
					<c:otherwise>
						<tiles:insertAttribute name="my2columncard_2_ROC" />
					</c:otherwise>
				</c:choose>
				<!-- card Component with 1 column Ends -->
			</div>
			<!-- Parent Div Ends -->
	</section>

	<!-- FOOTER -->
	<tiles:insertAttribute name="footer" />
	<!-- FOOTER Ends -->

	<!-- Google Tag Manager -->
	<script>
    window['dataLayer'] = window['dataLayer'] || [];
    dataLayer.push( { 'visitor-status' : 'ANONYMOUS' } );
    dataLayer.push( { 'language' : "${locale}" } );
    dataLayer.push( { 'preferred-province' : '' } );
    dataLayer.push( { 'page-category' : 'null' } );
    dataLayer.push( { 'brand' : '' } );
    dataLayer.push({'page-name': "${locale}"});
    var dataForGTM = { 'gtrack': false };
     try {
        // UTM info from hash
        if( location.hash && location.hash !== '#' ) {
            // Make sure there's a utm_source
            if( location.hash.indexOf('utm_source') > -1 ) {

                // Since we found a utm_source gtrack is true
                dataForGTM['gtrack'] = true;

                    // Split at ampersand to get keys and values
                var kvPairs = location.hash.replace('#','').split('&'),
                    i = 0, l = kvPairs.length;

                // Iterate through each kvPair
                for( i; i < l; i++ ) {
                    // Get this index
                    var kv = kvPairs[i];
                    // If there's an equals sign in the current index 
                    if( kv.indexOf('=') > -1 ) {
                            // Cache index of the equals sign
                        var indexOfEquals = kv.indexOf('='),
                            // The key
                            k = kv.slice( 0, indexOfEquals ),
                            // The value
                            v = kv.slice( indexOfEquals + 1, kv.length ) || "";

                        // Switch at the key and add the value to the corresponding GTM key
                        switch( k ) {
                            case 'utm_source' :
                                dataForGTM['gsource'] = v;
                            break;
                            case 'utm_medium' :
                                dataForGTM['gmedium'] = v;
                            break;
                            case 'utm_term' :
                                dataForGTM['gterm'] = v;
                            break;
                            case 'utm_content' :
                                dataForGTM['gcontent'] = v;
                            break;
                            case 'utm_campaign' :
                                dataForGTM['gname'] = v;
                            break;
                            default:
                                // do nothing
                            break;
                        }
                    }
                }

                // Remove the hash
                location.hash = "";
            }
        }
    } catch ( err ) {
        // Do nothing
    }

    try {
        dataLayer.push( dataForGTM );
    } catch( err ) {
        // Do nothing
    }
</script>
	<noscript>
		<iframe src="//www.googletagmanager.com/ns.html?id=GTM-PG7XC5"
			height="0" width="0" style="display: none; visibility: hidden"></iframe>
	</noscript>
	<script>
    (function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
        new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
        j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
        '//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
    })(window,document,'script','dataLayer','GTM-PG7XC5');
</script>
	<!-- End Google Tag Manager -->

</body>
</html>