package io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
응용문제 1
data.txt라는 파일을 생성 후 다음 결과에 대한 내용이 data.txt에 저장 되도록 코드를 작성하시오.

[실행]
"댓글 내용을 입력하세요: "

[결과]
data.txt 파일을 열었을 경우 해당 댓글 내용이 저장 되어 있어야 합니다.

*/
public class io4 {

	public static void main(String[] args) {
		io4_box ib = new io4_box();
		ib.aaa();
		ib.fw();

	}

}


class io4_box {
	String url = "D:\\java_io\\data.txt";
	String data[]=null;
	
	public void aaa(){
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("댓글 내용을 입력하세요: ");
		String input = sc.nextLine();
		
		this.data = new String[1];
		this.data[0] = input;
		
	}catch(Exception e){
		System.out.println(e);
	}
		}
	
	public void fw() {
	    try (FileWriter fw = new FileWriter(this.url, true)) { // append 모드
	        for (int i = 0; i < this.data.length; i++) {
	            fw.write(this.data[i] + "\n");
	        }
	        System.out.println("파일 저장 완료!");
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
}


