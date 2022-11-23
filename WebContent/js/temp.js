function showTemp(id){
	//在显示图表之前需要先清空显示图表的div的内容
	//document.getElementById('main').innerHTML = "";
	
	//异步请求相关
	var tempurl = "HBaseController";
	//获取站点编号
	var stationID = document.getElementById('station_id').value;
	var type = id;
	var tempurlP = tempurl + "?station_id=" + stationID + "&type=" + type;

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById(id));
	myChart.resize();
	// 声明数据数组供后期不断添加数据
	var dateTemp = [];
	var temp = [];
	var dewp = [];
	var max = [];
	var min = [];
	var index = 0;// 当前用来更新的条数的下标
	option = {
		title : {
			text : 'Station Temperature'
		},
		tooltip : {
			trigger : 'axis'
		},
		/*legend : {
			data : [ '平均温度', '最高温度', '最低温度', '平均露点' ]
		},*/
		// 工具栏
		/*toolbox : {
			show : true,
			feature : {
				dataZoom : {
					yAxisIndex : 'none'
				},
				restore : {},
				saveAsImage : {}
			}
		},*/
		xAxis : {
			data : dateTemp
		},
		yAxis : {
			splitLine : {
				show : false
			}
		},
		dataZoom : [ {
			type : 'inside'
		} ],
		series : [ {
			name : '平均温度',
			type : 'line',
			smooth : true,
			data : temp
		}, {
			name : '平均露点',
			type : 'line',
			smooth : true,
			data : dewp
		}, {
			name : '最高温度',
			type : 'line',
			smooth : true,
			data : max
		}, {
			name : '最低温度',
			type : 'line',
			smooth : true,
			data : min
		} ]
	};
	// 首次设置图标样式
	myChart.setOption(option);
	// 更新数据的方法
	function addData(singleData) {
		dateTemp.push(singleData.date);
		temp.push(singleData.temp);
		dewp.push(singleData.dewp);
		max.push(singleData.max);
		min.push(singleData.min);
	}
	// 发送ajax请求
	$.get(tempurlP, function(data) {
		data = JSON.parse(data);
		alert(data);
		// 启动周期性计时器
		var interval = setInterval(function() {
			addData(data[index]);// 将新的一天的数据添加到数组中
			index++;
			// 已经添加过366天的数据
			if (index >= 366) {
				// 清空当前的周期性计时器
				clearInterval(interval);
			}
			myChart.setOption(option);// 显示更新后的图标
		}, 500);
	});
}