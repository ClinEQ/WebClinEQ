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
    <div id="studySitePrimary">
        <p class="firstLv">Site List</p>
    </div>
    <div class="checkSite">
        <p class="secondLv">Site   <a href="javascript:void(0);" onclick="ToggleSubform('divSearchSponsor', 'formSearchSponsor');">Check if site exist</a>  </p>              
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
        <button type="submit" class="btn btn-default">Add Site</button>
        </div>  
    <div>
    <button type="submit" class="btn btn-success">Next</button>
    </div>
    
    <div class="save-options">
        <button type="button" class="btn btn-primary">Create Study</button>


        <button type="button" class="btn btn btn-info">Save as Default</button>


        <button type="button" class="btn btn btn-danger">Cancel</button>
    </div>
    
    
</div>
    
    
    <!-- footer -->
<jsp:include page="../includes/footer.jsp"/>