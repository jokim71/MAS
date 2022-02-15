<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * 
 * @class  WorkerList
 * @since  2022.01.19
 * @author (주)새힘정보기술 
 *
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><spring:message code="title.worker" /></title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/mas.css'/>"/>
    <script type="text/javaScript" language="javascript" defer="defer">    
        <!--
        /* 글 목록 화면 function */
        function fn_egov_selectList(id) {
        	document.listForm.mode.value = "SEARCH";
        	document.listForm.action = "<c:url value='/workerList.do'/>";
           	document.listForm.submit();
        }
        
        /* pagination 페이지 링크 function */
        function fn_egov_link_page(pageNo){
        	document.listForm.mode.value = "SEARCH";
        	document.listForm.pageIndex.value = pageNo;
        	document.listForm.action = "<c:url value='/workerList.do'/>";
           	document.listForm.submit();
        }
                
        /* 작업자 추가 function */
        function fn_worker_write_Pop() {
        	document.listForm.sWorkerInfoSeq.value = "";
        	document.listForm.empid.value = "";
        	document.listForm.worker.value = "";
        	document.listForm.use_yn.value = "Y";
        	document.listForm.compid.value = document.listForm.sCompId.value;
        	
        	document.getElementById("pop").style.display="inline";      	
        } 
        
        /* 글 수정 화면 function */
        function fn_worker_update(seq, empid, worker, yn) {
        	document.listForm.sWorkerInfoSeq.value = seq;
        	document.listForm.empid.value  = empid;
        	document.listForm.worker.value = worker;
        	document.listForm.use_yn.value = yn;
        	document.listForm.compid.value = document.listForm.sCompId.value;
        	
        	document.getElementById("pop").style.display="inline";      	
        }
        
        /*  화면 닫기 function */
        function fn_egov_closeWin() {
        	document.getElementById("pop").style.display="none";
        }
        
        /* 글 등록 function */
        function fn_worker_save() {
        	document.listForm.action = "<c:url value='/insertWorker.do'/>";
        	document.listForm.submit();
        	
        	document.getElementById("pop").style.display="none";
        }
        
        //-->
    </script>
</head>

<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
    <form:form commandName="searchVO" id="listForm" name="listForm" method="post">
        <input type="hidden" name="sWorkerInfoSeq" />
        <input type="hidden" name="mode" />
        <div id="content_pop">
        	<!-- 타이틀 -->
        	<div id="title" style="width:600px;">
        		<ul>
        			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt=""/>&nbsp;<spring:message code="list.worker" /></li>
        		</ul>
        	</div>
        	<!-- // 타이틀 -->
        	<div id="search" style="width:800px;">
	        	<div>
	        		<ul>
	         			<li>
	        			    <label for="searchCondition" style="visibility:show;"><spring:message code="search.sCompId" /></label>
	        				<form:select path="sCompId" cssClass="use">
	        					<c:forEach var="resultComp" items="${resultCompList}" varStatus="status">
	        						<form:option value="${resultComp.compId}" label="${resultComp.compId}" />
	        					</c:forEach>
	        				</form:select>
	        			</li>
	        			<li><label for="searchKeyword" style="visibility:show; margin-left: 20px;"><spring:message code="search.name" /></label>
	                        <form:input path="sWorker" cssClass="txt"/>
	                    </li>
	        			<li>
	        	            <span class="btn_blue_l">
	        	                <a href="javascript:fn_egov_selectList();"><spring:message code="button.search" /></a>
	        	                <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
	        	            </span>
	        	        </li>
	                </ul>
	            </div>
	            <div>
	                <ul>
	                	<li>
	        	            <span class="btn_blue_l" style="margin-left: 10px">
	        	                <a href="javascript:fn_worker_write_Pop();"><spring:message code="button.add" /></a>
	        	                <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
	        	            </span>
	        	        </li>
	                </ul>
	            </div>
        	</div>
        	<!-- List -->
        	<div id="table" style="width:600px; height:400px; overflow:auto;">
        		<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="작업자이름, 사용여부">
        			<caption style="visibility:hidden">작업자 이름, 사용여부</caption>
        			<colgroup>
        				<col width="5%"/>
        				<col width="10%"/>
        				<col width="10%"/>
        				<col width="10%"/>
        				<col width="10%"/>
        			</colgroup>
        			<tr>
        				<th align="center" class="fixHeader">No</th>
        				<th align="center" class="fixHeader"><spring:message code="title.worker.empid" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.worker.worker" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.worker.use_yn" /></th>
         				<th align="center" class="fixHeader"><spring:message code="title.worker.add_tim" /></th>
        				
        			</tr>
        			<c:forEach var="result" items="${resultList}" varStatus="status">
            			<tr onClick="javaScript:fn_worker_update('<c:out value="${result.workerInfoSeq}"/>', '<c:out value="${result.empid}"/>', '<c:out value="${result.worker}"/>', '<c:out value="${result.useYn}"/>')">
            				<td align="center" class="listtd"><c:out value="${result.workerInfoSeq}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.empid}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.worker}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.useYn}"/></td>
            			    <td align="center" class="listtd"><c:out value="${result.addtim}"/></td>
            			</tr>
        			</c:forEach>
        		</table>
        	</div>
        	<!-- /List -->
        	<div id="paging" style="width:600px;">
        	  <ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
        		<form:hidden path="pageIndex" />
        	</div>
        </div>
		<div id="pop" style="display:none;">
		    <div style="float:left; text-align:left; padding:10px 10px 10px 10px; width:280px; background:#3D3D3D;">
		    	<!-- 타이틀 -->
		    	<div id="title" style="width:280px;">
		    		<ul>
		    			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt=""/>&nbsp;작업자 등록</li>
		    		</ul>
		    	</div>
		    	<!-- // 타이틀 -->
		    	<div id="search">
		    		<div>
						<label for="searchKeyword" style="visibility:show; margin-left: 10px;"><spring:message code="title.worker.empid" /></label>				
							<form:input path="empid" cssClass="txt" style="margin-left: 11px"/>                        
					</div>	
		    		<div style="margin-top: 10px;">
						<label for="searchKeyword" style="visibility:show; margin-left: 10px;"><spring:message code="title.worker.worker" /></label>				
							<form:input path="worker" cssClass="txt" />                        
					</div>	
					<div style="margin-top: 10px;">					    	
		       			<label for="searchKeyword" style="visibility:show; margin-left: 10px"><spring:message code="title.worker.use_yn" /></label>
		       				<form:select path="use_yn" cssClass="use">
								<form:option value="Y" label="사용" />
								<form:option value="N" label="미사용" />
		       				</form:select>
		       		</div>	
		       		<div style="margin-top: 10px;">	
		       			<label for="searchKeyword" style="visibility:show;"><spring:message code="search.sCompId" /></label>
		       				<form:input path="compid" cssClass="txt"/>
		       		</div>	
		    	</div>
		    </div>
			<div style="float:left; margin-left: 80px;">
				<span class="btn_blue_l">
			        <a href="javascript:fn_worker_save();">저장</a>
			        <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
			    </span>	
			    <span class="btn_blue_l" style="margin-left: 20px;">
			        <a href="javascript:fn_egov_closeWin();">닫기</a>
			        <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
			    </span>	
			</div>	
		</div>
    </form:form>
</body>
</html>
