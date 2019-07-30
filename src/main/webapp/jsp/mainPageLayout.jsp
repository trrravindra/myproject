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

<title><c:if test="${not empty title}">
		<spring:message code="${title}" />
	</c:if></title>
<meta name="description" content="" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="format-detection" content="telephone=yes" />
<meta http-equiv="cleartype" content="on" />
<meta name="mobileoptimized" content="1024" />
<meta name="viewport" content="width=1024" />

<link rel="stylesheet"
	href="<c:url value='/resources/styles/pages/erefill/global.css'/>" />

<script src="<c:url value='/resources/js/vendor/modernizr.js'/>"></script>

</head>

<body class=""
	data-page-analytics='{"pageCategory" : "","pageName" : "${pageName}","pageTemplate" : "","brand" : "","campaign" : ""}'>

	<section class="container">



		<c:choose>
			<c:when
				test="${'myprescriptions' eq pageName or 'caregiverMyPrescription' eq pageName}">
				<section
					class="page page-details sidebar-left-layout page-prescriptions">
					<c:set var="analyticsPageName" value="myprescriptions"></c:set>
			</c:when>
			<c:when
				test="${'mymedicationrecord' eq pageName or 'caregiverMedicationRecord' eq pageName}">
				<section
					class="page page-details sidebar-left-layout page-medication-record">
					<c:set var="analyticsPageName" value="mymedicationrecord"></c:set>
			</c:when>
			<c:when
				test="${'myorderhistory' eq pageName or 'caregiverOrderHistory' eq pageName}">
				<section
					class="page page-details sidebar-left-layout page-order-history">
					<c:set var="analyticsPageName" value="myorderhistory"></c:set>
			</c:when>
			<c:when
				test="${'myaccount' eq pageName or 'caregiverAccount' eq pageName }">
				<section class="page sidebar-left-layout">
					<c:set var="analyticsPageName" value="myaccount"></c:set>
			</c:when>
			<c:when test="${'mymanagedaccount' eq pageName}">
				<section class="page sidebar-left-layout page-managed-accounts">
					<c:set var="analyticsPageName" value="mymanagedaccount"></c:set>
			</c:when>
			<c:when test="${'help' eq pageName or 'caregiverHelp' eq pageName}">
				<section class="page sidebar-left-layout">
					<c:set var="analyticsPageName" value="help"></c:set>
			</c:when>
			<c:otherwise>
				<section
					class="page page-details page-details-my-account sidebar-left-layout page-refill-request page-managed-accounts">
					<c:set var="analyticsPageName" value="${pageName}"></c:set>
			</c:otherwise>
		</c:choose>

		<tiles:insertAttribute name="header" />

		<tiles:insertAttribute ignore="true" name="notification" />

		<div class="sidebar">
			<tiles:insertAttribute ignore="true" name="navigation" />
		</div>

		<tiles:insertAttribute name="body" />

	</section>
	</section>

	<!-- FOOTER -->
	<tiles:insertAttribute name="footer" />
	<!-- Google Tag Manager -->
	<script>
    window['dataLayer'] = window['dataLayer'] || [];
    dataLayer.push( { 'visitor-status' : 'IDENTIFIED' } );
    dataLayer.push( { 'language' : "${locale}" } );
    dataLayer.push( { 'preferred-province' : '' } );
    dataLayer.push( { 'page-category' : 'null' } );
    dataLayer.push( { 'brand' : '' } );
    dataLayer.push({'page-name': "${analyticsPageName}"});
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
