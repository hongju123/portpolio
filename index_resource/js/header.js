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