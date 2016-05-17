<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../resources/css/eqhome/newStudySponsor.css" rel="stylesheet" type="text/css"/>

<jsp:include page="../includes/header.jsp"/>
<script>var sponsor = "${sponsor}";</script>

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
            <div>
                <h1 class="firstLv">Setup Sponsor User</h1>              
            </div>
            <div class="checkSpon">
                <a  style="font-size:14px; font-weight: normal;" href="javascript:void(0);" onclick="ToggleSubform('searchUser', 'formSearchUser');">Search User</a>
            </div>
            <div class="searchUser" style="display:none">
            </div>
            <form method="post">
                <div class="table-area">
                    <table id="tblNSSSponsorUserList" class="table table-striped">
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
                        <tbody>
                            <c:forEach var="user" items="${sponsor.getUsersCollection()}">
                               
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
                                    <td>
                                        Detail
                                    </td>
                                    <td>
                                        <a href="removeUserFromOrg?deleteUserID=${user.getEqUserId()}">Remove</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <input type="button" value="Add New User" style="float:right;" data-toggle="modal" data-target="#modalNewUser" class="btn btn-default" >
                </div>
                <div class="save-options">
                    <button type="submit" class="btn btn-info" formaction="newStudySponsor">Back</button>
                    <button type="submit" class="btn btn-success" formaction="newStudySite">Next</button>
                </div>
            </form>
        </div>
    </div>
</div>


<jsp:include page="../includes/footer.jsp"/>

<jsp:include page="../includes/forms/formCreateNewUser.jsp"/>