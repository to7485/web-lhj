package ex1_map.exam;

import java.util.HashMap;
import java.util.Map;

public class StudentAvg {
	public static void main(String[] args) {
		//이름을 key, 점수를 value로 저장한다
		//평균, 최고점 학생을 찾는다
		
		//평균점수 : XX점
		//최고 점수 학생 :  xxx/00점
		
		Map<String, Integer> scores = new HashMap<String, Integer>();
		scores.put("김학생",85);
		scores.put("이학생",92);
		scores.put("박학생",78);
		scores.put("최학생",95);
		
		int sum = 0;
		int maxScore = -1;
		String topStudent = "";
		
		for(Map.Entry<String, Integer> entry : scores.entrySet()) {
			int score = entry.getValue();
			sum += score;
			
			if(score > maxScore) {
				maxScore = score;
				topStudent = entry.getKey();
			}
		}
		
		double avg = (double) sum / scores.size();
		
		System.out.println("평균 점수 : " + avg);
		System.out.println("최고 점수 학생 : "+topStudent+"/"+maxScore);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
