package com.lokesh.capp.controller;

import com.lokesh.capp.command.Edit_Profile_Command;
import com.lokesh.capp.command.LoginCommand;
import com.lokesh.capp.command.RegisterCommand;
import com.lokesh.capp.domain.User;
import com.lokesh.capp.exception.UserBlockedException;
import com.lokesh.capp.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author hp
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
   

    /**
     *
     * @param m
     * @return
     */
    
    //Index page view 
    @RequestMapping(value = {"/", "/index"})
    public String index(Model m) {
        m.addAttribute("command", new LoginCommand());
        return "index";  //  ->/WEB_INF/view/index.jsp
    }

    // Handler for login user
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginHandle(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
        try {
            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());

            if (loggedInUser == null) {
                //ON FAILED
                // Add an error message and go back to login page which is index.jsp
                m.addAttribute("err", "please Enter Valid Credentials");
                return "index";  //JSP--> /WEB-INF/view/index.jsp
            } else {
                //ON SUCCESS
                // check user role and Redirect user to appropriate dashboard.

                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    addUserInSession(loggedInUser, session);//Add session to user
                    return "redirect:admin/dashboard";
                } else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
                    addUserInSession(loggedInUser, session);
                    return "redirect:user/dashboard";
                } else {
                    m.addAttribute("err", "OOPs! There No Such Role is Found.");
                    return "index";  //JSP--> /WEB-INF/view/index.jsp
                }
            }
        } catch (UserBlockedException ex) {
            // Add an error message and go back to login page which is index.jsp
            m.addAttribute("err", ex.getMessage());
            return "index";  //JSP--> /WEB-INF/view/index.jsp
        }
    }

    //handler for logout user
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:index?act=lo";  //  ->/WEB_INF/view/dashboard_user.jsp
    }

    //loggedin user dashboard  view
    @RequestMapping(value = "/user/dashboard")
    public String userDashboard() {
        return "dashboard_user";  //  ->/WEB_INF/view/dashboard_user.jsp
    }

    //loggedin admin dashboard view
    @RequestMapping(value = "/admin/dashboard")
    public String adminDashboard() {
        return "dashboard_admin";  //  ->/WEB_INF/view/dashboard_admin.jsp
    }
    
    //user list view inside admin dashboard
    @RequestMapping(value = "/admin/userlist")
    public String getUserList(Model m) {
        m.addAttribute("userList", userService.getUserList());
        return "userlist";  //  ->/WEB_INF/view/dashboard_admin.jsp
    }
 
    
    
//user registration form view
    @RequestMapping(value = "/reg_form")
     public String registerHandle(Model m) {
        m.addAttribute("command", new RegisterCommand());
        return "reg_form";  //  ->/WEB_INF/view/reg_from.jsp
    }

    
    // Handle user Registration form
    @RequestMapping(value = "/register")
    public String register(@ModelAttribute("command") RegisterCommand cmd, Model m) {
        try {
            User u = cmd.getUser();
            u.setRole(UserService.ROLE_USER);
            u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
            userService.register(u);
            return "redirect:index?act=reg";
        } catch (DuplicateKeyException e) {
            m.addAttribute("err", "Login Name already taken . Choose Another loginName");
            return "redirect:reg_form?act=err";
        }
       
    }

    //Add http session for loggedin user
    private void addUserInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());
    }
  
    
    //handler for changing login status of user
    @RequestMapping(value = "/admin/change_status")
    @ResponseBody
    public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus) {
        try {
            userService.changeLoginStatus(userId, loginStatus);
            return "success: Status Changed";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR : Unable to Change Status";
        }
         
    }
    
    
    // Handler for Checking  availability of user name in database that user is already exists or not.
    @RequestMapping(value = "/check_avail")
    @ResponseBody
    public String checkAvailability(@RequestParam String loginName) {
       if(userService.isLoginNameExist(loginName))
           return "UserName is already exist .choose another name";
       else
           return "You can take this user Name.";
    }
    
    //Edit profile front controller
    @RequestMapping(value={"/user/edit_profile"})
    public String editProfile(HttpSession session ,Model m)
    {
       
        Integer userId=(Integer) session.getAttribute("userId");
        System.out.println("======================"+userId);
        
        User u=userService.findById(userId);
        Edit_Profile_Command command=new Edit_Profile_Command();
        command.setName(u.getName());
          command.setName(u.getPhone());
            command.setName(u.getEmail());
              command.setName(u.getAddress());
               System.out.println("======================"+command.getName());
                System.out.println("======================"+command.getPhone());
                 System.out.println("======================"+command.getEmail());
                  System.out.println("======================"+command.getAddress());
        m.addAttribute("command" ,command );
        return "edit_profile_form";
    }
    
    
     
    
    
    

}
