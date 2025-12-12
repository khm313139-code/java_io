package io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;

//2025-12-11
/*
응용문제 1
해당 정보를 입력시 사용자 개인정보를 클래스 배열에 저장하는 코드를 작성합니다.
단, 다음과 같이 실행 되어야 합니다. 암호화는 (md5) 입니다.

[실행] - ship.txt에 있는 질문사항을 순서대로 출력하여 사용자가 입력하는 프로세서 입니다.
아이디를 입력하세요: hong
패스워드를 입력하세요: a123456
이메일을 입력하세요: hong@nate.com
연락처를 입력하세요: 01012345678

[결과]
[hong,ef012355687cd0133,hong@nate.com,01012345678]
*/


public class ex1 {
    ex1_box eb = new ex1_box(); // 암호화 model
    Scanner sc = null;
    ArrayList<String> userinfo = null;
    String url = "d:\\java_io\\java_io\\ship.txt";

    public static void main(String[] args) {
        ex1 program = new ex1(); // 객체 생성
        program.member_ship();   // member_ship 메서드 호출
    }

    public void member_ship() {
    	File f = new File(this.url);
    	this.sc = new Scanner(System.in);
    	this.userinfo = new ArrayList<String>();
    	
        try {
        	FileReader fr = new FileReader(f);
        	BufferedReader br = new BufferedReader(fr);
        	
        	
        	String qc = "[회원가입]"; //실행이 되어 한칸 공백이 발생한다. - do~while의 단점
        	int count = 0;
        	do {
        		
        		System.out.println(qc);
        		if(!qc.equals("[회원가입]")) {
        			String userdata = this.sc.nextLine();
        			if(count==1) { //패스워드 입력단계
        				userdata  = this.eb.md5_encode(userdata);
        				
        			}
        			this.userinfo.add(userdata);
        		
        			count++;
        		
        		}
        		
        	}while((qc=br.readLine())!= null); 
        	System.out.println(userinfo);
        	
        	br.close();
        	
        	
        	
        	
        	
           
        	
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}












/* 내 코드
public class ex1 {

	public static void main(String[] args) {
		
		
		
		
		
		String url = "d:\\java_io\\java_io\\ship.txt";
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> al = new ArrayList();
		
		try {
		InputStream is = new FileInputStream(url);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		
		
		System.out.println(br.readLine());
		String id = sc.next();
		System.out.println(br.readLine());
		String pw = sc.next();
		
		try {
			pw = md5(pw);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(br.readLine());
		String em=sc.next();
		System.out.println(br.readLine());
		String tel=sc.next();
		
		al.add(id);
		al.add(pw);
		al.add(em);
		al.add(tel);
		
		System.out.println(al);
		
		br.close();
		
		}catch(Exception e){
			System.out.println(e);
		
		}
		
		}
	
	//pw에 매개변수 던져서 암호화 시킴
	public static String md5(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        //배열화 시켜서 받음
        byte[] digest = md.digest(input.getBytes());
        //stringbuilder는 받은 문자열을 연결시켜서 출력시키는 역할
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%01x", b & 0xff));
        }
        return sb.toString();
    }

}
*/
