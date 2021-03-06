package pl.gamematch.GameMatch.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.gamematch.GameMatch.model.game.*;
import pl.gamematch.GameMatch.service.GameService;

import java.util.*;

/**
 * Created by Piotr Romanczak on 01-11-2021
 * Description: GameController class
 */

@RestController
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * Created by Piotr Romanczak on 01-11-2021
     * Description: this method returns a Game object by provided alias
     * @param alias
     * @return Game
     */
    @GetMapping("/games/{alias}")
    public Game getGame(@PathVariable String alias) {
        return gameService.getGameByAlias(alias);
    }

    /**
     * Created by Piotr Romanczak on 02-11-2021
     * Description: this method returns List of games by provided category name
     * @param name
     * @return List<Game>
     */
    @GetMapping("/games-by-category/{name}")
    public Set<Game> getGamesByCategory(@PathVariable String name) {
        return gameService.getGamesByCategory(name);
    }

    /**
     * Created by Piotr Romanczak on 02-11-2021
     * Description: this method returns List of all games
     * @return List<Game>
     */
    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    /**
     * Created by Piotr Romanczak on 18-12-2021
     * Description: this method returns List of all games that have not been released
     * @return List<Game>
     */
    @GetMapping("/games/not-released")
    public List<Game> getAllNotReleasedGames() { return gameService.getNotReleasedGames();}

    /**
     * Created by Piotr Romanczak on 18-12-2021
     * Description: this method returns List of most popular games
     * @return List<Game>
     */
    @GetMapping("/games/popular")
    public List<Game> getPopularGames() { return gameService.getPopularGames();}

    /**
     * Created by Piotr Romanczak on 18-12-2021
     * Description: this method returns List of most popular games
     * @return List<Game>
     */
    @GetMapping("/games/highest-rating")
    public List<Game> getHighRatedGames() { return gameService.getHighRatedGames();}

    /**
     * Created by Piotr Romanczak on 08-11-2021
     * Description: this method returns List of all games by provided GameCategory List
     * @param inGameWrapper
     * @return List<Game>
     */
    @PostMapping(path = "/match", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Game> matchGamesToUserInput (@RequestBody GameWrapper inGameWrapper) {
        return gameService.handleGameMatch(inGameWrapper);
    }

    /**
     * Created by Piotr Romanczak on 17-12-2021
     * Description: this method inserts Games
     * @param games
     */
    @PostMapping("/games")
    public void insertGame (@RequestBody List<Game> games) {
        gameService.insertGame(games);
    }
}
