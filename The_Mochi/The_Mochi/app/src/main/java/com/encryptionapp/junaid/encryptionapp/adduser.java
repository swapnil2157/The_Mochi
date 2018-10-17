package com.The_Mochi.Swap;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class adduser extends AppCompatActivity {

    Button addmochi;
    DatabaseReference reference;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);

        listView = findViewById(R.id.listviews);
        addmochi=findViewById(R.id.addmochi);
        addmochi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(adduser.this,MainActivity.class);
                startActivity(intent);
            }
        });

        reference = FirebaseDatabase.getInstance().getReference().child("users");

        FirebaseListAdapter<UserModel> firebaseListAdapter = new FirebaseListAdapter<UserModel>(this, UserModel.class, R.layout.user, reference) {
            @Override
            protected void populateView(View v, UserModel model, int position) {
                TextView nameTV = v.findViewById(R.id.nameTV);
                nameTV.setText(model.getName());
                TextView facilities = v.findViewById(R.id.facilities);
                facilities.setText(model.getFacilities());
                TextView daysOpen = v.findViewById(R.id.daysOpen);
                daysOpen.setText(model.getDaysOpen());
                TextView contactNo = v.findViewById(R.id.contactNo);
                contactNo.setText(model.getContactNo());
            }
        };

        listView.setAdapter(firebaseListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                UserModel userModel = (UserModel) adapterView.getItemAtPosition(i);
                String geoUri = "http://maps.google.com/maps?q=loc:"+ userModel.getLatitude();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                startActivity(intent);
//                Toast.makeText(adduser.this, ""+userModel.getLatitude(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
