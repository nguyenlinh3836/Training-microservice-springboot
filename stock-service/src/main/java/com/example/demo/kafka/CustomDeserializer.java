//package com.example.demo.kafka;
//
//import com.example.demo.dto.StockDto;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import feign.Headers;
//import org.apache.kafka.common.errors.SerializationException;
//import org.apache.kafka.common.serialization.Deserializer;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.reflect.Type;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//public class CustomDeserializer implements Deserializer<List<StockDto>> {
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//    }
//
//    @Override
//    public List<StockDto> deserialize(String topic, byte[] data) {
//        try {
//            if (data == null){
//                System.out.println("Null received at deserializing");
//                return null;
//            }
//            System.out.println("Deserializing...");
//            return objectMapper.readValue(new String(data, "UTF-8"), new TypeReference<List<StockDto>>() {
//                @Override
//                public Type getType() {
//                    return super.getType();
//                }
//            });
//        } catch (Exception e) {
//            throw new SerializationException("Error when deserializing byte[] to StockDto");
//        }
//    }
//
//    @Override
//    public void close() {
//    }
//}
