package egovframework.example.cmmn.service.impl;

import java.util.List;

import egovframework.example.cmmn.service.MasCommonVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * 
 * @class  MasCommonMapper
 * @since  2022.01.12
 * @author (주)새힘정보기술 
 *
 */
@Mapper("masCommonMapper")
public interface MasCommonMapper {
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
