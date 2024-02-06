[Home](https://github.com/mstensby)

### Problem Statement

The goal of this program is to create a Sports simulator, where you are able to play one of 4 sports: Football, Hockey, Basketball, and Soccer. Each of these should have the proper scoring methods and the point representation of each of those scoring methods. After the user requests the desired scoring method, the score will increase for that team. Once the user wishes to end the quarter, they may do so by entering the last scoring method. 

This program should use Polymorphism, in order to establish re-usability of methods and variables that all sports should have. This includes a Team Name, the proper scoring methods, and the increment of time (Period, Quarter, or Half). The program should be able to add points scored to each team depending on which team the user wants to score.

### User Documentation

To play the Sports Simulator, simply click the run button and enter in a number that is associated with a scoring method for one of the two teams. Whenever you wish to end the quarter/period/half, simply enter the number that is associated with it. Once you end the game (by incrementing the time a last time) the final score will display and show who the winner is.

### Developer Documentation

The abstract class "Game" should be used to create setters and getters for each of the private variables due to the principle of least privilege. Then, there should be an abstract method that sets the time format of the game. 

The next classes should have an "is-a" relationship. This means that all sports should have their own type of scoring methods. There are also a significant amount of methods that will be the same across all sports, such as setting the team names. There will also be a class Team that is solely used for creating the new teams after the names of the teams are entered.

The private variables that can be used for all sports should be: the current time increment, the max time increment (e.g. 4 for quarters), the team names, the number of options, and the number of scoring methods(although they change depending on the sport, setters and getters allow them to be used for all programs). 

The two public variables that were used is a Hashmap and an array of Strings. The hashmaps purpose is to associate each number that the user could enter with a # of points that can be scored after choosing that method of scoring. The array of Strings purpose is to have each distinct possibility for how the user may be able to score(e.g. touchdown for either team). These two public variables are changed depending on the sport that is being played, which means that they must be public so that the user may be able to access them and change the ways that can be scored if needed.

[Game JavaDocs](http://localhost:8000/mstensby/oral_exam2/Polymorphism/doc/package-summary.html)
![UML_Diagram](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/raw/main/oral_exam2/Polymorphism/PolymorphismUMLDiagram.png)

### Source Code
[Game](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Polymorphism/src/Game.java)

[Team](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Polymorphism/src/Team.java)

[Hockey](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Polymorphism/src/Hockey.java)

[Soccer](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Polymorphism/src/Soccer.java)


[Basketball](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Polymorphism/src/Basketball.java)

[Football](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Polymorphism/src/Football.java)

[ScoreboardGameDriver](https://class-git.engineering.uiowa.edu/swd2023fall/mstensby/-/blob/main/oral_exam2/Polymorphism/src/ScoreboardGameDriver.java)
