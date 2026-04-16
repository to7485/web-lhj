package ex3_bufferedstream.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class MemberExample {
	public static void main(String[] args) {
		//members.csv파일을 읽어서 나이가 30이상인 회원만 senior_members.txt파일로 저장하시오
		//데이터는 , 기준으로 분리한다.
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader("members.csv"));
			bw = new BufferedWriter(new FileWriter("senior_members.txt"));
			
			String line;
			
			while((line = br.readLine())!= null) {
				//1. CSV분리
				String[] data = line.split(",");
				String name = data[0];
				int age = Integer.parseInt(data[1]);
				
				//2. 조건 검사
				if(age >= 30) {
					bw.write(name +","+age);
					bw.newLine(); //개행을 해주는 메서드
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(bw != null) {
					bw.close();
				}
				
				if(br != null) {
					br.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}








