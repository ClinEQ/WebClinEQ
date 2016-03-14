<%-- 
    Document   : EQHomePage
    Created on : Feb 16, 2016, 8:46:19 PM
    Author     : yusong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <center>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/clineq.css">
        <title>EQ Home</title>
        <style>
#header {
    background-color:blue;
    color:white;
    text-align:center;
    padding:5px;
}
#nav {
    line-height:30px;
    background-color:gainsboro;
    height:300px;
    width:100px;
    float:left;
    padding:5px;	      
}
#section {
    width:350px;
    float:left;
    padding:10px;	 	 
}
#footer {
    background-color:blue;
    color:white;
    clear:both;
    text-align:center;
   padding:5px;	 	 
}
</style>

    </head>
     
    <body> 
        <div id="header">
            <h1 color="red">ClinEQ System</h1> 
            <ul>
                
                <li><a href="#">Home</li>
                <li><a href="#">Notification</li>
                <li><a href="#">My Account</li>
                <li><a href="#">Logoff</li>
                <li><a href="#">Help</li>
            </ul>    
                        
        </div>
       
         <div id="nav">
             Study<br>
             Sponsor<br>
             Site
         </div>

         <div id="section">
             <h2 align="center">Study List</h2>
            <table>
               <tr>Study Status</tr>
               <tr>
                  <select name="study_status" >
                  <option>Active</option>
               <option>Draft</option>
               <option>All</option>
               </select>
                </tr>
                 <tr>&nbsp;</tr>
               <tr>Sponsor Name</tr>
               <tr>
               <select name="sponsor_name" >
               <option>Phfier</option>
               <option>BMS</option>
               <option>Roche Lab</option>
               </select>
                </tr>
            </table>
             
         
         
        
       
        
       
          
        
         <p></p>
       
        <table border="1" width="1" cellspacing="2" cellpadding="10">
            <thead>
                <tr>
                    <th nowrap>EQ Study ID</th>
                    <th nowrap>NCT ID</th>
                    <th nowrap>Study Name</th>
                    <th nowrap>Sponsor Name</th>
                    <th nowrap>Initial Date</th>
                    <th nowrap>Status</th>
                    <th nowrap>Details</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                             
            </tbody>
            </table>
            <input type="button" value="Add New Study" name="btn_addNewStudy" />
        </div>
        
         <div id="footer">
             Copyright @ClinicalEQ LLC. 2016-2018
         </div>
    </body>
    </center>
</html>
