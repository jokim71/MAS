package egovframework.example.cmmn.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.cmmn.service.MasCommonVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * 
 * @class	MasCommonDAO
 * @since  2022.01.12
 * @author (주)새힘정보기술 
 *
 */
@Repository("masCommonDAO")
public class MasCommonDAO extends EgovAbstractDAO {
	 /**
	  * @method 회사이이디 읽어오기 
	  * @param param
	  * @return
	  */
	public List<?> selectCompIDList(MasCommonVO param) throws Exception {
		return list("masCommonDAO.selectCompIDList", param);
	}

	 /**
	  * @method MIXER_ID 읽어오기 
	  * @param param
	  * @return
	  */
	public List<?> selectMixerIdList(MasCommonVO param) throws Exception {
		return list("masCommonDAO.selectMixerIdList", param);
	}
	
	 /**
	  * @method MixerNo 읽어오기 
	  * @param param
	  * @return
	  */
	public List<?> selectMixerNoList(MasCommonVO param) throws Exception {
		return list("masCommonDAO.selectMixerNoList", param);
	}
}
