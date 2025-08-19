<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ê±°ë ì¤</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminMenu/adminManageTrading.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminHeader.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/adminFooter.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/admin/adminMenu/adminManageTrading.js"></script>
</head>

<body>
  <div id="header"></div>
  <main>
    <section class="body-sidebar">
      <div class="sidebar-div-name">
        ê´ë¦¬ì ë©ë´
      </div>

      <div class="sidebar-div-info">
        <div>
          <div> ê´ë¦¬ì : ë°±ì ì´ </div>
          <div> ê´ë¦¬ì ì´ë©ì¼ : ohohoho@naver.com</div>
        </div>
      </div>

      <div class="sidebar-div-container">
        <div>
          <ul>
            <li class="sidebar-elements"> <a href="./adminSiteStatistics.html"> ì¬ì´í¸ íµê³</a> </li>
            <li class="sidebar-elements"> <a href="./adminManagePosts.html"> ê²ìê¸ / ê³µì§ì¬í­</a> </li>
           <li class="sidebar-elements"> <a href="./adminManageFreeCommunity.html"> ì ì²´ ì»¤ë®¤ëí° </a> </li>
            <li class="sidebar-elements"> <a href="./adminManageTeamNews.html"> í ë´ì¤</a> </li>
            <li class="sidebar-elements"> <a href="./adminManageTeamYoutube.html"> í ì íë¸</a> </li>
            <li class="sidebar-elements"> <a href="./adminManageTeamSong.html"> í ììê°</a> </li>
            <li class="sidebar-elements"> <a href="./adminManageSell.html"> íë§¤ê¸</a> </li>
            <li class="sidebar-elements"> <a href="./adminManageTrading.html"> ê±°ëì¤ì¸ ê¸</a> </li>
            <li class="sidebar-elements"> <a href="./adminManageMember.html"> íìê´ë¦¬</a> </li>
          </ul>
        </div>
      </div>
    </section>
    <section class="body-container">
      <div class="body-container-name">
        ê±°ë ì¤ì¸ê¸ ëª©ë¡
      </div>
      <section class="body-container-list">
        <div class="list-background">

          <div class="list-names">
            <div>ê¸ ë²í¸</div>
            <div></div>
            <div>ì ëª©</div>
            <div>ê±°ë ì¼ì</div>
            <div>íë§¤ì ID</div>
            <div>êµ¬ë§¤ì ID</div>
          </div>
          
          <div class="list-container">
            <ul class="list-ul" id="list-ul">

            </ul>
          </div>

          <div class="page-buttons">
            <form action="" method="get">
              <button type="button" id="left-button"> â </button>
              <ul id="numberlist-ul">
                <li><a>1</a></li>
                <li><a>2</a></li>
                <li><a>3</a></li>
                <li><a>4</a></li>
                <li><a>5</a></li>
              </ul>
              <button type="button" id="right-button"> â· </button>
            </form>
          </div>

        </div>
      </section>
    </section>
  </main>
  <div id="footer"></div>
  <script src="${pageContext.request.contextPath}/assets/js/admin/adminHeaderFooterInclude.js"></script>
</body>

</html>