package com.example.a3_month_1_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSend;
    private EditText editTo;
    private EditText editSubject;
    private EditText editMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSend = findViewById(R.id.buttonSend);
        editTo = findViewById(R.id.editTextTo);
        editSubject = findViewById(R.id.editTextSubject);
        editMessage = findViewById(R.id.editTextMessage);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String to = editTo.getText().toString();
                String subject = editSubject.getText().toString();
                String message = editMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT,subject);
                email.putExtra(Intent.EXTRA_TEXT,message);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Выберите email клиента"));



            }
        });
    }
}