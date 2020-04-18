package com.rambo.algorithm.leetcode;

import java.util.*;

public class Twitter {
    private Integer timeCount = 0;
    static class Tweet {
        private Integer id;
        private Integer ts;

        public Tweet(Integer id, Integer ts){
            this.id = id;
            this.ts = ts;
        }
        public Integer getId(){
            return id;
        }

        public Integer getTs(){
            return ts;
        }
    }

    private Map<Integer, List<Tweet>> tweetMap;
    private Map<Integer, List<Integer>> followeeMap;
    /** Initialize your data structure here. */
    public Twitter() {
        tweetMap = new HashMap();
        followeeMap = new HashMap();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Tweet> userTweetList = tweetMap.get(userId);
        if (userTweetList == null){
            userTweetList = new ArrayList();
            tweetMap.put(userId, userTweetList);
        }

        userTweetList.add(new Tweet(tweetId, timeCount++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> tweetList = new ArrayList();
        if (tweetMap.get(userId) != null) {
            tweetList.addAll(tweetMap.get(userId));
        }
        List<Integer> followeeList = followeeMap.get(userId);
        if (followeeList != null) {
            for (Integer followeeId : followeeList) {
                if (tweetMap.get(followeeId) != null) {
                    tweetList.addAll(tweetMap.get(followeeId));
                }
            }
        }


        Collections.sort(tweetList, (o1, o2) -> -o1.ts.compareTo(o2.ts));

        List<Integer> tweetIdList = new ArrayList();
        for (Tweet tweet : tweetList) {
            if (tweetIdList.size() >= 10) {
                break;
            }
            tweetIdList.add(tweet.getId());
        }

        return tweetIdList;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId){
            return;
        }

        List<Integer> followeeList = followeeMap.get(followerId);
        if (followeeList == null){
            followeeList = new ArrayList();
            followeeMap.put(followerId, followeeList);
        }

        if (followeeList.contains(followeeId)){
            return;
        }
        followeeList.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId){
            return;
        }

        List<Integer> followeeList = followeeMap.get(followerId);
        if (followeeList == null){
            return;
        }

        if (!followeeList.contains(followeeId)){
            return;
        }
        followeeList.remove(Integer.valueOf(followeeId));
    }


    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        /*List<Integer> tweetIdList = twitter.getNewsFeed(1);
        tweetIdList.forEach(System.out::println);*/

        /*twitter.follow(2, 1);
        List<Integer> tweetIdList1 = twitter.getNewsFeed(2);
        tweetIdList1.forEach(System.out::println);*/
        /*twitter.postTweet(2,1);
        List<Integer> tweetIdList2 = twitter.getNewsFeed(1);
        tweetIdList2.forEach(System.out::println);*/

//        twitter.unfollow(2, 1);
        List<Integer> tweetIdList3 = twitter.getNewsFeed(1);
        tweetIdList3.forEach(System.out::println);

    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
