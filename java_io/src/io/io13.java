package io;

import java.io.*;
import java.nio.file.*;
import java.util.*;

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
public class io13 {

	public static void main(String[] args) {
		io13_box ib = new io13_box();
		ib.aaa();
		ib.bbb();
		ib.ccc();
	}

}

class io13_box{ 
	
	String hotel1;
	String vector1;
	ArrayList<String> al = new ArrayList<String>();
	String url = "d:\\java_io\\java_io\\images";
	
	public void aaa() { //이미지 등록할 디렉토리 생성하는 메소드
	
	Scanner sc = new Scanner(System.in);
	System.out.println("호텔 이미지를 등록할 디렉토리명을 입력하세요: ");
	hotel1= sc.nextLine();
	System.out.println("펜션 이미지를 등록할 디렉토리명을 입력하세요: ");
	vector1= sc.nextLine();
	sc.close();
	
	try {	
	Path hotel = Paths.get("c:\\travel\\"+hotel1);
	Files.createDirectories(hotel);
	Path vector = Paths.get("c:\\travel\\"+vector1);
	Files.createDirectories(vector);
	}catch(Exception e) {
		System.out.println(e);
		}
	}
	
	String file_name= null;
	
	public void bbb() { //파일 이름을 가져오는 메소드
		File fr = new File(url);
		String name[] = fr.list();
		for(String f : name) {
			this.file_name = f;
			//System.out.println(this.file_name);
			al.add(this.file_name);
		}
		System.out.println(al);
	}
	
	public void ccc() { // 저장 처리를 하는 메소드
		for(int i=0; i<this.al.size(); i++) {
			String fname=al.get(i);
			int n = (al.get(i).indexOf("."));
			
			String type = al.get(i).substring(n);
			//System.out.println(type);
			
			String copy = "c:\\travel\\";
			if(fname.contains("hotel")) {
				copy+=hotel1+"\\";
			}
			else {
				copy+=vector1+"\\";
			}
			
			
			String file_rename="";
			Random rd = new Random();
			int w = 0;
			while(w<6) {
				int nos = rd.nextInt(10);
				file_rename += nos;
				w++;
			}
			//System.out.println(file_rename);
			
			try {
				FileInputStream fs = new FileInputStream(this.url+"\\"+fname);
				byte by[] = new byte[fs.available()];
				fs.read(by);
				
				String copyrul = "c:\\travel\\";
				FileOutputStream os = new FileOutputStream(copy+file_rename+type);
				os.write(by);
				os.flush();
				
				os.close();
				fs.close();
				
			}catch(Exception e) {
				System.out.println("파일 복사시 오류 발생");
			}
			
		}
	}
	
}
	
	






