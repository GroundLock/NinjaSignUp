package dev.java10x.NinjaSignUp.Missions.Service;

import dev.java10x.NinjaSignUp.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_mission")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated
    private Rank rank;
    // A mission can be applied to more than one ninja
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninja;

}
