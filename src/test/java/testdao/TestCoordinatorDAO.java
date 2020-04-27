package testdao;

import com.standardeleven.project.dataaccess.dao.CoordinatorDAO;
import com.standardeleven.project.dataaccess.idao.ICoordinatorDAO;
import com.standardeleven.project.logical.Coordinator;

public class TestCoordinatorDAO {
    private static ICoordinatorDAO iCoordinatorDAO = new CoordinatorDAO();

    public static void main(String[] args) {

    }

    public static void addCoordinator() {
        Coordinator coordinator = new Coordinator();
    }

    public static void print(String string) {
        System.out.println(string);
    }
    public static void printTestTitle(String testTitle) {
        System.out.println(String.format("----- %s -----", testTitle));
    }
}
