package egovframework.example.worker.web;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Resource;
import javax.enterprise.inject.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.cmmn.service.MasCommonService;
import egovframework.example.cmmn.service.MasCommonVO;
import egovframework.example.manufactItem.web.manufactItemController;
import egovframework.example.worker.service.WorkerService;
import egovframework.example.worker.service.WorkerVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * 
 * @class  WorkerController
 * @since  2022.01.18
 * @author (주)새힘정보기술 
 *
 */
@Controller
public class WorkerController {
	
	private static final Logger log = LoggerFactory.getLogger(WorkerController.class);
	
	@Resource(name="workerService")
	private WorkerService workerService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "masCommonService")
	private MasCommonService masCommonService;
		
	@RequestMapping(value="/workerList.do")
	public String selectWorkerList(@ModelAttribute("searchVO") WorkerVO searchVO, ModelMap model) throws Exception {
		log.debug("##### selectWorkerList START !!! #####");
		
		/** EgovPropertyService */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// 최초 회사(공장) 값 설정
		if ("".equals(searchVO.getsCompId()) || searchVO.getsCompId() == null) {
			// 초기값 설정
			searchVO.setsCompId(propertiesService.getString("compId"));
			searchVO.setCompid(propertiesService.getString("compId"));
			searchVO.setUse_yn("Y");
		} else {
			searchVO.setCompid(searchVO.getsCompId());			
		}			
		
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());		
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		MasCommonVO paramVO = new MasCommonVO();
		
		// 작업자 정보 테이블 설정 
		paramVO.setTableId("T_WORKER_INFO");
		
		List<?> compList = masCommonService.selectCompIDList(paramVO);
		model.addAttribute("resultCompList", compList);
		
		List<?> workerList = workerService.selectWorkerList(searchVO);
		model.addAttribute("resultList", workerList);
		
		int totCnt = workerService.selectWorkerListCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);	
		
		return "worker/workerList";
	}
	
	@RequestMapping(value = "/insertWorker.do")
	public String InsertWorker(@ModelAttribute("searchVO") WorkerVO searchVO, ModelMap model) throws Exception {
		log.debug("##### InsertWorker START !!! #####");
						
		log.debug("##### InsertWorker sWorkerInfoSeq : " + searchVO.getsWorkerInfoSeq());
		log.debug("worker : " + searchVO.getWorker());
		log.debug("use_yn : " + searchVO.getUse_yn());
		log.debug("compid : " + searchVO.getCompid());
		
		searchVO.setAdd_emp("admin");
		searchVO.setLog_emp("admin");
		
		workerService.insertWorker(searchVO);

		return "forward:/workerList.do";
	}
		
}
