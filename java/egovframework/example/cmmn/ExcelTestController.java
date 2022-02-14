package egovframework.example.cmmn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;

@Controller
public class ExcelTestController {
	
	/** EgovSampleService */
	@Resource(name = "sampleService")
	private EgovSampleService sampleService;

	@RequestMapping(value = "/downExcel.do")
    public void listExcel(HttpServletRequest request,
            HttpServletResponse response, @ModelAttribute("searchVO") SampleDefaultVO searchVO,
            ModelMap modelMap) throws Exception { // 해당 화면의 검색조건에 해당하는 vo가 있다면 추가

        // 그냥 평소에 마이바티스에서 데이터 뽑는 방법으로 데이터를 가져온다.
        // 해당 화면에서 조회되는 리스트를 만든다 ex) 
		List<?> sampleList = sampleService.selectSampleList(searchVO);
        
        // 받은 데이터를 맵에 담는다.
        Map<String, Object> beans = new HashMap<String, Object>();
        beans.put("dataList", sampleList);
        
        // 엑셀 다운로드 메소드가 담겨 있는 객체
        MakeExcel me = new MakeExcel();

        //me.download(request, response, beans, "다운받을때지정될 엑셀파일명", "엑셀템플릿 파일 명.xlsx", "");
        me.download(request, response, beans, "test", "excelTest.xlsx", "");
    }

}
