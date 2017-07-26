package com.spring.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class City {
	private String cityname;
	private String location="Earth";
	private double latitude;
	private double longitude;
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public HashMap getCity(){
		HashMap rt = new HashMap<String,Object>();
		Field[] declaredFields = this.getClass().getDeclaredFields();
		City ci  = this;
		try {
        for (Field field : declaredFields) {  
            field.setAccessible(true);  
            //过滤内容为空的  
            
			if (field.get(ci) == null) {  
			    continue;  
			}
			
			rt.put(field.getName(), field.get(ci));
			 System.out.println(field.getName()+":"+field.get(ci).toString());			
          
        }  
		} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		return rt;
	}
	
}
