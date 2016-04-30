<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/WebClinEQ/resources/css/forms/formCreateNewSite.css" rel="stylesheet" type="text/css"/>

<div class="container">

    <!-- Modal -->
    <div class="modal fade" id="modalNewSite" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" >&times;</button>
                    <h4 class="modal-title">Create New Site Account</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal form-modal" action="inputSiteToStudy" method="post">
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNSSiteName">Site Name</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNSSiteName" name="SponName" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNSDesc">Desc</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNSDesc" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNSURL">URL</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNSURL" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNSAddress1">Address1</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNSAddress1" name="Address1">
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNSAddress2">Address2</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNSAddress2" name="Address2" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-1 control-label" for="inpFormCNSCity">City</label>
                            <div class="col-sm-3">
                                <input class="form-control" id="inpFormCNSCity" name="City" >
                            </div>
                            <label class="col-sm-1 control-label" for="inpFormCNSState">State</label>
                            <div class="col-sm-2">
                                <input class="form-control" id="inpFormCNSState" name="State" >
                            </div>
                            <label class="col-sm-2 control-label" for="inpFormCNSZip">Zip Code</label>
                            <div class="col-sm-3">
                                <input class="form-control" id="inpFormCNSZip" name="Zip">
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNSCountry">Country</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNSCountry" name="Country">
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-2 control-label" for="inpFormCNSPhone">Phone</label>
                            <div class="col-sm-4">
                                <input class="form-control" id="inpFormCNSPhone" name="Phone">
                            </div>
                            <label class="col-sm-1 control-label" for="inpFormCNSFax">Fax</label>
                            <div class="col-sm-5">
                                <input class="form-control" id="inpFormCNSFax" name="Fax">
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNSSiteType">Site Type</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNSSiteType" name="SponType" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNSSiteCate">Site Category</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNSSiteCate" >
                            </div>
                        </div>

                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNSStatus">Status</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNSStatus" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="txtFormCNSNotes">Notes</label>
                            <div class="col-sm-12">
                                <textarea class="form-group" rows="4" id="txtFormCNSNotes"></textarea>
                            </div>
                        </div>


                    
                <!--</div>-->

                <div>
                    <!--<button type="button" class="btn btn-default" style="width: 160px; margin-left: 70%;">Save & Add to Study</button>-->
                    <input type="submit" value="Add to Study" class="btn btn-default" style="width: 160px; margin-left: 70%;" onclick="form.action = 'inputSiteToStudy';">
                </div>
</form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 220px;">Cancel & Close Window</button>
                </div>
            </div>

        </div>
    </div>

</div>