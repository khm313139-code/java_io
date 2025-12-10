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

	public static void main(String[] args) throws Exception{
		new io13().file_search();

	}
	
	
	io14 ib = new io14();
	Scanner sc = null;
	String ori_url = "d:\\java_io\\java_io\\images"; //원본이 있는 경로
	String dir = "c:\\"; //사본이 만들어지는 경로
	//nio 쓰는 방법
	//path ori_url = paths.get("d:\\java_io\\java_io\\");
	//files.createdirectory~ 이런식으로 쓴다.
	FileInputStream fs = null; //input output은 new 때리면 안됨
	FileOutputStream os = null; //그냥 죄다 필드에 놓고 쓰면 편하다
	
	String user1, user2; //호텔 및 펜션 디렉토리 이름이 저장되는 변수
	
	
	public void file_search() throws Exception{
		this.sc = new Scanner(System.in);
		
		String dir = "c:\\";
		this.dir = "c:\\";
		
		File f = new File(ori_url);
		List<File> files = Arrays.asList(f.listFiles());
		File f2 = null;
		
		try {
			
		System.out.println("호텔 이미지를 등록할 디렉토리 명을 입력하세요:");
		this.user1 = this.sc.nextLine();
		f2=new File(dir+this.user1);
		f2.mkdir(); //이거 io에서 디렉토리 만드는 법
		
		System.out.println("펜션 이미지를 등록할 디렉토리 명을 입력하세요:");
		this.user2 = this.sc.nextLine();
		f2=new File(dir+this.user2);
		f2.mkdir();
		
		
		for(int a=0; a<files.size(); a++) {
			
			this.fs = new FileInputStream(files.get(a));
			byte temp[] = new byte[this.fs.available()];
			this.fs.read(temp);
			
			//int ck = files.get(a).toString().toLowerCase().indexOf("hotel");
			boolean ck = files.get(a).toString().toLowerCase().contains("hotel");
			
			String url2 = dir;
			//파일 이름 변경값 받기
			int aa = files.get(a).toString().lastIndexOf("\\");
			String names = files.get(a).toString().substring(aa);
			String rename = this.ib.renames(names);
			
			//파일 이름 최종 변경사항 확인
			System.out.println(rename);
			
			
			
			
			if(ck==true) { //호텔 이미지
				url2 = url2 + this.user1; //복사할 경로 + 사용자가 생성한 디렉토리
			}
			else { //펜션 이미지
				url2 = url2 + this.user2;
			}
			//tolowercase(): 대소문자 구분 안함.
			System.out.println(ck);
			
			// 디렉토리 끝에 \ 붙이기
            if(url2.endsWith("\\") == false) {
                url2 += "\\";
            }

            // hotel_20251209155506.jpg 형태로 저장할 파일명 생성
            String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
            String category = ck ? "hotel" : "pension";   // 펜션 파일 이름 prefix
            String newFileName = category + "_" + timestamp + ".jpg";

            // 파일 출력 스트림 생성 및 쓰기
            this.os = new FileOutputStream(url2 + newFileName);
            this.os.write(temp);
            this.os.close();

            System.out.println("▶ 저장 완료: " + url2 + newFileName);

            // ★추가 끝★ ---------------------------------------------------
			
			
			/*
			String url2 = "c:\\aaa\\";
			this.os = new FileOutputStream(url2+"111.jpg");
			this.os.write(temp);
			this.os.close();
			System.out.println(files.get(a));
		*/
		}
		
		
		
		}catch (Exception e) {
			System.out.println(e);
		}
		finally {
			if(this.fs!=null){ //fs가 null이 아닐때를 말함.
				this.fs.close();//위에 null 때려놔서 nullpointexception이 발생
			}
			this.sc.close();
			//null 때리면 안된다.
			//null이 아닐때 close를 해줘야함.
		}
		//this.ib.renames(null);
	}
}
	
	//내코드
//		io13_box ib = new io13_box();
//		ib.aaa();
//		ib.bbb();
//		ib.ccc();
//	}

//}







//내코드
//class io13_box{ 

//	String hotel1;
//	String vector1;
//	ArrayList<String> al = new ArrayList<String>();
//	String url = "d:\\java_io\\java_io\\images";
//	
//	public void aaa() { //이미지 등록할 디렉토리 생성하는 메소드
//	
//	Scanner sc = new Scanner(System.in);
//	System.out.println("호텔 이미지를 등록할 디렉토리명을 입력하세요: ");
//	hotel1= sc.nextLine();
//	System.out.println("펜션 이미지를 등록할 디렉토리명을 입력하세요: ");
//	vector1= sc.nextLine();
//	sc.close();
//	
//	try {	
//	Path hotel = Paths.get("c:\\travel\\"+hotel1);
//	Files.createDirectories(hotel);
//	Path vector = Paths.get("c:\\travel\\"+vector1);
//	Files.createDirectories(vector);
//	}catch(Exception e) {
//		System.out.println(e);
//		}
//	}
//	
//	String file_name= null;
//	
//	public void bbb() { //파일 이름을 가져오는 메소드
//		File fr = new File(url);
//		String name[] = fr.list();
//		for(String f : name) {
//			this.file_name = f;
//			//System.out.println(this.file_name);
//			al.add(this.file_name);
//		}
//		System.out.println(al);
//	}
//	
//	public void ccc() { // 저장 처리를 하는 메소드
//		for(int i=0; i<this.al.size(); i++) {
//			String fname=al.get(i);
//			int n = (al.get(i).indexOf("."));
//			
//			String type = al.get(i).substring(n);
//			//System.out.println(type);
//			
//			String copy = "c:\\travel\\";
//			if(fname.contains("hotel")) {
//				copy+=hotel1+"\\";
//			}
//			else {
//				copy+=vector1+"\\";
//			}
//			
//			
//			String file_rename="";
//			Random rd = new Random();
//			int w = 0;
//			while(w<6) {
//				int nos = rd.nextInt(10);
//				file_rename += nos;
//				w++;
//			}
//			//System.out.println(file_rename);
//			
//			try {
//				FileInputStream fs = new FileInputStream(this.url+"\\"+fname);
//				byte by[] = new byte[fs.available()];
//				fs.read(by);
//				
//				String copyrul = "c:\\travel\\";
//				FileOutputStream os = new FileOutputStream(copy+file_rename+type);
//				os.write(by);
//				os.flush();
//				
//				os.close();
//				fs.close();
//				
//			}catch(Exception e) {
//				System.out.println("파일 복사시 오류 발생");
//			}
//			
//		}
//	}
	

	
	






