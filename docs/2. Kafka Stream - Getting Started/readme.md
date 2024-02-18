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

## 8. KStream

## 9. KStream - Hands-on

## 10. KTable

## 11. KTable -  Hands-on

## 12. GlobalKTable

## 13. GlobalKTable - Hands-on

## 14. Processor (PAPI)

## 15. Processor (PAPI) - Hands-on

## 16. State store

## 17. Re-partition
