<%-- 
    Document   : index
    Created on : Dec 2, 2020, 7:37:11 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact List</title>
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
                    <h3>Contact List </h3>

                    <c:if test="${param.act eq 'sv'}">
                        <p class="success">Contact Added Successfully</p>
                    </c:if>
                    <c:if test="${param.act eq 'del'}">
                        <p class="success">Contact Deleted Successfully</p>
                    </c:if>
                    <c:if test="${param.act eq 'ed'}">
                        <p class="success">Contact Updated Successfully</p>
                    </c:if>
                        
                    <form action="<s:url value="/user/contact_search"/>" >
                        <div align="right" > 
                              <input type="text" name="freeText" value="${param.freeText}" placeholder="Enter text to search" >  
                              <button type="submit">search</button>
                        </div>
                    </form>
                            
                        <form  action="<s:url value="/user/bulk_cdelete"/>"> 
                            <button>delete select contact</button>
                    <table border="1" cellpadding="3">
                        <tr  >
                            <th>SELECT</th>
                            <th>Contact Id</th>
                            <th>NAME</th>
                            <th>PHONE</th>
                            <th>EMAIL</th>
                            <th>ADDRESS</th>
                            <th>REMARK</th>
                            <th>ACTION</th>
                        </tr>


                        <c:if test="${empty contactList}">
                            <tr>
                                <td colspan="8"> 
                                    <p  class="error"  align="center"> No Record found</p> 
                                </td>
                            </tr>
                        </c:if>



                        <c:forEach var="c" items="${contactList}" varStatus="st">
                            <tr>
                                <td><input type="checkbox" name="cid" value="${c.contactId}"></td>
                                <td>${c.contactId} </td>
                                <td>${c.name}</td>
                                <td>${c.phone}</td>
                                <td>${c.email}</td>
                                <td>${c.address}</td>
                                <td>${c.remark}</td>
                                <s:url var="url_del" value="/user/delete_contact">
                                      <s:param name="cid" value="${c.contactId}"/>
                                </s:url>
                                <s:url var="url_edit" value="/user/edit_contact">
                                      <s:param name="cid" value="${c.contactId}"/>
                                </s:url>
                                <td><a href="${url_edit}" >edit</a> |  <a href="${url_del}">delete</a></td>
                            </tr>
                        </c:forEach>
                     </table>
                  </form>            
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
