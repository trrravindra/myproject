<%@ include file="../global.jsp"%>

<%@ page session="false"%>
<!-- card Component with 3 columns -->
<div class="card-layout col3" style="margin-top: 10px;">
	<!-- Column 01 -->
	<div class="card article">
		<div class="header">
			<div class="inner">
				<h3 class="title">
					<spring:message code="home.three.card.heading.1" />
				</h3>
			</div>
		</div>
		<div class="content">
			<div class="inner">
				<img src="<c:url value='/resources/images/erefill/FPO/card-1.jpg'/>"
					title="" alt="Hero image">
				<p>
					<spring:message code="home.three.card.message.1" />
			</div>
		</div>
	</div>
	<!-- Column 01 Ends -->

	<!-- Column 02 -->
	<div class="card article">
		<div class="header">
			<div class="inner">
				<h3 class="title">
					<spring:message code="home.three.card.heading.2" />
				</h3>
			</div>
		</div>
		<div class="content">
			<div class="inner">
				<img src="<c:url value='/resources/images/erefill/FPO/card-3.jpg'/>"
					title="" alt="Hero image">
				<p>
					<spring:message code="home.three.card.message.2" />
			</div>
		</div>
	</div>
	<!-- Column 02 Ends-->

	<!-- Column 03 -->
	<div class="card article last">
		<div class="header">
			<div class="inner">
				<h3 class="title">
					<spring:message code="home.three.card.heading.3" />
				</h3>
			</div>
		</div>
		<div class="content">
			<div class="inner">
				<img
					src="<c:url value='/resources/images/erefill/FPO/food_alergy.jpg'/>"
					title="" alt="Hero image">
				<p>
					<spring:message code="home.three.card.message.3" />
			</div>
		</div>
	</div>
	<!-- Column 03 Ends-->
</div>
<!-- card Component with 3 columns Ends -->