package practica2.ds.ds.Controlador.Respuestas;

/**
 * Created by Pablo on 04/05/2015.
 */
public abstract class Respuesta {
    int id;
    String respuesta;
    String ruta;
    int tipo;
    int idPregunta;
    int correcta;

    public Respuesta(int id,String respuesta,String ruta,int tipo,int idPregunta,int correcta){
        this.id = id;
        this.respuesta = respuesta;
        this.ruta = ruta;
        this.tipo = tipo;
        this.idPregunta = idPregunta;
        this.correcta = correcta;
    }
    public String getRespuesta(){
        return respuesta;
    }
    public abstract String getRuta();

    public int getTipo(){
        return tipo;
    }
    public int getIdPregunta(){
        return idPregunta;
    }
    public int getCorrecta() {
        return correcta;
    }
}
