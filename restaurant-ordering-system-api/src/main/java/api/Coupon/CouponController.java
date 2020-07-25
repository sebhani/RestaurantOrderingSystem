package api.Coupon;

import api.Coupon.model.Coupon;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Controller
@Validated //required for @RequestParam validation
public class CouponController {
    @Autowired
    CouponRepository couponRepository;

    @Autowired
    CouponService couponService;

    /*
    * Apply coupon page for users
     */
    @RequestMapping(value = "applycoupon", method = RequestMethod.GET)
    public String getCouponPage(){
        return "coupon/index";
    }

    @RequestMapping(value = "applycoupon", method = RequestMethod.POST)
    public String applyCoupon(@RequestParam String couponToApprove){
        //checks if the coupon is invalid
        if(!couponService.approveCoupon(couponToApprove, couponRepository)) {
            return "redirect:/applycoupon?err=Invalid+Coupon";
        }

        return "redirect:";
    }

    /*
    * Create new coupons - In Dashboard/administrator
     */
    @RequestMapping(value = "dashboard/administrator/create_coupon", method = RequestMethod.GET)
    public String getCreateCouponPage(){
        //model.addAttribute("coupon", new Coupon());
        return "coupon/create";
    }

    @RequestMapping(value = "dashboard/administrator/create_coupon")
    public String createCoupon(@ModelAttribute @Validated Coupon coupon, @RequestParam @NotBlank String expiryDate){

        //check if the couponstr already saved in the database
        if(couponRepository.findByCouponstr(coupon.getCouponstr()).isPresent()){
            return "redirect:/dashboard/administrator/create_coupon?err=This+Coupon+Already+Exists!";
        }

        //Convert expiry date from string type to Date object. Then, set the expiry attribute with the obtained Date object
        Date expiry = getDateFromString(expiryDate);
        coupon.setExpiry(expiry);

        couponRepository.save(coupon);

        return "coupon/create";
    }

    /*
    * Constructs a Date object from a string in the yyyy-mm-dd format
     */
    private Date getDateFromString(String dateInString){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd", Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
