import javax.swing.JOptionPane;

public class ComputadorPortatil {
    private String serial;
    private String marca;
    private float tamano;
    private float precio;
    private String sistemaOperativo;
    private String procesador;

    public ComputadorPortatil(String serial, String marca, float tamano, float precio, String sistemaOperativo,
            String procesador) {
        this.serial = serial;
        this.marca = marca;
        this.tamano = tamano;
        this.precio = precio;
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
    }

    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public float getTamano() {
        return tamano;
    }
    public void setTamano(float tamano) {
        this.tamano = tamano;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
    public String getProcesador() {
        return procesador;
    }
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

   
    public void seleccionarSistemaOperativo() {
        String[] opciones = {"Windows 7", "Windows 10", "Windows 11"};
        int opcionSeleccionada;

        do {
            String opcionStr = JOptionPane.showInputDialog(
                "Seleccione el sistema operativo:\n" +
                "1. Windows 7\n" +
                "2. Windows 10\n" +
                "3. Windows 11\n"
            );

            try {
                opcionSeleccionada = Integer.parseInt(opcionStr);
                
                if (opcionSeleccionada < 1 || opcionSeleccionada > 3) {
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    opcionSeleccionada = -1; // Valor fuera del rango válido para repetir el ciclo
                } else {
                    // Asignar el sistema operativo seleccionado
                    sistemaOperativo = opciones[opcionSeleccionada - 1];
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido. Intente de nuevo.");
                opcionSeleccionada = -1; // Valor fuera del rango válido para repetir el ciclo
            }
        } while (opcionSeleccionada < 1 || opcionSeleccionada > 3);

        JOptionPane.showMessageDialog(null, "Sistema operativo seleccionado: " + sistemaOperativo);
    }

    // Método para seleccionar el procesador
    public void seleccionarProcesador() {
        String[] opciones = {"AMD Ryzen", "Intel® Core™ i5"};
        int opcionSeleccionada;

        do {
            String opcionStr = JOptionPane.showInputDialog(
                "Seleccione el procesador:\n" +
                "1. AMD Ryzen\n" +
                "2. Intel® Core™ i5\n"
            );

            try {
                opcionSeleccionada = Integer.parseInt(opcionStr);
                
                if (opcionSeleccionada < 1 || opcionSeleccionada > 2) {
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    opcionSeleccionada = -1; // Valor fuera del rango válido para repetir el ciclo
                } else {
                    // Asignar el procesador seleccionado
                    procesador = opciones[opcionSeleccionada - 1];
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido. Intente de nuevo.");
                opcionSeleccionada = -1; // Valor fuera del rango válido para repetir el ciclo
            }
        } while (opcionSeleccionada < 1 || opcionSeleccionada > 2);

        JOptionPane.showMessageDialog(null, "Procesador seleccionado: " + procesador);
    }
}
