app.controller('pdsCtrl',['$scope','$http',function(scope,http){
	http({
		url:'../../safe.json',
		mothed:'GET'
	})
	.success(function(data){
		scope.tit=data.paypd.tit;
		scope.data0=data.paypd.data[0]+"：";
		scope.data1=data.paypd.data[1];
		scope.data2=data.paypd.data[2];
		scope.data3=data.paypd.data[3];
		scope.data4=data.paypd.data[4];
		scope.data5=data.paypd.data[5];
	})
}]);