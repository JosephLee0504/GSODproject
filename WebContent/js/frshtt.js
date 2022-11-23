function showFRSHTT(id) {
	/**
	 * 
	 */
	//在显示图表之前需要先清空显示图表的div的内容
	//document.getElementById('main').innerHTML = "";
	
	// 异步请求相关
	var frshttUrl = "HBaseController";
	var stationID = document.getElementById('station_id').value;
	var type = id
	var frshttUrlP = frshttUrl + "?station_id=" + stationID + "&type=" + type;

	var severe = echarts.init(document.getElementById(id));

	var dateFrshtt = [];
	var isFog = 0;
	var isRainOrDrizzle = 0;
	var isSnowOrIcePellets = 0;
	var isHail = 0;
	var isThunder = 0;
	var isTornadoOrFC = 0;
	var isSunShine = 0;
	var indexSevere = 0;

	optionSevere = {
		tooltip : {},
		/*
		 * legend : { top : 30, textAlign : 'center', data : [ '雾天', '雨天', '雪天',
		 * '冰雹', '打雷', '刮风', '晴天' ] },
		 */
		title : [ {
			text : '恶劣天气数据',
			x : '25%',
			textAlign : 'center'
		}, {
			text : "恶劣天气占比",
			x : '75%',
			textAlign : 'center'
		} ],
		grid : [ {
			top : 150,
			width : '45%',
			bottom : '20%',
			left : 10,
			containLabel : true
		} ],
		xAxis : [ {
			// show : false,
			type : 'value',
			splitLine : {
				show : false
			}
		} ],
		yAxis : [ {
			// show : false,
			data : [ '雾天', '雨天', '雪天', '冰雹', '打雷', '刮风', '晴天' ],
			// axisLabel : {
			// interval : 0,
			// rotate : 30
			// },
			splitLine : {
				show : false
			}
		} ],
		series : [ {
			type : 'bar',
			// stack : 'chart',
			label : {
				normal : {
					color : 'blue',
					position : 'right',
					show : true
				}
			},
			data : [ {
				value : isFog,
				name : '雾天'
			}, {
				value : isRainOrDrizzle,
				name : '雨天'
			}, {
				value : isSnowOrIcePellets,
				name : '雪天'
			}, {
				value : isHail,
				name : '冰雹'
			}, {
				value : isThunder,
				name : '打雷'
			}, {
				value : isTornadoOrFC,
				name : '刮风'
			}, {
				value : isSunShine,
				name : '晴天'
			} ]
		}, {
			type : 'pie',
			radius : '50%',
			center : [ '75%', '55%' ],
			data : [ {
				value : isFog,
				name : '雾天'
			}, {
				value : isRainOrDrizzle,
				name : '雨天'
			}, {
				value : isSnowOrIcePellets,
				name : '雪天'
			}, {
				value : isHail,
				name : '冰雹'
			}, {
				value : isThunder,
				name : '打雷'
			}, {
				value : isTornadoOrFC,
				name : '刮风'
			}, {
				value : isSunShine,
				name : '晴天'
			} ]
		} ]
	};

	// 首次设置图标样式
	severe.setOption(optionSevere);
	// 更新数据
	function pushSevereDate(SevereDate) {
		dateFrshtt.push(SevereDate.date);
		isFog += parseInt(SevereDate.isFog);
		isRainOrDrizzle += parseInt(SevereDate.isRainOrDrizzle);
		isSnowOrIcePellets += parseInt(SevereDate.isSnowOrIcePellets);
		isHail += parseInt(SevereDate.isHail);
		isThunder += parseInt(SevereDate.isThunder);
		isTornadoOrFC += parseInt(SevereDate.isTornadoOrFC);
		isSunShine += parseInt(SevereDate.isSunShine);
//		console.log(isFog,isRainOrDrizzle,isSnowOrIcePellets,isHail,isThunder,isTornadoOrFC,isSunShine)
	}

	$.get(frshttUrlP, function(data) {
		alert(data);
		data = JSON.parse(data);
		console.log(data);
		// 启动周期性计时器
		var interval = setInterval(function() {
			pushSevereDate(data[indexSevere], true);// 调用更新方法
			indexSevere++;
			if (indexSevere >= 366) {
				clearInterval(interval);
			}
			severe.setOption({
				series : [ {
					data : [ {
						value : isFog,
						name : '雾天'
					}, {
						value : isRainOrDrizzle,
						name : '雨天'
					}, {
						value : isSnowOrIcePellets,
						name : '雪天'
					}, {
						value : isHail,
						name : '冰雹'
					}, {
						value : isThunder,
						name : '打雷'
					}, {
						value : isTornadoOrFC,
						name : '刮风'
					} , {
						value : isSunShine,
						name : '晴天'
					}]
				}, {
					data : [ {
						value : isFog,
						name : '雾天'
					}, {
						value : isRainOrDrizzle,
						name : '雨天'
					}, {
						value : isSnowOrIcePellets,
						name : '雪天'
					}, {
						value : isHail,
						name : '冰雹'
					}, {
						value : isThunder,
						name : '打雷'
					}, {
						value : isTornadoOrFC,
						name : '刮风'
					}, {
						value : isSunShine,
						name : '晴天'
					} ]
				}

				]
			});
		}, 500);
	});
}