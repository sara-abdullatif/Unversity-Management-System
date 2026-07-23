
package system_of_university;


public abstract class Person {

    private String name;
    private String address;
    protected long id;
    private long phone_number;
    private String email;

    public Person(String name, String address, long id, long phone_number, String email) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public abstract void displayinfo();

    public void updatecurrentinfo(String address) {
        this.address = address;
        this.phone_number = phone_number;

    }

    public void updatecurrentinfo(long phone_number) {
        this.phone_number = phone_number;
    }
}
