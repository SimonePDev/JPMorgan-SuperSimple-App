# JPMorgan-SuperSimple-App
A little test program very simple
It runs in Java 1.7. it is really simple. i just wrote some code in different ways (as you will see in comments over methods) not to lose time but to evidence the fact that there are many ways to achieve the goal.


anyway it si very simple. I created from the table you have in the test 2 entities that extends and implements an Abstract class and an Interface. I prefere to use an abstract class because in this way whoever wants to extend it is forced not to instantiate the base class but to use subclasses' contructor. I prefer this way because I can force the user to implements some of the methods specialized in some operations (this is not the case actually).

As you can see I also created DAO classes that retrieves data (actually I create the list of object).

at the end there are the The trade Classes and the calculation classes.
there is a baseTrade that has as attributes a trade date,an interface IGBCEStock (the one from which the entities object inherit), an Enum that represent the type of Trade (buy or sell) and the quantity.
