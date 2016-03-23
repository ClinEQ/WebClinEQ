<link href="/WebClinEQ/resources/css/forms/formSearchSponsor.css" rel="stylesheet" type="text/css"/>
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
<c:if test="${studyArrayList == null}">
                    <p>no studies </p>
                </c:if>
                <tbody>
                    <c:forEach var="study" items="${studyArrayList}">
                        <tr id="${study.getEqStudyId()}">
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
                                ${study.getSponStudyId()}
                            </td>
                            <td>
                                <input type="radio" name="optionsRadios" value="option">
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
    </div>
    <button type="submit" class="btn btn-default" style="float:right;">Add to Study</button>          
</div>

