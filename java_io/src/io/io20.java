package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//stream 단축코드
public class io20 {

	public static void main(String[] args) {
		String file = "d:\\java_io\\java_io\\222.jpg";
		try {
		//BufferedInputStream => new BufferedInputStream 바로 로드해버림(인스턴스를 바로 로드하여 적용하는 방식)
		BufferedInputStream bs = new BufferedInputStream(new FileInputStream(file));
		byte filesize[] = new byte[bs.available()];
		bs.read(filesize);
		
		
		String refile = "c:\\io\\333.jpg";
		//BufferedOutputStream => new BufferedOutputStream 바로 로드해버림(인스턴스를 바로 로드하여 적용하는 방식)
		BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(refile));
		bo.write(filesize);
		bo.flush();
		bo.close();
		bs.close();
		
		}catch (Exception e) {
			
			
			
		}

	}

}
