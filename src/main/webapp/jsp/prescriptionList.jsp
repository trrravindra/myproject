<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="com.lcl.erefill.core.constants.ERefillConstants"%>
<table class="prescription-list">
	<c:choose>
		<c:when test="${not empty lstPresc}">
			<c:forEach items="${lstPresc}" var="presc" varStatus="i">
				<c:if
					test="${fn:length(refillDate) gt i.index && not empty refillDate[i.index]}">
					<c:set var="refillDt" value="${refillDate[i.index]}" />
				</c:if>

				<c:if test="${not empty autoRefillOids[i.index]}">
					<c:set var="autoRefillOid" value="${autoRefillOids[i.index]}" />
				</c:if>

				<c:if test="${not empty refillReminderOids[i.index]}">
					<c:set var="refillReminderOid"
						value="${refillReminderOids[i.index]}" />
				</c:if>

				<c:set var="automatedRefill" value="false" />
				<c:forEach var="item" items="${automatedRefills}">
					<c:if test="${item eq presc.originalOID}">
						<c:set var="automatedRefill" value="true" />
					</c:if>
				</c:forEach>

				<c:set var="refillReminder" value="false" />
				<c:forEach var="item" items="${refillReminders}">
					<c:if test="${item eq presc.originalOID}">
						<c:set var="refillReminder" value="true" />
					</c:if>
				</c:forEach>

				<c:set var="expired" value="false" />
				<c:if test="${fn:contains(presc.estimatedFillDate, 'EXPIRED')}">
					<c:set var="expired" value="true" />
				</c:if>

				<tr class="${i.index % 2 == 0 ? 'remove-row' : 'alt remove-row'}">
					<td colspan="4">
						<div class="note">
							<c:choose>
								<c:when test="${automatedRefill eq true}">
									<spring:message
										code="my.prescriptions.auto.refill.notification.label" /> ${presc.nextExpectedDate}
								</c:when>
								<c:otherwise>
									<c:if test="${refillReminder eq true}">
										<spring:message
											code="my.prescriptions.refill.reminder.notification.label" />
									</c:if>
								</c:otherwise>
							</c:choose>
						</div>
					</td>
				</tr>

				<tr class="${i.index%2 == 0 ? '' : 'alt'}">
					<c:choose>
						<c:when test="${not presc.refillAllowed}">
							<td><input id="${presc.prescOID }" name="${presc.prescOID }"
								type="checkbox" value="true" disabled="true" /></td>
						</c:when>
						<c:otherwise>
							<td><input id="${presc.prescOID }" name="${presc.prescOID }"
								type="checkbox" value="true" /></td>
						</c:otherwise>
					</c:choose>
					<th>
						<div class="medication-info">
							<a href="#" class="drug-info-modal" data-drug-id="${presc.DIN}"
								data-modal="${contextPath}/${locale}/orderhistory/drugdetails"
								data-print="<spring:message	code="print.label"/>"> <span>${presc.name}</span>
								-<br />${presc.genericName}
							</a>
							<c:if test="${not empty presc.strength}"> (${presc.strength}) </c:if>
							<br /> <span><spring:message code="rx.label" />#${presc.rxNumber}</span><br />

							<a href="#" class="modal refill-history post-data"
								data-modal="${contextPath}/${locale}/user/refillHistory/1&&&${presc.prescOID}">
								<spring:message code="refill.history.title" />
							</a>

							<div class="presc-details prescription-wrap">
								<dl>
									<c:if test="${not empty presc.expirationDate}">
										<c:if test="${not empty presc.remainingQuantity}">
											<c:if test="${not empty presc.remainigRefills}">
												<%-- <dt><spring:message code="my.prescriptions.refill.history.label" />:</dt>
												<dd>${presc.remainingQuantity}</dd>
												<dt> <spring:message code="my.prescriptions.drug.quantity.label" />	:</dt>
												<dd>${presc.remainigRefills}</dd> --%>

												<dt>
													<spring:message code="my.prescriptions.drug.quantity.label" />
													:
												</dt>
												<dd>${presc.remainingQuantity}</dd>
												<dt>
													<spring:message
														code="my.prescriptions.refills.remaining.label" />
													:
												</dt>
												<dd>${presc.remainigRefills}</dd>
												<dt>
													<spring:message
														code="my.prescriptions.refillable.upto.label" />
													:
												</dt>
												<dd>${presc.expirationDate}</dd>
											</c:if>
											<c:if test="${empty presc.remainigRefills}">
												<%-- <dt>	<spring:message	code="my.prescriptions.refill.history.label" />:</dt>
												<dd>${presc.remainingQuantity}</dd> --%>

												<dt>
													<spring:message code="my.prescriptions.drug.quantity.label" />
													:
												</dt>
												<dd>${presc.remainingQuantity}</dd>
												<dt>
													<spring:message
														code="my.prescriptions.refillable.upto.label" />
													:
												</dt>
												<dd>${presc.expirationDate}</dd>
											</c:if>
										</c:if>
										<c:if test="${empty presc.remainingQuantity}">
											<c:if test="${not empty presc.remainigRefills}">
												<%-- <dt>	<spring:message code="my.prescriptions.drug.quantity.label" />:	</dt>
												<dd>${presc.remainigRefills}</dd> --%>

												<dt>
													<spring:message
														code="my.prescriptions.refills.remaining.label" />
													:
												</dt>
												<dd>${presc.remainigRefills}</dd>
												<dt>
													<spring:message
														code="my.prescriptions.refillable.upto.label" />
													:
												</dt>
												<dd>${presc.expirationDate}</dd>
											</c:if>
											<c:if test="${empty presc.remainigRefills}">
												<dt>
													<spring:message
														code="my.prescriptions.refillable.upto.label" />
													:
												</dt>
												<dd>${presc.expirationDate}</dd>
											</c:if>
										</c:if>
									</c:if>
									<c:if test="${empty presc.expirationDate}">
										<c:if test="${empty presc.remainingQuantity}">
											<c:if test="${empty presc.remainigRefills}">
												<dt>
													<spring:message code="my.prescriptions.drug.quantity.label" />
													:
												</dt>
												<dd>-</dd>
											</c:if>
											<c:if test="${not empty presc.remainigRefills}">
												<%-- <dt><spring:message code="my.prescriptions.drug.quantity.label" />	:</dt>
												<dd>${presc.remainigRefills}</dd> --%>

												<dt>
													<spring:message
														code="my.prescriptions.refills.remaining.label" />
													:
												</dt>
												<dd>${presc.remainigRefills}</dd>
											</c:if>
										</c:if>
										<c:if test="${not empty presc.remainingQuantity}">
											<c:if test="${empty presc.remainigRefills}">
												<dt>
													<spring:message code="my.prescriptions.drug.quantity.label" />
													:
												</dt>
												<dd>${presc.remainingQuantity}</dd>
											</c:if>
											<c:if test="${not empty presc.remainigRefills}">
												<%-- <dt>	<spring:message	code="my.prescriptions.refill.history.label" />	:</dt>
												<dd>${presc.remainingQuantity}</dd>
												<dt><spring:message code="my.prescriptions.drug.quantity.label" />:	</dt>
												<dd>${presc.remainigRefills}</dd> --%>

												<dt>
													<spring:message code="my.prescriptions.drug.quantity.label" />
													:
												</dt>
												<dd>${presc.remainingQuantity}</dd>
												<dt>
													<spring:message
														code="my.prescriptions.refills.remaining.label" />
													:
												</dt>
												<dd>${presc.remainigRefills}</dd>
											</c:if>
										</c:if>
									</c:if>

									<dt>
										<spring:message code="my.prescriptions.last.filled.label" />
										:
									</dt>
									<dd>${presc.lastFilledDate}</dd>

									<dt>
										<spring:message
											code="my.prescriptions.est.next.fill.date.label" />
										:
									</dt>
									<dd>${presc.estimatedFillDate}</dd>

									<dt>
										<spring:message code="my.prescriptions.prescribed.by.label" />
										:
									</dt>
									<dd>${presc.prescriberFirstName}&nbsp;${presc.prescriberLastName}</dd>
								</dl>
							</div>
							<div class="presc-instructions prescription-wrap">
								<c:choose>
									<c:when test="${fn:length(presc.sigDecoded) > 45}">
										<c:set var="sig"
											value="${fn:substring(presc.sigDecoded, 0, 45)}" />
										<p>
											${fn:substring(presc.sigDecoded, 0, 45)} &nbsp; <a href="#"
												class="populate-pres-instructions-modal"
												data-name="${presc.name}" data-strength="${presc.strength}"
												data-sigdecoded="${presc.sigDecoded}"
												data-modal="${contextPath}/${locale}/prescription/instructions">
												<spring:message code="more.label" />
											</a>
										</p>
									</c:when>
									<c:otherwise>
										<p>${presc.sigDecoded}</p>
										<c:set var="sig" value="${presc.sigDecoded}" />
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</th>

					<td>
						<div class="medication-refill">
							<c:choose>
								<c:when test="${automatedRefill eq true}">
									<p>
										<!-- <a class="populate-pres-stop-autorefill-modal" data-oid="${autoRefillOid}" data-name="${presc.name}" data-genericname="${presc.genericName}"
										data-strength="${presc.strength}" data-quantityfilled="${presc.quantityFilled}" data-rxnumber="${presc.rxNumber}"
											data-modal="/lcl-erefill-services/${locale}/autorefill/stop/confirm"
											href="#">  -->

										<a class="populate-pres-stop-autorefill-modal"
											data-oid="${autoRefillOid}" data-name="${presc.name}"
											data-strength="${presc.strength}"
											data-quantityfilled="${presc.quantityFilled}"
											data-sig="${sig}"
											data-modal="${contextPath}/${locale}/autorefill/stop/confirm"
											href="#"> <spring:message
												code="my.prescriptions.auto.refill.stop.label" /></a>
									</p>
									<p>
										<spring:message
											code="my.prescriptions.auto.refill.reminder.label" />
										<a class="modal"
											data-modal="${contextPath}/${locale}/autorefill/reminder/update/${autoRefillOid}"
											href="#"> <spring:message
												code="my.prescriptions.auto.refill.reminder.update.label" /></a>
									</p>
								</c:when>
								<c:otherwise>
									<label class="radio-item" for="setRefillRemind-${presc.prescOID}"> <c:choose>
											<c:when test="${refillReminder eq true}">
												<input type="radio" id="setRefillRemind-${presc.prescOID}" name="refillType"
													value="stop-reminders"
													<c:if test="${presc.refillReminderAllowed eq 0 || presc.narcotic}">disabled</c:if>>

												<spring:message
													code="my.prescriptions.stop.refill.reminders.label" />

												<span class="tooltip" aria-describedby="reminderTip"
													tabIndex="0"> <img
													src="<c:url value='/resources/images/erefill/icon-tooltip.png'/>"
													alt="tooltip"> <span class="tooltip-content"
													id="reminderTip">
														<h3>
															<spring:message
																code="my.prescriptions.stop.refill.reminder.tooltip.heading.label" />
														</h3>
														<p>
															<spring:message
																code="my.prescriptions.stop.refill.reminder.tooltip.text" />
														</p>
												</span>
												</span>
											</c:when>
											<c:otherwise>
												<input type="radio" id="setRefillRemind-${presc.prescOID}" name="refillType"
													value="<%=ERefillConstants.REFILL_REMINDER_REQUEST%>&&&${presc.prescOID}"
													<c:if test="${presc.refillReminderAllowed eq 0 || presc.narcotic}">disabled</c:if>>
												<spring:message
													code="my.prescriptions.set.refill.reminders.label" />

												<span class="tooltip" aria-describedby="reminderTip"
													tabIndex="0"><img
													src="<c:url value='/resources/images/erefill/icon-tooltip.png'/>"
													alt="tooltip"> <span class="tooltip-content"
													id="reminderTip">
														<h3>
															<spring:message
																code="my.prescriptions.set.refill.reminder.tooltip.heading.label" />
														</h3>
														<p>
															<spring:message
																code="my.prescriptions.set.refill.reminder.tooltip.text" />
														</p>
												</span> </span>
											</c:otherwise>
										</c:choose>
									</label>

									<label class="radio-item" for="setRefillAuto-${presc.prescOID}"> <input
										type="radio" id="setRefillAuto-${presc.prescOID}" name="refillType"
										value="<%=ERefillConstants.AUTO_REFILL_REQUEST%>&&&${presc.prescOID }"
										<c:if test="${presc.automatedRefillAllowed eq 0 || presc.narcotic}">disabled</c:if>>
										<spring:message code="my.prescriptions.set.auto.refill.label" />

										<span class="tooltip" aria-describedby="autoTip" tabIndex="0"><img
											src="<c:url value='/resources/images/erefill/icon-tooltip.png'/>"
											alt="tooltip"> <span class="tooltip-content"
											id="autoTip">
												<h3>
													<spring:message
														code="my.prescriptions.set.auto.refill.tooltip.heading.label" />
												</h3>
												<p>
													<spring:message
														code="my.prescriptions.set.auto.refill.tooltip.text" />
												</p>
										</span> </span>
									</label>

									<div class="btn-wrap">
										<c:choose>
											<c:when test="${refillReminder eq true}">
												<button type="submit"
													class="button-erefill green refill-submit for-overlay populate-pres-stop-refillreminder-modal "
													data-name="${presc.name}" data-oid="${refillReminderOid}"
													data-strength="${presc.strength}"
													data-quantityfilled="${presc.quantityFilled}"
													data-sig="${presc.sigDecoded}"
													data-modal="${contextPath}/${locale}/autorefill/reminder/stop/confirm/${reminderstopconfirmurl}"
													disabled>
													<spring:message code="go.label" />
												</button>
												<button type="submit"
													class="button-erefill green refill-submit for-submit hidego no-click-button"
													data-est-refill-date-en="${presc.estimatedFillDateEn}"
													disabled>
													<spring:message code="go.label" />
												</button>
											</c:when>
											<c:otherwise>
												<button type="submit"
													class="button-erefill green refill-submit no-click-button"
													data-est-refill-date-en="${presc.estimatedFillDateEn}"
													disabled>
													<spring:message code="go.label" />
												</button>
											</c:otherwise>
										</c:choose>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</td>
				</tr>
				<%-- <c:if
					test="${presc.refillAllowed && presc.noRefill || presc.narcotic || presc.controlled ||
					(presc.remainigRefills == 0  && empty presc.expirationDate && empty presc.remainingQuantity)}"> --%>


				<c:if
					test="${(presc.refillAllowed && presc.noRefill || presc.narcotic || presc.controlled) ||
					(presc.remainigRefills == 0  || presc.remainingQuantity == 0)}">



					<tr class="${i.index % 2 == 0 ? 'note-row' : 'note-row alt'}">
						<td></td>
						<td colspan="2">
							<div class="presc-instructions">
								<p class="note">
									<span> <spring:message code="refill.request.note.label" />
									</span>
									<c:if
										test="${(presc.refillAllowed && presc.noRefill) || (presc.remainigRefills == 0) || (presc.remainingQuantity==0)}">
										<spring:message code="my.prescriptions.refill.nill.text" />
									</c:if>
									<c:if test="${!presc.refillAllowed && presc.narcotic}">
										<spring:message code="my.prescriptions.narcotic.note.text" />
									</c:if>
									<c:if test="${!presc.refillAllowed && presc.controlled}">
										<spring:message code="my.prescriptions.controlled.note.text" />
									</c:if>
									<c:if
										test="${empty presc.remainigRefills && empty presc.expirationDate && empty presc.remainingQuantity}">
										<spring:message code="my.prescriptions.no.fields.label" />
									</c:if>
								</p>
							</div>
						</td>
						<td></td>
					</tr>
				</c:if>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td><spring:message code="my.prescriptions.no.records.found" /></td>
			</tr>
		</c:otherwise>
	</c:choose>
</table>