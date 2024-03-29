# How to setup the project

## Prerequisites

- Java 17 or later

## Steps

### install apache kafka

- Download the latest version of Apache Kafka from [here](https://kafka.apache.org/downloads)
- Extract the downloaded file to a directory of your choice

change the config file `zookeeper.properties`

![alt text](image.png)

change the config file `server.properties`

![alt text](image-1.png)

this completes the setup of Apache Kafka

### run the project

in the root directory of the project, run the following command

```powershell
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

```powershell
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

to get the graphical user interface for Apache Kafka, run the following command

<https://akhq.io/>

```powershell
C:\kafkaUI>C:\Users\USER\.jdks\corretto-21.0.2\bin\java.exe -Dfile.encoding=windows-1252 -Dsun.stdout.encoding=windows-1252 -Dsun.stderr.encoding=windows-1252 -jar C:\kafkaUI\akhq-0.24.0-all.jar
```

### create a spring boot project

#### create a streamInit package and a StreamInit class

```java
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
```
