package com.mtlevine0.hs100.ws.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mtlevine0.hs100.ws.model.HS100Device;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DeviceDaoTest {

	@Autowired
	private DeviceDao deviceDao;
	
	List<HS100Device> deviceList = new ArrayList<HS100Device>();
	
	@Before
	public void deviceDaoTestSetup() {
		// given
		HS100Device device = new HS100Device("Test Device1", "192.168.1.103", HS100Device.State.UNKNOWN);
		deviceList.add(deviceDao.save(device));
		
		device = new HS100Device("Test Device2", "192.168.1.124", HS100Device.State.UNKNOWN);
		deviceList.add(deviceDao.save(device));
	}
	
	@Test
	public void whenFindById_thenReturnDevice() {
		// when
		HS100Device found = deviceDao.findOne(deviceList.get(0).getId());
		
		// then
		assertThat(found.getId(), is(equalTo(deviceList.get(0).getId())));
	}
	
	@Test
	public void whenFindAll_thenReturnDevices() {
		// when
		ArrayList<HS100Device> devicecListFound = (ArrayList<HS100Device>) deviceDao.findAll();
		
		// then
		assertThat(devicecListFound.get(0).getId(), is(equalTo(deviceList.get(0).getId())));
		assertThat(devicecListFound.get(1).getId(), is(equalTo(deviceList.get(1).getId())));
	}
	
	@Test
	public void whenRemoveById_thenReturnNull() {
		// when
		deviceDao.delete(deviceList.get(0).getId());
		
		// then
		HS100Device device = deviceDao.findOne(deviceList.get(0).getId());
		assertThat(null, is(equalTo(device)));
	}
}
