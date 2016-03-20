<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>ClinEQ Index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.js"></script>
    <script>
        window.jQuery || document.write("<script src='Lib/jquery-1.11.3.js'><\/script>");
    </script>
    <link href="resources/lib/bootstrap-3.3.6-dist/css/bootstrap-theme.css" rel="stylesheet" />
    <link href="resources/lib/bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet" />
    <script src="resources/lib/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
    <link href="resources/css/MainStyle.css" rel="stylesheet" />
</head>
    <body>
        <div id="login">

                <form class="form-horizontal" action="login/loginCheck" method="post">
                    <form class="form-horizontal" action="study/displayStudyList" method="post">
                <div class="form-group form-group-lg">
                    <label class="col-sm-4 control-label" type="text" for="inpUserName">User Name</label>
                    <div class="col-sm-8">
                    <input class="form-control" id="inpUserName" name="userId" placeholder="User Name">
                    </div>
                </div>
                <div class="form-group form-group-lg">
                    <label class="col-sm-4 control-label" for="inpPassword">Password</label>
                    <div class="col-sm-8">
                    <input type="password" class="form-control" id="inpPassword" name="password" placeholder="Password">
                    </div>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
        </div>
    </body>
</html>
