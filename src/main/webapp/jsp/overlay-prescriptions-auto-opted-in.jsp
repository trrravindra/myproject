<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="overlay-wrap">
	<div class="inner">
		<div class="overlay">
			<div class="auto-refill-opted-in" role="dialog" tabIndex="0"
				aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
				<div class="header">
					<h1 class="title" id="overlayTitle">
						{{?it.content.updatetype=="optIN"}}
						<spring:message
							code="opt.in.auto.refill.reminder.overlay.title.label" />
						{{?}} {{?it.content.updatetype=="optOUT"}}
						<spring:message
							code="opt.out.auto.refill.reminder.overlay.title.label" />
						{{?}}
					</h1>
				</div>

				<div class="inner-content" id="overlayDesc">
					{{?it.content.email || it.content.mobile}}
					<p>
						<spring:message code="refill.reminder.overlay.notify.text" />
					</p>
					{{?}}
					<p>
						{{?it.content.email}}
						<spring:message code="refill.reminder.overlay.success.email.label" />

						<strong>{{=it.content.email}}</strong> {{?}} <br />

						{{?it.content.mobile}}
						<spring:message code="refill.request.notify.mobile.label" />
						<strong>{{=it.content.mobile.toString().substring(0,3)}}-{{=it.content.mobile.toString().substring(3,6)}}-{{=it.content.mobile.toString().substring(6,10)}} </strong> 
						
						{{?}}
					</p>

					<p>
						{{?it.content.updatetype=="optIN"}}
						<spring:message code="opt.in.auto.refill.overlay.description.text" />
						{{?}}
					</p>

					<p>
						{{?it.content.updatetype=="optOUT"}}
						<spring:message
							code="opt.out.auto.refill.overlay.description.text" />
						{{?}}
					</p>


					<button class="button-erefill green cancel">
						<spring:message code="continue.label" />
					</button>

				</div>
			</div>
			<a class="close" href="#"><spring:message code="close.label" /></a>
		</div>
	</div>
</div>
<div class="overlay-screen">
	<div></div>
</div>





