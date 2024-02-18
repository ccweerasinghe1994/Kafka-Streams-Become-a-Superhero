package com.wchamara.kafkasampleapp.processor;

import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.ProcessorSupplier;
import org.apache.kafka.streams.processor.api.Record;
import org.apache.kafka.streams.state.StoreBuilder;

import java.util.Set;

public class SimpleProcessor implements ProcessorSupplier<String, String, String, String> {
    @Override
    public Processor<String, String, String, String> get() {


        return new Processor<String, String, String, String>() {
            ProcessorContext context;

            @Override
            public void init(ProcessorContext context) {
                this.context = context;
            }

            @Override
            public void process(Record<String, String> record) {
                Record<String, String> newRecord = new Record<>(record.key(), String.format("%s: %s", context.recordMetadata().get().topic(), record.value()), System.currentTimeMillis());
            }

            @Override
            public void close() {
            }
        };
    }

    @Override
    public Set<StoreBuilder<?>> stores() {
        return ProcessorSupplier.super.stores();
    }
}
