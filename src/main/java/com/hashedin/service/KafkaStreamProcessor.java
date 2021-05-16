package com.hashedin.service;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.context.annotation.Bean;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

@Service
public class KafkaStreamProcessor {
    public void streamConsumer() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "HelloStreams");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> kStream = builder.stream("shares");
        kStream.foreach((k, v) -> System.out.println("Key = " + k + " Value = " + v));
        //kStream.peek((k, v) -> System.out.println("Key = " + k + " Value = " + v));
        Topology topology = builder.build();

        KafkaStreams streams = new KafkaStreams(topology, props);

        System.out.println("Starting the stream");
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Stopping Stream");
            streams.close();
        }));







        /*
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG,"default");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.Integer().getClass());


        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String, Integer> kStreams = streamsBuilder.stream("shares");
        System.out.println("Inside StreamCOnsumer");
        kStreams.foreach((k, v) -> System.out.println("key= " + k + "value=" +v));
        KafkaStreams streams = new KafkaStreams(streamsBuilder.build(),props);
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            streams.close();
        }));*/
    }
//    @Bean
//    public java.util.function.Consumer<KStream<String, String>> process() {
//
//        return input ->
//                input.foreach((key, value) -> {
//                    System.out.println("Key: " + key + " Value: " + value);
//                });
//    }

    }

