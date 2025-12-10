package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

//stream + reader,writer => buffered

public class io16 {

	public static void main(String[] args) throws Exception {
		String url = "d:\\java_io\\java_io\\list.txt";
		FileReader fr = new FileReader(url); //reader와 stream은 상극이라 이런식으로는 바로 핸들링 할 수 없어서 buffered 사용
		//FileReader 문서 파일 그 자체라 reader로 핸들링 불가 -> 문자를 buffer에 할당한 순간 문자는 byte로 바뀜
		//그래서 bufferedreader 써서 핸들링
		BufferedReader br = new BufferedReader(fr); //reader에서 버퍼로 할당.
		//System.out.println(br.readLine()); //byte 단위 - 이렇게 작성하면 볼 수 있음 데이터 loss나는지
		//readline을 사용하면 아래 반복문이 안돌아감 첫줄이
		
		//해당 조건문 또는 sysout에서 buffered 사용시 무조건 메모리에서는 해당 데이터를 사용한 것으로 간주하고 데이터를 삭제해버림.
		/*해당 코드 작성시 데이터는 loss 발생함.
		if(br.readLine()==null) {
			System.out.println("값이 없습니다.");
		}
		else {
			br.readLine();
			System.out.println("-----------");

		}
		*/  //buffer 잘못 쓰면 데이터 로스가 날 수도 있음.
		//그래서 잘 출력이 되는지 보려면 sysout을 주석달아야함 찍어보고
		String data = "";
		while((data=br.readLine()) != null ) {
			//System.out.println("반복문: " +data);
		}
		br.close();
		fr.close();
	
		
		new io15_box().abc();
	}

}


//writer+buffered

class io15_box{
	String url = "d:\\java_io\\java_io\\array.csv";
	
	public void abc() {
		try {
			FileWriter fr = new FileWriter(this.url,Charset.forName("EUC-KR"));
			BufferedWriter bw = new BufferedWriter(fr); //버퍼로 메모리 사용 / 메모리에 읽어서 한번에 저장시키는
			ArrayList<String> mb = new ArrayList<String>();
			mb.add("권하민, ISFP");
			mb.add("김고운, ENFP");
			mb.add("김예빈, INTP");
			mb.add("신범석, ENTP");
			
			for(String m:mb) {
				bw.write(m+"\n");
			}
			bw.close();
			fr.close();
			bw.flush(); //writer를 사용했으므로 flush 메모리를 초기화
			
			//bufferedreader일때는 flush 쓸 필요 없음 flush는 write일때만 사용!!
			
		}catch(Exception e) {
			System.out.println("파일 경로가 잘못 되었습니다.");
		}
	
	}
}














