package com.example.dell.firebaseauth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class welcome extends AppCompatActivity {

    Button button,button2;
    FirebaseAuth mAuth;

    String value="java";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_welcome );
        mAuth=FirebaseAuth.getInstance();
        button=(Button)findViewById( R.id.button2 );
        button2=(Button)findViewById( R.id.button3 );
        textView=(TextView)findViewById( R.id.textView );
        FirebaseUser user=mAuth.getCurrentUser();
        String user_id=user.getUid();

        textView.setText( "Welcome  "+user.getEmail() );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                finish();
                startActivity( new Intent( welcome.this,login.class ) );
            }
        } );
        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( welcome.this,courses.class ) );
            }
        } );

    }
}
