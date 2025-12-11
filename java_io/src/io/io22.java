package io;

import java.io.*;

//maven repository => back-end가 주로 이용하는 라이브러리 전용 사이트
//약 8만개 정도 라이브러리가 저장되어 있음.
import org.apache.commons.io.output.WriterOutputStream; //외부 라이브러리 io를 가져옴

//io 및 nio의 추가 클래스 형태2 (web) -> jsp나 jstl, thymeleaf 에서 많이 쓰는 io형태
public class io22 {

	public static void main(String[] args) {
		String url = "c:\\io\\info.txt";
		try {
		
		//PrintWriter => web 전용 io(javascript 코드를 출력하는 형태)	
		PrintWriter pw = new PrintWriter(url);
		//writer => web 전용 => printwirter
		
		pw.write("alert('올바른 접근이 아닙니다.'); self.close(); ");
		pw.close();
		
		}catch(Exception e) {
			System.out.println(e);
		}
		//new io22_box().abc();
		new io22_box().bbb();
	}

}

//inputstream, outputstream 네트워크 기능 추가(실시간으로 데이터 전송때문에 많이 사용)
class io22_box{
	String url = "c:\\io\\chat.log";
	public void bbb() {
		String message = "java i/o를 배우는 중입니다.";
		try {
		//byte로 파일을 로드 후 => 메모리 문자 형태로 메모리(append)를 이용하여 메세지 추가
		
		OutputStream os = new FileOutputStream(url); //1.byte 읽기
		OutputStreamWriter osw = new OutputStreamWriter(os);//3. 브릿지임
		BufferedWriter bw = new BufferedWriter(osw); //2.문자 읽기라 브릿지 없으면 안맞음
		bw.append(message);
		bw.flush();
		bw.close();
		//버퍼 쓰면 버퍼만 닫으면 나머지는 안닫아도 된다. 버퍼 안쓰면 닫아야 됨 다
		
		
		
		
		/* 얘는 다 닫아줘야함 filewriter를 사용했기 때문에 
		
		message ="java가 사람을 잡아요...ㅎㅎㅎ";
		FileWriter fw = new FileWriter(url); //이미지는 안됨
		BufferedWriter bw = new BufferedWriter(fw);
		OutputStream os2 = new WriterOutputStream(bw);
		os2.write(message.getBytes());
		bw.flush();
		os2.close();
		bw.close();
		fw.close();
		*/
		}
		catch (Exception e) {
			
		}
	}
	
	
	
	
	
	
	
	
	
	public void abc() {
		
		try {
			//전송 역할
			//System.out => byte로 전송하는 역할
			OutputStreamWriter os = new OutputStreamWriter(System.out); //입력한 문자를 바이트로 바꾸겠다.
			//사용자가 입력한 문자를 메모리에 탑재
			//System.out 출력을 시키겠다.
			BufferedWriter bw = new BufferedWriter(os);
			bw.write("안녕하세요!!!");
			bw.write("안녕하세요2!!!");
			bw.write("안녕하세요3!!!");
			bw.flush();
			bw.close();
			//OutputStreamWriter os 이 부분은 역으로 올라감 문자를 입력을 받고 BufferedWriter bw 문자 저장을 하고
			// System.out 이거로 바이트로 변환해서 inputstreamreaader로 넘겨줌
			
			
			//output에서 보내온 것을 System.in에서 읽어서 순차적으로 읽어서 출력시킴
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			String msg = br.readLine();
			System.out.println(msg);
			
		} catch (Exception e) {
			
		}
		
	}
}