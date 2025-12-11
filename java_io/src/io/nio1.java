package io;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

//nio로 모든 파일 및 디렉토리를 핸들링
//파일 생성 삭제 하는 것만 잘 알면 됨.
public class nio1 {

	public static void main(String[] args) throws Exception{
		try {
			
			Path url1 = Paths.get("c:\\"); //1 순위 셋팅 절대 경로 / 절대 경로로 핸들링해서 잡아야만 정상적인 운영방식이 됨. 
			//디렉토리 생성
			//Files.createDirectories(Paths.get(url1+"test")); //이거는 절대 io처럼 쓰면 안됨
			/* 파일 복사 
			Path data1 = Paths.get("d:\\java_io\\java_io\\123.jpg");
			Path data2 = Paths.get("c:\\test\\123.jpg");
			
			//덮어쓰기 기능도 있음 standardcopyoption.replace_existing(덮어쓰기 기능)
			//Files.copy(data1, data2,standardcopyoption.replace_existing) => 이런 식으로 사용
			//files.copy :복사를 적용하고 읽기전용 해당 복사파일을 삭제할 수 없음 but standardcopyoption.replace_existing 이거 사용시
			//복사하는 파일을 즉시 삭제가 가능하다.
			 
			 
			
			Files.copy(data1, data2);
			*/
	
			/* 파일 삭제
			Path data3 = Paths.get("c:\\test\\123.jpg");
			Files.delete(data3);
			*/
			
			/* 빈 파일을 강제 생성
			Path data4 = Paths.get("c:\\test\\aaa.jpg");
			Files.createFile(data4);
			*/
			
			/*	
			Path data5 = Paths.get("c:\\test\\"); //정상적인 디렉토리 전체 경로를 넣어줘야 함.
			Files.delete(data5); // 안에 파일이 있으면 삭제가 안됨
			//아무것도 없어야함.
			*/
			
			
			//foreach로 path를 핸들링 할 수 있음.
			//nio는 close가 없다.
			
			Path data6 = Paths.get("c:\\test\\");
			Stream<Path> st = Files.list(data6);
			//stream이란: nio 전용 클래스 배열임.
			//원시 배열 쓰는 것은 io임 stream은 클래스 배열
			//System.out.println(st);
			
			//forEach : 배열을 기본으로 하는 반복문
			st.forEach(aaa -> { //aaa : string아니다.
				//System.out.println(aaa);
				
				/* 파일명만 출력하기 위한 코드
				String fileurl = aaa.toString();
				int n = fileurl.lastIndexOf("\\");
				System.out.println(fileurl.substring(n+1));
				*/
				
				/* 파일명을 사용하여 삭제하는 방법
				try {
					Files.delete(aaa);
				}catch (Exception e) {
					System.out.println("해당 파일은 권한이 없어서 지우지 못함.");
				}
				*/
							
				/* 파일명만 출력하기 위한 코드
				Path filenm = data6.getFileName();
				System.out.println(filenm);
				*/
				
				/* 파일명을 사용하여 삭제하는 방법 키워드 사용
				//이건 실질적으로 웹에서 사용 => java.nio.file.api
				//relativize: 절대경로를 상대경로를 기능으로 설정
				//상대경로 ../home/abc/123
				Path filenm = data6.relativize(aaa); //relativize는 메소드
				//디렉토리 안에 있는거 싹다 가져와임 그래서 다가져옴
				System.out.println(filenm);
				*/
			}); 
			
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
