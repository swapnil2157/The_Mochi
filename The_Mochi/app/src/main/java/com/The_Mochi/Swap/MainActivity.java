package com.The_Mochi.Swap;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.The_Mochi.Swap.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
                if(Nametv.getText().toString().isEmpty()){
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
                String tvstitchingfac = tvstichingfac1.getText().toString();
                tvstitchingfac=tvstichingfac1.getText().toString().trim();
                String name = Nametv.getText().toString();
                name=Nametv.getText().toString().trim();
                String tvdaysopen = tvdaysopen2.getText().toString();
                tvdaysopen=tvdaysopen2.getText().toString().trim();
                if (name.isEmpty() && name.length()<3 && tvstitchingfac.isEmpty() && tvstitchingfac.length()<3 && tvdaysopen.isEmpty() && tvdaysopen.length()<3){
                    Toast.makeText(MainActivity.this,"USER CANNOT BE EMPTY",Toast.LENGTH_LONG).show();
                    return;
                }

                if (name.isEmpty()){
                    Toast.makeText(MainActivity.this,"NAME FIELD IS REQUIRED",Toast.LENGTH_LONG).show();
                    return;
                }
                if(name.length()<3) {
                    Toast.makeText(MainActivity.this, "LENGTH OF NAME IS < 3", Toast.LENGTH_LONG).show();
                    return;
                }


                if (tvstitchingfac.isEmpty()){
                    Toast.makeText(MainActivity.this,"STITCHING FACILITIES FIELD IS REQUIRED",Toast.LENGTH_LONG).show();
                    return;
                }
                if(tvstitchingfac.length()<3) {
                    Toast.makeText(MainActivity.this, "LENGTH OF FACILITIES IS < 3", Toast.LENGTH_LONG).show();
                    return;
                }


                if (tvdaysopen.isEmpty()){
                    Toast.makeText(MainActivity.this,"DAYS OPEN FIELD IS REQUIRED ",Toast.LENGTH_LONG).show();
                    return;
                }
                if(tvdaysopen.length()<3) {
                    Toast.makeText(MainActivity.this, "LENGTH OF DAYS OPEN IS < 3", Toast.LENGTH_LONG).show();
                    return;
                }

                String contnumber = contno.getText().toString();
                contnumber=contno.getText().toString().trim();
                String id = reference.push().getKey();
                reference.child(id).child("name").setValue(name);
                reference.child(id).child("facilities").setValue(tvstitchingfac);
                reference.child(id).child("DaysOpen").setValue(tvdaysopen);
                reference.child(id).child("contactNo").setValue(contnumber);
                Intent Redirect=new Intent(MainActivity.this,adduser.class);
                startActivity(Redirect);
            }
        });
    }
}




