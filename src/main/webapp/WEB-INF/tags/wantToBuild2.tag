<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="monopoly" tagdir="/WEB-INF/tags"%>

<spring:url value="/resources/css/game.css" var="gameCss"/>
<link href="${gameCss}" rel="stylesheet"/>

<div style="display:block; width: 100%;">
	<div style="display:flex;flex-direction: row;margin: auto;">
		<h1 class="propertyTxt">Do you want to build?</h1>
		<button type="button" onclick="hidePopUp('wantToBuild')" class="cancelButton" ><span class="glyphicon glyphicon-remove"></span></button>
	</div>
</div>

<img  class="propertyImg" alt="Card image" src="/resources/images/monopolyConstructor.png">

<a class="popUpButtons">
	<button type="button" onclick="closeOpenPopUp('wantToBuild', 'buildBuildings')" class="popUpButton">Yes</button>
	<button onclick="hidePopUp('wantToBuild')" class="popUpButton">No</button>
</a>