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
                <h1 class="firstLv">IWRS</h1>

                <div class="checkSpon">
                    <a href="javascript:void(0);" onclick="ToggleSubform('divSearchSponsor', 'formSearchSponsor');">Check if IWRS exist</a>           
                </div>

                <div class="divSearchSponsor subSearchArea" style="display:none">
                </div>
                <p style="margin-left: 23%">Enter New IWRS Information</p>
                <form class="form-horizontal" method="post">
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSIEqIWRSId">EQ IWRS ID</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSIEqIWRSId" name="EqSponId" value="${sponsor.getEqOrgId()}" readonly>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSIEqIWRSName">IWRS Name</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSIEqIWRSName" name="SponName" value="${sponsor.getOrgFullName()}">
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSIEqIWRSNameAb">IWRS Name ABBR</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSIEqIWRSNameAb" name="SponAB" value="${sponsor.getOrgNameAbbr()}">
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSIEqIWRSType">IWRS Type</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSIEqIWRSType" name="SponType" value="${sponsor.getOrgType()}" >
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSIEqIWRSCate">IWRS Category</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSIEqIWRSCate" name="SponCate" value="${sponsor.getOrgCategory()}" >
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSIEqIWRSAddress1">Address1</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSIEqIWRSAddress1" name="Address1" value="${sponsor.getAddress1()}" >
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSIEqIWRSAddress2">Address2</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSIEqIWRSAddress2" name="Address2" value="${sponsor.getAddress2()}" >
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-1 control-label" for="inpEqhomeNSICity">City</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="inpEqhomeNSICity" name="City" value="${sponsor.getCity()}" >
                        </div>
                        <label class="col-sm-1 control-label" for="inpEqhomeNSIState">State</label>
                        <div class="col-sm-2">
                            <input class="form-control" id="inpEqhomeNSIState" name="State" value="${sponsor.getState()}" >
                        </div>
                        <label class="col-sm-2 control-label" for="inpEqhomeNSIZip">Zip Code</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="inpEqhomeNSIZip" name="Zip" value="${sponsor.getZip()}" >
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSICountry">Country</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSICountry" name="Country" value="${sponsor.getCountry()}" >
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-2 control-label" for="inpEqhomeNSIPhone">Phone</label>
                        <div class="col-sm-4">
                            <input class="form-control" id="inpEqhomeNSIPhone" name="Phone" value="${sponsor.getPhone()}" >
                        </div>
                        <label class="col-sm-1 control-label" for="inpEqhomeNSIFax">Fax</label>
                        <div class="col-sm-5">
                            <input class="form-control" id="inpEqhomeNSIFax" name="Fax" value="${sponsor.getFax()}" >
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="inpEqhomeNSIIWRSUrl">IWRS URL</label>
                        <div class="col-sm-7">
                            <input class="form-control" id="inpEqhomeNSIIWRSUrl" name="SponUrl" value="${sponsor.getOrgUrl()}" >
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-3 control-label" for="inpEqhomeNSIConName">Contact Name</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="inpEqhomeNSIConName" name="ConName" value="${sponsor}" >
                        </div>
                        <label class="col-sm-1 control-label" for="inpEqhomeNSIEmail">Email</label>
                        <div class="col-sm-5">
                            <input class="form-control" id="inpEqhomeNSIEmail" name="Email" value="${sponsor}" >
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="sltEqhomeNSIIWRSStatus">IWRS Status</label>
                        <div class="col-sm-7">                    
                            <select id="sltEqhomeNSIIWRSStatus" class="form-control">
                                <option disabled selected value> -- Select an Status -- </option>
                                <c:forEach var="sponsorStatus" items="${orgStatusList}">
                                    <option value="${sponsorStatus}" >${sponsorStatus}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group form-group-lg">
                        <label class="col-sm-5 control-label" for="txteqhomeNSINote">Notes</label>
                        <div class="col-sm-12">
                            <textarea class="form-group" rows="4" id="txteqhomeNSINote" name="Note"></textarea>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-info" formaction="newStudySiteUserList">Back</button>
                    <button type="submit" id="btnNextNewStudySponsor"  class="btn btn-success" formaction="newStudyEDC">Next</button>                        
                </form>
            </div>

            <div class="save-options">
                <form>

                </form>
            </div>
        </div>
    </div>
</div>
    <!-- footer -->
    <jsp:include page="../includes/footer.jsp"/>


