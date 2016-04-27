<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header_site.jsp"/>


<style>
    .panel {
        border: 1px solid #bfbfbf;
    }
    
    .panel .panel-heading {
        background-color: #e6e6e6;
        vertical-align: middle;
        padding: 5px;
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
   
    #categories{
       background-color: #f7ecb5;
    }
    
     .filter-bar{
        text-align: center;
    }
    
    #formupload,
    .btn-success{
        float:right;
        margin-top: 10px;
        margin-bottom: 30px;
    }
    
     .btn-default {
      box-shadow: 1px 2px 5px #000000;   
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
            <li>Study Details</li>
            <li>Subject Details</li>
            <li class="active">Chart Upload</li>
        </ol>
    </div>


<div class="container">  
  
    <div class="panel panel-default">
        
        <div class="panel-heading">
            <table width="100%">
                <tr>
                    <td width="20%"></td>
                    <td width="35%"><span class="colTitle">NCTID:</span> <c:out value="${siteNameByStudyId}"/></td>                    
                    <td width="25%"><span class="colTitle">Sponsor Subject ID: </span></td>                   
                    <td width="20%"></td>
                </tr>
                <tr>
                    <td width="20%"></td>
                    <td width="30%"><span class="colTitle">Study ID: </span><c:out value="${getEqSubjectId}"/> </td>                    
                    <td width="30%"></td>                   
                    <td width="20%"></td>
                </tr>
            </table>
        </div>
                     
      
        <div class="panel-body">
            <h4 style="text-align: center; margin-bottom: 30px;">Subject Chart Upload</h4>
            
                  <div class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="sltSubjectCategory">Chart Category</label>
                            <div class="col-sm-10">
                               <select id="sltSubjectCategory" name="sltSubjectCategory" class="form-control"  >
                                  <c:forEach var="subjectCategory" items="${siteSubjectCategory}">

                                      <option value="${getChartCategoryId}" id="${getChartCategoryId}">${getChartCategoryName}</option>

                                  </c:forEach>

                              </select>     
                            </div>
                        </div>
                       <div class="form-group">
                            <label class="col-sm-2 control-label" for="sltSubjectSubCategory">Chart SubCategory</label>
                            <div class="col-sm-10">
                               <select id="sltSubjectSubCategory" name="sltSubjectSubCategory" class="form-control"  disabled>
                                  <c:forEach var="subjectSubCategory" items="${siteSubjectSubcategory}">

                                      <option value="${getChartSubcategoryId}" id="${getChartSubcategoryId}">${getChartSubcategoryName}</option>

                                  </c:forEach>

                              </select>     
                            </div>
                        </div>
                       <div class="form-group">
                            <label class="col-sm-2 control-label" for="sltUploadType">Upload Type</label>
                            <div class="col-sm-10">
                               <select id="sltUploadType" name="sltUploadType" class="form-control">
                                  <c:forEach var="subjectSubCategory" items="${siteSubjectSubcategory}">

                                      <option value="${getChartSubcategoryId}" id="${getChartSubcategoryId}">${getChartSubcategoryName}</option>

                                  </c:forEach>

                              </select>     
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="message" class="col-sm-2 control-label">Upload File</label>
                            <div class="col-sm-10">
                                <fieldset class="fsStyle">
                                    <div class="table-responsive">
                                    <table class="table table-striped" style="border: 1px solid #e6e6e6;">
                                        <thead>
                                            <tr>                            
                                                <th>File Name</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="file" items="">
                                                <tr>
                                                    <td>

                                                    </td>  
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                </fieldset>
 
                            </div>
                            
                          </div>
                     
                       <div class="form-group">
                          <label class="col-sm-2 control-label"></label>
                          <div class="col-sm-10">
                              <button id="addfile" type="submit" class="btn btn-success" >Add File</button>
                              <form id="formupload" class="form-inline" action="site/fileSiteDetails" enctype="multipart/form-data" method="post" style="display:none">
                                <input type="file" name="inpFile" size="40" class="file">
                                <input type="submit" value="Submit">
                              </form>
                          </div>
                       </div>
                      
                        <div class="form-group">
                          <label for="message" class="col-sm-2 control-label">Message with This Upload</label>
                          <div class="col-sm-10">
                            <textarea class="form-control" rows="5" id="message"></textarea>
                          </div>                          
                        </div>
                      
                        <div class="form-group">
                          <label for="certificate" class="col-sm-2 control-label"></label>
                          <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label><input type="checkbox" id="certificate" value="1">Certificate</label>
                            </div>
                          </div>
                        </div>
                      <div class="form-group">        
                        <div class="col-sm-offset-2 col-sm-10">
                          <button type="submit" class="btn btn-default">Submit Upload</button>
                          <button type="submit" class="btn btn-default" style="margin-left: 100px;">Cancel</button>
                        </div>
                      </div>
                   </div>
        
        </div>
    </div>

</div>
<!-- footer -->
<jsp:include page="../includes/footer_site.jsp"/>
