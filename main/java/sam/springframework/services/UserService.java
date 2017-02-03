package sam.springframework.services;

public interface UserService {
    boolean authenticate(String username, String password);
}
