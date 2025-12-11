package io;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.*; //Decoder(복호화), Encoder(암호화)

//encryption -> 암호화

public class encry {

	public static void main(String[] args) {
		//base64 => 기본 암호화
		//encoder => 문자를 암호화
		String password = "java123456"; //문자니 byte로 바꿔야함.
		byte[] word = password.getBytes();
		Encoder bs = Base64.getEncoder();
		byte[] word2 = bs.encode(word);
		//System.out.println(new String(word2));
	
		
		//decoder => 암호화 문자를 원본 문자로 복호화 
		String password2 = "amF2YTEyMzQ1Ng==";
		byte[] word3 = password2.getBytes();
		Decoder bs2 = Base64.getDecoder();
		byte[] word4 = bs2.decode(word3);
		//System.out.println(new String(word4));
		
		new encry_box().bbb();
	}

}


//개인정보 -> 패스워드, 카드정보(BASE64) - PG사에서도 암호화 된 걸 받는다. , 결제시 => SHA-1, 로그기록, 계좌 비밀번호 
//비대칭키 암호화 => AES, DES, RSA, ECC (다운 받아서 사용하는 것)

class encry_box{
//md5-sha => 복호화 x 해시
//SHA-3 => JDK 10이상 추천
//MD5 => 요즘에 많이 쓰는 암호화 알고리즘 SHA-2 이상인데 이거는 MD5보다 더 발전된 형태
//SHA는 SHA-1, SHA-2(224bit,256bit,384bit,512bit형태임), SHA-3(HASH 코드가 사용됨) SHA3-256 이런식으로 사용해야함 => byte 형태
	public void bbb() {
		String pw = "a1234"; //828c88f34ecb4c1ca8d89e18c6fad1a
		try {
			
			//MessageDigest => 해당 문자열을 암호화 형태로 구성하는 클래스
			
			MessageDigest md = MessageDigest.getInstance("SHA3-512");//java security - 보안 관련 암호화 알고리즘 직접 사용
			/* 원래 정석 코드
			byte[] repw = pw.getBytes();
			md.update(repw);*/
			md.update(pw.getBytes()); //해당 문자열을 byte 단위로 변경
			//이건 무조건 for-each 써야함 일반 반복문은 어려움
			byte md5_pw[] = md.digest(); //byte로 변화된 값을 return 
			
			String sb = "";
			//반복문을 돌린다. - 어떤 형태로 암호화를 구성화 할 것인지를 정한다.
			for(byte a: md5_pw) {
				//%X (대문자 영문), %x (소문자 영문) - a~f까지만 조합
				//0123456789 10(a) 11(b) ~~~~ 15(f) 까지임
				sb += String.format("%02x", a); //%x => 영문, 숫자 조합 (16진수에 소문자만 입력을 받겠다.)
				
				//"%01x" => 1자리 문자 1234 => 1,2,3,4
				//"%02x" => 2자리 문자 1234 => 01,02,03,04
				
				//0을 포함하냐 안하냐에 따라 0이 추가 되고 안되는 형태가 있음
				//"%01x" -> 828c88f34ecb4c1ca8d89e18c6fad1a
				//"%02x" -> 828c88f34ecb4c1ca8d89e018c6fad1a
				
			}
			System.out.println(sb);
			
			
			
		}catch (Exception e) {
			
		}
	}
}



