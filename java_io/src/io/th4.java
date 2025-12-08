package io;
//멀티 쓰레드 응용편 - 실제 핸들링 과정

public class th4 {

	public static void main(String[] args) {
		Integer data1[] = {10,20,30,40,50,60,70,80,90}; //하나의 쓰레드를 이렇게 오류가 발생하게 처리해도 나머지 쓰레드는 작동한다.(멀티 쓰레드)
		Integer data2[] = {5,10,15,20,25,30,35,40,45};
		Integer data3[] = {7,14,21,28,35,42,49,56,63,null}; //하나의 쓰레드를 이렇게 오류가 발생하게 처리해도 나머지 쓰레드는 작동한다.(멀티 쓰레드)
		
		//각각의 thread를 활용하여 배열값을 처리하는 코드 단, 실행할 때마다 다른 결과가 출력됨(처리 순서가 다르기 때문)
		th4_box tb1 = new th4_box(data1); //즉시실행이라서 data1처럼 매개변수 넘겨줘야한다.
		Thread tr1 = new Thread(tb1);
		th4_box tb2 = new th4_box(data2);
		Thread tr2 = new Thread(tb2);
		th4_box tb3 = new th4_box(data3);
		Thread tr3 = new Thread(tb3);
		
		//쓰레드 활용
		tr1.start();
		tr2.start();
		tr3.start();
	}
}


class th4_box extends Thread{
	int sum = 0;
	private Integer datas[] = null; //원시배열 받은것 핸들링
	
	public th4_box(Integer data[]) { //즉시실행
		this.datas=data;
	}

	
	@Override
	public void run() { //run 자체는 return이 없다 기본 형이 void
		
		try { //run안에 try-catch 가능
		for(Integer f=0; f<this.datas.length; f++) {
			this.sum += this.datas[f];
			
		}
			System.out.println("배열의 전체 값: "+this.sum);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}