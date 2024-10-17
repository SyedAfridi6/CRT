public interface IStudent {
    boolean register(String firstName, String lastName, String username, String password);
    boolean login(String username, String password);
}
