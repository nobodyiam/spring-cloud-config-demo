(function ($) {
    var app = angular.module('CloudConfig', [
        'ui.bootstrap',
        'toastr',
        'angular-loading-bar',
        'httpInterceptors' //custom http interceptor
    ]);

    app.controller('CloudConfigController', function ($scope, $http, $modal, toastr) {
        this.env = {};
        this.configQuery = {};

        var self = this;

        this.loadEnv = function() {
            $http.get("demo/env")
                .success(function (data) {
                    self.env = data;
                })
                .error(function (data, status) {
                    toastr.error((data && data.msg) || 'Loading env failed');
                });
        };

        this.queryConfig = function() {
            $http.get("demo/config/" + this.configQuery.configName)
                .success(function(data) {
                    self.configQuery.configValue = data.value;
                })
                .error(function(data, status) {
                    toastr.error((data && data.msg) || 'Load config failed');
                });
        };

        this.loadEnv();

    });

})(jQuery);