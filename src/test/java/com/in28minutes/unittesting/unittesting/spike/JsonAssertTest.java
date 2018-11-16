package com.in28minutes.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    
    String actualResponse = "{\"quantity\":100,\"price\":10,\"name\":\"Ball\",\"id\":1}";
    
    @Test
    public void jsonAssert_StritctTrue_ExactMatchExceptForSpaces() throws JSONException{
        String expectedResponse = "{\"quantity\":100,\"price\":10, \"name\":\"Ball\" ,\"id\":1}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }
    
    @Test
    public void jsonAssert_StritctFalse() throws JSONException{
        String expectedResponse = "{\"quantity\":100,\"price\":10, \"name\":\"Ball\" ,\"id\":1}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
    
    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException{
        String expectedResponse = "{quantity:100,price:10, \"name\":\"Ball 2\" ,id:1}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }
    
}
