package Interfaces;

import ma02_resources.project.Edition;

public interface EditionsController {
    void addEdition(Edition edition);

    boolean removeEdition(Edition edition);

    Edition getEdition(Edition edition);

    boolean setStatus(Edition edition);
}
