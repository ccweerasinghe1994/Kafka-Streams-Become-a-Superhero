package com.wchamara.kafkasampleapp.topology;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Arrays;
import java.util.regex.Pattern;

//@Component
public class KStreamTopology {
    //    @Bean
    public Topology createTopology() {
        StreamsBuilder builder = new StreamsBuilder();
        KStream singleTopic = builder.stream("star-wars-quotes", Consumed.with(Serdes.String(), Serdes.String()));
        KStream multipleTopics = builder.stream(Arrays.asList("star-wars-quotes", "arnold-schwarzenegger-quotes"), Consumed.with(Serdes.String(), Serdes.String()));
        KStream patternTopics = builder.stream(Pattern.compile("basketball.*"), Consumed.with(Serdes.String(), Serdes.String()));

        singleTopic.to("singleTopic");
        multipleTopics.to("multipleTopics");
        patternTopics.to("patternTopics");
        return builder.build();
    }
}
