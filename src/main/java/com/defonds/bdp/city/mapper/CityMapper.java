/**
 * File Name：CityMapper.java
 *
 * Copyright Defonds Corporation 2015 
 * All Rights Reserved
 *
 */
package com.defonds.bdp.city.mapper;

import java.util.List;

import com.defonds.bdp.city.bean.City;

/**
 * 
 * Project Name：bdp 
 * Type Name：CityMapper 
 * Type Description： 
 * Author：Defonds 
 * Create Date：2015-08-31
 * 
 * @version
 * 
 */
public interface CityMapper {
	// C
	public void insertCity(City city); // 插入一条城市记录

	// R
	public List<City> provinceCities(String province); // 根据省份名称返回该省份下的所有城市列表

	// R
	public City searchCity(String city_code); // 根据 city_code 查询城市信息
	
	// U
	public void renameCity(City city); // 根据 city_code，city_name 重命名城市信息
	
	// D
	public void deleteCity(String city_code); // 根据 city_code 删除城市
}
