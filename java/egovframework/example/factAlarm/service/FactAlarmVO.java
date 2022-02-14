package egovframework.example.factAlarm.service;

import egovframework.example.cmmn.CommPagingVO;

/**
 * 
 * @Class Name : FactAlarmVO
 * @author 새힘정보기술
 * @since 2022. 01.03
 * @version 1.0
 *
 */
public class FactAlarmVO extends CommPagingVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 조회 조건 */
	private String sCompId;		// 회사(공장)아이디
	private String sMixerId;	// 믹서아이디 
	private String sOccuDate;	// 발생일자 
	
	private String fact_alarm_info_seq;
	private String wo_no;		// 제조지시번호 
	private String prod_no;		// 제조번호 
	private String item_code;	// 제조품목아이디 
	private String item_name;	// 제조품목명 
	private String mixer_id;	// 믹서아이디 
	private String occu_date;	// 발생일시 
	private String alarm_cont;	// 발생내역 
	
	public String getsCompId() {
		return sCompId;
	}
	public void setsCompId(String sCompId) {
		this.sCompId = sCompId;
	}
	public String getsMixerId() {
		return sMixerId;
	}
	public void setsMixerId(String sMixerId) {
		this.sMixerId = sMixerId;
	}
	public String getsOccuDate() {
		return sOccuDate;
	}
	public void setsOccuDate(String sOccuDate) {
		this.sOccuDate = sOccuDate;
	}
	
	public String getFact_alarm_info_seq() {
		return fact_alarm_info_seq;
	}
	public void setFact_alarm_info_seq(String fact_alarm_info_seq) {
		this.fact_alarm_info_seq = fact_alarm_info_seq;
	}
	public String getWo_no() {
		return wo_no;
	}
	public void setWo_no(String wo_no) {
		this.wo_no = wo_no;
	}
	public String getProd_no() {
		return prod_no;
	}
	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getMixer_id() {
		return mixer_id;
	}
	public void setMixer_id(String mixer_id) {
		this.mixer_id = mixer_id;
	}
	public String getOccu_date() {
		return occu_date;
	}
	public void setOccu_date(String occu_date) {
		this.occu_date = occu_date;
	}
	public String getAlarm_cont() {
		return alarm_cont;
	}
	public void setAlarm_cont(String alarm_cont) {
		this.alarm_cont = alarm_cont;
	}
	
}
