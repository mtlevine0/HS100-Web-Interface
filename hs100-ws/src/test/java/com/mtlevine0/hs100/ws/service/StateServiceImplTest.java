package com.mtlevine0.hs100.ws.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.mtlevine0.hs100.ws.model.HS100Device;
import com.mtlevine0.hs100.ws.repository.DeviceDao;

import net.insxnity.hs100.HS100;

@RunWith(MockitoJUnitRunner.class)
public class StateServiceImplTest {
	
	@InjectMocks
	private StateServiceImpl stateServiceImpl;
	
	@Mock
	private DeviceDao deviceDao;
	
	@Mock
	private HS100 hs100;
	
	@Before
	public void setup() throws IOException {		
		// given
		HS100Device officeLightDevice = new HS100Device("Office Light", "192.168.1.103", HS100Device.State.UNKNOWN);
		HS100Device boxFanDevice = new HS100Device("Box Fan", "192.168.1.124", HS100Device.State.UNKNOWN);
		
		officeLightDevice.setId(0l);
		boxFanDevice.setId(1l);
		
		List<HS100Device> deviceList = new ArrayList<HS100Device>();
		deviceList.add(officeLightDevice);
		deviceList.add(boxFanDevice);
				
		Mockito.when(deviceDao.findAll()).thenReturn(deviceList);
		Mockito.doReturn(true).when(hs100).isOn();

	}
	
	@Test
	public void whenDevicesInRepository_thenDevicesReturnIsOn() throws IOException {
		// when
		List<HS100Device> deviceList = stateServiceImpl.getAllState();

		// then
		assertThat(deviceList.get(0).getState(), is(equalTo(HS100Device.State.ON)));
		assertThat(deviceList.get(1).getState(), is(equalTo(HS100Device.State.ON)));

	}
}
