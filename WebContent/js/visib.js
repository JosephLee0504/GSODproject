function showVisib(id) {
	/**
	 * 
	 */
	//在显示图表之前需要先清空显示图表的div的内容
	//document.getElementById('main').innerHTML = "";
	
	//异步请求相关
	var visibUrl = "HBaseController";
	//获取站点编号
	var stationID = document.getElementById('station_id').value;
	var type = id;
	var visibUrlP = visibUrl + "?station_id=" + stationID + "&type=" + type;

	var visibObj = echarts.init(document.getElementById(id));

	var dateVisib = [];
	var visib = [];
	var indexVisib = 0;

	optionVisib = {
		tooltip : {
			trigger : 'axis',
		},
		title : {
			left : 'center',
			text : '能见度',
		},
		/*toolbox : {
			feature : {
				dataZoom : {
					yAxisIndex : 'none'
				},
			}
		},*/
		xAxis : {
			// show : false,
			type : 'category',
			boundaryGap : false,
			data : dateVisib
		},
		yAxis : {
			show : false,
			type : 'value',
			start : 0,
			end : 100,
		},
		dataZoom : [
				{
					type : 'inside',
					startValue : '2016-01-01'
				},
				{
					handleIcon : 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
					handleSize : '80%',
					handleStyle : {
						color : '#fff',
						shadowBlur : 3,
						shadowColor : 'rgba(0, 0, 0, 0.6)',
						shadowOffsetX : 2,
						shadowOffsetY : 2
					}
				} ],
		series : [ {
			name : '能见度',
			type : 'line',
			smooth : true,
			symbol : 'none',
			sampling : 'average',
			itemStyle : {
				normal : {
					color : 'rgb(255, 70, 131)'
				}
			},
			areaStyle : {
				normal : {
					color : new echarts.graphic.LinearGradient(0, 0, 0, 1, [ {
						offset : 0,
						color : 'rgb(255, 158, 68)'
					}, {
						offset : 1,
						color : 'rgb(255, 70, 131)'
					} ])
				}
			},
			data : visib
		} ]
	};

	// 首次设置图标样式
	visibObj.setOption(optionVisib);
	// 更新数据
	function pushVisibDate(VisibDate) {
		dateVisib.push(VisibDate.date);
		visib.push(VisibDate.visib);
	}

	$.get(visibUrlP, function(data) {
		data = JSON.parse(data);
		// 启动周期性计时器
		var interval = setInterval(function() {
			pushVisibDate(data[indexVisib], true);// 调用更新方法
			indexVisib++;
			if (indexVisib >= 366) {
				clearInterval(interval);
			}
			visibObj.setOption(optionVisib);
		}, 500);
	});
}