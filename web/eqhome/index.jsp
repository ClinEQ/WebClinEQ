<link href="../resources/css/eqhome/index.css" rel="stylesheet" type="text/css"/>

<jsp:include page="../includes/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav id="navbar-main" class="navbar navbar-inverse">
    <jsp:include page="../includes/topNav.jsp"/>
    <jsp:include page="../includes/leftNav.jsp"/>
</nav>



<div class="container content">
    <section id="EQHome">
        <h3>Study List</h3>
        <div class="filter-bar">
            <form class="form-inline">
                <div class="form-group select-box" >
                    <label>Study Status</label>
                    
                    <select id="sltStudyStatus" name="sltStudyStatus" class="form-control">

                        <c:forEach var="studyStatus" items="${studyStatusList}">

                            <option value="${studyStatus}" id="${studyStatus}">${studyStatus}</option>

                        </c:forEach>

                    </select>                                        
                </div>
                <div class="form-group select-box">
                    <label>Sponsor Name</label>
                    
                    <select id="sltSponsorName" name="sltSponsorName" class="form-control" onChange="changeSponsor()">

                        <c:forEach var="sponsorName" items="${sponsorNameList}">

                            <option value="${sponsorName}" id="${sponsorName}">${sponsorName}</option>

                        </c:forEach>

                    </select>                      
                </div>
            </form>
        </div>

        <div class="table-area">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>EQ Study ID</th>
                        <th>NCI ID</th>
                        <th>Study Aname</th>
                        <th>Sponsor Name</th>
                        <th>Eq_initial_date</th>
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
    <form>
    <button type="submit" formaction="../study/createNewStudy" class="btn btn-success">Add New Study</button>
    </form>
</div>
<!-- footer -->
<jsp:include page="../includes/footer.jsp"/>
