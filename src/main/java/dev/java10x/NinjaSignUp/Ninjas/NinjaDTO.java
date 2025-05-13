package dev.java10x.NinjaSignUp.Ninjas;

import dev.java10x.NinjaSignUp.Missions.Service.MissionModel;
import dev.java10x.NinjaSignUp.Missions.Service.Rank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

        private Long id;
        private String name;
        private String email;
        private String imgUrl;
        private int age;
        private String rank;
        private MissionModel missions;
}
