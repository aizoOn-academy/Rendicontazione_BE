package com.aizoon.rendicontazione.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MultiValueMap;

import java.io.UnsupportedEncodingException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public abstract class AbstractControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    protected ResultActions post(String uri, Object body, MultiValueMap<String, String> params, Object... uriVars) throws Exception {
        var retVal = MockMvcRequestBuilders.post(uri, uriVars);
        return perform(body, params, retVal);
    }

    protected ResultActions put(String uri, Object body, MultiValueMap<String, String> params, Object... uriVars) throws Exception {
        var retVal = MockMvcRequestBuilders.put(uri, uriVars);
        return perform(body, params, retVal);
    }

    protected ResultActions get(String uri, MultiValueMap<String, String> params, Object... uriVars) throws Exception {
        var retVal = MockMvcRequestBuilders.get(uri, uriVars);
        return perform(null, params, retVal);
    }

    protected <T> ResultActions delete(String uri, MultiValueMap<String, String> params, Object... uriVars) throws Exception {
        var retVal = MockMvcRequestBuilders.delete(uri, uriVars);
        return perform(null, params, retVal);
    }

    private ResultActions perform(Object body,
                                  MultiValueMap<String, String> params, MockHttpServletRequestBuilder retVal) throws Exception {
        retVal.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        if (body != null) {
            retVal.content(convertToJson(body));
        }
        if (params != null) {
            retVal.params(params);
        }
        return mockMvc.perform(retVal);
    }

    protected String convertToJson(final Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected <T> T fromJson(MvcResult content, Class<T> clazz) {
        try {
            return mapper.readValue(content.getResponse().getContentAsString(), clazz);
        } catch (JsonProcessingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
