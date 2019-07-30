<%@ include file="global.jsp"%>


<div class="pharmacy-information">
	<div class="header">

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
										<c:set var="provinceTitle" value="${pharmaStores.legalName}" />
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
										<c:set var="provinceTitle" value="${pharmaStores.legalNameFr}" />
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

		<h1 class="title">${provinceTitle}</h1>

	</div>

	<div class="inner-content">
		<div class="col  pharmacy-info">
			<h4 class="title">
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
				<c:if test="${'null' ne pharmaStores.pharmaVO.addressLine1}">
					<span id="addressLine1">${pharmaStores.pharmaVO.addressLine1}</span>
					<br />
				</c:if>
				<c:if test="${'null' ne pharmaStores.pharmaVO.addressLine2}">
					<span id="addressLine2">${pharmaStores.pharmaVO.addressLine2}</span>
					<br />
				</c:if>
				<c:if test="${'null' ne pharmaStores.pharmaVO.addressLine3}">
					<span id="addressLine3">${pharmaStores.pharmaVO.addressLine3}</span>
				</c:if>
			</p>
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
				<c:if
					test="${not empty pharmaStores.pharmaVO.operatingHoursList && 'null' ne pharmaStores.pharmaVO.operatingHoursList}">
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
				</c:if>
			</table>
		</div>
		<div class="col pharmacy-details">

			<c:choose>
				<c:when test="${ 'QC' == pharmaStores.pharmaVO.province }">
					<h4 class="title">
						<spring:message code="pharmacy.owner.label" />
					</h4>
				</c:when>
				<c:otherwise>
					<h4 class="title">
						<spring:message code="pharmacy.manager.label" />
					</h4>
				</c:otherwise>
			</c:choose>
			<div class="media-object">
				<c:if test="${not empty pharmaStores.managerPhoto }">
					<div class="thumbnail">
						<img class="pharma-img" alt="Manager Image" id="logoImg"
							src="${pharmaStores.managerPhoto}" />
					</div>
				</c:if>
				<div class="details">
					<h5 class="title-pharmacist">
						<c:if test="${'null' ne pharmaStores.pharmaVO.managerName}">
							${pharmaStores.pharmaVO.managerName}
						</c:if>
					</h5>
					<%-- <a class="email-pharmacist"
						href="mailto:${pharmaStores.pharmaVO.managerEmail}"> <c:if
							test="${'null' ne pharmaStores.pharmaVO.managerEmail}">
							${pharmaStores.pharmaVO.managerEmail}
						</c:if>
					</a> --%>
				</div>
			</div>

			<c:choose>
				<c:when test="${ 'QC' == pharmaStores.pharmaVO.province }">
					<p>
						<spring:message code="pharmacy.details.disclaimer.owner.text" />
					</p>
				</c:when>
				<c:otherwise>
					<p>
						<spring:message code="pharmacy.details.disclaimer.manager.text" />
					</p>
				</c:otherwise>
			</c:choose>

			<!-- ---------------------------------------------------------------------------------------------------------------------------------------------------- -->
			<c:if
				test="${not empty pharmaStores.pharmaVO.province && 'QC' ne pharmaStores.pharmaVO.province}">


				<h4 class="title">
					<spring:message code="pharmacy.details.licensed.by.label" />
				</h4>

				<div class="media-object">
					<c:if test="${not empty pharmaStores.collegeLicenseLogo}">
						<div class="thumbnail">
							<!-- <img src="/content/dam/ERefill/licence_logos/${fn:toLowerCase(pharmaStores.collegeLicenseLogo)}.png" alt="" /> -->
							<img
								src="<c:url value='/resources/images/erefill/licence_logos/${fn:toLowerCase(pharmaStores.collegeLicenseLogo)}.png'/>"
								alt="Pharmacy store licence logo" />
						</div>
					</c:if>
					<div class="details"></div>
				</div>

				<p>
					<c:if
						test="${not empty pharmaStores.collegeStreet && 'null' ne pharmaStores.collegeStreet}">
						${pharmaStores.collegeStreet}<br>
					</c:if>
					<c:if
						test="${not empty pharmaStores.collegeCity && 'null' ne pharmaStores.collegeCity}">
						${pharmaStores.collegeCity},
					</c:if>
					<c:if
						test="${not empty pharmaStores.collegeProvince && 'null' ne pharmaStores.collegeProvince}">
						${pharmaStores.collegeProvince} <br>
					</c:if>
					<c:if
						test="${not empty pharmaStores.collegePostalCode && 'null' ne pharmaStores.collegePostalCode}">
						${pharmaStores.collegePostalCode}
					</c:if>
				</p>

				<table class="phone-numbers">
					<tr>
						<th><spring:message code="phone.label" /></th>
						<td><c:if
								test="${not empty pharmaStores.storePhone && 'null' ne pharmaStores.storePhone}">
								${pharmaStores.storePhone}
						</c:if></td>
					</tr>
					<tr>
						<th><spring:message code="fax.label" /></th>
						<td><c:if
								test="${not empty pharmaStores.storeFax && 'null' ne pharmaStores.storeFax}">
								${pharmaStores.storeFax}
							</c:if></td>
					</tr>
					<tr style="display: none;">
						<th><spring:message code="opq.label" /></th>
						<td><c:if
								test="${not empty pharmaStores.collegeLicense && 'null' ne pharmaStores.collegeLicense && not empty pharmaStores.storeOpq && 'null' ne pharmaStores.storeOpq}">
								<a
									href="/content/dam/ERefill/licence_docs/${fn:toLowerCase(pharmaStores.collegeLicense)}.pdf"
									target="_blank"> ${pharmaStores.storeOpq}</a>
							</c:if></td>
					</tr>
				</table>

				<c:if test="${'AB' eq pharmaStores.collegeProvince}">
					<p class="footnote">
						<spring:message code="pharmacy.details.footnote.manager.message" />
					</p>
				</c:if>
			</c:if>
			<!-- --------------------------------------------------------------------------------------------------------------------------------------------------- -->
		</div>


		<div class="col pharmacy-about">
			<h4 class="title">
				<spring:message code="pharmacy.details.about.us.label" />
			</h4>

			<c:choose>
				<c:when test="${locale eq 'fr_CA'}">
					<c:if test="${not empty pharmaStores.pharmaVO.descriptionFR}">
						${pharmaStores.pharmaVO.descriptionFR}
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if test="${not empty pharmaStores.pharmaVO.description}">
						${pharmaStores.pharmaVO.description}
					</c:if>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
