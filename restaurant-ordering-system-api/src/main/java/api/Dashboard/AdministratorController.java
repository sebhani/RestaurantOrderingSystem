package api.Dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "dashboard/administrator")
public class AdministratorController {

    @RequestMapping(value = "")
    public String getAdminMainPage(){
        return "dashboard/administrator/index";
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String getRestaurantOwnerDashboard(){
        return "dashboard/administrator/restaurantRegistration";
    }
}
