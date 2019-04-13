<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Vote Page</title>
    </head>
    <body>
        <jsp:useBean id="myVote" scope="session" class="ouhk.comps380f.votepart.Vote" />
        Question: <jsp:getProperty name="myVote" property="questionId" /> <br />
        
        <jsp:setProperty name="myVote" property="username" value="special_0"/>
        
        <c:if test="${myVote.checkVoted() >= 1}">
            You have alread voted!<br />
            <%
                out.print(myVote.FormResult());
            %>
            <br />
            <a href="<c:url value="/"/>">Index</a><br />
            <a href="<c:url value="/edit"/>">Edit</a><br />
        </c:if>
            
        <c:if test="${myVote.checkVoted() == 0}">
            You haven't vote before!
            <%
                out.println(myVote.getUsername());
                out.println(myVote.checkVoted());
                
                out.println(myVote.questionGen());
            %>

        </c:if>
    </body>
</html>