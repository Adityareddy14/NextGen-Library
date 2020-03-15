package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import com.example.library.ToDatePickerFragment;
import com.example.library.DatePickerFragment;

public class issuebookform extends AppCompatActivity {

    public String[] mThumbNames = {
            "Java Fundamentals", "Effective Java", "Java The Complete Reference", "Head First Java", "The C Language", "C programming Language",
            "C Programming","C Programming","Expert C Programming","C++ From Control Structures",
            "C++ Primer","The C++","Effective Modern C++","Accelerated C++","Python Crash Course","Head First Python",
            "Learn Python The Hard Way","Python Programming","Learning With Python"

    };

    public Integer[] mThumbIds  = {
            R.drawable.e12341,R.drawable.e12342,R.drawable.e12343,R.drawable.e12345,R.drawable.e12346,
            R.drawable.e12347,R.drawable.e12348,R.drawable.e12349,R.drawable.e12350,R.drawable.e12351,R.drawable.e12352,
            R.drawable.e12353,R.drawable.e12354,R.drawable.e12355,R.drawable.e12356,R.drawable.e12357,R.drawable.e12358,
            R.drawable.e12359,R.drawable.e12360
    };


    TextView textView,textView1;

    Button button;
    Button button1;
    Button button2;
    ArrayList<String> list;
    String st,st1;
    Main3Activity main3Activity;
    String email;
    ImageView imageView;
    String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issuebookform);

       Intent i = getIntent();

        num = i.getStringExtra("val");

       textView = findViewById(R.id.textView2);

        textView1 = findViewById(R.id.textView9);

        imageView = findViewById(R.id.img);


       int n = Integer.parseInt(String.valueOf(num));

        textView.setText(mThumbNames[n]);

        imageView.setImageDrawable(getDrawable(mThumbIds[n]));

        button = findViewById(R.id.button3);

        button1 = findViewById(R.id.button4);

        button2 = findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker(view);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToDatePicker(view);
            }
        });

       main3Activity = new Main3Activity();

        email = main3Activity.getEmail();


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (num) {
                    case "0":
                        textView1.setText("Availability: 8");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    case "1":
                        textView1.setText("Availability: 15");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    case "2":
                        textView1.setText("Availability: 0");
                        Toast.makeText(issuebookform.this, "Book not available check out later", Toast.LENGTH_SHORT).show();
                        break;
                    case "3":
                        textView1.setText("Availability: 4");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    case "4":
                        textView1.setText("Availability: 0");
                        Toast.makeText(issuebookform.this, "Book not available check out later", Toast.LENGTH_SHORT).show();
                        break;
                    case "5":
                        textView1.setText("Availability: 3");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    case "6":
                        textView1.setText("Availability: 0");
                        Toast.makeText(issuebookform.this, "Book not available check out later", Toast.LENGTH_SHORT).show();
                        break;
                    case "7":
                        textView1.setText("Availability: 1");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    case "8":
                        textView1.setText("Availability: 0");
                        Toast.makeText(issuebookform.this, "Book not available check out later", Toast.LENGTH_SHORT).show();
                        break;
                    case "9":
                        textView1.setText("Availability: 8");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    case "10":
                        textView1.setText("Availability: 15");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    case "11":
                        textView1.setText("Availability: 0");
                        Toast.makeText(issuebookform.this, "Book not available check out later", Toast.LENGTH_SHORT).show();
                        break;
                    case "12":
                        textView1.setText("Availability: 17");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    case "13":
                        textView1.setText("Availability: 4");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    case "14":
                        textView1.setText("Availability: 0");
                        Toast.makeText(issuebookform.this, "Book not available check out later", Toast.LENGTH_SHORT).show();
                        break;
                    case "15":
                        textView1.setText("Availability: 6");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    case "16":
                        textView1.setText("Availability: 8");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    case "17":
                        textView1.setText("Availability: 0");
                        Toast.makeText(issuebookform.this, "Book not available check out later", Toast.LENGTH_SHORT).show();
                        break;
                    case "18":
                        textView1.setText("Availability: 8");
                        Toast.makeText(issuebookform.this, "Request Successfull", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    public void showDatePicker(View v){
        DialogFragment datePicker1 = new DatePickerFragment();
        datePicker1.show(getSupportFragmentManager(), "date picker");
    }


    public void showToDatePicker(View v){
        DialogFragment datePicker1 = new ToDatePickerFragment();
        datePicker1.show(getSupportFragmentManager(), "date picker");
    }


}
