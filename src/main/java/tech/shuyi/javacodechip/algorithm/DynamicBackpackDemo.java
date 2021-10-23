package tech.shuyi.javacodechip.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ronald
 * @description
 * @date 23/10/2021
 */
public class DynamicBackpackDemo {
    public static void main(String[] args) {
        System.out.println("最大价值为：" + dynamicBackpack());
    }

    private static int dynamicBackpack() {
        int MAX_WEIGHT = 6;
        List<Stuff> backpack = initBackpack();
        int rows = backpack.size();
        int cols = MAX_WEIGHT;
        int[][] maxValues = new int[backpack.size()][MAX_WEIGHT];
        int[][] selectMatrix = new int[backpack.size()][MAX_WEIGHT];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int backpackWeight = j + 1;
                int currentStuffWeight = backpack.get(i).getWeight();
                int currentStuffValue = backpack.get(i).getValue();
                int backpackLeaveWeight = backpackWeight - currentStuffWeight;
                int prevMaxValue = i - 1 >= 0 ? maxValues[i - 1][j] : 0;
                int currentWeightValue = backpackWeight >= currentStuffWeight ? currentStuffValue : 0;
                int leaveWeightMaxValue = (i - 1 >= 0) && backpackLeaveWeight > 0 ? maxValues[i - 1][backpackLeaveWeight - 1] : 0;
                int nowMaxValue = currentWeightValue + leaveWeightMaxValue;
                int maxPackageValue = prevMaxValue;
                if (nowMaxValue > prevMaxValue) {
                    maxPackageValue = nowMaxValue;
                    selectMatrix[i][j] = 1;
                }
                maxValues[i][j] = maxPackageValue;
            }
        }
        printSelectStuff(rows - 1, cols - 1, selectMatrix, backpack);
        return maxValues[rows - 1][cols - 1];
    }

    private static void printSelectStuff(int row, int col, int[][] selectMatrix, List<Stuff> backpack) {
        for (int i = row; i >= 0; i--) {
            boolean isSelect = selectMatrix[i][col] == 1;
            if (isSelect) {
                Stuff stuff = backpack.get(i);
                System.out.println(stuff.getName() + " - weight:" + stuff.getWeight() + " - value:" + stuff.getValue());
                col -= stuff.getWeight();
            }
        }
    }

    private static List<Stuff> initBackpack() {
        List<Stuff> backpack = new ArrayList<>();
        backpack.add(new Stuff("water", 3, 10));
        backpack.add(new Stuff("book", 1, 3));
        backpack.add(new Stuff("food", 2, 9));
        backpack.add(new Stuff("jacket", 2, 5));
        backpack.add(new Stuff("camera", 1, 6));
        return backpack;
    }

    @Data
    @AllArgsConstructor
    public static class Stuff{
        private String name;
        private Integer weight;
        private Integer value;
    }
}