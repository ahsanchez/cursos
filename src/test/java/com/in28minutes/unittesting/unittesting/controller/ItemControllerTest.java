package com.in28minutes.unittesting.unittesting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.unittesting.unittesting.ItemController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void dummyItem_basic() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON_VALUE);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"quantity\":100,\"price\":10,\"name\":\"Ball\",\"id\":1}"))
                .andReturn();
    }
    
}
