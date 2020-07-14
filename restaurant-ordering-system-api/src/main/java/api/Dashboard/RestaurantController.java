package api.Dashboard;

import api.Inventory.Item;
import api.Inventory.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "dashboard/restaurant")  // path will become dashboard/administrator/...`
public class RestaurantController {
    @Autowired
    ItemRepository itemRepository;

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
        model.addAttribute("title", "Add Item to Menu");

        return "dashboard/restaurant/add";
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
    public String displayRemoveItem(Model model){
        model.addAttribute("title", "Remove Item from Menu");

        return "dashboard/restaurant/removeItem";
    }

    //handle post requests from remove form
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeFormPost(@RequestParam int itemId){
        itemRepository.delete(itemId);

        return "redirect:remove";
    }

    /*
     * Handle update page
     */
    //handle displaying of update form
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String displayUpdateItem(Model model){
        model.addAttribute("title", "Update Menu Item");

        return "dashboard/restaurant/updateItem";
    }

    //handle post requests from update form
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateFormPost(@ModelAttribute Item updatedItem, @RequestParam String availability){

        Item originalItem;
        //checking if the item exits
        try {
            originalItem= itemRepository.findOne(updatedItem.getId());
        } catch (EmptyResultDataAccessException e){
            System.out.print(e);
            return "redirect:update";
        }

        //set boolean attribute isAvailable since radio controls values are strings
        if(availability.equals("true"))
            updatedItem.setAvailable(true);

        //populate attributes with original values if required
        checkDefaults(originalItem, updatedItem);

        itemRepository.update(updatedItem);

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
}
