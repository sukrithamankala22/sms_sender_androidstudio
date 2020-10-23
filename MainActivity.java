package com.example.sms_sender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText pnum,pmsg;
    Button sendbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pnum=(EditText)findViewById(R.id.pnum);
        pmsg=(EditText)findViewById(R.id.pmsg);
        sendbtn=(Button)findViewById(R.id.sendbtn);
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    SmsManager smgr= SmsManager.getDefault();
                    smgr.sendTextMessage(pnum.getText().toString(),null,pmsg.getText().toString(),null,null);
                    Toast.makeText(MainActivity.this,"SMS Sent",Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,"SMS failed",Toast.LENGTH_SHORT).show();
                }
                /*try {
                    Intent i= new Intent(Intent.ACTION_VIEW);
                    i.setType("vnd.android-dir/mms-sms");
                    i.putExtra("address",new String(pnum.getText().toString()));
                    i.putExtra("sms_body",pmsg.getText().toString());
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,"sms failed",Toast.LENGTH_SHORT).show();
                }*/


            }
        });
    }
}