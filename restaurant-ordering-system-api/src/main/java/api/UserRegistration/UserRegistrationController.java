package api.UserRegistration;

import api.SpringSecurity.UserRepository;
import api.SpringSecurity.models.User;
import org.h2.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.model.IModel;

@Controller
public class UserRegistrationController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String getUserRegistration(Model model){
        model.addAttribute(new User()); //equivalent to ("user", new User())
        return "userRegistration/index";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute User user, Model model){

        if(exists(user.getPhone())){
            return "redirect:/signup?err=This+Phone+Number+Has+Been+Used!";
        }

        user.setActivated(true);//Later the user should provide the activation code to activate his account
        user.setRoles("ROLE_USER");

        userRepository.save(user);

        return "redirect:";
    }

    /*
    Checks if an account with the same phone number is already registered
     */
    private boolean exists(String phone_number){
        return userRepository.findByPhone(phone_number).isPresent();
    }
}