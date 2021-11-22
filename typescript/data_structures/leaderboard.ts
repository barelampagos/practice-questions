/**
 * 
Design a Leaderboard class, which has 3 functions:

addScore(playerId, score): Update the leaderboard by adding score to the given player's score. If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
top(K): Return the score sum of the top K players.
reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard). It is guaranteed that the player was added to the leaderboard before calling this function.
Initially, the leaderboard is empty.

Example 1:

Input: 
["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
[[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
Output: 
[null,null,null,null,null,null,73,null,null,null,141]

Explanation: 
Leaderboard leaderboard = new Leaderboard ();
leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
leaderboard.top(1);           // returns 73;
leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
 * 
 */
type Score = {
    id: number,
    score: number
}

class Leaderboard {

    scoreBoard: Score[];
    playerMap: Map<number, number>;
    
    constructor() {
        this.scoreBoard = [];
        this.playerMap = new Map();
    }

    addScore(playerId: number, score: number): void {
        console.log('ADD: ' + playerId + ', ' + score)
        console.log('EXISTS: ' + this.playerMap.has(playerId))
        
        // Add if not exists, update if exists
        if (!this.playerMap.has(playerId)) {
            let newScore: Score = {
                id: playerId, 
                score 
            };

            this.scoreBoard.push(newScore);
        } else {
            console.log('UPDATE')
            let existingRecordIndex: number = this.scoreBoard.findIndex(scoreEntry => {
                return scoreEntry.id == playerId
            });
            console.log(existingRecordIndex)
            
            this.scoreBoard[existingRecordIndex].score += score;
        }
        
        this.scoreBoard.sort((r1, r2) => {
            return r2.score - r1.score;
        })

        this.playerMap.set(playerId, score);
        console.log(this.playerMap)
        console.log(this.scoreBoard);
    }

    top(K: number): number {
        console.log('TOP: ' + K)
        let topKRecords: Score[] = this.scoreBoard.slice(0, K);
        let topKScore: number = topKRecords.reduce((totalScore, currentRecord) => { return totalScore + currentRecord.score}, 0);
        console.log('SCORE: ' + topKScore)
        return topKScore;
    }

    reset(playerId: number): void {
        console.log('REMOVE: ' + playerId)
        this.playerMap.delete(playerId);
        this.scoreBoard = this.scoreBoard.filter(existingRecord => existingRecord.id != playerId);

        console.log(this.playerMap);
        console.log(this.scoreBoard);

    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * var obj = new Leaderboard()
 * obj.addScore(playerId,score)
 * var param_2 = obj.top(K)
 * obj.reset(playerId)
 */