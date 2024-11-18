// let slideIndex = 0;
// let slides = document.getElementsByClassName("carousel-item");
// showSlides();

// function showSlides() {
//   for (let i = 0; i < slides.length; i++) {
//     slides[i].classList.remove("active"); 
//   }
//   slideIndex++;
//   if (slideIndex > slides.length) { slideIndex = 1; } 
//   slides[slideIndex - 1].classList.add("active"); 
//   setTimeout(showSlides, 4000); 
// }


var thumbnail1 = document.getElementById('thumbnail1');
var thumbnail2 = document.getElementById('thumbnail2');
var thumbnail3 = document.getElementById('thumbnail3');

var popup1 = document.getElementById('video-popup1');
var popup2 = document.getElementById('video-popup2');
var popup3 = document.getElementById('video-popup3');

var close1 = popup1.querySelector('.close');
var close2 = popup2.querySelector('.close');
var close3 = popup3.querySelector('.close');

//  tải lại video
function openPopup(popup, videoUrl) {
  var iframe = popup.querySelector('iframe');
  iframe.src = videoUrl; // Cập nhật src để tải video
  popup.style.display = 'flex';
  iframe.contentWindow.postMessage('{"event":"command","func":"playVideo","args":""}', '*'); // Tự động phát video
}

// Khi người dùng nhấp vào thumbnail1
thumbnail1.onclick = function() {
  openPopup(popup1, "https://www.youtube.com/embed/_iyC2aUCxY0?autoplay=1&mute=1");
}

// Khi người dùng nhấp vào thumbnail2
thumbnail2.onclick = function() {
  openPopup(popup2, "https://www.youtube.com/embed/krgcyk2rjFc?autoplay=1&mute=1");
}

// Khi người dùng nhấp vào thumbnail3
thumbnail3.onclick = function() {
  openPopup(popup3, "https://www.youtube.com/embed/SjAzn1NV7Nc?autoplay=1&mute=1");
}

// Khi người dùng nhấp vào nút X để đóng popup1
close1.onclick = function() {
  popup1.style.display = 'none';
  var iframe = popup1.querySelector('iframe');
  iframe.src = ''; // Dừng video khi đóng popup
}

// Khi người dùng nhấp vào nút X để đóng popup2
close2.onclick = function() {
  popup2.style.display = 'none';
  var iframe = popup2.querySelector('iframe');
  iframe.src = ''; // Dừng video khi đóng popup
}

// Khi người dùng nhấp vào nút X để đóng popup3
close3.onclick = function() {
  popup3.style.display = 'none';
  var iframe = popup3.querySelector('iframe');
  iframe.src = ''; // Dừng video khi đóng popup
}

// Đóng popup khi nhấp ra ngoài nội dung popup
window.onclick = function(event) {
  if (event.target == popup1) {
    popup1.style.display = 'none';
    var iframe = popup1.querySelector('iframe');
    iframe.src = ''; // Dừng video khi đóng popup
  }
  if (event.target == popup2) {
    popup2.style.display = 'none';
    var iframe = popup2.querySelector('iframe');
    iframe.src = ''; // Dừng video khi đóng popup
  }
  if (event.target == popup3) {
    popup3.style.display = 'none';
    var iframe = popup3.querySelector('iframe');
    iframe.src = ''; // Dừng video khi đóng popup
  }
}


    // phim
    // Khai báo các phần tử DOM
const nowShowingSection = document.getElementById('now-showing-section');
const comingSoonSection = document.getElementById('coming-soon-section');

// Nút "Đang chiếu"
const nowShowingBtn = document.getElementById('now-showing-btn');
nowShowingBtn.addEventListener('click', () => {
  console.log("Now Showing clicked");
  nowShowingSection.style.display = 'block';
  comingSoonSection.style.display = 'none';
});

// Nút "Sắp khởi chiếu"
const comingSoonBtn = document.getElementById('coming-soon-btn');
comingSoonBtn.addEventListener('click', () => {
  console.log("Coming Soon clicked");
  comingSoonSection.style.display = 'block';
  nowShowingSection.style.display = 'none';
});

// chuyển đổi qua trang đặt vé
// Lấy tất cả các nút "Đặt vé"
const bookButtons = document.querySelectorAll('.book-button');

// Thêm sự kiện click cho mỗi nút
bookButtons.forEach(button => {
    button.addEventListener('click', () => {
        // Chuyển hướng đến trang giaodienghe.html
        window.location.href = 'giaodienghe.html';
    });
});



        