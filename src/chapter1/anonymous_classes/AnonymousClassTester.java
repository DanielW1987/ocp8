package chapter1.anonymous_classes;

class HelloWorld { // superclass
    void displayMessage() {
        System.out.println("Hello World");
    }
}

class AnonymousClassTester {

    public static void main(String args[]){

        /*
         * Beispiel 1
         */
        HelloWorld hw1 = new HelloWorld() {
            void displayMessage() {
                System.out.println("Hello Earth");
            }
        };

        hw1.displayMessage(); // Ausgabe: Hello Earth

        /*
         * Beispiel 2
         */
        HelloWorld hw2 = new HelloWorld() {

            @Override
            void displayMessage() {
                System.out.println("Hello Earth");
            }

            // Kompiliert zwar, macht aber kein Sinn, da von außen nicht sichtbar. Der Referenztyp weiß nicht, dass es diese Methode gibt
            public void displayError() {
                System.out.println("Don\'t create new methods in an anonymous inner class.");
            }
        };
        hw2.displayMessage();
        // hw2.displayError(); => DOES NOT COMPILE


        /*
         * Beispiel 3
         */
        reallyStrange(new HelloWorld());    // Ausgabe: Hello World
        reallyStrange(new HelloWorld(){     // Ausgabe: Reaööy strange stuff

            @Override
            void displayMessage(){
                System.out.println("Really strange stuff!");
            }

        });
    }


    static void reallyStrange(HelloWorld hw){
        hw.displayMessage();
    }
}