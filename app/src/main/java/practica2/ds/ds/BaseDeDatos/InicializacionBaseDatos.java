package practica2.ds.ds.BaseDeDatos;

/**
 * Created by Pablo on 06/05/2015.
 */
public class InicializacionBaseDatos {

    public InicializacionBaseDatos(metodosTablas sr){

        if(sr.getAll().size()==0) {
            //añadimos los datos a la base de datos
            TablaEnunciados tabla = new TablaEnunciados();
            TablaRespuestas resp = new TablaRespuestas();
            TablaResultados resultados = new TablaResultados();
            //Pregunta 1
            int cont = 1;
            tabla.enunciado = "¿Cuántos años tenía Jonh Lennon en la primera aparición de los Beatles en el Show de Ed sullivan?";
            tabla.ruta = "";
            tabla.tipo = 0;
            tabla.categoria = "Cine";
            //respuesta 1
            resp.correcta = 0;
            resp.respuesta = "40";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "25";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "23";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "33";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 2
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿En qué año empezaron a televisarse las campanadas desde la plaza de la puerta del Sol?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Curiosidades";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "1962";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "1983";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "1912";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "1970";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);
            //PREGUNTA 3
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿A que planeta pertenece esta textura?";
            tabla.ruta = "pluton";
            tabla.tipo = 1;
            tabla.categoria = "Curiosidades";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "tierra";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "neptuno";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "marte";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "pluton";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 4
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿Quién es este actor?";
            tabla.ruta = "jm";
            tabla.tipo = 1;
            tabla.categoria = "Curiosidades";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "Jim Carrey";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Liam Neeson";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Tom Cruise";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Adam Sandler";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 5
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿A que corresponde este sonido?";
            tabla.ruta = "lluvia";
            tabla.tipo = 2;
            tabla.categoria = "Curiosidades";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Río";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "Lluvia";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Granizo";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Océano";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);


            //PREGUNTA 6
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿A que corresponde este sonido?";
            tabla.ruta = "oceano";
            tabla.tipo = 2;
            tabla.categoria = "Curiosidades";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "Océano";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Lluvia";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Granizo";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Río";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 7
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿Cuántos pisos tiene la Torre Bankia?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Curiosidades";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "250";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "45";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "60";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "85";
            resp.idPregunta = cont;
            resp.ruta = "null";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 8
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "El primer Portátil fue lanzado en 1981 ¿Cuántos kilos pesaba?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Curiosidades";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "11 KG";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "10.66 LG";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "8.54 KG";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "7.22 KG";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 9
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "En centímetros, ¿Cuánto mide la barba más larga de la que se tiene constancia?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Curiosidades";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "420.50";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "321.25";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "533.40";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "684.78";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 10
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿Cuántos de los 195 países del mundo tienen al menos un restaurante McDonald's?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Curiosidades";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "170";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "86";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "164";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "119";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 11
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿Cuántas personas aparecen en el cuadro Las Meninas de Velázquez?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Curiosidades";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "10";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "8";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "14";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "11";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 12
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿Cuántos caramelos PEZ caben en un dispensador PEZ?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Curiosidades";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "10";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "12";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "18";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "20";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 13
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "Sansón y Dalila, película de 1949 fue interpretada por:";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Cine";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "Hedy Lamarr y Victor Mature";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Greer Garson y Robert Taylor";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Gina Lollobrigida y Yul Brinner";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Angela Lansbury y José Ferrer";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 14
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "Gregory Peck interpretó a un abogado en Matar a un ruiseñor. ¿Cual era el nombre de su personaje?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Cine";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Martin Finch";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Stuart Finch";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Alois Finch";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "Atticus Finch";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 15
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿Que clase de pez es NEMO?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Cine";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "Pez Payaso";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Pez Globo";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Pez Rallado";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Pez Luna";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 16
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿Cuántas películas de men in black hay?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Cine";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "1";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "2";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "3";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "4";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 17
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿En que película Anakin Skywalker se va al lado oscuro?";
            tabla.ruta = "nada";
            tabla.tipo =0;
            tabla.categoria = "Cine";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Star Wars 2: la batalla de geonosis";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Futurama";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Star Wars 1";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "Star Wars 3";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 18
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿Cual de los siguientes jugador de basquet actuó en una película?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Cine";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "kobe bryant";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Lebron james";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "Emanuel Ginobillo";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "Michael Jordan";
            resp.idPregunta = cont;
            resp.ruta = "";
            resp.tipo = 0;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);

            //PREGUNTA 19
            cont++;
            tabla = new TablaEnunciados();
            tabla.enunciado = "¿Cual de los siguientes actores es Jim Carrey?";
            tabla.ruta = "no ruta";
            tabla.tipo = 0;
            tabla.categoria = "Cine";
            //respuesta 1
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "nada";
            resp.idPregunta = cont;
            resp.ruta = "liam";
            resp.tipo = 1;
            sr.insertarRespuesta(resp);
            //respuesta 2
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "nada";
            resp.idPregunta = cont;
            resp.ruta = "jm";
            resp.tipo = 1;
            sr.insertarRespuesta(resp);
            //respuesta 3
            resp = new TablaRespuestas();
            resp.correcta = 0;
            resp.respuesta = "nada";
            resp.idPregunta = cont;
            resp.ruta = "tom";
            resp.tipo = 1;
            sr.insertarRespuesta(resp);
            //respuesta 4
            resp = new TablaRespuestas();
            resp.correcta = 1;
            resp.respuesta = "nada";
            resp.idPregunta = cont;
            resp.ruta = "adam";
            resp.tipo = 1;
            sr.insertarRespuesta(resp);
            sr.insertarEnunciado(tabla);



        }
    }
}
