# Basketball Simulation

Originally developed by [cmquinn97](https://github.com/cmquinn97). 

This code simulates basketball games based on manually inputted player ratings, in coordination with a simulation algorithm to provide realistic results.

***

The original code was modified in order to solve the following task:
> **Task:** Find a way to balance the game in a situation where one of the teams has numerical superiority (six players instead of five).


## Table of Contents

- [Project Overview](#project-overview)
	- [original](#original)
	- [two\_teams\_equal](#two_teams_equal)
	- [two\_teams\_unbalanced](#two_teams_unbalanced)
	- [balance\_attempt](#balance_attempt)
- [Running the Program](#running-the-program)


## Project Overview

Project repository contains the following folders and subfolders:

- **original:** original simulation code with minor modifications;
- **two\_teams\_equal:** reworked code which allows to simulate games between "equal" teams (a real team and its clone);
- **two\_teams\_unbalanced:** the code is modified in order to simulate extra player's presence:
	- **unbalanced_1st:** player #6 is the same as player #1;
	- **unbalanced_5th:** player #6 is the same as player #5;
- **balance_attempt:** the code is modified so that the team with numerical superiority gets less points:
	- **balance_1st:** player #6 is the same as player #1;
	- **balance_5th:** player #6 is the same as player #5;

Some details concerning each folder are provided below.

### original

The original simulation has two regimes:

- playoffs (a tournament invloving several teams)
- one-game series (4-round series between two teams)

The user is asked to choose the regime at the start of the simulation.

The code has 6 pre-existing teams, each one contains 5 pre-existing players in a fixed order. The player is characterized by his name and 3 ratings:

-  his ability to score a 2-pointer;
-  his ability to score a 3-pointer;
-  his defensive ability.

One particular game simulation happens within a loop; even iterations correspond to the first team and odd iterations correspond to the second team. During each iteration, a random integer between 1 and 100 is generated to decide on a player who takes the shot (*"shooter"*). Player #1 has 30% chance of shooting, players #2 and #3 have 20%, players #4 and #5 — 15%.

Another random integer between 1 and 100 is generated to decide whether the chosen player attempts to throw a 2- or 3-pointer (*"shot"*). Less than 85 corresponds to a 2-point attempt, the rest is a 3-point attempt.

*"chance"* and *"defense_quality"* are both random integers between 1 and 100 which decide the fate of the throw. The player's rating for a corresponding shot (2- or 3-pointer) should be higher than the *chance*. The player is confronted with the same-number player from the opposite team; the defensive ability rating of that player should be less than *defense_quality*. If both conditions are met, then the throw is considered successful and the team scores 2 ot 3 points respectively.

### two\_teams\_equal

Only the "one-game series" regime is used. The amount of games in the series is increased to $$N = 10^4$$. You can now simulate a game which involves one team playing against itself.

### two\_teams\_unbalanced

Same as the previous one, but the sixth player is added into the second team. The first team has a "dummy" player as #6 with all his ratings set to zero.

The players now have the following layout of chances to shoot during one iteration: 20% for players #1, #2 and #3, 15% for players #4 and #5 and 10% for the 6th player.

In terms of ratings, the 6th player is either the same as #1 (**unbalanced_1st** subfolder) or the same as #5 (**unbalanced_5th** subfolder).

### balance\_attempt

Same as the previous one, but an attempt was made to regain balance. Namely, the second team (with numerical superiority) earns 1.67 points for a 2-point shot and 2.5 points for a 3-point shot (the 5/6 coefficient is applied).

In terms of ratings, the 6th player is either the same as #1 (**balance_1st** subfolder) or the same as #5 (**balance_5th** subfolder).

## Running the Program

To run the program, go to one of the folders. Each folder contains a Makefile. You can either compile the project manually or use the `make` command. Use `make clean` to remove extra files.