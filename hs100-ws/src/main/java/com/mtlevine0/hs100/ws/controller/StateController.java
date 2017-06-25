package com.mtlevine0.hs100.ws.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtlevine0.hs100.ws.model.HS100Device;
import com.mtlevine0.hs100.ws.service.StateServiceImpl;

@RestController
@RequestMapping("api/v1/")
public class StateController  {

	@Autowired
	private StateServiceImpl stateService;
	
	@RequestMapping(value = "State", method = RequestMethod.GET)
	public ResponseEntity<List<HS100Device>> getAllState() {
		
		List<HS100Device> deviceList = null;
		
		try {
			deviceList = stateService.getAllState();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<HS100Device>>(deviceList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "State", method = RequestMethod.POST)
	public ResponseEntity<List<HS100Device>> setState(@RequestBody List<HS100Device> deviceList) {
				
		try{
			deviceList = stateService.setState(deviceList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<HS100Device>>(deviceList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "State/{id}", method = RequestMethod.GET)
	public ResponseEntity<HS100Device> getState(@PathVariable Long id) {
		
		HS100Device device = null;
		
		try {
			device = stateService.getState(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<HS100Device>(device, HttpStatus.OK);
	}
	
//	
//	@RequestMapping(value = "State/{id}", method = RequestMethod.PUT)
//	public HS100Request setDeviceState(@PathVariable long id, @RequestBody HS100Device device) {
//		return deviceDao.update(id, device);
//	}
	
}
