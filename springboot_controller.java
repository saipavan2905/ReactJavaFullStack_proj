@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (user.getUsername().length() < 3) {
            return ResponseEntity.badRequest().body("Username must be at least 3 characters long.");
        }
        if (!user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            return ResponseEntity.badRequest().body("Invalid email format.");
        }
        if (user.getPassword().length() < 8) {
            return ResponseEntity.badRequest().body("Password must be at least 8 characters long.");
        }
        return ResponseEntity.ok("User registered successfully!");
    }
}
