<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../resources/css/eqhome/sponsor.css" rel="stylesheet" type="text/css"/>

<jsp:include page="../includes/header.jsp"/>

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

    <div class="row  content contenSponsor">
        <div class="col-lg-2 col-md-2 col-sm-2">
            <jsp:include page="../includes/leftNav.jsp"/>
        </div>
        <div class="col-lg-10 col-md-10 col-sm-10">
            <!-- Header -->
            <div>
                <h1 class="firstLv">Sponsor</h1>
            </div>
            <!-- Filter -->
            <div class="filter-bar sponsorFilterBar">
                <!-- Filter Area -->
                <form class="form-inline">        
                    <div class="form-group select-box" id="divSponsorStatus" >
                        <label>Select Sponsor Status</label>
                        <select id="sltSponsorStatus" name="sltSponsorStatus" class="form-control"  >
                            <option value="All">ALL</option>
                            <c:forEach var="sponsorStatus" items="${sponStatusList}">
                                <option value="${sponsorStatus}">${sponsorStatus}</option>
                            </c:forEach>
                        </select>                                        
                    </div>
                    <!-- Search Bar -->
                    <div class="form-group seacrh" style="margin:15px 10px;">
                        <div class="form-group">
                            <input type="text" class="form-control inpSearchTableContent" placeholder="Search, eg:Sponsor Name, Country, City...">
                        </div>            
                        <button type="submit" class="btn btn-default">Search</button>
                    </div>
                </form>      
            </div>
            <!-- Table -->
            <div>
                <table class="table table-striped table-bordered table-bordered">
                    <thead>
                        <tr>
                            <th>EQ Sponsor ID</th>
                            <th>Sponsor Name</th>
                            <th>Address</th>
                            <th>Status</th>
                            <th>Detail</th>
                        </tr>
                    </thead>
                    <tbody class="fbody">
                        <c:forEach var="spon" items="${sponList}">
                            <c:if test="${spon.getOrgType()=='SPONSOR'}">
                                <tr>
                                    <td>
                                        ${spon.getEqOrgId()}
                                    </td>
                                    <td>
                                        ${spon.getOrgFullName()}
                                    </td>
                                    <td>
                                        ${spon.getAddress1()} ${spon.getAddress2()} ${spon.getCity()} ${spon.getState()} ${spon.getZip()}
                                    </td>
                                    <td>
                                        ${spon.getStatus()}
                                    </td>
                                    <td>
                                        <a href="">Detail</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- Add New Sponsor Button -->
            <a href="javascript:void(0);" onclick="ToggleSubform('divCreateNewSponsor', 'formCreateNewSponsor');" class="btn btn-default" style="float:right;">Add New Sponsor</a>
            <!-- Form Create New Sponsor -->
            <div class="divCreateNewSponsor" style="display: none">               
            </div>
        </div>
    </div>


</div>



