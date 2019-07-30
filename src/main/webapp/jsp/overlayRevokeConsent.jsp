<%@ include file="global.jsp"%>

<div class="revoke-consent">
	<div class="header">
		<h1 class="title">
			<spring:message code="my.account.revoke.consent.overlay.title.label" />
		</h1>
	</div>
	<div class="inner-content">
		<form class="form-details uniform form-validate" method="post"
			action="${contextPath}/${locale}/myaccount/consent/revoke">
			<p>
				<spring:message code="my.account.revoke.consent.overlay.instruction" />
			</p>
			<label class="erefill-radio small"> <input type="radio"
				name="radio1" value="AccountNeverActivated" /> <spring:message
					code="my.account.account.never.activated" />
			</label> <label class="erefill-radio small"> <input type="radio"
				name="radio1" value="InactiveAccount" /> <spring:message
					code="my.account.inactive.account" />
			</label> <label class="erefill-radio small"> <input type="radio"
				name="radio1" value="ConsentExpired" /> <spring:message
					code="my.account.consent.expired" />
			</label> <label class="erefill-radio small"> <input type="radio"
				name="radio1" value="MoveToAnotherLocation" /> <spring:message
					code="my.account.move.to.another.location" />
			</label> <label class="erefill-radio small"> <input type="radio"
				name="radio1" value="MoveToAnotherPharmacy" /> <spring:message
					code="my.account.move.to.another.pharmacy" />
			</label> <label class="erefill-radio small"> <input type="radio"
				name="radio1" value="FindWebsiteDifficultToUse" /> <spring:message
					code="my.account.find.website.difficult.to.use" />
			</label> <label class="erefill-radio small"> <input type="radio"
				name="radio1" value="FindTheServiceUnreliable" /> <spring:message
					code="my.account.find.the.service.unreliable" />
			</label> <label class="erefill-radio small"> <input type="radio"
				name="radio1" value="FindTheWebsiteToBeInflexible" /> <spring:message
					code="my.account.find.the.website.to.be.inflexible" />
			</label> <label class="erefill-radio small"> <input type="radio"
				name="radio1" value="DoNotLikeThisService" /> <spring:message
					code="my.account.do.not.like.this.service" />
			</label> <label class="erefill-radio small"> <input type="radio"
				name="radio1" value="Other" /> <spring:message
					code="my.account.other" />
			</label>

			<button class="button-erefill green" type="submit" disabled
				name="revokeconsentspopup_button">
				<spring:message
					code="my.account.revoke.consent.overlay.revoke.button" />
			</button>
			<a class="button-erefill link cancel" href="#" role="button"> <spring:message
					code="my.account.revoke.consent.overlay.back.link" />
			</a>
			<csrf:csrfToken />
		</form>
	</div>
</div>


