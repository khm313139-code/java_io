package io;
//io 리뷰
//string, char(잘 안씀)

/*

io를 사용하는 경우 => 간단한 파일처리, 단순한 파일 저장 기능 (얘는 무조건 답변을 받아야 메세지를 보낼 수 있음 채팅이라 가정시)
nio => cdn서버, streaming 서버, 채팅서버, storage 서버(스토리지 서버)(쉽게 설명하면 얘는 채팅이라 가정시 채팅을 할때 답변이 없어도 계속 입력 가능)



i/o에 대한 파일(읽기,쓰기) 용량 => 20mb(최대로 하더라도) / io는 동기통신, 단방향 통신(입력받고 출력하는)
string, char => 문서 파일
filereader, filewriter => disk 쓰기, 읽기 형태에 사용 => scanner로 출력
bufferedreader, bufferedwriter => buffer기반(메모리) 성능향상 buffer가 file을 그냥 scanner로 읽는거보다 훨 빠르다.
=> 단독 사용은 안됨. filereader라던가 writer를 써야함.
여러개 데이터를 한꺼번에 보낼 떄는 buffer가 필요함.

9번대 이상은 buffer만 close 해도 되지만
8번대 이하는 다 close 해야함.


//주의사항 : string => byte로 변환시 (getbytes())라는 메소드를 활용해 변환 처리를 한 후 => available로 처리
stream => byte형태로 동작(이미지, pdf, 동영상, 음악, 문서 ...)
inputstream(부모) => fileinputstream, audioinputstream...
outputstream(부모) => fileoutputstream, audiooutputstream...

bufferedinputstream, bufferedoutputstream => buffer기반(메모리) 성능향상 / 단독 사용 불가능
(read, readline)

---------------------------------------------------------------------------------------------------

NIO 라는게 생성 => 비동기 통신으로 파일처리를 하는 방식임
기본은 stream 방식
stream, buffer, channel 방식으로 동작
대용량, 고성능, 양방향 통신
nio는 주로 path로 핸들링 시작
path => paths
randomaccessfile <=> channel(channel가져온 것을 랜덤 access로 핸들링)
files => createfile(), createdirectory(), delete(), copy(), move(), writestring(), readstring() / copy는 조금 옵션이 붙는다.
nio는 실시간으로 바로 저장해서 끝내버리는 장점이 있음 속도가 빠르다.

----------------------------------------------------------------------------------------------------

fileinputstream => inputstreamreader => bufferedreader 로 변환시 중간에 브릿지가 필요함(바이트 단위에서 변환을 해야 하니)
fileoutputstream => outputstreamwriter => bufferedwriter => write 후에 flush를 꼭 해줘야함 write 시
filewriter => byte[] getbytes() => fileoutputstream
*/

public class review1 {

	public static void main(String[] args) {
		

	}

}
