package fooddelivery;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="주문관리_table")
public class 주문관리 {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    Long orderId;
    String 배달지주소;
    String 요리종류;

    @PostPersist
    public void onPostPersist(){
        배달시작됨 배달시작됨 = new 배달시작됨();
        배달시작됨.setOrderId(String.valueOf(getOrderId()));
        BeanUtils.copyProperties(this, 배달시작됨);
        배달시작됨.publish();


    }

    @PrePersist
    public void onPrePersist(){
        쿠폰발행됨 쿠폰발행됨 = new 쿠폰발행됨();
        BeanUtils.copyProperties(this, 쿠폰발행됨);
        쿠폰발행됨.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String get배달지주소() {
        return 배달지주소;
    }

    public void set배달지주소(String 배달지주소) {
        this.배달지주소 = 배달지주소;
    }

    public String get요리종류() {
        return 요리종류;
    }

    public void set요리종류(String 요리종류) {
        this.요리종류 = 요리종류;
    }
}
