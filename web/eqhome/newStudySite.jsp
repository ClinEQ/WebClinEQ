<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../resources/css/eqhome/newStudySite.css" rel="stylesheet" type="text/css"/>

<jsp:include page="../includes/header.jsp"/>

<div class="container-fluid">
    <div class="row">
        <div>
            <nav id="navbar-main" class="navbar navbar-inverse">
                <div class="container-fluid">
                    <jsp:include page="../includes/topNav.jsp"/>
                </div>
            </nav>
        </div>
    </div>

    <div class="row  content">
        <div class="col-lg-2 col-md-2 col-sm-2">
            <jsp:include page="../includes/leftNavCreateNewPage.jsp"/>
        </div>
        <div class="col-lg-10 col-md-10 col-sm-10">
            <div id="studySitePrimary">
                <h1 class="firstLv">Site List</h1>
            </div>
            <div class="checkSite">
                <a href="javascript:void(0);" onclick="ToggleSubform('searchSite', 'formSearchSite');">Check if site exist</a>          
            </div>
            <div class="searchSite subSearchArea" style="display:none">
            </div>
            <form action="inputSiteToStudy" method="post">
                <div class="table-area">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>EQ Site ID</th>
                                <th>Site Name</th>
                                <th>Site Desc</th>
                                <th>Site Type</th>
                                <th>Status</th>
                                <th>Detail</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="site" items="${newSiteArrayList}">
                               
                                <tr>
                                    <td>
                                        ${site.getEqOrgId()} 
                                    </td>
                                    <td>
                                        ${site.getOrgFullName()} 
                                    </td>
                                    <td>
                                        ${site}
                                    </td>
                                    <td>
                                        ${site.getOrgType()}
                                    </td>
                                    <td>
                                        ${site.getStatus()}
                                    </td>
                                    <td>
                                        Detail
                                    </td>
                                    <td>
                                        <a href="removeSiteFromStudy?deleteSiteID=${site.getEqOrgId()}">Remove</a>
                                    </td>
                                </tr>
                            </c:forEach>                            
                        </tbody>
                    </table>
                    <input type="button" value="Add New Site" style="float:right;" data-toggle="modal" data-target="#modalNewSite" class="btn btn-default" >

                </div>  
                <div class="save-options">
                    <!--<button type="submit" class="btn btn-info" onclick="goBack()" >Back</button>-->
                    <button type="submit" class="btn btn-info" formaction="newStudySponsorUserList">Back</button>
                    <button type="submit" class="btn btn-success" formaction="newStudySiteUserList">Next</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- footer -->
<jsp:include page="../includes/footer.jsp"/>
<jsp:include page="../includes/forms/formCreateNewSponsor.jsp"/>
