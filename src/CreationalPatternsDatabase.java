import java.util.Objects;

    /**
     * Creational design pattern:
     *
     * is any design pattern that concerns how objects in your program are created.
     * These patterns can help you manage the creation of objects as your code becomes increasingly complex.
     *
     * Scenario: Singleton
     *
     * You may want to use a singleton if:
     * - A class that has only one instance, but no clear owner.
     * - You want that instance to be available everywhere in your code.
     * - The instance is initialized only when it's first used (also known as lazy initialization).
     */

    public final class CreationalPatternsDatabase{
    /**
    final: to make sure the class can't be extended
     */
        private static CreationalPatternsDatabase database;

        private CreationalPatternsDatabase() {}
        /**
         * private constructor: to make sure the class has only one instance
          */
        public static CreationalPatternsDatabase getInstance(){
            if (database == null){
                database = new CreationalPatternsDatabase();
                database.connect("/");
            }
            return database;
        }
        /**
         * lazy initialization: database connect is only established when the getInstance is called
         */


        private void connect(String url){
            Objects.requireNonNull(url);
        }

        public static void main(String[] args){
            CreationalPatternsDatabase a = CreationalPatternsDatabase.getInstance();
            CreationalPatternsDatabase b = CreationalPatternsDatabase.getInstance();
            System.out.println(a == b);
        }
    }
