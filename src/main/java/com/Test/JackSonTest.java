package com.Test;

import com.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class JackSonTest {
    @Test
    public void test() throws Exception {
        User user = new User();
        user.setId(18);
        user.setName("ÕÅÈý");
        user.setPassword("123456");
        ObjectMapper json = new ObjectMapper();
        String s = json.writeValueAsString(user);
        System.out.println(s);
        json.writeValue(new FileWriter("J:\\a.json"),user);

        User user1 = json.readValue(new FileReader("J:\\a.json"), User.class);
        System.out.println(user1);
    }
}
