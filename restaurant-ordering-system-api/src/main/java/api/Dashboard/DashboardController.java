package api.Dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "dashboard") //the URL will be .../dashboard/...
public class DashboardController {

    @RequestMapping(value = "")
    public String getDashboardMainPage(){
        return "dashboard/index";
    }
}
