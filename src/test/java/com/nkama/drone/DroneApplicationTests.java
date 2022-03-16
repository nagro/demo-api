package com.nkama.drone;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DroneApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetDrones() throws Exception {
        mockMvc.perform(get("/drones"))
            .andExpect(status().isOk());
            //.andExpect(jsonPath("$[0].batteryCapacity", is("10.15")));
    }

}
