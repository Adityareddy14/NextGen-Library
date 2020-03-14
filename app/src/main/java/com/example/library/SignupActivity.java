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
import android.widget.Toast;

import com.example.library.Retrofit.INodeJs;
import com.example.library.Retrofit.RetroClient;

public class SignupActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText id;
    EditText mobile;
    EditText password;
    EditText conpassword;
    int test=1;
    Button b1;

    INodeJs myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

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
        setContentView(R.layout.activity_signup);

        Retrofit retrofit = RetroClient.getInstance();
        myAPI = retrofit.create(INodeJs.class);

        name =  findViewById(R.id.name);
        email =  findViewById(R.id.email);
        id =  findViewById(R.id.id);
        mobile =  findViewById(R.id.phone);
        password =  findViewById(R.id.password);
        conpassword =  findViewById(R.id.conpassword);

        b1 =  findViewById(R.id.register);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p =password.getText().toString();
                String p1=conpassword.getText().toString();
                if(p.equals(p1)){
                    register(name.getText().toString(),email.getText().toString(),id.getText().toString(),mobile.getText().toString(),password.getText().toString());
                }
                else{
                    Toast.makeText( SignupActivity.this,"Password didn't matched",Toast.LENGTH_SHORT).show();
                }
                 }
        });


    }

    private void register(String name,String email,String id,String mobile,String password){
        compositeDisposable.add(myAPI.register(name,email,id,mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText( SignupActivity.this,""+s,Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                })

        );
    }

    public int testimportfile2(){
        if(test==1){
            return 1;
        }

        return 0;

    }
    public int testoncfile(String a,String b,int c,int d,int e,int f) {
        if (a.equals("") && b.equals("") && c == 0 && d == 0 && e == 0 && f == 0) {
            return 0;
        }

        return 1;
    }


}
