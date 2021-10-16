package tech.shuyi.javacodechip.aqs;

public class MultiAQSTest {
    public static void main(String[] args) {
        MultiConditionTest conditionTest = new MultiConditionTest();
        try {
            new Thread(() -> {
                try {
                    conditionTest.oddPrint1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    conditionTest.oddPrint2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    conditionTest.oddPrint3();
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