package dev.java10x.NinjaSignUp.Missions.Service;

import org.springframework.stereotype.Component;

@Component
public class MissionMapper {
    public MissionModel map (MissionDTO dto){
        MissionModel model = new MissionModel();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setRank(dto.getRank());
        return model;
    }

    public MissionDTO map (MissionModel model){
        MissionDTO dto = new MissionDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setRank(model.getRank());
        return dto;
    }
}
