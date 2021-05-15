package com.hashedin.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/kafka")
@CrossOrigin(origins = "http://127.0.0.1")
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String Topic = "trades";
    @GetMapping("/produce")
    public String postToKafka(@RequestParam String key, @RequestParam Integer value){
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put(key,value);
        final String finalValue = key + ":" + value;
//       NetflixShow show = new NetflixShow("A","B", "C", "D",
//                "E", "F", new Date(),200, "5*","25", "A", "dsjdk");
        kafkaTemplate.send(Topic, finalValue );
        return "published to kafka successfully";


    }
}

