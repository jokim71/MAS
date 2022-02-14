package egovframework.example.worker.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.manufactItem.service.ManufactItemVO;
import egovframework.example.worker.service.WorkerVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


/**
 * 
 * @class	WorkerDAO
 * @since  2022.01.03
 * @author (주)새힘정보기술 
 *
 */

@Repository("workerDAO")
public class WorkerDAO extends EgovAbstractDAO {
	/**
	  * @method name : 작업자 조회
	  * @param param
	  * @return
	  */
	public List<?> selectWorkerList(WorkerVO param) throws Exception{
		return (List<?>) list("workerDAO.selectWorkerList", param);
	}
	
	public int selectWorkerListCnt(WorkerVO param) throws Exception {
		return (Integer) select("workerDAO.selectWorkerListCnt", param);
	}
	
	public String insertWorker(WorkerVO param) throws Exception{
		return (String) insert("workerDAO.insertWorker", param);
	}

}
