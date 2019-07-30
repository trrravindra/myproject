<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="medication-list">
	<thead>
		<tr>
			<th class="medication"><spring:message code="medication.text" /></th>
			<th class="qty"><spring:message code="quantity.text" /></th>
			<th class="refills"><spring:message
					code="medication.record.refills.left.text" /></th>
			<th class="last-filled"><spring:message
					code="medication.record.last.filled.date.text" /></th>
			<th class="next-fill"><spring:message
					code="medication.record.estimated.next.fill.date" /></th>
			<th class="prescribed"><spring:message code="prescribed.by.text" /></th>
		</tr>
	</thead>
	<tbody class="pagination-list">
		<c:choose>
			<c:when test="${not empty lstPresc}">
				<c:forEach items="${lstPresc}" var="presc" varStatus="alt">
					<c:choose>
						<c:when test="${alt.index mod 2 eq 0}">
							<tr class="alt">
						</c:when>
						<c:otherwise>
							<tr class="">
						</c:otherwise>
					</c:choose>
					<td class="medication"><a
						data-print="<spring:message code="print.label" />"
						data-drug-id="${presc.DIN}" href="#"
						data-modal="${contextPath}/${locale}/orderhistory/drugdetails"
						class="drug-info-modal"> <span>${presc.name}</span> -
							${presc.genericName}
					</a> <c:if test="${not empty presc.strength}">(${presc.strength})</c:if><br />
						<span> <spring:message code="rx.label" />
							#${presc.rxNumber}
					</span> <br /> <span> <c:if test="${not empty presc.sigDecoded}"> (${presc.sigDecoded}) </c:if></span>
						<br /> <span> <c:if
								test="${not empty presc.expirationDate}">
								<spring:message code="my.prescriptions.refillable.upto.label" />: ${presc.expirationDate} </c:if></span>
					</td>
					<td class="qty">${presc.quantityFilled}</td>
					<td class="refills"><c:choose>
							<c:when test="${not empty presc.remainigRefills}">
									${presc.remainigRefills}
								</c:when>
							<c:otherwise> -
								</c:otherwise>
						</c:choose></td>
					<td class="last-filled">${presc.lastFilledDate}</td>
					<td class="next-fill">${presc.estimatedFillDate}</td>
					<td class="prescribed">${presc.prescriberFirstName}&nbsp;&nbsp;<br>${presc.prescriberLastName}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4"><spring:message
							code="medication.no.record.text" /></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
