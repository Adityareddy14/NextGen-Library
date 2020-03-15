package com.example.library;

import org.junit.Test;

import static org.junit.Assert.*;

public class ForgotPasswordTest {

    @Test
    public void onStop() {
    }

    @Test
    public void onDestroy() {
    }

    @Test
    public void onCreate() {
        String s1="adithya";
        String s2="hola@gmail.com";
        String s3="8247398867";
        double expected=1;
        double delta=0.1;
        int output;
        ForgotPassword objonc=new ForgotPassword();
        output=objonc.testforgtpssfile(s1,s2,s3);
        assertEquals(expected,output,delta);
    }
}