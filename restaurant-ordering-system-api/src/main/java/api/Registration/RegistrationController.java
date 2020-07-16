package api.Registration;

import api.SpringSecurity.UserRepository;
import api.SpringSecurity.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    /*
     * User Registration
     */

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String getUserRegistration(Model model){
        model.addAttribute(new User()); //equivalent to ("user", new User())
        return "registration/user";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute @Valid User user, Errors errors){

        if(errors.hasErrors()){
            return "redirect:/signup";
        }

        if(exists(user.getPhone())){
            return "redirect:/signup?err=This+Phone+Number+Has+Been+Used!";
        }

        user.setActivated(true);//Later the user should provide the activation code to activate his account
        user.setRoles("ROLE_USER");

        userRepository.save(user);

        return "redirect:";
    }

    /*
     * Restaurant Owner Registeration


    @RequestMapping(value = "dashboard/administrator/signup", method = RequestMethod.GET)
    public String getOwnerrRegistration(Model model){
        model.addAttribute(new User()); //equivalent to ("user", new User())
        return "registration/restaurant";
    }

    @RequestMapping(value = "dashboard/administrator/signup", method = RequestMethod.POST)
    public String registerOwner(@ModelAttribute @Valid User user, Errors errors){

        if(errors.hasErrors()){
            return "redirect:dashboard/administrator/signup";
        }

        if(exists(user.getPhone())){
            return "redirect:dashboard/administrator/signup?err=This+Phone+Number+Has+Been+Used!";
        }

        user.setActivated(true);//Later the user should provide the activation code to activate his account
        user.setRoles("ROLE_OWNER");

        //userRepository.save(user);

        return "redirect:";
    }
     */
    /*
    Checks if an account with the same phone number is already registered
     */
    private boolean exists(String phone_number){
        return userRepository.findByPhone(phone_number).isPresent();
    }
}