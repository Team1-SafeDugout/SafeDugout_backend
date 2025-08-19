const teamHeaders = {
  loginHeader: {
    doosan : "${pageContext.request.contextPath}/app/communityHtml/headerHtml/doosanHeader.html",
    hanwha : "${pageContext.request.contextPath}/app/communityHtml/headerHtml/hanwhaHeader.html",
    kia : "${pageContext.request.contextPath}/app/communityHtml/headerHtml/kiaHeader.html",
    kiwoom: "${pageContext.request.contextPath}/app/communityHtml/headerHtml/kiwoomHeader.html",
    kt : "${pageContext.request.contextPath}/app/communityHtml/headerHtml/ktHeader.html",
    lg: "${pageContext.request.contextPath}/app/communityHtml/headerHtml/lgHeader.html",
    lotte: "${pageContext.request.contextPath}/app/communityHtml/headerHtml/lotteHeader.html",
    nc: "${pageContext.request.contextPath}/app/communityHtml/headerHtml/ncHeader.html",
    samsung: "${pageContext.request.contextPath}/app/communityHtml/headerHtml/samsungHeader.html",
    ssg: "${pageContext.request.contextPath}/app/communityHtml/headerHtml/ssgHeader.html"
  },
  beforeLoginHeader: {
    doosan: "${pageContext.request.contextPath}/app/communityHtml/beforeLoginHeader/doosan.html",
    hanwha: "${pageContext.request.contextPath}/app/communityHtml/beforeLoginHeader/hanwha.html",
    kia : "${pageContext.request.contextPath}/app/communityHtml/beforeLoginHeader/kia.html",
    kiwoom: "${pageContext.request.contextPath}/app/communityHtml/beforeLoginHeader/kiwoom.html",
    kt : "${pageContext.request.contextPath}/app/communityHtml/beforeLoginHeader/kt.html",
    lg: "${pageContext.request.contextPath}/app/communityHtml/beforeLoginHeader/lg.html",
    lotte: "${pageContext.request.contextPath}/app/communityHtml/beforeLoginHeader/lotte.html",
    nc: "${pageContext.request.contextPath}/app/communityHtml/beforeLoginHeader/nc.html",
    samsung: "${pageContext.request.contextPath}/app/communityHtml/beforeLoginHeader/samsung.html",
    ssg: "${pageContext.request.contextPath}/app/communityHtml/beforeLoginHeader/ssg.html"
  }
};

const teamFooter = {
  doosan: "${pageContext.request.contextPath}/app/communityHtml/teamFooter/doosanFooter.html",
  hanwha: "${pageContext.request.contextPath}/app/communityHtml/teamFooter/hanwhaFooter.html",
  kia: "${pageContext.request.contextPath}/app/communityHtml/teamFooter/kiaFooter.html",
  kiwoom: "${pageContext.request.contextPath}/app/communityHtml/teamFooter/kiwoomFooter.html",
  kt: "${pageContext.request.contextPath}/app/communityHtml/teamFooter/ktFooter.html",
  lg: "${pageContext.request.contextPath}/app/communityHtml/teamFooter/lgFooter.html",
  lotte: "${pageContext.request.contextPath}/app/communityHtml/teamFooter/lotteFooter.html",
  nc: "${pageContext.request.contextPath}/app/communityHtml/teamFooter/ncFooter.html",
  samsung: "${pageContext.request.contextPath}/app/communityHtml/teamFooter/samsungFooter.html",
  ssg: "${pageContext.request.contextPath}/app/communityHtml/teamFooter/ssgFooter.html"
};

const teamCSS = {
  loginHeader: {
    doosan : "${pageContext.request.contextPath}/assets/css/communityCss/headerCss/doosanHeader.css",
    hanwha : "${pageContext.request.contextPath}/assets/css/communityCss/headerCss/hanwhaHeader.css",
    kia : "${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiaHeader.css",
    kiwoom: "${pageContext.request.contextPath}/assets/css/communityCss/headerCss/kiwoomHeader.css",
    kt : "${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ktHeader.css",
    lg: "${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lgHeader.css",
    lotte: "${pageContext.request.contextPath}/assets/css/communityCss/headerCss/lotteHeader.css",
    nc: "${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ncHeader.css",
    samsung: "${pageContext.request.contextPath}/assets/css/communityCss/headerCss/samsungHeader.css",
    ssg: "${pageContext.request.contextPath}/assets/css/communityCss/headerCss/ssgHeader.css"
  },
  footer: {
    doosan: "${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/doosanFooter.css",
    hanwha: "${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/hanwhaFooter.css",
    kia: "${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiaFooter.css",
    kiwoom: "${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/kiwoomFooter.css",
    kt: "${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ktFooter.css",
    lg: "${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lgFooter.css",
    lotte: "${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/lotteFooter.css",
    nc: "${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ncFooter.css",
    samsung: "${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/samsungFooter.css",
    ssg: "${pageContext.request.contextPath}/assets/css/communityCss/teamFooter/ssgFooter.css"
  }
};


async function loadHTML(targetId, filePath) {
  try {
    const res = await fetch(filePath);
    if (!res.ok) throw new Error(`Failed to load ${filePath}`);
    const html = await res.text();
    document.getElementById(targetId).innerHTML = html;
  } catch (e) {
    console.error(e);
  }
}

function loadCSS(href) {
  return new Promise((resolve, reject) => {
    if (!href) {
      reject(new Error('CSS 경로가 없습니다.'));
      return;
    }
    if (document.querySelector(`link[href="${href}"]`)) {
      resolve();
      return;
    }
    const link = document.createElement("link");
    link.rel = "stylesheet";
    link.href = href;
    link.onload = () => resolve();
    link.onerror = () => reject(new Error(`Failed to load CSS: ${href}`));
    document.head.appendChild(link);
  });
}

function getUserStatus() {
  const loggedIn = localStorage.getItem("loggedIn") === "true";
  const team = localStorage.getItem("team") || "doosan";
  return { loggedIn, team };
}

async function loadHeaderFooterCSS() {
  const { loggedIn, team } = getUserStatus();

  const headerFile = loggedIn? teamHeaders.loginHeader[team]: teamHeaders.beforeLoginHeader[team];
  const footerFile = teamFooter[team];

  if (!headerFile) {
    console.error(`Header file not found for team: ${team}, loggedIn: ${loggedIn}`);
    return;
  }
  
  if (!footerFile) {
    console.error(`Footer file not found for team: ${team}`);
    return;
  }

  try {
    await loadHTML("team-header", headerFile);
    await loadHTML("team-footer", footerFile);

    const headerCSS = teamCSS.loginHeader[team];
    const footerCSS = teamCSS.footer[team];

    await Promise.all([
      loadCSS(headerCSS),
      loadCSS(footerCSS)
    ]);
  } catch (e) {
    console.error(e);
  }
}

document.addEventListener("DOMContentLoaded", loadHeaderFooterCSS);
