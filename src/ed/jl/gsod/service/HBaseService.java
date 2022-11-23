package ed.jl.gsod.service;

import java.util.ArrayList;
import java.util.List;

import ed.jl.gsod.dao.HBaseDao;
import edu.jl.gsod.pojo.AirspeedVO;
import edu.jl.gsod.pojo.FrshttVO;
import edu.jl.gsod.pojo.HBaseDataDO;
import edu.jl.gsod.pojo.PressureVO;
import edu.jl.gsod.pojo.RainfallVO;
import edu.jl.gsod.pojo.TempVO;
import edu.jl.gsod.pojo.VisibVO;

/**
 * 调用HBaseDao类：处理DO为VO
 * @author tarena
 *
 */
public class HBaseService {
	private HBaseDao hdo = new HBaseDao();
	List<HBaseDataDO> dataList;
	public HBaseService(String stationId)
	{
		try {
			dataList = hdo.queryAllData(stationId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	2.1. 定义处理数据为TempVO的方法
	public List<TempVO> queryTemp(String stationId){
//		定义存储温度类数据的集合
		List<TempVO> tempList = new ArrayList<TempVO>();
//		调用dao层的所有数据的方法:异常在service层try
		try {
//			遍历dataList,将数据封装TempVO中
			for(HBaseDataDO dataDO:dataList) {
				TempVO tv = new TempVO();
				tv.setStn(dataDO.getStn());
				tv.setWban(dataDO.getWban());
				tv.setDate(dataDO.getDate().toString());
				tv.setTemp(dataDO.getTemp());
				tv.setDwep(dataDO.getDewp());
				tv.setMax(dataDO.getMax());
				tv.setMin(dataDO.getMin());
//				保存到tempList中
				tempList.add(tv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		返回数据集合
		return tempList;
	}
	
	// 2.2. 定义处理数据为PressureVO的方法
	public List<PressureVO> queryPressure(String stationId) {
		List<PressureVO> pressureList = new ArrayList<>();
		try {
			for(HBaseDataDO dataDO:dataList) {
				PressureVO pv = new PressureVO();
				pv.setStn(dataDO.getStn());
				pv.setWban(dataDO.getWban());
				pv.setDate(dataDO.getDate().toString());
				pv.setSlp(dataDO.getSlp());
				pv.setStp(dataDO.getStp());
				pressureList.add(pv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pressureList;
	}
	
	// 2.3. 定义处理数据为RainfallVO的方法
	public List<RainfallVO> queryRainfall(String stationId) {
		List<RainfallVO> rainfallList = new ArrayList<>();
		try {
			for(HBaseDataDO dataDO:dataList) {
				RainfallVO rv = new RainfallVO();
				rv.setStn(dataDO.getStn());
				rv.setWban(dataDO.getWban());
				rv.setDate(dataDO.getDate().toString());
				rv.setPrcp(dataDO.getPrcp());
				rv.setSndp(dataDO.getSndp());
				rainfallList.add(rv);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rainfallList;
	}
	
	// 2.4. 定义处理数据为VisibVO的方法
	public List<VisibVO> queryVisib(String stationId) {
		List<VisibVO> visibList = new ArrayList<>();
		try {
			for(HBaseDataDO dataDO:dataList) {
				VisibVO vv = new VisibVO();
				vv.setStn(dataDO.getStn());
				vv.setWban(dataDO.getWban());
				vv.setDate(dataDO.getDate().toString());
				vv.setVisib(dataDO.getVisib());
				visibList.add(vv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibList;
	}
	
	// 2.5. 定义处理数据为AirspeedVO的方法
	public List<AirspeedVO> queryAirspeed(String stationId) {
		List<AirspeedVO> airspeedList = new ArrayList<>();
		try {
			for(HBaseDataDO dataDO:dataList) {
				AirspeedVO av = new AirspeedVO();
				av.setStn(dataDO.getStn());
				av.setWban(dataDO.getWban());
				av.setDate(dataDO.getDate().toString());
				av.setWdsp(dataDO.getWdsp());
				av.setGust(dataDO.getGust());
				av.setMxspd(dataDO.getMxspd());
				airspeedList.add(av);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return airspeedList;
	}
	
	// 2.6. 定义处理数据为FrshttVO的方法
	public List<FrshttVO> queryFrshtt(String stationId) {
		List<FrshttVO> frshttList = new ArrayList<>();

		try {
			for(HBaseDataDO dataDO:dataList) {
				FrshttVO fv = new FrshttVO();
				fv.setStn(dataDO.getStn());
				fv.setWban(dataDO.getWban());
				fv.setDate(dataDO.getDate().toString());
				fv.setIsFog(dataDO.getFog());
				fv.setIsRainOrDrizzle(dataDO.getRod());
				fv.setIsSnowOrIcePellets(dataDO.getSoip());
				fv.setIsHail(dataDO.getHail());
				fv.setIsThunder(dataDO.getThunder());
				fv.setIsTornadoOrFC(dataDO.getTofc());
				frshttList.add(fv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return frshttList;
	}	
}