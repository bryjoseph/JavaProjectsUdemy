package com.interfacesAndAbstractClasses;

import java.util.List;

public interface ISavable {

    // returning the list of values
    List<String> write();
    // reading the list of saved values
    void read(List<String> savedValues);

    // my own personal method to implement
    // void saveScore(int playerScore);

}
