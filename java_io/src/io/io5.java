package io;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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








