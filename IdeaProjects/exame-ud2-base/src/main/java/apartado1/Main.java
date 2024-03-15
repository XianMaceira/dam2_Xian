package apartado1;

import java.sql.*;
import java.util.*;

public class Main {

    private static final String DB_URL = "jdbc:mysql://localhost/flights";
    private static final String USER = "root";
    private static final String PASSWORD = "abc123.";


    public static void main(String[] args) {

        try (Connection cn = DriverManager.getConnection(DB_URL, USER, PASSWORD)){
            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            System.out.print("Introduce a cantidade de viaxeiros: ");

            System.out.println();

            int pasajeros = sc.nextInt();
            String aeropuertos = getAeropuertos(cn).toString();
            System.out.println("Aeroportos de orixe: "+aeropuertos);
            System.out.print("Selecciona o aeroporto de orixe: ");

            String origen = sc2.nextLine();

            System.out.println();

            String aeropuertosDestino = getAeropuertosDestino(cn, origen).toString();
            System.out.println("Aeroportos de destino desde "+origen+": "+aeropuertosDestino);

            System.out.print("Aeroportos de destino: ");
            String destino = sc2.nextLine();

            System.out.println();
            String compañia_vuelo = getCompany(cn, origen, destino);
            String id_vuelo = getId(cn, origen, destino);
            System.out.println("Voo seleccionado: ["+ id_vuelo + "] " + origen+"-"+destino+" ("+compañia_vuelo+")");

            System.out.println();


            int total = getAsientosLibres(cn, id_vuelo);
            System.out.println("Asentos libres: "+total);

            if (pasajeros > total) {
                System.err.println("No quedan suficientes asientos");
            } else {

                String asientosAsignados = asignarAsientosLibres(cn, id_vuelo, pasajeros).toString();
                System.out.println("Asentos asignados: " + asientosAsignados);

                int restantes = total - pasajeros;
                System.out.println("Asentos restantes: " + restantes);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static Set<String> getAeropuertos (Connection con) {
        Set<String> airports = new HashSet<>();
        String query = "SELECT DISTINCT origin FROM flights";

        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                airports.add(rs.getString("origin"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return airports;
    }

    private static Set<String> getAeropuertosDestino (Connection con, String origen) {
        Set<String> airports = new HashSet<>();
        String query = "SELECT DISTINCT destination FROM flights WHERE origin = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, origen);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                airports.add(rs.getString("destination"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return airports;
    }

    private static String getCompany (Connection con, String origen, String destino) {
        int id_avion = 0;
        String compañia = "";
        String query = "SELECT plane_id FROM flights WHERE origin = ? AND destination = ?;";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, origen);
            ps.setString(2, destino);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id_avion = rs.getInt("plane_id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        query = "SELECT DISTINCT company FROM planes WHERE id = ?;";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id_avion);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compañia = rs.getString("company");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return compañia;
    }

    private static String getId (Connection con, String origen, String destino) {
        String id = "";
        String query = "SELECT id FROM flights WHERE origin = ? AND destination = ?;";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, origen);
            ps.setString(2, destino);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getString("id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return id;
    }

    private static int getAsientosLibres (Connection con, String id) {

        List<Integer> asientos = new ArrayList<>();
        int total;

        String query = "SELECT number " +
                "FROM seats WHERE flight_id = ?" +
                "AND assigned = 0;";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                asientos.add(rs.getInt("number"));
            }

            total = asientos.size();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return total;
    }

    private static List<Integer> asignarAsientosLibres (Connection con, String id, int asientosNecesarios) throws SQLException {

        List<Integer> asientos = new ArrayList<>();
        List<Integer> asientosAsignados = new ArrayList<>();

        String query = "SELECT number " +
                "FROM seats WHERE flight_id = ?" +
                "AND assigned = 0;";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                asientos.add(rs.getInt("number"));
            }

            Random r = new Random();
            for (int i = 0; i < asientosNecesarios;i++) {
                int valor = r.nextInt(0, asientos.size());
                asientosAsignados.add(asientos.get(valor));
                asientos.remove(valor);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return asientosAsignados;
    }


}
