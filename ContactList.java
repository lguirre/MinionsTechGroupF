/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanager;

import java.util.Vector;

/**
 *
 * @author veymarmc
 */
public class ContactList {
    private Vector list;

    public ContactList() {
        this.list = new Vector();
    }
    
    public void addContact(Contact contact) {
        list.add(contact);
    }
    
    public Vector getContacts() {
        return list;
    }
    
    public Vector searchContacts(String keyword) {
        Vector answer = new Vector();
        
        for (int i = 0; i < this.list.size(); i++) {
            if(((Contact)this.list.get(i)).containsKeyword(keyword)) {
                answer.add(this.list.get(i));
            }
        }
        
        return answer;
    }
}
