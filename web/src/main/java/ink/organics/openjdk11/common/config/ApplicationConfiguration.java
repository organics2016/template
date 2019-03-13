package ink.organics.openjdk11.common.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import ink.organics.openjdk11.common.utils.DateUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class ApplicationConfiguration {


    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // 过滤空属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // setter 失败不抛出异常
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        // 允许出现特殊字符和转义符
//        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
//        // 允许出现单引号
//        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateUtils.sf));
        timeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateUtils.sf));
        timeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateUtils.stf));
        timeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateUtils.stf));
        timeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateUtils.tf));
        timeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateUtils.tf));

        objectMapper.registerModule(timeModule);

        return objectMapper;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate = builder.build();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
}
