package tech.shuyi.javacodechip.algorithm;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author Ronald
 * @description
 * @date 20/10/2021
 */
public class DepthSearchDemo {

    public static void main(String[] args) {
        if (StringUtils.isEmpty(searchMongo())) {
            System.out.println("CAN NOT FIND A MONGO SELLER.  o(╥﹏╥)o");
        } else {
            System.out.println("FIND A MONGO SELLER!!! (*^▽^*)");
        }
    }

    private static String searchMongo() {
        Queue<String> searchQueue = new PriorityQueue();
        Map<String, Queue<String>> shipMap = initShipData();
        searchQueue.addAll(shipMap.get("me"));
        Set<String> searched = new HashSet<>();
        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            if (isMongoSeller(person)) {
                System.out.println("find mongo seller:" + person);
                return person;
            } else {
                System.out.println("find " + person + " is not mongo seller.");
                Queue<String> friendsQueue = shipMap.get(person);
                if (friendsQueue != null) {
                    searchQueue.addAll(friendsQueue);
                }
                searched.add(person);
                System.out.println("current search queue:" + searchQueue.toString());
            }
        }
        return "";
    }

    private static boolean isMongoSeller(String name) {
        return name.startsWith("m");
    }

    private static Map<String, Queue<String>> initShipData() {
        Map<String, Queue<String>> relationShipMap = new HashMap<>(4);
        Queue myFriendQueue = new PriorityQueue();
        myFriendQueue.add("bob");
        myFriendQueue.add("alice");
        myFriendQueue.add("claire");
        relationShipMap.put("me", myFriendQueue);

        Queue bobFriendQueue = new PriorityQueue();
        bobFriendQueue.add("anuj");
        bobFriendQueue.add("peggy");
        relationShipMap.put("bob", bobFriendQueue);

        Queue aliceFriendQueue = new PriorityQueue();
        aliceFriendQueue.add("peggy");
        relationShipMap.put("alice", aliceFriendQueue);

        Queue claireFriendQueue = new PriorityQueue();
        claireFriendQueue.add("thom");
        claireFriendQueue.add("jonny");
        // add mongo seller for test
        claireFriendQueue.add("mongo-seller");
        relationShipMap.put("alice", claireFriendQueue);

        return relationShipMap;
    }
}
