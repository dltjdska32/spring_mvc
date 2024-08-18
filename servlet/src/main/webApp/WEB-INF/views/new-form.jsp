<%--
  Created by IntelliJ IDEA.
  User: dltjd
  Date: 2024-08-18
  Time: 오후 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <!-- WEB-INF 아래에 파일들은 무조건 컨트롤러를 거쳐서 불려짐.
        외부에서 url을 직접 입력해도 해당 페이지로 바로 가지않는다. -->
    <!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
    <!-- 절대 경로 - ~/save 이런형식 -->
    <form action="save" method="post">
        username: <input type="text" name="username" />
        age:      <input type="text" name="age" />
        <button type="submit">전송</button>
    </form>
</body>
</html>
