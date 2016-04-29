<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../resources/css/eqhome/newStudyMain.css" rel="stylesheet" type="text/css"/>

<jsp:include page="../includes/header.jsp"/>

<nav id="navbar-main" class="navbar navbar-inverse">
    <div class="container-fluid">
        <jsp:include page="../includes/topNav.jsp"/>
        <jsp:include page="../includes/leftNavCreateNewPage.jsp"/>
    </div>
</nav>

<div class="container content">
    <div id="studyBasicInfo">
        <h1>Study Basic Information</h1>
        <form class="form-horizontal" action="http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_his_back" method="post">
        <!--<form class="form-horizontal" action="study/displayStudyList" autocomplete="on" method="post">-->    
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMNCTId">NCT ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSMNCTId" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMEUStudyId">EU Study ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSMEUStudyId" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMStudyAname">Study Aname</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMEQStudyAname" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMStudyTitle">Study Title</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMStudyTitle" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMSponStudyId">Sponsor Study ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMSponStudyId" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMCoSponStudyId">Co Sponsor Study ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMCoSponStudyId" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMStudyStartDate">Study Start Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpeqhomeNSMStudyStartDate" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMStudyEndDate">Study End Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpeqhomeNSMStudyEndDate" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMPlanSubNum">Planned Subject Number</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMPlanSubNum" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMEQSetDate">EQ Setup Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpeqhomeNSMEQSetDate" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMEQClsDate">EQ Close Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpeqhomeNSMEQClsDate" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpeqhomeNSMStudyStatus">Study Status</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpeqhomeNSMStudyStatus" >
                </div>
            </div>
        </form>
    </div>

    <div class="save-options">
        <form>
        <button type="submit" class="btn btn-info" formaction="../eqhome/index.jsp">Back</button>
        <!--<button type="submit" class="btn btn-success" formaction="../eqhome/newjsp.jsp">Next</button>-->
        <button type="submit" class="btn btn-success" formaction="../eqhome/newStudySponsor.jsp">Next</button>
        </form>
    </div> 

</div>

<!-- footer -->
<jsp:include page="../includes/footer.jsp"/>

