package security.example.mvc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoldController {
    @GetMapping("/gold")
    public ResponseEntity<String> getGold() {
        return ResponseEntity.ok("GOLD 1000");
    }
}
