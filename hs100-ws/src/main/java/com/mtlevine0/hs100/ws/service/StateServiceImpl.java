package com.mtlevine0.hs100.ws.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtlevine0.hs100.ws.model.HS100Device;
import com.mtlevine0.hs100.ws.repository.DeviceDao;

import net.insxnity.hs100.HS100;

@Component
public class StateServiceImpl implements StateService {
	
	@Autowired
	DeviceDao deviceDao;

	public List<HS100Device> getAllState() throws IOException {
		List<HS100Device> deviceList = (List<HS100Device>) deviceDao.findAll();
		for(HS100Device device : deviceList) {
			HS100 plug = new HS100(device.getIp());	
			device.setState(plug.isOn() ? HS100Device.State.ON : HS100Device.State.OFF);
		}
		return deviceList;
	}

	public List<HS100Device> setState(List<HS100Device> deviceList) throws IOException {
		for(HS100Device device : deviceList) {
			HS100 plug = new HS100(device.getIp());
			if(device.getState() == HS100Device.State.ON) {
				plug.switchOn();
			} else {
				plug.switchOff();
			}
		}	
		return deviceList;
	}
	
	public HS100Device getState(long id) throws IOException {
		HS100Device device = deviceDao.findOne(id);
		HS100 plug = new HS100(device.getIp());	
		device.setState(plug.isOn() ? HS100Device.State.ON : HS100Device.State.OFF);
		return device;
	}
	
}
