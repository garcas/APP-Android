package practica2.ds.ds.Modelo;

/**
 * Created by garcas on 28/04/2015.
 */
public class JuegoConcreto extends Juego {

    public void addPregunta(Pregunta pr){
        preguntas.add(pr);
    }

    public Pregunta getPregunta(int index){
        return preguntas.get(index);
    }
}
