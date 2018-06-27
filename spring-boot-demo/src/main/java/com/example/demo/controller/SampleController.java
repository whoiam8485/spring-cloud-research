package com.example.demo.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.vo.Skiploss;
import com.example.demo.vo.Skiploss.Data;
import com.example.demo.vo.Skiploss.Lat;
import com.example.demo.vo.Skiploss.Lon;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Mock VHA 的skiploss接口
 * 
 * @author gshen
 *
 */
@Controller
public class SampleController {

	/**
	 * 
	 */
	private static Map<String, List<Skiploss>> lonlatCache = Maps.newHashMap();
	
	static {
		generateLonLatByVin(116.397428, 39.90923, "RDCNNTG55TEST0001");
		
		generateLonLatByVin(116.397528, 39.95923, "RDCNNTG55TEST0002");

		generateLonLatByVin(116.497528, 39.96923, "RDCNNTG55TEST0003");

		generateLonLatByVin(116.597528, 39.96923, "RDCNNTG55TEST0004");

		generateLonLatByVin(116.598528, 39.99923, "RDCNNTG55TEST0005");
		
		generateLonLatByVin(116.597928, 39.98823, "RDCNNTG55TEST0006");

	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/service/vehicles/{vin}/skiploss", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	Skiploss skiploss(@PathVariable("vin") String vin) {

		Skiploss result = new Skiploss();
		List<Skiploss> dataList = lonlatCache.get(vin);
		if (dataList != null && !dataList.isEmpty()) {
			result = dataList.remove(0);
		}

		return result;
	}

	
	/**
	 * 
	 * @param lngX
	 * @param latY
	 * @param vin
	 */
	private static void generateLonLatByVin(double lngX, double latY, String vin) {

		List<Skiploss> lineArray = Lists.newArrayList();
		for (int i = 1; i < 15; i++) {
			lngX = lngX + Math.random() * 0.05;
			if (i % 2 == 0) {
				latY = latY + Math.random() * 0.0001;
			} else {
				latY = latY + Math.random() * 0.06;
			}

			Skiploss skiploss = new Skiploss();
			Lat lat = new Skiploss.Lat();
			lat.setValue(latY);

			Lon lon = new Lon();
			lon.setValue(lngX);
			Data data = new Skiploss.Data();

			data.setPositionlat(lat);
			data.setPositionlong(lon);
			skiploss.setData(data);
			lineArray.add(skiploss);
		}

		lonlatCache.put(vin, lineArray);

	}
	
	
   public static void main(String[] args) throws Exception  {
		
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("type", "alarm");
		data.put("city_code", "341181");
		
       StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));  
       RestTemplate restTemplate = new RestTemplateBuilder().additionalMessageConverters(m).build();  
		ResponseEntity<String> s = restTemplate.postForEntity("http://readearth2014.vicp.cc:8081/EZPShare/EZPService.svc/GetEZPInterFace", "type=boundingBoxWeather&LSTs='2017/12/12 10:10:11'&&city_codes=310114", String.class);
		System.out.println(s.getBody());

	}

}