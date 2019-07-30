<%@ include file="global.jsp"%>

<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-refill-request'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>

<div class="content">
	<c:choose>
		<c:when test="${refillType eq 'auto'}">
			<c:choose>
				<c:when test="${isLoggedInUser}">
					<h1 class="title">
						<spring:message code="auto.refill.page.title.label" />
					</h1>
					<h2 class="subhead">
						<spring:message code="auto.refill.page.subtitle.label" />
					</h2>
					<p>
						<spring:message code="auto.refill.page.description.text" />
					</p>
				</c:when>
				<c:otherwise>
					<h1 class="title">
						<spring:message code="auto.refill.page.custodian.title.label" />
						<div class="impersonatedTitle"></div>
					</h1>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${isLoggedInUser}">
					<h1 class="title">
						<spring:message code="refill.reminder.page.title.label" />
					</h1>
				</c:when>
				<c:otherwise>
					<h1 class="title">
						<spring:message code="refill.reminder.page.custodian.title.label" />
						<div class="impersonatedTitle"></div>
					</h1>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${refillType eq 'auto'}">
			<form class="uniform form-validate form-refill-request"
				action="${contextPath}/${locale}/autorefill/submit" method="post"
				data-auto-success="${contextPath}/${locale}/refillrequest/autorefill/success"
				data-reminder-success="${contextPath}/${locale}/refillrequest/refillreminder/success"
				data-refill-success="${contextPath}/${locale}/refillrequest/refill/success"
				data-auto-error="${contextPath}/${locale}/refillrequest/autorefill/error"
				data-reminder-error="${contextPath}/${locale}/refillrequest/refillreminder/error"
				data-refill-error="${contextPath}/${locale}/refillrequest/refill/error"
				data-cal-enable="<c:url value='/resources/images/erefill/icon-calendar.png'/>"
				data-msg-notify="<spring:message code="auto.refill.data.message"/>">
		</c:when>
		<c:otherwise>
			<form class="uniform form-refill-request form-refill-reminder"
				action="${contextPath}/${locale}/autorefill/submit" method="post"
				data-auto-success="${contextPath}/${locale}/refillrequest/autorefill/success"
				data-reminder-success="${contextPath}/${locale}/refillrequest/refillreminder/success"
				data-refill-success="${contextPath}/${locale}/refillrequest/refill/success"
				data-auto-error="${contextPath}/${locale}/refillrequest/autorefill/error"
				data-reminder-error="${contextPath}/${locale}/refillrequest/refillreminder/error"
				data-refill-error="${contextPath}/${locale}/refillrequest/refill/error"
				data-cal-enable="<c:url value='/resources/images/erefill/icon-calendar.png'/>">
		</c:otherwise>
	</c:choose>
	<input id="refillType" name="refillType" value="${refillType}"
		type="hidden" /> <input id="emailStatus" name="emailStatus"
		value="${emailStatus}" type="hidden" /> <input id="account"
		name="account" value="${account}" type="hidden" /> <input
		id="phoneNo" name="phoneNo" value="${mobileNumber}" type="hidden" />
	<input id="delivery" name="delivery" value="true" type="hidden" />
	<table class="refill-list">
		<thead>
			<tr>
				<th><spring:message code="refill.request.medication" /></th>
				<th class="quantity"><spring:message
						code="refill.request.medication" /></th>
				<th><spring:message code="refill.request.comments" /></th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty prescDetails}">
					<c:forEach items="${prescDetails}" var="presc" varStatus="i">
						<tr>
							<td class="medication"><a href="#" class="drug-info-modal"
								data-drug-id="${presc.din}"
								data-modal="${contextPath}/${locale}/orderhistory/drugdetails"
								data-print="<spring:message	code="print.label"/>"> <span>${presc.name}</span>
									- ${presc.genericName}
							</a> <c:if test="${not empty presc.strength}"> (${presc.strength}) </c:if><br />
								<span>(<spring:message code="rx.label" />#${presc.rxNumber})
							</span></td>
							<td class="quantity">${presc.quantityFilled}</td>
							<td class="comment"><textarea name="drug-id-here"
									maxlength="1024"></textarea> <input id="medOID" name="medOID"
								value="${presc.oid}" type="hidden" /> <c:if
									test="${refillType eq 'auto'}">
									<input id="prescOrigOID" name="prescOrigOID"
										value="${presc.oid}" type="hidden" />
								</c:if> <c:if test="${refillType eq 'reminder'}">
									<input id="prescOrigOID" name="prescOrigOID"
										value="${presc.originalOid}" type="hidden" />
								</c:if></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td><spring:message code="no.records.found" /></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>

	<c:if test="${refillType eq 'auto'}">
		<h2 class="subhead">
			<spring:message code="refill.request.pickup.delivery.options" />
		</h2>

		<div class="delivery-options no-datepicker">
			<div class="pickup-option active">
				<label class="radio-item"> <input type="radio"
					name="deliveryChoice" checked="checked" value="Pickup">
				<spring:message code="auto.refill.pick.up.text" /> <input
					type="hidden" name="medReleaseMode" value="Pickup">
				</label>
				<c:if test="${not empty account}">
					<p class="address">
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
									<spring:message code="loblaw.pharmacy.at.label" />
								</c:set>
							</c:otherwise>
						</c:choose>
						${provinceTitle}<br />

						<c:choose>
							<c:when test="${locale eq 'en_CA'}">
								<c:if test="${'null' ne pharmaStores.pharmaVO.pharmacyTitle}">
									<c:out value="${pharmaStores.pharmaVO.pharmacyTitle}" /><br/>
								</c:if>
							</c:when>
							<c:otherwise>
								<c:if test="${'null' ne pharmaStores.pharmaVO.storeNameFr}">
									<c:out value="${pharmaStores.pharmaVO.storeNameFr}" /><br/>
								</c:if>
							</c:otherwise>
						</c:choose> <span id="addressLine1">${pharmaStores.pharmaVO.addressLine1}
				</span><br> <span id="addressLine2">${pharmaStores.pharmaVO.addressLine2}
				<c:choose> <c:when test="${pharmaStores.pharmaVO.addressLine3 eq null}">${pharmaStores.pharmaVO.postalCode}
				</span> <br> </c:when>
				<c:otherwise></span> <br>
				<span id="addressLine3">${pharmaStores.pharmaVO.addressLine3} ${pharmaStores.pharmaVO.postalCode}</span> 
				</c:otherwise>
				</c:choose>
					</p>
				</c:if>

				<p>
					<spring:message code="auto.refill.prescription.pickup.dates.text" />
				</p>

				<ul class="pickup-dates">
					<c:if test="${not empty pickUpDate}">
						<li>${pickUpDate}</li>
					</c:if>
				</ul>
				<input id="PickReleaseDate" name="PickReleaseDate"
					value="${pickUpDateValue}" type="hidden" />

				<div class="err-msg">
					<ul></ul>
				</div>

				<p class="note">
					<span><spring:message code="refill.request.note.label" /></span>
					<spring:message code="auto.refill.pickup.note.text" />
				</p>

				<label><spring:message code="refill.request.comments.label" /><br />
					<textarea name="pickup-comments" maxlength="1024"></textarea> </label>
			</div>

			<div class="delivery-option">
				<label class="radio-item"> <input type="radio"
					name="deliveryChoice" value="Delivery">
				<spring:message code="auto.refill.delivery.text" />
				</label>

				<p class="address">
					<c:choose>
						<c:when test="${not empty entityPatient.address}">
							<input id="deliveryAddress" name="deliveryaddress"
								value="${entityPatient.address}" type="hidden" />
							<input id="delivery.city" name="deliverycity"
								value="${entityPatient.city}" type="hidden" />
							<input id="delivery.province" name="eProvince"
								value="${entityPatient.primaryEProvince}" type="hidden" />
							<input id="delivery.postalCode" name="deliverypostalCode"
								value="${entityPatient.primaryAddressPostalCode}" type="hidden" />
								${entityPatient.address}<br />
								${entityPatient.city},${entityPatient.primaryEProvince} <br />
								${entityPatient.primaryAddressPostalCode}
							</c:when>
						<c:when test="${not empty entityPatient.deliveryAddress}">
							<input id="delivery.address" name="deliveryaddress"
								value="${entityPatient.deliveryAddress}" type="hidden" />
							<input id="delivery.city" name="deliverycity"
								value="${entityPatient.deliveryCity}" type="hidden" />
							<input id="delivery.province" name="eProvince"
								value="${entityPatient.EProvince}" type="hidden" />
							<input id="delivery.postalCode" name="deliverypostalCode"
								value="${entityPatient.deliveryPostalCode}" type="hidden" />
								${entityPatient.deliveryAddress}<br />
								${entityPatient.deliveryCity},${entityPatient.EProvince} <br />
								${entityPatient.deliveryPostalCode}
							</c:when>
						<c:otherwise>
							<input id="delivery.address" name="deliveryaddress"
								value="${entityPatient.defaultPharmacy.address}" type="hidden" />
							<input id="delivery.city" name="deliverycity"
								value="${entityPatient.defaultPharmacy.city}" type="hidden" />
							<input id="delivery.province" name="eProvince"
								value="${entityPatient.defaultPharmacy.province}" type="hidden" />
							<input id="delivery.postalCode" name="deliverypostalCode"
								value="${entityPatient.defaultPharmacy.postalCode}"
								type="hidden" />
								${entityPatient.defaultPharmacy.address}<br />
								${entityPatient.defaultPharmacy.city},${entityPatient.defaultPharmacy.province} <br />
								${entityPatient.defaultPharmacy.postalCode}
							</c:otherwise>
					</c:choose>
				</p>
				<p class="note">
					<span><spring:message code="refill.request.note.label" /></span>
					<spring:message code="auto.refill.delivery.address.change.note" />
				</p>
				<p>
					<spring:message code="auto.refill.prescription.delivery.dates.text" />
				</p>

				<ul class="delivery-dates">
					<c:if test="${not empty deliveryDate}">
						<li>${deliveryDate}</li>
					</c:if>
				</ul>

				<input id="DelReleaseDate" name="DelReleaseDate"
					value="${deliveryDateValue}" type="hidden" />

				<div class="err-msg">
					<ul></ul>
				</div>

				<p class="note">
					<span><spring:message code="refill.request.note.label" /></span>
					<spring:message code="auto.refill.delivery.note.text" />
				</p>

				<label><spring:message code="refill.request.comments.label" /><br />
					<textarea name="delivery-comments" maxlength="1024"></textarea> </label>
			</div>
		</div>
	</c:if>


	<c:choose>
		<c:when test="${refillType eq 'auto'}">
			<h2 class="subhead">
				<spring:message code="auto.refill.reminders.subheading.label" />
			</h2>
			<c:if test="${userRole eq 'Caregivers' }">
				<p>
					<spring:message
						code="auto.refill.reminders.caregiver.subheading.text" />
				</p>
			</c:if>
			<c:if test="${userRole ne 'Caregivers' }">
				<p>
					<spring:message code="auto.refill.reminders.subheading.text" />
				</p>
			</c:if>
			<p>
				<spring:message code="select.label" />
			</p>
		</c:when>
		<c:otherwise>
			<h2 class="subhead">
				<spring:message code="refill.reminders.subheading.label" />
			</h2>
			<p>
				<spring:message code="refill.reminder.day.select.text" />
			</p>
			<div class="reminder-select-wrap">
				<select class="refill-reminder-days" name="date-range">
					<option value="7" selected="selected">7
						<spring:message code="days.text" /></option>
					<option value="6">6
						<spring:message code="days.text" /></option>
					<option value="5">5
						<spring:message code="days.text" /></option>
					<option value="4">4
						<spring:message code="days.text" /></option>
					<option value="3">3
						<spring:message code="days.text" /></option>
					<option value="2">2
						<spring:message code="days.text" /></option>
					<option value="1">1
						<spring:message code="day.text" /></option>
				</select>
			</div>
			<!-- This must be here to ensure there is no datepicker JS error -->
			<div class="delivery-options no-datepicker hidden"></div>

			<c:if
				test="${empty entityPatient.phoneNumber || 'null' eq entityPatient.phoneNumber || emailStatus=='Pending' || empty account || 'null' eq account }">
				<p>
					<spring:message code="refill.reminder.instruction.text" />
				</p>
			</c:if>
			<c:if test="${userRole eq 'Caregivers' }">
				<p>
					<spring:message code="refill.reminder.caregiver.notification.text" />
				</p>
			</c:if>
			<c:if test="${userRole ne 'Caregivers' }">
				<p>
					<spring:message code="refill.reminder.notification.text" />
				</p>
			</c:if>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${refillType eq 'reminder'}">
			<div class="refill-notify required"
				data-msg-notify="<spring:message code="refill.reminder.data.message.notify" />"
				data-msg-email-notify="<spring:message code="refill.reminder.data.message.email.notify" />"
				data-msg-mobile-notify="<spring:message code="refill.reminder.data.message.mobile.notify" />">
		</c:when>
		<c:otherwise>
			<div class="refill-notify">
		</c:otherwise>
	</c:choose>


	<div class="checkbox-item">
		<label> <c:choose>
				<c:when test="${not empty account}">
					<c:if test="${not empty emailStatus}">
						<c:choose>
							<c:when
								test="${emailStatus=='OK'||emailStatus=='Ok'||emailStatus=='ok'}">
								<input type="checkbox" name="emailnotify">
								<spring:message code="refill.request.notify.email.label" />
								<strong>${account}</strong>
								<c:if test="${userRole ne 'Caregivers' }">
									<spring:message
										code="refill.reminder.email.change.notification.text" />
								</c:if>
								<input id="email" name="email" value="${account}" type="hidden" />
							</c:when>
							<c:otherwise>
								<input type="checkbox" name="emailnotify" disabled>
								<spring:message code="refill.request.notify.email.label" />
								<spring:message code="refill.request.notify.email.unchecked" />
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:when>
				<c:otherwise>
					<input type="checkbox" name="emailnotify" disabled>
					<spring:message code="refill.request.notify.email.label" />
					<spring:message code="refill.reminder.no.email.text" />
				</c:otherwise>
			</c:choose>
		</label>
	</div>

	<c:if test="${userRole ne 'Caregivers'}">
		<div class="checkbox-item">
			<label> <c:choose>
					<c:when test="${not empty mobileNumber}">
						<c:if test="${not empty mobileStatus}">
							<c:choose>
								<c:when test="${mobileStatus == 0}">
									<input type="checkbox" name="phonenotify">
									<spring:message code="refill.request.notify.mobile.label" />	                                   
	                                    <strong>${fn:substring(mobileNumber, 0, 3)}-${fn:substring(mobileNumber, 3, 6)}-${fn:substring(mobileNumber, 6, 10)}</strong>
	                                    <input id="phone" name="phone" value="${mobileNumber}" type="hidden" />
	                                </c:when>
								<c:when test="${mobileStatus == 1}">
									<input type="checkbox" name="phonenotify" disabled>
									<spring:message code="refill.request.notify.mobile.label" />
									<spring:message code="refill.reminder.verify.mobile.text" />
								</c:when>
								<c:when test="${mobileStatus == 2}">
									<input type="checkbox" name="phonenotify" disabled>
									<spring:message code="refill.request.notify.mobile.label" />
									<spring:message code="refill.reminder.no.mobile.text" />
								</c:when>
							</c:choose>
						</c:if>
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="phonenotify" disabled>
						<spring:message code="refill.request.notify.mobile.label" />
						<spring:message code="refill.reminder.no.mobile.text" />
					</c:otherwise>
				</c:choose>
			</label>
		</div>
	</c:if>

</div>


<div class="form-footer form-footer-refill">
	<c:choose>
		<c:when
			test="${refillType eq 'auto' && empty pickUpDate && empty deliveryDate}">
			<p class="refill-nodate">
				<spring:message code="auto.refill.page.no.date.error" />
			</p>
			<button type="submit" class="button-erefill green refill-submit"
				disabled>
				<spring:message code="submit.button.label" />
			</button>
		</c:when>
		<c:otherwise>
			<button type="submit" class="button-erefill green refill-submit" disabled>
				<spring:message code="submit.button.label" />
			</button>
		</c:otherwise>
	</c:choose>
	<!-- <a class="cancel no-click" href="${contextPath}/${locale}/prescription/details"><spring:message code="cancel.button.label" /></a> -->

</div>

<c:if test="${not empty operatingHours}">
	<input type="hidden" id="operatingHours" value='${operatingHours}' />
</c:if>
<csrf:csrfToken />
</form>

<form class="form-footer-refill-cancel" method="POST"
	action="${contextPath}/${locale}/prescription/details">
	<button type="submit" class="cancel">
		<spring:message code="refill.cancel.label" />
	</button>
	<input type="hidden" id="page_num" value='${page_num}' name="page_num" />
	<csrf:csrfToken />
</form>

</div>