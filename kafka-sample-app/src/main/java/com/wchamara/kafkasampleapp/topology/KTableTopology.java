package com.wchamara.kafkasampleapp.topology;

import com.google.gson.Gson;
import com.wchamara.kafkasampleapp.dto.MovieQuotes;
import com.wchamara.kafkasampleapp.util.KufkaSerdisUtil;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.stereotype.Component;

@Component
public class KTableTopology {
    Gson gson = new Gson();

    //    @Bean
    public Topology createTopology() {
        StreamsBuilder builder = new StreamsBuilder();
        Materialized materialized = Materialized.as("movies-quotes");
        Materialized materializedWithDefault = Materialized.as("movies-quotes-with-default");

        KTable simpleConsumerDefault = builder.table("star-wars-quotes");
        KTable matierializedConsumerDefault = builder.table("disney-quotes", materializedWithDefault);
        KTable<String, MovieQuotes> simpleConsumer = builder.table("arnold-schwarzenegger-quotes", Consumed.with(Serdes.String(), KufkaSerdisUtil.getSerde(MovieQuotes.class, gson)));
        KTable matierializedConsumer = builder.table("basketball-quotes", Consumed.with(Serdes.String(), Serdes.String()), materialized);

        simpleConsumerDefault.toStream().to("simpleConsumerDefault");
        matierializedConsumerDefault.toStream().to("matierializedConsumerDefault");
        simpleConsumer.toStream().to("simpleConsumer");
        matierializedConsumer.toStream().to("matierializedConsumer");

        return builder.build();
    }
}
