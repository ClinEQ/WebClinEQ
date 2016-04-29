<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header_site.jsp"/>


<style>
    .panel {
        border: 1px solid #bfbfbf;
    }
    
    .panel .panel-heading {
        background-color: #e6e6e6;
        text-align: center;
        vertical-align: middle;
        padding: 14px;
        margin-bottom: 10px;
    }
    
    .table {
        width: 100%;
    }

    .colTitle {
        text-align: right;
        width: 50%;
        font-weight: bold;
        padding: 1px;        
    }

    .colContent {
        padding: 1px;
        width: 50%;
        text-align: left;
        
    }

    fieldset.fsStyle {
       border: solid 1px #DDD !important;
       padding: 0 10px 10px 10px;
       border-bottom: none;
   }

   legend.fsStyle {
       width: auto !important;
       border: none;
       font-size: 1.0em;
   }

</style>
 

<nav id="navbar-main" class="navbar navbar-inverse">
    <div class="container-fluid">
        <jsp:include page="../includes/topNav.jsp"/>
       <%-- <jsp:include page="../includes/leftNav.jsp"/>--%>
    </div>
</nav>

    <div class="container-fluid">
        <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li class="active">Study Details</li>
        </ol>
    </div>


<div class="container">  
  
    <div class="panel panel-default">
        
        <div class="panel-heading">
            <span class="colTitle">Study Name:</span>
            <span class="colContent" style="margin-right: 30px;">Test Test</span>
            <span class="colTitle" style="margin-left: 30px;">Sponsor Name:</span>
            <span class="colContent"><c:out value="${siteSponsorByStudyId}"/></span>
        </div>
                     
      
        <div class="panel-body">
            
                <fieldset class="fsStyle">
                    <legend class="fsStyle">
                        Subject List
                    </legend>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>EQ Subject ID</th>                                
                                    <th>Sponsor Subject ID</th>                                
                                    <th>Birthday</th>                                
                                    <th>Gender</th>
                                    <th>Status</th>
                                    <th>Notification</th>
                                    <th>Alert Status</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <c:if test="${studySiteSubjectList == null}">
                                <p>no subjects </p>
                            </c:if>
                            <tbody>
                                <c:forEach var="subject" items="${studySiteSubjectList}">
                                    <tr>
                                        <td>
                                            ${subject.getEqSubjectId()}
                                        </td>                                  
                                        <td>
                                            ${subject.getSponSubjectId()}
                                        </td>                                 
                                        <td>
                                            ${subject.getDateBirth()}
                                        </td>                                  
                                        <td>
                                            ${subject.getGender()}
                                        </td>
                                        <td>
                                            ${subject.getSubjectStatus()}
                                        </td>
                                        <td>

                                        </td>
                                        <td></td>
                                        <td><a class="btn btn-info btninfo" href="../site/subjectSiteDetails?eqStudyID=${StudyId}&eqSubjectID=${subject.getEqSubjectId()}&inpUserName=${UserId}" target="_blank">Details</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </fieldset>
        
        </div>
    </div>

</div>
<!-- footer -->
<jsp:include page="../includes/footer_site.jsp"/>
