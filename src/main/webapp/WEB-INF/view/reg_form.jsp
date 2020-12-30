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
        <s:url   var="url_jqlib"  value="/static/js/jquery-3.5.1.min.js"/>
        <script src="${url_jqlib}" ></script>
        <script>
            $(document).ready(function(){
                $("#id_check_avail").click(function (){
                    $.ajax({
                        url:'check_avail',
                        data: { loginName : $("#id_loginName").val()},
                        success:function (data){
                            $("#id_res_div").html(data);
                        }
                      });
                });
            });
        </script>
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
                    
                    <h3> User Registration </h3>
                    
                    <%-- showing Error message --%>  
                      <c:if test="${param.act eq 'err'}">
                          <p class="error">  Login Name already taken . Choose Another loginName</p>
                      </c:if>
                       
                      
                     <s:url var="url_register" value="/register"/>   
                    <f:form  action="${url_register}" modelAttribute="command" >
                        <table border="1">
                             <tr>
                                <td >Name</td>
                                <td >  <f:input path="user.name" /></td>
                             </tr>
                             <tr>
                                <td >phone</td>
                                <td >  <f:input path="user.phone" /></td>
                             </tr>
                             <tr>
                                <td >Email</td>
                                <td >  <f:input path="user.email" /></td>
                             </tr>
                            <tr>
                                <td >Address</td>
                                <td >  <f:textarea path="user.address" /></td>
                            </tr>
                             <tr>
                                <td >Login Name</td>
                                <td >  <f:input id="id_loginName" path="user.loginName" />
                                    <button type="button" id="id_check_avail">Check Availability</button><br/>
                                     <div id="id_res_div" class="error" ></div>
                                </td>
                             </tr>
                            
                            <tr>
                                <td >Password</td>
                                <td >  <f:password path="user.password" /></td>
                            </tr>
                            <tr>
                              <td align="center" colspan="2"><button >Register</button></td>
                            </tr>
                            <br/>
                            
                        </table>
                      
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
