package ProyectoInstituto;

import ProyectoInstituto.controlador.ControladorAlumno;
import ProyectoInstituto.modeloBBDD.Alumno;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaAlumnosModel extends AbstractTableModel {

    //LA TABLA VA A TENER ESTAS COLUMNAS
    public final static int NOMBRE = 0;
    public final static int DIRECCION = 1;
    public final static int ESTADOMATRICULADO = 2;

    public final static String[] nombreColumnas = {"Nombre del alumnos", "Dirección", "Estado de la \n matrícula"};
    public List<Alumno> alumnos;
    //para que el jTable se surta de datos es equivalente a recyclerview
    //es una representación gráfica que están surtidos por una clase que es AbstracTableModel
    //por ellos hacemos una clase que extienda de AbstractTableModel
    //en el constructor se inicializa la lista de datos
     ControladorAlumno controlador = new ControladorAlumno();
    public TablaAlumnosModel() {
        alumnos = obtenerAlumnos();
    }

    private List<Alumno> obtenerAlumnos() {
        //así hago la conexión entre la base de datos y las vistas
        List<Alumno> lista = controlador.obtenerAlumnos();
        return  controlador.obtenerAlumnos();
    }
       /* List<Alumno> alumnos = new ArrayList<>();
        //introducimos de manera estáfica los alumnos a la lista ya que no están en ninguna base de datos
        Alumno alumno1 = new Alumno(1, "Juan", "Calle 1", "Confirmada");
        alumnos.add(alumno1);
        Alumno a2 = new Alumno(2, "María", "Calle 2", "Procesando");
        alumnos.add(a2);
        Alumno a3 = new Alumno(3, "Pedro", "Calle 3", "Confirmada");
        alumnos.add(a3);

        return alumnos;
    }*/

    //Halla el número de filas de la tabla
    @Override
    public int getRowCount() {
        return alumnos.size();
    }

    //Halla el número de columnas de la tabla
    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    //Me devuelve el objeto que se encuentra en la fila y columna especificada
    //en la celda especificada
    //metodo que pinta en cada celda de la tabla el valor correspondiente del alumno
    //este me pinta las celdas de la tabla
    @Override
    public Object getValueAt(int fila, int columna) {
        //primero hallo el elemento que se encuentra en la fila
        Alumno a = alumnos.get(fila); //esto me da la fila Pepe  Calle  Confirmada
        if (columna == NOMBRE) {
            return a.getNombre();
        } else if (columna == DIRECCION) {
            return a.getDireccion();
        } else if (columna == ESTADOMATRICULADO) {
            return a.getEstadoMatricula();
        }
        return null;
    }
    @Override
    public String getColumnName (int columna){
        return nombreColumnas[columna];
    }
}
