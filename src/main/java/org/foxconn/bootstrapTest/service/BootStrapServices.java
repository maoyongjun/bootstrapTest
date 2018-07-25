package org.foxconn.bootstrapTest.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.foxconn.bootstrapTest.dao.LabelDao;
import org.foxconn.bootstrapTest.entity.BoardModel;
import org.foxconn.bootstrapTest.entity.Component;
import org.foxconn.bootstrapTest.entity.CpuModel;
import org.foxconn.bootstrapTest.entity.HddModel;
import org.foxconn.bootstrapTest.entity.LabelEntity;
import org.foxconn.bootstrapTest.entity.MemoryModel;
import org.foxconn.bootstrapTest.entity.Msg;
import org.foxconn.bootstrapTest.entity.NicModel;
import org.foxconn.bootstrapTest.entity.PsuModel;
import org.foxconn.bootstrapTest.entity.Result;
import org.foxconn.bootstrapTest.entity.SystemModel;
import org.foxconn.bootstrapTest.entity.User;
import org.foxconn.bootstrapTest.util.ExcleExportUtil;
import org.foxconn.bootstrapTest.util.ToStringArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

@RestController
public class BootStrapServices {
	Logger logger = LoggerFactory.getLogger(BootStrapServices.class);
	@Resource
	LabelDao labelDao;

	@PostMapping(path = "/test1", consumes = "application/json")
	public void getJson(@RequestBody Result system) {
		System.out.println(system);
	}

	@PostMapping(path = "/test2", consumes = "application/json")
	public void getJsonStr(@RequestBody String system) {
		System.out.println(system);
		Result result = JSON.parseObject(system, Result.class);
		System.out.println(result);
	}

	@PostMapping(path = "/test4", consumes = "application/json")
	public void getJsonStrs(@RequestBody String user) {
		System.out.println(user);
	}

	@PostMapping(path = "/label/add", consumes = "application/json", produces = "application/json")
	public Msg addLabel(@RequestBody LabelEntity label) {
		labelDao.addLabel(label);
		Msg msg = new Msg();
		msg.setMsg("OK");
		return msg;
	}

	@PostMapping(path = "/label/addList", consumes = "application/json", produces = "application/json")
	public Msg addLabelList(@RequestBody List<LabelEntity> label) {
		for (LabelEntity e : label) {
			labelDao.addLabel(e);
		}
		Msg msg = new Msg();
		msg.setMsg("OK");
		return msg;
	}

	@PostMapping(path = "/label/update", consumes = "application/json")
	public void updateLabel(@RequestBody LabelEntity label) {
		labelDao.updateLabel(label);
	}

	@PostMapping(path = "/label/delete", consumes = "application/json", produces = "application/json")
	public Msg deleteLabel(@RequestBody LabelEntity label) {
		labelDao.deleteLabel(label);
		Msg msg = new Msg();
		msg.setMsg("OK");
		return msg;
	}

	@GetMapping(path = "/label/query", produces = "application/json")
	public List<LabelEntity> queryLabel(LabelEntity label) {
		System.out.println(label);
		List<LabelEntity> list = labelDao.findAll(label);

		return list;
	}

