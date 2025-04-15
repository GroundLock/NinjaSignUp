package dev.java10x.NinjaSignUp.Ninjas;

import dev.java10x.NinjaSignUp.Missions.Service.MissionModel;
import jakarta.persistence.*;

import java.util.List;

// Entity Transforms a class to an entity in DB
@Entity
@Table(name = "tb_sign_up")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private int age;

    // A ninja has only one mission
    @ManyToOne
    @JoinColumn(name = "mission_id") // Foregnein key ( I have no idea on how to write this)
    private MissionModel missions;

    public NinjaModel() {
    }

    public NinjaModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
