<%-- 
    Document   : login
    Created on : May 15, 2016, 11:33:29 AM
    Author     : Calum
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>ClinEQ Index</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
            <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.js"></script>
            <link href="resources/lib/bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
            <script src="resources/lib/jquery-1.11.3.js" type="text/javascript"></script>
            <link href="resources/css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div id="login">
            <form class="form-horizontal" action="user/login" method="post">
                <!--<form class="form-horizontal" action="study/displayStudyList" method="post">-->
                <div class="form-group form-group-lg">
                    <label class="col-sm-4 control-label" type="text" for="inpUserName">User Name</label>
                    <div class="col-sm-8">
                    <input class="form-control" id="inpUserName" name="inpUserName" placeholder="User Name">
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label class="col-sm-4 control-label" for="inpPassword">Password</label>
                    <div class="col-sm-8">
                    <input type="password" class="form-control" id="inpPassword" name="inpPassword" placeholder="Password">
                    </div>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            ${loginResult}
        </div>
    </body>
</html>

