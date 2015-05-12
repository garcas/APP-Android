package practica2.ds.ds.BaseDeDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    private static final int DATABASE_VERSION = 13;

    // Database Name
    private static final String DATABASE_NAME = "practica2.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_ENUNCIADOS = "CREATE TABLE " + TablaEnunciados.TABLE  + "("
                + TablaEnunciados.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + TablaEnunciados.KEY_enunciado + " TEXT, "
                + TablaEnunciados.KEY_tipo + " INTEGER, "
                + TablaEnunciados.KEY_ruta + " TEXT, "
                + TablaEnunciados.KEY_categoria +" TEXT"
                +")";

        String CREATE_TABLE_RESPUESTAS = "CREATE TABLE " + TablaRespuestas.TABLE  + "("
                + TablaRespuestas.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + TablaRespuestas.KEY_respuesta + " TEXT, "
                + TablaRespuestas.KEY_tipo + " INTEGER, "
                + TablaRespuestas.KEY_ruta +" TEXT, "
                + TablaRespuestas.KEY_correcta +" INTEGER, "
                + TablaRespuestas.KEY_idPregunta +" INTEGER"
                +")";

        String CREATE_TABLE_RESULTADOS = "CREATE TABLE " + TablaResultados.TABLE + "("
                + TablaResultados.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + TablaResultados.KEY_fecha + " TEXT, "
                + TablaResultados.KEY_actividad + " TEXT, "
                + TablaResultados.KEY_aciertos + " INTEGER, "
                + TablaResultados.KEY_fallos + " INTEGER "
                +")";

        db.execSQL(CREATE_TABLE_ENUNCIADOS);
        db.execSQL(CREATE_TABLE_RESPUESTAS);
        db.execSQL(CREATE_TABLE_RESULTADOS);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone
        db.execSQL("DROP TABLE IF EXISTS " + TablaEnunciados.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TablaRespuestas.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TablaResultados.TABLE);
        // Create tables again
        onCreate(db);

    }

}
