package com.example.bookmyshow.DeSerializer;

import com.example.bookmyshow.Event.BookingEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import java.util.Map;


public class BookingEventDeSerializer implements Deserializer<BookingEvent> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }
    @Override
    public BookingEvent deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        BookingEvent bookingEvent = null;
        try{
            bookingEvent=mapper.readValue(bytes, BookingEvent.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return bookingEvent;
    }
    @Override
    public void close() {
        Deserializer.super.close();
    }
}
