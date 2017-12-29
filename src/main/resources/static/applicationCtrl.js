var qrApp = angular.module('qrApp', []);
qrApp.controller('ApplicationCtrl', function ($scope, $http) {

    $scope.sizes = [150, 300, 500];
    $scope.size;
    $scope.fileTypes = ['png', 'jpg']
    $scope.fileType = '';
    $scope.content = '';

    $scope.generate = function() {
        var qrDto = {};
        qrDto.content = $scope.content;
        qrDto.size = $scope.size;
        qrDto.fileType = $scope.fileType;

        $http.post('/qr/generate', qrDto).success(function(){
            console.log("QR code has been generated");
        });
        location.reload();
    }

});