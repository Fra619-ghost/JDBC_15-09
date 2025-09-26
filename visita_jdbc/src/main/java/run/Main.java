package run;

import dao.VisitDao;
import modelo.Visit;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VisitDao dao = new VisitDao();

        try {
            // Crear una nueva visita
            Visit nueva = new Visit();
            nueva.setVisitorName("Juan Pérez");
            nueva.setVisitorDocument("001-230998-0001A");
            nueva.setVisitorEmail("juanperez@gmail.com");
            nueva.setHostName("Lic. Ramírez");
            nueva.setReason("Entrega de papelería");

            dao.createVisit(nueva);

            // Cerrar visita con ID 1
            dao.closeVisit(1);

            // Listar todas las visitas
            List<Visit> visitas = dao.listAll();
            for (Visit v : visitas) {
                System.out.println(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
