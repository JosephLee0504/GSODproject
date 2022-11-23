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
 * ����HBaseDao�ࣺ����DOΪVO
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
	
//	2.1. ���崦������ΪTempVO�ķ���
	public List<TempVO> queryTemp(String stationId){
//		����洢�¶������ݵļ���
		List<TempVO> tempList = new ArrayList<TempVO>();
//		����dao����������ݵķ���:�쳣��service��try
		try {
//			����dataList,�����ݷ�װTempVO��
			for(HBaseDataDO dataDO:dataList) {
				TempVO tv = new TempVO();
				tv.setStn(dataDO.getStn());
				tv.setWban(dataDO.getWban());
				tv.setDate(dataDO.getDate().toString());
				tv.setTemp(dataDO.getTemp());
				tv.setDwep(dataDO.getDewp());
				tv.setMax(dataDO.getMax());
				tv.setMin(dataDO.getMin());
//				���浽tempList��
				tempList.add(tv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		�������ݼ���
		return tempList;
	}
	
	// 2.2. ���崦������ΪPressureVO�ķ���
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
	
	// 2.3. ���崦������ΪRainfallVO�ķ���
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
	
	// 2.4. ���崦������ΪVisibVO�ķ���
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
	
	// 2.5. ���崦������ΪAirspeedVO�ķ���
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
	
	// 2.6. ���崦������ΪFrshttVO�ķ���
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