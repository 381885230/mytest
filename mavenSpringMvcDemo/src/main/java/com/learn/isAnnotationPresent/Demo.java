package com.learn.isAnnotationPresent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// declare a new annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Demo {
   
   String str();
   
   int val();
}
