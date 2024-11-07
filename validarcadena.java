public class validarcadena {
    public boolean esnumeroValido(String cedula) {
        // Verifica si la cédula solo contiene dígitos y tiene entre 7 y 10 caracteres
        return cedula.matches("\\d{7,10}");
}
public boolean escadenaValida(String nombre) {
    // Verifica que la cadena solo contenga letras (mayúsculas y minúsculas)
    return nombre.matches("^[a-zA-Z]+$");
}


}
