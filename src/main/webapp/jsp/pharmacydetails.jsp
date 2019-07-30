<%@ page
	import="java.util.Locale,
                java.util.*,
                java.util.ResourceBundle,
                com.lcl.erefill.core.constants.ERefillConstants,
                com.lcl.erefill.core.vo.PharmaDeptVO,
                com.lcl.erefill.core.vo.PharmacyVO,
                com.lcl.erefill.core.vo.PharmacyOperatingHours,
                com.lcl.erefill.core.utils.CommonUtils"%>
<html>

<body>

	<%

PharmaDeptVO pharmaStores = (PharmaDeptVO) request.getAttribute("pharmaStores");
%>
	Pharmacy Page
	<br />
	<%=pharmaStores.getPharmaVO().getPharmacyTitle() %>

</body>
</html>