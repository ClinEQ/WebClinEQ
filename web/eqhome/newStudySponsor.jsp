<jsp:include page="../includes/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../resources/css/eqhome/newStudySponsor.css" rel="stylesheet" type="text/css"/>
<link href="../resources/css/forms/formSearchSponsor.css" rel="stylesheet" type="text/css"/>

<script src="../resources/lib/bootstrap-datepicker-1.5.1-dist/js/bootstrap-datepicker.js" type="text/javascript"></script>
<link href="../resources/lib/bootstrap-datepicker-1.5.1-dist/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
<link href="../resources/lib/bootstrap-datepicker-1.5.1-dist/css/bootstrap-datepicker.standalone.css" rel="stylesheet" type="text/css"/>
<script src="../resources/script/eqhome.js" type="text/javascript"></script>

<nav id="navbar-main" class="navbar navbar-inverse">
    <div class="container-fluid">
        <jsp:include page="../includes/topNav.jsp"/>
        <jsp:include page="../includes/leftNavCreateNewPage.jsp"/>
    </div>
</nav>

<div class="container content">
    <div id="studySponPrimary">
        <p class="firstLv">Sponsor</p>
        <div class="checkSpon">
            <p class="secondLv">Primary Sponsor   <a href="javascript:void(0);" onclick="ToggleSubform('divSearchSponsor', 'formSearchSponsor');">Check if sponsor exist</a>  </p>              
        </div>

        <div class="divSearchSponsor subSearchArea" style="display:none">
        </div>

        <form class="form-horizontal" method="post">
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSSEqSponId">EQ Sponsor ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSSEqSponId" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSSSponName">Sponsor Name</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSSSponName" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSSSponAB">Sponsor Name ABBR</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSSSponAB" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSSSponType">Sponsor Type</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSSSponType" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSSSponCate">Sponsor Category</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSSSponCate" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSSAddress1">Address1</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSSAddress1" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSSAddress2">Address2</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSSAddress2" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-1 control-label" for="inpeqhomeNSSCity">City</label>
                <div class="col-sm-3">
                    <input class="form-control" id="inpeqhomeNSSCity" >
                </div>
                <label class="col-sm-1 control-label" for="inpeqhomeNSSState">State</label>
                <div class="col-sm-2">
                    <input class="form-control" id="inpeqhomeNSSState" >
                </div>
                <label class="col-sm-2 control-label" for="inpeqhomeNSSZip">Zip Code</label>
                <div class="col-sm-3">
                    <input class="form-control" id="inpeqhomeNSSZip" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSSCountry">Country</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSSCountry" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-2 control-label" for="inpeqhomeNSSPhone">Phone</label>
                <div class="col-sm-4">
                    <input class="form-control" id="inpeqhomeNSSPhone" >
                </div>
                <label class="col-sm-1 control-label" for="inpeqhomeNSSFax">Fax</label>
                <div class="col-sm-5">
                    <input class="form-control" id="inpeqhomeNSSFax" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSSSponUrl">Sponsor URL</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSSSponUrl" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" for="inpeqhomeNSSConName">Contact Name</label>
                <div class="col-sm-3">
                    <input class="form-control" id="inpeqhomeNSSConName" >
                </div>
                <label class="col-sm-1 control-label" for="inpeqhomeNSSEmail">Email</label>
                <div class="col-sm-5">
                    <input class="form-control" id="inpeqhomeNSSEmail" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSSStudyStatus">Study Status</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSSStudyStatus" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="txteqhomeNSSNote">Notes</label>
                <div class="col-sm-12">
                    <textarea class="form-group" rows="4" id="txteqhomeNSSNote"></textarea>
                </div>
            </div>
        </form>
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
        <a class="btn btn-default" href="javascript:void(0);" onclick="ToggleSubform('divCreateNewUser', 'formCreatNewUser');" role="button">Add New User</a>
        <div class="divCreateNewUser" style="display:none">
        </div>
    </div>

    <div class="form-horizontal">
        <button type="submit" formaction="../eqhome/newStudySponsor.jsp" class="btn btn-success">Next</button>
    </div>

    <div class="save-options">
        <button type="button" class="btn btn-primary">Create Study</button>


        <button type="button" class="btn btn btn-info">Save as Default</button>


        <button type="button" class="btn btn btn-danger">Cancel</button>
    </div>



    <!-- footer -->
    <jsp:include page="../includes/footer.jsp"/>

 