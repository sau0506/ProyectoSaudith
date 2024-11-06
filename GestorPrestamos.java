import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorPrestamos {
    private ArrayList<EstudianteIngenieria> vectorIngenieros = new ArrayList<>();
    private ArrayList<EstudianteDiseno> vectorDisenadores = new ArrayList<>();
    private ArrayList<ComputadorPortatil> vectorPortatil = new ArrayList<>();
    private ArrayList<TabletaGrafica> vectorTableta = new ArrayList<>();

    public void registrarPrestamoIngenieria() {

        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante de ingeniería:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del estudiante:");
        int numeroSemestre = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de semestre cursado:"));
        float promedioAcumulado = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el promedio acumulado:"));
        String serial = JOptionPane.showInputDialog("Ingrese el serial del computador portátil:");

        // Aquí asumimos que EstudianteIngenieria y ComputadorPortatil ya están
        // definidos correctamente
        EstudianteIngenieria estudiante = new EstudianteIngenieria(cedula, nombre, apellido, telefono, numeroSemestre,
                promedioAcumulado, serial);
        vectorIngenieros.add(estudiante);
        Exportar e= new Exportar();
        e.ExportarEstInge(vectorIngenieros);

        // Pide más información necesaria para el computador portátil
        String marca = JOptionPane.showInputDialog("Ingrese la marca del computador portátil:");
        float tamano = Float
                .parseFloat(JOptionPane.showInputDialog("Ingrese el tamaño del computador portátil en pulgadas:"));
        float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del computador portátil:"));
        ComputadorPortatil portatil = new ComputadorPortatil(serial, marca, tamano, precio, "", "");

        portatil.seleccionarSistemaOperativo();
        portatil.seleccionarProcesador();
        vectorPortatil.add(portatil);
        

        JOptionPane.showMessageDialog(null, "Préstamo para estudiante de ingeniería registrado exitosamente.");
    }

    public void registrarPrestamoDiseno() {
        Importar i = new Importar();
        vectorDisenadores = i.leerEstudianteDiseño();
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante de diseño:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del estudiante:");
        String modalidadEstudio = JOptionPane.showInputDialog("Ingrese la modalidad de estudio (Virtual/Presencial):");
        int cantidadAsignaturas = Integer
                .parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de asignaturas inscritas:"));
        String serial = JOptionPane.showInputDialog("Ingrese el serial de la tableta gráfica:");

        EstudianteDiseno estudiante = new EstudianteDiseno(cedula, nombre, apellido, telefono, modalidadEstudio,
                cantidadAsignaturas, serial);
        vectorDisenadores.add(estudiante);
        Exportar e = new Exportar();
        e.ExportarEstDiseño(vectorDisenadores);

        String marca = JOptionPane.showInputDialog("Ingrese la marca de la tableta gráfica:");
        float tamano = Float
                .parseFloat(JOptionPane.showInputDialog("Ingrese el tamaño de la tableta gráfica en pulgadas:"));
        float precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio de la tableta gráfica:"));
        TabletaGrafica tableta = new TabletaGrafica(serial, marca, tamano, precio, "", 0);

        tableta.seleccionarAlmacenamiento();
        vectorTableta.add(tableta);
        e.ExportarTabletaG(vectorTableta);

        JOptionPane.showMessageDialog(null, "Préstamo para estudiante de diseño registrado exitosamente.");
    }

    public void modificarPrestamoIngenieria() {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante para modificar el préstamo:");
        EstudianteIngenieria estudiante = buscarPrestamoPorCedulaIngenieria(cedula);

        if (estudiante != null) {
            String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono:");
            int nuevoSemestre = Integer
                    .parseInt(JOptionPane.showInputDialog("Ingrese el nuevo número de semestre cursado:"));
            float nuevoPromedio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo promedio acumulado:"));

            estudiante.setTelefono(nuevoTelefono);
            estudiante.setNumeroSemestre(nuevoSemestre);
            estudiante.setPromedioAcumulado(nuevoPromedio);

            JOptionPane.showMessageDialog(null, "Préstamo del estudiante de ingeniería modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un préstamo registrado para la cédula ingresada.");
        }
    }

    public void eliminarPrestamoIngenieria() {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante para eliminar el préstamo:");
        EstudianteIngenieria estudiante = buscarPrestamoPorCedulaIngenieria(cedula);

        if (estudiante != null) {
            vectorIngenieros.remove(estudiante);
            vectorPortatil.removeIf(portatil -> portatil.getSerial().equals(estudiante.getSerial()));
            JOptionPane.showMessageDialog(null, "Préstamo del estudiante eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un préstamo registrado para la cédula ingresada.");
        }
    }

    public void buscarPrestamoIngenieria() {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante para buscar el préstamo:");
        EstudianteIngenieria estudiante = buscarPrestamoPorCedulaIngenieria(cedula);

        if (estudiante != null) {
            JOptionPane.showMessageDialog(null, "Préstamo encontrado:\n" + estudiante.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un préstamo registrado para la cédula ingresada.");
        }
    }

    private EstudianteIngenieria buscarPrestamoPorCedulaIngenieria(String cedula) {
        for (EstudianteIngenieria estudiante : vectorIngenieros) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

    public void modificarPrestamoDiseno() {
        String cedula = JOptionPane
                .showInputDialog("Ingrese la cédula del estudiante de diseño para modificar el préstamo:");
        EstudianteDiseno estudiante = buscarPrestamoPorCedulaDiseno(cedula);

        if (estudiante != null) {
            String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono:");
            String nuevaModalidad = JOptionPane
                    .showInputDialog("Ingrese la nueva modalidad de estudio (Virtual/Presencial):");
            int nuevasAsignaturas = Integer
                    .parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de asignaturas:"));

            estudiante.setTelefono(nuevoTelefono);
            estudiante.setModalidadEstudio(nuevaModalidad);
            estudiante.setCantidadAsignaturas(nuevasAsignaturas);

            JOptionPane.showMessageDialog(null, "Préstamo del estudiante de diseño modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un préstamo registrado para la cédula ingresada.");
        }
    }

    public void eliminarPrestamoDiseno() {
        String cedula = JOptionPane
                .showInputDialog("Ingrese la cédula del estudiante de diseño para eliminar el préstamo:");
        EstudianteDiseno estudiante = buscarPrestamoPorCedulaDiseno(cedula);

        if (estudiante != null) {
            vectorDisenadores.remove(estudiante);
            vectorTableta.removeIf(tableta -> tableta.getSerial().equals(estudiante.getSerial()));
            JOptionPane.showMessageDialog(null, "Préstamo del estudiante de diseño eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un préstamo registrado para la cédula ingresada.");
        }
    }

    public void buscarPrestamoDiseno() {
        String cedula = JOptionPane
                .showInputDialog("Ingrese la cédula del estudiante de diseño para buscar el préstamo:");
        EstudianteDiseno estudiante = buscarPrestamoPorCedulaDiseno(cedula);

        if (estudiante != null) {
            JOptionPane.showMessageDialog(null, "Préstamo encontrado:\n" + estudiante.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un préstamo registrado para la cédula ingresada.");
        }
    }

    private EstudianteDiseno buscarPrestamoPorCedulaDiseno(String cedula) {
        for (EstudianteDiseno estudiante : vectorDisenadores) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }
        return null;
    }

    public void imprimirInventarioTotal() {
        StringBuilder inventario = new StringBuilder("Inventario de Préstamos:\n");

        inventario.append("\nEstudiantes de Ingeniería:\n");
        for (EstudianteIngenieria estudiante : vectorIngenieros) {
            inventario.append(estudiante.toString()).append("\n");
        }

        inventario.append("\nEstudiantes de Diseño:\n");
        for (EstudianteDiseno estudiante : vectorDisenadores) {
            inventario.append(estudiante.toString()).append("\n");
        }

        inventario.append("\nComputadores Portátiles:\n");
        for (ComputadorPortatil portatil : vectorPortatil) {
            inventario.append(portatil.toString()).append("\n");
        }

        inventario.append("\nTabletas Gráficas:\n");
        for (TabletaGrafica tableta : vectorTableta) {
            inventario.append(tableta.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, inventario.toString());
    }
}