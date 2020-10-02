package tt_racing_car;

import javax.swing.plaf.TableHeaderUI;

public class Main {
    public static int DISTANCE = 100;
    public static int STEP = 2;

    public static void main(String[] args) {
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");

        //khong can tao class Thread vi da implements interface Runnable
        Thread thread1 = new Thread(carA);
        Thread thread2 = new Thread(carB);
        Thread thread3 = new Thread(carC);

        System.out.println("Distance: 100Km");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
