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
        <form class="form-horizontal" action="study/displayStudyList" method="post">
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMNCTId">NCT ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSMNCTId" name="NCTId" value="${newStudy.getNctid()}">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMEUStudyId">EU Study ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSMEUStudyId" name="EUStudyId" value="${newStudy.getEuStudyId()}">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMStudyAname">Study Aname</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSMEQStudyAname" name="StudyAname" value="${newStudy.getStudyAname()}">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMStudyTitle">Study Title</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSMStudyTitle" name="StudyTitle" value="${newStudy.getStudyTitle()}">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMSponStudyId">Sponsor Study ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSMSponStudyId" name="SponStudyId" value="${newStudy.getSponStudyId()}">
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMCoSponStudyId">Co Sponsor Study ID</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSMCoSponStudyId" name="CoSponStudyId" value="${newStudy.getCoSponStudyId()}" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMStudyStartDate">Study Start Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpEqhomeNSMStudyStartDate" name="StudyStartDate" value="${newStudy.getStudyStartDateString()}" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMStudyEndDate">Study End Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpEqhomeNSMStudyEndDate" name="StudyEndDate" value="${newStudy.getStudyEndDateString()}"  class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMPlanSubNum">Planned Subject Number</label>
                <div class="col-sm-7">
                    <input class="form-control" id="inpEqhomeNSMPlanSubNum" name="PlanSubNum" value="${newStudy.getPlannedPatientsNum()}" >
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMEQSetDate">EQ Setup Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpEqhomeNSMEQSetDate" name="EQSetDate" value="${newStudy.getStudyEqInitDateString()}" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="inpEqhomeNSMEQClsDate">EQ Close Date</label>
                <div class="col-sm-7 input-group date">
                    <input type="text" id="inpEqhomeNSMEQClsDate" name="EQClsDate" value="${newStudy.getStudyEqCloseDateString()}" class="form-control"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                </div>
            </div>
            <div class="form-group form-group-lg">
                <label class="col-sm-5 control-label" for="sltEqhomeNSMStudyStatus">Study Status</label>
                <div class="col-sm-7">
<!--                    <input class="form-control" id="inpeqhomeNSMStudyStatus" name="StudyStatus" value="${newStudy.getStudyStatus()}">-->
                    <select id="sltSponsorName" id="sltEqhomeNSMStudyStatus" class="form-control">
                        <option disabled selected value> -- Select an Status -- </option>
                        <c:forEach var="studyStatus" items="${studyStatusList}">
                            <option value="${studyStatus}" >${studyStatus}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </form>
    </div>

    <div class="save-options">
        <form>
            <button type="submit" class="btn btn-info" formaction="../eqhome/index.jsp">Back</button>
            <button type="submit" class="btn btn-success" formaction="../study/newStudySponsor">Next</button>
        </form>
    </div>
</div>

<!-- footer -->
<jsp:include page="../includes/footer.jsp"/>

