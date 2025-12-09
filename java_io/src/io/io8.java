package io;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//stream 응용문제 [필수조건 => fileoutputstream
/*
d:\java_io 디렉토리에 dan.txt를 생성합니다. 단, 자바코드에서 생성 되어야 합니다.
구구단 8단에 대한 내용이 dan.txt에 저장되도록 합니다.

dan.txt 파일을 열었을 경우 메모장에 해당 내용이 저장되어 있어야 합니다.
*/
public class io8 {

	public static void main(String[] args) throws Exception{
		io8_box ib = new io8_box();
		ib.aaa();
		ib.bbb();

	}

}

class io8_box{
	public void aaa() throws Exception{
		Path data = Paths.get("d:\\java_io\\java_io\\dan.txt");
		Files.createFile(data);
		//Files.delete(data);
	}
	
	public void bbb() throws Exception{
		String url = "d:\\java_io\\java_io\\dan.txt";
		
		try (FileOutputStream os = new FileOutputStream(url)){
		for(int i=1; i<10; i++) {
			String line = "8 * "+ i + "=" + (8*i) + "\n";
			os.write(line.getBytes());
		}
		os.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("8단 구구단 저장됨.");
	}
	
}
