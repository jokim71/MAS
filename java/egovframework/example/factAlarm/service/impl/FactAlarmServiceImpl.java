package egovframework.example.factAlarm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.factAlarm.service.FactAlarmService;
import egovframework.example.factAlarm.service.FactAlarmVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * 
 * @class FactAlarmServiceImpl
 * @since  2022.01.03
 * @author (주)새힘정보기술 
 *
 */
@Service("factAlarmService")
public class FactAlarmServiceImpl extends EgovAbstractServiceImpl implements FactAlarmService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(FactAlarmServiceImpl.class);
	
	@Resource(name="factAlarmDAO")
	private FactAlarmDAO factAlarmDAO;
	
	/**
	 * 설비 알람발생내역
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<?> selectFactAlarmList(FactAlarmVO param) throws Exception {
		return factAlarmDAO.selectFactAlarmList(param);
	}
	
	/**
	 * 설비 알람발생내역건
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int selectFactAlarmListCnt(FactAlarmVO param) throws Exception {
		return factAlarmDAO.selectFactAlarmListCnt(param);
	}
}
