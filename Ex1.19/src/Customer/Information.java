// This is information of customer
package Customer;

/**
 * 
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 29/08/2016
 * 
 */
public class Information {
    private String address;
    private String email;
    private String idCardNum;
    private String name;
    private String phoneNum;

    public Information(String address, String email, String idCardNum, String name, String phoneNum) {
        this.address = address;
        this.email = email;
        this.idCardNum = idCardNum;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
}
