package egovframework.example.manufactItem.service.impl;

import java.util.List;

import egovframework.example.manufactItem.service.ManufactItemVO;
import egovframework.example.manufactItem.service.ScaleVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 
 * @class ManufactItemMapper
 * @since  2022.01.10
 * @author (주)새힘정보기술 
 *
 */
@Mapper("manufactItemMapper")
public interface ManufactItemMapper {

	 /**
	  * @method name : 제조원료 현황 
	  * @param param
	  * @return
	  */
	List<?> selectManufactItemList(ManufactItemVO param) throws Exception;
	
	 /**
	  * @method name : 제조원료 현황 건수 
	  * @param param
	  * @return
	  */
	int selectManufactItemListCnt(ManufactItemVO param) throws Exception;
	
	/** 
	 * @method 투입원료 내역  
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<?> selectScaleList(ScaleVO param) throws Exception;
	
	/** 
	 * @method 기간별 투입량   
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int selectScaleCapacity(ScaleVO param) throws Exception;	
}
