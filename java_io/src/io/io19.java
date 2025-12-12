package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//http://mekeyace.kbsn.or.kr/user.csv

/*
 파일의 인코딩 된 언어셋 확인
 filereader fr = new filereader(url);
 system.out.println(fr.getencoding()); //해당 파일 저장형태의 언어셋이 뭐로 되어있는지 알 수 있는것이 getencoding임
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

//강사님 코드

public class io19 {
	private String url = "d:\\java_io\\java_io\\data.csv";
	private ArrayList<String> userdata = null;
	
	public static void main(String[] args) {
		String menu[] = {"SKT", "KT" , "LGT", "알뜰폰"};
		Scanner sc = new Scanner(System.in); //입력을 받아서 사용할 것으로 여기에 때림
		String cp ="";
		
		boolean ck = false;
		
		while(true) {
		System.out.println("통신사를 선택해 주세요 " + Arrays.toString(menu) +":");
			cp = sc.next();
			for(String m : menu) {
				if(cp.equals(m)) {
					
					
					
					ck=true;
					break; //이 브레이크는 for-each 브레이크임.
				}
			}
			if(ck==true) {
				break;
			}
			else {
				System.out.println("해당 메뉴에 맞는 단어만 입력하세요");
			}
			
		}
		ArrayList<String> data = new io19().corp(cp); //1차 배열 만든 것을 전달받아 출력시킴 아래 메소드에서 만들어서 올려버림
		System.out.println(data);
	
		sc.close();
	}

	//해당 파일을 로드 후 필요한 정보를 1차 클래스로 생성 후 return 하는 메소드
	public ArrayList<String> corp(String cp){
		
		//해당 통신사에 맞는 사용자만 정보를 저장하는 배열
		this.userdata = new ArrayList<String>();
		try {
			File f = new File(this.url);
			
			//byte로 로드 후 해당 문서 파일에 문자 내용을 확인하는 string으로 변환한 코드
			//변환과 동시에 언어셋을 적용하여 출력하는 형태
			
			InputStream is = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(is,Charset.forName("EUCKR"));
			BufferedReader bf = new BufferedReader(isr); //bufferedreader는 데이터 loss가 나니 아래꺼 닫아줘야함.
			//System.out.println(bf.readLine());
			
			
			String user;
			while((user=bf.readLine()) != null) {
				String ck[] = user.split(",");
				for(String c : ck) {
					if(c.equals(cp)) {
						this.userdata.add(ck[0]);
						break;
					}
				}
			}
			//System.out.println(this.userdata);
			
			bf.close();
		} catch (Exception e) {
			this.userdata = null;
		}
		
		return this.userdata;
	}
		
}







/* 내코드
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
*/
