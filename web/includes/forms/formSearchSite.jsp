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

