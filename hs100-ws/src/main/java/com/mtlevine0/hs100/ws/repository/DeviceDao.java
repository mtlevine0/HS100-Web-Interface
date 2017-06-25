package com.mtlevine0.hs100.ws.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.mtlevine0.hs100.ws.model.HS100Device;

@Transactional
public interface DeviceDao extends CrudRepository<HS100Device, Long>{

}
