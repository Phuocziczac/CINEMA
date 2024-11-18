approute.controller("phim", ['$scope', '$location', function ($scope, $location) {
    $scope.themPhim = function () {
        $location.path('editphim');  // Thay đổi đường dẫn khi nhấn nút
    }
}]);
