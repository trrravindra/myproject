<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="overlay-wrap">
	<div class="inner">
		<div class="overlay">
			<div class="instructions" role="dialog" tabIndex="0"
				aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
				<div class="header">
					<h1 class="title" id="overlayTitle">{{=it.content.name}}({{=it.content.strength}})</h1>
				</div>
				<div class="inner-content" id="overlayDesc">
					<p>{{=it.content.sigdecoded}}</p>
				</div>
			</div>
			<a class="close" href="#"><spring:message code="close.label" /></a>
		</div>
	</div>
</div>
<div class="overlay-screen">
	<div></div>
</div>