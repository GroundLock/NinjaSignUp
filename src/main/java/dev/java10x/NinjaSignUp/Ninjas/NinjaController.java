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
    @GetMapping("/read/all")
    public List<NinjaDTO> listAllNinja(){
        return ninjaService.listNinja();
    }

    // Show ninja by ID (Read)
    @GetMapping("/read/ID/{id}")
    public ResponseEntity<?> listNinjaByID(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listNinjaByID(id);
        if(ninja != null){
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Not found");
    }

    // Change data  (Update)
    @PutMapping("/updateID/{id}")
    public ResponseEntity<?> updateByID(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        if(ninjaService.listNinjaByID(id)!=null){
            NinjaDTO ninja = ninjaService.updateNinja(ninjaDTO, id);
            return ResponseEntity.ok(ninja);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja not found on id "+id);
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
