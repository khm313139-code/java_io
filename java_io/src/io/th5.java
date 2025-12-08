package io;
/*

응용문제 1. - 멀티 쓰레드 활용
다음의 결과처럼 나오도록 멀티 쓰레드를 활용하여 처리하시길 바랍니다.
integer data[] = {6,9,10,15,3,17};

해당 배열의 데이터를 기준으로 다음과 같이 실행됩니다.

[결과]
총 배열의 합산 결과:
총 배열의 곱한 결과:
*/
public class th5 {

	public static void main(String[] args) {
		Integer data[] = {6,9,10,15,3,17};
		th5_box1 tb1 = new th5_box1(data,"+");
		th5_box1 tb2 = new th5_box1(data,"*");
		
		Thread th1 = new Thread(tb1);
		Thread th2 = new Thread(tb2);
		
		th1.start();
		
		th2.start();
	}
}


class th5_box1 extends Thread{
	private Integer ldata[] = null;
	String part = "";
	public th5_box1(Integer data[], String munja) {
		this.ldata=data;
		this.part=munja;
	}
	
	@Override
		public void run() {
			Integer total = 0;
			Integer total2 = 1;
			for(Integer a : this.ldata) {
				if(this.part=="+") {
					total += a;
				}
				else {
					total2 *= a;
				}
			}
			if(this.part=="+") {
				System.out.println(total);
			}
			else {
				System.out.println(total2);
			}
			
		}
}
	
	
	
	
// 내코드
//	public static void main(String[] args) {
//		Integer data[] = {6,9,10,15,3,17};
//	
//		th5_box1 tb1 = new th5_box1(data);
//		th5_box2 tb2 = new th5_box2(data);
//		Thread t2 = new Thread(tb2);
//		
//		tb1.start();
//		t2.start(); //runnable
//	}
//}
//
//class th5_box1 extends Thread{
//	private Integer datas[] = null;
//	public th5_box1(Integer data[]) {
//		this.datas = data;
//	}
//	@Override
//	public void run() {
//		
//		int sum = 0;
//		for(int i = 0; i<datas.length; i++) {
//			sum = sum+datas[i];
//		}
//		System.out.println("총 합: "+sum);	
//		
//	}
//}
//
//class th5_box2 implements Runnable{
//	private Integer datas[] = null;
//	public th5_box2(Integer data[]) {
//		this.datas = data;
//	}
//	
//	@Override
//	public void run() {
//		int mul = 1;
//		for(int ii = 0; ii<datas.length; ii++) {
//			mul = mul*datas[ii];
//		}
//		System.out.println("총 곱: "+mul);	
//		
//	}
//}