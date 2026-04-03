module my_module_a {
	//exports 키워드는 모듈이 가지고 있는 패키지를 외부에서 사용할 수 있도록
	//노출시키는 역할을 한다.
	exports pack1;
	
	//transitive
	//이 모듈을 사용하는 쪽에서도 자동으로 사용하게 해준다.
	//A -> B -> C일 때 A는 C를 못쓰기 때문에 transitive를 사용하여
	//A도 C를 사용할 수 있게 해준다.
	requires transitive my_module_b;
	
}