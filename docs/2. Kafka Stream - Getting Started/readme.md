# kafka stream - getting started

## 1. Kafka Streams vs. Regular Kafka

Kafka Streams is a library that allows you to perform stream processing on data stored in Kafka. It is a client library for building applications and microservices, where the input and output data are stored in Kafka clusters. Kafka Streams is a part of the Apache Kafka project and is used for building real-time applications and microservices.

![alt text](image.png)

![alt text](image-1.png)

what is a kafka consumer?

A Kafka consumer is a client that subscribes to topics and processes the feed of published messages. Kafka consumers are used to read messages from Kafka topics and process them. Kafka consumers can be used to read messages from one or more Kafka topics and process them.

what is a kafka stream?

Kafka Streams is a client library for building applications and microservices, where the input and output data are stored in Kafka clusters. It is a part of the Apache Kafka project and is used for building real-time applications and microservices. Kafka Streams is a library that allows you to perform stream processing on data stored in Kafka.

![alt text](image-2.png)
![alt text](image-3.png)
![alt text](image-4.png)
![alt text](image-5.png)
![alt text](image-6.png)
![alt text](image-7.png)

## 2. Topology

![alt text](image-8.png)
![alt text](image-9.png)
![alt text](image-10.png)
![alt text](image-11.png)
![alt text](image-12.png)
![alt text](image-13.png)
![alt text](image-14.png)
![alt text](image-15.png)
![alt text](image-16.png)
![alt text](image-17.png)

![alt text](image-18.png)
![alt text](image-19.png)
![alt text](image-20.png)

![alt text](image-21.png)
![alt text](image-22.png)
![alt text](image-23.png)
![alt text](image-24.png)
![alt text](image-25.png)
![alt text](image-26.png)
![alt text](image-27.png)
![alt text](image-28.png)
![alt text](image-29.png)
![alt text](image-30.png)

## 3. Topology - Hands-on

![alt text](image-31.png)

```java
package com.wchamara.kafkasampleapp.topology;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BasicTopology {
    @Bean
    public Topology createTopology() {
        StreamsBuilder builder = new StreamsBuilder();

        // Add your topology here

        return builder.build();
    }
}

```

## 4. Serdes

![alt text](image-32.png)
![alt text](image-33.png)
![alt text](image-34.png)
![alt text](image-35.png)
![alt text](image-36.png)
![alt text](image-37.png)
example
![alt text](image-38.png)
custom serdes

![alt text](image-39.png)
![alt text](image-40.png)

we can make our own custom serializer and deserializer

![alt text](image-41.png)
![alt text](image-42.png)
![alt text](image-43.png)
![alt text](image-44.png)
![alt text](image-45.png)

## 5. Serdes - Hands-on

```java
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

//@Component
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

```

## 6. Tasks

![alt text](image-46.png)
![alt text](image-47.png)
![alt text](image-48.png)
![alt text](image-49.png)
![alt text](image-51.png)
![alt text](image-50.png)
![alt text](image-52.png)
![alt text](image-53.png)
![alt text](image-54.png)
![alt text](image-55.png)

![alt text](image-56.png)
![alt text](image-57.png)
Doors are the tasks
which is 3 in this case
![alt text](image-58.png)
taxis are the threads
![alt text](image-59.png)
![alt text](image-60.png)
![alt text](image-61.png)
![alt text](image-62.png)
![alt text](image-63.png)
![alt text](image-64.png)
![alt text](image-65.png)
![alt text](image-66.png)
![alt text](image-67.png)
![alt text](image-68.png)
![alt text](image-69.png)
![alt text](image-70.png)
![alt text](image-71.png)
![alt text](image-72.png)
![alt text](image-73.png)
![alt text](image-74.png)
![alt text](image-75.png)
![alt text](image-76.png)
![alt text](image-77.png)

## 7. DSL vs. PAPI

![alt text](image-78.png)
![alt text](image-79.png)
![alt text](image-80.png)
![alt text](image-81.png)

![alt text](image-82.png)
![alt text](image-83.png)
![alt text](image-84.png)
![alt text](image-85.png)
![alt text](image-86.png)
![alt text](image-87.png)
![alt text](image-88.png)
![alt text](image-89.png)

## 8. KStream

![alt text](image-90.png)
![alt text](image-91.png)
![alt text](image-92.png)
![alt text](image-93.png)
![alt text](image-94.png)
![alt text](image-95.png)
![alt text](image-96.png)
![alt text](image-97.png)
![alt text](image-98.png)
![alt text](image-99.png)
![alt text](image-100.png)
![alt text](image-101.png)
![alt text](image-102.png)
![alt text](image-103.png)
![alt text](image-104.png)
![alt text](image-105.png)

## 9. KStream - Hands-on

## 10. KTable

![ ](image-106.png)
![alt text](image-107.png)
![alt text](image-108.png)
![alt text](image-109.png)
![alt text](image-110.png)
![alt text](image-111.png)
![alt text](image-112.png)
![alt text](image-113.png)
![alt text](image-114.png)
![alt text](image-115.png)
![alt text](image-116.png)
![alt text](image-117.png)
![alt text](image-118.png)
![alt text](image-119.png)
![alt text](image-120.png)
![alt text](image-121.png)
![alt text](image-122.png)
![alt text](image-123.png)
![alt text](image-124.png)
![alt text](image-125.png)

## 11. KTable -  Hands-on

## 12. GlobalKTable

![alt text](image-126.png)
![alt text](image-127.png)
![alt text](image-128.png)
![alt text](image-129.png)
![alt text](image-130.png)
![alt text](image-131.png)
![alt text](image-132.png)
![alt text](image-133.png)
![alt text](image-134.png)
![alt text](image-135.png)
![alt text](image-136.png)
![alt text](image-137.png)
![alt text](image-138.png)

## 13. GlobalKTable - Hands-on

```java
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
```

## 14. Processor (PAPI)

## 15. Processor (PAPI) - Hands-on

## 16. State store

## 17. Re-partition
