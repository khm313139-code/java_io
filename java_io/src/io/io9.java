package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//Stream => 이미지
public class io9 {

    public static void main(String[] args) {
        String url = "d:\\java_io\\java_io\\apink.webp";

        try {
        	//반복문을 활용하여 progress를 구현
            FileInputStream fs = new FileInputStream(url);
            //전체 파일의 총 용량을 100으로 나누어서 용량을 읽어들임.
            byte by[]=new byte[fs.available()/100];
            
            //신규 이름으로 해당 파일을 생성 및 저장하는 코드
            String url2 = "d:\\java_io\\java_io\\apink2.webp";
            FileOutputStream os = new FileOutputStream(url2);

            int i = 0; //읽은 바이트 수 
            int check = 0; //읽은 횟수
           
            while(true) { //무한루프를 이용하여 전체 용량을 모두 읽어드릴 수 있도록 함.
                i = fs.read(by); //byte 숫자(전체 용량을/100) => 분해해서 용량을 읽음.
                System.out.println(i);
                if(i==-1) {
                    break;
                }
                else {
                	//해당 byte만큼 지속적으로 이미지 용량을 조합
                    os.write(by,0,i); //(byte객체명, 읽을 숫자(시작 byte 숫자), 끝나는 byte 숫자)
                    //0으로 시작 안하면 이미지 깨질 수가 있음.
                }
                //다운로드에 대한 이미지 결합에 대한 %(진행률)을 확인
                check++;
                if(check % 2==0) {
                	System.out.println("현재 다운로드 진행률 : "+check+ "%");
                }
            }

            fs.close();
            os.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    } // main 끝
} // 클래스 끝

		
	
			
			/* 이코드는 일반 복사 형태 원본 파일 읽어서 사본으로 복사
			 * filewrite로는 이미지는 안된다. 메모장이나 이런건 가능
			FileInputStream fs = new FileInputStream(url);
			byte by[]=new byte[fs.available()];
			fs.read(by);
			
			String url2 = "d:\\java_io\\java_io\\apink2.webp";
			FileOutputStream os = new FileOutputStream(url2);
			os.write(by); //문자나 이런게 아니니 그냥 이미지니 복사하면 됨.
			os.flush();
			os.close();
			fs.close();
			*/
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//}
//}
//}
	


