<%@ include file="global.jsp"%>

<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-general'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
</head>
<!-- Content Div -->
<div class="content">
	<h1 class="title">
		<spring:message code="help.title" />
	</h1>
	<ul class="faq-items-list faq-list-faqs">
		<li class="alt">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.1" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.1" />
					</p>
				</div>
			</div>
		</li>
		<li class="">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.2" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.2" />
					</p>
					<p
						style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;">&nbsp;</p>
				</div>
			</div>
		</li>
		<li class="alt">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.3" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.3" />
					</p>
				</div>
			</div>
		</li>
		<li class="">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.4" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.4" />
					</p>
				</div>
			</div>
		</li>
		<li class="alt">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.5" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.5" />
					</p>
				</div>
			</div>
		</li>
		<li class="">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.6" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.6" />
					</p>
				</div>
			</div>
		</li>
		<li class="alt">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.7" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.7" />
					</p>
				</div>
			</div>
		</li>
		<li class="">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.8" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.8" />
					</p>
				</div>
			</div>
		</li>
		<li class="alt">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.9" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.9" />
					</p>
				</div>
			</div>
		</li>
		<li class="">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.10" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.10" />
					</p>
					<p
						style="font-family: tahoma, arial, helvetica, sans-serif; font-size: 12px;">&nbsp;</p>
				</div>
			</div>
		</li>
		<li class="alt">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.11" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.11" />
					</p>
				</div>
			</div>
		</li>
		<li class="">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.12" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.12" />
					</p>
				</div>
			</div>
		</li>
		<li class="alt">
			<div class="collapse">
				<h3 class="title">
					<a data-collapse-target=".collapse-content">Q. <spring:message
							code="help.faq.question.13" /></a>
				</h3>
				<div class="collapse-content">
					<p>
						A.
						<spring:message code="help.faq.answer.13" />
					</p>
				</div>
			</div>
		</li>
	</ul>
	<script>
     pageName = "faqs";
 </script>
</div>
<!-- Content Div Ends-->

<%-- <c:import url="http://10.209.4.200:4503/content/erefill/${locale}/help.textcontent.html"></c:import> --%>