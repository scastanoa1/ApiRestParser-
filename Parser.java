import java.util.regex.Pattern;

public class Parser {
    public static boolean revisarBody(String body){
        boolean temp = revisarUser(body)&&revisarPsw(body)&&revisarNombre(body);
        if(temp){
            return true;
        }
        return false;
    }
    public static boolean revisarTipo(String method){
        switch (method.toUpperCase()) {
            case "GET", "POST", "DELETE", "PUT" -> {
                return true;
            }
            default -> {
                System.out.println("Método inválido");
                return false;
            }
        }

    }
    public static boolean revisarURI(String URI) {
        boolean temp = (revisarEsquema(URI) && revisarHost(URI) && revisarPuerto(URI) && revisarRecurso(URI));
        if (temp) {
            if (BD.URI.equals(URI)){
                System.out.println("Conectandose con el servidor...");
                return true;
            }
            else{
                System.out.println("Esta URL no pudo ser encontrada");
                return false;

            }
        }
        return false;
    }
    public static boolean revisarHeaders(String header){
        if(revisarHeader(header)){
            if(header.equals(BD.HEADER)){
                return true;
            }
            else{
                System.out.println("El header brindado no coincide con el esperado");
                return false;
            }
        }
        return false;
    }
    public static boolean revisarEsquema(String esquema){

        if(Pattern.matches("^http://.*",esquema)){
            return true;
        }
        System.out.println("La URL no dispone de un esquema válido para la conexión");
        return false;
    }
    public static boolean revisarHost(String host){
        if(Pattern.matches(".*/[\\p{Lower}\\p{Upper}]{1,9}:.*",host)){
            return true;}
        System.out.println("La URL no cuenta con un host váido para la conexión");
        return false;
    }
    public static boolean revisarPuerto(String puerto){
        if(Pattern.matches(".*:\\d{4}/.*",puerto)){
            return true;
        }
        System.out.println("La URL no contiene un puerto válido");
        return false;
    }
    public static boolean revisarRecurso(String recurso){
        if(Pattern.matches(".*\\d/.+/.+$",recurso)){
            return true;
        }
        System.out.println("-La URL no dispone de un recurso válido para la conexión");
        return false;
    }
    public static boolean revisarHeader(String header){
        if(Pattern.matches(".*: [a-zA-Z]+/csv",header)){
            return true;
        }
        System.out.println("-El header no contiene un formato válido");
        return false;
    }
    public static boolean revisarUser(String user){
        if(Pattern.matches("^\\w+,.*",user))
            return true;
        System.out.println("-El usuario debe estar entre <Usuario><coma>");
        System.out.println("<Usuario>::=<A word character: [a-zA-Z_0-9]>");
        return false;
    }
    public static boolean revisarPsw(String psw){
        if(Pattern.matches(".+,(\\w|\\p{Punct})+.*",psw))
            return true;
        System.out.println("-La contraseña debe estar entre <Usuario>,<Contraseña>,");
        System.out.println("<Contraseña>::=<carácter>");
        return false;
    }
    public  static boolean revisarNombre(String nombre){
        if(Pattern.matches(".*,.*,(\\p{Lower}|\\p{Upper})+\s(\\p{Lower}|\\p{Upper})+",nombre))
            return true;
        System.out.println("-El nombre completo debe estar <NombreUsuario>,<Contraseña>,<Nombre><Espacio><Apellido>");
        System.out.println("<Nombre>&&<Apellido>::=<Letra>");
        return false;
    }
}
