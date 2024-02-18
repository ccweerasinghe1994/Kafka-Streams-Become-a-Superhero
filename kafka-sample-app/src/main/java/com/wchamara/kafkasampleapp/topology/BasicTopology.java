package com.wchamara.kafkasampleapp.topology;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;

//@Component
public class BasicTopology {
    //    @Bean
    public Topology createTopology() {
        StreamsBuilder builder = new StreamsBuilder();

        // Add your topology here

        return builder.build();
    }
}
