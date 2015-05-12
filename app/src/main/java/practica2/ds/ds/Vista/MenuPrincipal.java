package practica2.ds.ds.Vista;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.net.URL;

import practica2.ds.ds.BaseDeDatos.InicializacionBaseDatos;
import practica2.ds.ds.BaseDeDatos.TablaEnunciados;
import practica2.ds.ds.BaseDeDatos.TablaRespuestas;
import practica2.ds.ds.BaseDeDatos.metodosTablas;
import practica2.ds.ds.R;


public class MenuPrincipal extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        metodosTablas sr = new metodosTablas(this);

        IniciarJuego();
        InicializacionBaseDatos i = new InicializacionBaseDatos(sr);

    }

    public void IniciarJuego(){
        Button boton = (Button)findViewById(R.id.buttonIniciarJuego);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPrincipal.this, SeleccionarActividad.class));
        }});
        Button boton2 = (Button)findViewById(R.id.buttonResultados);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPrincipal.this, mostrarResultados.class));
            }});
        Button boton3 = (Button)findViewById(R.id.buttonEnlazar);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=question%20games"));
                startActivity(browserIntent);
            }});

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
