package pl.gamematch.GameMatch.model.game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Piotr Romanczak on 05-12-2021
 * Description: GameMode entity
 */

@Entity
@NoArgsConstructor
@Table(name="game_mode")
@Getter
@Setter
public class GameMode {

    @Id
    @Column(name = "game_mode_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "game_mode_name")
    private String name;

    public GameMode(String name) {
        this.name = name;
    }
}
