<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header_site.jsp"/>



<style>
    
    .col4 {
        overflow-y: auto; 
        overflow-x: auto; 
        min-height: 400px; 
        background-color: #f2f2f2;
    }
    
    .col8 {                
        font-size: inherit;
    }
    
    .container{
        min-height: 400px;
    }
        
    .colTitle {
        text-align: left;       
        font-weight: bold;
        padding: 1px;
    }

    .colContent {
        padding: 1px;      
        text-align: left;    
    }
    
    
    #tableChartHeader {
        width: 100%;       
        background-color: #e6e6e6;
        padding: 3px;
        margin-bottom: 10px;
    }
    
    .btn-success{
        float:right;
        margin-bottom: 30px;
    }
    
    hr {
        display: block;
        margin-top: 0.5em;
        margin-bottom: 0.5em;
        margin-left: auto;
        margin-right: auto;
        border-style: inset;
        border-width: 1px;
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
        <li><a href="#">Study Details</a></li>
        <li class="active">Subject Details</li>
    </ol>
</div>
    
<div class="container">   
    
    <div id="tableChartHeader">
        <table width="100%">
            <tr>
                <td width="20%"></td>
                <td width="35%"><span class="colTitle">Study Name:</span> <c:out value="${siteNameByStudyId}"/></td>                    
                <td width="25%"><span class="colTitle">Gender: </span></td>                   
                <td width="20%"></td>
            </tr>
            <tr>
                <td width="20%"></td>
                <td width="30%"><span class="colTitle">EQ Subject ID: </span><c:out value="${getEqSubjectId}"/> </td>                    
                <td width="30%"><span class="colTitle">Sponsor Study ID: </span></td>                   
                <td width="20%"></td>
            </tr>
            <tr>
                <td width="20%"></td>
                <td width="30%"><span class="colTitle">DOB:</span> </td>                    
                <td width="30%"></td>                   
                <td width="20%"></td>
            </tr>
        </table>
    </div>
     <hr>  
    
                
    <nav class="col-sm-4 col4">
        <form>
            <input class="hidden" type=hidden" id="jsonData" name="jsonData" value="${testCat}" />
            <input class="hidden" type=hidden" id="subjectid" value="${subject.getEqSubjectId()}" />
            <input class="hidden" type=hidden" id="userid" value="${UserId}" />
        </form>
        <div id="tree1"></div>
    </nav>
        
    <div class="col-sm-8 col8" style="margin-top: 15px;"> 
         <div id="test"></div>
        <div id="lblselect">Please select a subcategory.</div>
        <div align="center" id="lblsubcatname" style="display: none;"></div>
        <iframe id="iframe" src="../site/fileUploadHistory?chartSubcategoryID=0&eqSubjectID=${subject.getEqSubjectId()}&inpUserName=${UserId}" width="100%"  style="border:none"></iframe>
        <a class="btn btn-success" href="../site/fileSiteDetails" target="_blank">Upload New Files</a>
    </div>

</div>
<!-- footer -->
<jsp:include page="../includes/footer_site.jsp"/>
