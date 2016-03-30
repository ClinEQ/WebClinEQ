<jsp:include page="../includes/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../resources/css/eqhome/newStudySponsorUserList.css" rel="stylesheet" type="text/css"/>
<script src="../resources/script/eqhome.js" type="text/javascript"></script>

<nav id="navbar-main" class="navbar navbar-inverse">
    <div class="container-fluid">
        <jsp:include page="../includes/topNav.jsp"/>
        <jsp:include page="../includes/leftNavCreateNewPage.jsp"/>
    </div>
</nav>
<div class="container content">
    <div>
        <div>
            <p class="firstLv">User List</p>
        </div>
        <div class="checkSpon checkSpon2">
            <p class="secondLv">Sponsor User List   <a href="javascript:void(0);" onclick="ToggleSubform('divSearchUser', 'formSearchUser');">Check if user exist</a>  </p>              
        </div>

        <div class="divSearchUser" style="display:none">
        </div>

        <div class="table-area">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>EQ User ID</th>
                        <th>User Type</th>
                        <th>Institute</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Detail</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <c:if test="${userArrayList == null}">
                    <p>no user </p>
                </c:if>
                <tbody>
                    <c:forEach var="user" items="${userArrayList}">
                        <tr>
                            <td>
                                ${user.getEqUserId()}
                            </td>
                            <td>
                                ${user.getUserType()}
                            </td>
                            <td>
                                ${user.getEqOrgId().getOrgFullName()}
                            </td>
                            <td>
                                ${user.getFname()}
                            </td>
                            <td>
                                ${user.getLname()}
                            </td>
                            <td><a href="#">Details</a></td>
                            <td><a href="#">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">Add New User</button>
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

<jsp:include page="../includes/forms/formCreateNewUser.jsp"/>