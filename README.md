The game of battleMage is played by writing a Java class representing a Player Character that can analyze
an incoming threat and make a decision about what action to take. Can you devise a strategy that will win regularly?

There are two "starter classes," DumbFighter and BadBlocker. Try them out in the BattleTester
main method, then come up with better strategies of your own!

Rules of the Game:
Your character will face an Opponent with 100 hit points.
Your character may have up to 200 points worth of resources, hit points included.

Each turn, your character will be faced with the threat of incoming damage in four quadrants. (top left, etc.)
Each turn the Opponent will be randomly vulnerable to either physical (attack) damage or magical (Magic Blast) damage.

Your character will have to decide which of four actions to take. Each action costs a certain amount of any resource.

"Attack" costs 1 resource for 1 hit. Hits do 10 damage (plus the opponent's physical vulnerability)
Attacks can hit multiple times, they cost (3^n-2) where n is the number of hits.

"Block" costs 1 of any resource whose value is <= 20.
Blocks are made in the UP, DOWN, LEFT, or RIGHT direction, and remove all threat from the two blocked quadrants.

"MagicBlast" costs 10 of any resource, and gets 1 cheaper each time it is used in Battle.
MAgic blast removes 1/3 of the Opponent's remaining hitponts (plus the opponent's magical vulnerability)

"MagicShield" costs 2^n, where n is the power of the shield
Magic Shied reduces the remaining threat by half in all quadrants, once for each shield power.




