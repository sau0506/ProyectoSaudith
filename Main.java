import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        GestorPrestamos gestor= new GestorPrestamos();
        Main m= new Main();
        boolean bandera = true;
        while (bandera) {
            String menu = "1. ESTUDIANTES DE INGENIERIA.\n" +
                    "2. ESTUDIANTES DE DISEÑO.\n" +
                    "3. IMPRIMIR INVENTARIO TOTAL.\n" +
                    "4. SALIR DEL PROGRAMA.";
            try {
                int opt = Integer.parseInt(JOptionPane.showInputDialog("Que opción desea ingresar?:\n" + menu));
                switch (opt) {
                    case 1:
                       m.menuEstudiantesIngenieria(gestor);
                        break;
                    case 2:
                         m.menuEstudiantesDiseno(gestor);
                        break;
                    case 3:
                         gestor.imprimirInventarioTotal();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa.");
                        bandera = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ingrese una opción enumerada en el menú.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una opción válida.");
            }
        }
    }

    public void  menuEstudiantesIngenieria(GestorPrestamos gestor) {
        boolean bandera = true;
        while (bandera) {
            String menuIngenieria = "1.1 Registrar préstamo de equipo.\n" +
                    "1.2 Modificar préstamo de equipo.\n" +
                    "1.3 Devolución de equipo.\n" +
                    "1.4 Buscar equipo.\n" +
                    "1.5 Volver al menú principal.";
            try {
                int opt = Integer
                        .parseInt(JOptionPane.showInputDialog("Que opción desea ingresar?:\n" + menuIngenieria));

                switch (opt) {
                    case 1:
                         gestor.registrarPrestamoIngenieria();
                        break;
                    case 2:
                         gestor.modificarPrestamoIngenieria();
                        break;
                    case 3:
                         gestor.eliminarPrestamoIngenieria();
                        break;
                    case 4:
                         gestor.buscarPrestamoIngenieria();
                        break;
                    case 5:
                        // Volver al menú principal
                        JOptionPane.showMessageDialog(null, "Regresando al menú principal.");
                        bandera = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ingrese una opción enumerada en el menú.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una opción válida.");

            }

        }
    }

public void menuEstudiantesDiseno(GestorPrestamos gestor) {
    boolean bandera = true;
    while (bandera) {
        String menuDiseno = "2.1 Registrar préstamo de equipo.\n" +
                "2.2 Modificar préstamo de equipo.\n" +
                "2.3 Devolución de equipo.\n" +
                "2.4 Buscar equipo.\n" +
                "2.5 Volver al menú principal.";
        try {
            int opt = Integer.parseInt(JOptionPane.showInputDialog("Que opción desea ingresar?:\n" + menuDiseno));
            switch (opt) {
                case 1:
                     gestor.registrarPrestamoDiseno();
                    break;
                case 2:
                     gestor.modificarPrestamoDiseno();
                    break;
                case 3:
                     gestor.eliminarPrestamoDiseno();
                    break;
                case 4:
                     gestor.buscarPrestamoDiseno();
                    break;
                case 5:
                    // Volver al menú principal
                    JOptionPane.showMessageDialog(null, "Regresando al menú principal.");
                    bandera = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opción enumerada en el menú.");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese una opción válida.");

        }
    }
}
}
