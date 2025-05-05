package dev.java10x.NinjaSignUp.Ninjas;

import dev.java10x.NinjaSignUp.Missions.Service.Rank;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // List all ninjas
    public List<NinjaModel> listNinja(){
        return ninjaRepository.findAll();
    }

    // List by ID
    public NinjaModel listNinjaByID(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaModel createNinja(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }

    // Deletes - Need to be void
    public void deleteNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }


}
