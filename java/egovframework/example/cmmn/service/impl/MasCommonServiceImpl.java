package egovframework.example.cmmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.cmmn.service.MasCommonService;
import egovframework.example.cmmn.service.MasCommonVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * 
 * @class MasCommonServiceImpl
 * @since  2022.01.12
 * @author (주)새힘정보기술 
 *
 */
@Service("masCommonService")
public class MasCommonServiceImpl extends EgovAbstractServiceImpl implements MasCommonService {

	@Resource(name="masCommonDAO")
	private MasCommonDAO masCommonDAO;
	
	@Override
	public List<?> selectCompIDList(MasCommonVO param) throws Exception {
		// TODO Auto-generated method stub
		return masCommonDAO.selectCompIDList(param);
	}

	@Override
	public List<?> selectMixerIdList(MasCommonVO param) throws Exception {
		// TODO Auto-generated method stub
		return masCommonDAO.selectMixerIdList(param);
	}

	@Override
	public List<?> selectMixerNoList(MasCommonVO param) throws Exception {
		// TODO Auto-generated method stub
		return masCommonDAO.selectMixerNoList(param);
	}

}
