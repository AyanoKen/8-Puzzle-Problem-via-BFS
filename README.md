# 8-Puzzle-Problem-via-BFS
8 Puzzle is a 3x3 matrix with 8 numbers and a blank space.

Each individual spot of the matrix is a tile. 

In the initial matrix, the tiles are jumbled and using the blank tile, we are supposed to arrange the tiles such that the matrix is in increasing order.
We can reach the final state by four operations on a board. i.e 
Move the blank tile up (i.e replacing it with the tile above it)
Move blank tile Down 
Move Black tile left 
Move blank tile right
For example:

Initial State:
4 8 7

1 3 5

6   2

Final State:
1 2 3 

4 5 6

7 8 

Used Method: State Space Search.
State space search is a process used in the field of computer science, in which successive configurations or states of an instance are considered, with the intention of finding a goal state with a desired property.

Algorithm: Breadth First Search.
Breadth First Search is a searching algorithm in which we iterate through a tree in a manner that we complete all the nodes in a height h first and only then we move on to search in the height h + 1. 

Details of my Code:
In my program, I made a Board class to represent a state of the matrix. It contains a array which is the matrix, two variables to know the coordinates of the blank tile and a board object to store the parent of a board(Parent is the board which brought this board to the BFS queue)
The board class also contains the methods to implement the operations on the blank tile.

I used a queue to implement the breadth first seearch algorithm. The queue initially contains the initial state of the board and when the program starts, The program checks if the board at the front of the queue is the answer. If it is the answer, stop searching else, the four operations are done on that board and the resulting children boards are placed inside the queue and then the board at the front of the queue is removed. This goes on until the goal state is found.

Once the goal state is found, using the back pointer (Object variable "parent"), I found out the path to the goal from the initial state.



Note:
1.Any Contribution is appretiated.

2.Download the three files (Board, Main, Queue) and run the Main file to test the program

3.The algorithm works only when the state tree is small. ie, it fails when the puzzle is changed a lot but you can increase the size of the queue to make it work for more puzzles.

4.This algorithm is to show that BFS is "Not" suitable for State Space Search Problems.

5.This is my first time hosting in github. So, please dont hate me for my bad code :)
