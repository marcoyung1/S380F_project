<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="myVote" scope="session" class="ouhk.comps380f.votepart.Vote" />
        <a href="<c:url value="/create"/>">Create Question</a><br />

        <jsp:setProperty name="myVote" property="questionId" value="2" />
        <a href="<c:url value="/vote"/>">  Question '2' </a><br />        


        <a href="<c:url value="/result"/>">Vote Result</a><br />
    </body>
</html>
