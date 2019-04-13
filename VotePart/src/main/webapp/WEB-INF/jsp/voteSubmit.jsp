<%-- 
    Document   : voteResult
    Created on : 2019/4/11, 下午 11:21:17
    Author     : yungtszhin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your Submittion</h1>
        <jsp:useBean id="myVote" scope="session" class="ouhk.comps380f.votepart.Vote" />
        <jsp:setProperty name="myVote" property="username"  />
        <jsp:setProperty name="myVote" property="questionId" />
        <jsp:setProperty name="myVote" property="userAnswer"  />
        
        
        You are:
        <jsp:getProperty name="myVote" property="username"  /><br />
        This is question:
        <jsp:getProperty name="myVote" property="questionId"  /><br />
        Your Choice:
        <jsp:getProperty name="myVote" property="userAnswer"  /><br />
        
        <%
            int a = myVote.voteToDB();
            if(a == 1){
                out.print("Vote has been stored");
            }else
                out.print("Vote is not finished");
            
        %>
    </body>
</html>
