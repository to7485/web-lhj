package ex1_exception.resource;

public class Main {
	public static void main(String[] args) {
//		try(MyResource res = new MyResource("A")) {
//			String data = res.read1();// "100";
//			int value = Integer.parseInt(data);
//		} catch (Exception e) {
//			System.out.println("예외 처리 : " + e.getMessage());
//		}
//		
//		
//		try(MyResource res = new MyResource("A")) {
//			String data = res.read2();// "abc";
//			int value = Integer.parseInt(data);
//		} catch (Exception e) {
//			System.out.println("예외 처리 : " + e.getMessage());
//		}
		
		MyResource res = null;
		try {
			res = new MyResource("A");
			String data = res.read2();// "abc";
			int value = Integer.parseInt(data);
		} catch (Exception e) {
			System.out.println("예외 처리 : " + e.getMessage());
		} finally {
			try {
				if(res != null) {
					res.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}





