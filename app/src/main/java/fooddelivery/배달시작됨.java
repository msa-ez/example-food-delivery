package fooddelivery;


public class 배달시작됨 extends AbstractEvent {

    private Long id;
    private String 요리종류;
    private String 배달지주소;
    private String orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String get요리종류() {
        return 요리종류;
    }

    public void set요리종류(String 요리종류) {
        this.요리종류 = 요리종류;
    }
    public String get배달지주소() {
        return 배달지주소;
    }

    public void set배달지주소(String 배달지주소) {
        this.배달지주소 = 배달지주소;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
