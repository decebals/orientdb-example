package ro.fortsoft.orientdb.example.domain;

/**
 * @author Decebal Suiu
 */
public class Address {

    private String street;
    private String postcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String zip) {
        this.postcode = zip;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append("Address[");
        builder.append("street=").append(getStreet()).append(",");
        builder.append("postcode=").append(getPostcode());
        builder.append("]");
        
        return builder.toString();
    }

}
