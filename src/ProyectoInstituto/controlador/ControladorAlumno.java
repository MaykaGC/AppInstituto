package ProyectoInstituto.controlador;


import ProyectoInstituto.modeloBBDD.Alumno;
import ProyectoInstituto.modeloBBDD.Asignatura;
import ProyectoInstituto.modeloBBDD.InstitutoDAO;

import java.util.List;

public class ControladorAlumno {

//Esta clase hace la conexión entre la capa de modelo y las clases de vista,
//Para ello va a definir métodos que van a ser invocados desde las vistas
//para insertar en la base de datos
//y también va a definir métodos que van a devolver datos hacia las vistas
//desde las capas inferiores o base de datos.

    public ControladorAlumno(){

    }

    //primer metodo:hallar alumnos de la base datos
    //tengo que llamar al metodo selectAlumnos del DAO
    public List<Alumno> obtenerAlumnos(){
        List<Alumno> lista =  InstitutoDAO.selectAlumnos();
        return lista;
    }


    public int insertarAlumno(String nombre, String direccion, String estadoMatricula) {
        //aquí contruyo el objeto alumno que voy a insertar en la BD
        Alumno alum = new Alumno(nombre, direccion, estadoMatricula);
         int resultado = InstitutoDAO.ingresarAlumno(alum);
         return resultado;
    }



}
