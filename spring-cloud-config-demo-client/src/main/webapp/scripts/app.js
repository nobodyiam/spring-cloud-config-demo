(function ($) {
    var app = angular.module('CloudConfig', [
        'ui.bootstrap',
        'toastr',
        'angular-loading-bar',
        'httpInterceptors' //custom http interceptor
    ]);

    app.controller('CloudConfigController', function ($scope, $http, $modal, toastr) {
        var NONE = "none";

        this.env = {};
        this.configQuery = {};
        this.refreshResult = NONE;

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
            $http.get("demo/config/" + encodeURIComponent(this.configQuery.configName))
                .success(function(data) {
                    self.configQuery.configValue = data.value;
                })
                .error(function(data, status) {
                    toastr.error((data && data.msg) || 'Load config failed');
                });
        };

        this.refreshConfig = function() {
            $http.post("refresh")
                .success(function(data) {
                    self.assembleRefreshResult(data);
                })
                .error(function(data, status) {
                    toastr.error((data && data.msg) || 'Refresh config failed');
                });

        };

        this.assembleRefreshResult = function(changedPropertyArray) {
            if(!changedPropertyArray || !changedPropertyArray.length) {
                this.refreshResult = NONE;
                return;
            }
            this.refreshResult = changedPropertyArray.join(',');
        }

        this.loadEnv();

    });

})(jQuery);