package org.example.validaciones;

import org.example.modelos.Local;
import org.example.utilidades.Mensaje;
import org.example.utilidades.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class OfertaValidacion {
    //metodos ordinarios

    private Util util = new Util();
    public Boolean validarTitulo(String titulo)throws Exception{
        if (util.buscarCoincidencia(titulo,"^[a-zA-Z]+$")){
            throw new Exception(Mensaje.FORMATO_OFERTA.getMensaje());
        }
        if (titulo.length()>20){
            throw new Exception(Mensaje.LONGITUD_TITULO.getMensaje());
        }return true;

    }
    public Boolean validarFormatoFecha(String fecha)throws Exception{
        if (util.buscarCoincidencia(fecha,"^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-({4})$")){
            throw new Exception(Mensaje.FORMATO_FECHA.getMensaje());
        }return true;
    }

    public Boolean validarFechas(String fechaInicio, String fechaFin)throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-({4})$");
        try {
            Date inicio = dateFormat.parse(fechaInicio);
            Date fin = dateFormat.parse(fechaFin);
            if (inicio.toInstant().isBefore(fin.toInstant())){
                return true;

            }else {
                return false;
            }
        }catch (ParseException e){
            return false;
        }



    }
    public Boolean costoPersona(String costo)throws Exception{
        if (util.buscarCoincidencia(costo,"^(?!-)\\d+$\n")){
            throw new Exception(Mensaje.COSTO_PERSONA.getMensaje());
        }return true;
    }




}
