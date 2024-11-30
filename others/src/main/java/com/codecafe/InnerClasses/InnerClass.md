Inner Classes:

=> Inner classes are non-static classes, declared on an enclosing class at the member level.

=> Inner classes can have any of the four valid access modifiers:
1.public
2.private
3.protected
4.No modifier at all, which makes them package private

=> An inner class has access to instance members, including private members of the enclosing
class

=> Instantiating the inner class from external code is a bit tricky.

=> As of JDk16, static members of all types are supported on inner classes.

=> To create an instance of an inner class, you first need to have an instance of an enclosing
class (outer class)

Eg : EnclosingClass outerClass = new EnclosingClass();
EnclosingClass.InnerClass innerClass = outerClass.new InnerClass();

=> From that instance you call .new, followed by the inner class name and the parentheses,
taking any constructor arguments.

=> Many times, an inner class is never accessed, or instantiated from outside enclosing class,
but you should be familiar with this syntax.

=> One bonus for nested classes is that both the inner class and the outer class have direct access to the
other's instance members