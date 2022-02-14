package egovframework.example.worker.service;

import egovframework.example.cmmn.CommPagingVO;

/**
 * 
 * @Class Name : WorkerVO
 * @author 새힘정보기술
 * @since 2022. 01.18
 * @version 0.1
 *
 */

public class WorkerVO extends CommPagingVO {

	private static final long serialVersionUID = 1L;
	
	private String sCompId;		// 회사(공장)아이디  조회용 
	private String sWorker;	    // 작업자 아이디  조회용
	private String sWorkerInfoSeq;
	private String registerFlag;
	
	private String worker_info_seq; // 순번
	private String compid;  // 공장
	
	private String worker; // 작업자 이름
	private String use_yn; // 사용여부
	
	private String add_emp; // 최초등록자
	private String add_tim; // 최초등록시간
	private String log_emp;  // 수정등록자
	private String log_tim; // 수정시간
	
	public String getRegisterFlag() {
		return registerFlag;
	}
	public void setRegisterFlag(String registerFlag) {
		this.registerFlag = registerFlag;
	}
	public String getsCompId() {
		return sCompId;
	}
	public void setsCompId(String sCompId) {
		this.sCompId = sCompId;
	}
	public String getsWorker() {
		return sWorker;
	}
	public void setsWorker(String sWorker) {
		this.sWorker = sWorker;
	}
	public String getsWorkerInfoSeq() {
		return sWorkerInfoSeq;
	}
	public void setsWorkerInfoSeq(String sWorkerInfoSeq) {
		this.sWorkerInfoSeq = sWorkerInfoSeq;
	}
	public String getWorker_info_seq() {
		return worker_info_seq;
	}
	public void setWorker_info_seq(String worker_info_seq) {
		this.worker_info_seq = worker_info_seq;
	}
	public String getCompid() {
		return compid;
	}
	public void setCompid(String compid) {
		this.compid = compid;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getAdd_emp() {
		return add_emp;
	}
	public void setAdd_emp(String add_emp) {
		this.add_emp = add_emp;
	}
	public String getAdd_tim() {
		return add_tim;
	}
	public void setAdd_tim(String add_tim) {
		this.add_tim = add_tim;
	}
	public String getLog_emp() {
		return log_emp;
	}
	public void setLog_emp(String log_emp) {
		this.log_emp = log_emp;
	}
	public String getLog_tim() {
		return log_tim;
	}
	public void setLog_tim(String log_tim) {
		this.log_tim = log_tim;
	}
	
}
