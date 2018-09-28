package org.foxconn.ftpTest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.tools.ant.types.FlexInteger;
import org.junit.Test;


public class FtpTest {
	
	@Test
	public void test() throws IOException{
		String msg = "中文字符测试 abc";
		String filename = "testFile.txt";
		File file = new File("test.txt");
		FileInputStream fis =  new FileInputStream(file);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		msg= new String(buffer,"UTF-8");
		InputStream inputStream = new ByteArrayInputStream(msg.getBytes("UTF-8"));
		try {
			String  result = UploadFile.uploadFile("10.67.70.95", 21, "it", "8293584", "/temp", filename,
					inputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
