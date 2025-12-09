package io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//http://mekeyace.kbsn.or.kr/images.zip
/*
응용문제2
해당 경로에 images라는 디렉토리가 있습니다.
해당 디렉토리에 있는 이미지를 활용하여 다음과 같이 c:\\travel에 정상적으로 이미지가 반영이 되도록
코드를 작성해 주시면 됩니다.
[실행]
c:\\travel 안에
호텔 이미지를 등록할 디렉토리 명을 입력하세요: 입력받음
펜션 이미지를 등록할 디렉토리 명을 입력하세요: 입력받음

hotel로 시작하는 파일은 => 호텔 이미지를 저장하는 디렉토리에 복사되며
vectors로 시작하는 파일은 => 펜션 이미지를 저장하는 디렉토리에 복사 되어야 합니다.

단, 저장 시 년월일 형태의 중복되지 않은 파일 명으로 다음과 같이 파일명을 설정하십시오.
예시) hotel_20251209155506.jpg 중복안되게 해라 
*/
public class io14_연습용 {

	public static void main(String[] args) {
		io14_box ib = new io14_box();
		ib.aaa();
		ib.bbb();

	}

}


class io14_box{
	String url = "d:\\java_io\\java_io\\images";
	//Scanner sc = new Scanner(System.in);
	//String hotel1 = sc.nextLine();
	//String vector1 = sc.nextLine();
	
	public void aaa() { //일단 파일처리 하는 메소드 생성
		//System.out.println("호텔 이미지를 등록할 디렉토리 명을 입력하세요: ");
		//System.out.println("펜션 이미지를 등록할 디렉토리 명을 입력하세요: ");
		
		try {
		//Path p = Paths.get("c:\\travel\\"+hotel1);
		//Files.createDirectories(p);
		//Path d = Paths.get("c:\\travel\\"+vector1);
		//Files.createDirectories(d);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	String file_name=null;
	ArrayList<String> al = new ArrayList<String>();
	public void bbb() { //이미지 파일에서 이름을 불러오는 메소드 생성
		File fr = new File(url);
		String name[]=fr.list();
		//System.out.println(Arrays.toString(name));
		for(int i =0; i<name.length;i++) {
			this.file_name=name[i];
			al.add(this.file_name);
		}
		System.out.println(al);
		
	}
	
	public void ccc() { //파일명 앞자리 떼오고 난수 붙여서 처리하는 코드
		
	}
	
	
	
	
	
}