package dao;

import models.Visit;
import org.jetbrains.annotations.NotNull;
import utils.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitDao {

    public void createVisit(@NotNull Visit v) throws SQLException {
        String sql = "INSERT INTO visit (visitor_name, visitor_document, visitor_email, host_name, reason) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conexion.get();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, v.getVisitorName());
            ps.setString(2, v.getVisitorDocument());

            if (v.getVisitorEmail() == null) {
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setString(3, v.getVisitorEmail());
            }

            ps.setString(4, v.getHostName());
            ps.setString(5, v.getReason());

            ps.executeUpdate();
        }
    }

    public void closeVisit(long id) throws SQLException {
        String sql = "UPDATE visit SET visit_exit = NOW() WHERE id = ? AND visit_exit IS NULL";

        try (Connection con = Conexion.get();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    public List<Visit> listAll() throws SQLException {
        String sql = "SELECT id, visitor_name, visitor_document, visitor_email, host_name, reason, " +
                "visit_entry, visit_exit FROM visit ORDER BY visit_entry DESC";

        try (Connection con = Conexion.get();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            return mapAll(rs);
        }
    }

    private List<Visit> mapAll(ResultSet rs) throws SQLException {
        List<Visit> list = new ArrayList<>();

        while (rs.next()) {
            Visit v = new Visit();
            v.setId(rs.getLong("id"));
            v.setVisitorName(rs.getString("visitor_name"));
            v.setVisitorDocument(rs.getString("visitor_document"));
            v.setVisitorEmail(rs.getString("visitor_email"));
            v.setHostName(rs.getString("host_name"));
            v.setReason(rs.getString("reason"));

            Timestamp entry = rs.getTimestamp("visit_entry");
            Timestamp exit  = rs.getTimestamp("visit_exit");

            v.setVisitEntry(entry != null ? entry.toLocalDateTime() : null);
            v.setVisitExit(exit != null ? exit.toLocalDateTime() : null);

            list.add(v);
        }

        return list;
    }
}
