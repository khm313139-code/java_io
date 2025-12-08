package io;

import java.io.*;
import java.util.Scanner;

public class io2 {

//throws 사용시 try-catch 없이도 파일 읽기, 쓰기가 가능합니다.
	//	public static void main(String[] args) {
//		try {
//		//try-catch없이도 throws IOException 쓰면 사용가능하지만, 문제가 터지면 try-catch가 없어서 수정 공간이 없어지는 제약이 있다.
//		FileReader fr = new FileReader("‪D:\\java_io\\list2.dat");
//		}
//		catch (Exception e) {
//			
//		}
	
	//string 문자열을 이용하여 경로를 설정 후 filereader에 적용하는 방식으로 진행
	public static void main(String[] args) throws IOException, Exception{
		 String url = "d:\\java_io\\list2.dat"; //lre가 있으므로 경로를 바로 복사해서 쓰면 안되니 이렇게 string으로 한번 변환해서 처리하면 된다.
		 FileReader fr = new FileReader(url);
		 
		 
		 //system.in: 사용자 입력(input)
		 //system.out: 사용자 입력값을 출력(output)
		 
		 Scanner sc = new Scanner(fr); //데이터 값 받아서 출력하려고 scanner 사용
		 while(sc.hasNext()) { //라인별로 전체 통채로 읽기 / hasnext는 true, false가 있음.
			 //데이터가 더 있으면 → true / 더 이상 읽을 것이 없으면 → false
			 
			 String word = sc.nextLine();
			 System.out.println(word);
		 }
		 sc.close(); //연거의 역순으로 닫아야함 뒤바뀌면 fr이 닫혀있는데 sc는 열려 있는 상황이 발생한다.
		 			 //라이브러리를 종료시 open한 상황의 역순으로 무조건 종료
		 fr.close();
		 
		 
		 
		 
		 io2_box ib = new io2_box();
		 ib.fw();
		 
	}
}


//FileWriter: 저장 기능이며, 경로가 필요하며 파일명도 사용해야 합니다.
//단, new FileWriter(경로, true) 사용시 기존에 작성된 내용 포함하여 신규 내용을 추가

class io2_box{
	
	
	String url = "d:\\java_io\\array.txt";
	String data[] = {"2025","APINK","PINKNEWYEAR","콘서트","13TH(Pink Vibes)"};
	
	public void fw() throws Exception {
		//FileWriter fw = new FileWriter(this.url);
		FileWriter fw = new FileWriter(this.url,true); //true 안쓰면 기존에 작성한 내용 초기화됨	
		for(int f=0; f<this.data.length; f++) {
			fw.write(this.data[f]+"\n");
		}
		fw.close(); // 파일이 오픈 상황이므로 close를 하지 않을 경우 저장이 안됨.
	}
}


