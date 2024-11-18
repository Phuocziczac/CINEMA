// tạo dãy ghế tự động
const seatsContainer = document.querySelector('.seats');
const rows = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I']; // Adjusted rows

const columns = 14;

for (let row of rows) {
  const rowElement = document.createElement('div');
  rowElement.classList.add('row');

  const rowLabel = document.createElement('span');
  rowLabel.classList.add('row-label');
  rowLabel.textContent = row;
  rowElement.appendChild(rowLabel);

  for (let col = 1; col <= columns; col++) {
    const seat = document.createElement('div');
    seat.classList.add('seat');
    seat.dataset.seat = `${row}${col}`;
    seat.textContent = col;

    // Set border color based on row
    if (['D', 'E', 'F', 'G'].includes(row)) {
      seat.style.border = '3px solid red'; // Change to desired yellow color
    } else {
      seat.style.border = '3px solid  #9a9898'; // Default border color
    }

    rowElement.appendChild(seat);
  }

  seatsContainer.appendChild(rowElement);
}

// giúp howver lên khi ấn vào
const seats = document.querySelectorAll('.seat');
const selectedSeats = [];
const selectedSeatsElement = document.getElementById('selectedSeats');

seats.forEach(seat => {
    seat.addEventListener('click', () => {
        if (seat.classList.contains('unavailable')) return;

        seat.classList.toggle('selected');

        if (seat.classList.contains('selected')) {
            selectedSeats.push(seat.dataset.seat);
        } else {
            selectedSeats.splice(selectedSeats.indexOf(seat.dataset.seat), 1);
        }

        selectedSeatsElement.textContent = selectedSeats.join(', ');
    });
});
//  chuyển trang 
const seatsContainers = document.querySelector('.seats');
const selectedSeatss = [];

seatsContainers.addEventListener('click', handleSeatClick);

function handleSeatClick(event) {
    if (event.target.classList.contains('seat')) {
        const seatId = event.target.dataset.seat;
        const seatIndex = selectedSeatss.indexOf(seatId);

        // Toggle selection
        if (seatIndex === -1) {
            selectedSeatss.push(seatId);
            event.target.classList.add('selected'); 
        } else {
            selectedSeatss.splice(seatIndex, 1);
            event.target.classList.remove('selected');
        }

        updateSelectedSeatsDisplay();
    }
}

function updateSelectedSeatsDisplay() {
    const selectedSeatsSpan = document.getElementById('selectedSeatss');
    if (selectedSeatss.length > 0) {
        selectedSeatsSpan.textContent = selectedSeatss.join(', ');
    } else {
        selectedSeatsSpan.textContent = 'Không có ghế nào được chọn';
    }
}

const nextButton = document.getElementById('nextButton');
nextButton.addEventListener('click', () => {
    if (selectedSeatss.length > 0) {
        window.location.href = 'dichvu1.html';
    } else {
        alert('Vui lòng chọn ghế trước khi tiếp tục!');
    }
});

// Gọi updateSelectedSeatsDisplay ban đầu để hiển thị bất kỳ chỗ ngồi nào được chọn trước
updateSelectedSeatsDisplay();



// trở lại trang chủ
// const backButton = document.querySelector('.back');

// backButton.addEventListener('click', (event) => {
//     event.preventDefault();

//     const homePageContent = `
//         <h1>Trang chủ</h1>
//         <p>Đây là nội dung trang chủ.</p>
//     `;
//     document.body.innerHTML = homePageContent;
// });