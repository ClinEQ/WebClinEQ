<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header_site.jsp"/>


<style>
    .panel {
        border: 1px solid #bfbfbf;	
        
    }
    
    #info {
        text-align: left;
       position: relative;
    }
    
    .panel .panel-heading {
        background-color: #e6e6e6;
        text-align: center;
        padding: 4px;
    }
    
    .table {
        width: 100%;
    }
    
    label.lblInfo {
        
        font-style: italic;
    }


    #tableStudyDetails {
        width: 100%;
        margin-bottom: 40px;

    }

    .colTitle {
        text-align: right;
        width: 50%;
        font-weight: bold;
        padding: 4px;
    }

    .colContent {
        padding: 4px;
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

/*
.table-condensed>tbody>tr>td 
{
    padding: 10px;
}
*/

</style>
 

<nav id="navbar-main" class="navbar navbar-inverse">
    <div class="container-fluid">
        <jsp:include page="../includes/topNav.jsp"/>
       <%-- <jsp:include page="../includes/leftNav.jsp"/>--%>
    </div>
</nav>



<div class="container">   
                
   <table style="width: 100%;">
        <tr>
            <td style="text-align: left; width:50%; padding-left: 10px;">
                <label class="lblInfo">Site Name:</label> <c:out value="${siteNameByStudyId}"/> 
            </td>
        </tr>
        
    </table>
       
        
  
    <div class="panel panel-default">
        
        <div class="panel-heading">
            <h3>Study Details</h3> 
        </div>
      
        <div class="panel-body">
            <table id="tableStudyDetails">
                <tr>
                    <td class="colTitle">NCTID:</td>
                    <td class="colContent"></td>
                </tr>
                <tr>
                    <td class="colTitle">Study Name:</td>
                    <td class="colContent"><c:out value="${siteNameByStudyId}"/></td>
                </tr>
                <tr>
                    <td class="colTitle">Sponsor Name:</td>
                    <td class="colContent"><c:out value="${siteSponsorByStudyId}"/></td>
                </tr>
            </table>
                
                <fieldset class="fsStyle">
                    <legend class="fsStyle">
                        Subject List
                    </legend>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>EQ Subject ID</th>                                
                                <th>Sponsor Subject ID</th>
                                <th>Subject Full Name</th>
                                <th>Birthday</th>                                
                                <th>Gender</th>
                                <th>Status</th>
                                <th>Alert Status</th>
                                <th></th>
                            </tr>
                        </thead>
                        <c:if test="${studySiteSubjectList == null}">
                            <p>no subjects </p>
                        </c:if>
                        <tbody>
                            <c:forEach var="study" items="${studySiteSubjectList}">
                                <tr>
                                    <td>
                                        
                                    </td>                                  
                                    <td>
                                       
                                    </td>
                                    <td>
                                      
                                    </td>
                                    <td>
                                       
                                    </td>                                  
                                    <td>
                                      
                                    </td>
                                    <td>
                                        
                                    </td>
                                    <td></td>
                                    <td><a class="btn btn-info btninfo" href="../study/studySubjectDetails?eqStudyID=${study.getEqStudyId()}&inpUserName=${UserId}" target="_blank">Details</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </fieldset>
        
        </div>
    </div>

</div>
<!-- footer -->
<jsp:include page="../includes/footer_site.jsp"/>
