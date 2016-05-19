<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>

<script>
    var sponsors=JSON.stringify(${jsonInOrgArr});
</script>

<link href="/WebClinEQ/resources/css/forms/formSearchSponsor.css" rel="stylesheet" type="text/css"/>
<script src="/WebClinEQ/resources/script/forms/formSearchTableContent.js" type="text/javascript"></script>
<script src="/WebClinEQ/resources/script/forms/formSearchSponsor.js" type="text/javascript"></script>


<div class="searchArea">
    <h2 class="secondLv subform">Search Sponsor</h2>
    <form class="form-inline" action="#" method="post">
        <fieldset class="seacrh" style="margin:15px 10px;">
            <div class="form-group">
                <!--                <label style="font-size:15px;" for="inpSearchName">Enter Sponsor Name</label>-->
                <input type="text" class="form-control inpSearchTableContent" placeholder="Search">
            </div>            
            <button type="submit" class="btn btn-default">Search</button>
        </fieldset>
    </form>

    <form action="addOrgToStudy" method="post">
        <div class="tableSearchSponsor">
            <table id="tblFormSearchSponsor" class="table table-striped table-bordered table-bordered">
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
                    <c:forEach var="org" items="${orgArrayList}">

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
                                    <input type="radio" name="optionsRadiosaddOrgToStudy" value="${org.getEqOrgId()}">
                                </td>
                            </tr>
                        
                    </c:forEach>


                </tbody>
            </table>
        </div>

        <input id="btnAddToStudyFormSearchSponsor" type="submit" value="Add to Study" style="float:right;" class="btn btn-default" >

    </form>
</div>

