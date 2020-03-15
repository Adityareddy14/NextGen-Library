package com.example.library;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginActivityTest {

    @Test
    public void onStop() {
    }

    @Test
    public void onDestroy() {
    }

    @Test
    public void onCreate() {
        String s1="aditya";
        String s2="password";
        double expected=1;
        double delta=0.1;
        int output;
        LoginActivity objonc=new LoginActivity();
        output=objonc.testsendfile(s1,s2);
        assertEquals(expected,output,delta);
    }

    @Test
    public void getemail() {
    }


    @Test
    public void onclickloginbutton(){
        double expected = 1;
        double delta=0.1;
        int output;
        LoginActivity objlgn=new LoginActivity();
        output=objlgn.testimportfile();
        assertEquals(expected,output,delta);

    }

}