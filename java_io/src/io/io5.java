package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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

	public static void main(String[] args) throws IOException{
		new io5_box().aaa();

	}

}


class io5_box{
	String url = "\\java_io\\interior_data.dat";
		
	public void aaa() {
	    try {
	        List<String> data = Files.readAllLines(Paths.get(this.url));
	        System.out.println(data);
	    } catch (IOException e) {
	        e.printStackTrace(); 
	    }
	}
} 







