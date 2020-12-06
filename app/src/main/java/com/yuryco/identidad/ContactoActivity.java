package com.yuryco.identidad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.yuryco.identidad.util.SendMail;

public class ContactoActivity extends AppCompatActivity {

    TextInputEditText nombreC ;
    TextInputEditText correoC ;
    TextInputEditText mensajeC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        nombreC = findViewById(R.id.etNombre);
        correoC = findViewById(R.id.etCorreo);
        mensajeC = findViewById(R.id.eMensaje);
    }

    public void enviarComentario(View v ){

        String email = correoC.getText().toString().trim();
        String subject = nombreC.getText().toString().trim();
        String message = mensajeC.getText().toString().trim();

       // Log.i("Conctacto Activity","Email "+email+" subject "+subject+" message "+message);

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }
}