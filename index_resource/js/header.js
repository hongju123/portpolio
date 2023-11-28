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
});

document.querySelectorAll(".observer-left").length === 0 ? null : document.querySelectorAll(".observer-left").forEach(data => observerLeft.observe(data));

let observerRight = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        entry.isIntersecting === true ?
            entry.target.classList.add("ani-right") :
            entry.target.classList.remove("ani-right");
    });
});

document.querySelectorAll(".observer-right").length === 0 ? null : document.querySelectorAll(".observer-right").forEach(data => observerRight.observe(data));