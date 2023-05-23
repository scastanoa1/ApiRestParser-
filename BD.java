import java.util.ArrayList;


public class BD implements Methods{
    static ArrayList<ArrayList<String>> bd  = new ArrayList<>();
   /* public BD() {
        User u1 = new User("magdc", "CastaBaby@", "Miguel Gomez");
        User u2 = new User("michim", "botero69", "Michim Botero");
        User u3 = new User("j?sierra11", "done31", "Juanda Siera");
        agregarUsuario(u1);agregarUsuario(u2);agregarUsuario(u3);
    }*/

    final static String URI = "http://localhost:8080/api_rest/requests";
    final static String HEADER = "Content-Type: app/csv";


    public void agregarUsuario(String body){
        String[] spliter = body.split(",");
        ArrayList<String> temp = new ArrayList<>();
        try {
            User user = new User(spliter[0], spliter[1], spliter[2]);
            temp.add(Integer.toString(user.getId()));
            temp.add(user.getUser());
            temp.add(user.getPassword());
            temp.add(user.getFullName());
            bd.add(temp);
        }
        catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Error al agregar usuario");
    }
    }
    public void eliminarUsuario(int id){
        for (int i = 0; i < bd.size(); i++) {
            if (bd.get(i).get(0).equals(Integer.toString(id))){
                bd.remove(i);
                break;
            }
        }
    }

    public void actualizarUsuario(int id, String body){
        String[] temp = body.split(",");
        for (int i = 0; i < bd.size(); i++) {
            if (bd.get(i).get(0).equals(Integer.toString(id))){
                bd.get(i).set(1, temp[0]);
                bd.get(i).set(2, temp[1]);
                bd.get(i).set(3, temp[2]);
            }
        }
    }
    public void mostrarUsuario(int id){

        for (int i = 0; i < bd.size(); i++) {
            if(bd.get(i).get(0).equals(Integer.toString(id))){
                System.out.println("Id |  User  |  Psw     |     Nombre");
                String usuario = bd.get(i).get(1);
                String psw = bd.get(i).get(2);
                String nombre = bd.get(i).get(3);
                System.out.println(id+"  |  "+usuario+"  | "+psw+"  | "+nombre);
                break;
            }
        }
    }

    public void mostrarTodosUsuarios(){
        System.out.println("Id |  User  |  Psw     |     Nombre");
        for (int i = 0; i < bd.size(); i++) {
                String id = bd.get(i).get(0);
                String usuario = bd.get(i).get(1);
                String psw = bd.get(i).get(2);
                String nombre = bd.get(i).get(3);
                System.out.println(id+"  |  "+usuario+"  | "+psw+"  | "+nombre);
        }

    }
}
