package dev.java10x.NinjaSignUp.Ninjas;

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
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.createNinja(ninja);
    }

    // Show ninjas (Read)
    @GetMapping("/readall")
    public List<NinjaModel> listAllNinja(){
        return ninjaService.listNinja();
    }

    // Show ninja by ID (Read)
    @GetMapping("/readID/{id}")
    public NinjaModel listNinjaByID(@PathVariable Long id){return ninjaService.listNinjaByID(id);}

    // Change data  (Update)
    @PutMapping("/updateID/{id}")
    public NinjaModel updateByID(@PathVariable Long id, @RequestBody NinjaModel ninjaModel){return ninjaService.updateNinja(ninjaModel, id);}

    // Delete Ninja (Delete)
    @DeleteMapping("/deleteID/{id}")
    public void deleteID(@PathVariable Long id){ninjaService.deleteNinjaId(id);}

    // All of this is called CRUD (Create, read, update, delete)

}
