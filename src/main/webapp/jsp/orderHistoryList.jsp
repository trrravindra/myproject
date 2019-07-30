<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:choose>
	<c:when test="${not empty mpRefill}">
		<c:forEach items="${mpRefill}" var="refill" varStatus="alt">
			<c:choose>
				<c:when test='${alt.index mod 2 eq 0}'>
					<div class="order-history-row alt">
						<div class="order-history-date">
							<h4 class="title">${refill.key}</h4>
							(${fn:length(refill.value)}
							<spring:message code="prescriptions.text" />
							)
						</div>
						<div class="order-history-items">
							<table>
								<c:forEach items="${refill.value}" var="presc">
									<tr>
										<th><a data-print="<spring:message code="print.label" />"
											data-drug-id="${presc.prescriptionsVO.productDIN}" href="#"
											data-modal="${contextPath}/${locale}/orderhistory/drugdetails"
											class="drug-info-modal"> <span>${presc.prescriptionsVO.medicineName}</span>
												- ${presc.prescriptionsVO.productForm}
										</a> <br>(<spring:message code="rx.label" />
											#${presc.prescriptionsVO.rxNumber})</th>
										<td class="order-qty"><spring:message
												code="order.history.quantity" /> <span>${presc.prescriptionsVO.quantityFilled}</span></td>
										<td><span class="submitted-by"><spring:message
													code="submitted.by" /><br>
												${presc.accountCreatorVO.accountCreatorFirstName}
												${presc.accountCreatorVO.accountCreatorLastName}</span></td>
										<c:choose>
											<c:when
												test="${presc.prescriptionsVO.lastState == 'Declined' || presc.prescriptionsVO.lastState == 'Rejected'}">
												<td class="order-status"><span class="status-rejected"><spring:message
															code="declined.text" /></span></td>
												<c:if
													test="${not empty presc.prescriptionsVO.pharmacistComments}">
													<tr class="rejection-note-row">
														<td colspan="4"><div class="rejection-note">${presc.prescriptionsVO.pharmacistComments}</div></td>
													</tr>
												</c:if>
											</c:when>
											<c:otherwise>
												<c:if test="${presc.prescriptionsVO.lastState == 'Pending'}">
													<td class="order-status"><spring:message
															code="pending.text" /></td>
												</c:if>
												<c:if
													test="${presc.prescriptionsVO.lastState == 'Received'}">
													<td class="order-status"><spring:message
															code="received.text" /></td>
												</c:if>
												<c:if
													test="${presc.prescriptionsVO.lastState == 'Accepted'}">
													<td class="order-status"><spring:message
															code="accepted.text" /></td>
												</c:if>
												<c:if
													test="${presc.prescriptionsVO.lastState == 'AcceptedWithoutInfo'}">
													<td class="order-status"><spring:message
															code="accepted.without.info.text" /></td>
												</c:if>
												<c:if test="${presc.prescriptionsVO.lastState == 'None'}">
													<td class="order-status"><spring:message
															code="none.text" /></td>
												</c:if>
												<c:if
													test="${presc.prescriptionsVO.lastState == 'ReceivedETARequired'}">
													<td class="order-status"><spring:message
															code="received.eta.required.text" /></td>
												</c:if>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="order-history-row">
						<div class="order-history-date">
							<h4 class="title">${refill.key}</h4>
							(${fn:length(refill.value)}
							<spring:message code="prescriptions.text" />
							)
						</div>
						<div class="order-history-items">
							<table>
								<c:forEach items="${refill.value}" var="presc">
									<tr>
										<th>
											<%-- <a href="#" class="modal" data-modal=""data-print="<spring:message code="print.label" />"> --%>
											<a data-print="<spring:message code="print.label" />"
											data-drug-id="${presc.prescriptionsVO.productDIN}" href="#"
											data-modal="${contextPath}/${locale}/orderhistory/drugdetails"
											class="drug-info-modal"> <span>${presc.prescriptionsVO.medicineName}</span>
												- ${presc.prescriptionsVO.productForm}
										</a> <br>(<spring:message code="rx.label" />
											#${presc.prescriptionsVO.rxNumber})
										</th>
										<td class="order-qty"><spring:message
												code="order.history.quantity" /> <span>${presc.prescriptionsVO.quantityFilled}</span></td>
										<td><span class="submitted-by"><spring:message
													code="submitted.by" /><br>
												${presc.accountCreatorVO.accountCreatorFirstName}
												${presc.accountCreatorVO.accountCreatorLastName}</span></td>
										<c:choose>
											<c:when
												test="${presc.prescriptionsVO.lastState=='Declined'|| presc.prescriptionsVO.lastState== 'Rejected'}">
												<td class="order-status"><span class="status-rejected"><spring:message
															code="declined.text" /></span></td>
												<c:if
													test="${not empty presc.prescriptionsVO.pharmacistComments}">
													<tr class="rejection-note-row">
														<td colspan="4"><div class="rejection-note">${presc.prescriptionsVO.pharmacistComments}</div></td>
													</tr>
												</c:if>
											</c:when>
											<c:otherwise>
												<c:if test="${presc.prescriptionsVO.lastState == 'Pending'}">
													<td class="order-status"><spring:message
															code="pending.text" /></td>
												</c:if>
												<c:if
													test="${presc.prescriptionsVO.lastState == 'Received'}">
													<td class="order-status"><spring:message
															code="received.text" /></td>
												</c:if>
												<c:if
													test="${presc.prescriptionsVO.lastState == 'Accepted'}">
													<td class="order-status"><spring:message
															code="accepted.text" /></td>
												</c:if>
												<c:if
													test="${presc.prescriptionsVO.lastState == 'AcceptedWithoutInfo'}">
													<td class="order-status"><spring:message
															code="accepted.without.info.text" /></td>
												</c:if>
												<c:if test="${presc.prescriptionsVO.lastState == 'None'}">
													<td class="order-status"><spring:message
															code="none.text" /></td>
												</c:if>
												<c:if
													test="${presc.prescriptionsVO.lastState == 'ReceivedETARequired'}">
													<td class="order-status"><spring:message
															code="received.eta.required.text" /></td>
												</c:if>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:when>
	<c:otherwise>
		<spring:message code="order.history.no.results.text" />
	</c:otherwise>
</c:choose>

