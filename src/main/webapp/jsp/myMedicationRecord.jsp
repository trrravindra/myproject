<%@ include file="global.jsp"%>

<script src="<c:url value='/resources/js/vendor/modernizr.js'/>"></script>
<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-general'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>

<c:set var="wasurl" value='${contextPath}/${locale}/mymedicationrecord' />

<div class="content">
	<a class="ctrl-print" href="#"><spring:message code="print.label" /></a>

	<c:choose>
		<c:when test="${isLoggedInUser}">
			<h1 class="title">
				<spring:message code="my.medication.record.title" />
			</h1>
		</c:when>
		<c:otherwise>
			<h1 class="title">
				<spring:message code="my.medication.record.custodian.title" />
				<div class="impersonatedTitle"></div>
			</h1>
		</c:otherwise>
	</c:choose>

	<h2 class="subhead">
		<spring:message code="prescription.sbtitle.text" />
	</h2>
	<c:choose>
		<c:when test="${filterDate eq 'all'}">
			<div class="date-result print">
				<spring:message code="all.days.print.value" />
			</div>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${filterDate eq '30'}">
					<div class="date-result print">
						<spring:message code="last.30.days.print.value" />
					</div>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${filterDate eq '90'}">
							<div class="date-result print">
								<spring:message code="last.90.days.print.value" />
							</div>
						</c:when>
						<c:otherwise>
							<c:if test="${filterDate eq '180'}">
								<div class="date-result print">
									<spring:message code="last.180.days.print.value" />
								</div>
							</c:if>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>

	<div class="ctrl-wrap">
		<div class="show-range">
			<form:form class="uniform form-range-filter" action="${wasurl}"
				method="POST" modelAttribute="medicationRecord">
				<input type="hidden" name="page_num" id="page_num"
					value="${pageNum}" />
				<label> <spring:message code="show.label" /> <select
					class="submit-on-change" name="date_range">
						<c:choose>
							<c:when test="${filterDate eq 'All'}">
								<option value="all" selected="selected">
									<spring:message code="all.dates.text" />
								</option>
							</c:when>
							<c:otherwise>
								<option value="all">
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
				</label>
				<csrf:csrfToken />
			</form:form>
		</div>
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

	<%@ include file="medicationRecordList.jsp"%>

	<div class="ctrl-wrap ctrl-bottom">
		<nav class="pagination">
			<c:if test="${not empty numOfPages && numOfPages gt 1}">
				<spring:message code="page.label" />
				<c:choose>
					<c:when test="${pageNum != 1}">
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