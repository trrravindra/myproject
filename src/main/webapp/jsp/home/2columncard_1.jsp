<%@ include file="../global.jsp"%>

<%@ page session="false"%>

<!-- Column 01-->
<div class="card blue-menu">
	<div class="front">
		<div class="header">
			<div class="inner">
				<h3 class="title">
					<spring:message code="home.two.card.1.heading" />
				</h3>
				<div class="logo">
					<img
						src="<c:url value='/resources/images/erefill/msbm_header_logo.png'/>"
						alt="msbm Header Logo Image">
				</div>
			</div>
		</div>
		<div class="content">
			<div class="inner">
				<div class="right">
					<img
						src="<c:url value='/resources/images/erefill/FPO/card-bluemenu-product-1.jpg'/>"
						alt="Product Image">
				</div>
				<p
					style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;">
					<spring:message code="home.two.card.1.message" />
					<br>
				</p>
			</div>
		</div>
		<div class="footer">
			<div class="inner">
				<a class="button-erefill blue shadow"
					href="http://www.pc.ca/en_CA/familypage/PCBlueMenuPage.html"
					target="_blank"><spring:message
						code="home.two.card.1.button.label" /></a>
			</div>
		</div>
	</div>
</div>
<!-- Column 01 Ends-->