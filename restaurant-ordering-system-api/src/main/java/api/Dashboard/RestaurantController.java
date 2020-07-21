package api.Dashboard;

import api.Inventory.Item;
import api.Inventory.ItemRepository;
import api.SpringSecurity.UserRepository;
import api.SpringSecurity.models.MyUserDetails;
import api.SpringSecurity.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "dashboard/restaurant")  // path will become dashboard/administrator/...`
public class RestaurantController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    private String userRole;

    @RequestMapping(value = "")
    public String AdminPage(Model model){
        List<Item> menuItems = itemRepository.findAll();
        model.addAttribute("menuItems", menuItems);
        model.addAttribute("title", "Administrator Page");

        return "dashboard/restaurant/index";
    }

    /*
     * Handle add page
     */
    //handle displaying of add form
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddForm(Model model){

        //check if the user is admin to enable restaurant id association
        userRole = getPrincipal().getAuthorities().iterator().next().getAuthority();
        if(userRole.equals("ROLE_ADMIN")){
            model.addAttribute("admin",true);
        }

        model.addAttribute("title", "Add Item to Menu");

        return "dashboard/restaurant/add";
    }

    //handle post requests from add form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addFormPost(@ModelAttribute Item newItem, @RequestParam(required = false) Integer restaurantId){

        User user;
        if(userRole.equals("ROLE_ADMIN")){
            user = userRepository.findById(restaurantId).get();//You got to handle exception NoSuchElementException

            if(!user.getRoles().equals("ROLE_OWNER"))//check if the user is a restaurant or not
                return "redirect:add?err=The+User+is+not+a+restaurant!";
        }else {
            user = getPricipalDB();//getting the authenticated user (restaurant) from the DB
        }

        newItem.setRestaurantinfo(user.getRestaurantInfo());
        newItem.setAvailable(true);

        itemRepository.save(newItem);

        return "redirect:add";
    }

    /*
     * Handle remove page
     */
    //handle displaying of remove form
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveItem(Model model){
        model.addAttribute("title", "Remove Item from Menu");

        return "dashboard/restaurant/removeItem";
    }

    //handle post requests from remove form
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeFormPost(@RequestParam int itemId){
        itemRepository.deleteById(itemId);

        return "redirect:remove";
    }

    /*
     * Handle update page
     */
    //handle displaying of update form
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String displayUpdateItem(Model model){
        model.addAttribute("title", "Update Menu Item");

        //check if the user is admin to enable restaurant id association
        userRole = getPrincipal().getAuthorities().iterator().next().getAuthority();
        if(userRole.equals("ROLE_ADMIN")){
            model.addAttribute("admin",true);
        }

        return "dashboard/restaurant/updateItem";
    }

    //handle post requests from update form
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateFormPost(@ModelAttribute Item updatedItem, @RequestParam String availability,
                                 @RequestParam(required = false) Integer restaurantId){

        Item originalItem;
        //checking if the item exits
        try {
            originalItem= itemRepository.findById(updatedItem.getId());
        } catch (EmptyResultDataAccessException e){
            System.out.print(e);
            return "redirect:update";
        }

        //set boolean attribute isAvailable since radio controls values are strings
        if(availability.equals("true"))
            updatedItem.setAvailable(true);

        //populate attributes with original values if required
        checkDefaults(originalItem, updatedItem);

        //associate item to restaurant
        User user;
        if(userRole.equals("ROLE_ADMIN")){
            user = restaurantId!=null? userRepository.findById(restaurantId).get() : originalItem.getRestaurantinfo().getUser();//You got to handle exception NoSuchElementException

            if(!user.getRoles().equals("ROLE_OWNER"))//check if the user is a restaurant or not
                return "redirect:update?err=The+User+is+not+a+restaurant!";
        }else {
            user = getPricipalDB();//getting the authenticated user (restaurant) from the DB
        }
        updatedItem.setRestaurantinfo(user.getRestaurantInfo());

        itemRepository.save(updatedItem);

        return "redirect:update";
    }

    //helper method to populate attributes with original values if required
    private void checkDefaults(Item originalItem, Item updatedItem){
        if((updatedItem.getName().trim()).equals("-"))
            updatedItem.setName(originalItem.getName());

        if((updatedItem.getDescription().trim()).equals("-"))
            updatedItem.setDescription(originalItem.getDescription());

        if(((int) updatedItem.getPrice()) == 404)
            updatedItem.setPrice(originalItem.getPrice());
    }

    //helper method to return the user fetched from the DB
    private User getPricipalDB(){
        MyUserDetails principal = getPrincipal();
        Optional<User> user = userRepository.findByPhone(principal.getUsername());
        user.orElseThrow(() -> new UsernameNotFoundException("Not found "+ principal.getUsername()));

        return user.get();
    }

    //helper method to return the currently authenticated principal
    private MyUserDetails getPrincipal(){
        return (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}