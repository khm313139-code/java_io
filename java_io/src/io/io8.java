package io;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//stream 응용문제 [필수조건 => fileoutputstream] - 바이트 단위임.
/*
d:\java_io 디렉토리에 dan.txt를 생성합니다. 단, 자바코드에서 생성 되어야 합니다.
구구단 8단에 대한 내용이 dan.txt에 저장되도록 합니다.

dan.txt 파일을 열었을 경우 메모장에 해당 내용이 저장되어 있어야 합니다.
*/

//강사님 코드
public class io8 {
	private String url = "d:\\java_io\\java_io\\dan.txt";
	String message = "";
	FileOutputStream fs = null; //필드에 올려버림 - outputstream 사용하면 언어셋 변경하기 easy
	
		
	public static void main(String[] args) throws Exception{
		String result = new io8().gugu();
		System.out.println(result);
	}
	
	public String gugu() {
		
		try {
			File f = new File(this.url);
			//구구단 정보를 모두 저장하는 문자열
			StringBuffer sb = new StringBuffer();
			//stringbuffer, stringbuild => tostring => getbytes => 저장
			
			//원래는 stringbuilder를 활용 / 버퍼를 쓴다는 것은 멀티 쓰레드를 쓴다는 것 / 저장 속도는 떨어진다 (성능)
			//stringbuilder는 싱글 쓰레드
			
			for(int i = 1; i<10; i++) {
				int sum = 8 * i;
				sb.append("8 * " + i +" = " + sum + "\n");
			}
			this.fs = new FileOutputStream(f); //stream 은 바이트
			/*길게 쓴거
			String gugus = sb.toString(); //한번 변환을 해줌 문자로
			byte by[] = gugus.getBytes();
			*/
			//위 코드를 한줄로
			this.fs.write(sb.toString().getBytes()); //그리고 받아서 처리하면 가능
			this.fs.close();
			
			this.message = "정상적으로 구구단 파일이 완성 되었습니다.";
			
		} catch (Exception e) {
			
			this.message = "error: "+e.getMessage();
			//오류 났으니 오류 메세지를 그대로 띄워버림
		}
		
		return message;
	}
}




/* 내 코드 
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
*/