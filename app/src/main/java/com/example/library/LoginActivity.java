package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.library.Retrofit.INodeJs;
import com.example.library.Retrofit.RetroClient;

public class LoginActivity extends AppCompatActivity {

    EditText e1;
    EditText e2;
    Button b1;
    Button b2;
    TextView t1;
     String em;
     int od = 1;
    INodeJs myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    Bundle bundle = new Bundle();

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        compositeDisposable.clear();
        super.onDestroy();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Retrofit retrofit = RetroClient.getInstance();
        myAPI = retrofit.create(INodeJs.class);

        e1 =  findViewById(R.id.uname);
        e2 =  findViewById(R.id.password);

        b1 =  findViewById(R.id.login);

        b2 =  findViewById(R.id.forgotpass);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,ForgotPassword.class);
                startActivity(i);
            }
        });

        t1 =  findViewById(R.id.signup);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                intent.putExtra("username",e1.getText().toString());
                em=e1.getText().toString();

                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                em=e1.getText().toString();
                Intent intent = new Intent(LoginActivity.this, Main3Activity.class);
                intent.putExtra("email",e1.getText().toString());
                //startActivity(intent);
                loginUser(e1.getText().toString(),e2.getText().toString());

            }
        });


    }

    public String getemail(){
        return em;
    }

    private void loginUser(final String email, String password){
        compositeDisposable.add(myAPI.loginUser(email,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if(s.contains("encrypted_password")) {
                            Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, Main3Activity.class);
                            intent.putExtra("email",e1.getText().toString());
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(LoginActivity.this,""+s,Toast.LENGTH_SHORT).show();
                    }
                })

        );
    }



    public int testimportfile(){
        if(od==1){
            return 1;
        }

        return 0;

    }

    public int testsendfile(String a,String b){
        if(a.equals("")&&b.equals("")){
            return 0;
        }

        return 1;

    }

}

