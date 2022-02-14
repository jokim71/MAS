package egovframework.example.manufactItem.service;

import egovframework.example.cmmn.CommPagingVO;

/**
 * 
 * @Class Name : ScaleVO
 * @author 새힘정보기술
 * @since 2022. 01.10
 * @version 1.0
 *
 */
public class ScaleVO extends CommPagingVO{

	/** 조회 조건 */
	private String sOrderNo;		// 제조지시번호 
	private String sIpDate;
	private String eIpDate;
	
	private String Sequence;
	private String OrderNo;
	private String INPUT_SEQ;
	private String ManufactureNo;
	private String ScaleBarCode;
	private String MaterialCode;
	private String MaterialName;
	private String Capacity;
	private String ScaleCapacity;
	private String LineNumber;
	private String RegistrationDate;
	private String Select_Tank;
	private String DisperDivision;
	private String BarCode;
	private String Checked;
	private String MixerNo;
	private String ipDate;
	private String rowNum;
	
	public String getsOrderNo() {
		return sOrderNo;
	}
	public void setsOrderNo(String sOrderNo) {
		this.sOrderNo = sOrderNo;
	}
	public String getSequence() {
		return Sequence;
	}
	public void setSequence(String sequence) {
		Sequence = sequence;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public String getINPUT_SEQ() {
		return INPUT_SEQ;
	}
	public void setINPUT_SEQ(String iNPUT_SEQ) {
		INPUT_SEQ = iNPUT_SEQ;
	}
	public String getManufactureNo() {
		return ManufactureNo;
	}
	public void setManufactureNo(String manufactureNo) {
		ManufactureNo = manufactureNo;
	}
	public String getScaleBarCode() {
		return ScaleBarCode;
	}
	public void setScaleBarCode(String scaleBarCode) {
		ScaleBarCode = scaleBarCode;
	}
	public String getMaterialCode() {
		return MaterialCode;
	}
	public void setMaterialCode(String materialCode) {
		MaterialCode = materialCode;
	}
	public String getMaterialName() {
		return MaterialName;
	}
	public void setMaterialName(String materialName) {
		MaterialName = materialName;
	}
	public String getCapacity() {
		return Capacity;
	}
	public void setCapacity(String capacity) {
		Capacity = capacity;
	}
	public String getScaleCapacity() {
		return ScaleCapacity;
	}
	public void setScaleCapacity(String scaleCapacity) {
		ScaleCapacity = scaleCapacity;
	}
	public String getLineNumber() {
		return LineNumber;
	}
	public void setLineNumber(String lineNumber) {
		LineNumber = lineNumber;
	}
	public String getRegistrationDate() {
		return RegistrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		RegistrationDate = registrationDate;
	}
	public String getSelect_Tank() {
		return Select_Tank;
	}
	public void setSelect_Tank(String select_Tank) {
		Select_Tank = select_Tank;
	}
	public String getDisperDivision() {
		return DisperDivision;
	}
	public void setDisperDivision(String disperDivision) {
		DisperDivision = disperDivision;
	}
	public String getBarCode() {
		return BarCode;
	}
	public void setBarCode(String barCode) {
		BarCode = barCode;
	}
	public String getChecked() {
		return Checked;
	}
	public void setChecked(String checked) {
		Checked = checked;
	}
	public String getMixerNo() {
		return MixerNo;
	}
	public void setMixerNo(String mixerNo) {
		MixerNo = mixerNo;
	}
	public String getIpDate() {
		return ipDate;
	}
	public void setIpDate(String ipDate) {
		this.ipDate = ipDate;
	}
	public String getRowNum() {
		return rowNum;
	}
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	public String getsIpDate() {
		return sIpDate;
	}
	public void setsIpDate(String sIpDate) {
		this.sIpDate = sIpDate;
	}
	public String geteIpDate() {
		return eIpDate;
	}
	public void seteIpDate(String eIpDate) {
		this.eIpDate = eIpDate;
	}
	
}
