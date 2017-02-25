# RomanNumeralsCalculator
A calculator for expressions with roman numerals.

Mai intai am impartit tema pe subprobleme:
1. convertirea numerelor romane in numere arabe
2. convertirea numerelor arabe in numere romane
3. trecerea unei expresii din forma infixata in forma postfixata(forma poloneza)
4. rezolvarea unei expresii in forma postfixata
5. potrivirea parantezelor
6. implementarea design patternurilor

1. Pentru a converti numerele romane in numere arabe am folosit un algoritm scurt ce presupune
parcurgerea caracterelor din numarul roman de la sfarsit catre inceput. Convertesc caracterul roman
intr-un int si tin intr-o variabila un maxim curent. Pana cand dau de un numar mai mare decat maximul
curent, scad din rezultat (care porneste de la 0) numarul curent. Cand dau de un numar mai mare decat
maximul, actualizez maximul si adun acest numar la rezultat.

2. Pentru a converti numerele arabe in numere romane, am un vector cu numere romane si unul cu
echivalentul acestora ca numere arabe. Adaug la numarul roman rezultat, primul numar roman care este
mai mic decat numarul ce trebuie convertit si scad acest numar roman din numarul pe care trebuie sa
il convertesc. Repet acest lucru pana cand numarul meu ajunge la zero.

3. Pentru a converti o expresie infixata in forma postfixata am implementat algoritmul descris in
laboratul 4 din referintele temei.

4. Pentru a rezolva expresia posfixata am folosit algorimtul descris in acelasi laborator.

5. Pentru potrivirea parantezelor am folosit un HashMap in care am pus parantezele deschise ca cheie
si cele inchise corespunzatoare ca valoare.

6. Am facut factory-urile si serverul, singleton-uri.

La factory-url OperatorsFactory am folosit tot un hashmap si o enumeratie pentru a valida operatorii
si pentru a instantia operatorul potrivit in functie de caracter.

Factory-ul OperandsFactory continte metodele de conversie din roman in arab si invers. Nu am creat decat
un singur tip de operand care contine o valoare de tip Double deoarece este de ajuns.

La fel si la factory-ul BracketsFactory am o singura clasa Bracket, iar symbol din din clasa Token
defineste ce tip de paranteza e.

Server-ul contine o lista cu rezultatele si o lista cu operatorii ce pot fi folositi si foloseste
metode din clasa utilitara statica ExpressionSolver ce contine un Stack<IToken> privat.
