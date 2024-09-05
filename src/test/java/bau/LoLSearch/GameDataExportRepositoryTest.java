package bau.LoLSearch;

import bau.LoLSearch.Records.Exports.GameDataExport;
import bau.LoLSearch.Records.GameData;
import bau.LoLSearch.Repositorys.GameDataExportRepository;
import bau.LoLSearch.Srvices.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GameDataExportRepositoryTest {
    @Autowired
    private GameDataExportRepository repository;

    @Autowired
    private GameDataExport testGameDataExport;

    @Test
    public void saveGameExportTest() {
        GameDataExport savedGameData = repository.save(testGameDataExport);
        assertNotNull(savedGameData,"gameData wasn't saved");
        assertEquals(testGameDataExport.matchId(), savedGameData.matchId(),"saved gameData didn't match expected");
    }


    @Test
    public void findGameExportTest() {
        GameDataExport savedGameData = repository.findById(testGameDataExport.matchId()).orElse(null);
        assertNotNull(savedGameData,"couldn't find gameData");
        assertEquals(testGameDataExport.matchId(), savedGameData.matchId(),"gameData found didn't match expected");

        GameDataExport gameNotFound = repository.findById("xd").orElse(null);
        System.out.println(gameNotFound);
        assertNull(gameNotFound);
    }

    @Test
    public void deleteGameExportTest() {
        repository.deleteById(testGameDataExport.matchId());
        GameDataExport savedGameData = repository.findById(testGameDataExport.matchId()).orElse(null);
        assertNull(savedGameData,"data wasn't deleted");
    }



}
