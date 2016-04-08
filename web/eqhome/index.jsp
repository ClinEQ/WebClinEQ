<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../resources/css/eqhome/index.css" rel="stylesheet" type="text/css"/>

<jsp:include page="../includes/header.jsp"/>

<nav id="navbar-main" class="navbar navbar-inverse">
    <div class="container-fluid">
        <jsp:include page="../includes/topNav.jsp"/>
        <jsp:include page="../includes/leftNav.jsp"/>
    </div>
</nav>

<div class="container content">
    <section id="EQHome">
        <h1 class="firstLv">Study List</h1>
        <div class="filter-bar indexFilterBar">
            <form class="form-inline">
                <div class="form-group select-box" id="divIndexStudyStatus" >
                    <label>Study Status</label>
                    <select id="sltStudyStatus" name="sltStudyStatus" class="form-control"  >
                        <option value="All">ALL</option>
                        <c:forEach var="studyStatus" items="${studyStatusList}">
                            <option value="${studyStatus}">${studyStatus}</option>
                        </c:forEach>
                    </select>                                        
                </div>
                <div class="form-group select-box">
                    <label>Sponsor Name</label>
                    <select id="sltSponsorName" name="sltSponsorName" class="form-control">
                        <option value="All">ALL</option>
                        <c:forEach var="sponsorName" items="${sponsorNameList}">
                            <option value="${sponsorName}" >${sponsorName}</option>
                        </c:forEach>
                    </select>                      
                </div>
            </form>
        </div>

        <div class="table-area">
            <table class="table table-striped" id="tableStudy">
                <thead>
                    <tr>
                        <th>EQ Study ID</th>
                        <th>NCI ID</th>
                        <th>Study Aname</th>
                        <th>Sponsor Name</th>
                        <th>EQ Initial Date</th>
                        <th>Status</th>
                        <th>Details</th>
                    </tr>
                </thead>
                <c:if test="${studyArrayList == null}">
                    <p>no studies </p>
                </c:if>
                <tbody>
                    <c:forEach var="study" items="${studyArrayList}">
                        <tr>
                            <td>
                                ${study.getEqStudyId()}
                            </td>
                            <td>
                                ${study.getNctid()}
                            </td>
                            <td>
                                ${study.getStudyAname()}
                            </td>
                            <td>
                                ${study.getEqSponName()}
                            </td>
                            <td>
                                ${study.getStudyEqInitDate()}
                            </td>
                            <td>
                                ${study.getStudyStatus()}
                            </td>
                            <td><a href="#">Detail</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
    <button onclick="openAddNewStudy('../study/createNewStudy',1000)" class="btn btn-success">Add New Study</button>
</div>

<!-- footer -->
<jsp:include page="../includes/footer.jsp"/>
