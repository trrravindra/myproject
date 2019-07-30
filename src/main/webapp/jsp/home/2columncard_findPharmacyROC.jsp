<%@ include file="../global.jsp"%>

<%@ page session="false"%>
<!-- Column 02-->
<div class="card find-pharmacy last">
	<div class="header">
		<div class="inner">
			<h3 class="title">
				<spring:message code="home.find.pharmacy.heading.ROC" />
			</h3>
		</div>
	</div>
	<div class="pharmacy-container">
		<div class="content">
			<div class="inner">
				<div>
					<p>
						<spring:message code="home.find.pharmacy.message" />
					</p>
				</div>
			</div>
		</div>
		<div class="footer">
			<div class="inner">
				<!--
            <form class="uniform form-find-pharmacy" action="https://www.yourhealthmattershere.ca/en_CA/storelocator.html">
             -->
				<%
                String locale="fr_CA";
               String currentPath = (String)request.getAttribute("javax.servlet.forward.request_uri");
               	if( currentPath.contains("en_CA") ) {

               		locale="en_CA";

               	}
               	String storeLocatorUrl = "/static/"+locale+"/storelocator.html";
                %>
				<form class="uniform form-find-pharmacy"
					action="<c:url value='<%=storeLocatorUrl%>'/>" method="get">
					<!-- Pharmacy department code -->
					<input type="hidden" name="departments" value="300064" />
					<spring:message code="home.find.pharmacy.placeholder"
						var="placeholder_enter" />
					<label class="aoda_lbl" for="pharmacyloc"></label> <input
						type="text" id="pharmacyloc" class="input-search" name="location"
						data-rule-required="true"
						data-msg-required="<spring:message code="pharmacy.search.error.message"/>"
						placeholder="${placeholder_enter}" />
					<button class="button-erefill green shadow" type="submit">
						<spring:message code="home.find.pharmacy.button.label" />
					</button>
					<div class="noresults" tabindex='0'>
						<spring:message code="home.find.pharmacy.no.results" />
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- Column 02 Ends-->