<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
    <head>
        <title>ClinEQ Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="../resources/lib/bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="../resources/lib/jquery-1.11.3.js" type="text/javascript"></script>
        <link href="../resources/css/login.css" rel="stylesheet" type="text/css"/>
    </head> 
    <body>
        <div>
            <form id="login" action="study/displayStudyList" method="post">
                <div class="form-group">
                    <label for="inpUserName">User Name</label>
                    <input class="form-control" id="inpUserName" placeholder="User Name">
                </div>
                <div class="form-group">
                    <label for="inpPassword">Password</label>
                    <input type="password" class="form-control" id="inpPassword" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </body>
</html>