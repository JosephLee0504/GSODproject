package edu.jl.gsod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import ed.jl.gsod.service.HBaseService;
import edu.jl.gsod.pojo.AirspeedVO;
import edu.jl.gsod.pojo.FrshttVO;
import edu.jl.gsod.pojo.PressureVO;
import edu.jl.gsod.pojo.RainfallVO;
import edu.jl.gsod.pojo.TempVO;
import edu.jl.gsod.pojo.VisibVO;

/**
 * urlPatterns = { "/HBaseController" }:接收的请求格式一定要是/HBaseController
 */
@WebServlet(description = "和前台页面交互的控制层，接收请求以及请求参数", urlPatterns = { "/HBaseController" })
public class HBaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		获取请求中的参数：station_id
		String stationId = request.getParameter("station_id");
		HBaseService hbs = new HBaseService(stationId);
		String type = request.getParameter("type");
		System.out.println(type);
		String jsonString="";
		if ("temp".equals(type)) {
//			调用service层的查询温度数据的方法
			List<TempVO> tempList = hbs.queryTemp(stationId);
//			将list处理为json串
			jsonString = JSON.toJSONString(tempList);
//			将json串返回给前台：前台ajax会获取到响应中的数据
		}
		else if ("pressure".equals(type)) {
			List<PressureVO> pressureList = hbs.queryPressure(stationId);
			jsonString = JSON.toJSONString(pressureList);
		}
		else if ("rainFall".equals(type)) {
			List<RainfallVO> rainfallList = hbs.queryRainfall(stationId);
			jsonString = JSON.toJSONString(rainfallList);
		}
		else if ("visib".equals(type)) {
			List<VisibVO> visibList = hbs.queryVisib(stationId);
			jsonString = JSON.toJSONString(visibList);
		}
		else if ("airSpeed".equals(type)) {
			List<AirspeedVO> airspeedList = hbs.queryAirspeed(stationId);
			jsonString = JSON.toJSONString(airspeedList);
		}
		else if ("frshtt".equals(type)) {
			List<FrshttVO> frshttList = hbs.queryFrshtt(stationId);
			jsonString = JSON.toJSONString(frshttList);
			System.out.println("tcsb");
		}
		response.getWriter().write(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}