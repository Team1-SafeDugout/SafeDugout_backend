<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>불펜토크</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamStadium.css">
<c:choose>
	<c:when test="${sessionScope.teamNumber == 1}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/doosanHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/doosanFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 3}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/hanwhaHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/hanwhaFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 9}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiaHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiaFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 10}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiwoomHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiwoomFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 6}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ktHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ktFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 2}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lgHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lgFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 8}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lotteHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lotteFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 7}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ncHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ncFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 4}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/samsungHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/samsungFooter.css">
	</c:when>
	<c:when test="${sessionScope.teamNumber == 5}">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ssgHeader.css">
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ssgFooter.css">
	</c:when>
</c:choose>
<%-- <script src="${pageContext.request.contextPath}/assets/js/communityJs/communityTapPage/teamStadium.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script> --%>
</head>
<body>
	<jsp:include
		page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />
	<main>
		<!-- 경기장 정보 컨테이너 -->
		<div class="team-stadium-main-container">
			<h2>경기장 정보</h2>
			<div class="team-stadium-section-container">
				<!-- 경기장 이미지 공간 -->
				<section class="team-stadium-img">
					<div>
						<c:choose>
							<c:when test="${sessionScope.teamNumber == 1}">
								<img
									src="${pageContext.request.contextPath}/assets/img/stadium/doosanStadium.webp"
									alt="두산 경기장">
							</c:when>
							<c:when test="${sessionScope.teamNumber == 2}">
								<img
									src="${pageContext.request.contextPath}/assets/img/stadium/lgStadium.jpg"
									alt="lg 경기장">
							</c:when>
							<c:when test="${sessionScope.teamNumber == 3}">
								<img
									src="${pageContext.request.contextPath}/assets/img/stadium/hanwhaStadium.webp"
									alt="한화 경기장">
							</c:when>
							<c:when test="${sessionScope.teamNumber == 4}">
								<img
									src="${pageContext.request.contextPath}/assets/img/stadium/samsungStadium.png"
									alt="삼성 경기장">
							</c:when>
							<c:when test="${sessionScope.teamNumber == 5}">
								<img
									src="${pageContext.request.contextPath}/assets/img/stadium/ssgStadium.webp"
									alt="ssg 경기장">
							</c:when>
							<c:when test="${sessionScope.teamNumber == 6}">
								<img
									src="${pageContext.request.contextPath}/assets/img/stadium/ktStadium.jpg"
									alt="kt 경기장">
							</c:when>
							<c:when test="${sessionScope.teamNumber == 7}">
								<img
									src="${pageContext.request.contextPath}/assets/img/stadium/ncStadium.webp"
									alt="nc 경기장">
							</c:when>
							<c:when test="${sessionScope.teamNumber == 8}">
								<img
									src="${pageContext.request.contextPath}/assets/img/stadium/lotteStadium.webp"
									alt="롯데 경기장">
							</c:when>
							<c:when test="${sessionScope.teamNumber == 9}">
								<img
									src="${pageContext.request.contextPath}/assets/img/stadium/kiaStadium.webp"
									alt="kia 경기장">
							</c:when>
							<c:when test="${sessionScope.teamNumber == 10}">
								<img
									src="${pageContext.request.contextPath}/assets/img/stadium/kiwoomStadium.webp"
									alt="키움 경기장">
							</c:when>
						</c:choose>
					</div>
				</section>

				<section class="team-stadium-info">
					<!-- 경기장 정보 컨테이너 -->
					<div class="team-stadium-info-container">
						<!-- 경기장 주소 -->
						<div class="info-table">
							<h3>경기장 주소</h3>
							<table>
								<tbody>
									<tr>
										<td><c:out value="${stadium.stadiumAddress}" /></td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- 티켓 가격 -->
						<div class="info-table">
							<h3>티켓 가격</h3>
							<table>
								<thead>
									<tr>
										<th>좌석명</th>
										<th>평일 가격</th>
										<th>주말 가격</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="ticket" items="${tickets}">
										<tr>
											<td><c:out value="${ticket.seatName}" /></td>
											<td><fmt:formatNumber value="${ticket.weekdayPrice}"
													type="number" />원</td>
											<td><fmt:formatNumber value="${ticket.weekendPrice}"
													type="number" />원</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- 티켓 예매 -->
						<div class="info-table">
							<h3>티켓 예매</h3>
							<table>
								<tbody>
									<tr>
										<td><c:out value="${ticketReservationSite}" /></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<!-- 먹거리 컨테이너 -->
					<div class="team-stadium-food-container">
						<!-- 먹거리 추천 -->
						<div class="info-table">
							<h3>먹거리 추천</h3>
							<table>
								<thead>
									<tr>
										<th>추천음식</th>
										<th>위치</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="food" items="${foods}">
										<tr>
											<td><c:out value="${food.foodName}" /></td>
											<td><c:out value="${food.foodLocation}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- 먹거리 이용 팁 -->
						<div class="info-table">
							<h3>먹거리 이용 팁</h3>
							<table>
								<tbody>
									<c:forEach var="food" items="${foods}">
										<tr>
											<td><c:out value="${food.foodTip}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</section>
			</div>
		</div>
	</main>
	<jsp:include
		page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
	<script>
		let memberNumber = $
		{
			sessionScope.memberNumber
		};
		let teamNumber = $
		{
			sessionScope.teamNumber
		};
	</script>
</body>
</html>
