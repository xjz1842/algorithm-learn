package com.algorithms.leetcode.fourhundred;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class leetcode_355_Twitter {

    private class Tweet{
        //推文id
        private Integer tweetId;
        //时间戳
        private Long timestamp;

        public Tweet(Integer tweetId, Long timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
    /**
     * key useriD用户Id  followerId集合
     */
    Map<Integer,Set<Integer>> followerMap;

    /**
     * userId --> tweet集合
     */
    Map<Integer,List<Tweet>>  userIdToTwitterMap;

    /**
     * version
     */
    AtomicInteger version = new AtomicInteger(0);

    /**
     * Initialize your data structure here.
     */
    public leetcode_355_Twitter() {
        followerMap = new HashMap<>();
        userIdToTwitterMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId,System.nanoTime());
        if(userIdToTwitterMap.containsKey(userId)){
            userIdToTwitterMap.get(userId).add(tweet);
        }else{
            List<Tweet> list = new ArrayList<>();
            list.add(tweet);
            userIdToTwitterMap.put(userId,list);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
         List<Tweet> tweets = userIdToTwitterMap.get(userId);

         if(tweets == null || tweets.size() == 0){
             tweets = new ArrayList<>();
         }else{
             // copy new list
             tweets = new ArrayList<>(tweets);
         }
        //copy new list
         tweets = new ArrayList<>(tweets);
         if(followerMap.get(userId) != null) {
             for (Integer followerId : followerMap.get(userId)) {
                 if (userIdToTwitterMap.containsKey(followerId)) {
                     tweets.addAll(userIdToTwitterMap.get(followerId));
                 }
             }
         }
         if(tweets.isEmpty()){
             return new ArrayList<>();
         }
         //取最新的10条
        tweets.sort((o1, o2) -> (int) (o2.timestamp - o1.timestamp));
        if(tweets.size() > 10){
            return tweets.subList(0,10).stream().map(key -> key.tweetId).collect(Collectors.toList());
        }
         return tweets.stream().map(key -> key.tweetId).collect(Collectors.toList());
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId)){
            followerMap.get(followerId).add(followeeId);
        }else{
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            followerMap.put(followerId,set);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if(followerMap.containsKey(followerId)){
           followerMap.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        leetcode_355_Twitter obj = new leetcode_355_Twitter();
        obj.postTweet(2, 5);
        obj.follow(1, 2);
        obj.follow(1, 2);
        System.out.println(obj.getNewsFeed(1));
//        List<Integer> param_2 = obj.getNewsFeed(1);
//        System.out.println(param_2);
//        obj.follow(2, 1);
//        System.out.println(obj.getNewsFeed(2));
//        obj.unfollow(2,1);
//        System.out.println(obj.getNewsFeed(2));
    }
}
