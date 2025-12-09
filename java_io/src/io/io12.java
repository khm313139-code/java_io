package io;

//파일을 이용하여 원시배열에 각각의 디렉토리에 있는 파일 리스트를 삽입함.
import java.io.File;
import java.util.Arrays;

public class io12 {

	public static void main(String[] args) {
		String url = "c:\\io\\"; //경로
		File fe = new File(url);
		File files [] = fe.listFiles();//io는 원시배열 nio는 클래스배열
		//listfiles => 해당 디렉토리에 접근하여 파일명 배열화 / class배열로도 핸들링 할 수 있다.
		System.out.println(Arrays.toString(files)); 
		//System.out.println(files[0]);
		for(File aa : files) {
			System.out.println(aa);
		
		}
	}

}
