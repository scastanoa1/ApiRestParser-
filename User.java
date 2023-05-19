import java.util.concurrent.atomic.AtomicInteger;
public class User {
public static final AtomicInteger contador = new AtomicInteger(0);
    private int id;
    private String user;
    private String password;
    private String fullName;

    public User(String user, String password, String fullName) {
        this.id = contador.incrementAndGet();
        this.user = user;
        this.password = password;
        this.fullName = fullName;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getUser() {return user;}

    public void setUser(String user) {this.user = user;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getFullName() {return fullName;}

    public void setFullName(String fullName) {this.fullName = fullName;}

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
