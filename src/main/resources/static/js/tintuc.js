approute.controller("tintuc", ['$scope', '$location', function ($scope, $location) {
    $scope.themTinTuc = function () {
        $location.path('edittintuc');  // Thay đổi đường dẫn khi nhấn nút
    }
}]);
