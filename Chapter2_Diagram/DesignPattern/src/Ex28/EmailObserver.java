/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex28;

/**
 *
 * @author snow
 */
public class EmailObserver extends Observer {

    public EmailObserver(Account account) {
        this.account = account;
        this.account.attach(this);
    }

    @Override
    public String update() {
        return "Email: Ngan hang abc kinh chao quy khach. Tai khoan cua quy khach"
                + " da thay doi.\nSo du hien tai la: " + this.account.getState() + " vnd";
    }
}
