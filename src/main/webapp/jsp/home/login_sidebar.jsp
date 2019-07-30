<%@ include file="../global.jsp"%>

<%@ page session="false"%>
<!-- Sidebar -->

<div class="sidebar">
	<div class="sidebar">
		<div class="card login last">
			<div class="header">
				<div class="inner">
					<h3 class="title">
						<spring:message code="login.label" />
					</h3>
				</div>
			</div>
			<div class="content">
				<div class="inner">
					<form action="${contextPath}/${locale}/user/login"
						class="uniform form-login" novalidate
						onSubmit="if (this.remember.checked) toMem(this)" method="POST">
						<div class="login">
							<h4 class="label">
								<spring:message code="login.message" />
							</h4>
							<div id="login_err" class="alert error error-msg"
								style="display: none" tabindex="0">
								<spring:message code="login.error" />
								<a href="javascript:void(0)" class="modal help-modal"><spring:message
										code="login.help.link" /></a>
							</div>
							<div id="login_err_session" style="display: none">
								<a href="javascript:void(0)" class="modal help-modal"><spring:message
										code="login.help.link" /></a>
							</div>
							<%
                    	Enumeration<String> errorEnum = request.getParameterNames();//("signinerror");
                    	String genericError= "";
                    	while( errorEnum.hasMoreElements() ) {
                    		genericError = errorEnum.nextElement();
                    		//if(genericError.equalsIgnoreCase("signinerror") || genericError.equalsIgnoreCase("error") || genericError){
                    		if( genericError.indexOf("error")!=-1) {
                    			genericError = request.getParameter(genericError);
                    		}else{
                    			genericError="";
                    		}
                    		continue;
                    	}
                    	//String accountLockedError =
                    	String key = "login."+genericError;
                    	boolean isError = false;
                    	boolean isSessionError = false;
                    	if(genericError !=null && genericError.equals("eSessionExpired"))
                    	{
                    		isSessionError = true;
                    		isError = true;
                    	}else if( genericError !=null && !genericError.equals("") ) {
                    		isError = true;

						} %>
							<%if (isError && !isSessionError){%>
							<script>
                                document.getElementById('login_err').style.display = "block";
                            </script>
							<%}%>

							<c:set var="erefillusername"
								value='${cookie["erefillusername"].value}' />
							<spring:message code="login.username.placeholder"
								var="placeholder_username" />
							<c:choose>
								<c:when
									test="${null ne erefillusername && not empty erefillusername}">
									<label class="aoda_lbl" for="username"></label>
									<input type="text" placeholder="${placeholder_username}"
										alphanumeric="true"
										data-msg-alphanumeric='<spring:message code="login.username.message.alphanumeric"/>'
										data-msg-required='<spring:message code="login.username.message.required"/>'
										data-rule-required="true" id="username" name="username"
										value="${erefillusername}" />
								</c:when>
								<c:otherwise>
									<label class="aoda_lbl" for="username"></label>
									<input type="text" placeholder="${placeholder_username}"
										alphanumeric="true"
										data-msg-alphanumeric='<spring:message code="login.username.message.alphanumeric"/>'
										data-msg-required='<spring:message code="login.username.message.required"/>'
										data-rule-required="true" id="username" name="username"
										value="" />
								</c:otherwise>
							</c:choose>


							<spring:message code="login.password.placeholder"
								var="placeholder_password" />
							<label class="aoda_lbl" for="password"></label> <input
								type="password" autocomplete="off"
								placeholder="${placeholder_password}"
								data-msg-required='<spring:message code="login.password.message.required"/>'
								data-rule-required="true" id="password" name="password" />
						</div>
						<%
                  	if( isError ) {

                   %>
						<label for="username" class="alert error error-msg" tabindex="0"><spring:message
								code="<%=key%>" /></label>
						<%  } %>
						<div class="remember">
							<label for="remember" class="aoda_lbl"></label> <input
								type="checkbox" id="remember" name="remember">
							<spring:message code="login.remember.me" />
						</div>
						<button type="submit" id="loginSubmit"
							class="button-erefill green">
							<spring:message code="login.sign.in" />
						</button>
						<a href='${contextPath}/${locale}/resetpassword/validateuser'
							target="_parent" class="button-erefill transparent"><spring:message
								code="login.forgot.password" /></a>
					</form>
				</div>
			</div>
			<div class="footer">
				<div class="inner">
					<!-- <h3 class="title"></h3> -->
					<p>
					<h3 class="title">
						<b><spring:message code="login.not.subscribed.label" /></b>
					</h3>
					<p>
						<spring:message code="login.not.subscribed.message" />
					</p>
				</div>
			</div>
		</div>
	</div>
	<div id="overlay-wrap" class="overlay-wrap login-help-overlay"
		style="top: 0px; display: none;">
		<div class="inner">
			<div class="overlay">
				<div class="need-help">
					<div class="header">
						<h1 class="title">
							<spring:message code="login.help.overlay.head" />
						</h1>
					</div>
					<div class="inner-content">
						<h2 class="title">
							<spring:message code="login.help.overlay.heading.1" />
						</h2>

						<p>
							<spring:message code="login.help.overlay.message.1" />
						</p>

						<h2 class="title">
							<spring:message code="login.help.overlay.heading.2" />
						</h2>
						<p>
							<spring:message code="login.help.overlay.message.2" />
						</p>
					</div>
				</div>
				<a class="close help-close" href="#">close</a>
			</div>
		</div>
	</div>
	<div id="overlay-screen" class="overlay-screen login-help-overlay"
		style="top: 0px; display: none;">
		<div></div>
	</div>
</div>
<!-- Sidebar Ends -->