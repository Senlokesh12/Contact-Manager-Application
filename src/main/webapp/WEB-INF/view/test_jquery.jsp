<%-- 
    Document   : test_jquery
    Created on : Dec 11, 2020, 1:30:51 PM
    Author     : hp
--%>
<%@taglib  uri="http://www.springframework.org/tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:url   var="url_jqlib"  value="/static/js/jquery-3.5.1.min.js"/>
         <script src="${url_jqlib}" ></script>
        <script>
           $(document).ready(function(){
             // alert('JQuery is ready to untegrate');
             $("#id_get_time").click(function(){
                 //alert("button is clicked");
                 $.ajax({
                     url :'get_time',
                     success: function (data) {
                        $("#get_time").html(data);
                    }
                 });
             });
           });
        </script>
    </head>
    <body>
        <h1>    ajax test page!</h1>
        <button id="id_get_time">Get Server time</button>
        <p id="get_time"></p>
    </body>
</html>
