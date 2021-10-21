package tech.shuyi.javacodechip.algorithm;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Ronald
 * @description
 * @date 21/10/2021
 */
public class DikstraDemo {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graphMap = initGraphDataMap();
        Map<String, Integer> costMap = initCoastMap();
        Map<String, String> parentMap = initParentMap();
        Set<String> processed = new HashSet<>();
        // find shortest road
        String node = findLowestCostNode(costMap, processed);
        while (!processed.contains(node)) {
            if (StringUtils.isEmpty(node)) {
                break;
            }
            Integer cost = costMap.get(node);
            Map<String, Integer> neighbors = graphMap.get(node);
            for (String neighbor : neighbors.keySet()) {
                Integer newCost = cost + neighbors.get(neighbor);
                if (costMap.get(neighbor) > newCost) {
                    costMap.put(neighbor, newCost);
                    parentMap.put(neighbor, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode(costMap, processed);
        }
        // print end to start
        String currentNode = "end";
        String parentNode = parentMap.get(currentNode);
        System.out.print(currentNode);
        while (parentNode != null) {
            System.out.print(" -> " + parentNode);
            parentNode = parentMap.get(parentNode);
        }
        System.out.println();
    }

    private static String findLowestCostNode(Map<String, Integer> costMap, Set<String> processed) {
        Integer lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = "";
        for (String node : costMap.keySet()) {
            Integer cost = costMap.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }

    private static Map<String, Map<String, Integer>> initGraphDataMap() {
        Map<String, Map<String, Integer>> graphMap = new HashMap<>(4);
        Map<String, Integer> startMap = new HashMap<>(2);
        startMap.put("a", 6);
        startMap.put("b", 2);
        graphMap.put("start", startMap);

        Map<String, Integer> aMap = new HashMap<>(2);
        aMap.put("end", 1);
        graphMap.put("a", aMap);

        Map<String, Integer> bMap = new HashMap<>(2);
        bMap.put("a", 3);
        bMap.put("end", 5);
        graphMap.put("b", bMap);

        Map<String, Integer> endMap = new HashMap<>(2);
        graphMap.put("end", endMap);

        return graphMap;
    }

    private static Map<String, Integer> initCoastMap() {
        Map<String, Integer> costMap = new HashMap<>(2);
        costMap.put("a", 6);
        costMap.put("b", 2);
        costMap.put("end", Integer.MAX_VALUE);
        return costMap;
    }

    private static Map<String, String> initParentMap() {
        Map<String, String> parentNodeMap = new HashMap<>(4);
        parentNodeMap.put("a", "start");
        parentNodeMap.put("b", "start");
        parentNodeMap.put("end", null);
        return parentNodeMap;
    }
}
