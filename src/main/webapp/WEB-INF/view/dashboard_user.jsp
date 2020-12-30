<%-- 
    Document   : index
    Created on : Dec 2, 2020, 7:37:11 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Capp</title>
        <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}"  rel="stylesheet" type="text/css"/>
        
    </head>
    <s:url var="url_bg" value="/static/images/bg2.jpg"/>
    <body background="${url_bg}">
        
        <table  border="1" align="center"  width="80%" >
           
            <%-- Header --%>
            <tr  >
                <td  height="100px"> 
                    <jsp:include page="include/header.jsp"/>
                </td>
            </tr>
            
            <%-- Menu --%> 
            <tr>
                <td  height="35px"  >
                    <jsp:include page="include/menu.jsp"/>
                <td height="35px" width="35px" >
                      <jsp:include page="include/profile_operation.jsp"/>
               </td>
        
               
           </tr>
            
           <%-- Content Area --%>
            <tr>
                <td   height="350px" valign="top">
                    <h1> User  Dashboard </h1>
                    TODO:-> 
                </td>  
            </tr>
            
           <%-- footer --%>
            <tr>
                <td  height="25px" align="right"> 
                    <jsp:include page="include/footer.jsp"/>
                </td>
            </tr>
            
        </table>
    </body>
</html>
