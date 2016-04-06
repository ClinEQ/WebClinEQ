<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../resources/css/eqhome/newStudySite.css" rel="stylesheet" type="text/css"/>

<jsp:include page="../includes/header.jsp"/>

<nav id="navbar-main" class="navbar navbar-inverse">
    <div class="container-fluid">
        <jsp:include page="../includes/topNav.jsp"/>
        <jsp:include page="../includes/leftNavCreateNewPage.jsp"/>
    </div>
</nav>

<div class="container content">
    <div id="studySitePrimary">
        <h1 class="firstLv">Site List</h1>
    </div>
    <div class="checkSite">
        <a href="javascript:void(0);" onclick="ToggleSubform('searchSite', 'formSearchSite');">Check if site exist</a>          
    </div>
    <div class="searchSite subSearchArea" style="display:none">
    </div>

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
            </tbody>
        </table>
        <input type="submit" value="Add New Site" style="float:right;" data-toggle="modal" data-target="#modalNewSite" class="btn btn-default" >
    </div>  


    <div class="save-options">
        <form>
            <button type="submit" class="btn btn-info" formaction="../eqhome/newStudySponsor.jsp">Back</button>
            <button type="submit" class="btn btn-success" >Next</button>
        </form>
    </div>
</div>


<!-- footer -->
<jsp:include page="../includes/footer.jsp"/>
<jsp:include page="../includes/forms/formCreateNewSite.jsp"/>
