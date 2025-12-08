package io;
//단일, 멀티 쓰레도 활용

public class th2 {
	public static void main(String[] args) {
		
		/* 단일 쓰레드 코드
		int w = 0;
		do {
			th2_box tb = new th2_box(w); //null값 넣어야해서 반복문 안에다 출력
			tb.zzz();
			w++;
		}while(w<500);
		*/
		
		//멀티쓰레드 호출 방식 (try catch가 필수조건임)
		try {
		int w = 0;
		do {
			th2_box tb = new th2_box(w); //null값 넣어야해서 반복문 안에다 출력
			Thread th = new Thread(tb); //Thread를 new 사용 시 쓰레드를 추가 이 코드에서는 10000개가 추가됨.
			th.start(); //run() 메소드를 호출해서 실행 - th 쓰레드 풀로 사용
			th.sleep(2000); //sleep 걸으면 쓰레드 재운다.
			//sleep은 무조건 try-catch 사용해서 처리해야함. / 어떤 쓰레드에 문제가 있는지 파악이 가능핟.
			//sleep thread가 휴식기를 거치는 상태 2000이면 2초
			w++;
		}while(w<10000);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}

//Thread 클래스를 활용하여 적용한 방식
class th2_box extends Thread{ //멀티쓰레드 사용
	int no = 0;
	public th2_box(Integer n) { //즉시 실행
		this.no = n;
	}
	public void zzz() { //여기서 위에꺼를 찍음
		System.out.println(this.no);
	}
	@Override
	public void run() { //멀티 쓰레드 실행
		this.zzz();
	}
}


/*단일 쓰레드 사용
class th2_box{
	int no = 0;
	public th2_box(Integer n) { //즉시 실행
		this.no = n;
	}
	public void zzz() { //여기서 위에꺼를 찍음
		System.out.println(this.no);
	}
}
*/