<%-- 
    Document   : createQuestionToDB
    Created on : 2019/4/12, 下午 05:19:14
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
        <jsp:useBean id="myQuestion" scope="session" class="ouhk.comps380f.votepart.Question" />
        <jsp:setProperty name="myQuestion" property="question"  />
        <jsp:setProperty name="myQuestion" property="ansA"  />
        <jsp:setProperty name="myQuestion" property="ansB"  />
        <jsp:setProperty name="myQuestion" property="ansC"  />
        <jsp:setProperty name="myQuestion" property="ansD"  />
        
        <%
            int a = myQuestion.questionToDB();
            if(a == 1){
                out.print("Question has been created");
            }else
                out.print("Question cannot create");
            
        %>
    </body>
</html>
