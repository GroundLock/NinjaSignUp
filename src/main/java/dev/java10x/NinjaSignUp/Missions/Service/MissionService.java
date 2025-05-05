package dev.java10x.NinjaSignUp.Missions.Service;

import dev.java10x.NinjaSignUp.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    private MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) { this.missionRepository = missionRepository; }

    public List<MissionModel> listMission(){
        return missionRepository.findAll();
    }

    public MissionModel listMissionByID(Long id){
        Optional<MissionModel> missionModel = missionRepository.findById(id);
        return missionModel.orElse(null);
    }

    public MissionModel createMission(MissionModel missionModel){
        return missionRepository.save(missionModel);
    }

    public void deleteID(Long id){
        missionRepository.deleteById(id);
    }
}
