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

    @PostPersist
    public void onPostPersist(){
        배달시작됨 배달시작됨 = new 배달시작됨();
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




}
