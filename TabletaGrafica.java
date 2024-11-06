import javax.swing.JOptionPane;

public class TabletaGrafica {
    private String serial;
    private String marca;
    private float tamano;
    private float precio;
    private String almacenamiento;
    private float peso;

    public TabletaGrafica(String serial, String marca, float tamano, float precio, String almacenamiento, float peso) {
        this.serial = serial;
        this.marca = marca;
        this.tamano = tamano;
        this.precio = precio;
        this.almacenamiento = almacenamiento;
        this.peso = peso;
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
    public String getAlmacenamiento() {
        return almacenamiento;
    }
    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void seleccionarAlmacenamiento() {
        String[] opciones = {"256 GB", "512 GB", "1 TB"};
        int opcionSeleccionada;

        do {
            String opcionStr = JOptionPane.showInputDialog(
                "Seleccione el almacenamiento de la tableta:\n" +
                "1. 256 GB\n" +
                "2. 512 GB\n" +
                "3. 1 TB\n"
            );
            
            try {
                opcionSeleccionada = Integer.parseInt(opcionStr);
                
                if (opcionSeleccionada < 1 || opcionSeleccionada > 3) {
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    opcionSeleccionada = -1; // Valor fuera del rango válido para repetir el ciclo
                } else {
                    // Asignar el almacenamiento seleccionado
                    almacenamiento = opciones[opcionSeleccionada - 1];
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido. Intente de nuevo.");
                opcionSeleccionada = -1; // Valor fuera del rango válido para repetir el ciclo
            }
        } while (opcionSeleccionada < 1 || opcionSeleccionada > 3);

        JOptionPane.showMessageDialog(null, "Almacenamiento seleccionado: " + almacenamiento);
    }
}