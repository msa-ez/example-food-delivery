package fooddelivery;

public class 주문됨 extends AbstractEvent {

    private Long id;
    private String 품목;
    private Integer 수량;

    public 주문됨(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String get품목() {
        return 품목;
    }

    public void set품목(String 품목) {
        this.품목 = 품목;
    }
    public Integer get수량() {
        return 수량;
    }

    public void set수량(Integer 수량) {
        this.수량 = 수량;
    }
}
