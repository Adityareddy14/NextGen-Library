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

    EditText name,email,id,mobile,password,conpassword;
    Button b1;

    INodeJs myAPI;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void onStop(){
        super.onStop();
    }

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

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        id = (EditText) findViewById(R.id.id);
        mobile = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        conpassword = (EditText) findViewById(R.id.conpassword);

        b1 = (Button) findViewById(R.id.register);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(name.getText().toString(),email.getText().toString(),id.getText().toString(),mobile.getText().toString(),password.getText().toString());
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
}
