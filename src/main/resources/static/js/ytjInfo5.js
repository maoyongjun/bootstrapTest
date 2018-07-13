// JavaScript Document
var list;
var block;
function ytjInfo5($scope,$filter) {
	var data;
 $.ajax({
		url:"test",
		type:"get",
		dataType:"json",
		success:function(result){
			data=result;
		},
		error:function(){
			alert("change an exception occurs!");
		}
	});
	
//    $scope.ytjs = [
//        {block:'Jani',address:'Norway',action:'未装',point: "104.040668,30.561926"},
//        {block:'Hege',address:'Sweden',action:'已装',point: "104.040668,30.561926"},
//        {block:'Kai',address:'Denmark',action:'损坏',point: "104.040668,30.561926"}
//    ];
	$scope.ytjs =data;
	$scope.setBlock=function(){
		list=$filter('filter')($scope.ytjs,$scope.block);
	}
}
function filterList(block){
	alert(list[0].point);
}