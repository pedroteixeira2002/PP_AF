package Interfaces;

import ma02_resources.project.Edition;
import ma02_resources.project.Status;

public interface EditionsController {
    void addEdition(Edition edition);

    boolean removeEdition(Edition edition);

    Edition getEdition(Edition edition);

}
