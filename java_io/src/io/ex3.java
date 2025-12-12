package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.util.Base64.Decoder;

import javax.sound.sampled.Line;

//IO & NIO를 이용한 응용문제
//http://mekeyace.kbsn.or.kr/members.csv
//base64로 암호화 되어 있음
//ex3_box.java를 생성하여 해당 파일에 암호화를 비교하는 코드를 작성합니다.
//암호화는 base64 형태로 구성되어 있습니다.


//[실행]
//아이디를 입력하세요:
//패스워드를 입력하세요:

//해당 아이디 및 패스워드를 입력 받은 후 정상적인 로그인이 발생 시 다음과 같이 결과를 출력합니다.

//[성공]
//김지현님 환영합니다.

//[실패]
//아이디 및 패스워드를 확인하세요

/*
public class ex3 {

    public static void main(String[] args) {
        String url = "d:\\java_io\\java_io\\members.csv";
        Scanner sc = new Scanner(System.in);

        System.out.println("아이디를 입력하세요: ");
        String mid = sc.next();
        System.out.println("패스워드를 입력하세요: ");
        String mpw = sc.next();

        try {
            FileInputStream fr = new FileInputStream(url);
            InputStreamReader isr = new InputStreamReader(fr, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            List<List<String>> all3 = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                List<String> all2 = new ArrayList<>();
                String all1[] = line.split(",");
                for (String s : all1) {
                    all2.add(s.trim());
                }
                all3.add(all2);
            }

            br.close();
            isr.close();
            fr.close();

            boolean found = false;
            for (int i = 0; i < all3.size(); i++) {
                String id = all3.get(i).get(0).trim();
                String pwEncoded = all3.get(i).get(1).trim();
                String name = all3.get(i).get(2).trim();

                // CSV에 있는 Base64 비밀번호 디코딩
                String decodedPw = "";
                try {
                    byte[] decodedBytes = Base64.getDecoder().decode(pwEncoded);
                    decodedPw = new String(decodedBytes, "UTF-8");
                } catch (IllegalArgumentException e) {
                    System.out.println("잘못된 Base64 형식: " + pwEncoded);
                    continue;
                }

                // 디코딩된 비밀번호와 사용자 입력 평문 비교
                if (mid.equals(id) && mpw.equals(decodedPw)) {
                    System.out.println(name + "님 환영합니다.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("아이디 및 패스워드를 확인하세요");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/


 public class ex3 {
    
    public static void main(String[] args) {
        String url = "d:\\java_io\\java_io\\members.csv";
        Scanner sc = new Scanner(System.in);

        System.out.println("아이디를 입력하세요: ");
        String mid = sc.next();
        System.out.println("패스워드를 입력하세요: ");
        String mpw = sc.next();

        try {
            FileInputStream fr = new FileInputStream(url);
            InputStreamReader isr = new InputStreamReader(fr, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            List<List<String>> all3 = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                List<String> all2 = new ArrayList<>();
                String all1[] = line.split(",");
                for (String s : all1) {
                    all2.add(s.trim());
                }
                all3.add(all2);
            }

            br.close();
            isr.close();
            fr.close();

            // 사용자가 입력한 비밀번호를 Base64로 인코딩
            String mpwEncoded = Base64.getEncoder().encodeToString(mpw.getBytes("UTF-8"));

            boolean found = false;
            for (int i = 0; i < all3.size(); i++) {
                String id = all3.get(i).get(0);
                String pw = all3.get(i).get(1);
                String name = all3.get(i).get(2);

                if (mid.equals(id) && mpwEncoded.equals(pw)) {
                    System.out.println(name + "님 환영합니다.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("아이디 및 패스워드를 확인하세요");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 

