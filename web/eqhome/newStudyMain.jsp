<jsp:include page="../includes/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link href="../resources/css/eqhome/newStudyMain.css" rel="stylesheet" type="text/css"/>
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
    <form class="form-horizontal" action="study/displayStudyList" method="post">
        <div id="studyBasicInfo">
            <p>Study Basic Information</p>

            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMNCTId">NCT ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSMNCTId" name="inpEqhomeNSMNCTId">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMEUStudyId">EU Study ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSMEUStudyId" name="inpEqhomeNSMEUStudyId">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMStudyAname">Study Aname</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMEQStudyAname" name="inpeqhomeNSMEQStudyAname">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMStudyTitle">Study Title</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMStudyTitle" name="inpeqhomeNSMStudyTitle">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMSponStudyId">Sponsor Study ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMSponStudyId" name="inpeqhomeNSMSponStudyId">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMCoSponStudyId">Co Sponsor Study ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMCoSponStudyId" name="inpeqhomeNSMCoSponStudyId" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMStudyStartDate">Study Start Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpeqhomeNSMStudyStartDate" name="inpeqhomeNSMStudyStartDate" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMStudyEndDate">Study End Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpeqhomeNSMStudyEndDate" name="inpeqhomeNSMStudyEndDate" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMPlanSubNum">Planned Subject Number</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMPlanSubNum" name="inpeqhomeNSMPlanSubNum" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMEQSetDate">EQ Setup Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpeqhomeNSMEQSetDate" name="inpeqhomeNSMEQSetDate" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMEQClsDate">EQ Close Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpeqhomeNSMEQClsDate" name="inpeqhomeNSMEQClsDate" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMStudyStatus">Study Status</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMStudyStatus" name="inpeqhomeNSMStudyStatus" >
                </div>
            </div>

            <!--<button type="submit" formaction="newStudySponsor" class="btn btn-success">Next</button>-->

        </div>

        <input type="submit" value="Next" class="btn btn-success" onclick="form.action = 'newStudySponsor';">
        <div class="save-options">
            <!--<button type="button" class="btn btn-primary">Create Study</button>
            <button type="button" class="btn btn btn-info">Save as Default</button>


            <button type="button" class="btn btn btn-danger">Cancel</button>-->
            <input type="submit" value="Create Study" class="btn btn-primary" onclick="form.action = 'saveNewStudy';">
            <input type="submit" value="Save as Draft" class="btn btn-info" onclick="form.action = 'saveNewStudyDraft';">
            <input type="submit" value="Cancel" class="btn btn-danger" onclick="form.action = 'cancelNewStudy';">



        </div>
    </form>
</div>

<!-- footer -->
<jsp:include page="../includes/footer.jsp"/>

