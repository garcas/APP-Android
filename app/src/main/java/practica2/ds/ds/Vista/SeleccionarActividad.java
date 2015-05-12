package practica2.ds.ds.Vista;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import practica2.ds.ds.BaseDeDatos.metodosTablas;
import practica2.ds.ds.R;


public class SeleccionarActividad extends ActionBarActivity {
    int cont;
    ArrayList<String> categorias;
    metodosTablas repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_actividad);
        repo = new metodosTablas(this);
        cont=0;
        categorias = new ArrayList<String>();
        verNumCategorias();
        PonerActividades();

    }

    //lo utilizamos para crear dinamicamente los botones
    private void LayoutAddButton(Button button, int centerInParent, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        // Defining the layout parameters of the Button

        RelativeLayout.LayoutParams buttonLayoutParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        // Add Margin to the LayoutParameters
        buttonLayoutParameters.setMargins(marginLeft, marginTop, marginRight, marginBottom);
        // Add Rule to Layout
        buttonLayoutParameters.addRule(centerInParent);

        // Setting the parameters on the Button
        button.setLayoutParams(buttonLayoutParameters);
    }
    //añade al layout el boton nuevo en la posición elegida respecto del padre
    private void AddButtonLayout(Button button, int centerInParent) {
        // Just call the other AddButtonLayout Method with Margin 0
        LayoutAddButton(button, centerInParent, 0, 0, 0, 0);
    }

    public Button NuevoBoton(final String textoBoton){
        Button button1 = new Button(this);
        //le asignamos el texto
        button1.setText(textoBoton);
        //le asignamos lo que tiene q hacer y devolver al clicarlo
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeleccionarActividad.this, IniciarJuego.class);
                Bundle bundle = new Bundle();
                bundle.putString("Actividad", textoBoton);
                intent.putExtras(bundle);
                startActivity(intent);
            }});

        LayoutAddButton(button1, RelativeLayout.CENTER_HORIZONTAL,0,cont*200,0,0);
        cont++;

        return button1;
    }

    public void verNumCategorias(){
        String aux;
        boolean existe = false;
        for(int i=1;i<=repo.getAll().size();i++) {
            aux = repo.getEnunciado(i).getCategoria();
            for(int j=0;j<categorias.size();j++){
                if(aux.equals(categorias.get(j))){
                    existe=true;
                }
            }

            if(existe==false){
                categorias.add(aux);
            }
            existe=false;
        }

    }
    public void PonerActividades(){

        // Creating a new RelativeLayout
        RelativeLayout relativeLayout = new RelativeLayout(this);
        // Defining the RelativeLayout layout parameters with Fill_Parent
        relativeLayout.layout(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        relativeLayout.setBackgroundResource(R.drawable.background2);

        Button aux;
        String auxTexto;
        relativeLayout.setPadding(0,200,0,0);
        for(int i=0;i<categorias.size();i++) {
            auxTexto = categorias.get(i);
            aux = NuevoBoton(auxTexto);
            aux.setBackgroundResource(R.drawable.botonactividad);
            relativeLayout.addView(aux);
        }
        setContentView(relativeLayout);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seleccionar_actividad, menu);
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
