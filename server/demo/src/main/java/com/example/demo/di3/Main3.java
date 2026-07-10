package com.example.demo.di3;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.common.reflect.ClassPath;

//객체로 컨테이너에 저장해놓고 싶은 클래스에 @Component 어노테이션을 붙이고
//컴포넌트 스캔을 통해 저장
//@Component class Car{};
//@Component class SportCar extends Car{};
//@Component class Truck extends Car{};
//@Component class Engine{};

class AppContext{
	Map map; //객체를 저장할 map을 선언
	
	//AppContext 객체가 만들어질 때 HashMap이 같이 만들어진다.
	public AppContext() {
		map = new HashMap();
		doComponentScan();
	}
	
	//객체 자동 등록하기
	//Component Scanning
	//클래스 앞에 @Component 어노테이션을 붙이고 패키지에
	//컴포넌트 어노테이션이 붙어있는 클래스를 찾아서 객체를 만들고
	//맵에 저장하는 기법
	private void doComponentScan() {
		try {
			//AppContext 클래스를 찾아서 메모리에 올려서 객체를
			//생성할 수 있는 상태로 만든다.
			ClassLoader classLoader = AppContext.class.getClassLoader();
			
			//클래스 경로 상의 모든 클래스를 탐색하고 사용할 수 있게 도와준다.
			ClassPath classPath = ClassPath.from(classLoader);
			
			//지정한 패키지내의 모든 클래스의 정보를 가져와라
			Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.example.demo.di3");
			
			for(ClassPath.ClassInfo classInfo : set) {
				
				//현재의 ClassInfo 객체를 실제로 로드된 클래스(Class)로 변환한다.
				Class clazz = classInfo.load();
				
				//해당 클래스에 @Component가 달려있는지 확인한다.
				Component component = (Component)clazz.getAnnotation(Component.class);
				
				//해당 클래스가 @Component로 지정된 클래스라면
				if(component != null) {
					//key, value를 설정해서 map에 저장해야 한다.
					String id = StringUtils.uncapitalize(classInfo.getSimpleName());
					
					map.put(id, clazz.newInstance());
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	Object getBean(String key) {
		return map.get(key);
	}
}

public class Main3 {
	public static void main(String[] args) {
		AppContext ac = new AppContext();
		
//		Car car = (Car)ac.getBean("car");
//		System.out.println(car);
	}
}










