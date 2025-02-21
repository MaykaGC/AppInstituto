package ProyectoInstituto.controlador;

import ProyectoInstituto.modeloBBDD.Asignatura;
import ProyectoInstituto.modeloBBDD.InstitutoDAO;

public class ControladorAsignatura {


    public int insertarAsignatura(String nombreAsignatura, int curso) {
        //aquí construyo el objeto asignatura que voy a insertar en la BD
        Asignatura asig = new Asignatura(nombreAsignatura, curso);
        int resultado = InstitutoDAO.insertarAsignatura(nombreAsignatura, curso);
        return resultado;
    }

}