import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorPrestamos {
    validarcadena vc = new validarcadena();
    private ArrayList<EstudianteIngenieria> vectorIngenieros = new ArrayList<>();
    private ArrayList<EstudianteDiseno> vectorDisenadores = new ArrayList<>();
    private ArrayList<ComputadorPortatil> vectorPortatil = new ArrayList<>();
    private ArrayList<TabletaGrafica> vectorTableta = new ArrayList<>();

    public void registrarPrestamoIngenieria() {
        String cedula, nombre, apellido, telefono, serial, marca;
        boolean esValida, esValido;
        int numeroSemestre = 0;
        float promedioAcumulado, tamano, precio;



        do {
            cedula = JOptionPane
                    .showInputDialog("Ingrese la cédula del estudiante de ingeniería.");
            esValido = vc.esnumeroValido(cedula);

            if (!esValido) {
                JOptionPane.showMessageDialog(null,
                        "Cédula no válida. Debe contener solo números y tener minímo 7 digitos, maximo 10.");
            }
        } while (!esValido);

        do {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            esValida = vc.escadenaValida(nombre);

            if (!esValida) {
                JOptionPane.showMessageDialog(null, "El nombre solo puede tener texto");
            }
        } while (!esValida);

        do {
            apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante:");
            esValida = vc.escadenaValida(apellido);

            if (!esValida) {
                JOptionPane.showMessageDialog(null, "El apellido solo puede tener texto");
            }
        } while (!esValida);

        do {
            telefono = JOptionPane.showInputDialog("Ingrese el teléfono del estudiante:");
            esValido = vc.esnumeroValido(telefono);

            if (!esValido) {
                JOptionPane.showMessageDialog(null, "Debe contener solo números y tener minímo 7 digitos, maximo 10");
            }
        } while (!esValido);

        do {
            try {
                numeroSemestre = Integer
                        .parseInt(JOptionPane.showInputDialog("Ingrese el número de semestre cursado:"));

                if (numeroSemestre <= 0 || numeroSemestre > 13) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un número en el rango semestral (1-13).");
                } else {
                    // Código para cuando el número es válido y positivo
                    JOptionPane.showMessageDialog(null, "Número de semestre ingresado: " + numeroSemestre);
                }

            } catch (NumberFormatException e) {
                // Si se ingresa algo que no es un número
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                numeroSemestre = -1; // Se asigna un valor inválido para repetir el ciclo
            }

        } while (numeroSemestre <= 0 || numeroSemestre > 13);

        do {
            try {
                promedioAcumulado = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el promedio acumulado:"));

                if (promedioAcumulado <= 0.0 || promedioAcumulado > 5.0) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un promedio valido.");
                } else {
                    // Código para cuando el número es válido y positivo
                    JOptionPane.showMessageDialog(null, "Promedio ingresado: " + promedioAcumulado);
                }

            } catch (NumberFormatException e) {
                // Si se ingresa algo que no es un número
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                promedioAcumulado = -1; // Se asigna un valor inválido para repetir el ciclo
            }

        } while (promedioAcumulado <= 0.0 || promedioAcumulado > 5.0);

        do {
            serial = JOptionPane.showInputDialog("Ingrese el serial del computador portátil:");
            esValido = serial.matches("\\d+");

            if (!esValido) {
                JOptionPane.showMessageDialog(null,
                        "Serial no válido. Debe contener solo números.");
            }
        } while (!esValido);

        // Aquí asumimos que EstudianteIngenieria y ComputadorPortatil ya están
        // definidos correctamente
        EstudianteIngenieria estudiante = new EstudianteIngenieria(cedula, nombre, apellido, telefono, numeroSemestre,
                promedioAcumulado, serial);
        vectorIngenieros.add(estudiante);
        Exportar ex = new Exportar();
        ex.ExportarEstInge(vectorIngenieros);

        // Pide más información necesaria para el computador portátil

        do {
            marca = JOptionPane.showInputDialog("Ingrese la marca del computador portátil:");
            esValida = vc.escadenaValida(marca);

            if (!esValida) {
                JOptionPane.showMessageDialog(null, "la marca solo puede tener texto");
            }
        } while (!esValida);

        do {
            try {
                tamano = Float.parseFloat(
                        JOptionPane.showInputDialog("Ingrese el tamaño del computador portátil en pulgadas:"));

                if (tamano <= 0.0) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un tamaño valido.");
                } else {
                    // Código para cuando el número es válido y positivo
                    JOptionPane.showMessageDialog(null, "Tamaño ingresado: " + tamano);
                }

            } catch (NumberFormatException e) {
                // Si se ingresa algo que no es un número
                JOptionPane.showMessageDialog(null, "Por favor ingrese un tamaño válido.");
                tamano = -1; // Se asigna un valor inválido para repetir el ciclo
            }

        } while (tamano <= 0.0);
        
        do {
            try {
                precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del computador portátil:"));

                if (precio <= 0.0) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un precio valido.");
                } else {
                    // Código para cuando el número es válido y positivo
                    JOptionPane.showMessageDialog(null, "precio ingresado: " + precio);
                }

            } catch (NumberFormatException e) {
                // Si se ingresa algo que no es un número
                JOptionPane.showMessageDialog(null, "Por favor ingrese un precio válido.");
                precio = -1; // Se asigna un valor inválido para repetir el ciclo
            }

        } while (precio <= 0.0);

        ComputadorPortatil portatil = new ComputadorPortatil(serial, marca, tamano, precio, "", "");

        portatil.seleccionarSistemaOperativo();
        portatil.seleccionarProcesador();
        vectorPortatil.add(portatil);
        ex.ExportarComputador(vectorPortatil);

        JOptionPane.showMessageDialog(null, "Préstamo para estudiante de ingeniería registrado exitosamente.");
    }

    public void registrarPrestamoDiseno() {
        String cedula, nombre, apellido, telefono, serial, modalidadEstudio, marca;
        boolean esValida, esValido;
        int cantidadAsignaturas = 0;
        float  tamano, precio;

      
       

        do {
            cedula = JOptionPane
                    .showInputDialog("Ingrese la cédula del estudiante de diseño.");
            esValido = vc.esnumeroValido(cedula);

            if (!esValido) {
                JOptionPane.showMessageDialog(null,
                        "Cédula no válida. Debe contener solo números y tener minímo 7 digitos, maximo 10.");
            }
        } while (!esValido);

        do {
            nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            esValida = vc.escadenaValida(nombre);

            if (!esValida) {
                JOptionPane.showMessageDialog(null, "El nombre solo puede tener texto");
            }
        } while (!esValida);

        do {
            apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante:");
            esValida = vc.escadenaValida(apellido);

            if (!esValida) {
                JOptionPane.showMessageDialog(null, "El apellido solo puede tener texto");
            }
        } while (!esValida);
        do {
            telefono = JOptionPane.showInputDialog("Ingrese el teléfono del estudiante:");
            esValido = vc.esnumeroValido(telefono);

            if (!esValido) {
                JOptionPane.showMessageDialog(null, "Debe contener solo números y tener minímo 7 digitos, maximo 10");
            }
        } while (!esValido);

        do {
            modalidadEstudio = JOptionPane.showInputDialog("Ingrese la modalidad de estudio (Virtual/Presencial):");
            esValida = vc.escadenaValida(modalidadEstudio);

            if (!esValida) {
                JOptionPane.showMessageDialog(null, "La modalidad solo puede tener texto");
            }
        } while (!esValida);
        do {
            try {
                cantidadAsignaturas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de asignaturas inscritas:"));
                if (cantidadAsignaturas <= 0) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad valida");
                } else {
                    // Código para cuando el número es válido y positivo
                    JOptionPane.showMessageDialog(null, "Número de asignaturas ingresado: " + cantidadAsignaturas);
                }

            } catch (NumberFormatException e) {
                // Si se ingresa algo que no es un número
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                cantidadAsignaturas = -1; // Se asigna un valor inválido para repetir el ciclo
            }

        } while (cantidadAsignaturas <= 0);

        do {
            serial = JOptionPane.showInputDialog("Ingrese el serial de la tableta grafica:");
            esValido = serial.matches("\\d+");

            if (!esValido) {
                JOptionPane.showMessageDialog(null,
                        "Serial no válido. Debe contener solo números.");
            }
        } while (!esValido);

        EstudianteDiseno estudiante = new EstudianteDiseno(cedula, nombre, apellido, telefono, modalidadEstudio,
                cantidadAsignaturas, serial);
        vectorDisenadores.add(estudiante);
        Exportar ex = new Exportar();
        ex.ExportarEstDiseño(vectorDisenadores);

        do {
            marca = JOptionPane.showInputDialog("Ingrese la marca de la tableta gráfica:");
            esValida = vc.escadenaValida(marca);

            if (!esValida) {
                JOptionPane.showMessageDialog(null, "la marca solo puede tener texto");
            }
        } while (!esValida);

        do {
            try {
                tamano = Float.parseFloat(
                        JOptionPane.showInputDialog("Ingrese el tamaño del computador portátil en pulgadas:"));

                if (tamano <= 0.0) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un tamaño valido.");
                } else {
                    // Código para cuando el número es válido y positivo
                    JOptionPane.showMessageDialog(null, "Tamaño ingresado: " + tamano);
                }

            } catch (NumberFormatException e) {
                // Si se ingresa algo que no es un número
                JOptionPane.showMessageDialog(null, "Por favor ingrese un tamaño válido.");
                tamano = -1; // Se asigna un valor inválido para repetir el ciclo
            }

        } while (tamano <= 0.0);
        do {
            try {
                precio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio del computador portátil:"));

                if (precio <= 0.0) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un precio valido.");
                } else {
                    // Código para cuando el número es válido y positivo
                    JOptionPane.showMessageDialog(null, "precio ingresado: " + precio);
                }

            } catch (NumberFormatException e) {
                // Si se ingresa algo que no es un número
                JOptionPane.showMessageDialog(null, "Por favor ingrese un precio válido.");
                precio = -1; // Se asigna un valor inválido para repetir el ciclo
            }

        } while (precio <= 0.0);
       

       
        TabletaGrafica tableta = new TabletaGrafica(serial, marca, tamano, precio, "", 0);

        tableta.seleccionarAlmacenamiento();
        vectorTableta.add(tableta);
        ex.ExportarTabletaG(vectorTableta);

        JOptionPane.showMessageDialog(null, "Préstamo para estudiante de diseño registrado exitosamente.");
    }

    public void modificarPrestamoIngenieria() {
        String cedula, nuevoTelefono;
        int nuevoSemestre;
        float nuevoPromedio;
        boolean esValido;
        do {
            cedula = JOptionPane
                    .showInputDialog("Ingrese la cédula del estudiante de diseño");
            esValido = vc.esnumeroValido(cedula);

            if (!esValido) {
                JOptionPane.showMessageDialog(null,
                        "Cédula no válida. Debe contener solo números y tener minímo 7 digitos, maximo 10.");
            }
        } while (!esValido);
        
        EstudianteIngenieria estudiante = buscarPrestamoPorCedulaIngenieria(cedula);

        if (estudiante != null) {
            
            do {
                nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono:");
                esValido = vc.esnumeroValido(nuevoTelefono);
            
                if (!esValido) {
                    JOptionPane.showMessageDialog(null,
                            "telefono no válido. Debe contener solo números y tener minímo 5 digitos, maximo 10.");
                }
            } while (!esValido);
             do {
                try {
                    nuevoSemestre = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo número de semestre cursado:"));
            
                    if (nuevoSemestre <= 0 || nuevoSemestre>13) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un número en el rango semestral (1-13).");
                    } else {
                        // Código para cuando el número es válido y positivo
                        JOptionPane.showMessageDialog(null, "numero de semestre ingresado: " + nuevoSemestre);
                    }
            
                } catch (NumberFormatException e) {
                    // Si se ingresa algo que no es un número
                    JOptionPane.showMessageDialog(null, "Por favor ingrese solo numeros.");
                    nuevoSemestre= -1; // Se asigna un valor inválido para repetir el ciclo
                }
            
            } while (nuevoSemestre <= 0 || nuevoSemestre>13);
            
            do {
                try {
                    nuevoPromedio = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo promedio acumulado:"));
            
                    if (nuevoPromedio <= 0.0 || nuevoPromedio> 5.0) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un promedio valido.");
                    } else {
                        // Código para cuando el número es válido y positivo
                        JOptionPane.showMessageDialog(null, "promedio ingresado: " + nuevoPromedio);
                    }
            
                } catch (NumberFormatException e) {
                    // Si se ingresa algo que no es un número
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un promedio válido.");
                    nuevoPromedio = -1; // Se asigna un valor inválido para repetir el ciclo
                }
            
            } while (nuevoPromedio <= 0.0 || nuevoPromedio> 5.0);

            estudiante.setTelefono(nuevoTelefono);
            estudiante.setNumeroSemestre(nuevoSemestre);
            estudiante.setPromedioAcumulado(nuevoPromedio);
            Exportar ex = new Exportar();
        ex.ExportarEstInge(vectorIngenieros);
            ex.ExportarComputador(vectorPortatil);

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
        String cedula;
        boolean esValido;
        do {
            cedula = JOptionPane
                    .showInputDialog("Ingrese la cédula del estudiante de diseño ");
            esValido = vc.esnumeroValido(cedula);
        
            if (!esValido) {
                JOptionPane.showMessageDialog(null,
                        "Cédula no válida. Debe contener solo números y tener minímo 7 digitos, maximo 10.");
            }
        } while (!esValido);
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
        String cedula, nuevoTelefono,nuevaModalidad;
        boolean esValido, esValida;
        int nuevasAsignaturas;
        do {
            cedula = JOptionPane
                    .showInputDialog("Ingrese la cédula del estudiante de diseño ");
            esValido = vc.esnumeroValido(cedula);
        
            if (!esValido) {
                JOptionPane.showMessageDialog(null,
                        "Cédula no válida. Debe contener solo números y tener minímo 7 digitos, maximo 10.");
            }
        } while (!esValido);
        EstudianteDiseno estudiante = buscarPrestamoPorCedulaDiseno(cedula);


        if (estudiante != null) {
           
            do {
                nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono:");
                esValido = vc.esnumeroValido(nuevoTelefono);
            
                if (!esValido) {
                    JOptionPane.showMessageDialog(null,
                            "Telefono no válido. Debe contener solo números y tener minímo 7 digitos, maximo 10.");
                }
            } while (!esValido);
           
            do {
                nuevaModalidad = JOptionPane.showInputDialog("Ingrese la nueva modalidad de estudio (Virtual/Presencial):");
                esValida = vc.escadenaValida(nuevaModalidad);
            
                if (!esValida) {
                    JOptionPane.showMessageDialog(null, "La modalidad solo puede tener texto");
                }
            } while (!esValida);
             
             do {
                try {
                    nuevasAsignaturas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de asignaturas:"));
            
                    if (nuevasAsignaturas <= 0) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad valida.");
                    } else {
                        // Código para cuando el número es válido y positivo
                        JOptionPane.showMessageDialog(null, "precio ingresado: " +nuevasAsignaturas);
                    }
            
                } catch (NumberFormatException e) {
                    // Si se ingresa algo que no es un número
                    JOptionPane.showMessageDialog(null, "Por favor ingrese una cantidad valida.");
                    nuevasAsignaturas = -1; // Se asigna un valor inválido para repetir el ciclo
                }
            
            } while (nuevasAsignaturas <= 0);

            estudiante.setTelefono(nuevoTelefono);
            estudiante.setModalidadEstudio(nuevaModalidad);
            estudiante.setCantidadAsignaturas(nuevasAsignaturas);
            Exportar ex = new Exportar();
            ex.ExportarEstDiseño(vectorDisenadores);
            ex.ExportarTabletaG(vectorTableta);
            JOptionPane.showMessageDialog(null, "Préstamo del estudiante de diseño modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un préstamo registrado para la cédula ingresada.");
        }
    }

    public void eliminarPrestamoDiseno() {
        String cedula;
        boolean esValido;
        do {
            cedula = JOptionPane
                    .showInputDialog("Ingrese la cédula del estudiante de diseño ");
            esValido = vc.esnumeroValido(cedula);
        
            if (!esValido) {
                JOptionPane.showMessageDialog(null,
                        "Cédula no válida. Debe contener solo números y tener minímo 7 digitos, maximo 10.");
            }
        } while (!esValido);
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
        String cedula;
        boolean esValido;
        do {
            cedula = JOptionPane
                    .showInputDialog("Ingrese la cédula del estudiante de diseño");
            esValido = vc.esnumeroValido(cedula);
        
            if (!esValido) {
                JOptionPane.showMessageDialog(null,
                        "Cédula no válida. Debe contener solo números y tener minímo 7 digitos, maximo 10.");
            }
        } while (!esValido);
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