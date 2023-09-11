//Smooth scroll
tableContentTaskContainer.addEventListener('wheel', function(ev) {
    ev = window.event || ev;
    let delta = Math.max(-1, Math.min(1, (ev.wheelDelta || -ev.detail)));
    this.scrollTop -= (delta * 20); // количество пикселей = 2
    ev.preventDefault();
  });

tableContentTaskContainerStat.addEventListener('wheel', function(ev) {
    ev = window.event || ev;
    let delta = Math.max(-1, Math.min(1, (ev.wheelDelta || -ev.detail)));
    this.scrollTop -= (delta * 20); // количество пикселей = 2
    ev.preventDefault();
});