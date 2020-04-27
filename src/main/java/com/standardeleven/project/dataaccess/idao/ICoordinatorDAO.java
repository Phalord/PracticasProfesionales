package com.standardeleven.project.dataaccess.idao;

import java.sql.SQLException;
import com.standardeleven.project.logical.Coordinator;
import java.util.List;

public interface ICoordinatorDAO {
    public List<Coordinator> getAllCoordinators();
    public boolean addCoordinator(Coordinator coordinator);
    public boolean updateCoordinator(Coordinator coordinator);
    public boolean deleteCoordinator(Coordinator coordinator);
}
