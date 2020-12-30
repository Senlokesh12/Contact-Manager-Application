<%-- 
    Document   : index
    Created on : Dec 2, 2020, 7:37:11 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
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
        
        <table  border="1"  align="center"  width="80%" >
           
            <%-- Header --%>
            <tr>
                <td  height="100px"> 
                    <jsp:include page="include/header.jsp"/>
                </td>
            </tr>
            
            <%-- Menu --%> 
            <tr>
                <td  height="25px" >
                    <jsp:include page="include/menu.jsp"/>
                </td>
           </tr>
            
           <%-- Content Area --%>
            <tr>
                <td   height="350px" valign="top">
                    <s:url var="url_login" value="login"/>
                    <h3> User Login </h3>
                    
                    <%-- showing Error Message --%>
                    <c:if test="${err!=null}">
                      <p class="error">${err}</p>
                    </c:if>
                      
                      <%-- showing logout message --%>  
                      <c:if test="${param.act eq 'lo'}">
                          <p class="success">  yes ! You are successfully logout !!</p>
                      </c:if>
                       
                      <%-- showing register  message --%>  
                      <c:if test="${param.act eq 'reg'}">
                          <p class="success">You are Successfully  Registered .Please Login </p>
                      </c:if>
                        
                    <f:form  action="${url_login}" modelAttribute="command" >
                        <table border="1">
                            <tr>
                                <td >UserName</td>
                                <td >  <f:input path="loginName" /></td>
                            </tr>
                            <tr>
                                <td >Password</td>
                                <td >  <f:password path="password" /></td>
                            </tr>
                            <tr>
                              <td align="center" colspan="2"><button >Login</button></td>
                            </tr>
                            <br/>
                            
                        </table>
                        <div><a href="<s:url  value="/reg_form"/>" style="font-size: 14px;"> new user? </a></div>

                    </f:form>
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
