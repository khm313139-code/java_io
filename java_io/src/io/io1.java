package io;
import java.io.*;
import java.nio.charset.Charset;
/*
I/O : inputstream, outputstream => i/o는 try~catch 무조건 사용해야함.
입력 스트림: 데이터를 입력하는 형태(키보드, 마우스, load)
출력 스트림: 데이터를 출력하는 형태(모니터, 프린터, save)
FILE, FileReader (일반) => Input stream
FileWrite => output stream
*/

//‪D:\java_io\list.txt
//변경했습니다.
public class io1 { //io는 무조건!!!!!! try- catch

	public static void main(String[] args) {
		//FileReader : 해당 경로에서 파일을 load하는 역할
		FileReader fr=null;
		try {
			//Charset.forName: Java9 => EUC_KR or EUCKR 둘다 먹음(ANSI), UTF8 OR UTF-8, UTF16 OR UTF-16
			fr = new FileReader("D:\\java_io\\list.txt", Charset.forName("UTF8"));//파일이 없을수도 있으니 무조건 try-catch로 잡아야한다. //경로는 무조건 \\사용
			System.out.println(fr.getEncoding()); //file의 인코더 형식
			System.out.println(fr.read()); //file의 데이터 크기 
			
			while(true) {
				int m = fr.read(); //파일 열려있음.
				System.out.println(m); //2byte를 읽어들임
				System.out.println((char)m);//char 자료형으로 byte를 변환
				if(m==-1) {
					break;
				}
			}
			fr.close(); //파일 close 꼭 해야함.
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				fr.close();
			}catch(Exception e) {
				System.out.println("파일 종료를 제대로 시행하지 못했습니다.");
			}
			}
	}
}
