<%@ include file="../global.jsp"%>

<%@ page session="false"%>

<!-- Image Component -->
<div class="promo">
	<div class="carousel">

		<div class="carousel-slide text-on-left">
			<div class="front">
				<div class="inner">
					<div class="header">
						<h2 class="title">
							<spring:message code="home.carousel.slide1.heading" /><br><br>
						</h2>
					</div>
					<div class="footer">
						<h3 class="subhead">
							<spring:message code="home.carousel.slide1.subheading" />
						</h3>
						<p>
							<c:choose>
								<c:when
									test="${selectedProvince ne null && selectedProvince == 'QC'}">
									<spring:message code="home.carousel.slide1.description.QC" />
								</c:when>
								<c:otherwise>
									<spring:message code="home.carousel.slide1.description.ROC" />
								</c:otherwise>
							</c:choose>
						</p>
						<p>&nbsp;</p>
					</div>
				</div>
			</div>
			<div class="back">
				<img
					src="<c:url value='/resources/images/erefill/FPO/slide-1.jpg'/>"
					title="" alt="Carousel Image">
			</div>
		</div>

	</div>
</div>
<!-- Carousel Component Ends -->