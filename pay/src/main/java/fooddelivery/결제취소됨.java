package fooddelivery;

public class 결제취소됨 extends AbstractEvent {

    private Long id;
    private String orderId;


    public 결제취소됨(){
        super();
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
}
