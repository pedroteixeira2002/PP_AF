package Interfaces;

import cbl.EditionImp;
import ma02_resources.project.Edition;

public interface EditionsController {
    Edition[] getEditions();

    boolean removeEdition(String editionName);

    Edition getEdition(Edition edition);

    void addEdition(Edition edition) throws IllegalArgumentException;

}
