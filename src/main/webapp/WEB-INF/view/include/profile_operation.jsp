<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="en"> 

    <head> 
        <!-- Required meta tags -->
        <meta charset="utf-8"> 
        <meta name="viewport" content= 
              "width=device-width, initial-scale=1, 
              shrink-to-fit=no"> 
        <%-- Spring Tag Lib--%>
       <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
       <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
       <s:url var="url_profile_img" value="/static/images/LokeshDi.jpeg"/>
       <s:url var="url_logout" value="/logout"/>
         <s:url var="url_eprofile" value="/user/edit_profile"/>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href= 
              "https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
              integrity= 
              "sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
              crossorigin="anonymous"> 

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, 
                then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
        </script> 

        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"crossorigin="anonymous">
        </script> 

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
                crossorigin="anonymous">
        </script> 
    </head> 

    <body> 
        <div class="dropdown"> 
            <button class="btn btn-success 
                    dropdown-toggle" type="button"
                    id="dropdownMenuButton"
                    data-toggle="dropdown"
                    aria-haspopup="true"
                    aria-expanded="false" 
                    > 
                <img src="${url_profile_img}" class="avatar"  />
            </button> 

            <ul class="dropdown-menu"
                aria-labelledby="dropdownMenuButton"> 
               
                <li class="dropdown-item"> 
                    <a href="${url_eprofile}">edit profile</a>
                </li> 
                <li class="dropdown-item"> 
                    <a href="${url_logout}">logout</a>
                </li> 
            </ul> 
        </div> 
</body> 

</html> 
