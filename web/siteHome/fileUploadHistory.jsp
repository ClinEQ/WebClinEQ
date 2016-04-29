<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name=”viewport” content=”width=device-width, initial-scale=1”>
        <link href="../resources/lib/bootstrap-3.3.6-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>        
        <link href="../resources/lib/bootstrap-datepicker-1.5.1-dist/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>        
        <link href="../resources/lib/fonts/font-awesome-4.5.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../resources/css/main_site.css" rel="stylesheet" type="text/css"/>
        
        
        
        <link class="cssdeck" rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css" class="cssdeck">
        

    </head>
    <body> 
        <div class="table-responsive">
           <table class="table table-striped">
               <thead>
                    <tr>
                        <th>Upload Type</th>                                
                        <th>File Name</th>
                        <th>Upload Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <c:if test="${siteSubjectChart == null}">
                    <p>no studies </p>
                </c:if>
                <tbody>
                    <c:forEach var="chart" items="${siteSubjectChart}">
                        <tr id="" class="studyrow">
                            <td>
                                ${chart.getUploadType()}
                            </td>                                  
                            <td>
                                ${chart.getDocName()}
                            </td>
                            <td>
                                ${chart.getUploadTimestamp()}
                            </td>
                            <td>
                                ${chart.getReviewStatus()}
                            </td>    
                        </tr>
                    </c:forEach>
                </tbody>
           </table>
        
    </div>


    <script src="../resources/lib/jquery-1.11.3.js" type="text/javascript"></script>
    <script src="../resources/lib/bootstrap-3.3.6-dist/js/bootstrap.js" type="text/javascript"></script>
    <script src="../resources/lib/bootstrap-datepicker-1.5.1-dist/js/bootstrap-datepicker.js" type="text/javascript"></script>
    <script src="../resources/script/eqhome.js" type="text/javascript"></script> 
    <script src="../resources/script/sitehome.js" type="text/javascript"></script>
</body>
</html>