package dev.java10x.NinjaSignUp.Missions.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.NinjaSignUp.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_mission")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated
    private Rank rank;
    // A mission can be applied to more than one ninja
    @OneToMany(mappedBy = "missions")
    @JsonIgnore
    private List<NinjaModel> ninja;

}
