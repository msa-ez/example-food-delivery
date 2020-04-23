package fooddelivery;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

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

            //바로 이벤트를 보내버리면 주문정보가 커밋되기도 전에 배송발송됨 이벤트가 발송되어 주문테이블의 상태가 바뀌지 않을 수 있다.
            // TX 리스너는 커밋이 완료된 후에 이벤트를 발생하도록 만들어준다.
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void beforeCommit(boolean readOnly) {
                    결제승인됨.publish();
                }
            });


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
