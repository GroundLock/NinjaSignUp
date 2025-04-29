package dev.java10x.NinjaSignUp.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
