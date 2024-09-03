package bau.LoLSearch.Records;

import java.util.List;

public record GameParticipant(int allInPings, int assistMePings, int assists
        , int baronKills, int basicPings, int bountyLevel
        , Challenges challenges, int champExperience, int championId
        , String championName, int championTransform, int champLevel
        , int commandPings , int consumablesPurchased, int damageDealtToBuildings
        , int damageDealtToObjectives, int damageDealtToTurrets
        , int damageSelfMitigated, int dangerPings, int deaths
        , int detectorWardsPlaced, int doubleKills, int dragonKills
        , boolean eligibleForProgression, int enemyMissingPings
        , int enemyVisionPings, boolean firstBloodAssist, boolean firstBloodKill
        , boolean firstTowerAssist, boolean firstTowerKill, boolean gameEndedInEarlySurrender
        , boolean gameEndedInSurrender, int getBackPings, int goldEarned
        , int goldSpent, int holdPings, String individualPosition
        , int inhibitorKills, int inhibitorsLost, int inhibitorTakedowns
        , int item0, int item1, int item2, int item3, int item4, int item5, int item6
        , int itemsPurchased, int killingSprees, int kills , String lane
        , int largestCriticalStrike, int largestKillingSpree, int largestMultiKill
        , int longestTimeSpentLiving, int magicDamageDealt
        , int magicDamageDealtToChampions, int magicDamageTaken
        , Missions missions, int needVisionPings, int neutralMinionsKilled
        , int nexusKills, int nexusLost, int nexusTakedowns, int objectivesStolen
        , int objectivesStolenAssists, int onMyWayPings, int participantId
        , int pentaKills, Perks perks, int physicalDamageDealt
        , int physicalDamageDealtToChampions, int physicalDamageTaken
        , int placement, int playerAugment1, int playerAugment2
        , int playerAugment3, int playerAugment4, int playerAugment5
        , int playerAugment6, int playerSubteamId, int profileIcon
        , int pushPings, String puuid, int quadraKills, String riotIdGameName
        , String riotIdTagline, String role, int sightWardsBoughtInGame, int spell1Casts
        , int spell2Casts, int spell3Casts, int spell4Casts, int subteamPlacement
        , int summoner1Casts, int summoner1Id, int summoner2Casts, int summoner2Id
        , String summonerId, int summonerLevel, String summonerName, boolean teamEarlySurrendered
        , int teamId, String teamPosition, int timeCCingOthers, int timePlayed, int totalAllyJungleMinionsKilled
        , int totalDamageDealt, int totalDamageDealtToChampions, int totalDamageShieldedOnTeammates
        , int totalDamageTaken, int totalEnemyJungleMinionsKilled, int totalHeal, int totalHealsOnTeammates
        , int totalMinionsKilled, int totalTimeCCDealt, int totalTimeSpentDead, int totalUnitsHealed
        , int tripleKills, int trueDamageDealt, int trueDamageDealtToChampions, int trueDamageTaken
        , int turretKills, int turretsLost, int turretTakedowns, int unrealKills
        , int visionClearedPings, int visionScore, int visionWardsBoughtInGame
        , int wardsKilled, int wardsPlaced, boolean win) {

    public record Challenges(
            int playerScore0, int playerScore1, int playerScore10, int playerScore11
            ,int playerScore2, int playerScore3, int playerScore4, int playerScore5
            ,int playerScore6, int playerScore7, int playerScore8, int playerScore9
            ,int abilityUses, int acesBefore15Minutes, int alliedJungleMonsterKills
            ,int baronBuffGoldAdvantageOverThreshold, int baronTakedowns
            ,int blastConeOppositeOpponentCount, int bountyGold, int buffsStolen
            ,int completeSupportQuestInTime, int controlWardsPlaced
            ,double controlWardTimeCoverageInRiverOrEnemyHalf, double damagePerMinute
            ,double damageTakenOnTeamPercentage, int dancedWithRiftHerald
            ,int deathsByEnemyChamps, int dodgeSkillShotsSmallWindow, int doubleAces
            ,int dragonTakedowns, double earliestBaron, double earliestDragonTakedown
            ,int earlyLaningPhaseGoldExpAdvantage, int effectiveHealAndShielding
            ,int elderDragonKillsWithOpposingSoul, int elderDragonMultikills
            ,int enemyChampionImmobilizations, int enemyJungleMonsterKills
            ,int epicMonsterKillsNearEnemyJungler, int epicMonsterKillsWithin30SecondsOfSpawn
            ,int epicMonsterSteals, int epicMonsterStolenWithoutSmite
            ,int firstTurretKilled, double firstTurretKilledTime, int fistBumpParticipation
            ,int flawlessAces, int fullTeamTakedown, double gameLength
            ,int getTakedownsInAllLanesEarlyJungleAsLaner, double goldPerMinute
            ,int hadOpenNexus, int immobilizeAndKillWithAlly, int InfernalScalePickup
            ,int initialBuffCount, int initialCrabCount, int jungleCsBefore10Minutes
            ,int junglerTakedownsNearDamagedEpicMonster, double kda, int killAfterHiddenWithAlly
            ,int killedChampTookFullTeamDamageSurvived, int killingSprees, double killParticipation
            ,int killsNearEnemyTurret, int killsOnOtherLanesEarlyJungleAsLaner, int killsOnRecentlyHealedByAramPack
            ,int killsUnderOwnTurret, int killsWithHelpFromEpicMonster
            ,int knockEnemyIntoTeamAndKill, int kTurretsDestroyedBeforePlatesFall
            ,int landSkillShotsEarlyGame, int laneMinionsFirst10Minutes
            ,double laningPhaseGoldExpAdvantage, int legendaryCount, List<Integer> legendaryItemUsed
            ,int lostAnInhibitor, int maxCsAdvantageOnLaneOpponent, int maxKillDeficit
            ,int maxLevelLeadLaneOpponent, int mejaisFullStackInTime, int moreEnemyJungleThanOpponent
            ,int multiKillOneSpell, int multikills, int multikillsAfterAggressiveFlash
            ,int multiTurretRiftHeraldCount, int outerTurretExecutesBefore10Minutes, int outnumberedKills
            ,int outnumberedNexusKill, int perfectDragonSoulsTaken, int perfectGame, int pickKillWithAlly
            ,int playedChampSelectPosition, int poroExplosions, int quickCleanse, int quickFirstTurret
            ,int quickSoloKills, int riftHeraldTakedowns, int saveAllyFromDeath, int scuttleCrabKills
            ,double shortestTimeToAceFromFirstTakedown, int skillshotsDodged, int skillshotsHit
            ,int snowballsHit, int soloBaronKills, int soloKills, int soloTurretsLategame
            ,int stealthWardsPlaced, int survivedSingleDigitHpCount, int survivedThreeImmobilizesInFight
            ,int SWARM_DefeatAatrox, int SWARM_DefeatBriar, int SWARM_DefeatMiniBosses, int SWARM_EvolveWeapon
            ,int SWARM_Have3Passives, int SWARM_KillEnemy, int SWARM_PickupGold, int SWARM_ReachLevel50
            ,int SWARM_Survive15Min, int SWARM_WinWith5EvolvedWeapons, int takedownOnFirstTurret
            ,int takedowns, int takedownsAfterGainingLevelAdvantage, int takedownsBeforeJungleMinionSpawn
            ,int takedownsFirstXMinutes, int takedownsInAlcove, int takedownsInEnemyFountain
            ,int teamBaronKills, double teamDamagePercentage, int teamElderDragonKills
            ,int teamRiftHeraldKills, int teleportTakedowns, int tookLargeDamageSurvived
            ,int turretPlatesTaken, int turretsTakenWithRiftHerald, int turretTakedowns
            ,int twentyMinionsIn3SecondsCount, int twoWardsOneSweeperCount, int unseenRecalls
            ,double visionScoreAdvantageLaneOpponent, double visionScorePerMinute, int voidMonsterKill
            , int wardsGuarded, int wardTakedowns, int wardTakedownsBefore20M){};


    public record Missions(
            int playerScore0, int playerScore1, int playerScore10, int playerScore11, int playerScore2,int playerScore3
            ,int playerScore4, int playerScore5, int playerScore6, int playerScore7,int playerScore8, int playerScore9){};


}
