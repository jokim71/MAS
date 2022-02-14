package egovframework.example.manufactItem.web;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.cmmn.service.MasCommonService;
import egovframework.example.cmmn.service.MasCommonVO;
import egovframework.example.manufactItem.service.ManufactItemService;
import egovframework.example.manufactItem.service.ManufactItemVO;
import egovframework.example.manufactItem.service.ScaleVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


/**
 * 
 * @class  manufactItemController
 * @since  2022.01.14
 * @author (주)새힘정보기술 
 *
 */
@Controller
public class manufactItemController {

	private static final Logger log = LoggerFactory.getLogger(manufactItemController.class);

	@Resource(name = "manufactItemService")
	private ManufactItemService manufactItemService;
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "masCommonService")
	private MasCommonService masCommonService;
	
	/**
	 * @Method selectManufactItemList
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manufactItemList.do")
	public String selectManufactItemList(@ModelAttribute("searchVO") ManufactItemVO searchVO, ModelMap model) throws Exception {
		log.debug("##### selectManufactItemList START !!! #####");
		
		/** EgovPropertyService */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());		
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		// 최초조회값 설정
		if ("".equals(searchVO.getsOrderDate()) || searchVO.getsOrderDate() == null) {		// 오른 날자 
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
			
			String ltoDay = sdf.format(date);

			// 어제 날자 
			Date dDate = new Date();
			dDate = new Date(dDate.getTime()+(1000*60*60*24*-1));
			SimpleDateFormat dSdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
			
			String lyesterday = dSdf.format(dDate);
			
			searchVO.setsOrderDate(lyesterday);
			searchVO.seteOrderDate(ltoDay);
		}
		
		// Mixer 정보 조회조건 
		MasCommonVO commVO = new MasCommonVO();
		
		// 설비알람발생 테이블 설정 
		commVO.setTableId("IF_Manufacturing");

		log.debug("##### selectManufactItemList paramVO :: " + commVO);
		
		List<?> mixerList = masCommonService.selectMixerNoList(commVO);
		model.addAttribute("resultMixerList", mixerList);
		
		// 지시내역 조회 
		log.debug("##### selectManufactItemList searchVO :: " + searchVO);
		
		List<?> list = manufactItemService.selectManufactItemList(searchVO);
		model.addAttribute("resultList", list);		
		
		// 지시내역 건수 
		int totCnt = manufactItemService.selectManufactItemListCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		// 투입원료 조회 
		ScaleVO scaleVO = new ScaleVO();
        String id = searchVO.getOrderNo();

		if (id == null || id.length() == 0) {
			id = "";
		}
		
		scaleVO.setsOrderNo(id);		// 선택한 지시번호	
		
		List<?> scaleList = manufactItemService.selectScaleList(scaleVO);		
		model.addAttribute("resultScaleList", scaleList);		
		
		log.debug("##### selectManufactItemList selectManufactItemList :: " + list);
		log.debug("##### selectManufactItemList selectManufactItemListCnt :: " + totCnt);
		log.debug("##### selectManufactItemList selectScaleList :: " + scaleList);
		
		log.debug("##### selectManufactItemList END !!! #####");
		return "manufactItem/manufactItemList";
	}

	/**
	 * @Method selectScaleCapacity
	 * @param searchVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/selectScaleCapacity.do")
	public String selectScaleCapacity(@ModelAttribute("searchVO") ScaleVO searchVO, ModelMap model) throws Exception {
		log.debug("##### selectScaleCapacity START !!! #####");
		
		// 기간내 투입용량 
		int totCnt = manufactItemService.selectScaleCapacity(searchVO);
		
		model.addAttribute("resultValue", totCnt);
		
		log.debug("##### selectScaleCapacity END !!! #####");
		return "manufactItem/scaleCapacityPop";
	}
}
