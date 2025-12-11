package io;
import java.io.File;
//io 및 nio에 추가 클래스 형태
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Scanner;

//파일에 권한 속성을 설정하는 형태
//permission: read(r)-4: 읽기 전용, write(w)-2: 쓰기, excute(x)-1: 실행 , -> 최대 숫자 7
//r-x => 읽기랑 실행만 가능 5 / r-- => 4 / -wx => 3 / rwx => 7

public class io21 {

	public static void main(String[] args) {
		String ori_file = "d:\\java_io\\java_io\\array.csv";
		String cp = "c:\\io\\array.csv";
		try {
		//=> 실무에서는 큰 파일 위주로 사용할 경우 주로 사용한다.
		//randomaccess: 개발자가 해당 파일 속성 권한을 설정할 수 있음.
		RandomAccessFile file = new RandomAccessFile(ori_file, "r"); //randomaccessfile은 일반 io가 아님 nio랑 같이 써도 어려워지지 않는다.
		//ori_file, "r" rw로 쓸수도 있음 그럼 java에서 핸들링 가능
		
		RandomAccessFile file2 = new RandomAccessFile(cp, "rw"); //복사할 대상
		//w만 사용할수도 있는데 array.csv 파일이 미리 c드라이브에 만들어져야 w만 사용할 수 있다. 왜냐 r이 아니므로 읽어올 수가 없으니까
		
	
		
		//FileChannel(mio) : IO에서 (Fileinputstream + fileoutputstream)을 결합시켜 놓은 것이다.
		FileChannel fc = file.getChannel(); //getchannel은 RandomAccessFile을 가져오는 역할임(채널을 열어서 사용하는 구조)
		
		FileChannel target = file2.getChannel(); //얘는 쓰기 권한이 필요한데 복사할 파일에 r만 때려놓으면 작동이 안된다. w가 있어야함
		
		//transferFrom => write 기능을 향상시킴 - 최대 메모리로 2gb를 한반에 복사할 수 있음 그래서 2gb이상의 api 서비스를 만들때 주로 사용
		target.transferFrom(fc, 0, fc.size()); //복사할 파일, 배열(0번), 파일전체 사이즈
		
		target.close();
		fc.close();
		file2.close();
		file.close();
		
		}catch(Exception e) {
			System.out.println(e);
		}
		new io21_box().abc();
	}

}



//scanner => io형태로 구현 한다. => .log 같은것을 처리 할 때 사용
class io21_box{
	Scanner sc = null;
	public void abc() {
		try {
			String url ="c:\\io\\";
			this.sc = new Scanner(new File(url+"game.log")); //파일을 가져와서 핸들링을 하겠다.
			while(this.sc.hasNext()) {
				System.out.println(this.sc.nextLine());
			}
			
		}catch(Exception e) {
			
		}finally {
			this.sc.close();
		}
	}
}