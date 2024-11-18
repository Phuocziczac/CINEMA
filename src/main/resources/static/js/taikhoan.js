approute.controller("taikhoan", ['$scope', '$location', '$http', '$routeParams', function ($scope, $location, $http, $routeParams) {
    $scope.account = [];
    $scope.roles = [];
    $scope.form = {
        username: '',
        password: '',
        email: '',
        fullname: '',
        birthDay: new Date(), // Giá trị mặc định cho ngày sinh
        gender: true,
        phone: '',
        images: '',
        role: {} // Khởi tạo rỗng
    };
    var id = $routeParams.id;  // Lấy ID từ URL (nếu có)
    $scope.isNew = !id;
    $scope.currentPage = 0; // Trang hiện tại
    $scope.pageSize = 5; // Kích thước mỗi trang
    $scope.searchQuery = ''; // Biến lưu từ khóa tìm kiếm
    $scope.filteredAccounts = []; // Danh sách tài khoản đã lọc
    $scope.searchAccounts = function () {
        $http.get(`/rest/account/search?keyword=` + $scope.searchQuery) // Thay keyword bằng searchQuery
            .then(resp => {
                $scope.filteredAccounts = resp.data;
            })
            .catch(error => {
                console.log(error);
            });
    };

    $scope.filterAccounts = function () {
        if ($scope.searchQuery) {
            // Lọc danh sách tài khoản dựa trên từ khóa tìm kiếm
            $scope.searchAccounts();
        } else {
            $scope.filteredAccounts = []; // Nếu không có từ khóa, đặt danh sách gợi ý thành rỗng
        }
    };

    // Hàm chọn tài khoản từ gợi ý
    $scope.selectAccount = function (account) {
        $scope.form = angular.copy(account); // Sao chép tài khoản đã chọn vào form
        $scope.filteredAccounts = []; // Xóa danh sách gợi ý
        $scope.suaTaiKhoan(account.id)
    };
    $scope.timKiem = function () {
        $scope.account = $scope.filteredAccounts;
        $scope.filteredAccounts = 0;
    }
    $scope.xuatExcel = function () {
        $http({
            method: 'GET',
            url: `/rest/account/excel`,
            responseType: 'arraybuffer'
        }).then(resp => {
            const blob = new Blob([resp.data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
            const url = window.URL.createObjectURL(blob);

            const a = document.createElement('a');
            a.href = url;
            a.download = 'accounts.xlsx';
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
    $scope.imageChanged = function (files) {
        if (files.length > 0) {
            var data = new FormData();
            data.append('file', files[0]);

            $http.post('/rest/upload/images', data, {
                transformRequest: angular.identity,
                headers: { 'Content-Type': undefined }
            }).then(resp => {
                // Giả sử resp.data.name chứa tên file
                $scope.form.images = resp.data.name; // Cập nhật tên hình ảnh

            }).catch(error => {
                alert("Lỗi load hình ảnh: " + (error.data && error.data.message ? error.data.message : 'Unknown error'));
                console.log("error", error);
            });
        } else {
            alert("Vui lòng chọn hình ảnh.");
        }
    };






    // Hàm chuyển hướng đến trang danh sách tài khoản
    $scope.danhsach = function () {
        $location.path(`/taikhoan`);
    }
    // Hàm để thêm tài khoản mới
    $scope.themTaiKhoan = function () {
        $location.path('/edittaikhoan');  // Không có ID, chỉ đến trang thêm tài khoản mới
    };

    // Hàm chuyển hướng đến trang chỉnh sửa với ID
    $scope.suaTaiKhoan = function (id) {
        $location.path(`/edittaikhoan/${id}`);  // Điều hướng đến trang chỉnh sửa với ID
    };
    // Khi nhấn nút "Edit", chuyển hướng đến trang chỉnh sửa kèm ID
    $scope.edit = function (item) {
        $scope.suaTaiKhoan(item.id);  // Điều hướng với ID của tài khoản được chọn
    };


    // Load danh sách tài khoản
    $scope.load = function () {
        $http.get(`/rest/account/list?roleIds=1,2&page=${$scope.currentPage}&size=${$scope.pageSize}`).then(resp => {

            $scope.account = resp.data.content;
            $scope.totalPages = resp.data.totalPages; // Lưu tổng số trang để sử dụng khi phân trang
            $scope.account.forEach(item => {
                item.birthDay = new Date(item.birthDay);
            });
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

    // Load danh sách vai trò
    $scope.loadRoles = function () {
        $http.get(`/rest/account/role`).then(resp => {
            $scope.roles = resp.data;
        }).catch(error => {
            console.log(error);
        });
    };

    // Gọi hàm loadRoles khi controller được khởi tạo
    $scope.loadRoles();

    // Kiểm tra nếu có ID trong URL thì gọi API lấy chi tiết tài khoản
    if (id) {
        $http.get(`/rest/account/${id}`).then(resp => {
            $scope.form = resp.data;
            if ($scope.form.birthDay) {
                $scope.form.birthDay = new Date($scope.form.birthDay);
            }
        }).catch(error => {
            console.log(error);
        });
    }

    // Hàm tạo hoặc lưu tài khoản
    $scope.saveOrCreate = function () {
        if ($scope.isNew) {
            // Tạo tài khoản mới
            $http.post(`/rest/account`, $scope.form).then(resp => {
                $scope.account.push(resp.data);
                alert("Thêm tài khoản mới thành công");
                $scope.danhsach(); // Điều hướng về danh sách tài khoản
            }).catch(error => {
                console.log(error);
            });
        } else {
            // Lưu chỉnh sửa tài khoản
            $http.put(`/rest/account/${id}`, $scope.form).then(resp => {
                var index = $scope.account.findIndex(p => p.id == $scope.form.id);
                if (index !== -1) {
                    $scope.account[index] = resp.data;
                }
                alert("Lưu tài khoản thành công");
                $scope.danhsach(); // Điều hướng về danh sách tài khoản
            }).catch(error => {
                console.log(error);
            });
        }
    };

    // Xóa tài khoản
    $scope.delete = function (item) {
        $http.delete(`/rest/account/${item}`).then(resp => {
            var index = $scope.account.findIndex(p => p.id == item);
            if (index !== -1) {
                $scope.account.splice(index, 1);
            }
            alert("Xóa thành công");
            $scope.danhsach();
            $scope.load(); // Điều hướng về danh sách tài khoản
        }).catch(error => {
            console.log(error);
        });
    };
    //Tìm tài khoản

    // Gọi hàm load để tải danh sách tài khoản khi trang được tải
    $scope.load();
}]);
