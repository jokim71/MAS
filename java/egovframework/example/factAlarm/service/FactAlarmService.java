package egovframework.example.factAlarm.service;

import java.util.List;

/**
 * 
 * @class  FactAlarmService
 * @since  2022.01.03
 * @author (주)새힘정보기술 
 *
 */
public interface FactAlarmService {

	/**
	 * 설비 알람발생내역
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<?> selectFactAlarmList(FactAlarmVO param) throws Exception;
	
	/**
	 * 설비 알람발생내역건
	 * @param param
	 * @return
	 * @throws Exception
	 */
	int selectFactAlarmListCnt(FactAlarmVO param) throws Exception;
}
