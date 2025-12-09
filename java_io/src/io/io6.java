package io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class io6 {
	//string으로 할경우
	//string sb = "d:\\java_io\\agree2.txt";
	//이렇게 작성하면 됨
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(); //string으로 해도 된다.
		sb.append("d:\\java_io\\");
		sb.append("agree.txt"); //자바에서 직접 agree2.txt만들겠다.
		try {
			//File: 실제 경로에서 생성, 삭제, 다른경로 이동, 해당 파일명(속성 변경)
			File f = new File(String.valueOf(sb)); //file io는 파일은 생성 수정 삭제 등 할 수 있음.
			//f.createNewFile();
			//f.renameTo(f);//파일이름 바꿀때 핸들링
			//f.delete(); //해당 경로에 있는 파일 삭제시 사용한다.
			
			//agree파일 이동 코드 - 파일 이동시에는 nio가 필요함(path-interface)
			Path data1 = f.toPath(); // Paths.get(f); 이렇게 쓰게 되면 file을 url로 바꿔달라고 한다. / 다른 형태의 구조를 띤다 그래서 get으로 못 불러옴
			//data1을 io에서 nio로 객체형을 변환시켜야 한다.
			
			
			/*io와 nio를 혼용해서 사용하면 이렇게 변환해줘야한다.*/
			String url2 = "c:\\io\\agree.txt"; 
			File f1 = new File(url2);
			Path data2 = f1.toPath();
			
			/*StandardCopyOption.REPLACE_EXISTING - io에 있는 옵션
			기존 파일을 대체해서 해당 경로로 붙여넣기 하는 기능
			*/
			
			//Files.move(data1, data2, StandardCopyOption.REPLACE_EXISTING); //io랑 nio를 같이 쓰면 굉장히 복잡해진다. option을 붙여줘야 해서
			//이거 복사가 아님 파일 자체를 통째로 옮겨버림
			//move는 파일 이동
			
			//2. data2 -> data1으로 카피
			Files.copy(data2, data1); //c에서 d로 옮김.
			//파일 복사
			
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
		new io6_box().abc();
		}catch (Exception e) {
			
		}
	}

}


//nio 전용 코드
//files와 paths를 써야한다. nio는
//그냥 file 쓰면 io임 - file writer, fileread 등등

class io6_box{
	public void abc() throws Exception {
		//nio 형태로 디렉토리를 생성
		//Files.createDirectory(Paths.get("c:\\io"));
		
		//nio 형태로 path(interface)를 이용하여 파일 복사
		/*
		Path data1 = Paths.get("d:\\java_io\\list.txt");
		Path data2 = Paths.get("c:\\io\\list.txt");
		Files.copy(data1, data2); //copy(원본 경로, 사본 경로)
		*/
		
		/* 잘라내기 형태로 이동
		try {
		Path data3 = Paths.get("d:\\java_io\\agree2.txt");
		Path data4 = Paths.get("c:\\io\\agree2.txt");
		Files.move(data3, data4);
		}catch (Exception e) {
			System.out.println(e);
		*/
		
		//파일을 생성
		Path data5 = Paths.get("c:\\java_io\\agree3.txt");
		//Files.createFile(data5);
		Files.delete(data5); //파일 삭제
		
		
		
		
		
		
		}
	}
