package dev.java10x.NinjaSignUp.Missions.Service;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionDTO {

    private Long id;
    private String name;
    private Rank rank;
}
