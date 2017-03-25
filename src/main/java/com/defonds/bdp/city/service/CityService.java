/**
 * File Name：CityService.java
 *
 * Copyright Defonds Corporation 2015 
 * All Rights Reserved
 *
 */
package com.defonds.bdp.city.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.defonds.bdp.city.bean.City;
import com.defonds.bdp.city.mapper.CityMapper;

/**
 * 
 * Project Name：bdp
 * Type Name：CityService
 * Type Description：
 * Author：Defonds
 * Create Date：2015-08-31
 * @version 
 * 
 */
@Service
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public class CityService { 
	private final Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private CityMapper cityMapper;
	
	/*
	 * @CacheEvict:value:缓存名称;
	 * allEntries:是否清空所有缓存内容，缺省为 false，如果指定为 true，则方法调用后将立即清空所有缓存.
	 */
	/**
	 * C<p>
	 * CRUD (Create 创建，Retrieve 读取，Update 更新，Delete 删除) 操作中，
	 * 除了 R 具备幂等性，其他三个发生的时候都可能会造成缓存结果和数据库不一致。<br/>
	 * 为了保证缓存数据的一致性，在进行 CUD 操作的时候我们需要对可能影响到的缓存进行更新或者清除。<br/>
	 * <p>
	 * @param city_code 城市代码
	 * @param city_jb 城市级别
	 * @param province_code 省代码
	 * @param city_name 城市名称
	 * @param city 所在地级市名称
	 * @param province 所在省份名称
	 */
	@CacheEvict(value = { "provinceCities"}, allEntries = true)
	public void insertCity(String city_code, String city_jb, 
			String province_code, String city_name,
			String city, String province) {
		City cityBean = new City();
		cityBean.setCityCode(city_code);
		cityBean.setCityJb(city_jb);
		cityBean.setProvinceCode(province_code);
		cityBean.setCityName(city_name);
		cityBean.setCity(city);
		cityBean.setProvince(province);
		this.cityMapper.insertCity(cityBean);
	}
	
	// R
	// @Cacheable 的作用主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
	@Cacheable("provinceCities")
	public List<City> provinceCities(String province) {
		logger.debug("province=" + province);
		return this.cityMapper.provinceCities(province);
	}
	
	// R
	@Cacheable("searchCity")
	public City searchCity(String city_code){
		logger.debug("city_code=" + city_code);
		return this.cityMapper.searchCity(city_code);	
	}
	
	// U
	@CacheEvict(value = { "provinceCities", "searchCity" }, allEntries = true)
	public int renameCity(String city_code, String city_name) {
		City city = new City();
		city.setCityCode(city_code);
		city.setCityName(city_name);
		this.cityMapper.renameCity(city);
		return 1;
	}
	
	// D
	@CacheEvict(value = { "provinceCities", "searchCity" }, allEntries = true)
	public int deleteCity(String city_code) {
		this.cityMapper.deleteCity(city_code);
		return 1;
	}
}