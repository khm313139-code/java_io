package io;

import java.io.*;
import java.nio.file.*;
import java.util.*;

//io(blocking) 라이브러리: stream 기반 (메모리) => 간단한 파일 입출력 / 단일 thread 처리 느낌
//nio(non-blocking) 라이브러리(io 개선판): buffer 기반 (메모리) => 네트워크 서버 및 클라우드에 연결처리(고성능 앱) 멀티 thread 처리 느낌
//nio장점 new를 사용하지 않아도 된다.
//nio단점 메모리 할당량이 많아서 서버에도 메모리가 많아야 한다.

public class io3 {
	public static void main(String[] args) throws Exception{
		new io3_box().abc();

	}

}

class io3_box{
	String url = "D:\\java_io\\array.txt";
	public void abc() throws IOException{
	  // files: nio 라이브러리 이며, readAllLines: 메모리로 파일을 한번에 모두 읽어들임.
	  // 메모리 사용량이 많아짐
	  // paths: 파일 경로 및 파일 생성등 다양한 형태로 구현 가능
	  // paths.get: 경로를 설정
		
	  List<String> data = Files.readAllLines(Paths.get(this.url));
	  System.out.println(data);
	  //위에 코드는 파일을 닫을 필요도 없음 자기가 알아서 닫음
	
	
	  //파일 형식이 byte 단위이므로 string 쓸 수 없음. arrays 이런거 못씀
	  //byte의 원시배열로 로드 후 new string() => 문자열 인스턴스로 출력
	  byte[] data2 = Files.readAllBytes(Paths.get(this.url));
	  System.out.println(new String(data2));
	  
	  //nio의 단점 : 메모리 할당 많아짐 / 한글 언어 패킷을 조정해야함.
	}
}