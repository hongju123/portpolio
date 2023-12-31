
document.querySelector(".search_area").addEventListener("submit", data = (e) => {
    e.preventDefault();
    const search_area = document.querySelector(".search_area");
    const input = search_area.main_search;
    const data = document.querySelectorAll("[name='data']");
    let found = false;
    data.forEach(element => {
        element.value.includes(input.value) == true ? searchHandler(input.value) : console.log("nope");
    });
})
function searchHandler(e) {
    const trimmedInput = e.replace(/(\s*)/g, "");
    console.log(trimmedInput);

    if (trimmedInput.includes("스프링") || trimmedInput.includes("프로젝트")) {
        found = true;
        location.replace("/ocoProject/index")
    }
    else if (trimmedInput.includes("로그인")) {
        location.replace("/user/login")
        found = true;
    } else if (trimmedInput.includes("회원가입")) {
        location.replace("/user/join")
        found = true;
    } else if (trimmedInput.includes("비지니스")) {
        location.replace("/user/join_business_Page")
        found = true;
    } else if (trimmedInput.includes("게시판")) {
        location.replace("/Cboard/list?topic=")
        found = true;
    }
}

function showElement(inputElement) {
    const previousElementSibling = inputElement.previousElementSibling;
    previousElementSibling.classList.remove("hidden");

    makeSizeUpOnFocus()
}
function hideElement(inputElement) {
    const previousElementSibling = inputElement.previousElementSibling;
    previousElementSibling.classList.add("hidden");

    makeSizeDownOnFocus();
}
function makeSizeUpOnFocus() {
    document.querySelector(".search_area").classList.add("sizeUp");
}
function makeSizeDownOnFocus(sizeElement) {
    document.querySelector(".search_area").classList.remove("sizeUp");
}

let observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        entry.isIntersecting === true ?
            entry.target.classList.add("ani") :
            entry.target.classList.remove("ani");
    });
});

document.querySelectorAll(".observer").length === 0 ? null : document.querySelectorAll(".observer").forEach(data => observer.observe(data));

let observerLeft = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        entry.isIntersecting === true ?
            entry.target.classList.add("ani-left") :
            entry.target.classList.remove("ani-left");
    });
})

document.querySelectorAll(".observer-left").length === 0 ? null : document.querySelectorAll(".observer-left").forEach(data => observerLeft.observe(data));

let observerRight = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        entry.isIntersecting === true ?
            entry.target.classList.add("ani-right") :
            entry.target.classList.remove("ani-right");
    });
});

document.querySelectorAll(".observer-right").length === 0 ? null : document.querySelectorAll(".observer-right").forEach(data => observerRight.observe(data));


//페이지 로딩시 슬라이드 이동거리 

document.addEventListener('DOMContentLoaded', function () {
    let widthSize = document.querySelectorAll(".card").length * 20;
    document.documentElement.style.setProperty("--widthSize", `${-widthSize}vw`);
});



//위치정보 

function onLocation(e) {
    const lat = e.coords.latitude;
    const lon = e.coords.longitude;

    console.log(lat + "+" + lon);

    const key = "6682c5c50c3364b6073670a47567585b";
    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${key}&units=metric`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(data.main.temp);

        });
}

function offLocation() {
    console.log("위치X");
}

navigator.geolocation.getCurrentPosition(onLocation, offLocation);

// menu js start
function showGlobalMenu() {
    const globalMenu = document.querySelector(".global-menu")
    
    globalMenu.classList.remove("hidden");
}
function removeGlobalMenu() {
    const globalMenu = document.querySelector(".global-menu")
    
    globalMenu.classList.add("hidden");
}


// menu js end