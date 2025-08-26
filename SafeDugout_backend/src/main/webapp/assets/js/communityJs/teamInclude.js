const teamHeaders = {
  loginHeader: {
    doosan : "./../../../../webapp/app/communityHtml/headerHtml/doosanHeader.jsp",
    hanwha : "./../../../../webapp/app/communityHtml/headerHtml/hanwhaHeader.jsp",
    kia : "./../../../../webapp/app/communityHtml/headerHtml/kiaHeader.html",
    kiwoom: "./../../../../webapp/app/communityHtml/headerHtml/kiwoomHeader.jsp",
    kt : "./../../../../webapp/app/communityHtml/headerHtml/ktHeader.jsp",
    lg: "./../../../../webapp/app/communityHtml/headerHtml/lgHeader.jsp",
    lotte: "./../../../../webapp/app/communityHtml/headerHtml/lotteHeader.jsp",
    nc: "./../../../../webapp/app/communityHtml/headerHtml/ncHeader.jsp",
    samsung: "./../../../../webapp/app/communityHtml/headerHtml/samsungHeader.jsp",
    ssg: "./../../../../webapp/app/communityHtml/headerHtml/ssgHeader.jsp"
  },
  beforeLoginHeader: {
    doosan: "./../../../../webapp/app/communityHtml/beforeLoginHeader/doosan.jsp",
    hanwha: "./../../../../webapp/app/communityHtml/beforeLoginHeader/hanwha.jsp",
    kia : "./../../../../webapp/app/communityHtml/beforeLoginHeader/kia.jsp",
    kiwoom: "./../../../../webapp/app/communityHtml/beforeLoginHeader/kiwoom.jsp",
    kt : "./../../../../webapp/app/communityHtml/beforeLoginHeader/kt.jsp",
    lg: "./../../../../webapp/app/communityHtml/beforeLoginHeader/lg.jsp",
    lotte: "./../../../../webapp/app/communityHtml/beforeLoginHeader/lotte.jsp",
    nc: "./../../../../webapp/app/communityHtml/beforeLoginHeader/nc.jsp",
    samsung: "./../../../../webapp/app/communityHtml/beforeLoginHeader/samsung.jsp",
    ssg: "./../../../../webapp/app/communityHtml/beforeLoginHeader/ssg.jsp"
  }
};

const teamFooter = {
  doosan: "./../../../../webapp/app/communityHtml/teamFooter/doosanFooter.jsp",
  hanwha: "./../../../../webapp/app/communityHtml/teamFooter/hanwhaFooter.jsp",
  kia: "./../../../../webapp/app/communityHtml/teamFooter/kiaFooter.jsp",
  kiwoom: "./../../../../webapp/app/communityHtml/teamFooter/kiwoomFooter.jsp",
  kt: "./../../../../webapp/app/communityHtml/teamFooter/ktFooter.jsp",
  lg: "./../../../../webapp/app/communityHtml/teamFooter/lgFooter.jsp",
  lotte: "./../../../../webapp/app/communityHtml/teamFooter/lotteFooter.jsp",
  nc: "./../../../../webapp/app/communityHtml/teamFooter/ncFooter.jsp",
  samsung: "./../../../../webapp/app/communityHtml/teamFooter/samsungFooter.jsp",
  ssg: "./../../../../webapp/app/communityHtml/teamFooter/ssgFooter.jsp"
};

const teamCSS = {
  loginHeader: {
    doosan : "./../../../../webapp/assets/css/communityCss/headerCss/doosanHeader.css",
    hanwha : "./../../../../webapp/assets/css/communityCss/headerCss/hanwhaHeader.css",
    kia : "./../../../../webapp/assets/css/communityCss/headerCss/kiaHeader.css",
    kiwoom: "./../../../../webapp/assets/css/communityCss/headerCss/kiwoomHeader.css",
    kt : "./../../../../webapp/assets/css/communityCss/headerCss/ktHeader.css",
    lg: "./../../../../webapp/assets/css/communityCss/headerCss/lgHeader.css",
    lotte: "./../../../../webapp/assets/css/communityCss/headerCss/lotteHeader.css",
    nc: "./../../../../webapp/assets/css/communityCss/headerCss/ncHeader.css",
    samsung: "./../../../../webapp/assets/css/communityCss/headerCss/samsungHeader.css",
    ssg: "./../../../../webapp/assets/css/communityCss/headerCss/ssgHeader.css"
  },
  footer: {
    doosan: "./../../../../webapp/assets/css/communityCss/teamFooter/doosanFooter.css",
    hanwha: "./../../../../webapp/assets/css/communityCss/teamFooter/hanwhaFooter.css",
    kia: "./../../../../webapp/assets/css/communityCss/teamFooter/kiaFooter.css",
    kiwoom: "./../../../../webapp/assets/css/communityCss/teamFooter/kiwoomFooter.css",
    kt: "./../../../../webapp/assets/css/communityCss/teamFooter/ktFooter.css",
    lg: "./../../../../webapp/assets/css/communityCss/teamFooter/lgFooter.css",
    lotte: "./../../../../webapp/assets/css/communityCss/teamFooter/lotteFooter.css",
    nc: "./../../../../webapp/assets/css/communityCss/teamFooter/ncFooter.css",
    samsung: "./../../../../webapp/assets/css/communityCss/teamFooter/samsungFooter.css",
    ssg: "./../../../../webapp/assets/css/communityCss/teamFooter/ssgFooter.css"
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
