public class Controladora {
    private String tipo;
    private String cabecera;
    private String body;
    private final Methods method = new BD();
    private int id;
    private final BD bd = new BD();

    private void procesarRequest(String m){
        switch (method) {
            case "GET" -> {
                if (cabecera.equals("http://localhost:8080/apis/users")) {
                    GET();
                }
            }
            case "POST" -> {
                if (cabecera.equals("http://localhost:8080/apis/users")) {
                    POST(body);
                }
            }
            default -> System.out.println("Método no soportado");
        }
    }
    private void procesarRequest(String m, int id){
        switch (method) {
            case "GET" -> {
                if (cabecera.equals("http://localhost:8080/apis/users")) {
                    GETUser(id);
                }
            }
            case "POST" -> {
                if (cabecera.equals("http://localhost:8080/apis/users")) {
                    POST(body);
                }
            }
            case "PUT" -> {
                if (cabecera.equals("http://localhost:8080/apis/users")) {
                    PUT(body, id);
                }
            }
            case "DELETE" -> {
                if (cabecera.equals("http://localhost:8080/apis/users")) {
                    DELETE(id);
                }
            }
            default -> System.out.println("Método no soportado");
        }
    }
    private void apiRest(String tipo, String cabecera, String body){
        this.tipo = tipo;
        this.cabecera = cabecera;
        this.body = body;
        procesarRequest(body);
    }
    private void apiRest(String tipo, String cabecera, String body, int id){
        this.tipo = tipo;
        this.cabecera = cabecera;
        this.body = body;
        this.id = id;
    }

    public void GET(){
        bd.mostrarTodosUsuarios();
        System.out.println("GET");
    }
    public void GETUser(int id){
        bd.mostrarUsuario(id);
        System.out.println("GETUser");
    }
    public void POST(String body){
        bd.agregarUsuario(body);
        System.out.println("POST");
    }
    public void PUT(String body, int id){
        bd.actualizarUsuario(id, body);
        System.out.println("PUT");
    }
    public void DELETE(int id){
        bd.eliminarUsuario(id);
        System.out.println("DELETE");
    }
}


