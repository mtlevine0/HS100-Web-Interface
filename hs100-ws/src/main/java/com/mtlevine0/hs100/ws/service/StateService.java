package com.mtlevine0.hs100.ws.service;

import java.io.IOException;
import java.util.List;

import com.mtlevine0.hs100.ws.model.HS100Device;

public interface StateService {

	public List<HS100Device> getAllState() throws IOException;
	
	public List<HS100Device> setState(List<HS100Device> deviceList) throws IOException;
	
	public HS100Device getState(long id) throws IOException;
	
}
