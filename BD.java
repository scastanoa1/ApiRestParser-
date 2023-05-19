import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BD implements Methods{
//    User u1 = new User("magdc","CastaBaby@","Miguel Gomez");
//    User u2 = new User("michim","botero69","Michim Botero");
//    User u3 = new User("j?sierra11","done31","Juanda Siera");
//    ArrayList<User> pabloP = new ArrayList<>();
//
//        pabloP.add(u1);
//        pabloP.add(u2);
//        pabloP.add(u3); bd
    ArrayList<ArrayList<String>> bd = new ArrayList<>();

    public void agregarUsuario(User user){
        ArrayList<String> temp = new ArrayList<>();
        temp.add(Integer.toString(user.getId()));
        temp.add(user.getUser());
        temp.add(user.getPassword());
        temp.add(user.getFullName());
        bd.add(temp);
    }
    public void eliminarUsuario(int id){
        for (int i = 0; i < bd.size(); i++) {
            if (bd.get(i).get(0).equals(Integer.toString(id))){
                bd.remove(i);
            }
        }
    }

    public void actualizarUsuario(int id, User user){
        for (int i = 0; i < bd.size(); i++) {
            if (bd.get(i).get(0).equals(Integer.toString(id))){
                bd.get(i).set(1, user.getUser());
                bd.get(i).set(2, user.getPassword());
                bd.get(i).set(3, user.getFullName());
            }
        }
    }
    public void mostrarUsuario(int id){
        for (int i = 0; i < bd.size(); i++) {
            if(bd.get(i).get(0).equals(Integer.toString(id))){
                System.out.println(bd.get(i));
            }
        }
    }

    public void mostrarTodosUsuarios(){
        System.out.println(bd.toString());
    }
}
