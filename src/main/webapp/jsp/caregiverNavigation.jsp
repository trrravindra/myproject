<%@ include file="global.jsp"%>

<section class="sidenav">
	<%@ include file="welcomenote.jsp"%>
	<%@ include file="customnavigation.jsp"%>
	<nav class="nav-general">
		<ul>
			<li><a
				class="<c:if test="${'caregiverMyPrescription' eq pageName}">active</c:if> no-click"
				href="${contextPath}/${locale}/caregiver/prescription/details">
					<c:if
						test="${empty selectedPatientOID || selectedPatientOID eq PatientOID || selectedPatientOID eq 'Caregivers' }">
						<spring:message code="content.nav.my" />
					</c:if> <spring:message code="content.nav.prescription" />
			</a></li>
		</ul>
		<ul>
			<li><a
				class="<c:if test="${'caregiverOrderHistory' eq pageName}">active</c:if> no-click"
				href="${contextPath}/${locale}/orderhistory/getorderhistory"> <c:choose>
						<c:when
							test="${empty selectedPatientOID || selectedPatientOID eq PatientOID || selectedPatientOID eq 'Caregivers'}">
							<spring:message code="content.nav.order.history" />
						</c:when>
						<c:otherwise>
							<spring:message code="content.nav.order.history.custodian" />
						</c:otherwise>
					</c:choose>
			</a></li>
		</ul>
		<ul>
			<li><a
				class="<c:if test="${'caregiverMedicationRecord' eq pageName}">active</c:if> no-click"
				href="${contextPath}/${locale}/mymedicationrecord"> <c:if
						test="${empty selectedPatientOID || selectedPatientOID eq PatientOID || selectedPatientOID eq 'Caregivers'}">
						<spring:message code="content.nav.my" />
					</c:if> <spring:message code="content.nav.medication.record" /></a></li>
		</ul>
		<c:if test="${selectedPatientOID eq 'Caregivers' || isLoggedInUser}">
			<ul>
				<li><a
					class="<c:if test="${'caregiverAccount' eq pageName}">active</c:if> no-click"
					href="${contextPath}/${locale}/myaccount/caregiver/details"><spring:message
							code="content.nav.account" /></a></li>
			</ul>
		</c:if>
		<ul>
			<li><a
				class="<c:if test="${'caregiverHelp' eq pageName}">active</c:if> no-click"
				href="${contextPath}/${locale}/user/help"><spring:message
						code="content.nav.help" /></a></li>
		</ul>
		<ul>
			<li><a
				class="<c:if test="${'caregiverContactUs' eq pageName}">active</c:if> no-click"
				href="${contextPath}/${locale}/user/contactus"><spring:message
						code="content.nav.contact.us" /></a></li>
		</ul>
	</nav>
