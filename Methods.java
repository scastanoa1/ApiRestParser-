public interface Methods {
    void agregarUsuario(String body);
    void eliminarUsuario(int id);
    void actualizarUsuario(int id, String body);
    void mostrarUsuario(int id);
    void mostrarTodosUsuarios();

}
