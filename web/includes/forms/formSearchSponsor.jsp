<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="searchArea">
    <p class="firstLv subform">Search Sponsor</p>
    <form class="form-inline" action="#" method="post">
        <fieldset class="seacrh">
            <!--            <legend class="search">Search Sponsor</legend>-->
            <div class="form-group">
                <label for="inpSearchName">Enter Sponsor Name</label>
                <input type="text" class="form-control" id="inpSearchName">
            </div>            
            <button type="submit" class="btn btn-default">Search</button>
        </fieldset>
    </form>

    <div class="seacrhSpon">
        <p class="secondLv">Search Result</p>              
    </div>

    <form class="form-horizontal" action="AddSponsorToStudy" method="post">
        <div class="tableSearchSponsor">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Sponsor Name</th>
                        <th>Department</th>
                        <th>Location</th>
                        <th>Status</th>
                        <th><i class="fa fa-dot-circle-o"></i></th>
                    </tr>
                </thead>
                <c:if test="${orgArrayList == null}">
                    <p>no org </p>
                </c:if>
                <tbody>

                    <c:forEach var="org" items="${orgArrayList}">
                        
                        <c:if test="${org.getOrgType()=='SPONSOR'}">


                            <tr>
                                <td>
                                    ${org.getOrgFullName()}
                                </td>
                                <td>

                                </td>
                                <td>
                                    ${org.getAddress1()} ${org.getAddress2()} ${org.getCity()} ${org.getState()} ${org.getZip()}
                                </td>
                                <td>
                                    ${org.getStatus()}
                                </td>
                                <td>
                                    <input type="radio" name="optionsRadios" id="optionsRadios" value="value="${org.getEqOrgId()}">
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>


                </tbody>
            </table>
        </div>
        <!--<button type="submit" class="btn btn-default" style="float:right;">Add to Study</button> -->
        <input type="submit" value="Add to Study" class="btn btn-danger" >

    </form>
</div>

