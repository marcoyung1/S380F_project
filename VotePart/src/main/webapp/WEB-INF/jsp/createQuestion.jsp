<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Question></title>
    </head>
    <body>
        <h1>Create Question</h1>
        <form action="create" method="POST">
            <input type="hidden" name="questionId">
            Your Question : 
                <input type="text" name="question" value=""/><br/>
            A:    <input type="text" name="ansA" value=""/>  <br/>
            B:    <input type="text" name="ansB" value=""/>  <br/>
            C:    <input type="text" name="ansC" value=""/>  <br/>
            D:    <input type="text" name="ansD" value=""/>  <br/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
