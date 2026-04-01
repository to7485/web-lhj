package ex2_package.hyundai;

//import의 역할
//긴 이름을 줄여서 쓰기 위한 문법

import ex2_package.hankook.SnowTire;
import ex2_package.kumho.AllSeasonTire;


public class Car {
	//타이어가 필요하다
		//클래스의 전체 경로를 다 작성해줬기 때문에 import를 써주지 않아도 됩니다.
		ex2_package.hankook.Tire tire1 = new ex2_package.hankook.Tire();
		ex2_package.kumho.Tire tire2 = new ex2_package.kumho.Tire();
		SnowTire tire3 = new SnowTire();
		AllSeasonTire tire4 = new AllSeasonTire();
}



