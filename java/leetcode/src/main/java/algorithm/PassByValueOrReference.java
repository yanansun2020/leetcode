package algorithm;

import org.junit.Test;

public class PassByValueOrReference {
    @Test
    public void test() {
        Dog dog = new Dog("Kitty");
        foo(dog);
        System.out.println(dog.name);//print out Max


        //Keeping in mind that myDog is a pointer, and not an actual Dog, so myDog will not change.
        // myDog still has the original address; it’s still pointing to the original Dog.
        Dog mydog = null;
        changeMyDog(mydog);
        if (mydog == null) {

            System.out.println("my dog is still empty");//this will be printed out
        } else {
            System.out.println("my dog is assigned");
        }

        //will still print out Kitty here
        Dog yourDog = new Dog("Kitty");
        changeMyDog(yourDog);
        System.out.println(yourDog.name);

    }

    private void changeMyDog(Dog dog) {
        Dog yourDog = new Dog("Sim");
        dog = yourDog;
        System.out.println("I'm in changeMyDog " + dog.name);
    }

    public void foo(Dog someDog) {  // AAA
        someDog.name = "Max";     // BBB
        someDog = new Dog("Fifi");  // CCC
        someDog.name = "Rowlf";   // DDD
    }
}

class Dog{
    String name;
    Dog(String name) {
        this.name = name;
    }
}
