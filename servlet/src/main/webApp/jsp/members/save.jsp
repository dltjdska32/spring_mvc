<%--
  Created by IntelliJ IDEA.
  User: dltjd
  Date: 2024-08-18
  Time: 오후 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();

    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age")); // getParam을해서 가져오는 값은 string값이다.

    Member member = new Member(username, age);
    memberRepository.save(member);
%>



<html>
<head>
    <title>Title</title>
</head>
<body>
성공

<ul>
    <li>id = <%=member.getId()%></li>
    <li>username = <%=member.getUsername()%></li>
    <li>age = <%=member.getAge()%></li>
</ul>
<a href="/index.html"> 메인</a>
</body>
</html>
