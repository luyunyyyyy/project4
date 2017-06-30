package main;

import java.util.ArrayList;

/**
 * Created by lyy on 2017/6/29.
 */
public class MFD {
    private String userName;

    public MFD(String userName, ArrayList<UFD> ufds) {
        this.userName = userName;
        this.ufds = ufds;
    }

    public MFD(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<UFD> getUfds() {
        return ufds;
    }

    public void setUfds(ArrayList<UFD> ufds) {
        this.ufds = ufds;
    }

    private ArrayList<UFD> ufds;

}
