package tech.shuyi.javacodechip.aqs;

public class AQSTest {
    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        try {
            new Thread(() -> {
                try {
                    conditionTest.oddPrint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    conditionTest.evenPrint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}