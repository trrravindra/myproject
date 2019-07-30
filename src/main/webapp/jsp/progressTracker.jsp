<%--
  This jsp will add the title and description and the progress tracker in the initial sign in pages
--%>

<div class="registration-steps">
	<a
		class="step <c:if test="${registrationStep eq 'verifyIdentity'}">active</c:if>">
		<div class="inner">
			<div class="number">1</div>
			<div class="text">
				<spring:message code="registration.progress.tracker.step1.label" />
			</div>
		</div>
	</a> <a
		class="step <c:if test="${registrationStep eq 'termsofuse'}">active</c:if>">
		<div class="inner">
			<div class="number">2</div>
			<div class="text">
				<spring:message code="registration.progress.tracker.step2.label" />
			</div>
		</div>
	</a> <a href="#"
		class="step <c:if test="${registrationStep eq 'accountpref'}">active</c:if>">
		<div class="inner">
			<div class="number">3</div>
			<div class="text">
				<spring:message code="registration.progress.tracker.step4.label" />
			</div>
		</div>
	</a> <a href="#"
		class="step <c:if test="${registrationStep eq 'accountinfo'}">active</c:if>">
		<div class="inner">
			<div class="number">4</div>
			<div class="text">
				<spring:message code="registration.progress.tracker.step3.label" />
			</div>
		</div>
	</a> <a href="#"
		class="step last <c:if test="${registrationStep eq 'success'}">active</c:if>">
		<div class="inner">
			<div class="number">5</div>
			<div class="text">
				<spring:message code="registration.progress.tracker.step5.label" />
			</div>
		</div>
	</a>
</div>

<script>
var selector = ${registrationStep}; 
if (selector =="verifyIdentity" || selector == "" ){
     pageName = "registration:birth date";
}else if(selector =="termsofuse"){
     pageName = "registration:terms conditions";
}else if(selector =="accountinfo"){
     pageName = "registration:account info";
}else if(selector =="accountpref"){
     pageName = "registration:security questions";
}else if(selector =="success"){
     pageName = "registration:confirmed";
}
</script>