<%-- 
    Document   : subjectDetails
    Created on : Apr 22, 2016, 10:36:55 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is subjectDetails page!</h1>
        <a class="btn btn-info btninfo" href="../site/pdfRetrive?inpeqsubjectchartid=10" target="_blank">Retrieve PDF file</a>
        
        <form class="form-horizontal" action="site/fileSiteDetails" enctype="multipart/form-data" method="post">
            <p>  <input type="file" name="inpFile" size="40" ></p>
            <div> <input type="submit" value="Submit"></div>
        </form>
            
               
    </body>
</html>