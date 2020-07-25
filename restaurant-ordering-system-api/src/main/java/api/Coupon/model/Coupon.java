package api.Coupon.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "The coupon string can't be blank")
    private String couponstr;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date expiry;

    @Range(min = 0, max = 100)
    private int percentage;

    public Coupon() {
    }

    public Coupon(@NotBlank(message = "The coupon string can't be blank") String coupon, Date expiry, @Range(min = 0, max = 100) int percentage) {
        this.couponstr = coupon;
        this.expiry = expiry;
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCouponstr() {
        return couponstr;
    }

    public void setCouponstr(String coupon) {
        this.couponstr = coupon;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
