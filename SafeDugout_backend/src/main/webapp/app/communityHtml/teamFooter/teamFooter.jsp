<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<footer>
  <div class="team-footer-container" id="team-footer${sessionScope.teamNumber}">
    <a href="">이용약관</a>
    <c:choose>
    <c:when test="${sessionScope.teamNumber == 1}">
    <a href="https://www.doosanbears.com/" target="_blank">팀 공식 사이트 바로가기</a>
    </c:when>
    <c:when test="${sessionScope.teamNumber == 3}">
    <a href="https://www.hanwhaeagles.co.kr/index.do" target="_blank">팀 공식 사이트 바로가기</a>
    </c:when>
    <c:when test="${sessionScope.teamNumber == 9}">
    <a href="https://tigers.co.kr/" target="_blank">팀 공식 사이트 바로가기</a>
    </c:when>
    <c:when test="${sessionScope.teamNumber == 10}">
    <a href="https://heroesbaseball.co.kr/index.do" target="_blank">팀 공식 사이트 바로가기</a>
    </c:when>
    <c:when test="${sessionScope.teamNumber == 6}">
    <a href="https://www.ktwiz.co.kr/" target="_blank">팀 공식 사이트 바로가기</a>
    </c:when>
    <c:when test="${sessionScope.teamNumber == 2}">
    <a href="https://www.lgtwins.com/service/html.ncd?view=/pc_twins/twins_main/twins_main" target="_blank">팀 공식 사이트 바로가기</a>
    </c:when>
    <c:when test="${sessionScope.teamNumber == 8}">
    <a href="https://www.giantsclub.com/html/" target="_blank">팀 공식 사이트 바로가기</a>
    </c:when>
    <c:when test="${sessionScope.teamNumber == 7}">
    <a href="https://www.ncdinos.com/" target="_blank">팀 공식 사이트 바로가기</a>
    </c:when>
    <c:when test="${sessionScope.teamNumber == 4}">
    <a href="https://www.samsunglions.com/" target="_blank">팀 공식 사이트 바로가기</a>
    </c:when>
    <c:when test="${sessionScope.teamNumber == 5}">
    <a href="https://www.ssglanders.com/main" target="_blank">팀 공식 사이트 바로가기</a>
    </c:when>
    </c:choose>
  </div>  
</footer>