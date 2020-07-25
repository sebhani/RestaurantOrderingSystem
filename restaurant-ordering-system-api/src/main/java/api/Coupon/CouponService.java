package api.Coupon;

import api.Coupon.model.Coupon;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class CouponService {
    public boolean approveCoupon(String couponToApprove, CouponRepository couponRepository){
        Optional<Coupon> coupon = couponRepository.findByCouponstr(couponToApprove);

        if(coupon.isPresent()){

            //Hours,minutes, etc. don't matter to us, so we set the date at the start of the day
            DateTime today = new DateTime(DateTimeZone.UTC).withTimeAtStartOfDay();
            DateTime expiry = new DateTime(coupon.get().getExpiry(), DateTimeZone.UTC).withTimeAtStartOfDay();

            //Should be replaced with logging
            System.out.println("expiry: "+expiry);
            System.out.println("today: "+today);

            return today.isEqual(expiry) || expiry.isAfter(today); //return true if expiry date is equal/after today's date
        }

        return false;
    }

    /*
    Getting if coupon's expiry is before (no)

    private boolean before(Date couponExpiryDate){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+3"));

        //Getting the coupon's expiry date in terms of Year, Month, and Day
        cal.setTime(couponExpiryDate);
        int couponExpiryYear = cal.get(Calendar.YEAR);
        int couponExpiryMonth = cal.get(Calendar.MONTH);
        int couponExpiryDay = cal.get(Calendar.DAY_OF_MONTH);

        System.out.println("expiry day------> "+couponExpiryDay);
        //Getting today's date in terms of Year, Month, and Day
        cal.setTime(new Date());
        int todayYear = cal.get(Calendar.YEAR);
        int todayMonth = cal.get(Calendar.MONTH);
        int todayDay = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println("today------> "+todayDay);

        return (todayYear<=couponExpiryYear && todayMonth<=couponExpiryMonth && todayDay<=couponExpiryDay);
    }   */
}