<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * 
 * @class  FactAlarmList
 * @since  2022.01.03
 * @author (주)새힘정보기술 
 *
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
	<jsp:include page="/WEB-INF/fragment/common-js.jsp" />
	<jsp:include page="/WEB-INF/fragment/common-css.jsp" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><spring:message code="title.factAlarm" /></title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/mas.css'/>"/>
    <script type="text/javaScript" language="javascript" defer="defer">
	    $(document).ready(function(){
			$("#sOccuDate").datepicker();
		});     
        <!--
        /* 글 목록 화면 function */
        function fn_egov_selectList() {
        	document.listForm.action = "<c:url value='/factAlarmList.do'/>";
           	document.listForm.submit();
        }
        
        /* pagination 페이지 링크 function */
        function fn_egov_link_page(pageNo){
        	document.listForm.pageIndex.value = pageNo;
        	document.listForm.action = "<c:url value='/factAlarmList.do'/>";
           	document.listForm.submit();
        }
        //-->
    </script>
</head>

<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
    <form:form commandName="searchVO" id="listForm" name="listForm" method="post">
        <input type="hidden" name="selectedId" />
        <div id="content_pop">
        	<!-- 타이틀 -->
        	<div id="title">
        		<ul>
        			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt=""/>&nbsp;<spring:message code="list.factAlarm" /></li>
        		</ul>
        	</div>
        	<!-- // 타이틀 -->
        	<div id="search">
        		<ul>
        			<li>
        			    <label for="searchCondition" style="visibility:show;"><spring:message code="search.sCompId" /></label>
        				<form:select path="sCompId" cssClass="use">
        					<c:forEach var="resultComp" items="${resultCompList}" varStatus="status">
        						<form:option value="${resultComp.compId}" label="${resultComp.compId}" />
        					</c:forEach>
        				</form:select>
        			</li>
        			<li>
        			    <label for="searchCondition" style="visibility:show;"><spring:message code="search.sMixer" /></label>
        				<form:select path="sMixerId" cssClass="use">
        					<form:option value="" label="" />
        					<c:forEach var="resultMixer" items="${resultMixerList}" varStatus="status">
        						<form:option value="${resultMixer.mixerId}" label="${resultMixer.mixerId}" />
        					</c:forEach>
        				</form:select>
        			</li>   
        			<li><label for="searchKeyword" style="visibility:show;"><spring:message code="search.sDate" /></label>
                        <form:input path="sOccuDate" cssClass="txt"/>
                    </li>
        			<li>
        	            <span class="btn_blue_l">
        	                <a href="javascript:fn_egov_selectList();"><spring:message code="button.search" /></a>
        	                <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
        	            </span>
        	        </li>
                </ul>
        	</div>
        	<!-- List -->
        	<div id="table">
        		<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="제조지시번호, 제조번호, 제조품목, 믹서아이디, 발생일시, 발생내역을 표시하는 테이블">
        			<caption style="visibility:hidden">제조지시번호, 제조번호, 제조품목, 믹서아이디, 발생일시, 발생내역을 표시하는 테이블</caption>
        			<colgroup>
        				<col width="5%"/>
        				<col width="7%"/>
        				<col width="10%"/>
        				<col width="?"/>
        				<col width="7%"/>
<%--         				<col width="7%"/> --%>
        				<col width="10%"/>
        				<col width="30%"/>
        			</colgroup>
        			<tr>
        				<th class="fixHeader" align="center">No</th>
        				<th class="fixHeader" align="center"><spring:message code="title.factAlarm.mixer_id" /></th>
        				<th class="fixHeader" align="center"><spring:message code="title.factAlarm.occu_date" /></th>
        				<th class="fixHeader" align="center"><spring:message code="title.factAlarm.alarm_cont" /></th>
        				<th class="fixHeader" align="center"><spring:message code="title.factAlarm.wo_no" /></th>
<%--         				<th class="fixHeader" align="center"><spring:message code="title.factAlarm.prod_no" /></th> --%>
        				<th class="fixHeader" align="center"><spring:message code="title.factAlarm.item_code" /></th>
        				<th class="fixHeader" align="center"><spring:message code="title.factAlarm.item_name" /></th>
        			</tr>
        			<c:forEach var="result" items="${resultList}" varStatus="status">
            			<tr>
            				<td align="center" class="listtd"><c:out value="${paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count)}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.mixerId}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.occuDate}"/></td>
            				<td align="left"   class="listtd"><c:out value="${result.alarmCont}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.woNo}"/></td>
<%--             				<td align="center" class="listtd"><c:out value="${result.prodNo}"/></td> --%>
            				<td align="center" class="listtd"><c:out value="${result.itemCode}"/></td>
            				<td align="left"   class="listtd"><c:out value="${result.itemName}"/></td>
            			</tr>
        			</c:forEach>
        		</table>
        	</div>
        	<!-- /List -->
        	<div id="paging">
        		<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
        		<form:hidden path="pageIndex" />
        	</div>
        </div>
    </form:form>
</body>
</html>
