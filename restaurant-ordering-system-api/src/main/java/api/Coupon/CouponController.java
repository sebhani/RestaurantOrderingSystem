package api.Coupon;

import api.Coupon.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class CouponController {
    @Autowired
    CouponRepository couponRepository;

    @Autowired
    CouponService couponService;

    @RequestMapping(value = "applycoupon", method = RequestMethod.GET)
    public String getCouponPage(){
        return "coupon/index";
    }

    @RequestMapping(value = "applycoupon", method = RequestMethod.POST)
    public String validateCoupon(@RequestParam String couponToApprove){
        //checks if the coupon is invalid
        if(!couponService.approveCoupon(couponToApprove, couponRepository)) {
            return "redirect:/applycoupon?err=Invalid+Coupon";
        }

        return "redirect:";
    }

}
