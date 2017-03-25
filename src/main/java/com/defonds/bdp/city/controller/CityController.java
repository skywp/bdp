/**
 * File Name：CityController.java
 *
 * Copyright Defonds Corporation 2015 
 * All Rights Reserved
 *
 */
package com.defonds.bdp.city.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.defonds.bdp.city.service.CityService;

/**
 * 
 * Project Name：bdp
 * Type Name：CityController
 * Type Description：
 * Author：Defonds
 * Create Date：2015-08-27
 * @version 
 * 
 */
@Controller
@RequestMapping("/city")
public class CityController {
	private final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private CityService cityService;
	
	
	@RequestMapping("/create")
	@ResponseBody
	public Integer create(@RequestParam(value="city_code", defaultValue="") String city_code,
			@RequestParam(value="city_jb", defaultValue="") String city_jb,
			@RequestParam(value="province_code", defaultValue="") String province_code,
			@RequestParam(value="city_name", defaultValue="") String city_name,
			@RequestParam(value="city", defaultValue="") String city,
			@RequestParam(value="province", defaultValue="") String province) {
		logger.debug(city_name);
		this.cityService.insertCity(city_code, city_jb, province_code, city_name, city, province);
		return 1;
	}
	
	// R
	@RequestMapping("/province/cities")
	@ResponseBody
	public Object provinceCities(@RequestParam(value="province", defaultValue="") String province) {
		logger.debug("province=" + province);
		return this.cityService.provinceCities(province);
	}
	
	// R
	@RequestMapping("/search")
	@ResponseBody
	public Object searchCity(@RequestParam(value="city_code", defaultValue="") String city_code){
		logger.debug("city_code=" + city_code);
		return this.cityService.searchCity(city_code);
	}
	
	// U
	@RequestMapping("/rename")
	@ResponseBody
	public Object renameCity(@RequestParam(value="city_code", defaultValue="") String city_code,
			@RequestParam(value="city_name", defaultValue="") String city_name){
		logger.debug(city_name);
		return this.cityService.renameCity(city_code, city_name);
	}
	
	// D
	@RequestMapping("/destroy")
	@ResponseBody
	public Object deleteCity(@RequestParam(value="city_code", defaultValue="") String city_code){
		return this.cityService.deleteCity(city_code);
	}
	
}