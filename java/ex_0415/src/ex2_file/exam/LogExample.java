package ex2_file.exam;

import java.io.File;

public class LogExample {
	public static void main(String[] args) {
		//logs폴더를 나타내는 File객체 만들기
		//폴더가 존재하지 않으면 "logs폴더가 없습니다."출력하고 종료하기
		//logs폴더 안의 파일 중 확장자가 .log인 파일만 찾기
		//.log파일의 이름과 크기를 바이트 단위로 출력하기
		//마지막에 .log파일 개수와 전체 용량 합계를 출력하기
		
		//출력예시
		//error.log - 1200byte
		//access.log - 3400byte
		//system.log - 800byte
		//.log파일 개수 : 3
		//전체 용량 : 5400byte'
		
		File f = new File("logs");
		
		if(!f.exists()) {
			System.out.println("logs폴더가 없습니다.");
			return;
		}
		
		File[] files = f.listFiles();
		
		if(files == null) {
			System.out.println("파일 목록을 읽을 수 없습니다.");
			return;
		}
		
		int count = 0;
		long totalSize = 0;
		
		for(File file : files) {
			if(file.isFile() && file.getName().endsWith(".log")) {
				System.out.println(file.getName()+" - " + file.length()+"byte");
				count++;
				totalSize += file.length();
			}
		}
		
		System.out.println(".log 파일 개수 : " + count);
		System.out.println("전체 용량 : " + totalSize+"byte");
		
		
		
		
		
		
		
		
		
		
		
	}
}
