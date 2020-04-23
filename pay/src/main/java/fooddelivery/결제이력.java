package fooddelivery;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="결제이력_table")
public class 결제이력 {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String orderId;
    private Double 금액;
    private String 행위;

    @PrePersist
    public void onPrePersist(){

        if("취소".equals(행위)){
            결제취소됨 결제취소됨 = new 결제취소됨();
            BeanUtils.copyProperties(this, 결제취소됨);
            결제취소됨.publish();

        }else{
            결제승인됨 결제승인됨 = new 결제승인됨();
            BeanUtils.copyProperties(this, 결제승인됨);
            결제승인됨.publish();


            try {
                Thread.currentThread().sleep((long) (400 + Math.random() * 220));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public Double get금액() {
        return 금액;
    }

    public void set금액(Double 금액) {
        this.금액 = 금액;
    }


    public String get행위() {
        return 행위;
    }

    public void set행위(String 행위) {
        this.행위 = 행위;
    }
}
