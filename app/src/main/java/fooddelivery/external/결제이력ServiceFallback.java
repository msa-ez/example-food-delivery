package fooddelivery.external;

/**
 * Created by uengine on 2020. 4. 18..
 */
public class 결제이력ServiceFallback implements 결제이력Service {
    @Override
    public void 결제(결제이력 주문) {
        //do nothing if you want to forgive it

        System.out.println("Circuit breaker has been opened. Fallback returned instead.");
    }
}
