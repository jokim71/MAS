package egovframework.example.worker.service;

import java.util.List;

import egovframework.example.manufactItem.service.ManufactItemVO;


/**
 * 
 * @class  FactAlarmService
 * @since  2022.01.03
 * @author (주)새힘정보기술 
 *
 */
public interface WorkerService {

	/**
	 * 작업자 리스트 조회
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<?> selectWorkerList(WorkerVO param) throws Exception;
	
	int selectWorkerListCnt(WorkerVO param) throws Exception;
	
	public String insertWorker(WorkerVO param) throws Exception;
		
	
}
