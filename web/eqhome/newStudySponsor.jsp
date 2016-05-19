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
            <div id="studySponPrimary">
                <h1 class="firstLv">Sponsor</h1>

                <div class="checkSpon">
                    <a href="javascript:void(0);" onclick="ToggleSubform('divSearchSponsor', 'formSearchSponsor');">Check if sponsor exist</a>           
                </div>

                <div class="divSearchSponsor subSearchArea" style="display:none">
                </div>
                <p style="margin-left: 28%">Enter New Sponsor Information</p>
                <form class="form-horizontal" method="post">
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSSEqSponId">EQ Sponsor ID</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSSEqSponId" name="EqSponId" value="${sponsor.getEqOrgId()}" readonly>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSSSponName">Sponsor Name</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSSSponName" name="SponName" value="${sponsor.getOrgFullName()}" ${sponsorPicked == true?'readonly':''}>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSSSponAB">Sponsor Name ABBR</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSSSponAB" name="SponAB" value="${sponsor.getOrgNameAbbr()}" ${sponsorPicked == true?'readonly':''}>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSSSponType">Sponsor Type</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSSSponType" name="SponType" value="${sponsor.getOrgType()}"  ${sponsorPicked == true?'readonly':''}>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSSSponCate">Sponsor Category</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSSSponCate" name="SponCate" value="${sponsor.getOrgCategory()}"  ${sponsorPicked == true?'readonly':''}>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSSAddress1">Address1</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSSAddress1" name="Address1" value="${sponsor.getAddress1()}"  ${sponsorPicked == true?'readonly':''}>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSSAddress2">Address2</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSSAddress2" name="Address2" value="${sponsor.getAddress2()}"  ${sponsorPicked == true?'readonly':''}>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-1 control-label" for="inpEqhomeNSSCity">City</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="inpEqhomeNSSCity" name="City" value="${sponsor.getCity()}"  ${sponsorPicked == true?'readonly':''}>
                        </div>
                        <label class="col-sm-1 control-label" for="inpEqhomeNSSState">State</label>
                        <div class="col-sm-2">
                            <input class="form-control" id="inpEqhomeNSSState" name="State" value="${sponsor.getState()}"  ${sponsorPicked == true?'readonly':''}>
                        </div>
                        <label class="col-sm-2 control-label" for="inpEqhomeNSSZip">Zip Code</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="inpEqhomeNSSZip" name="Zip" value="${sponsor.getZip()}"  ${sponsorPicked == true?'readonly':''}>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSSCountry">Country</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSSCountry" name="Country" value="${sponsor.getCountry()}"  ${sponsorPicked == true?'readonly':''}>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-2 control-label" for="inpEqhomeNSSPhone">Phone</label>
                        <div class="col-sm-4">
                            <input class="form-control" id="inpEqhomeNSSPhone" name="Phone" value="${sponsor.getPhone()}"  ${sponsorPicked == true?'readonly':''}>
                        </div>
                        <label class="col-sm-1 control-label" for="inpEqhomeNSSFax">Fax</label>
                        <div class="col-sm-5">
                            <input class="form-control" id="inpEqhomeNSSFax" name="Fax" value="${sponsor.getFax()}"  ${sponsorPicked == true?'readonly':''}>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSSSponUrl">Sponsor URL</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSSSponUrl" name="SponUrl" value="${sponsor.getOrgUrl()}"  ${sponsorPicked == true?'readonly':''}>
                        </div>
                    </div>
                        <!--
                    <div class="form-group form-group-lg">
                        <label class="col-sm-3 control-label" for="inpEqhomeNSSConName">Contact Name</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="inpEqhomeNSSConName" name="ConName" value="${sponsor}" >
                        </div>
                        <label class="col-sm-1 control-label" for="inpEqhomeNSSEmail">Email</label>
                        <div class="col-sm-5">
                            <input class="form-control" id="inpEqhomeNSSEmail" name="Email" value="${sponsor}" >
                        </div>
                    </div>
                        -->
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="sltEqhomeNSSSponsorStatus">Sponsor Status</label>
                        <div class="col-sm-7">                    
                            <select id="sltEqhomeNSSSponsorStatus" class="form-control" name="sponsorStatus">
                                <!--<option disabled selected value> -- Select an Status -- </option>-->
                                <c:forEach var="sponsorStatus" items="${orgStatusList}">
                                    <option value="${sponsorStatus}" ${sponsorStatus == (sponsor.getStatus())?'selected':''} ${sponsorPicked == true?'disabled':''}>${sponsorStatus}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="txteqhomeNSSNote">Notes</label>
                        <div class="col-sm-12">
                            <textarea class="form-group" rows="4" id="txteqhomeNSSNote" name="Note" ${sponsorPicked == true?'readonly':''}>${sponsor.getNotes()}</textarea>
                        </div>
                    </div>
                    <div class="save-options">
                        <button type="submit" class="btn btn-danger btnFormClear"  formaction="clearForm">Clear Form</button>
                        <button type="submit" class="btn btn-info" formaction="newStudyMain">Back</button>
                        <button type="submit" id="btnNextNewStudySponsor"  class="btn btn-success" formaction="newStudySponsorUserList">Next</button>
                    </div>
                </form>
            </div>


        </div>
    </div>
</div>
<!-- footer -->
<jsp:include page="../includes/footer.jsp"/>

<%--<jsp:include page="../includes/forms/formCreateNewUser.jsp"/>--%>

