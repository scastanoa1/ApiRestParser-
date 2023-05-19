public class Controladora {
    private String tipo;
    private String cabecera;
    private String body;
    private final Methods method = new BD();
    private int id;

    private void procesarRequest(){
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


    }
    private void apiRest(String tipo, String cabecera, String body, int id){
        this.tipo = tipo;
        this.cabecera = cabecera;
        this.body = body;
        this.id = id;


    }
}


