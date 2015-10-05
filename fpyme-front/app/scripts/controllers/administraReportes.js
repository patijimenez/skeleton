'use strict';

angular.module('fpymeFrontApp')
.controller('AdministraReportesCtrl', function($scope, $log, jobService) {
    var setError = null;
    var setInfo = null;
    $scope.noOfPages = null;
    $scope.currentPage = 1;
    $scope.maxSize = 5;

    $scope.adminOptions = {
        lineWrapping: true,
        lineNumbers: true,
        autofocus: true,
        matchBrackets: true,
        mode: 'text/x-groovy'
    };

    $scope.sendNow = function(reporte){
      $log.log(reporte);
      jobService.sendReportNow(reporte).then(function(data){
        if(data.status){
          setInfo("El reporte fue enviado")
        }
      });
    };

    $scope.JobsList = function(){
      jobService.getJobsList($scope.maxSize, $scope.currentPage, $scope.searchCriteria).then(function(data){
        $scope.reportsList = data.jobs;
        var numPages = Math.floor(data.total/$scope.maxSize);
        $scope.noOfPages = data.total % $scope.maxSize == 0 ? numPages : numPages + 1;
      });
    };

    $scope.$watch('currentPage', function(){
      $scope.JobsList();
    });

    $scope.reporte = {
        listaDestinatarios: []
    };

    $scope.addDestinatario = function() {
        $scope.reporte.listaDestinatarios.push($scope.email);
        $scope.email = "";
    };


    $scope.saveReport = function(){
      $scope.report = {};
      $scope.report.to = $scope.reporte.listaDestinatarios;
      $scope.report.name = $scope.name;
      $scope.report.query = $scope.query;
      $scope.report.cronExpression = $scope.cronExpression;
      $scope.report.description = $scope.description;
      $scope.report.language = $scope.language;

      jobService.saveReportJob($scope.report).then(function (data) {
        if(data.status){
          $scope.JobsList();
          setInfo("El reporte ha sido guardado y esta activo");
        }
        else{
          setError(data.message);
        }
      }, function (){

      });
    };

    $scope.deleteJob = function(report){
      jobService.deleteJob(report).then(function (data) {
        if(data.status){
          $scope.JobsList();
          setInfo("El reporte ha sido eliminado");
        }
        else{
          setError(data.message);
        }
      }, function (){
           setError("Error al eleiminar el reporte");
      });
    };

    $scope.pauseJob = function(report){
      jobService.pauseJob(report).then(function (data) {
        if(data.status){
          $scope.JobsList();
          setInfo("El reporte ha sido pausado");
        }
        else{
          setError(data.message);
        }
      }, function (){

      });
    };
    $scope.resumeJob = function(report){
      jobService.resumeJob(report).then(function (data) {
        if(data.status){
          $scope.JobsList();
          setInfo("El reporte ha sido reiniciado");
        }
        else{
          setError(data.message);
        }
      }, function (){

      });
    };

    $scope.viewReport = function(report){
      $scope.name = report.name;
      $scope.description = report.description;
      $scope.query = report.body;
      $scope.language = report.language;
      $scope.cronExpression = report.cronExpression;
      if(report.to.length > 0){
        var arrTo = report.to.split(",");
        $log.log(report.to);
        $log.log(report.to.split(","));
        $scope.reporte.listaDestinatarios = arrTo;
      }
    };

    $scope.deleteDestinatario = function(item){
      var index = $scope.reporte.listaDestinatarios.indexOf(item);
      $scope.reporte.listaDestinatarios.splice(index,1);
    };

    $scope.clean = function(){
      $scope.name = "";
      $scope.description = "";
      $scope.query = "";
      $scope.language = "";
      $scope.cronExpression = "";
      $scope.email = "";
      $scope.reporte.listaDestinatarios = [];
    };

    setError = function(error){
      $scope.showError = true;
      $scope.resultMessage = error;
      _.delay(function(){
        $scope.showError = false;
        $scope.$digest();
      }, 3000,'');
      $(window).scrollTop(0);
    };

    setInfo = function(text){
      $scope.showInfo = true;
      $scope.resultMessage = text;
      _.delay(function(){
        $scope.showInfo = false;
        $scope.$digest();
      }, 3000,'');
        $(window).scrollTop(0);
    };
});
