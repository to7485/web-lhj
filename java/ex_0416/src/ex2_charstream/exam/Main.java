package ex2_charstream.exam;

public class Main {
	public static void main(String[] args) {
		FileConverter converter = new FileConverter();
		
		try {
			converter.copy("wall.jpg", "wall_copy2.jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
