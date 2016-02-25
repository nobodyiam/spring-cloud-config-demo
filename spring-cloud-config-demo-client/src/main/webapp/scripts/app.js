(function ($) {
    var app = angular.module('CloudConfig', [
        'ui.bootstrap',
        'toastr',
        'angular-loading-bar',
        'httpInterceptors' //custom http interceptor
    ]);

    app.controller('CloudConfigController', function ($scope, $http, $modal, toastr) {
        this.env = {};

        var self = this;

        this.loadEnv = function() {
            $http.get("demo/env")
                .success(function (data) {
                    self.env = data;
                })
                .error(function (data, status) {
                    toastr.error((data && data.msg) || 'Loading failed');
                });
        };

        this.loadEnv();

    });

})(jQuery);