package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//Buffered: byte의 내용을 temp 임시 실제 메모리에 저장

/*
buffering 사용전 => ssd,hdd => 외부 장치에 접근시 성능저하 발생(파일로드)
buffered => 실제 메모리를 활용하여 미리 파일에 대한 전체 용량을 읽어온다. 속도가 굉장히 빠르다.
(오류 발생시에도 메모리에 저장된 사항이므로 가능함)
저장시에도 buffered 모든 데이터를 순차적으로 저장할 수 있음. 

- stream(byte) => bufferedinputstream, bufferedoutputstream
- read/write(문자) => bufferedReader, bufferedwriter
*/
public class io15 {

	public static void main(String[] args) {
		String ori = "d:\\java_io\\java_io\\123.jpg";
		String copy_url = "c:\\io\\123.jpg";
		
		try {
			//cdn, streaming 서버에서 주로 활용한다.
			//특정 서버 활용할때 활용도가 높다.
			
			//InputStream: 입력 단에 부모 stream
			InputStream is = new FileInputStream(ori);//뭘 쓸지 모르니 가장 상위 부모 클래스 선언해놓는다.
			//원래는 byte를 거친 후 작성 but buffered는 코드가 달라짐
			BufferedInputStream bs = new BufferedInputStream(is); //버퍼 이용시 저장할 때도 버퍼를 활용해야함.
			//ssd, hdd => memory에 할당
			
			//OutputStream: 출력 단에 부모 stream
			OutputStream os = new FileOutputStream(copy_url); //버퍼 이용시 저장할 때도 버퍼를 활용해야함.
			//memory => ssd, hdd 저장
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			
			
			if(bs.available()>10485760) { //10mb
				System.out.println("이미지는 최대 10MB 이하의 파일만 업로드 가능");		
			}
			else {
				//메모리 버퍼를 얼만큼 사용할 것인지 정함
				byte[]by=new byte[1024*2];
				int read;
				
				//개발자가 설정한 메모리 규격에 맞게 파일을 핸들링 - 메모리임 하드에 있는게 아니라
				while((read=bs.read(by))!=-1) { //데이터 없을때까지 다 읽어들여라
					bos.write(by,0,read);
					
				}
				bos.flush(); //이거 넣어줘야 함. buffered 쓸 때 필수 
				bos.close();
				os.close();
				bs.close();
				is.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
