package com.example.aaron.witnessprotection;

import android.app.Application;

/**
 * Created by aaron on 6/26/2016.
 */
public class Global extends Application {
    public int numberplayers;

    public int getNumberplayers(){
        return numberplayers;
    }
    public void setNumberplayers(int newnumberplayers){
        this.numberplayers = newnumberplayers;
    }

}
