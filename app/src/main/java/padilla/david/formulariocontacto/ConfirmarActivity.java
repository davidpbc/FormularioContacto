package padilla.david.formulariocontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class ConfirmarActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaValor;
    private TextView tvTelefonoValor;
    private TextView tvEmailValor;
    private TextView tvDescripcionValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        Bundle params = getIntent().getExtras();
        String nombre = params.getString(getResources().getString(R.string.pnombre));
        String fecha = params.getString(getResources().getString(R.string.pfecha));
        String telefono = params.getString(getResources().getString(R.string.ptelefono));
        String email = params.getString(getResources().getString(R.string.pemail));
        String descripcion = params.getString(getResources().getString(R.string.pdescripcion));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFechaValor = (TextView) findViewById(R.id.tvFechaValor2);
        tvTelefonoValor = (TextView) findViewById(R.id.tvTelefonoValor);
        tvEmailValor = (TextView) findViewById(R.id.tvEmailValor);
        tvDescripcionValor = (TextView) findViewById(R.id.tvDescripcionValor);

        tvNombre.setText(nombre);
        tvFechaValor.setText(fecha);
        tvTelefonoValor.setText(telefono);
        tvEmailValor.setText(email);
        tvDescripcionValor.setText(descripcion);
    }

    public void editarContacto(View v) {
        regresar();
    }

    public void regresar() {
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFechaValor = (TextView) findViewById(R.id.tvFechaValor2);
        tvTelefonoValor = (TextView) findViewById(R.id.tvTelefonoValor);
        tvEmailValor = (TextView) findViewById(R.id.tvEmailValor);
        tvDescripcionValor = (TextView) findViewById(R.id.tvDescripcionValor);

        Intent intent = new Intent(ConfirmarActivity.this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.pnombre), tvNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecha), tvFechaValor.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono), tvTelefonoValor.getText().toString());
        intent.putExtra(getResources().getString(R.string.pemail), tvEmailValor.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdescripcion), tvDescripcionValor.getText().toString());
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            regresar();
        }
        return super.onKeyDown(keyCode, event);
    }
}
