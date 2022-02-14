package egovframework.example.factAlarm.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.cmmn.service.MasCommonService;
import egovframework.example.cmmn.service.MasCommonVO;
import egovframework.example.factAlarm.service.FactAlarmService;
import egovframework.example.factAlarm.service.FactAlarmVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * 
 * @class  FactAlarmController
 * @since  2022.01.03
 * @author (주)새힘정보기술 
 *
 */
@Controller
public class FactAlarmController {

	private static final Logger log = LoggerFactory.getLogger(FactAlarmController.class);
	
	@Resource(name = "factAlarmService")
	private FactAlarmService factAlarmService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "masCommonService")
	private MasCommonService masCommonService;
	
	/**
	 * @Method selectFactAlarmList
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/factAlarmList.do")
	public String selectFactAlarmList(@ModelAttribute("searchVO") FactAlarmVO searchVO, ModelMap model) throws Exception {
		log.debug("##### selectFactAlarmList START !!! #####");
		
		/** EgovPropertyService */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));
		
		// 최초 회사(공장) 값 설정
		if ("".equals(searchVO.getsCompId()) || searchVO.getsCompId() == null)
				searchVO.setsCompId(propertiesService.getString("compId"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());		
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		// 조회 조건 
		MasCommonVO paramVO = new MasCommonVO();
		
		// 설비알람발생 테이블 설정 
		paramVO.setTableId("T_FACT_ALARM_INFO");

		// 회사이이디
		log.debug("##### selectCompIDList paramVO :: " + paramVO);
		
		List<?> compList = masCommonService.selectCompIDList(paramVO);
		model.addAttribute("resultCompList", compList);
	
		// 믹서아이디
		log.debug("##### selectManufactItemList paramVO :: " + paramVO);
		
		List<?> mixerList = masCommonService.selectMixerIdList(paramVO);
		model.addAttribute("resultMixerList", mixerList);
		
		// 내역 조회 
		log.debug("##### selectFactAlarmList searchVO :: " + searchVO);
		
		List<?> list = factAlarmService.selectFactAlarmList(searchVO);
		model.addAttribute("resultList", list);

		// 내역 건수 
		int totCnt = factAlarmService.selectFactAlarmListCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		log.debug("##### selectFactAlarmList selectFactAlarmList :: " + list);
		log.debug("##### selectFactAlarmList selectFactAlarmListCnt :: " + totCnt);
		
		log.debug("##### selectFactAlarmList END !!! #####");
		return "factAlarm/factAlarmList";
	}
}
