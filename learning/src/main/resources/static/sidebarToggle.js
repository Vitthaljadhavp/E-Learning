let body = document.body;
let sideBar = document.querySelector('.side-bar');

const toggleSidebar = () => {
    sideBar.classList.toggle('active');
    body.classList.toggle('active');
};

const closeSidebar = () => {
    sideBar.classList.remove('active');
    body.classList.remove('active');
};

document.querySelector('#menu-btn').onclick = toggleSidebar;
document.querySelector('.side-bar .close-side-bar').onclick = closeSidebar;

window.onscroll = () => {
    if (window.innerWidth < 1200) {
        sideBar.classList.remove('active');
        body.classList.remove('active');
    }
};
