package egovframework.example.cmmn.service;

import java.io.Serializable;

public class MasCommonVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5443289919391257220L;


	private String compId;		// 회사아이디 
	private String mixerId;		// 믹서아이디
	private String tableId;		// 테이블아이디 
	
	public String getCompId() {
		return compId;
	}
	public void setCompId(String compId) {
		this.compId = compId;
	}
	public String getMixerId() {
		return mixerId;
	}
	public void setMixerId(String mixerId) {
		this.mixerId = mixerId;
	}
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
	
	
}
