package cohension;

//통신적 응집도
//동일한 입력과 출력을 사용하여 다른 기능을 수행하는 활동들이 모여 있는 경우
//- 데이터 구조가 변경되면 이 데이터를 공유하는 모든 메서드를 한꺼번에 수정해야 함
//- 특정 기능만 필요한 다른 모듈에서 이 클래스를 불러올 때, 필요없는 기능까지 함께 묶여서 들어옴
public class SalesReporter {

	public void generateReport(double[] salesData) {
		
		//똑같은 매출 데이터를 두 개의 작업에 각각 전달한다.
		
		//동일한 salesData를 사용해 총 매출액 계산
		double totalRevenue = calculrateTotalRevenue(salesData);
		
		//동일한 salesData를 사용해 세금을 계산
		double taxAmount = calculrateTax(salesData);
		
	}
	
	//배열의 총 합을 계산하여 반환
	public double calculrateTotalRevenue(double[] salesData) {
		double sum = 0;
		for(double price : salesData) {
			sum += price;
		}
		
		return sum;
	}
	
	//매출별 10%씩 뗀 금액이 얼만지
	public double calculrateTax(double[] salesData) {
		return calculrateTotalRevenue(salesData)* 0.1;
	}
	
	
	
}
