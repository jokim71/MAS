<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : egovSampleList.jsp
  * @Description : Sample List 화면
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2009.02.01            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.02.01
  *
  * Copyright (C) 2009 by MOPAS  All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>COSMAX 제조자동화 Test Menu</title>
    <script type="text/javaScript" language="javascript" defer="defer">
        <!--
        /* Sample 호출 function */
        function fn_sample_List() {
           	document.listForm.action = "<c:url value='/egovSampleList.do'/>";
           	document.listForm.submit();
        }
        
        /* 설비 알람 발생 호출 function */
        function fn_factAlarm_List() {
           	document.listForm.action = "<c:url value='/factAlarmList.do?compid=1200&userid=112190051&uuid=5701261a-f878-4d8e-9a66-ac01b125be05'/>";
           	document.listForm.submit();
        }    
        
        /* 투입원료 내역 호출 function */
        function fn_manufactItem_List() {
           	document.listForm.action = "<c:url value='/manufactItemList.do?compid=1200&userid=112190051&uuid=5701261a-f878-4d8e-9a66-ac01b125be05'/>";
           	document.listForm.submit();
        } 
        /* 작업자 리스트 호출 function */
        function fn_worker_List() {
           	document.listForm.action = "<c:url value='/workerList.do?compid=1200&userid=112190051&uuid=5701261a-f878-4d8e-9a66-ac01b125be05'/>";
           	document.listForm.submit();
        }  
        
        
        
        //-->
    </script>
</head>
<body style="text-align:left; margin:10 auto;">
    <form:form id="listForm" name="listForm" method="post">
        <br />##### COSMAX 제조자동화 Test Menu #####<br /><br />
    	<a href="javascript:fn_sample_List()">Sample 호출</a><br /><br />
    	<a href="javascript:fn_factAlarm_List()">설비 알람 발생</a><br /><br />
    	<a href="javascript:fn_manufactItem_List()">투입원료 내역</a><br /><br />
    	<a href="javascript:fn_worker_List()">작업자 관리</a><br /><br />
    </form:form>
 </body>
</html>