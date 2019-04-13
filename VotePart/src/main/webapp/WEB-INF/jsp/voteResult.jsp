<%-- 
    Document   : voteResult
    Created on : 2019/4/13, 下午 12:39:35
    Author     : yungtszhin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vote</title>
    </head>
    <body>
        <jsp:useBean id="myVote" scope="session" class="ouhk.comps380f.votepart.Vote" />
        <h1>Vote Result</h1>
        <c:forEach items="${myVote.voteResult()}" var="result">
            <br />${result}<br />
        </c:forEach>

    </body>

</html>
