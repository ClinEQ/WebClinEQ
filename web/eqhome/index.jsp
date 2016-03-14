<%-- 
    Document   : Index
    Created on : Mar 6, 2016, 11:49:55 AM
    Author     : songy04
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<script src="../../../resources/scripts/EQHomeJavascript.js" type="text/javascript"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <section id="EQHome">
            
      
        <h1>Hello World!</h1>
        
        <c:if test="${studyArrayList == null}">
            <p>no studies </p>
        </c:if>
            
        <table>
           <tr>
            <th>EQ Study ID</th>
            <th>NCI ID</th>
            <th>Study Aname</th>
            <th>Sponsor Name</th>
            <th>Sponsor Name</th>
            <th>&nbsp;</th>
         </tr>
          <c:forEach var="study" items="${studyArrayList}">
            <tr>
              <td>
                  ${study.getEqStudyId()}
              </td>
              <td>
                  ${study.getStudyAname()}
              </td>
            <td>
                  ${study.getStudyTitle()}
              </td>
              <td>
                  ${study.getSponStudyId()}
              </td>
            <td>
                  ${study.getStudyEqInitDate()}
              </td>
              <td>
                  ${study.getStudyStatus()}
              </td>
            </tr>
          </c:forEach>
           
        </table>
 

  </section>
     </body>
</html>
