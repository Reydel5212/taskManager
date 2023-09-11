
//Fields Initialization auth
let cookie = getCookie("color");

const container = Array.from(
    document.getElementsByClassName('container')
);
const form = Array.from(
    document.getElementsByClassName('form')
);
const form_title = Array.from(
    document.getElementsByClassName('form_title')
);
const form_input = Array.from(
    document.getElementsByClassName('form_input')
);
const preloader = Array.from(
    document.getElementsByClassName('preloader')
);
const preloaderLogo = Array.from(
    document.getElementsByClassName('preloaderLogo')
);

function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
}

function changeColor(cookie){
    if (cookie == 'light'){
        container.forEach(container => {
            container.style.background = "linear-gradient(180deg, rgb(247, 246, 243), rgb(242, 242, 242))";
        });
        form.forEach(form => {
            form.style.background = "#FFF";
            form.style.boxShadow = "0px 1px 25px -2px rgba(127, 126, 122, 0.1)";
        });
        form_title.forEach(form_title => {
            form_title.style.color = "#353535";
        });
        form_input.forEach(form_input => {
            form_input.style.color = "#353535";
        });
        preloader.forEach(preloader => {
            preloader.style.background = "linear-gradient(180deg, rgb(247, 246, 243), rgb(242, 242, 242))";
        });
        preloaderLogo.forEach(preloaderLogo =>{
            preloaderLogo.src = "/image/logoShortPreloaderDark.svg";
        });

    }else if (cookie == 'dark'){
        container.forEach(container => {
            container.style.backgroundColor = "#111111";
        });
        form.forEach(form => {
            form.style.backgroundColor = "#232323";
        });
        form_title.forEach(form_title => {
            form_title.style.color = "#FFF";
        });
        form_input.forEach(form_input => {
            form_input.style.color = "#FFF";
        });
        preloader.forEach(preloader => {
            preloader.style.background = "linear-gradient(0deg, rgb(17, 17, 17), rgb(30, 30, 30))";
        });
        preloaderLogo.forEach(preloaderLogo =>{
            preloaderLogo.src = "/image/logoShortPreloader.svg";
        });

    } else {
        container.forEach(container => {
            container.style.background = "linear-gradient(135deg, rgb(43, 48, 59), rgb(33, 41, 49))";
        });
        form.forEach(form => {
            form.style.background = "linear-gradient(180deg, rgb(43, 48, 59), rgb(39, 42, 49))";
            form.style.boxShadow = "0px 1px 25px -2px rgba(238, 242, 246, 0.1)";
        });
        form_title.forEach(form_title => {
            form_title.style.color = "#FFF";
        });
        form_input.forEach(form_input => {
            form_input.style.color = "#FFF";
        });
        preloader.forEach(preloader => {
            preloader.style.background = "linear-gradient(135deg, rgb(43, 48, 59), rgb(33, 41, 49))";
        });
        preloaderLogo.forEach(preloaderLogo =>{
            preloaderLogo.src = "/image/logoShortPreloader.svg";
        });

    }
}

window.addEventListener('load', function() {
    //preloader
    var preloader = document.querySelector('.preloader');
    setTimeout(function() {
        preloader.style.opacity = '0';
        setTimeout(function() {
            preloader.style.display = 'none';
        }, 500);
    }, 1100);
});

window.addEventListener("load", ()=>{

    changeColor(cookie);

})
