<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/WebClinEQ/resources/css/forms/formCreateNewSponsor.css" rel="stylesheet" type="text/css"/>
<!--<p>Enter New Sponsor Information</p>-->

<div class="container">

    <!--Modal-->
    <div class="modal fade" id="modalNewSponsr" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" >&times;</button>
                    <h4 class="modal-title">Create New Sponsor</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="post">
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpEqhomeNSSEqSponId">EQ Sponsor ID</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpEqhomeNSSEqSponId" name="EqSponId" readonly>
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpEqhomeNSSSponName">Sponsor Name</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpEqhomeNSSSponName" name="SponName" value="">
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpEqhomeNSSSponAB">Sponsor Name ABBR</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpEqhomeNSSSponAB" name="SponAB" value="">
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpEqhomeNSSSponType">Sponsor Type</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpEqhomeNSSSponType" name="SponType" value="" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpEqhomeNSSSponCate">Sponsor Category</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpEqhomeNSSSponCate" name="SponCate" value="" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpEqhomeNSSAddress1">Address1</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpEqhomeNSSAddress1" name="Address1" value="" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpEqhomeNSSAddress2">Address2</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpEqhomeNSSAddress2" name="Address2" value="" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-1 control-label" for="inpEqhomeNSSCity">City</label>
                            <div class="col-sm-3">
                                <input class="form-control" id="inpEqhomeNSSCity" name="City" value="" >
                            </div>
                            <label class="col-sm-1 control-label" for="inpEqhomeNSSState">State</label>
                            <div class="col-sm-2">
                                <input class="form-control" id="inpEqhomeNSSState" name="State" value="" >
                            </div>
                            <label class="col-sm-2 control-label" for="inpEqhomeNSSZip">Zip Code</label>
                            <div class="col-sm-3">
                                <input class="form-control" id="inpEqhomeNSSZip" name="Zip" value="" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpEqhomeNSSCountry">Country</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpEqhomeNSSCountry" name="Country" value="" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-2 control-label" for="inpEqhomeNSSPhone">Phone</label>
                            <div class="col-sm-4">
                                <input class="form-control" id="inpEqhomeNSSPhone" name="Phone" value="" >
                            </div>
                            <label class="col-sm-1 control-label" for="inpEqhomeNSSFax">Fax</label>
                            <div class="col-sm-5">
                                <input class="form-control" id="inpEqhomeNSSFax" name="Fax" value="" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpEqhomeNSSSponUrl">Sponsor URL</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpEqhomeNSSSponUrl" name="SponUrl" value="" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-3 control-label" for="inpEqhomeNSSConName">Contact Name</label>
                            <div class="col-sm-3">
                                <input class="form-control" id="inpEqhomeNSSConName" name="ConName" value="" >
                            </div>
                            <label class="col-sm-1 control-label" for="inpEqhomeNSSEmail">Email</label>
                            <div class="col-sm-5">
                                <input class="form-control" id="inpEqhomeNSSEmail" name="Email" value="" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="sltEqhomeNSSSponsorStatus">Sponsor Status</label>
                            <div class="col-sm-7">                    
                                <select id="sltEqhomeNSSSponsorStatus" class="form-control">
                                    <option disabled selected value> -- Select an Status -- </option>
                                    <c:forEach var="sponsorStatus" items="${orgStatusList}">
                                        <option value="${sponsorStatus}" >${sponsorStatus}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="txteqhomeNSSNote">Notes</label>
                            <div class="col-sm-12">
                                <textarea class="form-group" rows="4" id="txteqhomeNSSNote" name="Note"></textarea>
                            </div>
                        </div>
                        <div>

                            <input type="submit" value="Add to Site" class="btn btn-default" style="width: 160px; margin-left: 70%;" onclick="form.action = 'inputSiteToStudy';">
                        </div>
                    </form>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 220px;">Cancel & Close Window</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
