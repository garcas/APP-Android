package practica2.ds.ds.Controlador.Enunciados;

/**
 * Created by garcas on 28/04/2015.
 */
public class EnunciadoTextoConImagen extends Enunciado {


    public EnunciadoTextoConImagen(int student_ID, String enunciado, String ruta, int tipo, String categoria) {
        super(student_ID, enunciado, ruta, tipo, categoria);
    }

    @Override
    public String getRuta() {
        return ruta;
    }
}
