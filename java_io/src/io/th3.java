package io;

//멀티 쓰레드 interface

public class th3 {

	public static void main(String[] args) {
		th3_box tb = new th3_box();
		/* start와 run의 차이점
		
		tr.start(); => jvm(java virtual machine) 스케쥴러 새로운 쓰레드를 자동으로 호출 -> start는 기본 베이스가 멀티 쓰레드임.
		tr.run(); => 개발자가 직접 해당 메소드를 호출 (run을 쓰면 기본 조건을 안걸면 단일쓰레드를 사용하는 것과 마찬가지) / run은 사용하지 않는다 주로
		start를 쓰는게 가장 안정적 run은 모르는 것이 낫다.
		
		*/
		for(int f=0; f<100; f++) { //실제 실무에서는 반복문 안에 thread를 사용하지 않고, 각각 thread별로 핸들링 해야한다.
			//start를 반복문 안에 두면 new thread를 생성해야 한다. start는 밖으로 빼서 사용해야한다.
			tb.abc(f);
			Thread tr = new Thread(tb); //멀티 쓰레드 활용함. //각각 작업 할때마다 쓰레드를 하나씩 생성해서 넣어줘야함.
			try {
				tr.sleep(1000);
				tr.start();
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}
	}
}

/* 해당 쓰레드를 인터페이스로 사용하는 방법 - 그냥 보여주기 위해서 반복문 안에 thread를 사용 각각 핸들링해서 main 안에 넣고 각각 start 시켜야함.*/
class th3_box implements Runnable{ //100% 멀티 쓰레드 썼다. - runnable은 interface라 무조건 override해야함.
	int n = 0;
	
	public void abc(int z) {
		this.n=z;
	}
	@Override
	public void run() { //multi thread를 가동하는 메소드 (수정 절대 불가 - 인터페이스라서)
		
		System.out.println(this.n);
	}
}