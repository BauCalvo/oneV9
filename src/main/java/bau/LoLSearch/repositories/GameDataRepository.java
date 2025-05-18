package bau.LoLSearch.repositories;

import bau.LoLSearch.models.entities.game.GameData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameDataRepository extends MongoRepository<GameData, String> {
}
