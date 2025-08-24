# chess-app
Application that simulates the movements of three types of chess pieces on an empty chess board(8x8). The three implemented pieces are
King, Queen and Pawn. The movements are implemented as follows:
1. Pawn - It can only move 1 step at a time, in the vertical forward direction.
2. King - It can only move 1 step at a time, in all 8 directions (vertical, horizontal and diagonal)
3. Queen - It can move across the board in all 8 directions.
JUnit test cases are also added for all the three pieces movements.

##Getting Started

Prerequisites
  - JDK 21
  - Maven 3.9.x

Installing & Running
1. Clone the repository `git clone https://github.com/sidharth-k-7/chess-app.git`
2. Build the project using Maven: `mvn clean install`
3. Run the AppMain class via IDE
4. For command line exe, run the below inside the root directory

      -  `mvn compile`
      -  `mvn exec:java -Dexec.mainClass="org.chess.AppMain"`
  




