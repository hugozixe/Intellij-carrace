package practice.carrace;// Car.java

import java.util.Random;

public class Car {
    String name;
    int 이동거리;

    public Car(String name) {
                if (name.length() > 8) {
            throw new IllegalArgumentException("이름은 8자 이하만 가능합니다.");
        }
        this.name = name;
    }


    public void 전진앞으로() {
        Random random = new Random();
        random.nextInt(10);

        if(random.nextInt(10) >= 4)
            이동거리++;
    }
}