	@GetMapping(value = "/test3")
	public List<User> getjson() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setId("1");
		user.setName("张三");
		user.setSex("男");
		user.setTime("2017-08-09");
		users.add(user);
		user = new User();
		user.setId("1");
		user.setName("李四");
		user.setSex("男");
		user.setTime("2017-08-10");
		users.add(user);
		return users;
	}

	@GetMapping(value = "/test")
	public Result getPage() {
		SystemModel system = new SystemModel();
		system.setPn("RM760-FX");
		system.setSn("7CE821P5CX");
		BoardModel board = new BoardModel();
		board.setPn("T-Twins");
		board.setSn("02012EW00T0BAU05P");
		board.setFw("BMC:1.1;BIOS:2.2");
		system.setBoard(board);
		CpuModel cpu = new CpuModel();
		cpu.setPn("Intel(R)Xeon(R)Gold6148CPU@2.40GHz");
		cpu.setSn("54060500FFFBEBBF");
		system.setCpu(cpu);
		HddModel hdd = new HddModel();
		hdd.setSn("BTYS80550GDH480BGN");
		hdd.setPn("INTELSSDSC2KB480G7");
		system.setHdd(hdd);
		List<MemoryModel> memorys = new ArrayList<MemoryModel>();
		MemoryModel memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1E4D");
		memorys.add(memory);

		memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1AE8");
		memorys.add(memory);

		memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1BA5");
		memorys.add(memory);

		memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1B79");
		memorys.add(memory);

		memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1E4C");
		memorys.add(memory);

		memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1B72");
		memorys.add(memory);

		memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1AF1");
		memorys.add(memory);

		memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1ED4");
		memorys.add(memory);

		memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1B1E");
		memorys.add(memory);

		memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1E9C");
		memorys.add(memory);

		memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1EDA");
		memorys.add(memory);

		memory = new MemoryModel();
		memory.setPn("M393A4K40BB2-CTD");
		memory.setSn("38BD1D69");
		memorys.add(memory);

		system.setMemory(memorys);

		List<NicModel> nics = new ArrayList<NicModel>();
		NicModel nic = new NicModel();
		nic.setPn("MellanoxTechnologiesMT27710Family[ConnectX-4Lx]");
		nic.setSn("MT1814X07142");
		nic.setFw("123213213");
		nics.add(nic);

		nic = new NicModel();
		nic.setPn("MellanoxTechnologiesMT27710Family[ConnectX-4Lx]");
		nic.setSn("MT1814X07142");
		nics.add(nic);

		system.setNic(nics);

		List<PsuModel> psus = new ArrayList<PsuModel>();
		PsuModel psu = new PsuModel();
		psu.setPn("S15-550P1A");
		psu.setSn("F3181900000166");
		psus.add(psu);

		psu = new PsuModel();
		psu.setPn("S15-550P1A");
		psu.setSn("F3181900000341");
		psus.add(psu);

		system.setPsu(psus);

		Result result = new Result();
		result.setSystem(system);
		return result;
	}

	private List<ArrayList<String[]>> ls = new ArrayList<ArrayList<String[]>>();

	@GetMapping(value = "/test6")
	public Msg getExcle() {
		Msg msg = new Msg();
		msg.setMsg("OK");
		logger.debug("begin write Excle");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		String fileName = "data" + sdf.format(new Date()) + ".xlsx";
		List data = new ArrayList<>();
		Result result = getPage();
		result.getSystem();

		List<ArrayList<String[]>> ls = new ArrayList<ArrayList<String[]>>();
		ls.add((ArrayList<String[]>) ToStringArrayUtil.toStringArray(data));
		File file = new File("c:\\" + fileName);
		logger.debug("try to write Excle,sheet count:" + ls.size());
		try {
			ExcleExportUtil.write_Excel(file, (ArrayList) ls, new String[] { "data1", "data2", "data3", "data4" }, "2");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public String getJSON(String path) throws IOException {
		File file = new File(path);
		Reader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader);
		StringBuffer sb = new StringBuffer();
		String str = "";
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
//		System.out.println(sb);
//		Map map = (Map) JSON.parse(sb.toString());
//		System.out.println(map);
		return sb.toString();
	}

	public void writeExcle(List<SystemModel> systems) {
		List<Component> ls = null;
		FileOutputStream output = null;
		try {
			output = new FileOutputStream("d:\\整機部件驗收清單.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 读取的文件路径
		SXSSFWorkbook wb = new SXSSFWorkbook(10000);// 内存中保留 10000 条数据，以免内存溢出，其余写入 硬盘
		
		int index = 0;
		for (int j = 0; j < systems.size(); j++) {
			SystemModel system = systems.get(j);
			ls = system.getComponent();
			Sheet sheet = wb.createSheet(String.valueOf(0));
			int width = 0;
			wb.setSheetName(0, "整機部件驗收清單");
			ArrayList<String[]> ls2 =null;
			if(ls!=null) {
				ls2 = (ArrayList<String[]>) ToStringArrayUtil.toStringArray(ls);
			}
			
			for (int i = 0; i < ls2.size(); i++) {
				Row row = sheet.createRow(i);
				String[] s = ls2.get(i);
				if (i == index) {
					Cell cell0 = row.createCell(index);
					cell0.setCellType(XSSFCell.CELL_TYPE_STRING);// 文本格式
					cell0.setCellValue("aaaa");// 写入内容
				}
				for (int cols = 0; cols < s.length; cols++) {
					Cell cell = row.createCell(cols + 5);
					cell.setCellType(XSSFCell.CELL_TYPE_STRING);// 文本格式
					if (null != s[cols]) {
						sheet.setColumnWidth(cols, ((width=s[cols].length())<6?6:width)*384); //设置单元格宽度  
					}
					cell.setCellValue(s[cols]);// 写入内容
				}
			}
			index+=ls2.size();
			try {
				if (null != output) {
					wb.write(output);
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
