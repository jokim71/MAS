package egovframework.example.manufactItem.service;

import egovframework.example.cmmn.CommPagingVO;

/**
 * 
 * @Class Name : ManufactItemVO
 * @author 새힘정보기술
 * @since 2022. 01.10
 * @version 1.0
 *
 */
public class ManufactItemVO extends CommPagingVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private String mode;
	
	/** 조회 조건 */
	private String sOrderNo;		// 제조지시번호 
	private String sMixerNo;		// 믹서번 
	private String sItemCode;		// 제조품목코
	private String sOrderDate;		// 제조일자 (시작)
	private String eOrderDate;		// 제조일자 (종료) 
	private String searchOrderNo;	// 엑셀출력용 지시번호 변수 저장
	
	private String Sequence;			// 일련번호
	private String CRT_TYPE;			// TYPE
	private String D_Mark;				// MARK
	private String OrderNo;				// 지시번호
	private String SendTime;			// 전송일시
	private String ManufactureNo;		// 제조번호
	private String BulkCode;
	private String BulkName;			
	private String ManufactureiTem;		// 제조품목코드
	private String ManufactureName;		// 제조품목명 
	private String OrderDate;			// 제조지시일시  
	private String ManufactureRoom;		// 제조실 
	private String ManufactureQTY;		// 제조량 
	private String ManufactureDate;		// 제조일시 
	private String ManufacturePerson;   // 작업자 
	private String MixerNo;				// MixerNo
	private String RegistrationDate;	
	private String StartTime;			// 시작일시 
	private String EndTime;				// 종료일시 
	private String EndCheck;
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getsOrderNo() {
		return sOrderNo;
	}
	public void setsOrderNo(String sOrderNo) {
		this.sOrderNo = sOrderNo;
	}
	public String getsMixerNo() {
		return sMixerNo;
	}
	public void setsMixerNo(String sMixerNo) {
		this.sMixerNo = sMixerNo;
	}
	public String getsItemCode() {
		return sItemCode;
	}
	public void setsItemCode(String sItemCode) {
		this.sItemCode = sItemCode;
	}
	public String getsOrderDate() {
		return sOrderDate;
	}
	public void setsOrderDate(String sOrderDate) {
		this.sOrderDate = sOrderDate;
	}
	public String geteOrderDate() {
		return eOrderDate;
	}
	public void seteOrderDate(String eOrderDate) {
		this.eOrderDate = eOrderDate;
	}
	public String getSequence() {
		return Sequence;
	}
	public void setSequence(String sequence) {
		Sequence = sequence;
	}
	public String getCRT_TYPE() {
		return CRT_TYPE;
	}
	public void setCRT_TYPE(String cRT_TYPE) {
		CRT_TYPE = cRT_TYPE;
	}
	public String getD_Mark() {
		return D_Mark;
	}
	public void setD_Mark(String d_Mark) {
		D_Mark = d_Mark;
	}
	public String getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(String orderNo) {
		OrderNo = orderNo;
	}
	public String getSendTime() {
		return SendTime;
	}
	public void setSendTime(String sendTime) {
		SendTime = sendTime;
	}
	public String getManufactureNo() {
		return ManufactureNo;
	}
	public void setManufactureNo(String manufactureNo) {
		ManufactureNo = manufactureNo;
	}
	public String getBulkCode() {
		return BulkCode;
	}
	public void setBulkCode(String bulkCode) {
		BulkCode = bulkCode;
	}
	public String getBulkName() {
		return BulkName;
	}
	public void setBulkName(String bulkName) {
		BulkName = bulkName;
	}
	public String getManufactureiTem() {
		return ManufactureiTem;
	}
	public void setManufactureiTem(String manufactureiTem) {
		ManufactureiTem = manufactureiTem;
	}
	public String getManufactureName() {
		return ManufactureName;
	}
	public void setManufactureName(String manufactureName) {
		ManufactureName = manufactureName;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public String getManufactureRoom() {
		return ManufactureRoom;
	}
	public void setManufactureRoom(String manufactureRoom) {
		ManufactureRoom = manufactureRoom;
	}
	public String getManufactureQTY() {
		return ManufactureQTY;
	}
	public void setManufactureQTY(String manufactureQTY) {
		ManufactureQTY = manufactureQTY;
	}
	public String getManufactureDate() {
		return ManufactureDate;
	}
	public void setManufactureDate(String manufactureDate) {
		ManufactureDate = manufactureDate;
	}
	public String getManufacturePerson() {
		return ManufacturePerson;
	}
	public void setManufacturePerson(String manufacturePerson) {
		ManufacturePerson = manufacturePerson;
	}
	public String getMixerNo() {
		return MixerNo;
	}
	public void setMixerNo(String mixerNo) {
		MixerNo = mixerNo;
	}
	public String getRegistrationDate() {
		return RegistrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		RegistrationDate = registrationDate;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getEndCheck() {
		return EndCheck;
	}
	public void setEndCheck(String endCheck) {
		EndCheck = endCheck;
	}
	public String getSearchOrderNo() {
		return searchOrderNo;
	}
	public void setSearchOrderNo(String searchOrderNo) {
		this.searchOrderNo = searchOrderNo;
	} 
	
}
