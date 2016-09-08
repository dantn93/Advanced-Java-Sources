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
public class MobiObserver extends Observer {

    public MobiObserver(Account account) {
        this.account = account;
        this.account.attach(this);
    }

    @Override
    public String update() {
        return "Mobi: Xin chao. Tai khoan cua quy khach da thay doi. \n"
                + "So du hien tai la: " + this.account.getState()+" vnd";
    }
}
