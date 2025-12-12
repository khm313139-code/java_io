package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/*
응용문제 1
data.txt라는 파일을 생성 후 다음 결과에 대한 내용이 data.txt에 저장 되도록 코드를 작성하시오.

[실행]
"댓글 내용을 입력하세요: "

[결과]
data.txt 파일을 열었을 경우 해당 댓글 내용이 저장 되어 있어야 합니다.

*/

//강사님 코드
public class io4 {
	private String url = "c:\\io\\data.txt";
	String message = ""; //결과 정보를 담는 변수
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception{
		String result = new io4().file_save();
		System.out.println(result); //결과를 여기서 받겠다.
	}
	
	
	
	public String file_save() {
		//해당 경로를 지정 그냥 경로만 지정된 것을 확인만 시키는 용도
		File f = new File(this.url);
		try {
			//저장을 할 것임.
			System.out.println("댓글 내용을 입력하세요: ");
			String txt = this.sc.nextLine();
			
			FileWriter fw = new FileWriter(f,true); //기존에 있던 자료 유지하고 싶으면 여기에 true 넣으면 됨, 여기 기본은 false
			BufferedWriter bw = new BufferedWriter(fw);
			
			/* 언어셋 변경
			FileOutputStream fw = new FileOutputStream(f,true);
			OutputStreamWriter osw = new OutputStreamWriter(fw,StandardCharsets.UTF_8); //
			BufferedWriter bw = new BufferedWriter(osw);
			//시작과 마지막이 중요하다.
			*/
			
			bw.write(txt);
			bw.newLine(); //이거 새로 등록하는 것 자동 줄바꿈
			bw.flush();
			bw.close();
			this.message = "올바르게 댓글이 저장 되었습니다.";
		} catch (Exception e) {
			e.getMessage();
			this.message = "경로 오류로 인하여 정상적으로 저장되지 않았습니다.";
			
		} finally {
			this.sc.close();
		}
		
		return this.message; //call을 받아서 처리하는
	}
}








//내 코드
//public class io4 {
//
//	public static void main(String[] args) throws Exception{
//		io4_box ib = new io4_box();
//		ib.aaa();
//		ib.bbb();
//		
//	}
//}
//
//class io4_box{
//	String url = "d:\\java_io\\data.txt";
//	String data[] = null;
//	Scanner sc = new Scanner(System.in);
//	public void aaa() throws Exception{
//		
//		System.out.println("댓글 내용을 입력하세요: ");
//		String input = sc.nextLine();
//		this.data = new String[1];
//		data[0]=input;
//		//System.out.println(Arrays.toString(data));
//	}
//	
//	
//	public void bbb() throws Exception{
//		FileWriter fw = new FileWriter(this.url,true);
//		for(int i=0;i<this.data.length;i++) {
//			fw.write(this.data[i]+"\r\n");
//		}
//		fw.close();
//	}
//	
//	
//}

