package dev.java10x.NinjaSignUp.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome";

    }


    // Add Ninja (Create)
    @PostMapping("/create")
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO newNinja = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Success: New ninja created on ID (" + newNinja.getId() + ")");
    }

    // Show ninjas (Read)
    @GetMapping("/readall")
    public List<NinjaDTO> listAllNinja(){
        return ninjaService.listNinja();
    }

    // Show ninja by ID (Read)
    @GetMapping("/readID/{id}")
    public ResponseEntity<String> listNinjaByID(@PathVariable Long id){
        if(ninjaService.listNinjaByID(id)!=null){
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body("Found ninja in id "+id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Not found");
    }

    // Change data  (Update)
    @PutMapping("/updateID/{id}")
    public ResponseEntity<String> updateByID(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        ninjaService.updateNinja(ninjaDTO, id);
        return ResponseEntity.ok("Ninja Update on ID "+id);
    }

    // Delete Ninja (Delete)
    @DeleteMapping("/deleteID/{id}")
    public ResponseEntity<String> deleteID(@PathVariable Long id){
        if (ninjaService.listNinjaByID(id)!=null){
            ninjaService.deleteNinjaId(id);
            return ResponseEntity.ok("Success: Ninja deleted on ID " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Failed: Ninja not found on ID " + id);
    }

    // All of this is called CRUD (Create, read, update, delete)

}
