<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="searchArea">
    <p class="firstLv subform">Search User</p>
    <form class="form-inline" action="#" method="post">
        <fieldset class="seacrh">
            <div class="form-group">
                <label for="inpSearchName">Enter Sponsor Name</label>
                <input type="text" class="form-control" id="inpSearchName">
            </div>
            <div class="form-group">
                <label for="sltFltIns">by Institution</label>
                <select id="sltFltIns" name="sltFltIns" class="form-control">
                    <option value="all" id="optAll" selected="selected">All</option>
                    <option value="acitve" id="optActive">AA</option>
                    <option value="pending" id="optPending">BB</option>
                </select>   
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
                    <th>User Name</th>
                    <th>User ID</th>
                    <th>Institution Name</th>
                    <th>Institution Type</th>
                    <th>Status</th>
                    <th><i class="fa fa-dot-circle-o"></i></th>
                </tr>
            </thead>
            <c:if test="${userArrayList == null}">
                <p>no user </p>
            </c:if>
            <tbody>
                <c:forEach var="user" items="${userArrayList}">
                    <tr>
                        <td>
                            ${user.getFname()} ${user.getLname()}
                        </td>
                        <td>
                            ${user.getEqUserId()} 
                        </td>
                        <td>
                            ${user.getEqOrgId().getOrgFullName()}
                        </td>
                        <td>
                            ${user.getUserType()} 
                        </td>
                        <td>
                            ${user.getStatus()}
                        </td>
                        <td>
                            <input type="radio" name="optionsRadios" id="optionsRadios" value="option">
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <button type="submit" class="btn btn-default" style="float:right;">Add to Study</button>
</div>