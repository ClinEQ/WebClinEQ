<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../resources/css/eqhome/newStudySponsor.css" rel="stylesheet" type="text/css"/>

<jsp:include page="../includes/header.jsp"/>
<script>var sponsor="${sponsor}";</script>

<nav id="navbar-main" class="navbar navbar-inverse">
    <div class="container-fluid">
        <jsp:include page="../includes/topNav.jsp"/>
        <jsp:include page="../includes/leftNavCreateNewPage.jsp"/>
    </div>
</nav>

<div class="container content">
    <div id="studySponPrimary">
        <h1 class="firstLv">EDC</h1>

        <div class="checkSpon">
            <a href="javascript:void(0);" onclick="ToggleSubform('divSearchSponsor', 'formSearchSponsor');">Check if EDC exist</a>           
        </div>

        <div class="divSearchSponsor subSearchArea" style="display:none">
        </div>
        <p style="margin-left: 23%">Enter New EDC Information</p>
        <form class="form-horizontal" method="post">
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSEEqEDCId">EQ EDC ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSEEqEDCId" name="EqSponId" value="${sponsor.getEqOrgId()}" readonly>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSEEqEDCName">EDC Name</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSEEqEDCName" name="SponName" value="${sponsor.getOrgFullName()}">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSEEqEDCNameAb">EDC Name ABBR</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSEEqEDCNameAb" name="SponAB" value="${sponsor.getOrgNameAbbr()}">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSEEqEDCType">EDC Type</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSEEqEDCType" name="SponType" value="${sponsor.getOrgType()}" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSEEqEDCCate">EDC Category</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSEEqEDCCate" name="SponCate" value="${sponsor.getOrgCategory()}" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSEEqEDCAddress1">Address1</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSEEqEDCAddress1" name="Address1" value="${sponsor.getAddress1()}" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSEEqEDCAddress2">Address2</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSEEqEDCAddress2" name="Address2" value="${sponsor.getAddress2()}" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-1 control-label" for="inpEqhomeNSECity">City</label>
                <div class="col-sm-3">
                    <input class="form-control" id="inpEqhomeNSECity" name="City" value="${sponsor.getCity()}" >
                </div>
                <label class="col-sm-1 control-label" for="inpEqhomeNSEState">State</label>
                <div class="col-sm-2">
                    <input class="form-control" id="inpEqhomeNSEState" name="State" value="${sponsor.getState()}" >
                </div>
                <label class="col-sm-2 control-label" for="inpEqhomeNSEZip">Zip Code</label>
                <div class="col-sm-3">
                    <input class="form-control" id="inpEqhomeNSEZip" name="Zip" value="${sponsor.getZip()}" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSECountry">Country</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSECountry" name="Country" value="${sponsor.getCountry()}" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-2 control-label" for="inpEqhomeNSEPhone">Phone</label>
                <div class="col-sm-4">
                    <input class="form-control" id="inpEqhomeNSEPhone" name="Phone" value="${sponsor.getPhone()}" >
                </div>
                <label class="col-sm-1 control-label" for="inpEqhomeNSEFax">Fax</label>
                <div class="col-sm-5">
                    <input class="form-control" id="inpEqhomeNSEFax" name="Fax" value="${sponsor.getFax()}" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSEEDCUrl">EDC URL</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSEEDCUrl" name="SponUrl" value="${sponsor.getOrgUrl()}" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" for="inpEqhomeNSEConName">Contact Name</label>
                <div class="col-sm-3">
                    <input class="form-control" id="inpEqhomeNSEConName" name="ConName" value="${sponsor}" >
                </div>
                <label class="col-sm-1 control-label" for="inpEqhomeNSEEmail">Email</label>
                <div class="col-sm-5">
                    <input class="form-control" id="inpEqhomeNSEEmail" name="Email" value="${sponsor}" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="sltEqhomeNSEEDCStatus">EDC Status</label>
                <div class="col-sm-7">                    
                    <select id="sltEqhomeNSEEDCStatus" class="form-control">
                        <option disabled selected value> -- Select an Status -- </option>
                        <c:forEach var="sponsorStatus" items="${orgStatusList}">
                            <option value="${sponsorStatus}" >${sponsorStatus}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="txteqhomeNSENote">Notes</label>
                <div class="col-sm-12">
                    <textarea class="form-group" rows="4" id="txteqhomeNSENote" name="Note"></textarea>
                </div>
            </div>
        </form>
    </div>

    <div class="save-options">
        <form>
            <button type="submit" class="btn btn-info" formaction="../eqhome/newStudyIWRS.jsp">Back</button>
            <button id="btnNextNewStudySponsor"  class="btn btn-success" formaction="#">Create Study</button>
            <button id="btnNextNewStudySponsor"  class="btn btn-default" formaction="#">Cancel</button>
        </form>
    </div>
</div>

<!-- footer -->
<jsp:include page="../includes/footer.jsp"/>


