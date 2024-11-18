approute.controller("theloai", ['$scope', '$location', function ($scope, $location) {
    $scope.themTheLoai= function () {
        $location.path('edittheloai');  // Thay đổi đường dẫn khi nhấn nút
    }
}]);
