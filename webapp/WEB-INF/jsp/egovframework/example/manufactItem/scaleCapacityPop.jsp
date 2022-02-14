<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<%
/**
 * 
 * @class  scaleCapacityPop
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
    <title>원료투입량 확인</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/mas.css'/>"/>
    
    <script type="text/javaScript" language="javascript" defer="defer">
	    $(document).ready(function(){
			$("#sIpDate").datepicker();
			$("#eIpDate").datepicker();
		});     
        <!--
        /*  화면 닫기 function */
        function fn_egov_closeWin() {
           	window.close();
        }
        
        function fn_egov_sacleCapacity() {
        	document.detailForm.action = "<c:url value='/selectScaleCapacity.do'/>";
           	document.detailForm.submit();
        }        
        -->
    </script>
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">

<form:form commandName="searchVO" id="detailForm" name="detailForm">
    <div id="content_pop" style="width: 380px;">
    	<!-- 타이틀 -->
    	<div id="title" style="width:380px;">
    		<ul>
    			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt=""/>&nbsp;원료 투입량</li>
    		</ul>
    	</div>
    	<!-- // 타이틀 -->
    	<div id="" style="width: 380px;">
    		<div style="display: inline-flex;">
	    		<div style="margin-top: 10px;">
	    			<label for="searchKeyword" style="visibility:show;"><spring:message code="search.sDate" /></label>
					<form:input path="sIpDate" cssStyle="width: 100px; margin-left: 20px;" cssClass="datePicker"/>&nbsp;~&nbsp;
					<form:input path="eIpDate" cssStyle="width: 100px;" cssClass="datePicker"/>
				</div>
				<div style="margin-top: 15px; margin-left: 45px;">          
					<span class="btn_blue_l">
	       	        	<a href="javascript:fn_egov_sacleCapacity();"><spring:message code="button.search" /></a>
	       	            <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt="조회"/>
	       	        </span>
       	        </div>
       	    </div>
    		<div style="margin-top: 15px;">
    			<label for="searchKeyword" style="visibility:show;">투입량</label>
       			<c:set var="sumCapacity" value="${empty resultValue ? 0 : resultValue}"/>
    			<input type="text" style="text-align:right; width: 100px; margin-left: 8px;" value="<c:out value='${sumCapacity}'/>"/>
            </div>  
    	</div>
    </div>
	<div id="search" style="width: 380px; margin-top: 20px; text-align: center;">
		<div style="display: inline-block;">
		    <span class="btn_blue_l">
		        <a href="javascript:fn_egov_closeWin();">닫기</a>
		        <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
		    </span>	
		</div>
	</div>
</form:form>
</body>
</html>