package practica2.ds.ds.Controlador.Respuestas;

/**
 * Created by garcas on 28/04/2015.
 */
public class RespuestaSonido extends Respuesta{

    public RespuestaSonido(int id, String respuesta, String ruta, int tipo, int idPregunta, int correcta) {
        super(id, respuesta, ruta, tipo, idPregunta, correcta);
    }

    @Override
    public String getRuta() {
        return ruta;
    }
}
