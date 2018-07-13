package org.foxconn.bootstrapTest.service;

import java.util.ArrayList;
import java.util.List;

import org.foxconn.bootstrapTest.entity.TestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BootStrapServices {
	Logger logger = LoggerFactory.getLogger(BootStrapServices.class);
	@GetMapping(value="/test")
	public List<TestModel> getPage(){
		TestModel model = new TestModel();
		List<TestModel> list = new ArrayList<TestModel>();
		model.setCategory("cate1");
		model.setName("name1");
		model.setPartno("partno1");
		model.setWorkoderno("wo1");
		list.add(model);
		model = new TestModel();
		model.setCategory("cate2");
		model.setName("name2");
		model.setPartno("partno2");
		model.setWorkoderno("wo2");
		list.add(model);
		model = new TestModel();
		model.setCategory("cate3");
		model.setName("name3");
		model.setPartno("partno3");
		model.setWorkoderno("wo3");
		list.add(model);
		logger.info(list.toString());
		return list;
	}
}
