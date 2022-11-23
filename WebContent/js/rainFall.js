function showRainFall(id) {
	/**
	 * 
	 */
	//在显示图表之前需要先清空显示图表的div的内容
	//document.getElementById('main').innerHTML = "";
	
	// 异步请求相关
	var rainFallUrl = "HBaseController";
	var stationID = document.getElementById('station_id').value;
	var type = id
	var rainFallUrlP = rainFallUrl + "?station_id=" + stationID + "&type=" + type;

	var rainFall = echarts.init(document.getElementById(id));
	var dateRainFall = []; // 时间
	var prcp = []; // 总降水量
	var sndp = []; // 降雪深度
	var indexRainFall = 0;

	optionRainFall = {
		title : {
			text : '降雪深度/总降水量',
			x : 'center'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				animation : false
			}
		},
		/*
		 * legend : { top: 30, data : [ '降雪深度', '总降雨量' ], x : 'center' },
		 */
		/*toolbox : {
			feature : {
				dataZoom : {
					yAxisIndex : 'none'
				},
				restore : {},
				saveAsImage : {}
			}
		},*/
		axisPointer : {

			link : {
				xAxisIndex : 'all'
			}
		},
		dataZoom : [ {
			startvalue : '2016-01-01'
		}, {
			type : 'inside',
		} ],
		xAxis : [ {
			// show : false,
			type : 'category',
			boundaryGap : false,
			axisLine : {
				onZero : true
			},
			data : dateRainFall
		} ],
		yAxis : [ {
			show : false,
			name : '降雪深度(英寸)',
			type : 'value',
		}, {
			name : '总降雨量(英寸)',
			type : 'value',
			inverse : true
		} ],
		series : [ {
			name : '降雪深度',
			type : 'line',
			symbolSize : 8,
			hoverAnimation : false,
			data : sndp
		}, {
			name : '总降雨量',
			type : 'line',
			symbolSize : 8,
			hoverAnimation : false,
			data : prcp,
			itemStyle : {
				normal : {
					color : '#FF359A',
					lineStyle : {
						color : '#FF359A'
					}
				}
			}
		} ]
	};

	// 首次设置图标样式
	rainFall.setOption(optionRainFall);
	// 更新数据
	function pushRainFallDate(rainFallDate) {
		dateRainFall.push(rainFallDate.date);
		prcp.push(rainFallDate.prcp);
		sndp.push(rainFallDate.sndp);
	}

	$.get(rainFallUrlP, function(data) {
		data = JSON.parse(data);
		// 启动周期性计时器
		var interval = setInterval(function() {
			pushRainFallDate(data[indexRainFall], true);// 调用更新方法
			indexRainFall++;
			if (indexRainFall >= 366) {
				clearInterval(interval);
			}
			rainFall.setOption(optionRainFall);
		}, 500);
	});

}