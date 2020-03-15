package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.library.ui.history.HistoryFragment;

public class book_information extends AppCompatActivity {

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
    TextView textView1;
    TextView textView2;
    ImageView imageView;
    ImageButton imageButton;

    Button button;
    Button button1;
   public String num;
   String send;
   Intent i;
   Intent intent;
   Intent in;
   Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_information);

        textView = findViewById(R.id.tv);

        textView1 = findViewById(R.id.description);

        textView2 = findViewById(R.id.details);

        imageView = findViewById(R.id.img);

        button = findViewById(R.id.button);

        button1 =  findViewById(R.id.button2);


        i = getIntent();

        num = i.getStringExtra("val");

        //Log.e("valu",String.valueOf(num));


      send = String.valueOf(num);

      intent = new Intent(book_information.this,Whislist.class);

      bundle = new Bundle();
      bundle.putInt("val",Integer.parseInt(send));
      HistoryFragment historyFragment = new HistoryFragment();
      historyFragment.setArguments(bundle);


        switch(num){
            case "0":
                imageView.setImageDrawable(getDrawable(R.drawable.e12341));
                textView.setText(mThumbNames[0]);
                textView1.setText("Core Java Volume I Fundamentals is a Java reference book that offers a detailed explanation of various features of Core Java,including exception handling, interfaces, and lambda expressions. Significant highlights of the book include simple language, conciseness, and detailed examples. The latest edition of the Core Java Volume I  Fundamentals comprehensively updated for covering Java SE 9, 10 , 11. The book helps Java programmers develop an ability to write highly robust and maintainable code.");
                textView2.setText("Author: Cay S.Horstmann\n" +
                        "Latest Edition: 11th Edition\n" +
                        "Publisher: Prentice Hall");
                break;
            case "1":
                imageView.setImageDrawable(getDrawable(R.drawable.e12342));
                textView.setText(mThumbNames[1]);
                textView1.setText("A must-have book for every Java programmer and Java aspirant,Effective Java makes up for an excellent complementary read with other Java books or learning material.The book offers 78 best practices to follow for making the code better.Effective Java divides all the mentioned best practices into 11 distinct sections, such as Concurrency, Generics, and Methods, to make it easier for the reader to grasp it all.The book offers something to Java programmers of any skill level.");
                textView2.setText("Author: Joshua Bloch\n" +
                        "Latest Edition: 3rd Edition\n" +
                        "Publisher: Addison Wesley");
                break;
            case "2":
                imageView.setImageDrawable(getDrawable(R.drawable.e12343));
                textView.setText(mThumbNames[2]);
                textView1.setText("If you are a seasoned Java programmer looking to enhance your Java knowledge, don’t be averted by the title of the book, Java: A Beginner’s Guide. It is, in fact, one of the most comprehensive books for learning Java. Anyone with basic programming knowledge can easily benefit from the Java: A Beginner’s Guide. The Java book covers all concepts pertains to Core Java. The latest edition of the Java: A Beginner’s Guide is fully revised to include Java 11 SE.The book offers several hands-on exercises as well as a quiz section at the end of every chapter to let the readers self-evaluate their learning.");
                textView2.setText("Author: Herbert Schildt\n" +
                        "Latest Edition: 8th Edition\n" +
                        "Publisher: McGraw-Hill Education\n");
                break;
            case "3":
                imageView.setImageDrawable(getDrawable(R.drawable.e12345));
                textView.setText(mThumbNames[3]);
                textView1.setText("The most important selling points of Head First Java is its simplicity and super-effective real-life analogies that pertain to the Java programming concepts. Head First Java covers almost all OOPS concepts, and fascinatingly explains them.Despite several readers claiming it to be a dated book, as it covers nothing beyond Java 5.0, Head First Java is still found on the shelves of numerous Java veterans. Thus, it a must-have book for every Java pursuer and developer.");
                textView2.setText("Author: Kathy Sierra\n" +
                        "Latest Edition: 2nd Edition\n" +
                        "Publisher: Shroff/O’Reilly");
                break;
            case "4":
                imageView.setImageDrawable(getDrawable(R.drawable.e12346));
                textView.setText(mThumbNames[4]);
                textView1.setText("The C Programming Language (2nd Edition) written by Brain W. Kernighan is ideal for every serious programmer’s digital library. You should have a background on Data Structure to easily follow most of the examples.To read this C programming book, you need to have some familiarity with basic programming concepts like variables, assignment statements, loops, and functions.The book includes detailed information about the C language reference manual. It also helps you in syntax notation, declarations, scope rules, etc.");
                textView2.setText("Author: Brian W.Kernighan \n" +
                        "Latest Edition: 2nd Edition");
                break;
            case "5":
                imageView.setImageDrawable(getDrawable(R.drawable.e12347));
                textView.setText(mThumbNames[5]);
                textView1.setText("This book is written by Kernighan for Advanced C programmer. The person should have some background on Data Structure in order to follow most of the examples easily. The book was also structured to reuse function from previous chapters like getting a line, strcmp, alloc, etc.However, most of these functions are exactly same in C's standard library. If you read the content of this book deeply, you will learn the crucial area of C that will save you from trouble. Like debugging your code like post fix increments and side effects and the precedence of statement evaluation.");
                textView2.setText("The C Programming Language (2nd Edition) written by Brain W. Kernighan is ideal for every serious programmer’s digital library. You should have a background on Data Structure to easily follow most of the examples.To read this C programming book, you need to have some familiarity with basic programming concepts like variables, assignment statements, loops, and functions.The book includes detailed information about the C language reference manual. It also helps you in syntax notation, declarations, scope rules, etc.");
                textView2.setText("Author: Greg Perry\n" +
                        "Latest Edition: 3rd Edition");
                break;
            case "6":
                imageView.setImageDrawable(getDrawable(R.drawable.e12348));
                textView.setText(mThumbNames[6]);
                textView1.setText("3rd EditionC Programming Absolute Beginner's Guide is a book written by Greg Perry and Dean Miller. This book teaches some basic concept of C language with clear and easy steps. The book explains the method to organize programs and work with variables, operators, I/O, pointers, functions, etc.This C book gave simple instructions which help you to create useful, reliable C code, from games to mobile apps.");
                textView2.setText("Author: Greg Perry\n" +
                        "Latest Edition: 3rd Edition");
                break;
            case "7":
                imageView.setImageDrawable(getDrawable(R.drawable.e12349));
                textView.setText(mThumbNames[7]);
                textView1.setText("The book is targeting people with no prior programming experience. It is quite comprehensive in its treatment of the majority of C programming concepts. It is also covers the information needed by a C programmer in using the standard C library.Author's easy language helps all type of readers to readers to understand from beginners to more advanced students. It includes a significant number of exercises and longer programming projects. It also includes extensive revisions and updates.");
                textView2.setText("Author: K N King\n" +
                        "Latest Edition: 2nd Edition");
                break;
            case "8":
                imageView.setImageDrawable(getDrawable(R.drawable.e12350));
                textView.setText(mThumbNames[8]);
                textView1.setText("Expert C Programming: Deep Secrets 1st Edition, Kindle EditionExpert C programming is a book written by Peter Van Der Linden is a second book which offers many advanced tips and tricks. This book helps C programmer to scan the sections that are relevant to their immediate needThe book explains various coding techniques which is used by the best C programmers. It gave an introduction on to C in the simplest language so that a programmer can understand it without in-depth research. It is also an ideal programming book for anyone who wants to learn more about the implementation, practical use of C.");
                textView2.setText("Author: Peter Van Der \n" +
                        "Latest Edition: 1st Edition");
                break;
            case "9":
                imageView.setImageDrawable(getDrawable(R.drawable.e12351));
                textView.setText(mThumbNames[9]);
                textView1.setText("Starting Out with C++ from Control Structures to Objects plus MyLab Programming with Pearson eText -- Access Card Package (8th Edition)This C++ book was written by Tony Gaddis’s accessible. It is step-by-step presentation helps the beginner as well as experienced developers. It helps them to understand important concepts of C++ programming languageIn this book, Gaddis covers control structures, functions, arrays, and pointers before objects and classes. Gaddis texts, clear and easy-to-read code with many practical, real-world examples. MyProgrammingLab for Starting Out with C++ offers homework, assessment program which engages learners.");
                textView2.setText("Author: Tony Gaddis\n" +
                        "Latest Edition: 8th Edition");
                break;
            case "10":
                imageView.setImageDrawable(getDrawable(R.drawable.e12352));
                textView.setText(mThumbNames[10]);
                textView1.setText(" C++ Primer 5th EditionC++ Primer (5th Edition) 5th Edition written by Stanley B, introduces the C++ standard library from the outset. It helps you to write useful programs without the need to master every aspect of C++ language. The books cover many examples, and it also demonstrates how to make the best use of them.This book is ideal for that new developer who wants to know core C++ concepts and techniques. The book helps you to learn through examples that illuminate today’s best coding styles and program design techniques.");
                textView2.setText("Author: Stanley B\n" +
                        "Latest Edition: 5th Edition");
                break;
            case "11":
                imageView.setImageDrawable(getDrawable(R.drawable.e12353));
                textView.setText(mThumbNames[11]);
                textView1.setText("C++ Standard Library, The: A Tutorial And Reference 2Nd Edition 2nd EditionThe book offers comprehensive documentation of each library component, which includes an introduction to its purpose and design.This C++ book covers practical programming details needed for effective use. It also teaches signature, important classes and functions and plenty of examples of working code. The book also covers topic like Standard Template Library (STL), examining containers, iterators, function objects, etc.");
                textView2.setText("Author: Barbara E.Moo\n" +
                        "Latest Edition: 2nd Edition");
                break;
            case "12":
                imageView.setImageDrawable(getDrawable(R.drawable.e12354));
                textView.setText(mThumbNames[12]);
                textView1.setText("Effective Modern C++ is a book written in the form of guidelines and not rules because guidelines have exceptions. The most important part of each Item is not the advice it offers, but the rationale behind the advice. When you’ve read that, you’ll be in a position to determine whether the circumstances of your project justify a violation of the Item’s guidance.The main goal of this book is to provide a deeper understanding of how things work in C++11 and C++14.");
                textView2.setText("Author: Scottt Meyers\n" +
                        "Latest Edition: 2nd Edition");
                break;
            case "13":
                imageView.setImageDrawable(getDrawable(R.drawable.e12355));
                textView.setText(mThumbNames[13]);
                textView1.setText("This is an advanced C++ learning book written by  Andrew Koenig. The book includes topics like The pros and cons of braced initialization, perfect forwarding, except specifications, and smart pointer makes functions. The relationships among std:: move, std:: forward. It also overs techniques which helps you to write correct, useful lambda expressions.Effective Modern C++ is the most important book to know important C++ concept and guidelines, styles, and idioms to effectively use modern C++ effectively and thoroughly.");
                textView2.setText("Author: Andrew Koenig\n" +
                        "Latest Edition: 3rd Edition");
                break;
            case "14":
                imageView.setImageDrawable(getDrawable(R.drawable.e12356));
                textView.setText(mThumbNames[14]);
                textView1.setText("Python Crash Course by Eric Matthews is a fast-paced and comprehensive introduction to Python language for beginners who wish to learn Python programming and write useful programs. The book aims to get you up to speed fast enough and have you writing real programs in no time at all. This book is also for programmers who have a vague understanding of the language and wish to brush up their knowledge before trying their hands-on Python programming. As you work through the book, you learn the use of libraries and tools such as Numpy and matplotlib and work with data to create stunning visualizations. You also learn about the idea behind 2d games and Web applications and how to create them.");
                textView2.setText("Author: Eric Matthews\n" +
                        "Latest Edition: 2nd Edition");
                break;
            case "15":
                imageView.setImageDrawable(getDrawable(R.drawable.e12357));
                textView.setText(mThumbNames[15]);
                textView1.setText("Head-First Python by Paul Barry is a quick and easy fix for you if you wish to learn the basics of Python programming without having to slog through counterproductive tutorials and books. The book helps you in gaining a quick grasp of the fundamentals of Python programming and working with built-in functions and data structures. The book then moves to help you build your web application, exception handling, data wrangling, and other concepts. The head first Python makes use of a visual format rather than a text-based approach, helping you to see and learn better.");
                textView2.setText("Author: Paul Barry\n" +
                        "Latest Edition: 2nd Edition");
                break;
            case "16":
                imageView.setImageDrawable(getDrawable(R.drawable.e12358));
                textView.setText(mThumbNames[16]);
                textView1.setText("Learn Python the Hard Way by Zed A. Shaw (3rd Edition) is a collection of 52 correctly collated exercises. You have to read the code and type it precisely. Once typed, you have to fix the mistakes in the code for a better understanding and watch the programs run. These exercises help you understand the working of the software, structure of a well-written program, and how to avoid and find common mistakes in code using some tricks that professional programmers have up their sleeves.");
                textView2.setText("Author: Zed A.Shaw\n" +
                        "Latest Edition: 3rd Edition");
                break;
            case "17":
                imageView.setImageDrawable(getDrawable(R.drawable.e12359));
                textView.setText(mThumbNames[17]);
                textView1.setText("Python Programming by John Zelle is the third edition of the original Python programming book published in 2004, the second edition of which released in 2010. Instead of treating this book as a source of Python programming, it is recommended to take it as an introduction to the art of programming. This book introduces you to computer science, programming, and other concepts, only using Python language as the medium for beginners. The book discusses its contents in a style that is most suitable for beginners, who find the concepts in the book easy to understand and engaging.");
                textView2.setText("Author: John Zelle\n" +
                        "Latest Edition: 3rd Edition");
                break;
            case "18":
                imageView.setImageDrawable(getDrawable(R.drawable.e12360));
                textView.setText(mThumbNames[18]);
                textView1.setText("Learning with Python by Allen Downey, Jeff Elkner, and Chris Meyers is an introduction to Python programming and using the language to create excellent real-world programs. The book divides into 20 sections and also includes a contributors list and a way forward. The initial sections discuss the basics of programming and what makes up a program. Then it moves on to basic Python concepts such as variables, functions, conditionals, fruitful functions, and iteration. Towards the end, the book discusses the core concepts such as objects, inheritance, lists, stacks, queues, trees, and debugging.");
                textView2.setText("Author: Allen Downey\n" +
                        "Latest Edition: 3rd Edition");
                break;
            default:
                break;
        }


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("val",send);
                Toast.makeText(book_information.this, "Book added to wishlist", Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sen();
            }
        });

    }


    public String sendVal(){ return num;
    }

    public void sen(){
        in = new Intent(book_information.this,issuebookform.class);
        in.putExtra("val",num);
        startActivity(in);
    }
}
