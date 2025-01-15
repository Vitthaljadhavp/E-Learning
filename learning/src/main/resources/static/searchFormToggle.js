let searchForm = document.querySelector('.header .flex .search-form');
let profile = document.querySelector('.header .flex .profile');

const toggleSearchForm = () => {
    searchForm.classList.toggle('active');
    profile.classList.remove('active');
};

document.querySelector('#search-btn').onclick = toggleSearchForm;
