<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<s:url var="url_css1" value="/static/css/style1.css"/>
 <s:url var="url_bg" value="/static/images/bg2.jpg"/>
<link href="${url_css1}"  rel="stylesheet" type="text/css"/>

<s:url var="url_logout" value="/logout"/>
<s:url var="url_reg" value="/reg_form"/>
<s:url var="url_login" value="/index"/>

 <%--User Not Logged in call : Guest menu --%>
<c:if test="${sessionScope.userId==null}">
 <div class="topnav" >
        <a class="active" href="#">Home</a>
        <a href="${url_login}">Login</a>
        <a href="${url_reg}">register</a>
        <a href="#">about</a>
        <a href="#">Help</a>
         <img src="${url_bg}" alt="Avatar" class="avatar">
    </div>
</c:if>

 
 
 
<%--Menu to admin Logged in call : Admin Menu --%>
  <s:url  var="url_userlist" value="/admin/userlist"/>
   <s:url  var="url_adminhome" value="/admin/dashboard"/>
     <c:if test="${ sessionScope.userId!=null && sessionScope.role==1}">
  
     <div class="topnav" >
        <a class="active" href="${url_adminhome}">Dashboard</a>
        <a href="${url_userlist}">User List</a>
        <a href="#contact">Contact</a>
        <a href="${url_logout}">logout</a>
        
        <img src="<s:url value="/static/images/LokeshDi.jpeg"/>" alt="Avatar" class="avatar">
    </div>
</c:if>





<%--general user logged  in call : User menu --%>
<s:url var="url_cform" value="/contact_form"/>
<s:url var="url_uhome" value="/user/dashboard"/>
<s:url var="url_clist" value="/clist"/>
<s:url  var="url_logout_img" value="/static/images/Apps-session-logout-icon.png"/>
<c:if test="${sessionScope.userId!=null && sessionScope.role==2 }">
       <div class="topnav" >
        <a class="active" href="${url_uhome}">Dashboard</a>
        <a href="${url_cform}">Add Contact</a>
        <a href="${url_clist}">Contact List</a>
        <%--<jsp:include page="profile_operation.jsp"/> --%>
        
       </div>
</c:if>

