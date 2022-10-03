package Exercise_Builder;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public final class Main {


    /**
     * UdacisearchClient class has a constructor with lots of parameters. Furthermore, it's a mutable class.
     * It's the perfect candidate for the Builder Pattern.
     *
     * This should be a fairly straightforward procedure — you are going to take the UdacisearchClient class and
     * make a Builder class for it. This will provide the following benefits:
     * 1. UdacisearchClient will become an immuable type,
     * which means its value does not change after it is created.
     * 2. The builder class will emulate named parameters. Unlike the large constructor, the builder makes it
     * harder for callers to accidentally mix up the order of the client properties.
     *
     *
     * Changes about UdacisearchClient class:
     * 1. make its constructor private instead of public
     * 2. make all instance fields final, and remove all setter methods, delete the default values of the fields
     * 3. give UdacisearchClient a static inner class called Buidler. Give the buidler class
     * a non-final instance field corresponding to each field of UdacisearchClient
     * 4. create setter methods for all the builder's fields
     * 5. add a UdacisearchClient.Builder#build() method that calls the private UdacisearchClient constructor
     * 6. Update Main to use the new UdacisearchClient.Builder, instead of the UdacisearchClient constructor,
     * to build the value of client variable
     */
    public static void main(String[] args) {

        UdacisearchClient.Builder b = new UdacisearchClient.Builder()
                .setQuarterlyBudget(8000)
                .setNumEmployees(5)
                .setContractStart(Instant.now())
                .setContractLength(Duration.ofDays(180))
                .setTimeZone(ZoneId.of("America/Los_Angeles"))
                .setBillingAddress("555 Meowmers Ln, Riverside, CA 92501");

        UdacisearchClient client = b.setName("Irene").setID(1881L).build();
        System.out.println(client);
    }
}
