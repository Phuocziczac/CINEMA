approute.controller('ghe', ['$scope', '$http', '$location', '$routeParams', function ($scope, $http, $location, $routeParams) {
    // Initialize room, seat, and seat class lists
    $scope.rooms = [];
    $scope.seats = [];
    $scope.selectedRoomId = null;
    $scope.selectedSeat = {};
    $scope.newSeat = {};
    $scope.seatClasses = [];
    $scope.isRoomVisible = true;  // Khi bạn muốn hiển thị select
    var id = $routeParams.id;
    $scope.isNew = !id;
    // Load room list from API
    $scope.loadRooms = function () {
        $http.get('/rest/seats/room').then(function (response) {
            $scope.rooms = response.data;
        }, function (error) {
            console.error('Error loading room:', error);
        });
    };

    // Load seat class list from API
    $scope.loadSeatClasses = function () {
        $http.get('/rest/seats/seatclass').then(function (response) {
            $scope.seatClasses = response.data;
        }, function (error) {
            console.error('Error loading seat classes:', error);
        });
    };

    // Load seats by room ID from API
    $scope.loadSeatsByRoom = function (roomId) {
        console.log(roomId);
        if (!roomId) return;

        $http.get('/rest/seats/room/' + roomId).then(function (response) {
            const rows = {};
            if (response.data.length === 0) {
                console.log('Phòng này không có dữ liệu ghế');
                $scope.seats = []; // Đặt mảng ghế trống nếu không có dữ liệu
            } else {
                response.data.forEach(seat => {
                    const row = seat.rowNumber;
                    if (!rows[row]) rows[row] = [];
                    rows[row].push(seat);
                });
                $scope.seats = Object.values(rows);
                console.log(Object.values(rows));
            }
        }, function (error) {
            console.error('Error loading seats:', error);
        });
    };

    // Toggle seat selection
    $scope.toggleSeat = function (seat) {
        if (seat.status) {
            seat.selected = !seat.selected;
        }
    };


    // Mở modal cho chế độ Sửa
    $scope.editSeat = function (seat) {
        $scope.isEditMode = true; // Chế độ Sửa
        $scope.newSeat = angular.copy(seat);  // Sao chép thông tin ghế vào newSeat
        $scope.newSeat.seatClassId = seat.seatClass.id;  // Gán id của seatClass cho ng-model seatClassId
        $scope.newSeat.room = { id: $scope.selectedOption };
        // Gán roomId cho selectedOption
        $('#exampleModal').modal('show'); // Hiển thị modal
    };

    // Mở modal cho chế độ Thêm mới
    $scope.openModal = function () {
        if ($scope.selectedOption == null) {
            alert("vui lòng chọn phòng trước thêm ghế")
        } else {
            $scope.isEditMode = false; // Chế độ Thêm mới
            $scope.newSeat = {}; // Reset form datas
            $scope.newSeat.room = { id: $scope.selectedOption };

            $('#exampleModal').modal('show'); // Hiển thị modal

        }

    };

    // Lưu hoặc Cập nhật ghế
    $scope.saveSeat = function () {
        // Cập nhật thông tin room và seatClass trước khi gửi request
        $scope.newSeat.room = { "id": $scope.selectedOption };
        $scope.newSeat.seatClass = { "id": $scope.newSeat.seatClassId };

        if ($scope.isEditMode) {
            // Thực hiện cập nhật ghế
            $http.put(`/rest/seats/${$scope.newSeat.id}`, $scope.newSeat)
                .then(function (response) {
                    const index = $scope.seats.findIndex(s => s.id === response.data.id);
                    if (index !== -1) {
                        $scope.seats[index] = response.data; // Cập nhật dữ liệu ghế sau khi sửa
                    }
                    $('#exampleModal').modal('hide'); // Đóng modal
                    alert("Ghế đã được sửa thành công!");
                    $scope.loadSeatsByRoom($scope.selectedOption); // Tải lại danh sách ghế
                })
                .catch(function (error) {
                    if (error.status === 409) {
                        alert("Ghế này đã tồn tại!");
                    } else {
                        console.error("Lỗi cập nhật ghế:", error);
                        alert("Ghế này đã tồn tại!");
                    }
                });
        } else {
            // Thực hiện thêm mới ghế
            $http.post('/rest/seats', $scope.newSeat)
                .then(function (response) {
                    $scope.seats.push(response.data); // Thêm ghế mới vào danh sách
                    $('#exampleModal').modal('hide'); // Đóng modal
                    alert("Ghế đã được thêm thành công!");
                    $scope.loadSeatsByRoom($scope.selectedOption); // Tải lại danh sách ghế
                })
                .catch(function (error) {
                    if (error.status === 409) {
                        alert("Ghế này đã tồn tại!");
                    } else {
                        console.error("Lỗi thêm ghế:", error);
                        alert("Ghế này đã tồn tại!");
                    }
                });
        }
    };

    $scope.xoaGhe = function () {
        $http.delete(`/rest/seats/${$scope.newSeat.id}`)
            .then(function (response) {
                const index = $scope.seats.findIndex(s => s.id === $scope.newSeat.id); // Tìm vị trí của ghế cần xóa trong danh sách seats
                if (index !== -1) {
                    $scope.seats.splice(index, 1); // Xóa ghế khỏi danh sách
                }
                $('#exampleModal').modal('hide'); // Đóng modal
                alert("Ghế đã được xóa thành công!");
                $scope.loadSeatsByRoom($scope.selectedOption); // Tải lại danh sách ghế theo phòng đã chọn
            })
            .catch(function (error) {

                console.error("Lỗi xóa ghế:", error);
                alert("Đã xảy ra lỗi khi xóa ghế!");

            });
    };


    $scope.edit = function (id) {
        $location.path(`/editghe/${id}`);
    }
    $scope.danhsach = function () {
        $location.path(`/ghe`);
    }
    $scope.themLoaiGhe = function (id) {
        $location.path(`/editghe`);
    }
    if (id) {
        $http.get(`/rest/seatclass/${id}`).then(resp => {
            $scope.form = resp.data;

        }).catch(error => {
            console.log(error);
        });
    }
    // Hàm tạo hoặc lưu tài khoản
    $scope.saveOrCreate = function () {
        if ($scope.isNew) {
            // Tạo tài khoản mới
            $http.post(`/rest/seatclass`, $scope.form).then(resp => {
                $scope.seatClasses.push(resp.data);
                alert("Thêm mới thành công");
                $scope.danhsach(); // Điều hướng về danh sách tài khoản
            }).catch(error => {
                console.log(error);
            });
        } else {
            // Lưu chỉnh sửa tài khoản
            $http.put(`rest/seatclass/${id}`, $scope.form).then(resp => {
                var index = $scope.seatClasses.findIndex(p => p.id == $scope.form.id);
                if (index !== -1) {
                    $scope.seatClasses[index] = resp.data;
                }
                alert("Lưu Lớp ghế  thành công");
                $scope.danhsach(); // Điều hướng về danh sách tài khoản
            }).catch(error => {
                console.log(error);
            });
        }
    };
    $scope.delete = function (item) {
        $http.delete(`/rest/seatclass/${item}`).then(resp => {
            var index = $scope.seatClasses.findIndex(p => p.id == item);
            if (index !== -1) {
                $scope.seatClasses.splice(index, 1);
            }
            alert("Xóa thành công");
            $scope.danhsach();
            $scope.loadRooms(); // Điều hướng về danh sách tài khoản
        }).catch(error => {
            console.log(error);
        });
    };
    // Initialize data when the page loads
    $scope.loadRooms();
    $scope.loadSeatClasses();
}]);
