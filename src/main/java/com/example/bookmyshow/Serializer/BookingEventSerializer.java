package com.example.bookmyshow.Serializer;

import com.example.bookmyshow.Event.BookingEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class BookingEventSerializer implements Serializer<BookingEvent> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String s, BookingEvent bookingEvent) {
        byte[] bytes=null;
        ObjectMapper objectMapper=new ObjectMapper();
        try{
          bytes=objectMapper.writeValueAsString(bookingEvent).getBytes();
        }
        catch(Exception e){
           e.printStackTrace();
        }
        return bytes;
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
