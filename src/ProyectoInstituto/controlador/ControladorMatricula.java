package ProyectoInstituto.controlador;

import ProyectoInstituto.modeloBBDD.InstitutoDAO;
import ProyectoInstituto.modeloBBDD.Matricula;

public class ControladorMatricula {


    public int insertarMatricula(int idAsignatura, int idAlumno, double nota){

        Matricula matric = new Matricula(nota, idAsignatura, idAlumno,nota);
        int resultado = InstitutoDAO.insertarMatricula(idAsignatura, idAlumno, nota);
        return resultado;

    }
}



