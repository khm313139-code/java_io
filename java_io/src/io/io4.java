package io;

import java.io.FileWriter;
import java.io.IOException;
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
public class io4 {

	public static void main(String[] args) throws Exception{
		io4_box ib = new io4_box();
		ib.aaa();
		ib.bbb();
		
	}
}

class io4_box{
	String url = "d:\\java_io\\data.txt";
	String data[] = null;
	Scanner sc = new Scanner(System.in);
	public void aaa() throws Exception{
		
		System.out.println("댓글 내용을 입력하세요: ");
		String input = sc.nextLine();
		this.data = new String[1];
		data[0]=input;
		//System.out.println(Arrays.toString(data));
	}
	
	
	public void bbb() throws Exception{
		FileWriter fw = new FileWriter(this.url,true);
		for(int i=0;i<this.data.length;i++) {
			fw.write(this.data[i]+"\r\n");
		}
		fw.close();
	}
	
	
}

