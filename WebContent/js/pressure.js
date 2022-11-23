function showPressure(id) {
	/**
	 * 
	 */
	//在显示图表之前需要先清空显示图表的div的内容
	//document.getElementById('main').innerHTML = "";
	
	// 异步请求相关
	var presurl = "HBaseController";
	var stationID = document.getElementById('station_id').value;
	var type = id;
	var presurlP = presurl + "?station_id=" + stationID + "&type=" + type;

	var pressure = echarts.init(document.getElementById(id));
	var datePressure = [];
	var slp = []; // 海平面气压
	var stp = []; // 地面气压
	var indexPressure = 0;

	optionPressure = {
		title : {
			text : '海平面/地面气压',
			left : 'center'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'shadow'
			}
		},
		/*
		 * legend : { top: 30, data : [ '海平面气压', '地面气压' ] },
		 */
		xAxis : {
			show : false,
			type : 'value',
			boundaryGap : '10%',
		},
		yAxis : {
			// show : false,
			startValue : '2016-01-01',
			data : datePressure
		},
		series : [ {
			name : '海平面气压',
			type : 'line',
			smooth : true,
			symbol : 'none',
			sampling : 'bar',
			itemStyle : {
				normal : {
					color : 'rgb(255, 70, 131)'
				}
			},
			data : slp
		}, {
			name : '地面气压',
			type : 'line',
			smooth : true,
			symbol : 'none',
			sampling : 'bar',
			itemStyle : {
				normal : {
					color : '#921aff'
				}
			},
			data : stp
		} ]
	};

	// 首次设置图标样式
	pressure.setOption(optionPressure);
	// 更新数据
	function pushPressureDate(PressureDate) {
		datePressure.push(PressureDate.date);
		slp.push(PressureDate.slp);
		stp.push(PressureDate.stp);
	}

	$.get(presurlP, function(data) {
		data = JSON.parse(data);
		// 启动周期性计时器
		var interval = setInterval(function() {
			pushPressureDate(data[indexPressure], true);// 调用更新方法
			indexPressure++;
			if (indexPressure >= 366) {
				clearInterval(interval);
			}
			pressure.setOption(optionPressure);
		}, 500);
	});

}