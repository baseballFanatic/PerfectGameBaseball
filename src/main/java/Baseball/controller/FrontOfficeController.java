package Baseball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class FrontOfficeController
{
    @RequestMapping(value = "/office", method = RequestMethod.GET)
    public String frontOffice(HttpSession session, ModelMap modelMap ) {
        modelMap.put( "username", session.getAttribute( "username" ) );
        modelMap.put( "firstName", session.getAttribute( "firstName" ) );
        modelMap.put( "lastName", session.getAttribute( "lastName" ) );
        modelMap.put( "active", session.getAttribute( "active" ) );
        modelMap.put( "recentYear", session.getAttribute( "recentYear" ) );
        return "frontOffice";
    }
}
