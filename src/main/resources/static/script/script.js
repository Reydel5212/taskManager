//Fields Initialization main
let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".bx-menu");
let homeSectionContentBar = document.querySelector(".homeSectionContentBar");
let body = document.querySelector("body");
let tableContentTaskContainer = document.querySelector(".tableContentTaskContainer");
let tableContentTaskContainerStat = document.querySelector(".tableContentTaskContainerStat");

const sideBarClass = Array.from(
    document.getElementsByClassName('sidebar')
);
const homeSectionContentBarClass = Array.from(
    document.getElementsByClassName('homeSectionContentBar')
);
const tableContentBar = Array.from(
    document.getElementsByClassName('tableContentBar')
);
const homeSection = Array.from(
    document.getElementsByClassName('home-section')
);
const linkName = Array.from(
    document.getElementsByClassName('link_name')
);
const bx = Array.from(
    document.getElementsByClassName('bx')
);
const tableTaskText = Array.from(
    document.getElementsByClassName('tableTaskText')
);
const tableContentCell = Array.from(
    document.getElementsByClassName('tableContentCell')
);
const profileDetails = Array.from(
    document.getElementsByClassName('profile-details')
);
const tableContentHover = Array.from(
    document.getElementsByClassName('tableContentHover')
);
const navLinksList = Array.from(
    document.getElementsByClassName('nav-links-list')
);
const subMenu = Array.from(
    document.getElementsByClassName('sub-menu')
);
const logo = Array.from(
    document.getElementsByClassName('logo')
);
const preloader = Array.from(
    document.getElementsByClassName('preloader')
);
const preloaderLogo = Array.from(
    document.getElementsByClassName('preloaderLogo')
);
const addTaskInput = Array.from(
    document.getElementsByClassName('addTaskInput')
);

//sideBar
let arrow = document.querySelectorAll(".arrow");
for (var i = 0; i < arrow.length; i++) {
    arrow[i].addEventListener("click", (e)=>{
        let arrowParent = e.target.parentElement.parentElement;//selecting main parent of arrow
        arrowParent.classList.toggle("showMenu");
    });
}

sidebarBtn.addEventListener("click", ()=>{
  sidebar.classList.toggle("close");
  homeSectionContentBar.classList.toggle("sideBarClose");
});


//Get cookie function
function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}



