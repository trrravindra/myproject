<%@ include file="../global.jsp"%>

<%@ page session="false"%>

<!-- FOOTER -->

<c:set var="userRole" value="${userRole}" />

<footer class="footer-main">
	<div class="wrap">
		<div class="footer-global-erefill">
			<ul>
				<li><a class="no-click"
					href="<c:url value='/${locale}/user/terms-and-conditions'></c:url>"
					target=""><spring:message code="footer.terms.of.user" /></a></li>
				<li><a class="no-click"
					href="<c:url value='/${locale}/user/privacy-policy'></c:url>"
					target="_blank"><spring:message code="footer.privacy" /></a></li>
				<li><a class="no-click"
					href="<c:url value='/${locale}/user/consent'></c:url>" target=""><spring:message
							code="footer.consent" /></a></li>
				<c:if test="${locale eq 'en_CA' }">
					<li><a class="no-click" href="http://loblaw.ca/en/accessibility.html" target="">
					<spring:message	code="footer.accessibility" /></a></li>
				</c:if> 
				<c:if test="${locale eq 'fr_CA' }">
					<li><a class="no-click" href="http://loblaw.ca/fr/accessibility.html" target="">
					<spring:message	code="footer.accessibility" /></a></li>
				</c:if> 
			</ul>
			<div class="copyright">
				<spring:message code="footer.copyright" />
			</div>

			<c:set var="userProvince" value="${pharmaStores.pharmaVO.province}" />
			<c:if test="${not empty userProvince && userProvince ne null}">
				<c:if test="${userProvince eq 'QC' && userRole ne 'Caregivers'}">
					<div class="disclaimer">
						<spring:message code="footer.disclaimer" />
					</div>
				</c:if>
			</c:if>
		</div>
	</div>
</footer>
<!-- FOOTER Ends -->