</section>
<c:choose>
	<c:when test="${isLoggedInUser}">
		<%-- <c:out value="${isLoggedInUser}"></c:out> --%>
	</c:when>
	<c:otherwise>
		<!-- pharmacy section to be displayed only when not logged in user -->
		<div class="card my-pharmacy">

			<div class="header">
				<div class="inner">
					<h3 class="title">
						<spring:message code="pharmacy.details.label" />
					</h3>
				</div>
			</div>
			<div class="content">
				<div class="inner">
					<c:if test="${not empty selectedPatientOID}">
						<p>
							<spring:message code="pharmacy.for.label" />
							<br />
						<div class="impersonatedTitle"></div>
						</p>
					</c:if>
					<h4 class="Addresstitle title">
						<%-- <c:choose>
														<c:when
															test="${not empty pharmaStores && pharmaStores.pharmaVO.province == 'QC'}">
															<spring:message code="quebec.pharmacy.at.label" />
															<br />
														</c:when>
														<c:otherwise>
															<spring:message code="loblaw.pharmacy.at.label" />
															<br />
														</c:otherwise>
													</c:choose>
													<c:choose>
														<c:when test="${locale eq 'en_CA'}">
													${pharmaStores.pharmaVO.pharmacyTitle}
												</c:when>
														<c:otherwise>
													${pharmaStores.pharmaVO.storeNameFr}
												</c:otherwise>
													</c:choose> --%>

						<c:choose>
							<c:when
								test="${not empty pharmaStores.pharmaVO.province && pharmaStores.pharmaVO.province == 'QC'}">
								<c:choose>
									<c:when test="${'null' ne pharmaStores}">
										<c:choose>
											<c:when test="${locale eq 'en_CA'}">
												<c:choose>
													<c:when
														test="${not empty pharmaStores.legalName && 'null' ne pharmaStores.legalName}">
														<c:set var="provinceTitle"
															value="${pharmaStores.legalName}" />
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when
																test="${not empty pharmaStores.businessOwner && 'null' ne pharmaStores.businessOwner}">
																<c:set var="provinceTitle"
																	value="${pharmaStores.businessOwner}" />
															</c:when>
															<c:otherwise>
																<c:set var="provinceTitle">
																	<spring:message code="quebec.pharmacy.label" />
																</c:set>
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when
														test="${not empty pharmaStores.legalNameFr && 'null' ne pharmaStores.legalNameFr}">
														<c:set var="provinceTitle"
															value="${pharmaStores.legalNameFr}" />
													</c:when>
													<c:otherwise>
														<c:choose>
															<c:when
																test="${not empty pharmaStores.businessOwner && 'null' ne pharmaStores.businessOwner}">
																<c:set var="provinceTitle"
																	value="${pharmaStores.businessOwner}" />
															</c:when>
															<c:otherwise>
																<c:set var="provinceTitle">
																	<spring:message code="quebec.pharmacy.label" />
																</c:set>
															</c:otherwise>
														</c:choose>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<c:set var="provinceTitle">
											<spring:message code="quebec.pharmacy.label" />
										</c:set>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:set var="provinceTitle">
									<spring:message code="loblaw.pharmacy.label" />
								</c:set>
							</c:otherwise>
						</c:choose>
						${provinceTitle}

						<c:if
							test="${not empty pharmaStores && pharmaStores.pharmaVO.province ne 'QC'}">
							<spring:message code="at.label" />
							<br />
						</c:if>
						<c:if
							test="${not empty pharmaStores && pharmaStores.pharmaVO.province ne 'QC'}">
							<c:choose>
								<c:when test="${locale eq 'en_CA'}">
									<c:if test="${'null' ne pharmaStores.pharmaVO.pharmacyTitle}">
										<c:out value="${pharmaStores.pharmaVO.pharmacyTitle}" />
									</c:if>
								</c:when>
								<c:otherwise>
									<c:if test="${'null' ne pharmaStores.pharmaVO.storeNameFr}">
										<c:out value="${pharmaStores.pharmaVO.storeNameFr}" />
									</c:if>
								</c:otherwise>
							</c:choose>
						</c:if>
					</h4>
					<p>
						<span id="addressLine1">${pharmaStores.pharmaVO.addressLine1}
						</span><br> <span id="addressLine2">${pharmaStores.pharmaVO.addressLine2}
						</span> <br> <span id="addressLine2">${pharmaStores.pharmaVO.addressLine3}
						</span>

					</p>
					<div class="no-print">
						<table class="phone-numbers">
							<tbody>
								<tr>
									<th><spring:message code="phone.label" /></th>

									<c:if test="${'null' ne pharmaStores.pharmaVO.phone}">
										<td id="phoneNumber">${pharmaStores.pharmaVO.phone}</td>
									</c:if>
								</tr>
								<tr>
									<th><spring:message code="fax.label" /></th>
									<c:if test="${'null' ne pharmaStores.pharmaVO.fax}">
										<td id="faxNumber">${pharmaStores.pharmaVO.fax}</td>
									</c:if>
								</tr>
							</tbody>
						</table>
						<h4 class="title-hours">
							<spring:message code="pharmacy.hours.label" />
						</h4>
						<table class="pharmacy-hours">
							<c:forEach items="${pharmaStores.pharmaVO.operatingHoursList}"
								var="oprHrs">
								<tr>
									<c:choose>
										<c:when test="${locale eq 'fr_CA'}">
											<th>${oprHrs.dayFr}:</th>
										</c:when>
										<c:otherwise>
											<th>${oprHrs.day}:</th>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${locale eq 'fr_CA'}">
											<td>${oprHrs.hoursFr}</td>
										</c:when>
										<c:otherwise>
											<td>${oprHrs.hours}</td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</table>
						<input type="hidden" id="storeId" name="storeId"
							value="${pharmaStores.pharmaVO.storeId}" /> <a
							data-modal="${contextPath}/${locale}/pharmacyDetails" href="#"
							class="more-details modal"><spring:message
								code="more.pharmacy.details.label" /></a>
					</div>
				</div>
			</div>
		</div>

	</c:otherwise>
</c:choose>
