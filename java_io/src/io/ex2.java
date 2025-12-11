package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
응용문제 2
user.csv 파일을 로드하여 해당 사용자 통신사별로 각각의 파일로 저장 되도록 해야합니다.
skt_user.csv
kt_user.csv
lgt_user.csv
etc_user.csv

*/

public class ex2 {
	
	public static void main(String[] args) {
		String url = "d:\\java_io\\java_io\\data.csv";
		String filenm[] = {"skt_user.csv","kt_user.csv","lgt_user.csv","etc_user.csv"};
		Path base = Paths.get("d:\\java_io\\java_io\\create");
		
		
		try {
			Files.createDirectories(base);
			
			
			
			//csv 파일 읽기
			FileInputStream fr = new FileInputStream(url);
			InputStreamReader isr = new InputStreamReader(fr, "euc-kr" );
			BufferedReader br = new BufferedReader(isr);
			
			List<List<String>> all2 = new ArrayList<>();
			String data;
			
			
			while((data=br.readLine()) != null) {
			String parts[] = data.split(",");
			//System.out.println(Arrays.toString(parts));
			List<String> al = new ArrayList(Arrays.asList(parts));
			
			all2.add(al);
			}
			System.out.println(all2);
			
			
			
			
			
			//조건별 파일 생성
			for(List<String> al2 : all2) {
				
				
				String move = al2.get(1).toLowerCase();
				String file;
			
				switch (move) {
                case "skt":
                    file = base + "\\skt_user.csv";
                    break;
                case "kt":
                    file = base + "\\kt_user.csv";
                    break;
                case "lgt":
                    file = base + "\\lgt_user.csv";
                    break;
                default:
                    file = base + "\\etc_user.csv";
                    break;
            }

            // 파일 작성 (있으면 이어쓰기)
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(String.join(",", al2));
                bw.newLine();
            }
        }

        System.out.println("통신사별 CSV 생성 완료!");
    }catch (Exception e) {
		// TODO: handle exception
	}
}
}

