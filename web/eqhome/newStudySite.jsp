<jsp:include page="../includes/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../resources/css/eqhome/newStudySite.css" rel="stylesheet" type="text/css"/>


<nav id="navbar-main" class="navbar navbar-inverse">
    <div class="container-fluid">
        <jsp:include page="../includes/topNav.jsp"/>
        <jsp:include page="../includes/leftNavCreateNewPage.jsp"/>
    </div>
</nav>

<div class="container content">
    <div>
        <p class="firstLv">Site List</p>
    </div>
    <form class="form-inline">
        <div class="checkSite">
            <p class="secondLv">Site   <a href="javascript:void(0);" onclick="ToggleSubform('divSearchSite', 'formSearchSite');">Check if site exist</a></p>              
        </div>
         <div class="divSearchSite subSearchArea" style="display:none">
        </div>
    </form>
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
            <c:if test="${studyArrayList == null}">
                <p>no studies </p>
            </c:if>
            <tbody>
                <c:forEach var="study" items="${studyArrayList}">
                    <tr>
                        <td>
                            ${study.getEqStudyId()}
                        </td>
                        <td>
                            ${study.getNctid()}
                        </td>
                        <td>
                            ${study.getStudyAname()}
                        </td>
                        <td>
                            ${study.getEqSponName()}
                        </td>
                        <td>
                            ${study.getStudyEqInitDate()}
                        </td>
                        <td><a href="#">Detail</a></td>
                        <td><a href="#">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">Add New Site</button>
    </div>  
    <div>
        <a type="submit" class="btn btn-success" href="newStudySubject.jsp">Next</a>
    </div>

    <div class="save-options">
        <button type="button" class="btn btn-primary">Create Study</button>


        <button type="button" class="btn btn btn-info">Save as Default</button>


        <button type="button" class="btn btn btn-danger">Cancel</button>
    </div>


</div>


<!-- footer -->
<jsp:include page="../includes/footer.jsp"/>

<jsp:include page="../includes/forms/formCreateNewSite.jsp"/>