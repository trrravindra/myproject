<%@ include file="global.jsp"%>
<script id="require-js" data-path="<c:url value='/static/global.html'/>"
	data-main="<c:url value='/resources/js/erefill-my-prescriptions'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>

<c:set var="wasurl"
	value='${contextPath}/${locale}/prescription/details' />

<div class="content">
	<c:choose>
		<c:when test="${isLoggedInUser}">
			<h1 class="title">
				<spring:message code="my.prescriptions.page.title.label" />
			</h1>
		</c:when>
		<c:otherwise>
			<h1 class="title">
				<spring:message
					code="my.prescriptions.page.impersonated.user.title.label" />
				<div class="impersonatedTitle"></div>
			</h1>
		</c:otherwise>
	</c:choose>

	<div class="ctrl-wrap">
		<div class="err-msg">
			<ul></ul>
		</div>
		<c:set var="alldaysFilter" value="<%=ERefillConstants.ALL_DAYS%>" />
		<c:set var="days30Filter" value="<%=ERefillConstants.LAST_30_DAYS %>" />
		<c:set var="days90Filter" value="<%=ERefillConstants.LAST_90_DAYS %>" />
		<c:set var="days180Filter"
			value="<%=ERefillConstants.LAST_180_DAYS %>" />
		<c:set var="lastFilled"
			value="<%=ERefillConstants.LAST_FILLED_DATE %>" />
		<c:set var="nextFill" value="<%=ERefillConstants.NEXT_FILL_DATE %>" />
		<c:set var="medication" value="<%=ERefillConstants.MEDICATION_NAME %>" />


		<form class="uniform form-range-filter"
			action="${contextPath}/${locale}/prescription/details" method="POST"
			data-cal-enable="<c:url value='/resources/images/erefill/icon-calendar.png'/>">
			<input type="hidden" name="selectedPatientOid" value="" />
			<div class="show-range select-range">
				<!-- Show/select range form -->

				<label for="date_range"> <spring:message code="show.label" />
					<!-- Form will auto-submit when value selected --> <select
					class="myPres-submit-on-change1" name="date_range" id="date_range">
						<c:choose>
							<c:when
								test="${not empty dateFilter && dateFilter eq alldaysFilter || not empty fromDate && not empty toDate}">
								<option value="all" selected="selected"><spring:message
										code="all.dates.text" /></option>
							</c:when>
							<c:otherwise>
								<option value="all"><spring:message
										code="all.dates.text" /></option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when
								test="${not empty dateFilter && dateFilter eq days30Filter || not empty fromDate && not empty toDate}">
								<option value="30" selected="selected"><spring:message
										code="last.text" /> 30
									<spring:message code="days.text" /></option>
							</c:when>
							<c:otherwise>
								<option value="30"><spring:message code="last.text" />
									30
									<spring:message code="days.text" /></option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when
								test="${not empty dateFilter && dateFilter eq days90Filter || not empty fromDate && not empty toDate}">
								<option value="90" selected="selected"><spring:message
										code="last.text" /> 90
									<spring:message code="days.text" /></option>
							</c:when>
							<c:otherwise>
								<option value="90"><spring:message code="last.text" />
									90
									<spring:message code="days.text" /></option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when
								test="${not empty dateFilter && dateFilter eq days180Filter || not empty fromDate && not empty toDate}">
								<option value="180" selected="selected"><spring:message
										code="last.text" /> 180
									<spring:message code="days.text" /></option>
							</c:when>
							<c:otherwise>
								<option value="180"><spring:message code="last.text" />
									180
									<spring:message code="days.text" /></option>
							</c:otherwise>
						</c:choose>
				</select>
				</label> <label for="from"><spring:message
						code="my.prescriptions.from.label" /><input
					title="<spring:message code="from.label" />" type="text"
					class="date-from date-picker" id="from" name="from"
					value="${fromDate}"
					data-msg-required="<spring:message code="my.prescriptions.dates.required.errMsg" />"
					data-msg-malformed-date="<spring:message code="my.prescriptions.dates.format.errMsg" />"
					placeholder="<spring:message code="date.format"/>" maxlength="10" />
				</label> <label for="to"><spring:message
						code="my.prescriptions.to.label" /> <input
					title="<spring:message code="to.label" />" type="text"
					class="date-to date-picker" id="to" name="to" value="${toDate}"
					data-msg-required="<spring:message code="my.prescriptions.dates.required.errMsg" />"
					data-msg-malformed-date="<spring:message code="my.prescriptions.dates.format.errMsg" />"
					placeholder="<spring:message code="date.format"/>" maxlength="10" />
				</label> <input type="hidden" name="page_num" id="page_num"
					value="${pageNum}" /> <input type="hidden" name="orderInfo"
					id="orderInfo" value="" />

				<c:choose>
					<c:when test="${not empty chkdPresc && null ne chkdPresc}">
						<input type="hidden" name="chkdPresc" id="chkdPresc"
							value="${chkdPresc}" />
					</c:when>
					<c:otherwise>
						<input type="hidden" name="chkdPresc" id="chkdPresc" value="" />
					</c:otherwise>
				</c:choose>

				<input type="hidden" name="removedOrderInfo" id="removedOrderInfo"
					value="" />
				<button type="submit">
					<spring:message code="view.label" />
				</button>
				<!-- End of Show/select range form -->
			</div>
			<div class="sorting">
				<!-- Sort by form -->

				<label for="sort_by"> <spring:message code="sort.by.label" />
					<!-- Form will auto-submit when value selected --> <select
					class="myPres-submit-on-change" id="sort_by" name="sort_by">
						<c:choose>
							<c:when test="${sortFilter eq  lastFilled}">
								<option value="last-filled" selected="selected"><spring:message
										code="last.filled.date.text" /></option>
							</c:when>
							<c:otherwise>
								<option value="last-filled"><spring:message
										code="last.filled.date.text" /></option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${sortFilter eq  nextFill}">
								<option value="next-filled" selected="selected"><spring:message
										code="estimated.next.fill.date" /></option>
							</c:when>
							<c:otherwise>
								<option value="next-filled"><spring:message
										code="estimated.next.fill.date" /></option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${sortFilter eq  medication}">
								<option value="name" selected="selected"><spring:message
										code="medication.name.text" /></option>
							</c:when>
							<c:otherwise>
								<option value="name"><spring:message
										code="medication.name.text" /></option>
							</c:otherwise>
						</c:choose>
				</select>
				</label>
			</div>
			<csrf:csrfToken />
		</form>
		<div class="results">

			<c:choose>
				<c:when test="${not empty lstPresc}">
					<spring:message code="viewing.label" />&nbsp;${firstRecord} - ${fn:length(lstPresc) + firstRecord - 1} &nbsp;<spring:message
						code="of.label" />&nbsp;${totalRecords}
				</c:when>
				<c:otherwise>
					<spring:message code="viewing.label" />&nbsp;${firstRecord} - ${totalRecords} &nbsp;<spring:message
						code="of.label" />&nbsp;${totalRecords}
				</c:otherwise>
			</c:choose>
		</div>
	</div>


	<form class="uniform form-prescriptions"
		action="${contextPath}/${locale}/refillrequest/view" method="post">
		<button type="submit"
			class="button-erefill green refill-submit no-click-button normal-refill-submit">
			<spring:message code="my.prescriptions.refill.selected.presc.label" />
		</button>

		<input type="hidden" name="page_num" id="page_num" value="${pageNum}" />

		<%@include file="prescriptionList.jsp"%>

		<div class="form-footer">
			<button type="submit"
				class="button-erefill green refill-submit no-click-button normal-refill-submit">
				<spring:message code="my.prescriptions.refill.selected.presc.label" />
			</button>
			<div class="ctrl-wrap ctrl-bottom">
				<nav class="pagination">

					<c:if test="${not empty numOfPages && numOfPages gt 1}">
						<spring:message code="page.label" />
						<c:choose>
							<c:when test="${pageNum != 1 }">
								<a href="${wasurl}" id="prev_${(pageNum - 1)}" class="prev"
									title="Previous Page">${(pageNum - 1)}</a>
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
										<li><strong>${pageNum}</strong></li>
									</c:when>
									<c:otherwise>
										<li><a href="${wasurl}" id="${(i + 1)}">${(i + 1)}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ol>
						<c:choose>
							<c:when test="${pageNum ne numOfPages}">
								<a href="${wasurl}" id="next_${(pageNum + 1)}" class="next"
									title="Next Page">${(pageNum + 1)}</a>
							</c:when>
							<c:otherwise>
								<span class="next disabled" title="Next Page"><spring:message
										code="next.page.text" /></span>
							</c:otherwise>
						</c:choose>
					</c:if>
				</nav>
				<div class="results">
					<c:choose>
						<c:when test="${not empty lstPresc}">
							<spring:message code="viewing.label" />&nbsp;${firstRecord} - ${fn:length(lstPresc) + firstRecord - 1} &nbsp;<spring:message
								code="of.label" />&nbsp;${totalRecords}
	            		</c:when>
						<c:otherwise>
							<spring:message code="viewing.label" />&nbsp;${firstRecord} - ${totalRecords} &nbsp;<spring:message
								code="of.label" />&nbsp;${totalRecords}
	            		</c:otherwise>
					</c:choose>
				</div>
				<div class="hidden" id="totalrecords">${totalRecords}</div>
			</div>
		</div>
		<csrf:csrfToken />
	</form>
</div>