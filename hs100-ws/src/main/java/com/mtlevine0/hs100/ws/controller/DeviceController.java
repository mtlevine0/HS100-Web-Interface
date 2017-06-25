package com.mtlevine0.hs100.ws.controller;

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
import com.mtlevine0.hs100.ws.repository.DeviceDao;

import net.insxnity.hs100.HS100;

@RestController
@RequestMapping("api/v1/")
public class DeviceController  {

	@Autowired
	private DeviceDao deviceDao;
	
	@RequestMapping(value = "Devices", method = RequestMethod.GET)
	public ResponseEntity<List<HS100Device>> findAll() {
		return new ResponseEntity<List<HS100Device>>((List<HS100Device>) deviceDao.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "Devices", method = RequestMethod.POST)
	public ResponseEntity<HS100Device> create(@RequestBody HS100Device deviceRequest) {
		HS100 device = new HS100(deviceRequest.getIp());
		if(!device.isPresent()){
			return new ResponseEntity<HS100Device>(deviceRequest, HttpStatus.PRECONDITION_FAILED);		
		}
		return new ResponseEntity<HS100Device>(deviceDao.save(deviceRequest), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "Devices/{id}", method = RequestMethod.GET)
	public ResponseEntity<HS100Device> get(@PathVariable Long id) {
		return new ResponseEntity<HS100Device>(deviceDao.findOne(id), HttpStatus.OK);
	}
	
//	@RequestMapping(value = "Devices/{id}", method = RequestMethod.PUT)
//	public HS100Device update(@PathVariable Long id, @RequestBody HS100Device device) {
////		return deviceDao.update(id, Sensor);
//		return null;
//	}
	
	@RequestMapping(value = "Devices/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HS100Device> delete(@PathVariable Long id) {
		HS100Device device = deviceDao.findOne(id);
		deviceDao.delete(id);
		return new ResponseEntity<HS100Device>(device, HttpStatus.OK);
	}
	
}
