import java.util.Scanner;

public class Controladora {
    static Scanner scan = new Scanner(System.in);
    private String tipo;
    private String cabecera;
    private String body;
    private final Methods bd = new BD();
    private int id;

    public Controladora(String tipo, String cabecera, String body, int id) {
        if(Parser.revisarTipo(tipo)&&Parser.revisarHeaders(cabecera)){
            apiRest(tipo,cabecera,body,id);
            procesarRequest(id);
        }
        else{
            System.out.println("Error método o header no encontrado");
        }
    }
    public Controladora(String tipo, String cabecera, String body) {
        if(Parser.revisarTipo(tipo)&&Parser.revisarHeaders(cabecera)){
            apiRest(tipo,cabecera,body);
            procesarRequest();
        }
        else{
            System.out.println("Error método o header no encontrado");
        }
    }

    private  void procesarRequest(){
        switch (tipo.toUpperCase()){
            case"GET":
                bd.mostrarTodosUsuarios();
                break;
            case"POST":{
                bd.agregarUsuario(body);
                break;
                }
        }

    }
    private void procesarRequest(int id){
        switch (tipo.toUpperCase()){
            case"GET":
                bd.mostrarUsuario(id);
                break;
            case"PUT":{
                bd.actualizarUsuario(id,body);
                break;
            }
            case"DELETE":{
                bd.eliminarUsuario(id);
                break;
            }
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void Menu(){
        part1();
        String procesando ="";
        while(!procesando.equals("6")){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("-Menu de opciones");
            System.out.println("1. Leer usuarios existentes.");
            System.out.println("2. Encontrar usuario existente.");
            System.out.println("3. Crear un usuario.");
            System.out.println("4. Editar un usuario existente.");
            System.out.println("5. Eliminar un usuario.");
            System.out.println("6. Salir.");
            System.out.print("-> ");
            procesando = scan.next();
            switch (procesando){
                case"1":
                    GET();
                    break;
                case"2":
                    System.out.print("Ingrese el id del usuario: ");
                    GET(scan.nextInt());
                    break;
                case"3":
                    POST();
                    break;
                case"4":
                    System.out.print("Ingrese el id del usuario: ");
                    PUT(scan.nextInt());
                    break;
                case"5":
                    System.out.print("Ingrese el id del usuario: ");
                    DELETE(scan.nextInt());
                    break;

                case"6":
                    System.out.println("Finalizando el programa");
                    System.exit(0);
                default:
                    System.out.println("Opción no encontrada");
                    break;
            }

        }
    }
    public static void GET(){
        new Controladora("GET","Content-Type: app/csv","");
    }
    public static void GET(int id){
        new Controladora("GET","Content-Type: app/csv","",id);
    }
    public static void POST(){
        String bodi;
        System.out.println("+Ingrese el cuerpo de solicitud en formato csv");
        System.out.println("+De forma que <NombreUsuario>,<Contraseña>,<Nombre><Espacio><Apellido>");
            bodi = scan.nextLine();
        while(!Parser.revisarBody(bodi)){
            System.out.println("--> ");
            bodi = scan.nextLine();
        }
        new Controladora("POST","Content-Type: app/csv",bodi);
    }
    public static void PUT(int id){
        String bodi;
        System.out.println("+Ingrese el cuerpo de solicitud en formato csv");
        System.out.println("+De forma que <NombreUsuario>,<Contraseña>,<Nombre><Espacio><Apellido>");
        bodi = scan.nextLine();
        while(!Parser.revisarBody(bodi)){
            System.out.println("--> ");
            bodi = scan.nextLine();
        }
        new Controladora("PUT","Content-Type: app/csv",bodi,id);
    }
    public static void DELETE(int id){
        new Controladora("DELETE","Content-Type: app/csv","",id);
    }

    public static void part1(){
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("Ingrese una URL para concectarse: ");
        } while (!Parser.revisarURI(scan.nextLine()));
    }


}


