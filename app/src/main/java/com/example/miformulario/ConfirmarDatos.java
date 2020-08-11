package com.example.miformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;

import android.preference.TwoStatePreference;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView tvnombrecompleto, tvdate, tvtelefono, tvemail, tvdescripcion;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tvnombrecompleto = (TextView)findViewById(R.id.tvNombrecompleto);
        tvdate           = (TextView)findViewById(R.id.tvDate);
        tvtelefono       = (TextView)findViewById(R.id.tvTelefono);
        tvemail          = (TextView)findViewById(R.id.tvEmail);
        tvdescripcion    = (TextView)findViewById(R.id.tvDescripcióndecontacto);
        btnEditar        = (Button) findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                startActivity(intent);
            }
        });

        confirmarDato();
    }

    private void confirmarDato() {
        Bundle datos = this.getIntent().getExtras();

        String nombrecompleto = datos.getString("com_name");
        String date = datos.getString("dat");
        String telefono = datos.getString("tel1");
        String email = datos.getString("e_mail");
        String descripcion = datos.getString("descrip");

        tvnombrecompleto.setText(nombrecompleto);
        tvdate.setText(date);
        tvtelefono.setText(telefono);
        tvemail.setText(email);
        tvdescripcion.setText(descripcion);

        }

}