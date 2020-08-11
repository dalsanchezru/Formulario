package com.example.miformulario;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import android.os.Parcelable;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText nombrecompleto, etDate, telefono, email, descripcion;
    DatePickerDialog.OnDateSetListener setListener;
    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombrecompleto = (EditText)findViewById(R.id.editNombre);
        etDate        = (EditText)findViewById(R.id.editDate);
        telefono    = (EditText)findViewById(R.id.editTelefono);
        email       = (EditText)findViewById(R.id.editEmail);
        descripcion = (EditText)findViewById(R.id.editDescripcióndecontacto);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        siguiente   = (Button)findViewById(R.id.btnSiguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String com_name = nombrecompleto.getText().toString();
                String dat = etDate.getText().toString();
                String tel1 = telefono.getText().toString();
                String e_mail = email.getText().toString();
                String descrip = descripcion.getText().toString();

               Bundle i = new Bundle();

                i.putString("com_name", nombrecompleto.getText().toString());
                i.putString("dat", etDate.getText().toString());
                i.putString("tel1", telefono.getText().toString());
                i.putString("e_mail", email.getText().toString());
                i.putString("descrip", descripcion.getText().toString());

                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtras(i);
                startActivity(intent);

            }
        });

    }
}