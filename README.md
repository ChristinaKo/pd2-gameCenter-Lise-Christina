pd2-project-Lise-Christina
==========================
Group Members: Lise Ho and Christina Ko from Period 2

Description: This is our Game Center. It currently holds three games: Tic-Tac-Toe, Connect-4 and a Trivia Game. 
To use our game center, please compile Gui.java.

What works:
     Tic-Tac-Toe easy and hard levels both work. The Trivia also works. The High Score chart works with the exception of the ConnectFour column. Players are able to change their profiles as well via the high score screen.

What does not work:
     Everything should work, but these are some of our flawed game features:
     The ConnectFour algorithm behind the com player for connect four is weak --> it just chooses random slots, but the game functions.
     High Scores are temporary; when you rerun GUI, HS are defaulted back to the default HS [all previous high scores are deleted].
     	  
Data structures used: We used priority queues in GUIs.java to store the high scores. [max heaps]
