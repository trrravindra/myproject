<%@ include file="global.jsp"%>

<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
</head>
<script id="require-js"
	data-path="${pageContext.request.contextPath}/static/global.html"
	data-main="<c:url value='/resources/js/erefill-refill-request'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>

<div class="content">
	<c:choose>
		<c:when test="${isLoggedInUser}">
			<h1 class="title">
				<spring:message code="refill.request.page.title" />
			</h1>
		</c:when>
		<c:otherwise>
			<h1 class="title">
				<spring:message code="refill.request.page.custodian.title" />
				<div class="impersonatedTitle"></div>
			</h1>
		</c:otherwise>
	</c:choose>

	<c:set var="placeholder" value="YYYY-MM-DD" />
	<c:if test="${locale eq 'fr_CA' }">
		<c:set var="placeholder" value="AAAA-MM-JJ" />
	</c:if>

	<form class="uniform form-validate form-refill-request"
		action="${contextPath}/${locale}/refillrequest/submit" method="post"
		data-auto-success="${contextPath}/${locale}/refillrequest/autorefill/success"
		data-reminder-success="${contextPath}/${locale}/refillrequest/refillreminder/success"
		data-refill-success="${contextPath}/${locale}/refillrequest/refill/success"
		data-auto-error="${contextPath}/${locale}/refillrequest/autorefill/error"
		data-reminder-error="${contextPath}/${locale}/refillrequest/refillreminder/error"
		data-refill-error="${contextPath}/${locale}/refillrequest/refill/error"
		data-cal-enable="<c:url value='/resources/images/erefill/icon-calendar.png'/>">

		<input id="freedeldeptid" name="freedeldeptid"
			value="${pharmaStores.pharmaVO.freeDelDepttId}" type="hidden" /> <input
			type="hidden" value="${pharmaStores.pharmaVO.storeId}" id="storeId"
			name="storeId" />
		<csrf:csrfToken />
		<table class="refill-list">
			<thead>
				<tr>
					<th><spring:message code="refill.request.medication" /></th>
					<th class="quantity"><spring:message
							code="refill.request.quantity" /></th>
					<th><spring:message code="refill.request.comments" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${prescDetails}" var="view" varStatus="i">
					<tr class="${i.count%2 == 0 ? '' : 'alt'}">
						<td class="medication"><a class="drug-info-modal"
							data-drug-id="${view.din}"
							data-print="<spring:message code="print.label" />"
							data-modal="${contextPath}/${locale}/orderhistory/drugdetails"
							href="#"> <span>${view.name}</span>-${view.genericName}
						</a> <c:if test="${not empty view.strength}">
								(${view.strength})
							</c:if> <br>(<spring:message code="rx.label" /> #${view.rxNumber})
						</td>
						<td class="quantity">${view.quantityFilled}</td>
						<td class="comment"><textarea name="drug_id_here"
								maxlength="1024"></textarea> <input id="prescOrigOID"
							name="prescOrigOID" value="${view.oid}" type="hidden" /></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<input id="delivery" name="delivery" value="true" type="hidden" />
		<h2 class="subhead">
			<spring:message code="refill.request.pickup.delivery.options" />
		</h2>
		<div class="delivery-options">
			<div class="pickup-option active">
				<label class="radio-item"> <input type="radio"
					value="Pickup" checked="checked" name="medReleaseMode"> <spring:message
						code="refill.request.pickup.label" />
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
									<c:out value="${pharmaStores.pharmaVO.pharmacyTitle}" /> <br/> 
								</c:if>
							</c:when>
							<c:otherwise>
								<c:if test="${'null' ne pharmaStores.pharmaVO.storeNameFr}">
									<c:out value="${pharmaStores.pharmaVO.storeNameFr}" /> <br/>
								</c:if>
							</c:otherwise>
						</c:choose><span id="addressLine1">${pharmaStores.pharmaVO.addressLine1}
				</span><br> <span id="addressLine2">${pharmaStores.pharmaVO.addressLine2}
				<c:choose> <c:when test="${pharmaStores.pharmaVO.addressLine3 eq null}">${pharmaStores.pharmaVO.postalCode}
				</span> <br> </c:when>
				<c:otherwise></span> <br>
				<span id="addressLine3">${pharmaStores.pharmaVO.addressLine3} ${pharmaStores.pharmaVO.postalCode}</span> 
				</c:otherwise>
				</c:choose>
					</p>
				</c:if>
				<p class="date-selector">
					<spring:message code="refill.request.pickup.date.time" />
					<br> <label class="date-disclaimer"> <spring:message
							code="refill.request.pickup.info.text" />
					</label><br> <label> <input type="text"
						class="pickup-date-picker date-select" name="PickReleaseDate"
						value="" placeholder="${placeholder}"
						data-msg-required="<spring:message code="refill.request.pickup.date.req.msg" />"
						data-msg-malformed-date="<spring:message code="refill.request.pickup.date.format.msg" />"
						data-msg-out-of-range="<spring:message code="refill.request.pickup.date.range.msg" />"
						maxlength="10" />
					</label> <select name="pickup-time">
						<option value="600">6:00 AM</option>
						<option value="630">6:30 AM</option>
						<option value="700">7:00 AM</option>
						<option value="730">7:30 AM</option>
						<option value="800">8:00 AM</option>
						<option value="830">8:30 AM</option>
						<option value="900">9:00 AM</option>
						<option value="930">9:30 AM</option>
						<option value="1000">10:00 AM</option>
						<option value="1030">10:30 AM</option>
						<option value="1100">11:00 AM</option>
						<option value="1130">11:30 AM</option>
						<option value="1200">12:00 PM</option>
						<option value="1230">12:30 PM</option>
						<option value="1300">1:00 PM</option>
						<option value="1330">1:30 PM</option>
						<option value="1400">2:00 PM</option>
						<option value="1430">2:30 PM</option>
						<option value="1500">3:00 PM</option>
						<option value="1530">3:30 PM</option>
						<option value="1600">4:00 PM</option>
						<option value="1630">4:30 PM</option>
						<option value="1700">5:00 PM</option>
						<option value="1730">5:30 PM</option>
						<option value="1800">6:00 PM</option>
						<option value="1830">6:30 PM</option>
						<option value="1900">7:00 PM</option>
						<option value="1930">7:30 PM</option>
						<option value="2000">8:00 PM</option>
						<option value="2030">8:30 PM</option>
						<option value="2100">9:00 PM</option>
						<option value="2130">9:30 PM</option>
						<option value="2200">10:00 PM</option>
						<option value="2230">10:30 PM</option>
						<option value="2300">11:00 PM</option>
						<option value="2330">11:30 PM</option>
						<option value="2400">12:00 AM</option>
						<option value="2430">12:30 AM</option>
						<option value="0100">1:00 AM</option>
						<option value="0130">1:30 AM</option>
					</select>

				</p>
				<div class="err-msg">
					<ul></ul>
				</div>
				<p class="note">
					<span><spring:message code="refill.request.note.label" /></span>
					<spring:message code="refill.request.pickup.note.text" />
				</p>
				<label> <spring:message code="refill.request.comments.label" />
					<br> <textarea name="comments" maxlength="1024"></textarea>
				</label>
			</div>
			<div class="delivery-option">
				<label class="radio-item"> <c:choose>
						<c:when test="${ not empty pharmaStores.pharmaVO.freeDelDepttId }">
							<input type="radio" value="Delivery" name="medReleaseMode">
						</c:when>
						<c:otherwise>
							<input type="radio" value="Delivery" name="medReleaseMode"
								disabled="disabled">
						</c:otherwise>

					</c:choose> <spring:message code="refill.request.delivery.label" /> <c:if
						test="${ empty pharmaStores.pharmaVO.freeDelDepttId }">
						<div class="delivery-close-text">
							<spring:message code="disabled.option.help.text" />
						</div>
					</c:if>
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
					<spring:message code="refill.request.delivery.address.note.text" />
				</p>
				<p class="date-selector">
					<spring:message code="refill.request.delivery.date" />
					<br> <label> <input type="text"
						class="delivery-date-picker date-select" name="DelReleaseDate"
						value="" placeholder="${placeholder}" maxlength="10"
						data-msg-required="<spring:message code="refill.request.delivery.date.req.msg" />"
						data-msg-malformed-date="<spring:message code="refill.request.delivery.date.format.msg" />"
						data-msg-out-of-range="<spring:message code="refill.request.delivery.date.range.msg" />" />
					</label> <select name="delivery-time">
						<option value="600">6:00 AM</option>
						<option value="630">6:30 AM</option>
						<option value="700">7:00 AM</option>
						<option value="730">7:30 AM</option>
						<option value="800">8:00 AM</option>
						<option value="830">8:30 AM</option>
						<option value="900">9:00 AM</option>
						<option value="930">9:30 AM</option>
						<option value="1000">10:00 AM</option>
						<option value="1030">10:30 AM</option>
						<option value="1100">11:00 AM</option>
						<option value="1130">11:30 AM</option>
						<option value="1200">12:00 PM</option>
						<option value="1230">12:30 PM</option>
						<option value="1300">1:00 PM</option>
						<option value="1330">1:30 PM</option>
						<option value="1400">2:00 PM</option>
						<option value="1430">2:30 PM</option>
						<option value="1500">3:00 PM</option>
						<option value="1530">3:30 PM</option>
						<option value="1600">4:00 PM</option>
						<option value="1630">4:30 PM</option>
						<option value="1700">5:00 PM</option>
						<option value="1730">5:30 PM</option>
						<option value="1800">6:00 PM</option>
						<option value="1830">6:30 PM</option>
						<option value="1900">7:00 PM</option>
						<option value="1930">7:30 PM</option>
						<option value="2000">8:00 PM</option>
						<option value="2030">8:30 PM</option>
						<option value="2100">9:00 PM</option>
						<option value="2130">9:30 PM</option>
						<option value="2200">10:00 PM</option>
						<option value="2230">10:30 PM</option>
						<option value="2300">11:00 PM</option>
						<option value="2330">11:30 PM</option>
						<option value="2400">12:00 AM</option>
						<option value="2430">12:30 AM</option>
						<option value="0100">1:00 AM</option>
						<option value="0130">1:30 AM</option>
					</select>
				</p>
				<div class="err-msg">
					<ul></ul>
				</div>
				<p class="note">
					<span><spring:message code="refill.request.note.label" /></span>
					<spring:message code="refill.request.delivery.charges.note.text" />
				</p>
				<label><spring:message code="refill.request.comments.label" /><br>
					<textarea name="comments" maxlength="1024"></textarea> </label>
			</div>
		</div>
		<input id="deliveryPhoneNumber" name="deliveryPhoneNumber"
			value="${entityPatient.deliveryPhoneNumber}" type="hidden" /> <input
			id="patientOID" name="patientOID" value="${entityPatient.oid}"
			type="hidden" /> <input id="eProvince" name="eProvince"
			value="${entityPatient.EProvince}" type="hidden" />
		<h2 class="subhead">
			<spring:message code="refill.request.notification.label" />
		</h2>
		<p>
			<c:choose>
				<c:when test="${userRole eq 'Caregivers' }">
					<spring:message code="refill.notification.caregiver.msg" />
				</c:when>
				<c:otherwise>
					<spring:message code="refill.notification.msg" />
				</c:otherwise>
			</c:choose>
		</p>

		<div class="refill-notify">
			<c:if test="${userRole eq 'Caregivers' }">
				<div class="checkbox-item">
					<label> <input type="checkbox" name="emailnotify"
						value="${account}"> <spring:message
							code="refill.request.notify.email.label" /> <c:out
							value="${account}" /> <input id="email" name="email"
						value="${account}" type="hidden" />
					</label>
				</div>
			</c:if>
			<c:if test="${userRole ne 'Caregivers' }">
				<div class="checkbox-item">
					<label> <c:choose>
							<c:when test="${not empty account}">
								<c:if test="${not empty emailStatus}">
									<c:choose>
										<c:when
											test="${emailStatus=='OK'||emailStatus=='Ok'||emailStatus=='ok'}">
											<input type="checkbox" name="emailnotify">
											<spring:message code="refill.request.notify.email.label" />
											<strong>${account}</strong>&nbsp;&nbsp;<spring:message
												code="refill.reminder.email.change.notification.text" />
											<input id="email" name="email" value="${account}"
												type="hidden" />
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

				<div class="checkbox-item">
					<label> <c:choose>
							<c:when test="${not empty mobileNumber}">
								<c:if test="${not empty mobileStatus}">
									<c:choose>
										<c:when test="${mobileStatus== 0}">
											<input type="checkbox" name="phonenotify">
											<spring:message code="refill.request.notify.mobile.label" />
                                                <strong>${fn:substring(mobileNumber, 0, 3)}-${fn:substring(mobileNumber, 3, 6)}-${fn:substring(mobileNumber, 6, 10)}</strong>
                                        
                                  		 <input type="hidden" name="mobile"
												id="mobile" value="${mobileNumber}">
												<input id="phone" name="phoneNo" value="${mobileNumber}" type="hidden" />
										</c:when>
										<c:when test="${mobileStatus== 1}">
											<input type="checkbox" name="phonenotify" disabled>
											<spring:message code="refill.request.notify.mobile.label" />

											<spring:message
												code="refill.request.notify.phonenumber.unchecked" />
										</c:when>
										<c:when test="${mobileStatus== 2}">
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


			<!--  phone section for refill request -->
			<c:if test="${empty refillType}">
				<h4 class="title">
					<spring:message code="refill.request.contactme.label" />
				</h4>
				<div class="mob-div">
					<label class="phone-item"> <spring:message
							code="refill.request.notify.phone.label" /> <c:if
							test="${userRole eq 'Caregivers' }">
							<input class="phone-field" type="text" value="" name="phone"
								maxlength="12" numeric="true"
								data-msg-numeric="<spring:message code="refill.request.phonenumber.err.msg" />">
						</c:if> <c:if test="${userRole ne 'Caregivers' }">
							<c:if test="${not empty entityPatient}">
								<input class="phone-field" type="text"
									value="${entityPatient.phoneNumber}" name="phone"
									maxlength="12" numeric="true"
									data-msg-numeric="<spring:message code="refill.request.phonenumber.err.msg" />">
							</c:if>
						</c:if>

					</label>
				</div>
				<div class="clearBoth">
					<c:if test="${userRole ne 'Caregivers' }">
						<p>
							<spring:message code="refill.request.phonenumber.update.note" />
							<strong><spring:message
									code="refill.request.phonenumber.equipped.note" /></strong>
						</p>
					</c:if>
					<c:if test="${userRole eq 'Caregivers' }">
						<p>
							<spring:message
								code="refill.request.phonenumber.caregiver.update.note" />
						</p>
					</c:if>

				</div>
				<div class="mob-div refillreq-mob-div"></div>
			</c:if>
		</div>


		<input id="patientDefaultPharmacy" name="patientDefaultPharmacy"
			value="${pharmaStores.pharmaVO.storeId}" type="hidden" />

		<div class="form-footer form-footer-refill">
			<button type="submit" class="button-erefill green refill-submit"
				disabled="true">
				<spring:message code="refill.request.submit.label" />
			</button>
		</div>
		<c:if test="${not empty operatingHours}">
			<input type="hidden" id="operatingHours" value='${operatingHours}' />
		</c:if>
		<input type="hidden" id="rxReq" name="rxReq" />


	</form>

	<form class="form-footer-normal-refill-cancel" method="POST"
		action="${contextPath}/${locale}/prescription/details">
		<button type="submit" class="cancel">
			<spring:message code="refill.cancel.label" />
		</button>
		<input type="hidden" id="page_num" value='${page_num}' name="page_num" />
		<csrf:csrfToken />
	</form>

</div>
