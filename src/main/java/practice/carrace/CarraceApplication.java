package practice.carrace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
// CarraceApplication.java

public class CarraceApplication {

	public static void main(String[] args) {
		List<Car> cars = getCars();
		System.out.println("cars = " + cars);

		System.out.println("몇 회나 진행시킬까요?");
		Scanner scanner = new Scanner(System.in);
		int 진행횟수 = scanner.nextInt();
//		System.out.println("진행횟수 = " + 진행횟수);
	}

	public static List<Car> getCars() {
		while (true) {
			List<String> 이름목록 = getNames();
			try {
				return makeCars(이름목록);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static List<String> getNames() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("경주에 참가하는 자동차의 이름들을 입력해 주세요. (이름들은 쉼표(,)로 구분)");
		return List.of(scanner.nextLine().split(","));
	}

	public static List<Car> makeCars(List<String> 이름목록) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < 이름목록.size(); i++) {
			Car car = new Car(이름목록.get(i));
			carList.add(car);
		}
		return carList;
	}
	private static class Car {
		public Car(String s) {
		}
	}
}