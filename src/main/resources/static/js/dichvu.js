approute.controller("dichvu", ['$scope', '$location', '$http', '$routeParams', function ($scope, $location, $http, $routeParams) {
    $scope.services = [];
    $scope.form = {
        name: '',
        price: 0,
        quantity: 0,
        images: '',
        status: true,
        createdAt: new Date(),
        updatedAt: new Date()
    };
    
    var id = $routeParams.id;  // Lấy ID từ URL (nếu có)
    $scope.isNew = !id;

    isNew = !id;
    $scope.currentPage = 0; // Trang hiện tại
    $scope.pageSize = 5; // Kích thước mỗi trang
    $scope.searchQuery = ''; // Search query variable
    $scope.filteredServices = []; // Filtered services list

    $scope.searchServices = function () {
    $http.get(`/rest/services/search?keyword=` + $scope.searchQuery)
        .then(resp => {
        $scope.filteredServices = resp.data;
        })
        .catch(error => {
        console.error('Error fetching services:', error);
        });
    };

    $scope.filterServices = function () {
    if ($scope.searchQuery) {
        $scope.searchServices(); // Fetch services based on search query
    } else {
        $scope.filteredServices = []; // Clear filtered list if no query
    }
    };

    $scope.selectService = function (service) {
    $scope.form = angular.copy(service); // Copy selected service to form
    $scope.filteredServices = []; // Clear filtered list
    $scope.suaDichVu(service.id); // Call your "suaDichVu" function
    };

    $scope.timKiem = function () { // Assuming this is the search button click handler
    $scope.filterServices(); // Trigger filtering based on search query
    };   
    //cách 1
    // $scope.xuatExcel = function () {
    //     $http({
    //         method: 'GET',
    //         url: `/rest/services/excel`,
    //        responseType: 'arraybuffer'
    //     }).then(resp => {
    //         const blob = new Blob([resp.data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
    //         const url = window.URL.createObjectURL(blob);
    //         const a = document.createElement('a');
    //         a.href = url;
    //         a.download = 'services.xlsx';
    //         document.body.appendChild(a);
    //         a.click();
    //         // Giải phóng bộ nhớ sau khi tải
    //         document.body.removeChild(a);
    //         window.URL.revokeObjectURL(url);
    //         // Thông báo người dùng sau khi tải xong
    //        alert("File excel đã được tải ,vui lòng kiểm tra thư mục dowload");
    //     }).catch(error => {
    //       console.log(error);
    //     });
    // };
    //cách 2
    $scope.xuatExcel = function () {
        $http({
            method: 'GET',
            url: `/rest/services/excel`,
            responseType: 'arraybuffer'
        }).then(resp => {
            const blob = new Blob([resp.data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
            const url = window.URL.createObjectURL(blob);
            const a = document.createElement('a');
    
            a.href = url;
            a.download = 'services.xlsx';
    
            // Thêm sự kiện onload và lỗi
            a.onload = () => {
                // Giải phóng bộ nhớ
                document.body.removeChild(a);
                window.URL.revokeObjectURL(url);
                // Hiển thị thông báo sau khi tải xong
                alert("File excel đã được tải ,vui lòng kiểm tra thư mục download");
            };
            a.onerror = () => {
                console.error('Lỗi khi tải xuống file');
            };
    
            document.body.appendChild(a);
            a.click();
        }).catch(error => {
            console.error('Lỗi khi gọi API:', error);
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
    $scope.load = function () {
        $http.get('/rest/services')
            .then(resp => {
                $scope.services = resp.data;
            })
            .catch(error => {
                console.log(error);
            });
    };

    // Hàm chuyển hướng đến trang danh sách dịch vụ
    $scope.danhsach = function () {
        $location.path(`/dichvu`);
    };
    // Hàm để thêm dịch vụ mới
    $scope.themDichvu = function () {
        $location.path('/editdichvu');  // Chuyển đến trang thêm dịch vụ mới
    };

    // Hàm chuyển hướng đến trang chỉnh sửa với ID
    $scope.suaDichVu = function (id) {
        $location.path(`/editdichvu/${id}`);
    };

    // Khi nhấn nút "Edit", chuyển hướng đến trang chỉnh sửa kèm ID
    $scope.edit = function (item) {
        $scope.suaDichVu(item.id);
        console.log(item);
    };

    // Kiểm tra nếu có ID trong URL thì gọi API lấy chi tiết dịch vụ
    if (id) {
        $http.get(`/rest/services/${id}`).then(resp => {
            $scope.form = resp.data;
            if ($scope.form.createdAt) {
                $scope.form.createdAt = new Date($scope.form.createdAt);
            }
            if ($scope.form.updatedAt) {
                $scope.form.updatedAt = new Date();
            }
        }).catch(error => {
            console.log(error);
        });
    }

    // Hàm tạo hoặc lưu dịch vụ
    $scope.saveOrCreate = function () {
        if ($scope.isNew) {
            // Tạo dịch vụ mới
            $http.post(`/rest/services`, $scope.form).then(resp => {
                $scope.services.push(resp.data);
                alert("Thêm dịch vụ mới thành công");
                $scope.danhsach(); // Điều hướng về danh sách dịch vụ
            }).catch(error => {
                alert("Tên dịch vụ đã tồn tại! Vui lòng nhập tên dịch vụ khác!");
                console.log(error);
            });
        } else {
            // Lưu chỉnh sửa dịch vụ
            $http.put(`/rest/services/${id}`, $scope.form).then(resp => {
                var index = $scope.services.findIndex(p => p.id == $scope.form.id);
                if (index !== -1) {
                    $scope.form.createdAt = 
                    $scope.services[index] = resp.data;
                }
                alert("Lưu dịch vụ thành công");
                $scope.danhsach(); // Điều hướng về danh sách dịch vụ
            }).catch(error => {
                console.log(error);
            });
        }
    };

    // Xóa dịch vụ
    $scope.delete = function (item) {
        $http.delete(`/rest/services/${item}`).then(resp => {
            var index = $scope.services.findIndex(p => p.id == item);
            if (index !== -1) {
                $scope.services.splice(index, 1);
            }
            alert("Xóa dịch vụ thành công");
            $scope.load(); // Tải lại danh sách dịch vụ sau khi xóa
        }).catch(error => {
            console.log(error);
        });
    };

     
    
    
    $scope.load = function () {
        $http.get(`/rest/services/list?roleIds=1,2&page=${$scope.currentPage}&size=${$scope.pageSize}`)
    .then(resp => {
      $scope.services = resp.data.content; // Update services array
      $scope.totalPages = resp.data.totalPages; // Update total pages

      // Loop through services and format birthDay if present
      $scope.services.forEach(item => {
        if (item.hasOwnProperty('birthDay')) { // Check if birthDay exists
          item.birthDay = new Date(item.birthDay);
        }
      });
    })
    .catch(error => {
      console.error('Error loading services:', error);
    });
    };
    
    
    $scope.first = function () {
        $scope.currentPage = 0;
        $scope.load();
    };
    
    $scope.last = function () {
        $scope.currentPage = $scope.totalPages - 1;
        $scope.load();
    };
    
    $scope.nextPage = function () {
        if ($scope.currentPage < $scope.totalPages - 1) {
            $scope.currentPage++;
            $scope.load();
        }
    };
    
    $scope.prevPage = function () {
        if ($scope.currentPage > 0) {
            $scope.currentPage--;
            $scope.load();
        }
    };
    

    // Gọi hàm load để tải danh sách dịch vụ khi controller được khởi tạo
    $scope.load();
}]);
