package egovframework.example.manufactItem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.manufactItem.service.ManufactItemService;
import egovframework.example.manufactItem.service.ManufactItemVO;
import egovframework.example.manufactItem.service.ScaleVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * 
 * @class ManufactItemServiceImpl
 * @since  2022.01.10
 * @author (주)새힘정보기술 
 *
 */
@Service("manufactItemService")
public class ManufactItemServiceImpl extends EgovAbstractServiceImpl implements ManufactItemService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(FactAlarmServiceImpl.class);
	
	@Resource(name="manufactItemDAO")
	private ManufactItemDAO manufactItemDAO;
	
	/**
	 * 제조원료 현황 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<?> selectManufactItemList(ManufactItemVO param) throws Exception {
		return manufactItemDAO.selectManufactItemList(param);
	}
	
	/**
	 * 제조원료 현황 건수 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int selectManufactItemListCnt(ManufactItemVO param) throws Exception {
		return manufactItemDAO.selectManufactItemListCnt(param);
	}
	
	/**
	 * 투입원료 내역 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<?> selectScaleList(ScaleVO param) throws Exception {
		return manufactItemDAO.selectScaleList(param);
	}
	
	/** 
	 * @method 기간별 투입량   
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int selectScaleCapacity(ScaleVO param) throws Exception {
		return manufactItemDAO.selectScaleCapacity(param);
	}
}
