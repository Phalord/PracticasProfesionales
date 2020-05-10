package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.Coordinator;
import java.util.List;

public interface ICoordinatorDAO {
    List<Coordinator> getAllCoordinators();
    Coordinator getCoordinator(String coordinatorPersonalNumber);
    boolean addCoordinator(Coordinator coordinator);
    boolean updateCoordinator(Coordinator coordinator);
    boolean deleteCoordinator(Coordinator coordinator);
}
