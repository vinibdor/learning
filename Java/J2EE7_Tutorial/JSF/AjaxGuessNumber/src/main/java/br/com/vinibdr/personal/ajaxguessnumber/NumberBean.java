package br.com.vinibdr.personal.ajaxguessnumber;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by vinib on 22/04/2017.
 */
@Named (value = "userNumberBean")
@RequestScoped
public class NumberBean implements Serializable {

    private static final long serialVersionUID = 5913728353335224751L;
    private Integer userNumber = null;

    @Inject
    private DukesNumberBean dukesNumberBean;

    public Integer getUserNumber(){
        return userNumber;
    }

    public void setUserNumber(Integer userNumber){
        this.userNumber = userNumber;
    }

    public String getResponse(){
        if ((userNumber != null) && (userNumber.compareTo(dukesNumberBean.getRandomInt()) == 0)) {
            return "Yay! You got it!";
        }
        if (userNumber == null) {
            return null;
        }
        return "Sorry, " + userNumber + " is incorrect.";
    }
}
