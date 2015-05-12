package practica2.ds.ds.Vista;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

import practica2.ds.ds.BaseDeDatos.TablaResultados;
import practica2.ds.ds.BaseDeDatos.metodosTablas;
import practica2.ds.ds.Controlador.Respuestas.Respuesta;
import practica2.ds.ds.Modelo.Juego;
import practica2.ds.ds.Modelo.PreguntaConcreta;
import practica2.ds.ds.Modelo.Pregunta;
import practica2.ds.ds.R;


public class IniciarJuego extends ActionBarActivity {
    MediaPlayer acierto,fallo;
    ArrayList<Button> botones;
    TextView t;
    int cont;
    metodosTablas repo;
    Juego j;
    int aciertos,fallos;
    ArrayList<ImageButton> botonTipoImagen;
    int preguntaCorrecta;
    Button imagenSonido;
    boolean reproduciendo;
    MediaPlayer sonido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_juego);
        init();
        setPreguntasRespuestas(j.getPregunta(cont));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_iniciar_juego, menu);
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



//cuando venimos desde actividad recogemos la seleccionada y la metemos en un objeto juego.
    public Juego recogerActividad(){
        //nos disponemos a crear el juego con la categoría seleccionada
        Juego juego = new Juego();
        //creamos una pregunta que utilizaremos para ir añadiendolas al juego.
        PreguntaConcreta pregunta;
         Bundle b = getIntent().getExtras();
         String actividad = b.getString("Actividad");
        //para generar la pregunta necesitaremos un array de respuestas
        ArrayList<Respuesta> respuestas=new ArrayList<Respuesta>();
        for(int i=0;i<=repo.getAll().size();i++){
            if(actividad.equals(repo.getEnunciado(i).getCategoria())){
                respuestas = repo.getRespuestaPorIDEnunciado(i);
                pregunta = new PreguntaConcreta(repo.getEnunciado(i),respuestas,repo.getEnunciado(i).getTipo());
                juego.addPregunta(pregunta);
            }
        }
        return juego;
    }
    public void init(){
        botones= new ArrayList<Button>();
        botonTipoImagen = new ArrayList<ImageButton>();
        botonTipoImagen.add((ImageButton)findViewById(R.id.botonImagen1));
        botonTipoImagen.add((ImageButton)findViewById(R.id.botonImagen2));
        botonTipoImagen.add((ImageButton)findViewById(R.id.botonImagen3));
        botonTipoImagen.add((ImageButton)findViewById(R.id.botonImagen4));
        imagenSonido =(Button)findViewById(R.id.botonImagenSonido);
        cont=0;
        aciertos =0;
        fallos =0;
        t = (TextView)findViewById(R.id.textoPregunta);
        botones.add((Button)findViewById(R.id.botonRespuesta1));
        botones.add((Button)findViewById(R.id.botonRespuesta2));
        botones.add((Button)findViewById(R.id.botonRespuesta3));
        botones.add((Button)findViewById(R.id.botonRespuesta4));
        final GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setColor(Color.LTGRAY);
        for(int i=0;i<botones.size();i++){
           botones.get(i).setBackground(drawable);
        }
        repo= new metodosTablas(this);
        j= recogerActividad();
        acierto = MediaPlayer.create(IniciarJuego.this,R.raw.correct);
        fallo = MediaPlayer.create(IniciarJuego.this,R.raw.incorrect);
        reproduciendo = false;
    }


    public void setPreguntasRespuestas(final Pregunta p){
        t.setText(p.getEnunciado().getEnunciado());
        //ENUNCIADOS DE TIPO TEXTO
        if(p.getEnunciado().getTipo()==0) {
            imagenSonido.setVisibility(View.GONE);
            //ENUNCIADOS DE TIPO IMAGEN
        }else if(p.getEnunciado().getTipo()==1){
            imagenSonido.setText("Ver Imagen");
            imagenSonido.setVisibility(View.VISIBLE);
            imagenSonido.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    mostrarImagen(p);
                }
            });
            //ENUNCIADOS DE TIPO SONIDO
        }else{
            imagenSonido.setText("Esuchar Sonido");
            imagenSonido.setVisibility(View.VISIBLE);
            imagenSonido.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    reproducirSonido(p);
                }
            });
        }
        Button aux;
        for(int i=0;i<p.getRespuestas().size();i++){
            //respuestas de tipo texto
            if(p.getRespuestas().get(i).getTipo()==0) {
                botones.get(i).setVisibility(View.VISIBLE);
                botonTipoImagen.get(i).setVisibility(View.GONE);
                botones.get(i).setText(p.getRespuestas().get(i).getRespuesta());

                if(p.getRespuestas().get(i).getCorrecta()==1){
                    preguntaCorrecta = i;
                    final int finalI = i;
                    botones.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            acierto.start();
                            aciertos++;
                            resaltarBotones(finalI, true);
                        }
                    });
                }else {
                    final int finalI1 = i;
                    botones.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            fallo.start();
                            fallos++;
                            resaltarBotones(finalI1,false);
                        }
                    });
                }
            }
            //respuestas de tipo imagen
            if(p.getRespuestas().get(i).getTipo()==1) {
                botones.get(i).setVisibility(View.GONE);
                botonTipoImagen.get(i).setVisibility(View.VISIBLE);
                botonTipoImagen.get(i).setBackgroundResource(getResources().getIdentifier(p.getRespuestas().get(i).getRuta(), "drawable", getPackageName()));
                if(p.getRespuestas().get(i).getCorrecta()==1){
                    preguntaCorrecta = 1;
                    botonTipoImagen.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            acierto.start();
                            aciertos++;
                            cambiarPregunta();
                        }
                    });
                }else {
                    botonTipoImagen.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            fallo.start();
                            fallos++;
                            cambiarPregunta();
                        }
                    });
                }
            }
        }
    }
    //Tras seleccionar una respuesta verificamos si quedan preguntas en el juego y si no mostramos las calificaciones
    public void cambiarPregunta(){
        cont++;
        if(reproduciendo) {
            sonido.stop();
            reproduciendo=false;
        }
        if(cont<j.getTam()){
            setPreguntasRespuestas(j.getPregunta(cont));
        }else{
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("¡Fin del juego!");
            alertDialog.setMessage("Su resultado final ha sido:\n - Aciertos: " + aciertos + "\n - Fallos: " + fallos);
            alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    TablaResultados resultados = new TablaResultados();
                    resultados.fecha = Calendar.getInstance().get(Calendar.DATE)+"/"+Calendar.getInstance().get(Calendar.MONTH)+"/"+Calendar.getInstance().get(Calendar.YEAR);
                    resultados.actividad=j.getPregunta(cont-1).getEnunciado().getCategoria();
                    resultados.fallos = fallos;
                    resultados.aciertos=aciertos;
                    repo.insertarREsultado(resultados);
               /* Bundle bundle = new Bundle();
                bundle.putString("Actividad", textoBoton);**/
                    startActivity(new Intent(IniciarJuego.this, MenuPrincipal.class));
                }
            });
            alertDialog.show();
        }


    }
    //Enmarcamos los botones tras hacerles click
    public void resaltarBotones(final int idBoton,boolean correcta){
        final GradientDrawable drawable = new GradientDrawable();
        final GradientDrawable drawable2 = new GradientDrawable();
      //  drawable.setShape(GradientDrawable.RECTANGLE);

        if(!correcta){
            drawable.setStroke(3, Color.RED);
            drawable.setColor(Color.rgb(255, 80, 80));
        }
        botones.get(idBoton).setBackground(drawable);
        drawable2.setShape(GradientDrawable.RECTANGLE);
        drawable2.setStroke(3, Color.GREEN);
        drawable2.setColor(Color.rgb(102, 255, 102));
        botones.get(preguntaCorrecta).setBackground(drawable2);
        for(int i=0;i<botones.size();i++){
            botones.get(i).setClickable(false);
        }
        Handler handler = new Handler();
        //hacemos un lapso de 2 segundos entre pregutna y pregunta
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                drawable.setColor(Color.LTGRAY);
                drawable.setStroke(0,Color.WHITE);
                botones.get(idBoton).setBackground(drawable);
                botones.get(preguntaCorrecta).setBackground(drawable);
                for(int i=0;i<botones.size();i++){
                    botones.get(i).setClickable(true);
                }
                cambiarPregunta();
            }
        },2000);
    }
    //Muestra la imagen al hacer click en el boton "ver Imagen"
    public void mostrarImagen(Pregunta p){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        ImageView image = new ImageView(this);
        image.setImageResource(getResources().getIdentifier(p.getEnunciado().getRuta(), "drawable", getPackageName()));
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this).
                        setMessage("").
                        setTitle("Imagen").
                        setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setView(image);
        builder.create().show();
    }
    //Reproduce o pausa el sonido en función de su estado
    public void reproducirSonido(Pregunta p){
        if(reproduciendo){
            sonido.release();
            reproduciendo=false;
        }else {
            reproduciendo=true;
            sonido = MediaPlayer.create(IniciarJuego.this, getResources().getIdentifier(p.getEnunciado().getRuta(), "raw", getPackageName()));
            sonido.setLooping(true);
            sonido.start();
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        if(reproduciendo){
            sonido.stop();
        }
    }



}


