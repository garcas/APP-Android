package practica2.ds.ds.Modelo;

import java.util.ArrayList;

/**
 * Created by garcas on 28/04/2015.
 */
public class Juego implements Actividades{
    ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    int idJuego=0;
    int tipo;

    public void addPregunta(Pregunta pr){
        preguntas.add(pr);
    }
    public Pregunta getPregunta(int index){
        return preguntas.get(index);
    }

    @Override
    public int getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getTam(){
        return preguntas.size();
    }
}
