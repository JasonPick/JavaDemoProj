package com.sankuai.study.demo;

import com.sankuai.study.demo.mq.producer.KafkaProducer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.sankuai.study.demo.mapper")
@EntityScan("com.sankuai.study.entities")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        KafkaProducer producer = context.getBean(KafkaProducer.class);

        for(int i = 0; i<3; i++){
            producer.send();

            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
