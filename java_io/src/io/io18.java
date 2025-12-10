package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

//stream으로 시작해 => reader로 끝내는

/*
inputstream => inputstreamreader >bufferedreader (o) -정식 코드
inputstream => bufferedinputstream(o) - 맞음
inputstream => bufferedreader(x) - 스트림에서 reader 절대 못바꿈)
filewriter => outputstream (x) - writer에서 stream 바로 못바꿈 안됨
*/




public class io18 {

	public static void main(String[] args) {
		
		String url = "d:\\java_io\\java_io\\apink.webp";
		try {
		InputStream is = new FileInputStream(url); //데이터를 byte를 읽기(BYTE)
		//STREAM -> READER(언어셋 변경가능)
		InputStreamReader isr = new InputStreamReader(is); //stream에서 byte로 바로 변환 못함.
		//InputStreamReader isr = new InputStreamReader(is); //이미지 보려고 추가함 이미지는 깨짐 bufferedreader는 순전히 문자만
		BufferedReader br = new BufferedReader(isr); // 순전히 문자만(이미지는 안됨) 버퍼링해서 효율적으로 읽음 줄 단위로 읽을수 있음(readline) (STRING)
		
		//System.out.println(br.readLine());
		
		br.close();
		isr.close();
		is.close();
		
		
		
		
		
		
		
		
		//reader => stream으로 바꾸는 과정
		
		FileReader fr = new FileReader(url); //파일 로드
		BufferedReader br2 = new BufferedReader(fr); //메모리 저장
		
		byte[] by = null; //빈 원시 배열 => stream 전달
		String a = ""; //bufferedreader의 값을 받는 변수
		String b = ""; //a의 데이터 값을 누적시킴
		while((a=br2.readLine())!=null) {
			b+=a;
		}
		by=b.getBytes(); //문자 => byte
		
		
		
		//ByteArrayInputStream(by); : byte[] 원시 형태를 가져오는 stream
		InputStream is2 = new ByteArrayInputStream(by); //byte 단
		BufferedInputStream bis = new BufferedInputStream(is2);
		byte file[] = new byte[bis.available()];
		//System.out.println(bis.read(file));
		
		
		
		//읽은걸 저장해서 보기
		String copy_url = "c:\\io\\1111.txt"; //복사할 위치
		OutputStream os = new FileOutputStream(copy_url); 
		BufferedOutputStream bos = new BufferedOutputStream(os);
		int read;
		while((read=bis.read(file))!=-1) { //데이터 없을때까지 다 읽어들여라
			bos.write(by,0,read);
		}
		
		
		
		
		bos.close();
		is2.close();
		br2.close();
		fr.close();
		
		}catch(Exception e) {
			System.out.println("해당 파일이 올바르지 않습니다.");
		}
	}

}
