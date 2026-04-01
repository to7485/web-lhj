package ex2_method;

public class TimesTable {
	public void showTable(int dan) {
		for(int i = 1; i<10; i++) {
			System.out.printf("%d X %d = %d\n",dan,i,dan*i);
		}
	}
}
