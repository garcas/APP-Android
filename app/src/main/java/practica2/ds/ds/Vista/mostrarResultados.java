package practica2.ds.ds.Vista;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import practica2.ds.ds.BaseDeDatos.TablaResultados;
import practica2.ds.ds.BaseDeDatos.metodosTablas;
import practica2.ds.ds.Controlador.formatoResultados;
import practica2.ds.ds.R;


public class mostrarResultados extends ActionBarActivity {
    metodosTablas repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_resultados);

        repo= new metodosTablas(this);
        getResultados();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mostrar_resultados, menu);
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

    public void getResultados(){
        //lista list view
        final ListView lista = (ListView) findViewById(R.id.listView);
        //recogemos todos los resultados de la base de datos y los asignamos a resultados.
        ArrayList<TablaResultados> resultados = new ArrayList<TablaResultados>();
        resultados = repo.getResultado();

        formatoResultados formato = new formatoResultados(this,resultados);
        lista.setAdapter(formato);
    }
}
