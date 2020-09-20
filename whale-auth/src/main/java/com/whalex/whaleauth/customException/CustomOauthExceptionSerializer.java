package com.whalex.whaleauth.customException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/**
 * Description: 自定义异常转换类
 *
 * @author: 🐋鲸鱼
 * date: 2020/8/7 22:42
 */
public class CustomOauthExceptionSerializer extends StdSerializer<CustomOauthException> {
    public CustomOauthExceptionSerializer() {
        super(CustomOauthException.class);
    }

    @Override
    public void serialize(CustomOauthException value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        gen.writeStartObject();
        gen.writeNumberField("code", value.getCode());
        gen.writeStringField("error_description", value.getMessage());
        gen.writeStringField("error", Optional.ofNullable(value.getOAuth2ErrorCode()).orElse("error"));

        if (value.getAdditionalInformation()!=null) {
            for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                gen.writeStringField(key, add);
            }
        }

        gen.writeEndObject();
    }
}
