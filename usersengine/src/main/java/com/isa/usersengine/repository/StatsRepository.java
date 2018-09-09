package com.isa.usersengine.repository;


import com.isa.usersengine.domain.Stats;
import com.isa.usersengine.domain.User;

import java.util.HashMap;
import java.util.Map;


public class StatsRepository{

//    private static Map<String, Integer> statsRepository = new HashMap<>();
//
//    public static Map<String, Integer> getStatsRepository() {
//
//        if(statsRepository.size() == 0)
//            StatsRepository.fillStatsWithDefault();
//
//        return statsRepository;
//    }
//
//    private static void fillStatsWithDefault(){
//
//        User user = new User();
//        user.setName("Test");
//        user.setId(1000);
//        user.setLogin("testowy@");
//        user.setPassword("password");
//        user.setAge(99);
//
//        Stats stats = new Stats();
//        stats.setNumberOfRequests(1);
//        int numberOfRequest = Stats.getNumberOfRequests();
//
//                String identity = user.getName() + " (" + user.getId() + ")";
//
//        statsRepository.put(identity, numberOfRequest);
//    }
}
