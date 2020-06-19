/**
 * Created by lin on 2018/8/8.
 */
//function myContro($scope) {
    // var updateClock=function () {
    //     $scope.clock=new Date();
    //     $timeout(function () {
    //         updateClock();
    //     },1000)
    // };
    // updateClock();
   // $scope.clock = "333";
   // alert('dsdsdsds')
//};
var app = angular.module("myApp",[]);
app.controller("myContro",function ($scope,$timeout) {
    var updateClock=function () {
        $scope.clock=new Date();
        $timeout(function () {
            updateClock();
        },1000)
    };
    updateClock();
});

app.directive("customTag",function () {
    return {
        template:"<h1>自定义指令</h1>"
    };
})

