<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * 
 * @class  ManufactItemList
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
    <title><spring:message code="title.manufatcItem" /></title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/mas.css'/>"/>
    <script type="text/javaScript" language="javascript" defer="defer">
	    $(document).ready(function(){		
			$("#sOrderDate").datepicker();
			$("#eOrderDate").datepicker();
		}); 
	    
        <!--
        /* 글 목록 화면 function */
        function fn_egov_selectList() {
        	document.listForm.mode.value = "SEARCH";
        	document.listForm.action = "<c:url value='/manufactItemList.do'/>";
           	document.listForm.submit();
        }
        
        /* pagination 페이지 링크 function */
        function fn_egov_link_page(pageNo){
        	document.listForm.mode.value = "SEARCH";
        	document.listForm.pageIndex.value = pageNo;
        	document.listForm.action = "<c:url value='/manufactItemList.do'/>";
           	document.listForm.submit();
        }

        function fn_egov_manufactList(id){
        	document.listForm.orderNo.value = id;
        	document.listForm.mode.value = "SEARCH";

        	document.listForm.action = "<c:url value='/manufactItemList.do'/>";
           	document.listForm.submit();
        }
        
        function fn_egov_sacleCapacity(){
        	window.open("<c:url value='/selectScaleCapacity.do'/>", "_bkank", "width=400, height=200, left=100, top=50");
        }
        
        /* MainData Excel Download function */
        function fn_egov_mainData_xlsDownload(){
        	document.listForm.action = "<c:url value='/excelManufactItemList.do'/>";
           	document.listForm.submit();
        }
        
        /* SubData Excel Download function */
        function fn_egov_subData_xlsDownload(id){        
        	if(id == '' || id == null){
        		alert("지시번호를 선택하지 않았습니다.");
        		return;
        	}
        	document.itemListForm.searchOrderNo.value = id;
        	
        	document.itemListForm.action = "<c:url value='/excelScaleCapacityList.do'/>";
           	document.itemListForm.submit();
        }
        //-->
    </script>
</head>

