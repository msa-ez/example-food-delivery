package fooddelivery;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="주문_table")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String item;
    private Integer 수량;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        fooddelivery.external.결제이력 결제이력 = new fooddelivery.external.결제이력();
        // mappings goes here
        Application.applicationContext.getBean(fooddelivery.external.결제이력Service.class)
                .결제(결제이력);


    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    public Integer get수량() {
        return 수량;
    }

    public void set수량(Integer 수량) {
        this.수량 = 수량;
    }




}
