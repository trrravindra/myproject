<%@ include file="global.jsp"%>

<div class="refill-history" role="dialog" tabIndex="0"
	aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
	<div class="header">
		<img class="refill-img" src="${refillDrugInfo.imageURL}">
		<h1 class="title" id="overlayTitle">
			${refillDrugHeader.name} <span> <c:choose>
					<c:when test="${not empty refillDrugHeader}">
				- ${refillDrugHeader.genericName}
		</c:when>
				</c:choose> <c:choose>
					<c:when test="${not empty refillDrugHeader}">
				(${refillDrugHeader.strength})
		</c:when>
				</c:choose>
			</span><br />
			<spring:message code="my.prescriptions.refill.history.label" />
		</h1>
	</div>
	<div class="inner-content" id="overlayDesc">
		<p>
			<strong><spring:message code="refill.request.note.label" /></strong>
		<p>
			<spring:message var="tempVar"
				code="my.prescriptions.refill.history.note" />

			<c:set var="tempVar"
				value="${fn:replace(tempVar,'RX_NUMBER',refillDrugHeader.rxNum)}" />
			${tempVar} <a class="no-click"
				href="${contextPath}/${locale}/mymedicationrecord"><spring:message
					code="my.medication.record.title" /></a>.<br>
		</p>
		</p>

		<p>
			<strong><spring:message
					code="my.prescriptions.instructions.label" />:</strong>
			${refillDrugHeader.instructions}
		</p>

		<table>
			<c:choose>
				<c:when test="${not empty refillList}">
					<tr>
						<th><spring:message
								code="my.prescriptions.filled.column.label" /></th>
						<th><spring:message
								code="my.prescriptions.quantity.column.label" /></th>
						<th><spring:message
								code="my.prescriptions.days.supply.column.label" /></th>
					</tr>
					<c:forEach items="${refillList}" var="presc" varStatus="i">
						<tr class="${i.count%2 == 0 ? '' : 'alt'}">
							<td>${presc.histLastFillDate}</td>
							<td>${presc.quantityFilled}</td>
							<td>${presc.daysSupply}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="3" class="ctrl-wrap ctrl-bottom">
							<nav class="pagination">
								<c:if test="${not empty numOfPages && numOfPages gt 1}">
									<c:set var="wasurl"
										value='${contextPath}/${locale}/user/refillHistory' />
									<spring:message code="page.label" />
									<c:choose>
										<c:when test="${numOfPages != 1}">
											<a href="#" class="prev" title="Previous Page"
												data-url="${wasurl}/${(pageNum - 1)}&&&${prescOID}"><spring:message
													code="previous.page.label" /></a>
										</c:when>
										<c:otherwise>
											<span class="prev disabled" title="Previous Page"><spring:message
													code="previous.page.label" /></span>
										</c:otherwise>
									</c:choose>
									<ol>
										<c:forEach var="i" begin="0" end="${(numOfPages - 1)}">
											<c:choose>
												<c:when test="${i eq (pageNum - 1) }">
													<li>${pageNum}</li>
												</c:when>
												<c:otherwise>
													<li><a href="#"
														data-url="${wasurl}/${(i + 1)}&&&${prescOID}"
														id="${(i + 1)}">${(i + 1)}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</ol>
									<c:choose>
										<c:when test="${pageNum ne numOfPages}">
											<a href="#" class="next" title="Next Page"
												data-url="${wasurl}/${(pageNum + 1)}&&&${prescOID}"><spring:message
													code="next.page.text" /></a>
										</c:when>
										<c:otherwise>
											<span class="next disabled" title="Next Page"><spring:message
													code="next.page.text" /></span>
										</c:otherwise>
									</c:choose>
								</c:if>
							</nav>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<th><spring:message
								code="my.prescriptions.no.refill.history.text" /></th>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</div>