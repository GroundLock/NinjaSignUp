package dev.java10x.NinjaSignUp.Ninjas;

import dev.java10x.NinjaSignUp.Missions.Service.MissionModel;
import dev.java10x.NinjaSignUp.Missions.Service.Rank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

// Entity Transforms a class to an entity in DB
@Entity
@Table(name = "tb_sign_up")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missions")

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "rank")
    private String rank;

    @Column(name = "img_url")
    private String imgUrl;
    // A ninja has only one mission
    @ManyToOne
    @JoinColumn(name = "mission_id") // Foregnein key ( I have no idea on how to write this)
    private MissionModel missions;


}
