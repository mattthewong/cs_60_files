%%
%% einstein.pl
%%

% some "nice" prolog settings...  see assignment 8's
% description for the details on what these do
% -- but it's not crucial to know the details of these Prolog internals
:- set_prolog_flag( prompt_alternatives_on, groundness ).
:- set_prolog_flag(toplevel_print_options, [quoted(true),
     portray(true), attributes(portray),
     max_depth(999), priority(699)]).




/* EINSTEIN RULES!

 There are five houses: [nation, pet, cigar, beverage, house color]
   The nationalities are norwegian, brit, swede, dane, and german
   The pets are dog, bird, zebra, cat, and horse
   The cigars are pallmall, winfield, dunhill, rothmans, marlboro
   The beverages are tea, coffee, milk, water, and beer
   The house colors are red, green, yellow, blue, and white.

 We know that

 1) The norwegian lives in the first house.
 2) The person living in the center house drinks milk.
 3) The Brit lives in a red house.
 4) The Swede keeps dogs as pets.
 5) The Dane drinks tea.
 6) The Green house is next to, and on the left of the White house.
 7) The owner of the Green house drinks coffee.
 8) The person who smokes Pall Mall rears birds.
 9) The owner of the Yellow house smokes Dunhill.
10) The man who smokes Marlboro lives next to the one who keeps cats.
11) The man who keeps horses lives next to the man who smokes Dunhill.
12) The man who smokes Winfields drinks beer.
13) The German smokes Rothmans.
14) The red house is to the right of the blue.
15) The Norwegian does not live by the red, white, or green houses

 The question is, Who owns the Zebra?

*/

%% what two predicates might be helpful here?
% spatial constraints!


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

houses( [H1, H2, H3, H4, H5 ] ):-
   H1 = [ N1, P1, S1, B1, C1 ],
   H2 = [ N2, P2, S2, B2, C2 ],
   H3 = [ N3, P3, S3, B3, C3 ],
   H4 = [ N4, P4, S4, B4, C4 ],
   H5 = [ N5, P5, S5, B5, C5 ],
   perm( [N1,N2,N3,N4,N5], [norwegian, brit, swede, dane, german] ),
   perm( [P1,P2,P3,P4,P5], [dog, bird, zebra, cat, horse] ),
   perm( [S1,S2,S3,S4,S5], [pallmall, winfield, dunhill, rothmans, marlboro] ),
   perm( [B1,B2,B3,B4,B5], [tea, coffee, milk, water, beer] ),
   perm( [C1,C2,C3,C4,C5], [red, green, yellow, blue, white] ).

einstein(Houses) :-
  Houses = [[norwegian, _, _, _, _], _, [_, _, _, milk, _], _, _],
  member([brit, _, _, _, red], Houses),
  member([swede, dog, _, _, _], Houses),
  member([dane, _, _, tea, _], Houses),
  lr([_, _, _, _, green], [_, _, _, _, white], Houses),
  member([_, _, _, coffee, green], Houses),
  member([_, bird, pallmall, _, _], Houses),
  member([_, _, dunhill, _, yellow], Houses),
  nextTo([_, _, marlboro, _, _], [_, cat, _, _, _], Houses),
  nextTo([_, _, dunhill, _, _], [_, horse, _, _, _], Houses),
  member([_, _, winfield, beer, _], Houses),
  member([german, _, rothmans, _, _], Houses),
  lr([_, _, _, _, blue], [_, _, _, _, red], Houses),
  houses( Houses ),  % it's important to have this LATE (otherwise it's 120**5)
  \+nextTo([norwegian,_,_,_,_], [_,_,_,_,white], Houses), % negatives last!
  \+nextTo([norwegian,_,_,_,_], [_,_,_,_,red], Houses),
  \+nextTo([norwegian,_,_,_,_], [_,_,_,_,green], Houses).

solve :-
  einstein( [ H1, H2, H3, H4, H5 ] ),
  write( ' first house: '), write(H1), nl,  % nl is "newline"
  write( 'second house: '), write(H2), nl,
  write( ' third house: '), write(H3), nl,
  write( 'fourth house: '), write(H4), nl,
  write( ' fifth house: '), write(H5), nl.





