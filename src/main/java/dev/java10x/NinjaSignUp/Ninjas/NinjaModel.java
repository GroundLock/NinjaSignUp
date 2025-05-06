package dev.java10x.NinjaSignUp.Ninjas;

import dev.java10x.NinjaSignUp.Missions.Service.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Entity Transforms a class to an entity in DB
@Entity
@Table(name = "tb_sign_up")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;
    // A ninja has only one mission
    @ManyToOne
    @JoinColumn(name = "mission_id") // Foregnein key ( I have no idea on how to write this)
    private MissionModel missions;
}
