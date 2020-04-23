package fooddelivery;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{


    @Autowired 결제이력Repository 결제이력Repository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenever주문취소됨_결재취소함(@Payload 주문취소됨 주문취소됨){

        if(주문취소됨.isMe()){
            System.out.println("##### listener 결재취소함 : " + 주문취소됨.toJson());

            결제이력 결제이력 = new 결제이력();

            결제이력.set행위("취소");

            결제이력Repository.save(결제이력);
        }
    }

}
