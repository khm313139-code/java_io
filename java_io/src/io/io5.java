package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

/*
응용문제 2
interior_data.txt에 저장되어 있는 값을 각 라인별로 배열처리 형태로 구성해야 합니다.
http://mekeyace.kbsn.or.kr/interior_data.txt

[결과]
[[1,3D 모델링 인테리어,3D,조나단],[3,2D 바위 mapping 이미지,2D,토마스],...]
get(0).get(1) => 3D 모델링 인테리어 출력이 되어야함.

배열 기준으로 제목만 출력이 되어야 함. (node 기준으로 1번)

[결과 예시]
[[1,3D 모델링 인테리어,3D,조나단],[3,2D 바위 mapping 이미지,2D,토마스],...]

*/


public class io5 {

	public static void main(String[] args) throws Exception{
		new io5_box().aaa();
	}

}

class io5_box{
	String url = "d:\\java_io\\java_io\\interior_data.txt";
	//주석 처리한 부분 빠르게 처리하는 부분
	//ArrayList<String[]> alldata =null;
	
	//원래 방식
	ArrayList<String> al = null;
	ArrayList<ArrayList<String>> alldata = new ArrayList<ArrayList<String>>();
	
	public void aaa()throws Exception {
		try {
			FileReader fr = new FileReader(this.url);
			//좀 더 빠르게 쓰려면 buffer 쓰면 됨.
			BufferedReader br = new BufferedReader(fr);
			
			Scanner sc = new Scanner(br);
			//this.alldata = new ArrayList<String[]>(); //이렇게 쓰면 동작이 안될수도 있음 정확하게 형을 넣어줘야함.
			while(sc.hasNext()) {
				String word[] = sc.nextLine().split(",");
				this.al = new ArrayList<String>(Arrays.asList(word));
				this.alldata.add(al);
				//this.alldata.add(word);
			}
			System.out.println(this.alldata);
			
			sc.close();
			fr.close();
		}catch(Exception e) {
			e.getMessage();
		}
	}
}





/* 내코드
public class io5 {

	public static void main(String[] args) throws Exception{
		io5_box ib = new io5_box();
		ib.aaa();

	}

}


class io5_box{
		
		public void aaa()throws Exception {
			String url = "\\java_io\\interior_data.txt";
			FileReader fr = new FileReader(url);
			Scanner sc = new Scanner(fr);
			ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
			while(sc.hasNext()) {
			String word = sc.nextLine();
			String abc[] = word.split(",");
			//System.out.println(Arrays.toString(abc));
			
			ArrayList<String> all = new ArrayList<String>();
			for(int i=0; i<abc.length;i++) {
				all.add(abc[i]);
			}
			al.add(all);
			
		}
			//System.out.println(al);
			
			System.out.println(al.get(1).get(1));
			
	}
}
*/







