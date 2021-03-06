<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>ClinEQ Index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.js"></script>
    <script>
        window.jQuery || document.write("<script src='Lib/jquery-1.11.3.js'><\/script>");
    </script>
    
    <script src="resources/Lib/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
    <link href="<c:url value='resources/Lib/bootstrap-3.3.6-dist/css/bootstrap-theme.css'/>" rel="stylesheet" />
    <link href="<c:url value='resources/Lib/bootstrap-3.3.6-dist/css/bootstrap.css'/>" rel="stylesheet" />
    <link href="<c:url value='resources/Css/MainStyle.css'/>" rel="stylesheet" />
        


</head>
<body>
    <div>
        <!-- header -->
        <div class="row container-fluid">
            <div id="header" class="col-lg-12">
                <div>
                    <h1>ClinEQ System</h1>
                    <!--<img id="imgLogo" src="img/imgLogo.png" />-->
                </div>
                <!-- navigation -->
                <div id="nav" class="row">
                    <div id="navUserName" class="col-lg-8">
                        <p>User Name:</p>
                        
                    </div>
                    <div class="col-lg-4">
                        <ul id="navTop" class="nav nav-pills">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">Logout</a></li>
                            <li><a href="#">Help</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- leftNav + content -->
        <div class="row container-fluid">
            <!--left Nav-->
            <div id="nav-left" class="col-lg-3">
                <ul>
                    <!-- Study -->
                    <li>
                        <label class="tree-toggle">Study</label>
                        <ul class="nav tree">
                            <li><a href="#">New Study</a></li>
                            <li><a href="#">Search</a></li>
                        </ul>
                    </li>
                    <!-- Divider -->
                    <li class="divider"></li>
                    <!-- Site -->
                    <li>
                        <label class="tree-toggle">Site</label>
                        <ul class="nav tree">
                            <li><a href="#">New Site</a></li>
                            <li><a href="#">Search</a></li>
                        </ul>
                    </li>
                    <!-- Divider -->
                    <li class="divider"></li>
                    <!-- EQ Admin -->
                    <li>
                        <label class="tree-toggle">EQ Admin</label>
                        <ul class="nav tree">
                            <li><a href="#">Code Configuration</a></li>
                        </ul>
                    </li>
                </ul>
            </div>

            <!--content-->
            <div id="content" class="col-lg-9">
                <label>Table</label>
            </div>
        </div>
    </div>


    <script type="text/javascript">
        $(document).ready(function () {
            $('.tree-toggle').click(function () {
                $(this).parent().children('ul.tree').toggle(200);
            });
        });
    </script>



</body>
</html>
