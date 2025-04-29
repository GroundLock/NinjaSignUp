package dev.java10x.NinjaSignUp.Missions.Service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {
    private MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) { this.missionRepository = missionRepository; }

    public List<MissionModel> listMission(){
        return missionRepository.findAll();
    }
}
