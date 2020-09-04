public class PhoneNumber implements Comparable<PhoneNumber> {

    private String phoneNumber;
    //TODO: enums
    private String countryCode;
    private String serviceProvider;


    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        return this.phoneNumber.compareTo(phoneNumber.phoneNumber);
    }
}
