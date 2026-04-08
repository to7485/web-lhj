package ex1_reflection.log;

import java.io.FileInputStream;
import java.util.Properties;

//리플렉션 + 설정파일
//설정파일을 읽고, 리플렉션으로 객체를 생성해서 반환하는 공장역할

//로그를 출력하는 프로그램을 만들되, 로그 출력방식은 코드가 아니라 설정 파일에 따라서
//바뀌게 만들기 하기 위함

//개발중에는 콘솔에 출력
//운영 환경에서는 파일에 저장
//어떤 시스템에서는 DB에 저장
public class LoggerFactory {

	public static Logger getLogger() {
		//Properties : 설정파일을 읽어오기 위한 클래스
		Properties prop = new Properties();
		try {
			//load() : 설정파일을 읽어온다.
			prop.load(new FileInputStream("config.properties"));
			
			//클래스 이름 가져오기
			String className = prop.getProperty("loggerClass");
			
			//리플렉션을 이용하여 클래스를 찾는다.
			Class clazz = Class.forName(className);
			
			//객체를 만든다.
			//getDeclaredConstructor() : 클래스에 선언된 생성자를 가져오는 기능
			//newInstance() : 그 생성자를 실행해서 객체를 만든다.
			Object obj = clazz.getDeclaredConstructor().newInstance();
			
			return (Logger)obj;
			
		} catch (Exception e) {
			throw new RuntimeException("Logger 생성 실패",e);
		}
	}
	
	
	
	
}
