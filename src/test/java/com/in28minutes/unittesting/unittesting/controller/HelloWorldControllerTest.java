package com.in28minutes.unittesting.unittesting.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.unittesting.unittesting.HelloWorlController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorlController.class)
public class HelloWorldControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void helloWorld_basic() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON_VALUE);
        MvcResult result = mockMvc.perform(request).andReturn();
        
        assertEquals("Hello World", result.getResponse().getContentAsString());
        
    }
    
}
