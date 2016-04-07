<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/WebClinEQ/resources/script/forms/formSearchTableContent.js" type="text/javascript"></script>

    <h2 class="secondLvLv subform">Search User</h2>
    <form class="form-inline" action="#" method="post">
        <fieldset class="seacrh">
            <div class="form-group">
<!--                <label style="margin-left: 8px;" for="inpSearchName">User</label>-->
                <input type="text" class="form-control inpSearchTableContent" placeholder="Search">
            </div>
<!--            <div class="form-group">
                <label style="margin-right: 8px;" for="sltFltIns">Filter by Organization</label>
                <select id="sltFltIns" name="sltFltIns" class="form-control">
                    <option value="all" id="optAll" selected="selected">All</option>
                    <option value="acitve" id="optActive">AA</option>
                    <option value="pending" id="optPending">BB</option>
                </select>   
            </div>            -->
            <button type="submit" class="btn btn-default">Search</button>
        </fieldset>
    </form>
    
    <div class="tableSearchUser">
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
            <tbody id="fbody">
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
