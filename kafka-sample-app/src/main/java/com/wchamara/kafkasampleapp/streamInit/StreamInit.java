package com.wchamara.kafkasampleapp.streamInit;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class StreamInit {

    private final KafkaStreams streams;
    public StreamInit(Topology topology) {
        System.out.println("StreamInit");
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "app-id");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streams = new KafkaStreams(topology, props);
    }

    @PostConstruct
    public void startStream() {
        System.out.println("StreamInit start");
        streams.start();
    }

    @PreDestroy
    public void closeStream() {
        System.out.println("StreamInit close");
        streams.close();
    }
}
