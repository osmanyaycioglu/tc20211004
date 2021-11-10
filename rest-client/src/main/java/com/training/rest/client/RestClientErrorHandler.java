package com.training.rest.client;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class RestClientErrorHandler implements ErrorDecoder {

    @Override
    public RestClientExp decode(final String methodKeyParam,
                                final Response responseParam) {
        try {
            InputStream asInputStreamLoc = responseParam.body()
                                                        .asInputStream();
            ObjectMapper mapperLoc = new ObjectMapper();
            ErrorObj readValueLoc = mapperLoc.readValue(asInputStreamLoc,
                                                        ErrorObj.class);
            return new RestClientExp(readValueLoc);
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
        return null;
    }

}
