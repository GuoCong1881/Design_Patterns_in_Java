package DependencyInjection;

import com.google.inject.AbstractModule;

import java.time.Clock;

public final class ExpirationCheckerModule extends AbstractModule {

    /**
     * The purpose of this module is to tell Guice (the dependency injection framework) which implementations
     * it should use for each dependency your ExpirationChecker needs to inject. This code tells Guice to use the
     * "real" system clock and metadata fetcher for the Clock and MetadataFetcher dependencies.
     *
     * In the ExpirationChecker, we're injecting two dependencies (Clock clock, MetadataFetcher metadataFetcher).
     * We need to tell Guice how to satisfy those dependencies
     */

    @Override
    protected void configure() {
        // TODO: Fill this module in:
        //       1. Bind the Clock interface to Clock.systemUTC()
        //       2. Bind the MetadataFetcher interface to MetadataFetcherImpl

        /**
         * we are binding the clock dependency to a specific instance, which is the system clock
        * we're binding it to a specific instance, which means that whenever something in this program injects a clock,
        * it's actually going to get a singleton, which is the system clock
        */
        bind(Clock.class).toInstance(Clock.systemUTC());
        /**
         * For metadataFetcher, instead of binding to a specific instance, we are binding it to a class.
         * This means when you inject the metadataFetcher interface, Guice will create a new instance of metadataFetcherImple
         * every single time
         */
        bind(MetadataFetcher.class).to(MetadataFetcherImpl.class);
    }
}
