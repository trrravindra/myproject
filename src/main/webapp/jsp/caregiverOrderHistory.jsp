<%@ include file="global.jsp"%>

<script src="<c:url value='/resources/js/vendor/modernizr.js'/>"></script>
<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-general'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>


<c:set var="wasurl"
	value="${contextPath}/${locale}/orderhistory/specificorderhistory" />

<div class="content">
	<a class="ctrl-print" href="#"><spring:message code="print.label" /></a>

	<c:choose>
		<c:when test="${isLoggedInUser}">
			<h1 class="title">
				<spring:message code="caregiver.my.order.history.title" />
			</h1>
			<spring:message code="caregiver.my.order.history.message" />
		</c:when>
		<c:otherwise>
			<h1 class="title">
				<spring:message code="caregiver.order.history.title" />
				<div class="impersonatedTitle"></div>
			</h1>
			<c:choose>
				<c:when test="${locale eq 'en_CA'}">
					<c:if test="${filterDate ne 'All' }">
						<c:set var="datePrintVal" value="Last ${filterDate } Days" />
					</c:if>
					<c:if test="${filterDate eq 'All' }">
						<c:set var="datePrintVal" value="All Days" />
					</c:if>

					<c:if test="${status eq 'All'}">
						<c:set var="statusPrintVal" value="${status } statuses" />
					</c:if>
					<c:if test="${status ne 'All' }">
						<c:set var="statusPrintVal" value="${status }" />
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if test="${filterDate ne 'All' }">
						<c:set var="datePrintVal" value="${filterDate } derniers jours" />
					</c:if>
					<c:if test="${filterDate eq 'All' }">
						<c:set var="datePrintVal" value="Toutes les dates" />
					</c:if>

					<c:if test="${status eq 'All'}">
						<c:set var="statusPrintVal" value="Tous les statuts" />
					</c:if>
					<c:if test="${status ne 'All' }">
						<c:set var="statusPrintVal" value="${status }" />
					</c:if>
				</c:otherwise>
			</c:choose>
			<div class="date-result print">${datePrintVal},${statusPrintVal}</div>
			<div class="ctrl-wrap">
				<div class="show-range">
					<!-- Show range/show status form -->
					<form class="uniform form-range-filter" action="${wasurl}"
						method="POST">
						<input type="hidden" name="page_num" id="page_num"
							value="${pageNum}" /> <label> <spring:message
								code="show.label" />
						</label> <select class="submit-on-change" name="date_range">
							<c:choose>
								<c:when test="${filterDate eq 'All'}">
									<option value="All" selected="selected">
										<spring:message code="all.dates.text" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="All">
										<spring:message code="all.dates.text" />
									</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${filterDate eq '30'}">
									<option value="30" selected="selected">
										<spring:message code="last.30.days.print.value" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="30">
										<spring:message code="last.30.days.print.value" />
									</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${filterDate eq '90'}">
									<option value="90" selected="selected">
										<spring:message code="last.90.days.print.value" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="90">
										<spring:message code="last.90.days.print.value" />
									</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${filterDate eq '180'}">
									<option value="180" selected="selected">
										<spring:message code="last.180.days.print.value" />
									</option>
								</c:when>
								<c:otherwise>
									<option value="180">
										<spring:message code="last.180.days.print.value" />
									</option>
								</c:otherwise>
							</c:choose>
						</select>

						<!-- Form will auto-submit when value selected -->
						<select class="submit-on-change" name="status">
							<c:choose>
								<c:when test="${status eq 'All' }">
									<option value="All" selected="selected">
										<spring:message code="all.status.print.value" /></option>
								</c:when>
								<c:otherwise>
									<option value="All">
										<spring:message code="all.status.print.value" /></option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${status eq 'Pending' }">
									<option value="Pending" selected="selected">
										<spring:message code="pending.status.print.value" /></option>
								</c:when>
								<c:otherwise>
									<option value="Pending">
										<spring:message code="pending.status.print.value" /></option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${status eq 'Received' }">
									<option value="Received" selected="selected">
										<spring:message code="received.status.print.value" /></option>
								</c:when>
								<c:otherwise>
									<option value="Received">
										<spring:message code="received.status.print.value" /></option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${status eq 'Accepted' }">
									<option value="Accepted" selected="selected">
										<spring:message code="accepted.status.print.value" /></option>
								</c:when>
								<c:otherwise>
									<option value="Accepted">
										<spring:message code="accepted.status.print.value" /></option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${status eq 'Declined' }">
									<option value="Declined" selected="selected">
										<spring:message code="declined.status.print.value" /></option>
								</c:when>
								<c:otherwise>
									<option value="Declined">
										<spring:message code="declined.status.print.value" /></option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${status eq 'AcceptedWithoutInfo' }">
									<option value="AcceptedWithoutInfo" selected="selected">
										<spring:message code="acceptedWithoutInfo.status.print.value" /></option>
								</c:when>
								<c:otherwise>
									<option value="AcceptedWithoutInfo">
										<spring:message code="acceptedWithoutInfo.status.print.value" /></option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${status eq 'None' }">
									<option value="None" selected="selected">
										<spring:message code="none.status.print.value" /></option>
								</c:when>
								<c:otherwise>
									<option value="None">
										<spring:message code="none.status.print.value" /></option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${status eq 'ReceivedETARequired' }">
									<option value="ReceivedETARequired" selected="selected">
										<spring:message code="recievedETARequired.status.print.value" /></option>
								</c:when>
								<c:otherwise>
									<option value="ReceivedETARequired">
										<spring:message code="recievedETARequired.status.print.value" /></option>
								</c:otherwise>
							</c:choose>
							<%-- <c:forTokens
								items="All,Pending,Received,Accepted,Declined,AcceptedWithoutInfo,None,ReceivedETARequired"
								delims="," var="stat">
								<c:choose>
									<c:when test="${status eq stat}">
										<c:choose>
											<c:when test="${'All' eq stat}">
												<option value="${stat}" selected="selected">${stat}
													Status</option>
											</c:when>
											<c:otherwise>
												<option value="${stat}" selected="selected">${stat}</option>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${'All' eq stat}">
												<option value="${stat}">${stat}
													<spring:message code="status.print.value" /></option>
											</c:when>
											<c:otherwise>
												<option value="${stat}">${stat}</option>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>
							</c:forTokens> --%>
						</select>
						<csrf:csrfToken />
					</form>
					<!-- End of show range/show status form -->
				</div>
				<div class="results">
					<c:choose>
						<c:when test="${not empty mpRefill}">
							<spring:message code="viewing.label" />&nbsp;${firstRecord} - ${fn:length(mpRefill) + firstRecord - 1} &nbsp;<spring:message
								code="of.label" />&nbsp;${totalRecords}
           		</c:when>
						<c:otherwise>
							<spring:message code="viewing.label" />&nbsp;${firstRecord} - ${totalRecords} &nbsp;<spring:message
								code="of.label" />&nbsp;${totalRecords}
           		</c:otherwise>
					</c:choose>
				</div>
			</div>
			<%@ include file="orderHistoryList.jsp"%>
			<div class="ctrl-wrap ctrl-bottom">
				<nav class="pagination">
					<c:if test="${not empty numOfPages && numOfPages gt 1}">
						<spring:message code="page.label" />
						<c:choose>
							<c:when test="${pageNum ne 1}">
								<a href="${wasurl}" id="prev_${(pageNum - 1)}" class="prev"
									title="Previous Page">${(pageNum - 1)}</a>
							</c:when>
							<c:otherwise>
								<span class="prev disabled" title="Previous Page"><spring:message
										code="previous.page.label" /></span>
							</c:otherwise>
						</c:choose>
						<ol>
							<c:forEach var="i" begin="0" end="${(numOfPages -1)}">
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
						<c:when test="${not empty mpRefill}">
							<spring:message code="viewing.label" />&nbsp;${firstRecord} - ${fn:length(mpRefill) + firstRecord - 1} &nbsp;<spring:message
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
		</c:otherwise>
	</c:choose>
</div>