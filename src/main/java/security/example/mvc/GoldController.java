package security.example.mvc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoldController {
    @GetMapping("/gold")
    public ResponseEntity<String> getGold() {
        return ResponseEntity.ok("\uD83D\uDCB0 \uD83D\uDCB0 \uD83D\uDCB0 \uD83D\uDCB0 \uD83D\uDCB0 \uD83D\uDCB0 \uD83D\uDCB0 \uD83D\uDCB0");
    }

    @GetMapping("/charity")
    public ResponseEntity<String> getCharity() {
        return ResponseEntity.ok("\uD83D\uDCB0");
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> depositFunds(String amount) {
        return ResponseEntity.ok("Your deposit has been recorded.");
    }

    @PostMapping("/donation")
    public ResponseEntity<String> donateFunds(String amount) {
        return ResponseEntity.ok("Thank you for your generosity!");
    }
}
