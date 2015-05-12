package practica2.ds.ds.Modelo;

import java.util.ArrayList;

import practica2.ds.ds.Controlador.Enunciados.Enunciado;
import practica2.ds.ds.Controlador.Respuestas.Respuesta;

/**
 * Created by garcas on 28/04/2015.
 */
public class Pregunta {
    Enunciado enunciado;
    ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
    int tipo;

    public Pregunta(Enunciado enunciado, ArrayList<Respuesta> respuestas, int tipo){
        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.tipo = tipo;
    }

    public Enunciado getEnunciado(){
        return enunciado;
    }
    public ArrayList<Respuesta> getRespuestas(){
        return respuestas;
    }
    public int getTipo(){
        return tipo;
    }
}
