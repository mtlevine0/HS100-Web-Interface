package com.mtlevine0.hs100.ws.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mtlevine0.hs100.ws.model.HS100Device;
import com.mtlevine0.hs100.ws.repository.DeviceDao;

import net.insxnity.hs100.HS100;

@RunWith(SpringRunner.class)
public class StateServiceImplTest {

	@TestConfiguration
	static class StateServiceImplTestContextConfiguration {
		
		@Bean
		public StateService stateService() {
			return new StateServiceImpl();
		}
	}
	
	@Autowired
	private StateService stateService;
	
	@MockBean
	private DeviceDao deviceDao;
	
//	@MockBean
//	private List<HS100> hs100List;
	
	@Before
	public void setup() throws IOException {
		HS100Device device = new HS100Device("Test Device", "192.168.1.103", HS100Device.State.UNKNOWN);
		
		System.out.println("DEVICE ID: " + device.getId());
		
		Mockito.when(deviceDao.findOne(device.getId())).thenReturn(device);
		
//		Mockito.when(hs100.isOn()).thenReturn(true);

	}
	
	@Test
	public void whenValidId_thenDevicesShouldBeFound() {
		long id = 0;
		
		HS100Device found = deviceDao.findOne(id);
		
		assertThat(found.getId(), is(equalTo(id)));

	}
}
