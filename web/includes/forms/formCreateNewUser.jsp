<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="/WebClinEQ/resources/css/forms/formCreateNewUser.css" rel="stylesheet" type="text/css"/>

<div class="container">

    <!-- Modal -->
    <div class="modal fade" id="modalNewUser" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" >&times;</button>
                    <h4 class="modal-title">Create New User Account</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal form-modal" method="post">
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNULastName">Last Name</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNULastName" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUFirstName">First Name</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUFirstName" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUTitle">Title</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUTitle" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUAddress1">Address1</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUAddress1" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUAddress2">Address2</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUAddress2" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-1 control-label" for="inpFormCNUCity">City</label>
                            <div class="col-sm-3">
                                <input class="form-control" id="inpFormCNUCity" >
                            </div>
                            <label class="col-sm-1 control-label" for="inpFormCNUState">State</label>
                            <div class="col-sm-2">
                                <input class="form-control" id="inpFormCNUState" >
                            </div>
                            <label class="col-sm-2 control-label" for="inpFormCNUZip">Zip Code</label>
                            <div class="col-sm-3">
                                <input class="form-control" id="inpFormCNUZip" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUCountry">Country</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUCountry" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-2 control-label" for="inpFormCNUPhone">Phone</label>
                            <div class="col-sm-4">
                                <input class="form-control" id="inpFormCNUPhone" >
                            </div>
                            <label class="col-sm-1 control-label" for="inpFormCNUFax">Fax</label>
                            <div class="col-sm-5">
                                <input class="form-control" id="inpFormCNUFax" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUExEmId">External Employee ID</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUExEmId" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUUserType">User Type</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUUserType" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUUserRole">User Role</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUUserRole" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUUserLogId">User Login ID</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUUserLogId" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUUserPass">User Password</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUUserPass" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUExDep">External Department</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUExDep" >
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUAccSetDate">Account Setup Date</label>
                            <div class="col-sm-7 input-group date">
                                <input type="text" id="inpFormCNUAccSetDate" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-5 control-label" for="inpFormCNUStatus">Status</label>
                            <div class="col-sm-7">
                                <input class="form-control" id="inpFormCNUStatus" >
                            </div>
                        </div>
                    </form>
                </div>
                
                <div>
                    <button type="button" class="btn btn-default" style="width: 160px; margin-left: 70%;">Save & Add to Study</button>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 220px;">Cancel & Close Window</button>
                </div>
            </div>

        </div>
    </div>

</div>