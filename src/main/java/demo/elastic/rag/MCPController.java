package demo.elastic.rag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mcp")
public class MCPController {

    private final MCPService MCPService;

    @Autowired
    public MCPController(MCPService MCPService) {
        this.MCPService = MCPService;
    }

    @PostMapping("/query")
    public ResponseEntity query(@RequestBody String question) {
        try {
            String response = MCPService.queryLLM(question);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
