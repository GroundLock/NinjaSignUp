package dev.java10x.NinjaSignUp.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjaDTO ninjaDTO){

        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setImgUrl(ninjaDTO.getImgUrl());
        ninjaModel.setAge(ninjaDTO.getAge());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMissions(ninjaDTO.getMissions());

        return ninjaModel;

    }

    public NinjaDTO map(NinjaModel ninjaModel){

        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjaDTO.setAge(ninjaModel.getAge());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMissions(ninjaModel.getMissions());

        return ninjaDTO;
    }
}