//Change color function
function changeColor(){
    let cookie = getCookie("color");
    if (cookie == 'light'){

        //Change color

        body.style.color = "#353535";

        addTaskInput.forEach(addTaskInput => {
            addTaskInput.style.color = "#353535";
            addTaskInput.style.border = "1px #353535 solid";
        });
        sideBarClass.forEach(sideBarClass => {
            sideBarClass.style.background = "#FFF";
            sideBarClass.style.boxShadow = "0px 1px 25px -2px rgba(127, 126, 122, 0.1)";
        });
        linkName.forEach(linkName => {
            linkName.style.color = "#353535";
        });
        homeSection.forEach(homeSection => {
            homeSection.style.background = "linear-gradient(180deg, rgb(247, 246, 243), rgb(242, 242, 242))";
        });
        tableContentBar.forEach(tableContentBar => {
            tableContentBar.style.background = "#FFF";
            tableContentBar.style.boxShadow = "0px 1px 25px -2px rgba(127, 126, 122, 0.1)";
        });
        bx.forEach(bx => {
            bx.style.color = "#353535";
        });
        tableTaskText.forEach(tableTaskText => {
            tableTaskText.style.color = "#353535";
        });
        tableContentCell.forEach(tableContentCell => {
            tableContentCell.style.borderBottom = "1px #353535 solid";
        });
        profileDetails.forEach(profileDetails => {
            profileDetails.style.backgroundColor = "#E8E7E4";
        });
        subMenu.forEach(subMenu => {
            subMenu.style.backgroundColor = "#E8E7E4";
        });
        logo.forEach(logo => {
            logo.src = "/image/logoSecDark.svg";
        });
        preloader.forEach(preloader => {
            preloader.style.background = "linear-gradient(180deg, rgb(247, 246, 243), rgb(242, 242, 242))";
        });
        preloaderLogo.forEach(preloaderLogo =>{
            preloaderLogo.src = "/image/logoShortPreloaderDark.svg";
        });

        //hover
        tableContentHover.forEach(tableContentHover => {
            tableContentHover.addEventListener("mouseover",()=>{
                tableContentHover.style.backgroundColor = "#E8E7E4";
            })
            tableContentHover.addEventListener("mouseleave",()=>{
                tableContentHover.style.backgroundColor = "transparent";
            })
        });

        navLinksList.forEach(navLinksList => {
            navLinksList.addEventListener("mouseover",()=>{
                navLinksList.style.backgroundColor = "#E8E7E4";
            })
            navLinksList.addEventListener("mouseleave",()=>{
                navLinksList.style.backgroundColor = "transparent";
            })
        });

    }else if(cookie == 'dark'){

        //changeColor main
        body.style.color = "#FFF";

        addTaskInput.forEach(addTaskInput => {
            addTaskInput.style.color = "#fff";
            addTaskInput.style.border = "1px #fff solid";
        });
        sideBarClass.forEach(sideBarClass => {
            sideBarClass.style.background = "linear-gradient(180deg, rgb(28, 28, 28), rgb(21, 19, 19))";
            sideBarClass.style.boxShadow = "0px 1px 25px -2px rgba(238, 242, 246, 0.1)";
        });
        linkName.forEach(linkName => {
            linkName.style.color = "#FFF";
        });
        homeSection.forEach(homeSection => {
            homeSection.style.background = "linear-gradient(0deg, rgb(17, 17, 17), rgb(30, 30, 30))";
        });
        tableContentBar.forEach(tableContentBar => {
            tableContentBar.style.background = "linear-gradient(180deg, rgb(28, 28, 28), rgb(21, 19, 19))";
            tableContentBar.style.boxShadow = "0px 1px 25px -2px rgba(238, 242, 246, 0.1)";
        });
        bx.forEach(bx => {
            bx.style.color = "#FFF";
        });
        tableTaskText.forEach(tableTaskText => {
            tableTaskText.style.color = "#FFF";
        });
        tableContentCell.forEach(tableContentCell => {
            tableContentCell.style.borderBottom = "1px #FFF solid";
        });
        profileDetails.forEach(profileDetails => {
            profileDetails.style.backgroundColor = "#232323";
        });
        subMenu.forEach(subMenu => {
            subMenu.style.backgroundColor = "#232323";
        });
        preloader.forEach(preloader => {
            preloader.style.background = "linear-gradient(0deg, rgb(17, 17, 17), rgb(30, 30, 30))";
        });
        preloaderLogo.forEach(preloaderLogo =>{
            preloaderLogo.src = "/image/logoShortPreloader.svg";
        });

        //hover
        tableContentHover.forEach(tableContentHover => {
            tableContentHover.addEventListener("mouseover",()=>{
                tableContentHover.style.backgroundColor = "#4B4B4B";
            })
            tableContentHover.addEventListener("mouseleave",()=>{
                tableContentHover.style.backgroundColor = "transparent";
            })
        });

        navLinksList.forEach(navLinksList => {
            navLinksList.addEventListener("mouseover",()=>{
                navLinksList.style.backgroundColor = "#232323";
            })
            navLinksList.addEventListener("mouseleave",()=>{
                navLinksList.style.backgroundColor = "transparent";
            })
        });

    }else {
        //changeColor main
        body.style.color = "#FFF";

        addTaskInput.forEach(addTaskInput => {
            addTaskInput.style.color = "#fff";
            addTaskInput.style.border = "1px #fff solid";
        });
        sideBarClass.forEach(sideBarClass => {
            sideBarClass.style.background = "linear-gradient(180deg, rgb(43, 48, 59), rgb(39, 42, 49))";
            sideBarClass.style.boxShadow = "0px 3px 25px 0px rgba(238, 242, 246, 0.1)";
        });
        linkName.forEach(linkName => {
            linkName.style.color = "#FFF";
        });
        homeSection.forEach(homeSection => {
            homeSection.style.background = "linear-gradient(135deg, rgb(43, 48, 59), rgb(33, 41, 49))";
        });
        tableContentBar.forEach(tableContentBar => {
            tableContentBar.style.background = "linear-gradient(180deg, rgb(43, 48, 59), rgb(39, 42, 49))";
            tableContentBar.style.boxShadow = "0px 1px 25px -2px rgba(238, 242, 246, 0.1)";
        });
        bx.forEach(bx => {
            bx.style.color = "#FFF";
        });
        tableTaskText.forEach(tableTaskText => {
            tableTaskText.style.color = "#FFF";
        });
        tableContentCell.forEach(tableContentCell => {
            tableContentCell.style.borderBottom = "1px #FFF solid";
        });
        profileDetails.forEach(profileDetails => {
            profileDetails.style.backgroundColor = "#323A43";
        });
        subMenu.forEach(subMenu => {
            subMenu.style.backgroundColor = "#323A43";
            subMenu.style.boxShadow = "0px 1px 25px -2px rgba(238, 242, 246, 0.1)";
        });
        preloader.forEach(preloader => {
            preloader.style.background = "linear-gradient(135deg, rgb(43, 48, 59), rgb(33, 41, 49))";
        });
        preloaderLogo.forEach(preloaderLogo =>{
            preloaderLogo.src = "/image/logoShortPreloader.svg";
        });

        //hover
        tableContentHover.forEach(tableContentHover => {
            tableContentHover.addEventListener("mouseover",()=>{
                tableContentHover.style.backgroundColor = "#323A43";
                tableContentHover.style.cursor = "pointer";
            })
            tableContentHover.addEventListener("mouseleave",()=>{
                tableContentHover.style.backgroundColor = "transparent";
            })
        });

        navLinksList.forEach(navLinksList => {
            navLinksList.addEventListener("mouseover",()=>{
                navLinksList.style.backgroundColor = "#323A43";
                navLinksList.style.cursor = "pointer";
            })
            navLinksList.addEventListener("mouseleave",()=>{
                navLinksList.style.backgroundColor = "transparent";
            })
        });

    }
}
    window.addEventListener('load', function() {
        changeColor();
    //preloader
      var preloader = document.querySelector('.preloader');
      setTimeout(function() {
        preloader.style.opacity = '0';
        setTimeout(function() {
          preloader.style.display = 'none';
        }, 500);
      }, 1100);
    });

    window.addEventListener('load', function() {

        changeColor();

    });

