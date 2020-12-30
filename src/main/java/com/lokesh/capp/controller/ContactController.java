
package com.lokesh.capp.controller;

import com.lokesh.capp.domain.Contact;
import com.lokesh.capp.service.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hp
 */
@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;
    
    @RequestMapping(value="/contact_form")
    public String contactForm(Model m)
    {
        Contact contact =new Contact();
        m.addAttribute("command", contact);
        return "contact_form";
    }
    
     @RequestMapping(value = "/user/saveContact")
    public String saveOrUpdateContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
        Integer contactId = (Integer) session.getAttribute("aContactId");
         System.out.println("==================="+contactId);
        if(contactId == null) {
            //save contact
            try {
                Integer userId = (Integer) session.getAttribute("userId");
                c.setUserId(userId);
                contactService.save(c);
               
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to Save contact.Try Again");
                return "contact_form";
            }
             return "redirect:clist?act=sv";
        } 
        else {
            //update Contact
            try {
                c.setContactId(contactId);//PK
                contactService.update(c);
               
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to Update contact.Try Again");
                return "contact_form";
            }
             return "redirect:clist?act=ed";
        }
    }
    
    @RequestMapping(value={"/user/clist" , "/clist"})
    public String contactList(Model m,HttpSession session)
    {
        Integer userId=(Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId));
        return "clist";
    }
    
    
     @RequestMapping(value={"/user/delete_contact"})
    public String deleteContact(@RequestParam("cid") Integer contactId)
    {
        contactService.delete(contactId);
        return "redirect:clist?act=del";
    }
    
    @RequestMapping(value={"/user/edit_contact"})
    public String perpareEditForm(@RequestParam("cid") Integer contactId, HttpSession session,Model m)
    {
        session.setAttribute("aContactId", contactId);
        Contact c= contactService.findById(contactId);
        m.addAttribute("command", c);
        return "contact_form"; // JSP
    }
    
    
     @RequestMapping(value={"/user/contact_search"})
    public String searchContact( HttpSession session,Model m,@RequestParam("freeText")String txt)
    {
         m.addAttribute("contactList", contactService.findUserContact((Integer)session.getAttribute("userId"), txt));
        return "clist"; // JSP
    }
    
    
    @RequestMapping(value={"/user/bulk_cdelete"})
    public String deleteBulkContact(@RequestParam("cid")Integer[] contactIds)
    {
        contactService.delete(contactIds);
        return "redirect:clist?act=del";
    }
}
