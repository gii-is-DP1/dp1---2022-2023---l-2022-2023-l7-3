<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="monopoly" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/resources/css/game.css" var="gameCss"/>
<link href="${gameCss}" rel="stylesheet"/>

	<div style="display:block; width: 100%;">
		<div style="display:flex;flex-direction: row;margin: auto;">
			<h1 class="propertyTxt2">Do you want to bid <c:out value = "${player.user.username}"></c:out> ?</h1>
			<h1 class="propertyTxt2">Current Bid: <c:out value = "${auction.currentBid}"></c:out> <img style='height: 24px' src='/resources/images/Monodolar.png'/> </h1>
			<button type="button" onclick="hidePopUp('auctionBuilding')" class="cancelButton" ><span class="glyphicon glyphicon-remove"></span></button>
		</div>
	</div>
	
	<div  class="propertyImg">
		<img  alt="Card image" src="${property.badgeImage}">
	</div>
	
	<form:form action="/game/${Game.id}/auction" modelAttribute="auction" id = "AuctionForm" >
		<input type="hidden" name="id" value="${auction.id}"/>
		<input type="hidden" name="playerIndex" value="${auction.playerIndex}"/>
		<c:forEach items="${auction.remainingPlayers}" var="player" varStatus="status">
			<input type="hidden" name="remainingPlayers[${status.index}]" value="${player}"/>
		</c:forEach>
		<input type="hidden" name="currentBid" value="${auction.currentBid}"/>
		<input type="hidden" name="playerBid" value="${auction.playerBid}" id = "playerBid"/>
		<input type="hidden" name="propertyId" value="${auction.propertyId}"/>
		<input type="hidden" name="gameId" value="${auction.gameId}"/>
		<c:if test="${isActingOnAuction}">
			<div class="popUpButtons">
				<button class="popUpDangerButton">Abandon</button>
				<button class="popUpButton" type = "button" onclick="newBid(1)">1M</button>
				<button class="popUpButton" type = "button" onclick="newBid(10)">10M</button>
				<button class="popUpButton" type = "button" onclick="newBid(100)">100M</button>
			</div>
		</c:if>
    </form:form>

<script>
function newBid(quantity){
	 let playerBid = document.getElementById("playerBid");
	 playerBid.value = parseInt(playerBid.value) + quantity;
	 document.getElementById("AuctionForm").submit();
}
</script>