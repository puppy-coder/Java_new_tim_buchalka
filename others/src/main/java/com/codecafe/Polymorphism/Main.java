package com.codecafe.Polymorphism;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*We can just call this method(getMovie) , passing the type and name, and the
        right object type is instantiated and returned, but it's assigned to a variable
         with the movie type, so this code will work for any movie , or any of its subclasses
         that have not created yet. */

        /* This keeps all the information about Movie and it's subclasses , in the control
        of the movie class and simplifies the work that needs to be done, by the calling code
         */

        //This sounds like good encapsulation technique doesn't?

       // Movie theMovie = Movie.getMovie("Adventure", "Star Wars");
       // Movie theMovie = new Adventure(" Star Wars");
        //theMovie.watchMovie();

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter Type (A for Adventure, C for Comedy, " +
                    "S for Science Fiction, or Q to quit): ");
            String type = scanner.nextLine();
            if("Qq".contains(type)){
                break;
            }
            System.out.print("Enter Movie title:" );
            String title = scanner.nextLine();
            Movie movie = Movie.getMovie(type, title);
            /*
            The code called the method watchMovie() using a Movie reference variable.
            But at runtime, the Movie wasn't really a Movie, it was an instance of the
            subclass, the Adventure class. And it was the method watchMovie() that's
            actually depend on the Adventure class, that really got executed.

            --This is Polymorphism in action--!!

            Our compiled code, in the main method of the Main class, never knew
            anything about the Adventure class, or any of the subclasses.
            But at runtime, we got an object of type Adventure back from the
            factory method.

            Important Point! -- If we add any other new subclass, other than Adventure,
            Science Fiction and Comedy. Eg: Documentary. We are able to add easily without
            doing any change in Main method class.
             */
            movie.watchMovie();
        }
    }
}
