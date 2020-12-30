<%-- 
    Document   : index
    Created on : Dec 2, 2020, 7:37:11 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
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
            function changeStatus(uid,lStatus){
              
               $.ajax({
                   url: "change_status",
                   data: {userId:uid,loginStatus:lStatus},
                   success: function (data) {
                       alert(data);
                        
                    }
               });
                
            }
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
                    <h1> User List</h1>
                    <table border="1">
                        <tr>
                            <th>SN</th>
                            <th>USER ID</th>
                            <th>NAME</th>
                            <th>PHONE</th>
                            <th>EMAIL</th>
                            <th>ADDRESS</th>
                            <th>LOGIN NAME</th>
                            <th>LOGIN STATUS</th>
                        </tr>
                        
                        <c:forEach var="u" items="${userList}" varStatus="st">
                            <tr>
                                <td>${st.count}</td>
                                <td>${u.userId}</td>
                                <td>${u.name}</td>
                                <td>${u.phone}</td>
                                <td>${u.email}</td>
                                <td>${u.address}</td>
                                <td>${u.loginName}</td>
                                <td>
                                    <select id="id_${u.userId}" onchange="changeStatus(${u.userId},$(this).val())">
                                        <option value="1"> Active</option>
                                        <option value="2"> Block</option>
                                      </select>
                                      <script >
                                          $('#id_${u.userId}').val(${u.loginStatus});
                                      </script>
                              </td>
                            </tr>
                           
                        </c:forEach>
                          
                        
                    </table>
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
