function showAirSpeed(id) {
	/**
	 * 
	 */
	//在显示图表之前需要先清空显示图表的div的内容
	//document.getElementById('main').innerHTML = "";
	
	// 异步请求相关
	var asurl = "HBaseController";
	var stationID = document.getElementById('station_id').value;
	var type = id;
	var asurlP = asurl + "?station_id=" + stationID + "&type=" + type;

	var airSpeed = echarts.init(document.getElementById(id));

	// 声明数据数组
	var dateAirSpeed = []; // 时间
	var wdsp = [];// 平均风速
	var gust = []; // 最大风速
	var mxspd = []; // 最高持续风速
	var indexAirSpeed = 0;

	var optionAirSpeed = {
		title : {
			left : 'center',
			text : '最大风速和最高持续风速/节'
		},
		tooltip : {
			trigger : 'axis'
		},
		/*
		 * legend : { // 图例 top: 30, data : [ '最大风速', '最高持续风速' ], itemGap : 5 },
		 */
		xAxis : [ // X轴
		{
			// show : false,
			data : dateAirSpeed
		} ],
		yAxis : { // y轴
			show : false,
			splitLine : {
				show : false
			}
		},
		dataZoom : [  {
			type : 'inside'
		} ],
		series : [ {
			name : '平均风速',
			type : 'bar',
			data : wdsp
		}, {
			name : '最大风速',
			type : 'bar',
			data : gust
		}, {
			name : '最高持续风速',
			type : 'bar',
			data : mxspd,
			itemStyle : {
				normal : {
					color : '#28ff28',
					lineStyle : {
						color : '#28ff28'
					}
				}
			}
		} ]
	};
	// 首次设置图标样式
	airSpeed.setOption(optionAirSpeed);
	// 更新数据
	function pushAirSpeedDate(airSpeedDate) {
		//alert(sirSpeedDate.date);
		dateAirSpeed.push(airSpeedDate.date);
		wdsp.push(airSpeedDate.wdsp);
		gust.push(airSpeedDate.gust);
		mxspd.push(airSpeedDate.mxspd);
	}

	$.get(asurlP, function(data) {
		data = JSON.parse(data);
		// 启动周期性计时器
		var interval = setInterval(function() {
			pushAirSpeedDate(data[indexAirSpeed], true);// 调用更新方法
			indexAirSpeed++;
			if (indexAirSpeed >= 366) {
				clearInterval(interval);
			}
			airSpeed.setOption(optionAirSpeed);
		}, 500);
	});
}