<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="overlay-drug-information">
	<a name="CnsProduit0"><h4 class="header">
			<img src="${imageUrl}" class="refill-img" alt="Drug Image">
			<div lang="en-ca" class="title">
				${drugName}: <span>- ${drugGenericName} ${drugStrength}</span><br>
				<spring:message code="medication.drug.overlay.label" />
			</div>
		</h4></a> <a name="SizeFont"></a>

	<h4>
		<a name="EnteteNom"></a> <br> <a name="EnteteOrd"></a>
	</h4>
	<hr>

	<c:choose>
		<c:when test="${not empty drugInfoList}">
			<c:forEach var="details" items="${drugInfoList}">
				<c:if test="${not empty details.title}">
					<a name="CnsTitre0">
						<h4>
							<span lang="en-ca">${details.title}</span>
						</h4>
					</a>
				</c:if>
				<c:forEach var="desc" items="${details.description}">
					<c:if test="${not empty desc}">
						<ul>
							<li><span lang="en-ca"><c:out value="${desc}" /></span></li>
						</ul>
					</c:if>
				</c:forEach>
			</c:forEach>
			<a name="CnsTitre11"><h4>
					<span lang="en-ca"><spring:message
							code="drug.overlay.disclaimer.title" /></span>
				</h4></a>
			<p>
				<span lang="en-ca"><spring:message
						code="drug.overlay.disclaimer.text" /></span>
			</p>
		</c:when>
		<c:otherwise>
			<h4>
				<span lang="en-ca"><spring:message code="no.records.found" /></span>
			</h4>
		</c:otherwise>
	</c:choose>
	<p>&nbsp;</p>
	<a name="CalendrierDePrise"></a> <br> <br> <a
		name="IdentificationPharmacien"></a><br>
	<h4>
		<center>
			<a name="PiedPage"></a>
		</center>
	</h4>
	<a href="#" class="button-erefill green acceptclose"><spring:message
			code="close.label" /></a> <a class="ctrl-print" href="#"><spring:message
			code="print.label" /></a>
</div>