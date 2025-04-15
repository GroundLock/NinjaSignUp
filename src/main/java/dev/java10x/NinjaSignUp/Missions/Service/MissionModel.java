package dev.java10x.NinjaSignUp.Missions.Service;

import dev.java10x.NinjaSignUp.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_mission")

public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Rank rank;
    // A mission can be applied to more than one ninja
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninja;

    public MissionModel() {
    }

    public MissionModel(Long id, String name, Rank rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

}