<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
    <form:form commandName="searchVO" id="listForm" name="listForm" method="post">
    	<input type="hidden" name="orderNo"/>
    	<input type="hidden" name="mode"/>
        <div id="content_pop">
        	<!-- 타이틀 -->
        	<div id="title">
        		<ul>
        			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt=""/>&nbsp;<spring:message code="list.manufactItem" /></li>
        		</ul>
        	</div>
        	<!-- // 타이틀 -->
        	<div id="search">
        		<ul>
        			<li><label for="searchKeyword" style="visibility:show;"><spring:message code="search.sWoNo" /></label>
                        <form:input path="sOrderNo" cssClass="txt"/>
                    </li>
        			<li><label for="searchKeyword" style="visibility:show;"><spring:message code="search.sDate" /></label>
                        <form:input path="sOrderDate" cssClass="datePicker"/>&nbsp;~&nbsp;
                        <form:input path="eOrderDate" cssClass="datePicker"/>                     
                    </li>
        			<li>
        			    <label for="searchCondition" style="visibility:show;"><spring:message code="search.sMixer" /></label>
        				<form:select path="sMixerNo" cssClass="use">
        					<form:option value="" label="" />
        					<c:forEach var="resultMixer" items="${resultMixerList}" varStatus="status">
        						<form:option value="${resultMixer.mixerId}" label="${resultMixer.mixerId}" />
        					</c:forEach>
        				</form:select>
        			</li>                    
        			<li><label for="searchKeyword" style="visibility:show;"><spring:message code="search.sItem" /></label>
                        <form:input path="sItemCode" cssClass="txt"/>
                    </li>
        			<li>
        	            <span class="btn_blue_l">
        	                <a href="javascript:fn_egov_selectList();"><spring:message code="button.search" /></a>
        	                <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt="조회"/>
        	            </span>
        	        </li>
        			<li>
        	            <span class="btn_blue_l">
        	                <a href="javascript:fn_egov_mainData_xlsDownload();"><spring:message code="button.xls" /></a>
        	                <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt="엑셀로 저장"/>
        	            </span>
        	        </li>
        			<li>
        	            <span class="btn_blue_l">
        	                <a href="javascript:fn_egov_sacleCapacity();">기간내투입</a>
        	                <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt="기간내투입"/>
        	            </span>
        	        </li>
                </ul>
        	</div>
        	<!-- List -->
        	<div id="table" style="height:320px; overflow:auto;">
        		<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="No, TYPE, MARK, 지시번호, 전송일자, 제조번호, 제조품목, 제조설명, 지시일자, 제조량, 제조날짜등을 표시하는 테이블">
        			<caption style="visibility:hidden">No, TYPE, MARK, 지시번호, 전송일자, 제조번호, 제조품목, 제조설명, 지시일자, 제조량, 제조날짜등을 표시하는 테이블</caption>
        			<colgroup>
        				<col width="5%"/>
        				<col width="5%"/>
        				<col width="5%"/>
        				<col width="5%"/>
        				<col width="10%"/>
        				<col width="5%"/>
        				<col width="5%"/>
        				<col width="?"/>
        				<col width="10%"/>
        				<col width="7%"/>
        				<col width="5%"/>
        				<col width="10%"/>
        				<col width="5%"/>
        				<col width="7%"/>
        				<col width="7%"/>
        			</colgroup>
        			<tr>
        				<th align="center" class="fixHeader">No</th>
        				<th align="center" class="fixHeader">TYPE</th>
        				<th align="center" class="fixHeader">MARK</th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.OrderNo" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.SendTime" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ManufactureNo" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ManufactureiTem" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ManufactureiTem" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.OrderDate" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ManufactureRoom" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ManufactureQTY" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ManufactureDate" /></th>
        				<th align="center" class="fixHeader">MixerNo</th>
        				<th align="center" class="fixHeader">StartTime</th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ManufacturePerson" /></th>
        			</tr>
        			<c:forEach var="result" items="${resultList}" varStatus="status">
            			<tr onClick="javascript:fn_egov_manufactList('<c:out value="${result.orderno}"/>')">
            				<td align="center" class="listtd"><c:out value="${result.sequence}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.crtType}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.dMark}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.orderno}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.sendtime}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.manufactureno}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.manufactureitem}"/></td>
            				<td align="left"   class="listtd ellipsis"><c:out value="${result.manufacturename}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.orderdate}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.manufactureroom}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.manufactureqty}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.manufacturedate}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.mixerno}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.starttime}"/></td>
            				<td align="center" class="listtd"><c:out value="${result.manufactureperson}"/></td>
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
    <!-- 원료데이터 -->
    <form:form commandName="searchVO" id="itemListForm" name="itemListForm" method="post">
    	<input type="hidden" name="searchOrderNo"/>
        <div id="content_pop">
        	<span class="btn_blue_l" style="float: right;">
        	    <a href="javascript:fn_egov_subData_xlsDownload('<c:out value="${resultOrderNo}"/>');"><spring:message code="button.xls" /></a>
        	    <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt="엑셀로 저장"/>
        	</span>
		<!-- List -->
        	<div id="table" style="height:400px; overflow:auto;">
        		<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="지시번호, 순번, 제조번호, 바코드, 원료코드, 원이름, 지시량, 계량무게, 투입장비, 투입일시, 투입순서등을 표시하는 테이블">
        			<caption style="visibility:hidden">지시번호, 순번, 제조번호, 바코드, 원료코드, 원이름, 지시량, 계량무게, 투입장비, 투입일시, 투입순서등을 표시하는 테이블</caption>
        			<colgroup>
        				<col width="7%"/>
        				<col width="5%"/>
        				<col width="7%"/>
        				<col width="7%"/>
        				<col width="5%"/>
        				<col width="?"/>
        				<col width="5%"/>
        				<col width="5%"/>
        				<col width="5%"/>
        				<col width="10%"/>
        				<col width="5%"/>
        			</colgroup>
        			<tr>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.OrderNo" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.Seq" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ManufactureNo" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.BarCode" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ItemCode" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ItemName" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.Capacity" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ScaleCapacity" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.SelectTank" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ipDate" /></th>
        				<th align="center" class="fixHeader"><spring:message code="title.manufatcItem.ipSeq" /></th>
        			</tr>
        			<c:forEach var="resultScale" items="${resultScaleList}" varStatus="status">
            			<tr>
            				<td align="center" class="listtd"><c:out value="${resultScale.orderno}"/></td>
            				<td align="center" class="listtd"><c:out value="${resultScale.inputSeq}"/></td>
            				<td align="center" class="listtd"><c:out value="${resultScale.manufactureno}"/></td>
            				<td align="center" class="listtd"><c:out value="${resultScale.scalebarcode}"/></td>
            				<td align="center" class="listtd"><c:out value="${resultScale.materialcode}"/></td>
            				<td align="left"   class="listtd"><c:out value="${resultScale.materialname}"/></td>
            				<td align="center" class="listtd"><c:out value="${resultScale.capacity}"/></td>
            				<td align="center" class="listtd"><c:out value="${resultScale.scalecapacity}"/></td>
            				<td align="center" class="listtd"><c:out value="${resultScale.selectTank}"/></td>
            				<td align="center" class="listtd"><c:out value="${resultScale.RegistrationDate}"/></td>
            				<td align="center" class="listtd"><c:out value="${resultScale.linenumber}"/></td>
            			</tr>
        			</c:forEach>
        		</table>
        	</div>
        	<!-- /List -->    
        </div>
    </form:form>    
</body>
</html>
