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
	href="${pageContext.request.contextPath}/assets/css/communityCss/communityTapPage/teamStats.css">
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
<%-- <script defer src="${pageContext.request.contextPath}/assets/js/communityJs/teamInclude.js"></script> --%>

</head>
<body>
	<jsp:include
		page="${pageContext.request.contextPath}/app/communityHtml/headerHtml/teamHeader.jsp" />
	<main class="team-stats">
		<div class="team-stats-top-section">
			<div class="team-stats">
				<!-- 시즌 기록 -->
				<section class="team-stats-box">
					<h3>시즌 기록</h3>
					<div class="team-stats-header">
						<div>순위</div>
						<div>팀명</div>
						<div>경기수</div>
						<div>승</div>
						<div>패</div>
						<div>무</div>
						<div>승률</div>
						<div>타율</div>
						<div>방어율</div>
						<div>득점</div>
						<div>실점</div>
					</div>
					<c:forEach var="record" items="${teamRecords}">
						<div class="team-stats-row">
							<div>${record.teamRank}</div>
							<div>${record.teamName}</div>
							<div>${record.gameCount}</div>
							<div>${record.teamWin}</div>
							<div>${record.teamLose}</div>
							<div>${record.teamDraw}</div>
							<div>
								<fmt:formatNumber value="${record.teamWinRate}" pattern="#.###" />
							</div>
							<div>
								<fmt:formatNumber value="${record.teamAvgBat}" pattern="#.###" />
							</div>
							<div>
								<fmt:formatNumber value="${record.teamEra}" pattern="#.###" />
							</div>
							<div>${record.teamScore}</div>
							<div>${record.teamConcede}</div>
						</div>
					</c:forEach>
				</section>
				<!-- 투수 기록 -->
				<section class="team-stats-box">
					<h3>투수 기록</h3>
					<div class="team-stats-header">
						<div>ERA</div>
						<div>경기</div>
						<div>승</div>
						<div>패</div>
						<div>세이브</div>
						<div>승률</div>
						<div>이닝</div>
						<div>피안타</div>
						<div>피홈런</div>
						<div>볼넷</div>
						<div>사구</div>
						<div>삼진</div>
						<div>실점</div>
						<div>자책점</div>
						<div>WHIP</div>
					</div>
					<c:forEach var="record" items="${pitcherRecords}">
						<div class="team-stats-row">
							<div>
								<fmt:formatNumber value="${record.teamPitcherEra}"
									pattern="#.###" />
							</div>
							<div>${record.teamPitcherGameCount}</div>
							<div>${record.teamPitcherWin}</div>
							<div>${record.teamPitcherLose}</div>
							<div>${record.teamPitcherSave}</div>
							<div>
								<fmt:formatNumber value="${record.teamPitcherWpct}"
									pattern="#.###" />
							</div>
							<div>
								<fmt:formatNumber value="${record.teamPitcherIp}" pattern="#.##" />
							</div>
							<div>${record.teamPitcherHits}</div>
							<div>${record.teamPitcherHr}</div>
							<div>${record.teamPitcherBb}</div>
							<div>${record.teamPitcherHbp}</div>
							<div>${record.teamPitcherStrikeout}</div>
							<div>${record.teamPitcherScore}</div>
							<div>${record.teamPitcherEr}</div>
							<div>
								<fmt:formatNumber value="${record.teamPitcherWhip}"
									pattern="#.###" />
							</div>
						</div>
					</c:forEach>
				</section>
				<!-- 타자 기록 -->
				<section class="team-stats-box">
					<h3>타자 기록</h3>
					<div class="team-stats-header">
						<div>AVG</div>
						<div>경기</div>
						<div>타수</div>
						<div>타점</div>
						<div>득점</div>
						<div>1루타</div>
						<div>2루타</div>
						<div>3루타</div>
						<div>HR</div>
						<div>TB(루타)</div>
						<div>타점</div>
						<div>희생번트</div>
						<div>희생플라이</div>
					</div>
					<c:forEach var="record" items="${batterRecords}">
						<div class="team-stats-row">
							<div>
								<fmt:formatNumber value="${record.teamBatterAvgBat}"
									pattern="#.###" />
							</div>
							<div>${record.teamBatterGameCount}</div>
							<div>${record.teamBatterAb}</div>
							<div>${record.teamBatterRbi}</div>
							<div>${record.teamBatterR}</div>
							<div>${record.teamBatterHits}</div>
							<div>${record.teamBatterDoubleHit}</div>
							<div>${record.teamBatterTripleHit}</div>
							<div>${record.teamBatterHr}</div>
							<div>${record.teamBatterTb}</div>
							<div>${record.teamBatterRbi}</div>
							<div>${record.teamBatterSac}</div>
							<div>${record.teamBatterSf}</div>
						</div>
					</c:forEach>

				</section>
				<!-- 수비/주루 기록 -->
				<section class="team-stats-box">
					<h3>수비/주루</h3>
					<div class="team-stats-header">
						<div>경기</div>
						<div>실책</div>
						<div>병살</div>
						<div>도루허용</div>
						<div>도루저지</div>
						<div>도루성공</div>
						<div>견제사(수비)</div>
						<div>견제사(주루)</div>
					</div>
					<c:forEach var="record" items="${defenseRecords}">
						<div class="team-stats-row">
							<div>${record.gameCount}</div>
							<div>${record.error}</div>
							<div>${record.dp}</div>
							<div>${record.sb}</div>
							<div>${record.cb}</div>
							<div>${record.sbSuccess}</div>
							<div>${record.pickOff}</div>
							<div>${record.pickOffSuccess}</div>
						</div>
					</c:forEach>
				</section>
			</div>
			<!-- 역대순위 -->
			<aside class="team-stats-history-ranking">
				<h3>역대 순위</h3>
				<div class="team-stats-history-header">
					<div>연도</div>
					<div>경기</div>
					<div>승</div>
					<div>패</div>
					<div>무</div>
					<div>승률</div>
					<div>순위</div>
				</div>
				<div class="team-stats-history-row"></div>
			</aside>
		</div>
		<!-- 하단: 우승 년도 -->
		<section class="team-stats-championships">
			<h3>우승 년도</h3>
			<div class="team-logo-list"></div>
		</section>
	</main>
	<jsp:include
		page="${pageContext.request.contextPath}/app/communityHtml/teamFooter/teamFooter.jsp" />
</body>
</html>
