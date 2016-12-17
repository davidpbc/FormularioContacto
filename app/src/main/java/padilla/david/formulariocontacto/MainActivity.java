package padilla.david.formulariocontacto;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerFragment.DatePickerFragmentListener {

    private TextView tvFechaValor;
    private String fecha, nombre, telefono, email, descripcion;
    private android.support.design.widget.TextInputEditText tieNombre;
    private android.support.design.widget.TextInputEditText tieTelefono;
    private android.support.design.widget.TextInputEditText tieEmail;
    private android.support.design.widget.TextInputEditText tieDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle params = getIntent().getExtras();
        try {
            nombre = params.getString(getResources().getString(R.string.pnombre));
            fecha = params.getString(getResources().getString(R.string.pfecha));
            telefono = params.getString(getResources().getString(R.string.ptelefono));
            email = params.getString(getResources().getString(R.string.pemail));
            descripcion = params.getString(getResources().getString(R.string.pdescripcion));
        } catch (java.lang.NullPointerException e) {
            nombre = "";
            fecha = "";
            telefono = "";
            email = "";
            descripcion = "";

        }

        if (nombre != ""){
            tieNombre = (android.support.design.widget.TextInputEditText) findViewById(R.id.tieNombre);
            tieTelefono = (android.support.design.widget.TextInputEditText) findViewById(R.id.tieTelefono);
            tieEmail = (android.support.design.widget.TextInputEditText) findViewById(R.id.tieEmail);
            tieDescripcion = (android.support.design.widget.TextInputEditText) findViewById(R.id.tieDescripcion);
            tvFechaValor = (TextView) findViewById(R.id.tvFechaValor);


            tieNombre.setText(nombre);
            tieEmail.setText(email);
            tieTelefono.setText(telefono);
            tieDescripcion.setText(descripcion);
            tvFechaValor.setText(fecha);
        }

    }

    public void mostrarDatePicker(View v) {
        //DialogFragment picker = new DatePickerFragment();
        //picker.show(getSupportFragmentManager(), "datePicker");
        DatePickerFragment fragment = DatePickerFragment.newInstance(this);
        fragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void confirmar(View v) {
        tieNombre = (android.support.design.widget.TextInputEditText) findViewById(R.id.tieNombre);
        tieTelefono = (android.support.design.widget.TextInputEditText) findViewById(R.id.tieTelefono);
        tieEmail = (android.support.design.widget.TextInputEditText) findViewById(R.id.tieEmail);
        tieDescripcion = (android.support.design.widget.TextInputEditText) findViewById(R.id.tieDescripcion);
        tvFechaValor = (TextView) findViewById(R.id.tvFechaValor);

        Intent intent = new Intent(MainActivity.this, ConfirmarActivity.class);
        intent.putExtra(getResources().getString(R.string.pnombre), tieNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecha), tvFechaValor.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono), tieTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pemail), tieEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdescripcion), tieDescripcion.getText().toString());
        startActivity(intent);
        finish();
    }

    @Override
    public void onDateSet(Date date) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        fecha = format.format(date);
        tvFechaValor = (TextView) findViewById(R.id.tvFechaValor);
        tvFechaValor.setText(fecha);
    }
}
