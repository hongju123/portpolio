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