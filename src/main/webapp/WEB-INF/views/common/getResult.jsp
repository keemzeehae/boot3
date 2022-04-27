<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert('${msg}');
	location.href="${path}"
	//서버로 요청하는 방식 5가지
	//1. Web browser 의 주소창에 직접 주소를 입력
	//2. HTML 에 a태그
	//3. HTML에 form 태그
	//4. JS에서 location 객체의 href 속성에 주소를 씀
	//5. ajax 
</script>
