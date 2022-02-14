package egovframework.example.factAlarm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.factAlarm.service.FactAlarmVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * 
 * @class	FactAlarmDAO
 * @since  2022.01.03
 * @author (주)새힘정보기술 
 *
 */
@Repository("factAlarmDAO")
public class FactAlarmDAO extends EgovAbstractDAO {
	 /**
	  * @method name : 믹서 알람 내역 조회
	  * @param param
	  * @return
	  */
	public List<?> selectFactAlarmList(FactAlarmVO param) throws Exception {
		return list("factAlarmDAO.selectFactAlarmList", param);
	}
	
	 /**
	  * @method name : 믹서 알람 내역 건수 
	  * @param param
	  * @return
	  */
	public int selectFactAlarmListCnt(FactAlarmVO param) throws Exception {
		return (Integer) select("factAlarmDAO.selectFactAlarmListCnt", param);
	}
}
