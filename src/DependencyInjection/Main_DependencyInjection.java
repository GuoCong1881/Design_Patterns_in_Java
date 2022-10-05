package DependencyInjection;

public class Main_DependencyInjection {

    /**
     * What is Dependency Inejction?
     *
     * - DI is a design pattern that moves the creation of dependencies to outside of your code
     * - instead of creating objects, you tell the DI framework to create the objects for you
     * and inject them into your class
     *
     * How DI inejcts Objects
     *
     * The DI framework will attempt to instantiate any object that's injected. The DI framework will fail at runtime
     * if it doesn't know how to create the injected object. DI frameworks use modules to configure which classes or
     * objects should be used when an interface is injected.
     *
     * Indirect Dependencies
     *
     * DI also takes care of indirect, or transitive, dependencies. If you @Inject a class, and that class also has
     * a constructor marked with @Inject, the DI framework will try to inject all the constructor dependencies,
     * and all those dependencies' dependencies, and so on.
     *
     * Using DI to create singletons
     *
     * DI frameworks can usually be configured to return a specific instance of an object whenever it's injected.
     * Any time that object is requested by an @Inject annotation, the DI framework will supply the exact same instance, making it effectively a singleton.
     */

    /**
     * Expiration Manager
     *
     * Your company Udacisearch runs lots of web crawls for its SEO product. Most of these crawls produce some kind of
     * file output. You don't want to delete these files immediately (What if you need them later to review the
     * results of a recent crawl?), but once one of these files has been around for more than 30 days without being
     * touched, chances are you will never need it again.
     *
     * You created a small program that checks whether a list of files has expired, or reached its 30-day limit.
     * If any of the input files are expired, your program prints out their file names so you can delete them.
     * In a real-world context, this technique is known as a TTL, or "Time to Live". TTLs are a common way for large
     * systems to manage limited disk space and make sure it's not all being taken up by very old files that are never
     * used. In the real world. In this example, the TTL is checked manually, but in many systems it happens as part
     * of an automatic process.
     *
     * OK, so you coded up this ExpirationChecker class, but you ran into a problem: How are you going to unit test it?
     * ExpirationChecker depends on file metadata (last modified time) and the system time (to check whether the last
     * modified time is expired, based on the current time), so how are you supposed to write a unit test? Do you just
     * have old files sitting around on a test machine that can be used in test cases? No, that won't do — what if
     * those files are accidentally deleted, or what if the expiration time changes?
     *
     *
     * After a while of thinking, you decide it's probably best to rewrite your ExpirationChecker class to use
     * dependency injection. Designing the code this way will allow you to inject real implementations of dependencies
     * when running the program for real, and to use fake dependencies when running unit tests.
     *
     * You can learn more about test fakes and other test doubles in the Java Application Deployment course.
     * You don't need to know the details for this exercise, but suffice it to say they can make unit testing
     * much easier!
     *
     * For this exercise, you will use Guice, which is an open source dependency injection framework for Java.
     *
     *
     * Getting started
     *
     * For starters, you need to refactor the ExpirationChecker class to be compatible with dependency injection.
     *
     * 1. First, annotate the constructor with the @Inject annotation.
     * 2. Create an instance field for a java.time.Clock and make the ExpirationChecker constructor take arguments for
     * each of its instance fields. The body of the constructor should assign values to the instance fields.
     * 3. Now you need to change the code for ExpirationChecker#isExpired() to use the new Clock field instead of
     * Instant.now() to get the current time. By doing this, you will be able to use a fake Clock implementation
     * in tests, to control what ExpirationChecker thinks is the current time. (A FakeClock has already been
     * implemented for you, by the way.)
     * 4. Now, fill in ExpirationCheckerModule.java. The purpose of this module is to tell Guice (the dependency
     * injection framework) which implementations it should use for each dependency your ExpirationChecker needs
     * to inject. The final configure() method should look like this:
     *      bind(Clock.class).toInstance(Clock.systemUTC());
     *      bind(MetadataFetcher.class).to(MetadataFetcherImpl.class);
     *
     * This code tells Guice to use the "real" system clock and metadata fetcher for the Clock and
     * MetadataFetcher dependencies.
     * 5. Next, update Main.java to use Guice. You will have to create a new dependency injection container
     * (which is called an Injector in Guice terminology) that uses the module you just created: Guice.createInjector(new ExpirationCheckerModule()), and then get an instance of the ExpirationChecker by using Injector#getInstance(ExpirationChecker.class). This code should no longer be calling the ExpirationChecker constructor.
     * 6. Make sure Main.java compiles: javac Main.java. Congratulations! You successfully used dependency
     * injection to create an instance of your class.
     *
     *
     * Writing the Test
     * Now it's time to finish writing the unit test your class. Open up ExpirationCheckerTest.java to get started.
     * In the real world, you would be using a unit testing framework to do this, but to keep things simpler
     * in this exercise, a "regular" main() method will do just fine.
     *
     * 1. Find the code that instantiates the ExpirationChecker for the test. Change this code to use a Guice
     * Injector to instantiate the ExpirationChecker instead. You'll have to configure this injector to use
     * the FakeClock and FakeMetadataFetcher implementations. There is a terse way to do this in Guice using
     * the Module interface, which is compatible with lambdas:
     *      Injector injector = Guice.createInjector(
     *      b -> b.bind(Clock.class).toInstance(fakeClock),
     *      b -> b.bind(MetadataFetcher.class).toInstance(fakeMetadataFetcher));
     * Notice how you were able to swap out the ExpirationChecker's dependencies with fake implementations very easily!
     * 2. Finally, run the test and make sure it passes.
     *      javac *.java
     *      java -ea ExpirationCheckerTest
     *
     * The test should pass, which means you should not see anything printed to the command-line.
     * You will know it failed if the test throws an AssertionError.
     */
}
