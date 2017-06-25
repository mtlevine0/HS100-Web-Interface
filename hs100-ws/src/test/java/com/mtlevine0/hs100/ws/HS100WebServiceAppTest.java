package com.mtlevine0.hs100.ws;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mtlevine0.hs100.ws.controller.DeviceController;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class HS100WebServiceAppTest {
	
	@Autowired
	private DeviceController deviceController;

	@Test
	public void contextLoads() throws Exception {
        assertThat(deviceController).isNotNull();
	}

}
