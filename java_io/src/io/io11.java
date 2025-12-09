package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

//Array + 파일생성
public class io11 {

	public static void main(String[] args) {
		String url = "d:\\java_io\\java_io\\";
		String file_name[] = {"list.txt","apink.webp","array.txt"};
		
		
		for(int f = 0; f<file_name.length; f++) {
			int n = (file_name[f].lastIndexOf(".")); //이건 last를 써줘야 한다. 왜냐 파일 이름명에 .이 여러번 찍힐 수가 있으니까
		
		//.기준으로 속성 타입을 가져오기 위한 문자의 위치 파악
		//System.out.println(n);
		//substring => 해당 단어 기준의 노드 번호를 기점으로 문자를 가져옴.
		String type = file_name[f].substring(n); //substring은 잘라내는 것 n을 기준으로 뒤에서부터 출력 이 코드에선 (배열번호 4부터 뒤로 출력)
		
		//파일을 숫자화 하여 속성을 적용한 후 생성되도록 함.
		String file_rename = "";
		Random rd = new Random();
		int w = 0;
		while(w<6) {
		int nos = rd.nextInt(10);
			file_rename +=nos;
			w++;
		}
		
		try {
			//파일 복사를 시작
			FileInputStream fs = new FileInputStream(url + file_name[f]);
			byte by[] = new byte[fs.available()];
			fs.read(by);
			
			//복사할 경로
			String copyurl = "c:\\io\\";
			//복사할 경로 + 새로운 파일명 + 파일 속성
			FileOutputStream os = new FileOutputStream(copyurl+file_rename+type);
			os.write(by); //파일 저장
			os.flush(); //캐쉬메모리 공간확보
			
			
			os.close();
			fs.close();
		}
		catch(Exception e) {
			System.out.println("파일 복사시 오류 발생");
		}
		
		//System.out.println(file_rename+type);
		}
		System.out.println("해당 배열에 있는 모든 파일을 정상적으로 복사하였습니다.");
	}

}
