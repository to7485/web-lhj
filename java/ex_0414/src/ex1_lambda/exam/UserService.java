package ex1_lambda.exam;

import java.util.List;

public class UserService {

	//조건에 따라 다른 람다식을 반환
	public UserFilter getFilter(String type) {
		if(type.equals("adult")) {
			return user -> user.getAge() >= 20;
		} else if (type.equals("seoul")) {
			return user -> user.getCity().equals("서울");
		} else if(type.equals("kim")) {
			return user -> user.getName().startsWith("김");
		} else {
			return null;
		}
	}
	
	public void filterUsers(List<User> users, UserFilter filter) {
		for(User u : users) {
			if(filter.test(u)) {
				System.out.println(u.getName() + " / " + u.getAge() + " / " + u.getCity());
			}
		}
	}
	
	
	
	
	
	
	
	
}
