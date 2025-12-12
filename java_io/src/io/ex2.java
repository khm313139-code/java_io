package io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
응용문제 2
user.csv 파일을 로드하여 해당 사용자 통신사별로 각각의 파일로 저장 되도록 해야합니다.
skt_user.csv
kt_user.csv
lgt_user.csv
etc_user.csv

*/

public class ex2 {
	
	String filenm[] = {"skt_user.csv","kt_user.csv","lgt_user.csv","etc_user.csv"};
	private String ori_data ="d:\\java_io\\java_io\\data.csv";
	private String save_data = "d:\\java_io\\java_io\\";
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	OutputStream os = null;
	OutputStreamWriter osw = null;
	BufferedWriter bw = null;
	
	
	
	public static void main(String[] args) {
		new ex2().part_corp();
		
		
		
	}
	public void part_corp() {
		File f = new File(this.ori_data); //원본 데이터 경로
		try {
			for(String mkfile: filenm) { //배열값에 맞는 파일명으로 생성
				File f2 = new File(this.save_data + mkfile); //신규 파일 생성 경로
				f2.createNewFile(); //신규 파일 생성 각각 생성됨 skt,kt,lgt,알뜰폰
				
			}
		
			//해당 파일의 데이터를 로드하여 구분
			this.is = new FileInputStream(f);
			this.isr = new InputStreamReader(this.is,Charset.forName("EUC-KR"));
			this.br = new BufferedReader(this.isr);
			String data = "";
			while((data=this.br.readLine()) != null){
				
				String ck[] = data.split(","); //문자열, 기준으로 원시배열 생성하여 switch 반영
				int ff;
				switch(ck[1]) {
					case "SKT":
						
						ff=0; //filenm 해당 원시배열 변수에 맞는 배열 노드 번호를 적용하기 위함.
						//System.out.println(data);
						break;
					
					case "KT":
						ff=1;
						break;
						
					case "LGT":
						ff=2;
						break;
					
					default : //etc(알뜰폰)
						ff=3;
						break;
					
				
				
				}
				this.os = new FileOutputStream(this.save_data+filenm[ff], true);
				this.osw = new OutputStreamWriter(this.os,Charset.forName("EUC-KR"));
				this.bw = new BufferedWriter(this.osw);
				this.bw.write(data);
				this.bw.newLine();
				this.bw.flush();
			}
			
			
			
			
			
			
			
			
			this.bw.close();
			this.br.close();
			
		}catch (Exception e) {
			e.getMessage();
		}
	}
}






// 내 코드
//	public static void main(String[] args) {
//		String url = "d:\\java_io\\java_io\\data.csv";
//		String filenm[] = {"skt_user.csv","kt_user.csv","lgt_user.csv","etc_user.csv"};
//		Path base = Paths.get("d:\\java_io\\java_io\\create");
//		ex1_box eb = new ex1_box();
//		/*
//		String result = eb.base64_encode("a123456");
//		System.out.println(result);
//		*/
//		
//		
//		/* 암호화 만들어봄
//		Scanner sc = new Scanner(System.in);
//		System.out.println("고객 패스워드 입력: ");
//		String userpw = sc.next();
//		String result1 = eb.base64_encode(userpw);
//		System.out.println(result1);
////		String result2 = eb.base64_decode("c3ByaW5nMTIz");
//		if(result1.equals("YXBwbGUxMjM0NTY=")) {
//			System.out.println("로그인");
//		}
//		else {
//			System.out.println("동일한 코드가 아님");
//		}
//		sc.close();
//		*/
//		try {
//			Files.createDirectories(base);
//			
//			
//			
//			//csv 파일 읽기
//			FileInputStream fr = new FileInputStream(url);
//			InputStreamReader isr = new InputStreamReader(fr, "euc-kr" );
//			BufferedReader br = new BufferedReader(isr);
//			
//			List<List<String>> all2 = new ArrayList<>();
//			String data;
//			
//			
//			while((data=br.readLine()) != null) {
//			String parts[] = data.split(",");
//			//System.out.println(Arrays.toString(parts));
//			List<String> al = new ArrayList(Arrays.asList(parts));
//			
//			all2.add(al);
//			}
//			System.out.println(all2);
//			
//			
//			
//			
//			
//			//조건별 파일 생성
//			for(List<String> al2 : all2) {
//				
//				
//				String move = al2.get(1).toLowerCase();
//				String file;
//			
//				switch (move) {
//                case "skt":
//                    file = base + "\\skt_user.csv";
//                    break;
//                case "kt":
//                    file = base + "\\kt_user.csv";
//                    break;
//                case "lgt":
//                    file = base + "\\lgt_user.csv";
//                    break;
//                default:
//                    file = base + "\\etc_user.csv";
//                    break;
//            }
//
//            // 파일 작성 (있으면 이어쓰기)
//            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
//                bw.write(String.join(",", al2));
//                bw.newLine();
//            }
//        }
//
//        System.out.println("통신사별 CSV 생성 완료!");
//    }catch (Exception e) {
//		// TODO: handle exception
//	}
//}
//}

