package egovframework.example.manufactItem.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.manufactItem.service.ManufactItemVO;
import egovframework.example.manufactItem.service.ScaleVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * 
 * @class	ManufactItemDAO
 * @since  2022.01.10
 * @author (주)새힘정보기술 
 *
 */
@Repository("manufactItemDAO")
public class ManufactItemDAO extends EgovAbstractDAO {
	 /**
	  * @method 제조원료 현황 
	  * @param param
	  * @return
	  */
	public List<?> selectManufactItemList(ManufactItemVO param) throws Exception {
		return list("manufactItemDAO.selectManufactItemList", param);
	}
	
	 /**
	  * @method 제조원료 현황 건수 
	  * @param param
	  * @return
	  */
	public int selectManufactItemListCnt(ManufactItemVO param) throws Exception {
		return (Integer) select("manufactItemDAO.selectManufactItemListCnt", param);
	}
	
	/** 
	 * @method 투입원료 내역  
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<?> selectScaleList(ScaleVO param) throws Exception {
		return list("manufactItemDAO.selectScaleList", param);
	}

	/** 
	 * @method 기간별 투입량   
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int selectScaleCapacity(ScaleVO param) throws Exception {
		return (Integer) select("manufactItemDAO.selectScaleCapacity", param);
	}
}
