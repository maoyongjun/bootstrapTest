package org.foxconn.bootstrapTest.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootStrapServices {
	
	@GetMapping(value="/test")
	public Map<String,String> getPage(){
		Map<String,String> result = new HashMap<String,String>();
		result.put("test","testvalue");
		return result;
	}
}
