package com.wchamara.kafkasampleapp.topology;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.Materialized;

//@Component
public class GlobalKTableTopology {
    //    @Bean
    public Topology createTopology() {
        StreamsBuilder builder = new StreamsBuilder();
        Materialized materialized = Materialized.as("movies-quotes");
        Materialized materializedWithDefault = Materialized.as("movies-quotes-with-default");

        GlobalKTable simpleConsumerDefault = builder.globalTable("star-wars-quotes");
        GlobalKTable matierializedConsumerDefault = builder.globalTable("disney-quotes", materializedWithDefault);
        GlobalKTable simpleConsumer = builder.globalTable("arnold-schwarzenegger-quotes", Consumed.with(Serdes.String(), Serdes.String()));
        GlobalKTable matierializedConsumer = builder.globalTable("basketball-quotes", Consumed.with(Serdes.String(), Serdes.String()), materialized);

//        simpleConsumerDefault.toStream().to("simpleConsumerDefault");
//        matierializedConsumerDefault.toStream().to("matierializedConsumerDefault");
//        simpleConsumer.toStream().to("simpleConsumer");
//        matierializedConsumer.toStream().to("matierializedConsumer");

        return builder.build();
    }
}
