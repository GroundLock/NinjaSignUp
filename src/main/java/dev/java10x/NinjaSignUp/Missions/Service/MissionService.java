package dev.java10x.NinjaSignUp.Missions.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionService {

    private MissionRepository missionRepository;
    private MissionMapper missionMapper;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    // List missions
    public List<MissionDTO> listMission(){
        List<MissionModel> missions = missionRepository.findAll();
        return missions.stream()
                .map(missionMapper::map)
                .collect(Collectors.toList());
    }

    // list by ID
    public MissionDTO listMissionByID(Long id){
        Optional<MissionModel> mission = missionRepository.findById(id);
        return mission.map(missionMapper::map).orElse(null);
    }

    // Create missions
    public MissionDTO createMission(MissionDTO missionDTO){
        MissionModel model = missionMapper.map(missionDTO);
        model = missionRepository.save(model);
        return missionMapper.map(model);
    }

    // Delete mission
    public void deleteID(Long id){
        missionRepository.deleteById(id);
    }

    // Update mission
    public MissionModel updateMission(MissionModel missionModel, Long id){
        if (missionRepository.existsById(id)){
            return missionRepository.save(missionModel);
        }
        return null;
    }
}
