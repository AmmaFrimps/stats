package com.example.stats;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {
private EditText text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11;
DatabaseReference reff;
private Button btn1;
private TextView tv1,tv2,tv3;
//Member member;
private FirebaseFirestore mFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn1=findViewById(R.id.button3);
        tv1=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView4);
        tv3=findViewById(R.id.textView5);
        text1=findViewById(R.id.editText3);
        text2=findViewById(R.id.editText10);
        text3=findViewById(R.id.editText11);
        text4=findViewById(R.id.editText13);
        text11=findViewById(R.id.editText15);
        text5=findViewById(R.id.editText18);
        text6=findViewById(R.id.editText17);
        text7=findViewById(R.id.editText16);
        text8=findViewById(R.id.editText20);
        text9=findViewById(R.id.editText21);
        text10=findViewById(R.id.editText22);
        //member=new Member();
        //reff=FirebaseDatabase.getInstance().getReference().child("Member");
        mFirestore=FirebaseFirestore.getInstance();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname=text1.getText().toString();
                Map<String,String> userMap=new HashMap<> ();
                userMap.put("Full name",fname);
                String street=text2.getText().toString();
                userMap.put("Street",street);
                String DigAdress=text4.getText().toString();
                userMap.put("Digital Address",DigAdress);
                String distr=text3.getText().toString();
                userMap.put("   District",distr);
                String ma =text11.getText().toString();
                userMap.put("Male Adults",ma);
                String fa=text7.getText().toString();
                userMap.put("Female Adults",fa);
                String cm=text6.getText().toString();
                userMap.put("Male Children",cm);
                String cf=text5.getText().toString();
                userMap.put("Female Children",cf);
                String Aged=text8.getText().toString();
                userMap.put("Aged",Aged);
                String ea=text9.getText().toString();
                userMap.put("Employed Adults",ea);
                String ua=text10.getText().toString();
                userMap.put("Unemployed Adults",ua);


                mFirestore.collection("Member").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(RegisterActivity.this,"Data Inserted Succesfully",Toast.LENGTH_SHORT).show();
                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        String error=e.getMessage();
                        Toast.makeText(RegisterActivity.this,"Error: " +error,Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        //btn1.setOnClickListener(new View.OnClickListener() {
           // @Override
          //  public void onClick(View view) {
                //Integer ma,fa,cm,cf,Aged,ea,ua
                //int man=Integer.parseInt(text11.getText().toString().trim());
               // int fan=Integer.parseInt(text7.getText().toString().trim());
               /* int cma=Integer.parseInt(text6.getText().toString().trim());
                int cfa=Integer.parseInt(text5.getText().toString().trim());
                int Ageda=Integer.parseInt(text8.getText().toString().trim());
                int ean=Integer.parseInt(text9.getText().toString().trim());
                int uan=Integer.parseInt(text10.getText().toString().trim());





                member.setFname(text1.getText().toString().trim());
                member.setDistr(text2.getText().toString().trim());
                member.setAged(Ageda);
                member.setCf(cfa);
                member.setCm(cma);
                member.setDigAdress(text4.getText().toString().trim());
                member.setEa(ean);
                member.setFa(fan);
                member.setMa(man);
                member.setStreet(text3.getText().toString().trim());
                member.setUa(uan);


                reff.push().setValue(member);
                Toast.makeText(RegisterActivity.this,"Data Inserted Succesfully",Toast.LENGTH_LONG).show();
*/
            }


    }

