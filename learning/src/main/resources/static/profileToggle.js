let profile = document.querySelector('.header .flex .profile');
let searchForm = document.querySelector('.header .flex .search-form');

const toggleProfile = () => {
    profile.classList.toggle('active');
    searchForm.classList.remove('active');
};

document.querySelector('#user-btn').onclick = toggleProfile;
