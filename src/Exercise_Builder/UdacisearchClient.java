package Exercise_Builder;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Objects;

public final class UdacisearchClient implements Serializable {
    private final String name;
    private final long id;
    private final int quarterlyBudget;
    private final int numEmployees;
    private final Instant contractStart;
    private final Duration contractLength;
    private final ZoneId timeZone;
    private final String billingAddress;

    private UdacisearchClient(
            String name,
            long id,
            int quarterlyBudget,
            int numEmployees,
            Instant contractStart,
            Duration contractLength,
            ZoneId timeZone,
            String billingAddress) {
        this.name = name;
        this.id = id;
        this.quarterlyBudget = quarterlyBudget;
        this.numEmployees = numEmployees;
        this.contractStart = contractStart;
        this.contractLength = contractLength;
        this.timeZone = timeZone;
        this.billingAddress = billingAddress;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public int getQuarterlyBudget() {
        return quarterlyBudget;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public Instant getContractStart() {
        return contractStart;
    }

    public Duration getContractLength() {
        return contractLength;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    @Override
    public String toString() {
        return "UdacisearchClient{" +
                "name='" + getName() + '\'' +
                ", id=" + getId() +
                ", quarterlyBudget=" + getQuarterlyBudget() +
                ", numEmployees=" + getNumEmployees() +
                ", contractStart=" + getContractStart() +
                ", contractLength=" + getContractLength() +
                ", timeZone=" + getTimeZone() +
                ", billingAddress='" + getBillingAddress() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UdacisearchClient)) return false;
        UdacisearchClient that = (UdacisearchClient) o;
        return id == that.id &&
                quarterlyBudget == that.quarterlyBudget &&
                numEmployees == that.numEmployees &&
                name.equals(that.name) &&
                contractStart.equals(that.contractStart) &&
                contractLength.equals(that.contractLength) &&
                timeZone.equals(that.timeZone) &&
                billingAddress.equals(that.billingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                id,
                quarterlyBudget,
                numEmployees,
                contractStart,
                contractLength,
                timeZone,
                billingAddress);
    }

    public static class Builder{
        private String name = "";
        private long id = 0;
        private int quarterlyBudget = 0;
        private int numEmployees = 0;
        private Instant contractStart = Instant.EPOCH;
        private Duration contractLength = Duration.ZERO;
        private ZoneId timeZone = ZoneId.of("Etc/UTC");
        private String billingAddress = "";

        Builder setName(String name){this.name = name; return this;}
        Builder setID(long id){this.id = id; return this;}
        Builder setQuarterlyBudget(int quarterlyBudget){this.quarterlyBudget = quarterlyBudget; return this;}
        Builder setNumEmployees(int numEmployees){this.numEmployees = numEmployees; return this;};
        Builder setContractStart(Instant contractStart){this.contractStart = contractStart; return this;}
        Builder setContractLength(Duration contractLength){this.contractLength = contractLength; return this;}
        Builder setTimeZone(ZoneId timeZone){this.timeZone = timeZone; return this;};
        Builder setBillingAddress(String billingAddress){this.billingAddress = billingAddress; return this;}

        UdacisearchClient build(){
            return new UdacisearchClient(this.name, this.id, this.quarterlyBudget, this.numEmployees, this.contractStart,
                    this.contractLength, this.timeZone, this.billingAddress);
        }
    }
}
