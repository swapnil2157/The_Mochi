package com.The_Mochi.Swap;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    EditText Nametv, tvstichingfac1, tvdaysopen2, contno;
    DatabaseReference reference;
    Button Redirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reference = FirebaseDatabase.getInstance().getReference("users");

        Nametv = findViewById(R.id.tv1);
        Nametv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(Nametv.getText().length()<12){
                    Nametv.setError("This Field is Required");
                }
            }
        });
        tvstichingfac1 = findViewById(R.id.tv4);
        tvstichingfac1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(tvstichingfac1.getText().length()<20){
                    tvstichingfac1.setError("This Field is Required");
                }
            }
        });
        tvdaysopen2 = findViewById(R.id.tv6);
        tvdaysopen2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(tvdaysopen2.getText().length()<10){
                    tvdaysopen2.setError("This Field is Required");
                }
            }
        });
        contno = findViewById(R.id.tv14);
        contno.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(contno.getText().length()<11){
                    contno.setError("This Field is Required");
                }
            }
        });

        (findViewById(R.id.add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Nametv.getText().toString();
                String tvstitchingfac = tvstichingfac1.getText().toString();
                String tvdaysopen = tvdaysopen2.getText().toString();
                String textview = contno.getText().toString();
                String id = reference.push().getKey();
                reference.child(id).child("name").setValue(name);
                reference.child(id).child("facilities").setValue(tvstitchingfac);
                reference.child(id).child("DaysOpen").setValue(tvdaysopen);
                reference.child(id).child("contactNo").setValue(textview);
                Intent Redirect=new Intent(MainActivity.this,adduser.class);
                startActivity(Redirect);
            }
        });
    }
}




