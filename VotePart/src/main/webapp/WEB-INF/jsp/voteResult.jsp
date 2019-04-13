<%-- 
    Document   : voteResult
    Created on : 2019/4/13, 下午 12:39:35
    Author     : yungtszhin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vote</title>
    </head>
    <body>
        <jsp:useBean id="voteCount" scope="session" class="ouhk.comps380f.votepart.Vote" />
        <h1>Vote Result</h1>
        <% out.print(voteCount.voteResult()); %>
                
    </body>
    
</html>
