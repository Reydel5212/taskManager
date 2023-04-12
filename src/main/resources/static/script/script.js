//sideBar
let arrow = document.querySelectorAll(".arrow");
for (var i = 0; i < arrow.length; i++) {
  arrow[i].addEventListener("click", (e)=>{
 let arrowParent = e.target.parentElement.parentElement;//selecting main parent of arrow
 arrowParent.classList.toggle("showMenu");
  });
}

//sideBar and homeSection close
let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".bx-menu");
let homeSectionContentBar = document.querySelector(".homeSectionContentBar");

console.log(sidebarBtn);
sidebarBtn.addEventListener("click", ()=>{
  sidebar.classList.toggle("close");
    homeSectionContentBar.classList.toggle("sideBarClose");

});

//time
/*
let time = document.querySelector(".time");
let date = new Date().toLocaleString('ru', {
    month: 'long',
    day: 'numeric',
    weekday: "long"
});

addEventListener("load",()=>{
    time.innerHTML = date;
})
*/


