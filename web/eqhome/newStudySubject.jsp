<jsp:include page="../includes/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../resources/css/eqhome/newStudySubject.css" rel="stylesheet" type="text/css"/>

<nav id="navbar-main" class="navbar navbar-inverse">
    <div class="container-fluid">
        <jsp:include page="../includes/topNav.jsp"/>
        <jsp:include page="../includes/leftNavCreateNewPage.jsp"/>
    </div>
</nav>

<div class="container content">
    <div>
        <div>
            <p class="firstLv">Subject List</p>
        </div>
        <form class="form-inline">
            <div class="form-group select-box" >
                <label>Site Name</label>

                <select id="sltSiteName" name="sltSiteName" class="form-control">
                    <option value="ALL" id="ALL">ALL</option>
                    <option value="AA" id="AA">AA</option>
                    <option value="BB" id="AA">BB</option>
                </select>                                       
            </div>
        </form>
        <div class="table-area">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>EQ Subject ID</th>
                        <th>Site Name</th>
                        <th>Study Name</th>
                        <th>Date of Birth</th>
                        <th>Gender</th>
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
            <button type="submit" class="btn btn-default">Add Subject</button>
        </div>  
        <div>
            <button type="submit" class="btn btn-success">Next</button>
        </div>
    </div>
    <div class="save-options">
        <button type="button" class="btn btn-primary">Create Study</button>


        <button type="button" class="btn btn btn-info">Save as Default</button>


        <button type="button" class="btn btn btn-danger">Cancel</button>
    </div>


</div>


<!-- footer -->
<jsp:include page="../includes/footer.jsp"/>
