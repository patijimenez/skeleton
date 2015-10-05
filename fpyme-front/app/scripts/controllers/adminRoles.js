(function () {
'use strict';

angular.module('fpymeFrontApp')
    .controller('AdminRolesCtrl', function ($scope, $log, $location) {

        angular.element(document).ready(function () {

            $scope.permissions = jQuery('[name=permissions]').val();

            if(!angular.isUndefined($scope.permissions) && !$scope.permissions.isEmpty){

                $scope.lista = $scope.permissions.substring(1,$scope.permissions.length -1)
                $scope.lista = $scope.lista.split(',');

                $.each($scope.lista, function(i,item){
                    $scope.role.permissionsList.push(item.trim());
                });
                $scope.role.permissionsList = _.sortBy($scope.role.permissionsList, function(item){
                  return item;
                });
                jQuery('[name=permissionslist]').val(JSON.stringify($scope.role.permissionsList));
            }
        });

        $scope.role = {
            permissionsList: []

        };

        $scope.addPermission = function(permission) {
            if(!angular.isUndefined(permission)){
                $scope.error = false;
                $.each($scope.role.permissionsList, function(i,item){
                    if(item==permission){
                        $scope.error = true;
                        $scope.message = "El permiso " +  permission + " ya ha sido agregado.";
                    }
                });

                if(!$scope.error){
                  $scope.role.permissionsList.push(permission);
                  $scope.role.permissionsList = _.sortBy($scope.role.permissionsList, function(item){
                    return item;
                  });
                  jQuery('[name=permissionslist]').val(JSON.stringify($scope.role.permissionsList));
                  $scope.permission = undefined;
                }

            }else{
                $scope.error = true;
                $scope.message = "El campo permiso es requerido.";
            }

        };

        $scope.deletePermission = function(item) {
            var index =$scope.role.permissionsList.indexOf(item);
            $scope.role.permissionsList.splice(index,1);
            jQuery('[name=permissionslist]').val(JSON.stringify($scope.role.permissionsList));
        };

    });
}());
