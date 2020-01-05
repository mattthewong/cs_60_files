%
% logicpuzzle.pl  --  the logic-puzzle problem
%
% Submission site id(s):eu6
%
% Comments:

% some "nice" prolog settings...  see the assignment 
% description for the details on what these do
% -- but it's not crucial to know the details of these Prolog internals
:- set_prolog_flag( prompt_alternatives_on, groundness ).
:- set_prolog_flag(toplevel_print_options, [quoted(true),
     portray(true), attributes(portray), max_depth(999), priority(699)]).


% For this problem, you will need to choose a representation
% and the create the constraints on that representation to
% allow Prolog to solve the train-traveling logic problem

% It's not required that you use the spatial-layout representation
% that the solution to Einstein's puzzle used, but it's OK to do so.

% You may want to start by looking over that einstein.pl code.
% It should be linked at the top-level assignments page

% predicates we will need...
% adjacency (unordered)
nextTo(X, Y, List) :- lr(X, Y, List).
nextTo(X, Y, List) :- lr(Y, X, List).

% left-to-right adjacency
lr(L, R, [L, R | _]).
lr(L, R, [_ | Rest]) :- lr(L, R, Rest).

% remove an element (which much be present) from a list...
removeOne(X,[X|R],R).
removeOne(X,[F|R],[F|S]) :- removeOne(X,R,S).

% generates permutations of the first input's list
perm([X|Y],Z) :- perm(Y,W), removeOne(X,Z,W).
perm([],[]).
/*
 *
 * Here is the problem description:

   algird, bruno, collette, dino, and edwina are each from different
   Claremont Colleges. (Be sure to use lowercase for these constants
   inside Prolog!)

   The 5 Claremont Colleges are:  pomona, pitzer, hmc, cmc, and scripps.
   Each one brings a different snack: jots, chocolate, donuts, pez, and
   spam. They are all on the train together in seats 1 (leftmost)
   through 5 (rightmost).


Your task is to get Prolog to answer:

   Which student is in each seat,
     which college does each student go to, and
     what did each student bring for a snack?
*
 *
 */

seats([S1,S2,S3,S4,S5]):-
S1 = [N1,C1,F1],
S2 = [N2,C2,F2],
S3 = [N3,C3,F3],
S4 = [N4,C4,F4],
S5 = [N5,C5,F5],
perm([N1,N2,N3,N4,N5],[algird,bruno,collette,dino,edwina]),
perm([C1,C2,C3,C4,C5],[pomona,pitzer,cmc,hmc,scripps]),
perm([F1,F2,F3,F4,F5],[jots,chocolate,donuts,pez,spam]).

logicpuzzle(Seats):- 

seats(Seats),


(Seats = [[bruno,_,_], _,[_, hmc,spam],_,[dino,_,_]];
 Seats = [[dino,_,_], _, [_,hmc,spam],_,[bruno,_,_]]),


nextTo([algird,_,_],[_,hmc,spam], Seats),

nextTo([collette,_,_],[_,_,chocolate], Seats),
nextTo([collette,_,_],[_,_,donuts], Seats),

member([_,hmc,spam], Seats),

lr([_,_,chocolate], [_,_,pez], Seats),
nextTo( [_,pomona,_],[_,hmc,spam], Seats),
nextTo( [_,pomona,_],[_,_,jots], Seats),

\+nextTo( [dino,_,_],[_,_,donuts], Seats),
\+nextTo( [_,cmc,_],[edwina,_,_], Seats),

\+member([bruno,scripps,_], Seats),
\+member([dino,scripps,_], Seats),
\+member([algird,scripps,_], Seats).

solve :- 
  logicpuzzle([S1,S2,S3,S4,S5]),
  write( ' seat1: '), write(S1), nl,
  write( ' seat2: '), write(S2), nl,
  write( ' seat3: '), write(S3), nl,
  write( ' seat4: '), write(S4), nl,
  write( ' seat5: '), write(S5), nl.
/*
 *
 * 
Constraints:

1.  bruno and dino sat in the end seats.
2.  algird sat next to the student from HMC.
3.  collette sat next to (i.e. between) friends with chocolate and donuts.
4.  The HMC student brought spam as a snack and sat in the middle seat.
5.  chocolate was immediately to the left of pez.
6.  bruno, dino, and algird do not go to scripps.
7.  The pomona student sat between the person with jots and spam.
8.  dino did not sit next to the person with donuts.
9.  The CMC student did not sit next to edwina.


The unique solution:

  This is helpful to have when debugging... .

  Seats =
  [[bruno,cmc,jots],
   [algird,pomona,donuts],
   [collette,hmc,spam],
   [edwina,scripps,chocolate],
   [dino,pitzer,pez]]



Hints/guidelines:

  Use the einstein.pl example as a starting point and as a guide
  to some useful helper predicates!
*
 *
 */
 





