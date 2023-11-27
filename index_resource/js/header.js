function showElement(inputElement) {
    const previousElementSibling = inputElement.previousElementSibling;
    previousElementSibling.classList.add("hidden");
    previousElementSibling.previousElementSibling.classList.remove("hidden");


    makeSizeUpOnFocus()
}
function hideElement(inputElement) {
    const previousElementSibling = inputElement.previousElementSibling;
    inputElement.previousElementSibling.classList.remove("hidden");
    previousElementSibling.classList.remove("hidden");
    previousElementSibling.previousElementSibling.classList.add("hidden");

    makeSizeDownOnFocus();
}
function makeSizeUpOnFocus() {
    document.querySelector(".search_area").classList.add("sizeDown");
}
function makeSizeDownOnFocus(sizeElement) {
    document.querySelector(".search_area").classList.remove("sizeDown");
}