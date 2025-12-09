package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//동영상 stream으로 처리
public class io10 {

	public static void main(String[] args) {
		String url = "";
		Scanner sc = new Scanner(System.in);
		try { //throws를 써도 되지만 문제가 터지면 어디서 터졌는지 알 수 없기에 try-catch 쓰는 것이 좋다.
		System.out.println("복사할 동영상 경로를 입력하세요: ");
		url = sc.nextLine();//경로에 공백을 넣을 수 있음.
		
		FileInputStream fs = new FileInputStream(url);
		byte file[] = new byte[fs.available()]; //이건 한번에 읽어도 되지만 외부에서 쓸거면 fs.available()/100으로 끊어서 써줘야함.
		fs.read(file); // 이 read는 fileinputstream에 있는 read
		
		Date dt = new Date();
		/* 같은 파일명일 경우 덮어쓰기가 되어버린다. 그러면서 그 전에 복사가 된 영상이 사라져버리고 새로 복사된 영상이 저장된다.
		 * 그러므로 yyyyMMddHHmmss 여기도 우연의 일치로 같을 수 있음.
		 * 그래서 random()을 사용 => yyyyMMddHHmmss_숫자 8자리를 랜덤으로 형성해버림 */
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String rename = df.format(dt);
		
		String copys = "c:\\io\\"+rename+".mpeg"; //이렇게 속성도 바꿀 수 있다. 동영상 파일도 복사할 수도 있고
		//속성 형태만 바꾸는 것이지 인코딩이나 디코딩을 하는 것이 아니다 인코딩하고 관계가 없다. 그냥 파일 형식만 바뀌는 것
		FileOutputStream os = new FileOutputStream(copys);
		os.write(file);
		os.flush();
		os.close();
		fs.close();
		sc.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
