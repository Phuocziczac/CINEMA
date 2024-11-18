document.addEventListener("DOMContentLoaded", function () {
    let menuicn = document.querySelector(".menuicn");
    let nav = document.querySelector(".navcontainer");

    if (menuicn && nav) {
        menuicn.addEventListener("click", () => {
            nav.classList.toggle("navclose");
        });
    } else {
        console.error("Không tìm thấy phần tử .menuicn hoặc .navcontainer");
    }
});
