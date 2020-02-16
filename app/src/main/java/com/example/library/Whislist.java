package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Whislist extends AppCompatActivity {

    public Integer[] mThumbIds  = {
            R.drawable.e12341,R.drawable.e12342,R.drawable.e12343,R.drawable.e12345,R.drawable.e12346,
            R.drawable.e12347,R.drawable.e12348,R.drawable.e12349,R.drawable.e12350,R.drawable.e12351,R.drawable.e12352,
            R.drawable.e12353,R.drawable.e12354,R.drawable.e12355,R.drawable.e12356,R.drawable.e12357,R.drawable.e12358,
            R.drawable.e12359,R.drawable.e12360
    };

    public String[] mThumbNames = {
            "Java Fundamentals", "Effective Java", "Java The Complete Reference", "Head First Java", "The C Language", "C programming Language",
            "C Programming","C Programming","Expert C Programming","C++ From Control Structures",
            "C++ Primer","The C++","Effective Modern C++","Accelerated C++","Python Crash Course","Head First Python",
            "Learn Python The Hard Way","Python Programming","Learning With Python"

    };

    TextView textView;
    ImageView imageView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whislist);

        Intent intent = getIntent();
        int num = intent.getIntExtra("val",0);
        Log.e("number",String.valueOf(num));

        textView = findViewById(R.id.tv);

        imageView = findViewById(R.id.img);

        listView = findViewById(R.id.listView);


//        switch(num){
//            case 0:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12341));
//                textView.setText(mThumbNames[0]);
//
//                break;
//            case 1:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12342));
//                textView.setText(mThumbNames[1]);
//
//                break;
//            case 2:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12343));
//                textView.setText(mThumbNames[2]);
//
//                break;
//            case 3:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12345));
//                textView.setText(mThumbNames[3]);
//
//                break;
//            case 4:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12346));
//                textView.setText(mThumbNames[4]);
//
//                break;
//            case 5:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12347));
//                textView.setText(mThumbNames[5]);
//
//                break;
//            case 6:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12348));
//                textView.setText(mThumbNames[6]);
//
//                break;
//            case 7:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12349));
//                textView.setText(mThumbNames[7]);
//
//               break;
//            case 8:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12350));
//                textView.setText(mThumbNames[8]);
//
//                break;
//            case 9:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12351));
//                textView.setText(mThumbNames[9]);
//
//                break;
//            case 10:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12352));
//                textView.setText(mThumbNames[10]);
//
//                break;
//            case 11:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12353));
//                textView.setText(mThumbNames[11]);
//
//                break;
//            case 12:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12354));
//                textView.setText(mThumbNames[12]);
//
//                break;
//            case 13:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12355));
//                textView.setText(mThumbNames[13]);
//
//                break;
//            case 14:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12356));
//                textView.setText(mThumbNames[14]);
//
//                break;
//            case 15:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12357));
//                textView.setText(mThumbNames[15]);
//
//                break;
//            case 16:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12358));
//                textView.setText(mThumbNames[16]);
//
//                break;
//            case 17:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12359));
//                textView.setText(mThumbNames[17]);
//
//                break;
//            case 18:
//                imageView.setImageDrawable(getDrawable(R.drawable.e12360));
//                textView.setText(mThumbNames[18]);
//
//                break;
//            default:
//                break;
//        }



    }
}
