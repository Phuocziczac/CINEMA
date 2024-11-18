approute.controller('lichchieu', ['$scope', '$http', '$location', '$rootScope', function ($scope, $http, $location, $rootScope) {
    $scope.schedules = [];
    $scope.selectedSchedule = {};
    $scope.movies = [];
    $scope.showtimes = [];

    $scope.loadSchedules = function () {
        $http.get('/rest/schedule').then(function (response) {
            var schedules = response.data;
            var schedulesMap = {};

            // Load showtimes for each schedule
            var loadShowtimesPromises = schedules.map(function (schedule) {
                return $http.get('/rest/schedule/showtimes/' + schedule.id).then(function (showtimeResponse) {
                    var key = schedule.screeningDate + '-' + schedule.movie.name;
                    if (!schedulesMap[key]) {
                        schedulesMap[key] = {
                            screeningDate: schedule.screeningDate,
                            movie: schedule.movie,
                            showtimes: []
                        };
                    }
                    schedulesMap[key].showtimes = schedulesMap[key].showtimes.concat(showtimeResponse.data);

                    // Sort showtimes within each schedule by time
                    schedulesMap[key].showtimes.sort(function (a, b) {
                        return new Date(a.time) - new Date(b.time);
                    });
                });
            });

            // Once all showtimes are loaded, convert the map to an array, sort by screeningDate, and update the scope
            Promise.all(loadShowtimesPromises).then(function () {
                $scope.schedules = Object.values(schedulesMap);

                // Sort schedules by screeningDate
                $scope.schedules.sort(function (a, b) {
                    return new Date(a.screeningDate) - new Date(b.screeningDate);
                });

                $scope.$apply(); // Apply the scope changes
            });
        }, function (error) {
            console.error('Error loading schedules:', error);
        });
    };

    // Load movie list from API
    $scope.loadMovies = function () {
        $http.get('/rest/movies').then(function (response) {
            $scope.movies = response.data;
        }, function (error) {
            console.error('Error loading movies:', error);
        });
    };

    // Load showtime list from API
    $scope.loadShowtimes = function () {
        $http.get('/rest/showtime').then(function (response) {
            $scope.showtimes = response.data;
        }, function (error) {
            console.error('Error loading showtimes:', error);
        });
    };

    // Redirect to themlichchieu.html to add new schedule
    $scope.openAddSchedulePage = function () {
        $rootScope.isNew = true;
        $rootScope.selectedSchedule = {};  // Reset selectedSchedule when creating a new one
        $location.path('/themlichchieu');
    };

    // Redirect to themlichchieu.html to edit existing schedule
    $scope.editSchedule = function (schedule) {
        $rootScope.isNew = false;
        $rootScope.selectedSchedule = schedule;
        $location.path('/themlichchieu').search({ id: schedule.id });
    };

    $scope.danhSachLichChieu = function () {
        $location.path('/lichchieu');
    };

    // Delete schedule
    $scope.xoaLichChieu = function (id) {
        if (confirm("Bạn có chắc chắn muốn xóa lịch chiếu này?")) {
            $http.delete('/rest/schedule/' + id).then(function (response) {
                alert("Lịch chiếu đã được xóa thành công!");
                $scope.loadSchedules();
            }, function (error) {
                console.error('Error deleting schedule:', error);
                alert("Xóa lịch chiếu thất bại!");
            });
        }
    };

    // Initialize data when the page loads
    $scope.loadSchedules();
    $scope.loadMovies();
    $scope.loadShowtimes();
}]);
approute.controller('themlichchieu', ['$scope', '$rootScope', '$http', '$location', '$routeParams', function ($scope, $rootScope, $http, $location, $routeParams) {
    $scope.isNew = $rootScope.isNew;
    $scope.selectedSchedule = $rootScope.selectedSchedule || {};

    // Load data if ID is present in URL
    var id = $routeParams.id;
    if (id) {
        $http.get('/rest/schedule/' + id).then(function (response) {
            $scope.selectedSchedule = response.data;
        }, function (error) {
            console.error('Error loading schedule:', error);
        });
    }

    $scope.saveOrCreate = function () {
        if ($scope.isNew) {
            // Tạo lịch chiếu mới
            $http.post('/rest/schedule', $scope.selectedSchedule).then(function (response) {
                alert('Lịch chiếu đã được tạo thành công!');
                $location.path('/lichchieu');
            }, function (error) {
                console.error('Error creating schedule:', error);
                alert('Tạo lịch chiếu thất bại!');
            });
        } else {
            // Lưu lịch chiếu đã chỉnh sửa
            $http.put('/rest/schedule/' + $scope.selectedSchedule.id, $scope.selectedSchedule).then(function (response) {
                alert('Lịch chiếu đã được cập nhật thành công!');
                $location.path('/lichchieu');
            }, function (error) {
                console.error('Error updating schedule:', error);
                alert('Cập nhật lịch chiếu thất bại!');
            });
        }
    };

    $scope.danhSachLichChieu = function () {
        $location.path('/lichchieu');
    };
}]);
