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

    @Autowired 주문관리Repository 주문관리Repository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whenever결제승인됨_주문정보받음(@Payload 결제승인됨 결제승인됨){

        if(결제승인됨.isMe()){
            System.out.println("##### listener 주문정보받음 : " + 결제승인됨.toJson());

            주문관리 주문 = new 주문관리();
            주문.setOrderId(Long.valueOf(결제승인됨.getOrderId()));
            주문관리Repository.save(주문);
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenever결제취소됨_주문취소처리(@Payload 결제취소됨 결제취소됨){

        if(결제취소됨.isMe()){
            System.out.println("##### listener 주문취소처리 : " + 결제취소됨.toJson());

            주문관리Repository.findById(결제취소됨.getOrderId()).ifPresent(주문관리->{
                주문관리Repository.delete(주문관리);
            });

        }
    }

}
