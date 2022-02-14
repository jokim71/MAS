package egovframework.example.worker.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.manufactItem.service.ManufactItemVO;
import egovframework.example.worker.service.WorkerService;
import egovframework.example.worker.service.WorkerVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("workerService")
public class WorkerServiceImpl extends EgovAbstractServiceImpl implements WorkerService {

	@Resource(name="workerDAO")
	private WorkerDAO workerDAO;
	
	//@Override
	public List<?> selectWorkerList(WorkerVO param) throws Exception
	{
		return workerDAO.selectWorkerList(param);
	}
	
	//@Override
	public int selectWorkerListCnt(WorkerVO param) throws Exception {
		return workerDAO.selectWorkerListCnt(param);
	}
	
	//@Override
	public String insertWorker(WorkerVO param) throws Exception
	{	
		return workerDAO.insertWorker(param);
	}	
}
