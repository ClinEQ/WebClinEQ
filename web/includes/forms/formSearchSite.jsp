<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/WebClinEQ/resources/script/forms/formSearchTableContent.js" type="text/javascript"></script>


<div id="searchArea">
    <h2 class="secondLv subform">Search Site</h2>
    <form class="form-inline" action="#" method="post">
        <fieldset class="seacrh">
            <div class="form-group">
                <label for="inpSearchName">Enter Sponsor Name</label>
                <input type="text" class="form-control inpSearchTableContent" placeholder="Search">
            </div>            
            <button type="submit" class="btn btn-default">Search</button>
        </fieldset>
    </form>
    
    <form action="addSiteToStudy" method="post">
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
                <tbody id="fbody">
                    <c:forEach var="org" items="${siteArrayList}">

                            <tr>
                                <td>
                                    ${org.getOrgFullName()}
                                </td>
                                <td>
                                    ${org}
                                </td>
                                <td>
                                    ${org.getAddress1()} ${org.getAddress2()} ${org.getCity()} ${org.getState()} ${org.getZip()}
                                </td>
                                <td>
                                    ${org.getStatus()}
                                </td>
                                <td>
                                    <input type="radio" name="optionsRadiosAddSiteToStudy" value="${org.getEqOrgId()}">
                                </td>
                            </tr>
                        
                    </c:forEach>
                </tbody>
            </table>
    </div>
    <!--<button type="submit" class="btn btn-default" style="float:right;">Add to Study</button>  -->
    <input id="btnAddToStudyFormSearchSite" type="submit" value="Add to Study" style="float:right;" class="btn btn-default" >
    </form>
</div>

