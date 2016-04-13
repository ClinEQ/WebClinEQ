<%-- 
    Document   : newjsp
    Created on : Apr 7, 2016, 2:00:25 AM
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
        <button onclick="goBack()">Go Back</button>

<p>Notice that clicking on the Back button here will not result in any action, because there is no previous URL in the history list.</p>

<script>
function goBack() {
    window.history.back();
}
</script>
    </body>
</html>
