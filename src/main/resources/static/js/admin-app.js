var approute = angular.module("admin-app", ["ngRoute"]);
//approute á nha
approute.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "/admin/thongke/thongke.html"


        })
        .when("/taikhoan", {
            templateUrl: "/admin/taikhoan/taikhoan.html",
            controller: "taikhoan"
        })
        .when("/edittaikhoan/:id?", {
            templateUrl: "/admin/taikhoan/edittaikhoan.html",
            controller: "taikhoan"
        })
        .when("/khachhang", {
            templateUrl: "/admin/khachhang/khachhang.html",
            controller: "khachhang"
        })
        .when("/editkhachhang/:id?", {
            templateUrl: "/admin/khachhang/editkhachhang.html",
            controller: "khachhang"
        })
        .when("/ghe", {
            templateUrl: "/admin/ghe/ghe.html",
            controller: "ghe"
        })
        .when("/editghe/:id?", {
            templateUrl: "/admin/ghe/editghe.html",
            controller: "ghe"
        })
        .when("/theloai", {
            templateUrl: "/admin/theloai/theloai.html",
            controller: "theloai"
        })
        .when("/edittheloai", {
            templateUrl: "/admin/theloai/edittheloai.html",
            controller: "theloai"
        })
        .when("/rapchieu", {
            templateUrl: "/admin/rapchieu/rapchieu.html",
            controller: "rap"

        })
        .when("/editrap", {
            templateUrl: "/admin/rapchieu/editrap.html",
            controller: "rap"
        })
        .when("/tintuc", {
            templateUrl: "/admin/tintuc/tintuc.html",
            controller: "tintuc"
        })
        .when("/edittintuc", {
            templateUrl: "/admin/tintuc/edittintuc.html",
            controller: "tintuc"
        })
        .when("/phong", {
            templateUrl: "/admin/phong/phong.html",
            controller: "phong"
        })
        .when("/editphong/:id?", {
            templateUrl: "/admin/phong/editphong.html",
            controller: "phong"
        })
        .when("/dichvu", {
            templateUrl: "/admin/dichvu/dichvu.html",
            controller: "dichvu"
        })
        .when("/editdichvu/:id?", {
            templateUrl: "/admin/dichvu/editdichvu.html",
            controller: "dichvu"
        })

        .when("/phim", {
            templateUrl: "/admin/phim/phim.html",
            controller: "phim"

        })
        .when("/editphim", {
            templateUrl: "/admin/phim/editphim.html",
            controller: "phim"

        })
        .when("/lichchieu", {
            templateUrl: "/admin/lichchieu/lichchieu.html",
            controller: "lichchieu"


        })
        .when("/editlichchieu", {
            templateUrl: "/admin/lichchieu/editlichchieu.html",
            controller: "lichchieu"

        })
        .when("/datve", {
            templateUrl: "/admin/datve.html"


        })


});
