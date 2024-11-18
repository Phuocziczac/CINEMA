approute.controller("phong", ['$scope', '$location', '$http', '$routeParams', function ($scope, $location, $http, $routeParams) {
    $scope.themPhong = function () {
        $location.path('editphong');  // Thay đổi đường dẫn khi nhấn nút
    }
    var id = $routeParams.id;  // Lấy ID từ URL (nếu có)
    $scope.isNew = !id;
    $scope.rooms = [];
    $scope.form = {};
    $scope.currentPage = 0;
    $scope.pageSize = 5;
    $scope.searchQuery = ''; // Biến lưu từ khóa tìm kiếm
    $scope.filteredRooms = []; // Danh sách tài khoản đã lọc
    $scope.searchRooms = function () {
        $http.get(`/rest/room/search?keyword=` + $scope.searchQuery)
            .then(resp => {
                $scope.filteredRooms = resp.data;  // This should match the response structure
            })
            .catch(error => {
                console.log(error);
            });
    };


    $scope.filterRooms = function () {
        if ($scope.searchQuery) {
            // Lọc danh sách tài khoản dựa trên từ khóa tìm kiếm
            $scope.searchRooms();
        } else {
            $scope.filteredRooms = []; // Nếu không có từ khóa, đặt danh sách gợi ý thành rỗng
        }
    };

    // Hàm chọn tài khoản từ gợi ý
    $scope.selectRoom = function (room) {
        $scope.form = angular.copy(room); // Sao chép tài khoản đã chọn vào form
        $scope.filteredRooms = []; // Xóa danh sách gợi ý
        $scope.suaRoom(room.id)
    };
    $scope.timKiem = function () {
        $scope.rooms = $scope.filteredRooms;
        $scope.filteredRooms = 0;
    }
    $scope.xuatExcel = function () {
        $http({
            method: 'GET',
            url: `/rest/room/excel`,
            responseType: 'arraybuffer'
        }).then(resp => {
            const blob = new Blob([resp.data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
            const url = window.URL.createObjectURL(blob);

            const a = document.createElement('a');
            a.href = url;
            a.download = 'Room.xlsx';
            document.body.appendChild(a);
            a.click();

            // Giải phóng bộ nhớ sau khi tải
            document.body.removeChild(a);
            window.URL.revokeObjectURL(url);

            // Thông báo người dùng sau khi tải xong
            alert("File excel đã được tải ,vui lòng kiểm tra thư mục dowload");
        }).catch(error => {
            console.log(error);
        });
    };
    $scope.load = function () {
        $http.get(`/rest/room/list?page=${$scope.currentPage}&size=${$scope.pageSize}`).then(resp => {
            $scope.rooms = resp.data.content;
            $scope.totalPages = resp.data.totalPages;
        }).catch(error => {
            console.log(error);
        })
    }
    $scope.danhsach = function () {
        $location.path(`/phong`)
    }
    // Hàm chuyển hướng đến trang chỉnh sửa với ID
    $scope.suaRoom = function (id) {
        $location.path(`/editphong/${id}`);  // Điều hướng đến trang chỉnh sửa với ID
    };
    // Khi nhấn nút "Edit", chuyển hướng đến trang chỉnh sửa kèm ID
    $scope.edit = function (item) {
        $scope.suaRoom(item.id);  // Điều hướng với ID của tài khoản được chọn
    };

    if (id) {
        $http.get(`/rest/room/${id}`).then(resp => {
            $scope.form = resp.data;

        }).catch(error => {
            console.log(error);
        });
    }

    // Hàm tạo hoặc lưu tài khoản
    $scope.saveOrCreate = function () {
        if ($scope.isNew) {
            // Tạo tài khoản mới
            $http.post(`/rest/room`, $scope.form).then(resp => {
                $scope.rooms.push(resp.data);
                alert("Thêm phòng  mới thành công");
                $scope.danhsach(); // Điều hướng về danh sách tài khoản
            }).catch(error => {
                console.log(error);
            });
        } else {
            // Lưu chỉnh sửa tài khoản
            $http.put(`/rest/room/${id}`, $scope.form).then(resp => {
                var index = $scope.rooms.findIndex(p => p.id == $scope.form.id);
                if (index !== -1) {
                    $scope.account[index] = resp.data;
                }
                alert("Lưu phòng thành công");
                $scope.danhsach(); // Điều hướng về danh sách tài khoản
            }).catch(error => {
                console.log(error);
            });
        }
    };
    // Xóa tài khoản
    $scope.delete = function (item) {
        $http.delete(`/rest/room/${item}`).then(resp => {
            var index = $scope.rooms.findIndex(p => p.id == item);
            if (index !== -1) {
                $scope.rooms.splice(index, 1);
            }
            alert("Xóa thành công");
            $scope.danhsach();
            $scope.load(); // Điều hướng về danh sách tài khoản
        }).catch(error => {
            console.log(error);
        });
    };
    $scope.first = function () {

        $scope.currentPage = 0;
        $scope.load(); // Tải dữ liệu cho trang mới

    };
    $scope.last = function () {

        $scope.currentPage = $scope.totalPages - 1;
        $scope.load(); // Tải dữ liệu cho trang mới

    };
    $scope.nextPage = function () {
        if ($scope.currentPage < $scope.totalPages - 1) {
            $scope.currentPage++;
            $scope.load(); // Tải dữ liệu cho trang mới
        }
    };

    $scope.prevPage = function () {
        if ($scope.currentPage > 0) {
            $scope.currentPage--;
            $scope.load(); // Tải dữ liệu cho trang mới
        }
    };
    $scope.load();
}]);
