public class Main {
    static Methods m1 = new BD();
    public static void main(String[] args){
        User u1 = new User("magdc","CastaBaby@","Miguel Gomez");
        User u2 = new User("michim","botero69","Michim Botero");
        User u3 = new User("j?sierra11","done31","Juanda Siera");
    m1.agregarUsuario(u1);
    m1.agregarUsuario(u2);
    m1.agregarUsuario(u3);
    m1.mostrarTodosUsuarios();
    m1.eliminarUsuario(1);
    m1.mostrarTodosUsuarios();
    m1.agregarUsuario(u1);
    m1.mostrarTodosUsuarios();
    m1.actualizarUsuario(2, u1);
    m1.mostrarTodosUsuarios();
    m1.mostrarUsuario(2);
    }
}
