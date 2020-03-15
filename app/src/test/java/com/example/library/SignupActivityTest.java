package com.example.library;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignupActivityTest {

    @Test
    public void onStop() {
    }

    @Test
    public void onDestroy() {
    }

    @Test
    public void onCreate() {
        String s1="adithya";
        String s2="";
        int s3=4;
        int s4=0;
        int s5=3;
        int s6=0;
        double expected=1;
        double delta=0.1;
        int output;
        SignupActivity objonc=new SignupActivity();
        output=objonc.testoncfile(s1,s2,s3,s4,s5,s6);
        assertEquals(expected,output,delta);

    }

    @Test
    public void onclickregisterbutton(){
        double expected = 1;
        double delta=0.1;
        int output;
        SignupActivity objlgn=new SignupActivity();
        output=objlgn.testimportfile2();
        assertEquals(expected,output,delta);
    }


}