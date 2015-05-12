package practica2.ds.ds.BaseDeDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

import practica2.ds.ds.Controlador.Enunciados.Enunciado;
import practica2.ds.ds.Controlador.Enunciados.EnunciadoTextoConImagen;
import practica2.ds.ds.Controlador.Enunciados.EnunciadoTextoConSonido;
import practica2.ds.ds.Controlador.Enunciados.EnunciadoTextoPlano;
import practica2.ds.ds.Controlador.Respuestas.Respuesta;
import practica2.ds.ds.Controlador.Respuestas.RespuestaImagen;
import practica2.ds.ds.Controlador.Respuestas.RespuestaSonido;
import practica2.ds.ds.Controlador.Respuestas.RespuestaTexto;

public class metodosTablas {
    private DBHelper dbHelper;

    public metodosTablas(Context context) {
        dbHelper = new DBHelper(context);
    }
//insertar una nueva fila a la tabla de enunciados
    public int insertarEnunciado(TablaEnunciados tablaEnunciados) {
        // TODO Auto-generated method stub

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TablaEnunciados.KEY_tipo, tablaEnunciados.tipo);
        values.put(TablaEnunciados.KEY_ruta, tablaEnunciados.ruta);
        values.put(TablaEnunciados.KEY_enunciado, tablaEnunciados.enunciado);
        values.put(TablaEnunciados.KEY_categoria, tablaEnunciados.categoria);

        // Inserting Row
        long student_Id = db.insert(TablaEnunciados.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) student_Id;
    }
    //Insertar una nueva fila en la tabla de respuestas
    public int insertarRespuesta(TablaRespuestas tablaRespuestas) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TablaRespuestas.KEY_tipo, tablaRespuestas.tipo);
        values.put(TablaRespuestas.KEY_ruta, tablaRespuestas.ruta);
        values.put(TablaRespuestas.KEY_respuesta, tablaRespuestas.respuesta);
        values.put(TablaRespuestas.KEY_correcta, tablaRespuestas.correcta);
        values.put(TablaRespuestas.KEY_idPregunta, tablaRespuestas.idPregunta);

        // Inserting Row
        long student_Id = db.insert(TablaRespuestas.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) student_Id;
    }
    public int insertarREsultado(TablaResultados tablaResultados){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TablaResultados.KEY_fecha, tablaResultados.fecha);
        values.put(TablaResultados.KEY_actividad, tablaResultados.actividad);
        values.put(TablaResultados.KEY_aciertos, tablaResultados.aciertos);
        values.put(TablaResultados.KEY_fallos, tablaResultados.fallos);

        long student_Id = db.insert(TablaResultados.TABLE, null, values);
        db.close();
        return (int) student_Id;
    }

    public void delete(int id_enunciado) {
        //int student_Id = getFirstStudent();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TablaEnunciados.TABLE, TablaEnunciados.KEY_ID + "=" + id_enunciado, null);
        db.close(); // Closing database connection
    }

    public void actualizarEnunciado(TablaEnunciados tablaEnunciados) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TablaEnunciados.KEY_tipo, tablaEnunciados.tipo);
        values.put(TablaEnunciados.KEY_ruta, tablaEnunciados.ruta);
        values.put(TablaEnunciados.KEY_enunciado, tablaEnunciados.enunciado);

        db.update(TablaEnunciados.TABLE, values, TablaEnunciados.KEY_ID + "=" + tablaEnunciados.id, null);
        db.close(); // Closing database connection
    }

    public ArrayList getAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                TablaEnunciados.KEY_ID + "," +
                TablaEnunciados.KEY_enunciado + "," +
                TablaEnunciados.KEY_ruta + "," +
                TablaEnunciados.KEY_tipo +
                " FROM " + TablaEnunciados.TABLE;

        ArrayList enunciados =new ArrayList();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                enunciados.add(cursor.getString(cursor.getColumnIndex(TablaEnunciados.KEY_ID)) + "_"
                        + cursor.getString(cursor.getColumnIndex(TablaEnunciados.KEY_enunciado)));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return enunciados;

    }

