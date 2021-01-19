# AP Computer Science 2017-2018
Consists of various projects and assignments given to us during the school year.

## American Computer Science League Contests 2017-2018
American Computer Science League (ACSL) organizes computer science and programming contests for K-12 students.

This repo includes the folders labelled, Ninety-Nine, Walk, and Enclosure. This year I competed in the Intermediate division. Keep in mind, a majority of my logic was Brute Force.

### Ninety-Nine
**PROBLEM:** ACSL Ninety-Nine is a two-player card game played with a standard deck of 52-
cards (2 – 9, T, J, Q, K, A). To start, each player is dealt 3 cards and the remaining cards are
placed face down on the table (the pile). In an actual game the point total is set to zero, but for
this program an initial point total will be given. Each player in turn puts down one card and
changes the point total according to the point value of his card and then selects a card from the
top of the pile. Each card adds its face value in points (e.g. a 5 is worth five points, a T is worth
10 points, a J is worth 11 points, a Q is worth 12 points, a K is worth 13 points and an A is
worth 14 points) except for certain cards that have special values or meanings:

```
- A 9 is a pass (and does not change point total).
- A T subtracts 10 points from the total.
- An A adds either 1 or 14 to the point total. The 14 is played first as long as it does not put
the point total over 99.
```

Cards are played using the following rule: Play the largest face value card.
The game ends when the card played puts the point total over 99.

### [Walk](https://www.doralacademyprep.org/ourpages/auto/2018/2/13/48374494/c_3_walk_int%201718%20STUDENT.pdf)
**PROBLEM:** Given an array containing both 1’s and 0’s to direct a walker along a path, find the
ending location of the walker. This problem will use an 8x8 array. In the diagram below,
location (1, 1) is at the upper left hand corner of the array and contains a 0. If the walker
encounters a 0, he continues in the direction he entered that array location. If he encounters a 1,
the direction depends on the direction the walker enters that location and the turn value at that
location. Each 1 location starts out as a 90 degree turn but increases by 90 degrees each time it is
reentered.

If the walker enters (2, 2) from the Left, 90 degrees is a vertical move up, 180 continues in the
same direction, 270 degrees is a vertical move down and 360 degrees (or 0 degrees) is a move in
the opposite direction. See Diagram #1.

If the walker enters (2, 2) from the Right, 90 degrees is a vertical move down, 180 degrees
continues in the same direction, 270 degrees is a vertical move up and 360 degrees is a move in
the opposite direction. See Diagram #2.

If the walker enters (2, 2) from Below, 90 degrees is a move to the left, 180 degrees continues in
the same direction, 270 degrees is a move to the right and 360 degrees is a move in the opposite
direction. See Diagram #3.

If the walker enters (2, 2) from Above, 90 degrees is a move to the right, 180 degrees continues
in the same direction, 270 degrees is a move to the left and 360 degrees is a move in the opposite
direction. See Diagram #4.

If a cell value directs a walker to a boundary of the array, he is transported to the opposite side of
the array. Ex. If a move starts at (2, 8) and must go right, then the move will be to (2, 1).

