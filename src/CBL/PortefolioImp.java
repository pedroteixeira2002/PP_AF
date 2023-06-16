package CBL;

import Interfaces.EditionsController;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Task;
import ma02_resources.project.Status;

public class PortefolioImp implements EditionsController {
    private Edition[] editions;
    private int numberOfEditions;

    /**
     * @param edition
     */
    @Override
    public void addEdition(Edition edition) {

    }

    /**
     * @return the number of editions in the portfolio
     */
    public int getNumberOfEditions() {
        return numberOfEditions;
    }

    /**
     * @param edition
     * @return
     */
    @Override
    public boolean removeEdition(Edition edition) {
        return false;
    }

    /**
     * @param edition
     * @return
     */
    @Override
    public Edition getEdition(Edition edition) {
        return null;
    }

    /**
     * @param edition
     * @return
     */
    @Override
    public boolean setStatus(Edition edition) {
        return false;
    }


}

