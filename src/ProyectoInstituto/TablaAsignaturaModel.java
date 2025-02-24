package ProyectoInstituto;

import ProyectoInstituto.controlador.ControladorAsignatura;
import ProyectoInstituto.modeloBBDD.Asignatura;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaAsignaturaModel extends AbstractTableModel {

    public final static int NOMBREASIGNATURA= 0;
    public final static int CURSO= 1;

    public final static  String [] nombreColumnas = {"Nombre asignatura", "Curso"};

    ControladorAsignatura controladorAsignatura = new ControladorAsignatura();

    public List<Asignatura> asignaturas;
    public TablaAsignaturaModel () {asignaturas = obtenerAsignatura(); }

    private List<Asignatura> obtenerAsignatura(){

        List<Asignatura> lista = controladorAsignatura.obtenerAsignatura();
        return controladorAsignatura.obtenerAsignatura();
    }

    @Override
    public int getRowCount() {
        return asignaturas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Asignatura asi = asignaturas.get(fila);
        if(columna == NOMBREASIGNATURA){
            return asi.getNombreAsignatura();
        }else if (columna == CURSO){
            return asi.getCurso();
        }
        return null;
    }

    @Override
    public String getColumnName (int columna){
        return nombreColumnas[columna];
    }
}
