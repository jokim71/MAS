package egovframework.example.worker.service.impl;

import java.util.List;

import egovframework.example.sample.service.SampleVO;
import egovframework.example.worker.service.WorkerVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 
 * @class FactAlarmMapper
 * @since  2022.01.03
 * @author (주)새힘정보기술 
 *
 */
@Mapper("workerMapper")
public interface WorkerMapper {

	/**
	 * 작업자 리스트 조회
	 * @param param
	 * @return
	 * @throws Exception
	 */
	List<?> selectWorkerList(WorkerVO param) throws Exception;
	
	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	//void insertSample(WorkerVO param) throws Exception;
	
}
