package com.rau.leetcode.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Ihsmarkit {
    public static void main(String[] args) {

        List<String> friendList = Arrays.asList(new String[]{"friend@catena-technologies.com", "bff@uni.edu.sg", "provost@uni.edu.sg", "john@doe.com"});
        List<String> allEmails = Arrays.asList(new String[]{"enemy@uni.edu.sg", "bff@uni.edu.sg", "evil@spam.com", "bff@uni.edu.sg", "friend@catena-technologies.com"});
        System.out.println(getMatchedFriendEmailCount(friendList, allEmails));
    }

    public static int getMatchedFriendEmailCount(List<String> friendList, List<String> allEmails) {

        final Map<String, Integer> emailCountMap = new HashMap<>();
        allEmails.stream().forEach(email -> {
            if (emailCountMap.containsKey(email))
                emailCountMap.put(email, emailCountMap.get(email) + 1);
            else
                emailCountMap.put(email, 1);
        });

        final AtomicInteger count = new AtomicInteger();
        friendList.stream().forEach(item -> {
            count.getAndAdd(emailCountMap.getOrDefault(item, 0));
        });

        return count.get();
    }

}
