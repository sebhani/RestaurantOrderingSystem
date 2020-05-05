package api.Administrator;

import api.Inventory.Item;
import api.Inventory.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "administrator")  // path will become /administrator/...`
public class AdminController {
    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(value = "")
    public String AdminPage(Model model){
        return "administrator/index";
    }

    /*
     * Handle add page
     */
    //handle displaying of add form
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddForm(){
        return "administrator/add";
    }

    //handle post requests from add form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addFormPost(@ModelAttribute Item newItem){
        newItem.setAvailable(true);
        itemRepository.save(newItem);

        return "redirect:add";
    }

    /*
     * Handle remove page
     */
    //handle displaying of remove form
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveItem(){
        return "administrator/removeItem";
    }
}
