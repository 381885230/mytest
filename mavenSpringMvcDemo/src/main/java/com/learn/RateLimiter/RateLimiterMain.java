package com.learn.RateLimiter;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterMain {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(2);
        System.out.println(rateLimiter.acquire(5));
        System.out.println(rateLimiter.acquire(2));
        System.out.println(rateLimiter.acquire(1));
    }
}