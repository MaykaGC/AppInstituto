package ProyectoInstituto.controlador;

import ProyectoInstituto.modeloBBDD.Alumno;
import ProyectoInstituto.modeloBBDD.Asignatura;
import ProyectoInstituto.modeloBBDD.InstitutoDAO;

import java.util.List;

public class ControladorAsignatura {


    public List<Asignatura> obtenerAsignatura() {
        List<Asignatura> lista = InstitutoDAO.selectAsignatura();
        return lista;

    }

    public int insertarAsignatura(String nombreAsignatura, String curso) {
        //aquí construyo el objeto asignatura que voy a insertar en la BD
        Asignatura asig = new Asignatura(nombreAsignatura, curso);
        int resultado = InstitutoDAO.insertarAsignatura(asig);
        return resultado;
    }

}


