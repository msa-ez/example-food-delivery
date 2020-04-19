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
    public void whenever배달시작됨_주문상태변경(@Payload 배달시작됨 배달시작됨){

        if(배달시작됨.isMe()){
            System.out.println("##### listener 주문상태변경 : " + 배달시작됨.toJson());
        }
    }

}
