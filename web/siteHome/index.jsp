<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header_site.jsp"/>

<style>
    .filter-bar{
        height:40px;
        margin-bottom: 10px;
        margin-top: 30px;
    }
    
    .select-box{
        float:left;
        margin-left: 100px;  
    }
    
    .col2 {                
        font-size: 1.2em;
        border-right-width: 2px;
        border-right-color: #ddd;
        border-right-style: groove;
        min-height: 450px;
          // background-color: #eef7ee;
      }
      
      .col10 {                
        font-size: 1.0em;
        padding-left: 30px;
    }
      
      .studyrow:target {
        background-color: #337ab7 !important;
     }
     
     .form-inline .form-group {
        display: inline-block;
        margin-bottom: 0;
        vertical-align: middle;
      }
      
      #ltlStudies {
        font-size: 1.5em;
         font-weight: bold;    
         margin-bottom: 10px;
         margin-top: 0px;

    }
    
    


</style>
 

<nav id="navbar-main" class="navbar navbar-inverse">
    <div class="container-fluid">
        <jsp:include page="../includes/topNav.jsp"/>
       <%-- <jsp:include page="../includes/leftNav.jsp"/>--%>
    </div>
</nav>



<div class="container">   
    
    <div class="row">
        
        <nav class="col-sm-2 col2">
         <div id="ltlStudies">Studies</div>
          <ul class="nav nav-pills nav-stacked">
            <c:forEach var="study" items="${studyArrayList}">
                <li><a href="#${study.getNctid()}"> ${study.getStudyAname()}</a></li>         
            </c:forEach>
          </ul>
        </nav>
        
        <div class="col-sm-10 col10">   
           
                <h3>Study List</h3>
                <div class="filter-bar">
                    <form class="form-inline">
                        <div class="form-group select-box" >
                            <label>Study Status&nbsp;</label>

                            <select id="sltStudyStatus" name="sltStudyStatus" class="form-control"  >
                                <!-- onchange="changeTable($(this).val(), $('#sltSponsorName').val());"-->
                                <option value="All">ALL</option>
                                <c:forEach var="studyStatus" items="${studyStatusList}">

                                    <option value="${studyStatus}" id="${studyStatus}">${studyStatus}</option>

                                </c:forEach>

                            </select>                                        
                        </div>
                        <div class="form-group select-box">
                            <label>Sponsor Name&nbsp;</label>

                            <select id="sltSponsorName" name="sltSponsorName" class="form-control">

                                <c:forEach var="sponsorName" items="${sponsorNameList}">

                                    <option value="${sponsorName}" id="${sponsorName}">${sponsorName}</option>

                                </c:forEach>

                            </select>                      
                        </div>
                    </form>
                 </div>

               
                    <table class="table table-striped tablesorter">
                        <thead>
                            <tr>
                                <th>EQ Study ID</th>                                
                                <th class="th-sort">Study Name</th>
                                <th class="th-sort">Sponsor Study ID</th>
                                <th class="th-sort">Sponsor Name</th>                                
                                <th class="th-sort">Study Status</th>
                                <th class="th-sort">Alert Status</th>
                                <th></th>
                            </tr>
                        </thead>
                        <c:if test="${studyArrayList == null}">
                            <p>no studies </p>
                        </c:if>
                        <tbody>
                            <c:forEach var="study" items="${studyArrayList}">
                                <tr id="${study.getNctid()}" class="studyrow">
                                    <td>
                                        ${study.getEqStudyId()}
                                    </td>                                  
                                    <td>
                                        ${study.getStudyAname()}
                                    </td>
                                    <td>
                                        ${study.getSponStudyId()}
                                    </td>
                                    <td>
                                        ${study.getEqSponName()}
                                    </td>                                  
                                    <td>
                                        ${study.getStudyStatus()}
                                    </td>
                                    <td></td>
                                    <td><a class="btn btn-info btninfo" href="../study/studySiteDetails?eqStudyID=${study.getEqStudyId()}&inpUserName=${UserId}" target="_blank">Details</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
            
           
        </div>
        
    </div>    
 
</div>
<!-- footer -->
<jsp:include page="../includes/footer_site.jsp"/>
