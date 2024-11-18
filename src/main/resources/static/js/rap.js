approute.controller("rap", ['$scope', '$location', function ($scope, $location) {
    $scope.themRap = function () {
        $location.path('editrap');  // Thay đổi đường dẫn khi nhấn nút
    }
    $scope.goToDanhSach = function () {
        $location.path('/rapchieu');
    };
}]);
