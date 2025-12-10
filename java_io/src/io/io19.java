package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//http://mekeyace.kbsn.or.kr/user.csv

/*
 파일의 인코딩 된 언어셋 확인
 filereader fr = new filereader(url);
 system.out.println(fr.getencoding());
 * 
응용문제 1
다음 프로세서를 실행하는 코드를 작성하시오. 고객데이터는 user.csv의 파일을 이용하여 사용해야 합니다.

[실행]
통신사를 선택해 주세요: [SKT,KT,LGT,알뜰폰] : 
잘못 입력 시 : 해당 메뉴에 맞는 단어만 입력하세요 가 출력되고 다시 메뉴가 출력

[결과]
통신사를 선택해 주세요 [SKT,KT,LGT,알뜰폰] : LGT
[김준수, 신유빈, 윤하빈, 조선경, 황인호]

*/

public class io19 {

	public static void main(String[] args) {
		String url = "d:\\java_io\\java_io\\data.csv";
		Scanner sc = new Scanner(System.in);
		
		
		try {
		FileInputStream fr = new FileInputStream(url);
		InputStreamReader isr = new InputStreamReader(fr,"euc-kr");
		BufferedReader br = new BufferedReader(isr);
		String data = "";
		
		List<String> al = new ArrayList<String>();
		while((data=br.readLine())!=null) {
			//System.out.println(data);
		al.add(data);
		
		}
		br.close();
		
		
		
		//System.out.println(al);
		String array[] = al.toArray(new String[0]);
		//System.out.println(Arrays.toString(array));
		
		List<String[]> al2 = new ArrayList<String[]>();
		
		for(String line: array) {
			String[] row = line.split(",");
			al2.add(row);
		}
		
		String[][] array2= al2.toArray(new String[0][]);
		
		//System.out.println(Arrays.toString(array2));
		
		String[] valid = {"SKT","KT","LGT","알뜰폰"};
		
		while(true) {
		System.out.println("통신사를 선택해 주세요 " + Arrays.toString(valid) +":");
		String sel=sc.nextLine();
		
		
		boolean found = false;
		for(String s : valid) {
			if(s.equals(sel)) {
				found = true;
				break;
			}
		}
		
		if(!found) {
			System.out.println("잘못된 입력입니다.");
		}
		else{
			System.out.println(sel + "선택 완료!");
			for(int i = 0; i<array2.length; i++) {
				if(array2[i][1].equals(sel)) {
					System.out.println(array2[i][0]);
			}
		}
			break;
		}
		
		
		
		}
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
