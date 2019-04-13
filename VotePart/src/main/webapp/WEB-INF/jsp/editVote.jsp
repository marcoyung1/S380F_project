<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello User Application</title>
    </head>
    <body>
        <jsp:useBean id="myVote" scope="session" class="ouhk.comps380f.votepart.Vote" />
        <jsp:setProperty name="myVote" property="username" value="special_0"/>

            <%
                out.println(myVote.FormResult());
            %>
        <form action="edit" method="POST">
            <% out.println(myVote.questionGen()); %>
        </form>
    </body>
</html>