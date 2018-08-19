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

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder.BorderSide;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	@PostMapping(path = "/file/upload", consumes = "multipart/form-data")
	public String getFile(@RequestParam("fileName") MultipartFile file) {
		System.out.println(file);
	    if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        
        String path = "d:/test" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "true";
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
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
		List<HddModel> hdds = new ArrayList<HddModel>();
		hdds.add(hdd);
		system.setHdd(hdds);
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
	private CellStyle createCellStyle;

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
		StringBuffer sb = new StringBuffer("");
		String str = "";
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
//		System.out.println(sb);
//		Map map = (Map) JSON.parse(sb.toString());
//		System.out.println(map);
		str= sb.toString().replace("/t", "");
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
		Sheet sheet = wb.createSheet(String.valueOf(0));
		wb.setSheetName(0, "整機部件驗收清單");
//		CellStyle cellStyle =  wb.createCellStyle();
//		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
//		cellStyle.setBorderBottom(CellStyle.BORDER_DASHED);
		String[] headers = new String[]{"采购单号","服务器固资号","服务器SN号","厂商","机型","设备类型"
				,"版本","部件类型","部件原厂PN（支持采集的为OS采集PN)","部件原厂SN （支持采集的为OS采集SN）"
				,"部件FW版本"};
		Row row = sheet.createRow(0);
		Font createFont = wb.createFont();
		createCellStyle = wb.createCellStyle();
		createFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		createCellStyle.setFont(createFont);
		createCellStyle.setWrapText(true);//
		createCellStyle.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
		createCellStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
		createCellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		createCellStyle.setBorderRight(CellStyle.BORDER_THIN);
		createCellStyle.setBorderTop(CellStyle.BORDER_THIN);
		createCellStyle.setFillBackgroundColor(CellStyle.SOLID_FOREGROUND);
		CellStyle createCellStyle2 = wb.createCellStyle();
		createCellStyle2.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
		createCellStyle2.setBorderBottom(CellStyle.BORDER_THIN);
		createCellStyle2.setBorderLeft(CellStyle.BORDER_THIN);
		createCellStyle2.setBorderRight(CellStyle.BORDER_THIN);
		createCellStyle2.setBorderTop(CellStyle.BORDER_THIN);
		
		CellStyle createCellStyle3 = wb.createCellStyle();
		createCellStyle3.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
		createCellStyle3.setBorderBottom(CellStyle.BORDER_THIN);
		createCellStyle3.setBorderLeft(CellStyle.BORDER_THIN);
		createCellStyle3.setBorderRight(CellStyle.BORDER_THIN);
		createCellStyle3.setBorderTop(CellStyle.BORDER_THIN);
		createCellStyle3.setFillForegroundColor(HSSFColor.YELLOW.index);
	    //solid 填充  foreground  前景色
		createCellStyle3.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	    
		for(int i=0;i<headers.length;i++){
			Cell cell0 = row.createCell(i);
			cell0.setCellType(XSSFCell.CELL_TYPE_STRING);// 文本格式
			cell0.setCellValue(headers[i]);// 写入内容
			cell0.setCellStyle(createCellStyle);
			if(i<5){
				sheet.setColumnWidth(i,4000);
			}else{
				sheet.setColumnWidth(i,8000);
			}
		}
//		createFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		int index =1;
		for (int j = 0; j < systems.size(); j++) {
			System.out.println(systems.get(j).toString());
			SystemModel system = systems.get(j);
			ls = system.getComponent();
			
			int width = 0;
			System.out.println(ls);
			ArrayList<String[]> ls2 =null;
			if(ls!=null) {
				ls2 = (ArrayList<String[]>) ToStringArrayUtil.toStringArray(ls);
				
			}
			
			for (int i = 0; i < ls2.size(); i++) {
				row = sheet.createRow(index+i);
				
				if(i==0){
					String[] snmaster = new String[]{"POGO2018***","TYSV180404**",system.getSn(),"FOXCONN","RM760-FX","SC3-10G","6.0.0.10"};
					for(int k=0;k<snmaster.length;k++){
						Cell cell0 = row.createCell(k);
						cell0.setCellType(XSSFCell.CELL_TYPE_STRING);// 文本格式
						cell0.setCellValue(snmaster[k]);// 写入内容
						if(k<=3){
							cell0.setCellStyle(createCellStyle2);
						}else{
							cell0.setCellStyle(createCellStyle3);
							
						}
					}
				}else{
					String[] snmaster = new String[]{"","","","","","",""};
					for(int k=0;k<snmaster.length;k++){
						Cell cell0 = row.createCell(k);
						cell0.setCellType(XSSFCell.CELL_TYPE_STRING);// 文本格式
						cell0.setCellValue(snmaster[k]);// 写入内容
						cell0.setCellStyle(createCellStyle2);
					}
				}
				
				String[] s = ls2.get(i);
				for (int cols = 0; cols < s.length; cols++) {
					Cell cell = row.createCell(cols + 7);
					cell.setCellType(XSSFCell.CELL_TYPE_STRING);// 文本格式
					cell.setCellStyle(createCellStyle2);
					XSSFCellBorder border = new XSSFCellBorder();
					border.setBorderStyle(BorderSide.TOP,BorderStyle.MEDIUM);
//					StylesTable table = new StylesTable();
//					CellStyle style = table.createCellStyle();
//					style.setBorderTop((short)6);
//					cell.setCellStyle(style);
//					if (null != s[cols]) {
//						sheet.setColumnWidth(cols, ((width=s[cols].length())<6?6:width)*384); //设置单元格宽度  
//					}
					cell.setCellValue(s[cols]);// 写入内容
				}
			}
			index+=ls2.size();

		}
		try {
			if (null != output) {
				wb.write(output);
				output.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<SystemModel> getSystemModel() throws IOException{
		
		List<SystemModel> systems = new ArrayList<SystemModel>();
		String json = getJSON("D:\\git\\bootstrapTest\\src\\main\\resources\\7CE829P6TL.json");
		SystemModel system = null;
		Result result = JSON.parseObject(json, Result.class);
		if(result!=null){
			system = result.getSystem();
		}
		if(system!=null){
			systems.add(system);
		}
		json = getJSON("D:\\git\\bootstrapTest\\src\\main\\resources\\7CE830P1N7.json");
		result= new Result();
		result = JSON.parseObject(json, Result.class);
		if(result!=null){
			system = result.getSystem();
		}
		if(system!=null){
			systems.add(system);
		}
		return systems;
	}
}
