<%@ include file="global.jsp"%>
<head>
<title></title>
<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-my-managed-accounts'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
</head>
<c:set var="managerListPending" value="${managerListPending}" />
<c:set var="managerListAccepted" value="${managerListAccepted}" />
<c:set var="familyListPending" value="${familyListPending}" />
<c:set var="familyListAccepted" value="${familyListAccepted}" />

<div class="content">

	<!-- MAIN -->

	<h1 class="title">
		<spring:message code="my.managed.account.title" />
	</h1>
	<div class="main">
		<h2 class="sub-title">
			<spring:message code="my.managed.account.subtitle1" />
			<a href="#" class="modal" data-modal="custodianship/info"><spring:message
					code="what.is.custodianship.label" /></a>
		</h2>
		<c:choose>
			<c:when test="${empty managerListPending}">
			</c:when>
			<c:otherwise>
				<div class="pending">
					<h3>
						<spring:message code="my.managed.account.pending.request.label" />
					</h3>
					<table>
						<%boolean flag= true; %>
						<c:forEach var="patient" items="${managerListPending}">
							<%if(flag){ %>
							<tr class="alt">
								<%flag=false; } else {%>
							
							<tr>
								<% flag=true;} %>
								<th>
									<p>
										<spring:message code="my.managed.account.name.label" />
										:&nbsp;<strong><span class="username-accept">${patient.firstName}&nbsp;${patient.lastName}</span></strong>
									</p>
									<p>
										<spring:message code="my.managed.account.relationship.label" />
										:&nbsp;<strong><spring:message
												code="${patient.description}" text="${patient.description}" /></strong>
									</p> <input type="hidden" name="userName" id="userName"
									value="${patient.userName}">

								</th>
								<td class="cust_status">
									<p>
										<strong><spring:message code="pending.text" /></strong>
									</p>
								</td>
								<td>
									<p>
										<a href="#" class="button-erefill border modal"
											data-modal="${contextPath}/${locale}/managedaccount/custodianship/acceptrequest/requestoruser/${fn:replace(patient.userName,' ','%20')}/patientname/${fn:replace(patient.firstName,' ','%20')}/relationship/${fn:replace(patient.description,' ','%20')}"><spring:message
												code="my.managed.account.accept.request.label" /></a> <a
											href="" class="button-decline modal"
											data-modal="${contextPath}/${locale}/managedaccount/custodianship/declinerequest/requestoruser/${fn:replace(patient.userName,' ','%20')}/patientname/${fn:replace(patient.firstName,' ','%20')}/relationship/${fn:replace(patient.description,' ','%20')}"><spring:message
												code="my.managed.account.decline.request.label" /></a>
									</p>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:otherwise>
		</c:choose>

		<div class="access borderbottom">
			<c:choose>
				<c:when test="${empty managerListAccepted}">
					<p>
						<spring:message code="my.managed.account.no.custodianship.text" />
					</p>
				</c:when>
				<c:otherwise>
					<h3>
						<spring:message code="my.managed.account.accounts.access.label1" />
					</h3>
					<table>
						<%boolean flag= true; %>
						<c:forEach var="patient" items="${managerListAccepted}">

							<%if(flag){ %>
							<tr class="alt">
								<%flag=false; } else {%>
							
							<tr>
								<% flag=true;} %>
								<th>
									<p>
										<spring:message code="my.managed.account.name.label" />
										:&nbsp;<strong>${patient.firstName}&nbsp;${patient.lastName}</strong>
									</p>
									<p>
										<spring:message code="my.managed.account.relationship.label" />
										:&nbsp;<strong><spring:message
												code="${patient.description}" text="${patient.description}" /></strong>
									</p>
								</th>
								<td>
									<p>
										<a
											href="${contextPath}/${locale}/managedaccount/prescription/username/${patient.userName}"><spring:message
												code="my.managed.account.view.person.prescripiton.label" /></a>
									</p>
									<p>
										<a href="#" class="modal"
											data-modal="${contextPath}/${locale}/managedaccount/custodianship/cancelaccess/patientname/${fn:replace(patient.firstName,' ','%20')}/relationship/${fn:replace(patient.description,' ','%20')}/managerusername/${fn:replace(patient.userName,' ','%20')}"><spring:message
												code="my.managed.account.cancel.access.label" /></a>
									</p>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
			<a href="#" class="button-erefill green modal"
				data-modal="${contextPath}/${locale}/managedaccount/custodianship/minor" role="button"><spring:message
					code="my.managed.account.minor.custodianship.setup.label" /></a>
		</div>

		<h2 class="sub-title">
			<spring:message code="my.managed.account.subtitle2" />
		</h2>
		<c:choose>
			<c:when test="${empty familyListPending }">
			</c:when>
			<c:otherwise>
				<div class="pending">
					<h3>
						<spring:message code="my.managed.account.pending.request.label" />
					</h3>
					<table>
						<c:forEach var="patient" items="${familyListPending}">

							<tr>
								<th>
									<p>
										<spring:message code="my.managed.account.name.label" />
										:&nbsp;<strong>${patient.firstName}&nbsp;${patient.lastName}</strong>
									</p>
									<p>
										<spring:message code="my.managed.account.relationship.label" />
										:&nbsp;<strong><spring:message
												code="${patient.description}" text="${patient.description}" /></strong>
									</p>
								</th>
								<td class="cust_status">
									<p>
										<strong><spring:message code="pending.text" /></strong>
									</p>
								</td>
								<td>
									<p>
										<a href="#" class="modal"
											data-modal="${contextPath}/${locale}/managedaccount/custodianship/removerequest/patientname/${fn:replace(patient.firstName,' ','%20')}/relationship/${fn:replace(patient.description,' ','%20')}/managerusername/${fn:replace(patient.userName,' ','%20')}"><spring:message
												code="my.managed.account.remove.request.label" /></a>
									</p>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="access">
			<c:choose>
				<c:when test="${empty familyListAccepted }">
					<p>
						<spring:message
							code="my.managed.account.no.access.to.your.account.text" />
					</p>
				</c:when>
				<c:otherwise>
					<h3>
						<spring:message code="my.managed.account.accounts.access.label2" />
					</h3>
					<table>
						<c:forEach var="patient" items="${familyListAccepted}">

							<tr class="alt">
								<th>
									<p>
										<spring:message code="my.managed.account.name.label" />
										:&nbsp;<strong>${patient.firstName}&nbsp;${patient.lastName}</strong>
									</p>
									<p>
										<spring:message code="my.managed.account.relationship.label" />
										:&nbsp;<strong><spring:message
												code="${patient.description}" text="${patient.description}" /></strong>
									</p>
								</th>
								<td>
									<p>
										<a href="#" class="modal"
											data-modal="${contextPath}/${locale}/managedaccount/custodianship/revokeaccess/patientname/${fn:replace(patient.firstName,' ','%20')}/relationship/${fn:replace(patient.description,' ','%20')}/managerusername/${fn:replace(patient.userName,' ','%20')}"><spring:message
												code="my.managed.account.revoke.access.label" /></a>
									</p>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
			<a href="#" class="button-erefill green button-accept modal"
				data-modal="${contextPath}/${locale}/managedaccount/custodianship/grantaccess"
				data-apiurl="${contextPath}/${locale}/managedaccount/getConsent" role="button"><spring:message
					code="my.managed.account.grant.access.another.account.label" /></a>
		</div>
	</div>

</div>