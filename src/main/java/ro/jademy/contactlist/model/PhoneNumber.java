package ro.jademy.contactlist.model;

import org.apache.commons.lang3.StringUtils;
import ro.jademy.contactlist.enums.ServiceProvider;

import java.util.Objects;

public class PhoneNumber implements Comparable<PhoneNumber> {

    private String phoneNumber;
    private String countryCode;
    private ServiceProvider serviceProvider;


    public PhoneNumber(String phoneNumber, String countryCode, ServiceProvider serviceProvider) {
        this.phoneNumber = phoneNumber;
        this.countryCode = countryCode;
        this.serviceProvider = serviceProvider;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(countryCode, that.countryCode) &&
                serviceProvider == that.serviceProvider;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, countryCode, serviceProvider);
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        return this.phoneNumber.compareTo(phoneNumber.phoneNumber);
    }

    @Override
    public String toString() {
        return
                StringUtils.center(phoneNumber, 30, " ") +
                        StringUtils.center(countryCode, 10, " ") +
                        StringUtils.center(String.valueOf(serviceProvider), 15, " ");
    }
}
