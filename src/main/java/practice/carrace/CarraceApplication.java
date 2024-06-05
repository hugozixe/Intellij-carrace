package practice.carrace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// CarraceApplication.java

public class CarraceApplication {

	public static void main(String[] args) {
		List<Car> cars = makeCars();
		System.out.println("cars = " + cars);

		System.out.println("몇 회나 진행시킬까요?");
		Scanner scanner = new Scanner(System.in);
		int 진행횟수 = scanner.nextInt();
//		System.out.println("진행횟수 = " + 진행횟수);

		// 자동차들을 진행 횟수만큼 전진시킵니다.
		for (int i = 0; i < 진행횟수; i++) {
			for (int j = 0; j < cars.size(); j++) {
				cars.get(j).전진앞으로();
				System.out.println(cars.get(j).name + ": " + "-".repeat(cars.get(j).이동거리));
			}
			System.out.println();
		}

		// 자동차들의 이동 거리 중에 가장 먼 거리를 구합니다.
		int 최고이동거리 = 0;
		for (int i = 0; i < cars.size(); i++) {
			if (최고이동거리 < cars.get(i).이동거리) {
				최고이동거리 = cars.get(i).이동거리;
			}
		}

		// 자동차들의 이동 거리를 확인하여 우승자를 결정합니다.
		List<String> 우승자이름들 = new ArrayList<>();
		for (int i = 0; i < cars.size(); i++) {
			if (cars.get(i).이동거리 == 최고이동거리) {
				우승자이름들.add(cars.get(i).name);
			}
		}

		// 우승자들을 출력합니다.
		System.out.print("우승: ");
		for (int i = 0; i < 우승자이름들.size(); i++) {
			System.out.print(우승자이름들.get(i) + " ");
		}

		// 끝
	}

	public static List<Car> makeCars() {
		while (true) {
			List<String> 이름목록 = getNames();
			try {
				return makeCarsByNames(이름목록); // 여기서 예외가 발생하면 catch로 넘어감
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static List<String> getNames() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("경주에 참가하는 자동차의 이름들을 입력해 주세요. (이름들은 쉼표(,)로 구분)");
		// 쉼표를 기준으로 이름들을 분리하여 리스트로 만들어서 return함
		return List.of(scanner.nextLine().split(","));
	}

	public static List<Car> makeCarsByNames(List<String> 이름목록) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < 이름목록.size(); i++) {
			// Car 생성자에서 이름 길이가 8자를 초과하면 예외를 발생시킬 수 있음
			// 예외가 발생하면 함수 실행이 중단됨
			Car car = new Car(이름목록.get(i));
			carList.add(car);
		}
		return carList;
	}

}