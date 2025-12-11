package io;

//nio의 필수조건: buffer, channel, selector 멀티 플렉싱 도구들


import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.output.WriterOutputStream;

//nio에 대한 path에 경로형태
public class nio2 {

	public static void main(String[] args) {
		
		Path path1 = Paths.get("c:\\test\\"); //디렉토리가 하나가 있고
		Path path2 = Paths.get("c:\\test\\images\\123.jpg");
		Path relative  = path1.relativize(path2);
		//System.out.println(relative);
		
		
		/* 이런 식으로 해야함. 
		 * relativize: 현재 자신이 위치한 곳에서 다른 경로의 파일을 로드할 경우 정확한 위치 파악을 할 수 있는 용도로 사용
		 */ 
		Path path5 = Paths.get("/c/test");
		Path path6 = Paths.get("/c/images/123.jpg");
		Path relative3 = path5.relativize(path6);
		//System.out.println(relative3);
		
		
		Path path3 = Paths.get("/home/product");
		Path path4 = Paths.get("/home/admin/admin.html");
		Path relative2 = path3.relativize(path4); //원래는 이런식으로 사용해야함 relativize는 product 안에 admin 안에 admin.html 그래서 찾는거임 ..\admin\admin.html 이런식으로 
		//System.out.println(relative2);
		
		
		
		
		
		//정통 nio만 사용
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("이게 nio 입니다. ㅎㅎㅎ");
			sb.append("이게 nio 입니다. ㅎㅎㅎ");
			sb.append("이게 nio 입니다. ㅎㅎㅎ");
			
			Path pt = Paths.get("c:\\test\\123.txt");
			Files.writeString(pt, sb); //files.writestring: nio에 해당 파일 오픈하여 바로 저장가능
			String word = Files.readString(pt); //readstring : 메모리에서 해당 경로에 파일을 가져와서 출력
			//System.out.println(word);
			//Files.deleteIfExists(pt); -> 삭제시 사용 파일, 디렉토리 삭제가능 (파일이 있을 경우 불가능)
			
		}catch (Exception e) {

		}
		new nio2_box().abc();
	}
}


//드라이브 전체의 파일 보기
class nio2_box{
	public void abc() {
		//filesystem: 시스템 전반적인 정보를 확인 할 수 있는 클래스
		try {
			FileSystem fs = FileSystems.getDefault();
			//getfilestores() : 모든 디스크의 정보를 가져옴 (배열)
			for(FileStore st : fs.getFileStores()) {
				System.out.println("드라이브명 : " + st.name());
				System.out.println("파일시스템 : " + st.type());
				System.out.println("전체공간 : " + st.getTotalSpace());
				System.out.println("여유 공간 : " + st.getUsableSpace());
				System.out.println("사용중인 공간 : " + (st.getTotalSpace()-st.getUsableSpace()));
			}
		}catch (Exception e) {
			
		}
	}
}
