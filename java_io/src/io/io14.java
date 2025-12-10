package io;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

//io13과 연결
public class io14 {

	Date today = null;
	SimpleDateFormat sf = null;
	Random rd = null;
	
	//이름 변경
	public String renames(String filenm) {
		this.today = new Date();
		this.sf = new SimpleDateFormat("yyyyMMdd");
		this.rd = new Random(); //5라는 것은 난수임 난수열을 5번 호출한다는 것
//		new Random(5); random에 5를 넣어준 것은 이렇게 5번 호출한다는 것을 의미
//		new Random(5); random을 즉시실행 구조로 만들어준것
//		new Random(5);
//		new Random(5);
		int no = this.rd.nextInt(); //음의 정수도 나옴
		
		if(no<0) { //음의 정수를 양의 정수로 바꿈
			no=-no;
		}
		int idx = filenm.lastIndexOf(".");
		String type = filenm.substring(idx); //substring(0,5) 이런식으로 들어가야 함 원래 뒤에 있는게 자릿수
		
		String renames = this.sf.format(today)+no+type;
		
		return renames;
		
	}
}
