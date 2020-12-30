<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!doctype html>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<head>
    <title>user profile</title>
    <s:url var="url_cssfile" value="/static/css/userprofilecss.css" />
    <link href="${url_cssfile}"  rel="stylesheet" type="text/css"/>
</head>

<body>
    <form class="form-group" action="/user/edit_profile" modelAttribute="command" > 
        <div class="container">

            <div class="form-titile-bar">User Profile  </div>
            <div class="user-profile-image">
                <s:url var="url_profile_img" value="/static/images/user_profile_img.png"/>
                <img src="${url_profile_img}" class="avatar">
                <div >
                    <input type="file"  id="customFile"  class="file-chooser-style"/>
                </div>
            </div>
            <div class="user-details">
                <label for="inputforname" class="col-sm-2 col-form-label" >Name</label>
                <div class="col-sm-10">
                    <%-- <input type="text" class="form-control" id="inputEmail3" >--%>
                    <f:input  type="text" path="address" ></f:input>
                    
                </div>

                <label for="inputphone" class="col-sm-2 col-form-label"  name="phone">Phone</label>
                <div class="col-sm-10">
                <%-- <input type="text" class="form-control" id="inputEmail3" >--%>
                <f:input type="text" path="phone"/>
                </div>

                <label for="inputforemail" class="col-sm-2 col-form-label"  name="email">Email</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" >
                </div>

                <label for="inputaddress" class="col-sm-2 col-form-label"  name="address">Address</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3">
                </div>


                <div class="submit-btn">
                    <button class="btn btn-success">update</button>
                </div>
            </div>
        </div>

    </form>

    <!-- Optional JavaScript; choose one of the two! -->
    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    -->
</body>
