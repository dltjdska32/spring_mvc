<%--
  Created by IntelliJ IDEA.
  User: dltjd
  Date: 2024-08-18
  Time: 오후 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

성공

<ul>
    <!-- jsp 가 지원하는 프로퍼티 접근법. 모델에 담긴 데이터를 가져옴 req.getAttribute()-->
    <li>id =${member.id}</li>
    <li>username = ${member.username}</li>
    <li>age = ${member.age}</li>
</ul>

<a href="/index.html"> 메인</a>
</body>
</html>
