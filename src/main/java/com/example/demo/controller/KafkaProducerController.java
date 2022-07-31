package com.example.demo.controller;

import com.example.demo.payload.Student;
import com.example.demo.services.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kafkaProducer")
public class KafkaProducerController {

    @Autowired
    private KafkaSender sender;

    @PostMapping
    public ResponseEntity<String> sendData(@RequestBody Student student){
        sender.sendData(student);
        return new ResponseEntity<>("Data sent to Kafka", HttpStatus.OK);
    }
}