package org.foxconn.bootstrapTest.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

/**
* @author:myz
* @version 1.0 
* 创建时间：2016年8月14日 下午12:26:30
*/
public class ExcleExportUtil {
	String class_path = this.getClass().getResource("").getPath(); 
	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList> ls=new ArrayList<ArrayList>();
		ArrayList<String[]> ls2=new ArrayList<String[]>();
		ls2.add(new String[]{"1","4","7"});
		ls2.add(new String[]{"2","5","8","10"});
		ls2.add(new String[]{"3","6","9"});
		ls.add(ls2);
		
		//ExcleExportUtil.write_Excel("C:\\Users\\Administrator\\Desktop\\test.xlsx", ls, new String[]{"test"}, "2");
	}
	
	 @SuppressWarnings({ "rawtypes", "unchecked" })  
	    public static void write_Excel( File xls_write_Address,ArrayList<ArrayList> ls,String[] sheetnames,String tips_cmd ) throws IOException  {  
	           
//	        PropertyConfigurator.configure(class_path+"log4j.properties");//获取 log4j 配置文件  
//	        Logger logger = Logger.getLogger(ExcleExport2.class ); //获取log4j的实例         
	        FileOutputStream output = new FileOutputStream(xls_write_Address);  //读取的文件路径   
	        SXSSFWorkbook wb = new SXSSFWorkbook(10000);//内存中保留 10000 条数据，以免内存溢出，其余写入 硬盘          
	          
	          
	        for(int sn=0;sn<ls.size();sn++){  
	            Sheet sheet = wb.createSheet(String.valueOf(sn));  
	            
	            int width=0;
	            wb.setSheetName(sn, sheetnames[sn]);     
	            ArrayList<String[]> ls2 = ls.get(sn);   
	            for(int i=0;i<ls2.size();i++){  
//	            	System.out.println(i);
	                Row row = sheet.createRow(i);  
	                String[] s = ls2.get(i);                  
	                for(int cols=0;cols<s.length;cols++){  
	                    Cell cell = row.createCell(cols);                     
	                    cell.setCellType(XSSFCell.CELL_TYPE_STRING);//文本格式                    
	                    if (null!=s[cols]) {
	                    	sheet.setColumnWidth(cols, ((width=s[cols].length())<6?6:width)*384); //设置单元格宽度  
	                    }
	                    cell.setCellValue(s[cols]);//写入内容  
	                }  
	            }              
	         }    
	        wb.write(output);  
	        output.close();           
	    }  
	 	public static void write_Excel(ArrayList<ArrayList> ls,String[] sheetnames,OutputStream output){
	 		 SXSSFWorkbook wb = new SXSSFWorkbook(10000);//内存中保留 10000 条数据，以免内存溢出，其余写入 硬盘          
		        for(int sn=0;sn<ls.size();sn++){  
		            Sheet sheet = wb.createSheet(String.valueOf(sn));  
		            int width=0;
		            wb.setSheetName(sn, sheetnames[sn]);     
		            ArrayList<String[]> ls2 = ls.get(sn);   
		            for(int i=0;i<ls2.size();i++){  
		                Row row = sheet.createRow(i);  
		                String[] s = ls2.get(i);                  
		                for(int cols=0;cols<s.length;cols++){  
		                    Cell cell = row.createCell(cols);                     
		                    cell.setCellType(XSSFCell.CELL_TYPE_STRING);//文本格式                    
		                    sheet.setColumnWidth(cols, ((width=s[cols].length())<10?20:width)*384); //设置单元格宽度  
		                    cell.setCellValue(s[cols]);//写入内容  
		                }  
		            }              
		         }    
		    	
		        
		        try {
					wb.write(output);
				} catch (IOException e) {
					e.printStackTrace();
				}  finally{
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}     
				}
	 	}
	 
	
}
