package bau.LoLSearch.Repositorys;

import bau.LoLSearch.Records.Exports.GameDataExport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameDataExportRepository extends MongoRepository<GameDataExport, String> {
}
