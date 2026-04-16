package ex2_charstream.exam;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileConverter {
	public void copy(String source, String target) throws Exception{
		FileInputStream fis = new FileInputStream(source);
		FileOutputStream fos = new FileOutputStream(target);
		
		byte[] buffer = new byte[1024];
		int length;
		long totalBytes = 0;
		
		while((length = fis.read(buffer)) != -1) {
			fos.write(buffer,0,length);
			totalBytes += length;
		}
		
		fis.close();
		fos.close();
		
		//로그기록
		FileOutputStream logFos = new FileOutputStream("log.txt",true);
		String logMsg = "복사 완료 : " + totalBytes + "bytes\n";
		logFos.write(logMsg.getBytes());
		logFos.close();
		
	}
}
