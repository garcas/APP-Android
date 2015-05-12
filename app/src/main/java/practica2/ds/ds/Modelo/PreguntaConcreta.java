package practica2.ds.ds.Modelo;

import java.util.ArrayList;

import practica2.ds.ds.Controlador.Enunciados.Enunciado;
import practica2.ds.ds.Controlador.Respuestas.Respuesta;

/**
 * Created by garcas on 28/04/2015.
 */
public class PreguntaConcreta extends Pregunta {

    String categoria;

    public PreguntaConcreta(Enunciado enunciado, ArrayList<Respuesta> respuestas, int tipo) {
        super(enunciado, respuestas, tipo);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }




}
