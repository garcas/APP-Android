package practica2.ds.ds.BaseDeDatos;

/**
 * Created by Pablo on 01/05/2015.
 */
public class TablaRespuestas {

    // Labels table name
    public static final String TABLE = "Respuestas";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_respuesta = "respuesta";
    public static final String KEY_idPregunta = "idPregunta";
    public static final String KEY_ruta = "ruta";
    public static final String KEY_tipo = "tipo";
    public static final String KEY_correcta = "correcta";

    public int id;
    public String respuesta;
    public String ruta;
    public int tipo;
    public int idPregunta;
    public int correcta;

}

