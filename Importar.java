import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.omg.CORBA.FloatSeqHolder;

public class Importar {
    public ArrayList<EstudianteDiseno> leerEstudianteDiseño() {
        String rutaArchivo = "EstDiseño.txt";
        ArrayList<EstudianteDiseno> listaDiseño = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            EstudianteDiseno obj = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Cedula: ")) {
                    if (obj != null) {
                        listaDiseño.add(obj);
                    }
                    obj = new EstudianteDiseno();
                    obj.setCedula(line.substring(8));
                } else if (line.startsWith("nombre: ")) {
                    if (obj != null) {
                        obj.setNombre(line.substring(8));
                    }
                } else if (line.startsWith("apellido: ")) {
                    if (obj != null) {
                        obj.setApellido(line.substring(10));
                    }
                } else if (line.startsWith("telefono: ")) {
                    if (obj != null) {
                        obj.setTelefono(line.substring(10));
                    }
                } else if (line.startsWith("modalidadEstudio: ")) {
                    if (obj != null) {
                        obj.setModalidadEstudio(line.substring(18));
                    }
                } else if (line.startsWith("cantidadAsignaturas: ")) {
                    if (obj != null) {
                        obj.setCantidadAsignaturas(Integer.parseInt(line.substring(21)));
                    }
                } else if (line.startsWith("serial: ")) {
                    if (obj != null) {
                        obj.setSerial(line.substring(10));
                        listaDiseño.add(obj);
                        obj = null; // Reiniciar para el siguiente producto
                    }
                }
            }

            System.out.println("Archivo importado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaDiseño;
    }

    public ArrayList<EstudianteIngenieria> leerEstudianteInge() {
        String rutaArchivo = "EstInge.txt";
        ArrayList<EstudianteIngenieria> listaInge = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            EstudianteIngenieria obj = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Cedula: ")) {
                    if (obj != null) {
                        listaInge.add(obj);
                    }
                    obj = new EstudianteIngenieria();
                    obj.setCedula(line.substring(8));
                } else if (line.startsWith("nombre: ")) {
                    if (obj != null) {
                        obj.setNombre(line.substring(8));
                    }
                } else if (line.startsWith("apellido: ")) {
                    if (obj != null) {
                        obj.setApellido(line.substring(10));
                    }
                } else if (line.startsWith("telefono: ")) {
                    if (obj != null) {
                        obj.setTelefono(line.substring(10));
                    }
                } else if (line.startsWith("semestre: ")) {
                    if (obj != null) {
                        obj.setNumeroSemestre(Integer.parseInt(line.substring(9)));
                    }
                } else if (line.startsWith("Promedio: ")) {
                    if (obj != null) {
                        obj.setPromedioAcumulado(Float.parseFloat(line.substring(10)));
                    }
                } else if (line.startsWith("serial: ")) {
                    if (obj != null) {
                        obj.setSerial(line.substring(10));
                        listaInge.add(obj);
                        obj = null; // Reiniciar para el siguiente producto
                    }
                }
            }

            System.out.println("Archivo importado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaInge;
    }
    public ArrayList<TabletaGrafica> leerTabletaGrafica() {
        String rutaArchivo = "TabletaGrafica.txt";
        ArrayList<TabletaGrafica> listaTableta = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            TabletaGrafica obj = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Cedula: ")) {
                    if (obj != null) {
                        listaTableta.add(obj);
                    }
                    obj = new TabletaGrafica();
                } else if (line.startsWith("marca: ")) {
                    if (obj != null) {
                        obj.setMarca(line.substring(7));
                    }
                } else if (line.startsWith("peso: ")) {
                    if (obj != null) {
                        obj.setPeso(Float.parseFloat(line.substring(6)));
                    }
                } else if (line.startsWith("precio: ")) {
                    if (obj != null) {
                        obj.setPrecio(Float.parseFloat(line.substring(8)));
                    }
                } else if (line.startsWith("tamaño: ")) {
                    if (obj != null) {
                        obj.setTamano(Float.parseFloat(line.substring(8)));
                    }
                } else if (line.startsWith("almacenamiento: ")) {
                    if (obj != null) {
                        obj.setAlmacenamiento(line.substring(16));
                    }
                } else if (line.startsWith("serial: ")) {
                    if (obj != null) {
                        obj.setSerial(line.substring(8));
                        listaTableta.add(obj);
                        obj = null; // Reiniciar para el siguiente producto
                    }
                }
            }

            System.out.println("Archivo importado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaTableta;
    }

   
    }
