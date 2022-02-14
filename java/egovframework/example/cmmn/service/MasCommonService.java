package egovframework.example.cmmn.service;

import java.util.List;

/**
 * 
 * @class  MasCommonService
 * @since  2022.01.12
 * @author (주)새힘정보기술 
 *
 */
public interface MasCommonService {
	/**
	 * @method 회사이이디 읽어오기 
	 * @param param
	 * @return
	 */
	List<?> selectCompIDList(MasCommonVO param) throws Exception;
	
	 /**
	  * @method MIXER_ID 읽어오기 
	  * @param param
	  * @return
	  */
	List<?> selectMixerIdList(MasCommonVO param) throws Exception;
	
	 /**
	  * @method MixerNo 읽어오기 
	  * @param param
	  * @return
	  */
	List<?> selectMixerNoList(MasCommonVO param) throws Exception;
}
