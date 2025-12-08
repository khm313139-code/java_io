package io;
/*
Thread란 기본으로 1core - 1thread로 작동합니다. - oop 1thread
Java => multi thread를 이용하여 개발 환경에 다양한 작업을 구현할 수 있다. 
단, web => 단일 쓰레드 사용, API 구성 => Multi thread 사용가능(msa)


*/
public class th1 {

	public static void main(String[] args) {
		
		/*
		new th1_box().aaa(); //단일 쓰레드
		new th1_box().bbb(); //단일 쓰레드
		*/
		
		
		th1_box2 th2=new th1_box2();
		th2.start(); //thread 클래스를 활용하여 run() 이라는 메소드를 가동
		th1_box2 th3=new th1_box2();
		th3.start();
		
		
		/*
		Thread tr = new Thread(th2); //이렇게 호출해도 됨 / th2를 생성자로 두고 th2.start()해도 되고 tr만들어서 해도 됨.
		//이렇게 선언하면 쓰레드를 무조건 활용하겠다는 소리.
		tr.start(); //thread를 활용할거다 라는 의미 run으로 돌려도 됨
		*/
	}
}

class th1_box3 extends Thread{ //이렇게 thread를 하나 추가할 수도 있음
	
}


class th1_box2 extends Thread{ //Thread => multi
	
	public void aaa() {
		int w = 0;
		do {
			System.out.println("aaa: "+w);
			w++;
		}while(w<60);
	}
	
	public void bbb() {
		int w = 0;
		do {
			System.out.println("bbb: "+w);
			w++;
		}while(w<60);
	}
	
	@Override
	public void run() { //여기서 작동을 시킴 / 멀티쓰레드 사용하려면 run이 필요함.
		//멀티쓰레드 클래스를 적용한 메소드(기본 메소드)
		this.aaa(); //멀티쓰레드를 활용하여 작동
		this.bbb();
		
	}
	
}




/*
//단일 쓰레드 활용법
class th1_box{ //단일 thread
	public void aaa() {
		int w = 0;
		do {
			System.out.println("aaa: "+w);
			w++;
		}while(w<41);
	}
	
	public void bbb() {
		int w = 0;
		do {
			System.out.println("bbb: "+w);
			w++;
		}while(w<41);
	}
}
*/