//recogemos un enunciado por su id
    public Enunciado getEnunciado(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                TablaEnunciados.KEY_ID + "," +
                TablaEnunciados.KEY_enunciado + "," +
                TablaEnunciados.KEY_ruta + "," +
                TablaEnunciados.KEY_tipo + "," +
                TablaEnunciados.KEY_categoria +
                " FROM " + TablaEnunciados.TABLE
                + " WHERE " +
                TablaEnunciados.KEY_ID + "=" + Id;


        int iCount =0;
        TablaEnunciados tablaEnunciados = new TablaEnunciados();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                tablaEnunciados.id =cursor.getInt(cursor.getColumnIndex(TablaEnunciados.KEY_ID));
                tablaEnunciados.enunciado =cursor.getString(cursor.getColumnIndex(TablaEnunciados.KEY_enunciado));
                tablaEnunciados.ruta  =cursor.getString(cursor.getColumnIndex(TablaEnunciados.KEY_ruta));
                tablaEnunciados.tipo =cursor.getInt(cursor.getColumnIndex(TablaEnunciados.KEY_tipo));
                tablaEnunciados.categoria =cursor.getString(cursor.getColumnIndex(TablaEnunciados.KEY_categoria));

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        Enunciado e;
        if(tablaEnunciados.tipo==0){
            e=new EnunciadoTextoPlano(tablaEnunciados.id,
                    tablaEnunciados.enunciado,
                    null,
                    tablaEnunciados.tipo,
                    tablaEnunciados.categoria);
        }else if(tablaEnunciados.tipo==1){
            e=new EnunciadoTextoConImagen(tablaEnunciados.id,
                    tablaEnunciados.enunciado,
                    tablaEnunciados.ruta,
                    tablaEnunciados.tipo,
                    tablaEnunciados.categoria);
        }
        else{
            e=new EnunciadoTextoConSonido(tablaEnunciados.id,
                    tablaEnunciados.enunciado,
                    tablaEnunciados.ruta,
                    tablaEnunciados.tipo,
                    tablaEnunciados.categoria);
        }

        return e;
    }
    //recogemos una respuesta por su id
    public Respuesta getRespuesta(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                TablaRespuestas.KEY_ID + "," +
                TablaRespuestas.KEY_respuesta + "," +
                TablaRespuestas.KEY_ruta + "," +
                TablaRespuestas.KEY_correcta + "," +
                TablaRespuestas.KEY_idPregunta + "," +
                TablaRespuestas.KEY_tipo +
                " FROM " + TablaRespuestas.TABLE
                + " WHERE " +
                TablaRespuestas.KEY_ID + "=" + id;


        int iCount =0;
        TablaRespuestas tablaRespuestas = new TablaRespuestas();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                tablaRespuestas.id =cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_ID));
                tablaRespuestas.respuesta =cursor.getString(cursor.getColumnIndex(TablaRespuestas.KEY_respuesta));
                tablaRespuestas.ruta  =cursor.getString(cursor.getColumnIndex(TablaRespuestas.KEY_ruta));
                tablaRespuestas.tipo =cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_tipo));
                tablaRespuestas.correcta =cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_correcta));
                tablaRespuestas.tipo =cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_idPregunta));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        Respuesta r;
        if(tablaRespuestas.tipo==0){
            r = new RespuestaTexto(tablaRespuestas.id,
                    tablaRespuestas.respuesta,
                    null,
                    tablaRespuestas.tipo,
                    tablaRespuestas.idPregunta,
                    tablaRespuestas.correcta);
        }else if(tablaRespuestas.tipo==1){
            r = new RespuestaImagen(tablaRespuestas.id,
                    tablaRespuestas.respuesta,
                    tablaRespuestas.ruta,
                    tablaRespuestas.tipo,
                    tablaRespuestas.idPregunta,
                    tablaRespuestas.correcta);
        }else{
            r = new RespuestaSonido(tablaRespuestas.id,
                    tablaRespuestas.respuesta,
                    tablaRespuestas.ruta,
                    tablaRespuestas.tipo,
                    tablaRespuestas.idPregunta,
                    tablaRespuestas.correcta);
        }
        return r;
    }
    //recogemos una respuesta por el id de su pregunta
    public ArrayList<Respuesta> getRespuestaPorIDEnunciado(int idpregunta){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                TablaRespuestas.KEY_ID + "," +
                TablaRespuestas.KEY_respuesta + "," +
                TablaRespuestas.KEY_ruta + "," +
                TablaRespuestas.KEY_correcta + "," +
                TablaRespuestas.KEY_idPregunta + "," +
                TablaRespuestas.KEY_tipo +
                " FROM " + TablaRespuestas.TABLE
                + " WHERE " +
                TablaRespuestas.KEY_idPregunta + "=" + idpregunta;


        int iCount =0;
        TablaRespuestas tablaRespuestas = new TablaRespuestas();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<Respuesta> r = new ArrayList<Respuesta>();
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                if(cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_tipo))==0) {
                    r.add(new RespuestaTexto(cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_ID)),
                            cursor.getString(cursor.getColumnIndex(TablaRespuestas.KEY_respuesta)),
                            cursor.getString(cursor.getColumnIndex(TablaRespuestas.KEY_ruta)),
                            cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_tipo)),
                            cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_idPregunta)),
                            cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_correcta))
                    ));
                }else if(cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_tipo))==1) {
                    r.add(new RespuestaImagen(cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_ID)),
                            cursor.getString(cursor.getColumnIndex(TablaRespuestas.KEY_respuesta)),
                            cursor.getString(cursor.getColumnIndex(TablaRespuestas.KEY_ruta)),
                            cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_tipo)),
                            cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_idPregunta)),
                            cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_correcta))
                    ));
                }
                else{
                    r.add(new RespuestaSonido(cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_ID)),
                            cursor.getString(cursor.getColumnIndex(TablaRespuestas.KEY_respuesta)),
                            cursor.getString(cursor.getColumnIndex(TablaRespuestas.KEY_ruta)),
                            cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_tipo)),
                            cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_idPregunta)),
                            cursor.getInt(cursor.getColumnIndex(TablaRespuestas.KEY_correcta))
                    ));
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();


        return r;
    }
    //eliminar toda la base de datos
    public void eliminarBaseDatos(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TablaEnunciados.TABLE,null,null);
       // db.delete(TablaRespuestas.TABLE,null,null);
    }
    public int getNumPreguntasCategoría(String categoria){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                TablaEnunciados.KEY_ID + "," +
                TablaEnunciados.KEY_enunciado + "," +
                TablaEnunciados.KEY_ruta + "," +
                TablaEnunciados.KEY_tipo + "," +
                TablaEnunciados.KEY_categoria +
                " FROM " + TablaEnunciados.TABLE
                + " WHERE " +
                TablaEnunciados.KEY_categoria + "=" + categoria;
        Cursor cursor = db.rawQuery(selectQuery, null);

        return cursor.getCount();
    }
    public ArrayList<TablaResultados> getResultado(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                TablaResultados.KEY_ID + "," +
                TablaResultados.KEY_fecha + "," +
                TablaResultados.KEY_actividad + "," +
                TablaResultados.KEY_aciertos + "," +
                TablaResultados.KEY_fallos +
                " FROM " + TablaResultados.TABLE;

        ArrayList<TablaResultados> resultados  =new ArrayList();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        TablaResultados aux = new TablaResultados();
        if (cursor.moveToFirst()) {
            do {
                aux.fecha =  cursor.getString(cursor.getColumnIndex(TablaResultados.KEY_fecha));
                aux.actividad =cursor.getString(cursor.getColumnIndex(TablaResultados.KEY_actividad));
                aux.aciertos = cursor.getInt(cursor.getColumnIndex(TablaResultados.KEY_aciertos));
                aux.fallos = cursor.getInt(cursor.getColumnIndex(TablaResultados.KEY_fallos));
                resultados.add(aux);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return resultados;

    }













}