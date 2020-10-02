package tt_racing_car;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.Random;

import static tt_racing_car.Main.DISTANCE;
import static tt_racing_car.Main.STEP;

public class Car implements Runnable {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //khoi tao diem start (km ban dau)
        int runDistance = 0;

        //khoi tao time bat dau cuoc dua
        long startTime = System.currentTimeMillis();

        // Kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp tục chạy
        while (runDistance < DISTANCE) {
            try {
                //Random speed km/h
                int speed = (new Random().nextInt(20));
                //Calculate traveled distance
                runDistance += speed;
                //Build result graphic
                String border = "|";
                int percentTravel = (runDistance * 100) / DISTANCE;
                for (int i = 0; i < DISTANCE; i += STEP) {
                    if (percentTravel >= i + STEP) {
                        border += "=";
                    } else if (percentTravel >= i && percentTravel < i + STEP) {
                        border += "(o-o)";
                    } else {
                        border += "-";
                    }
                }
                border += "\t|";
                System.out.println("Car " + this.name + " : " + border + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car " + this.name + " broken...");
                break;
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Car " + this.name + " Finish in " + (endTime - startTime) / 1000 + " s");

        }
    }
}
