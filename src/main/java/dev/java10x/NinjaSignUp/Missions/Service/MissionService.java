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
    public MissionDTO updateMission(MissionDTO missionDTO, Long id){
        Optional<MissionModel> missionExist = missionRepository.findById(id);
        if (missionExist.isPresent()){
            MissionModel missionUpdated = missionMapper.map(missionDTO);
            missionUpdated.setId(id);
            MissionModel missionSaved = missionRepository.save(missionUpdated);
            return missionMapper.map(missionSaved);
        }
        return null;
    }
}
