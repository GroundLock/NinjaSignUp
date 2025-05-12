package dev.java10x.NinjaSignUp.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // List all ninjas
    public List<NinjaDTO> listNinja(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // List by ID
    public NinjaDTO listNinjaByID(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.map(ninjaMapper::map).orElse(null);
    }

    // Create Ninja
    public NinjaDTO createNinja(NinjaDTO ninjaDTO){
     NinjaModel ninja = ninjaMapper.map(ninjaDTO);
     ninja = ninjaRepository.save(ninja);
     return ninjaMapper.map(ninja);
    }

    // Deletes - Need to be void
    public void deleteNinjaId(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO updateNinja(NinjaDTO ninjaDTO, Long id){
        Optional<NinjaModel> ninjaExist = ninjaRepository.findById(id);
        if (ninjaExist.isPresent()){
            NinjaModel ninjaUpdated = ninjaMapper.map(ninjaDTO);
            ninjaUpdated.setId(id);
            NinjaModel ninjaSaved = ninjaRepository.save(ninjaUpdated);
            return ninjaMapper.map(ninjaSaved);
        }
        return null;
    }


}
