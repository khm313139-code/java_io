package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//stream : byte 자료형(jpg,png,mp3,mp4...)

public class io7 {

	public static void main(String[] args) {
		try {
			String url = "D:\\java_io\\java_io\\array.txt";
			
			//InputStream / stream 종류 엄청나게 많다. => io에 최고 부모 InputStream 뒤에 뭐가 붙느냐에 따라 달라진다.
			FileInputStream fs = new FileInputStream(url); //stream 나오면 무조건 byte 전환
			
			
			System.out.println(fs.available()); //파일의 저장 총 용량 이 파일은 250바이트임 그래서 250 출력
			
			byte temp[] = new byte[fs.available()]; //실무에서는 이렇게 한번에 읽어오지 않는다. fs.available() 이걸 직접때리면 안됨 그래서 1024*1024*5 이런식으로 계산해서 사용
			//byte가 temp에 들어간다(찍힌다)
			
			fs.read(temp); //byte는 무조건 읽어들여야한다.
			//read로 읽으면 ascii로 찍힌다.
			//stream 에서는 read를 사용하지 않을 경우 로드를 못함 필수조건
			
			String word = new String(temp); //여기에서 문자열로 변환되는 것(아스키를 읽어서)
			//문자열로 반영
			System.out.println(word); //데이터를 출력
			
			//1MB => 1메가
			//500MB => 500MB
			//1Mb(bit) => 0.125MB
			//10MB => 1.25MB
			
			fs.close(); //io 종료 무조건 해야함.
			
		}catch (Exception e) {
			e.getMessage();
		}
		
		new io7_box().abc();
	}
}

/*
InputStream: 파일을 읽어들임(read)
OutputStream: 파일을 저장함(write)
둘 다 byte 단위
*/
class io7_box{
	public void abc() {
		try {
			String url = "D:\\java_io\\java_io\\product.txt";
			String data = "자바 스트림 연습 중입니다.";
			FileOutputStream os = new FileOutputStream(url);
			byte[] by = data.getBytes();
			os.write(by);
			os.flush(); //stream에 있는 잔류 byte를 모두 출력 후 빈공간으로 변경하는 역할
			os.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
