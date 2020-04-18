NumberSliding
===============

This is an implementation of a well-known **number sliding puzzle**. Also, it contains a small **A.I. engine** able to play the game.
By running *NumberPuzzleApp.class*:

* The user is requested to create a square with 9 elements.
* Each element is a number in [1,9] except from 3. Also, one element is "void" (denoted by '0').
* We note that both input and output are text-based.

Then, the user can choose:

1. **To play the game by himself**. In this case, he is asked to play a series of moves (each move slides an element to its adjacent "void")
until he properly arranges all 9 elements (1 2 "void" # 4 5 6 # 7 8 9).

2. **To ask the help of our A.I. engine**. In this case, if the engine sees a series of moves leading to the desired arrangement, then
it will play them one-by-one, instantly. Otherwise, it will use a heuristic in order to find a "good" move, it will play it, and
it will continue from there.
