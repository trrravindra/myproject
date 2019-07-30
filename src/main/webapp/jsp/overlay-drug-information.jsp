<%@ include file="global.jsp"%>


<%@page import="com.lcl.erefill.core.vo.DrugInformation"%>


<div class="overlay-drug-information" role="dialog" tabIndex="0"
	aria-labelledby="overlayTitle" aria-describedby="overlayDesc">

	<a name="CnsProduit0">
		<h4 class="header">
			<c:if test="${not empty drugInfo }">
				<c:if test="${not empty drugInfo.imageURL }">
					<img class="refill-img" alt="Drug Image" src="${drugInfo.imageURL}">
				</c:if>
			</c:if>
			<c:if test="${empty drugInfo }">
				<c:if test="${empty drugInfo.imageURL }">
					<img class="refill-img" alt="No Drug Image"
						src="<c:url value='/resources/images/erefill/DinNoImage.jpg'/>">
				</c:if>
			</c:if>
			<div lang="en-ca" class="title">
				<c:choose>
					<c:when test="${not empty drugHeader}">
								${drugHeader.name}:
						</c:when>
					<c:otherwise>
						<c:if test="${not empty drugHeadName }">
					 			${drugHeadName}:
					 		</c:if>
					</c:otherwise>
				</c:choose>
				<span> <c:choose>
						<c:when test="${not empty drugHeader}">
								- ${drugHeader.genericName}
							</c:when>
					</c:choose> <c:choose>
						<c:when test="${not empty drugHeader}">
									(${drugHeader.strength})
							</c:when>
						<c:otherwise>
							<c:if test="${not empty drugHeadStrength }">(${drugHeadStrength})</c:if>
						</c:otherwise>
					</c:choose>
				</span> <br>
				<spring:message code="medication.drug.overlay.label" />
			</div>
		</h4>
	</a>
	<div class="drug-info-wrap">
		<a name="SizeFont"></a>

		<h4>
			<a name="EnteteNom"></a> <br> <a name="EnteteOrd"></a>
		</h4>
		<hr>

		<c:choose>
			<c:when test="${not empty drugInfo}">

				<c:out value="${drugInfo.completeHtml}" escapeXml="false" />
				<%-- <c:forEach var="details" items="${drugInfo.details}">
					<c:if test="${not empty details.title}">
						<a name="CnsTitre0">
							<h4>
								<span lang="en-ca">${details.title}</span>
							</h4>
						</a>
					</c:if>
					<c:forEach var="desc" items="${details.completeHtml}">
						<c:if test="${not empty desc}">
							<ul>
								<li><span lang="en-ca"><c:out value="${desc}" /></span></li>
							</ul>
						</c:if>
					</c:forEach>
				</c:forEach> --%>
				<a name="CnsTitre11">
					<h4>
						<span> <spring:message code="drug.overlay.disclaimer.title" />
						</span>
					</h4>
				</a>

				<span> <spring:message code="drug.overlay.disclaimer.text" />
				</span>
				</p>
			</c:when>
			<c:otherwise>
				<h4>
					<span lang="en-ca"><spring:message code="no.records.found" /></span>
				</h4>
			</c:otherwise>
		</c:choose>

		<p>&nbsp;</p>
		<a name="CalendrierDePrise"></a> <BR> <BR> <a
			name="IdentificationPharmacien"></a> <BR>
		<h4>
			<center>
				<a name="PiedPage"></a>
			</center>
		</h4>
	</div>
	<a href="#" class="button-erefill green acceptclose"><spring:message
			code="close.label" /></a> <a class="ctrl-print" href="#"><spring:message
			code="print.label" /></a>
</div>
<a class="close" href="#"><spring:message code="close.label" /></a>
</div>




