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
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whenever결제승인됨_주문정보받음(@Payload 결제승인됨 결제승인됨){

        if(결제승인됨.isMe()){
            System.out.println("##### listener 주문정보받음 : " + 결제승인됨.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenever결제취소됨_주문취소처리(@Payload 결제취소됨 결제취소됨){

        if(결제취소됨.isMe()){
            System.out.println("##### listener 주문취소처리 : " + 결제취소됨.toJson());
        }
    }

}
