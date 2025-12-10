package io;

//csv파일을 로드하여 버퍼로 출력시키는 형태(byte 형태로 변환해서 적용하는 형태)

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
//123.sql -> sql은 문서파일
public class io17 {

	public static void main(String[] args) {
		String url = "d:\\java_io\\java_io\\user.csv";
		try {
		FileReader fr = new FileReader(url);
		BufferedReader br = new BufferedReader(fr);
		String data = "";
		
		while((data=br.readLine()) != null) {
			System.out.println(data);
		}
		br.close();
		fr.close();
		
		
		
		/* scanner 사용 하는 경우 - csv는 실시간으로 바뀔 수도 있고 scanner는 문자기반 byte기반이 아니므로 사용할 수 없음.
		Scanner sc = new Scanner(fr);
		System.out.println(sc.nextLine()); //scanner는 문자기반 byte기반이 아님.
		*/
		
		
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
