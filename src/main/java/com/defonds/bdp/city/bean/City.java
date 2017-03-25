/**
 * File Name：City.java
 *
 * Copyright Defonds Corporation 2015 
 * All Rights Reserved
 *
 */
package com.defonds.bdp.city.bean;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * 
 * Project Name：bdp
 * Type Name：City
 * Type Description：
 * 		1. annotation @JsonSerialize, Entity serialized to json
 * 		2. annotation @JsonNaming, convert Higher case to under score 
 * 			and Lower case, example: cityCode, 
 * 			after json naming convert, will be city_code
 * Author：Defonds
 * Create Date：2015-08-28
 * @version 
 * 
 */
@JsonSerialize
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)  
public class City implements Serializable {
	private static final long serialVersionUID = -1484544039225196235L;
	private String id;
	private String cityCode;
	private String provinceCode;
	private String cityName;
	private String cityJb;
	private String city;
	private String province;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityJb() {
		return cityJb;
	}
	public void setCityJb(String cityJb) {
		this.cityJb = cityJb;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
}