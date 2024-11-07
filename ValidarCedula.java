import javax.swing.JOptionPane;
public class chat {

   

public void registrarPrestamoIngenieria() {
    String cedula;
    boolean esValida;

    // Solicitar la cédula y validarla hasta que solo contenga números
    do {
        cedula = JOptionPane.showInputDialog("Ingrese la cédula del estudiante de ingeniería:");
        esValida = cedula != null && cedula.matches("\\d+"); // Verifica que solo contenga dígitos
        
        if (!esValida) {
            JOptionPane.showMessageDialog(null, "Cédula no válida. Debe contener solo números.");
        }
    } while (!esValida);

    // Continuar solicitando otros datos una vez que la cédula sea válida
    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante:");
    String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del estudiante:");
    int numeroSemestre = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de semestre");
}
}
public class ValidarCedula {
    public static boolean esCedulaValida(String cedula) {
        // Verifica si la cédula solo contiene dígitos y tiene entre 7 y 10 caracteres
        return cedula.matches("\\d{7,10}");
    }

    public static void main(String[] args) {
        String cedula = "12345678";
        
        if (esCedulaValida(cedula)) {
            System.out.println("La cédula es válida.");
        } else {
            System.out.println("La cédula no es válida.");
        }
    }
}
