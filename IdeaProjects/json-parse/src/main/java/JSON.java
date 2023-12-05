

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;

public class JSON {
    public static void main(String[] args) {
        // Ruta al archivo JSON
        String filePath = "json.json";

        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            JsonObject companyJson = gson.fromJson(reader, JsonObject.class);

            // Mostrar información del JSON
            System.out.println("Root element: " + companyJson.keySet().iterator().next());

            JsonArray employees = companyJson.getAsJsonObject("company")
                    .getAsJsonArray("employee");

            for (JsonElement employee : employees) {
                JsonObject employeeObject = employee.getAsJsonObject();

                System.out.println("First Name: " + employeeObject.get("firstname").getAsString());
                System.out.println("Last Name: " + employeeObject.get("lastname").getAsString());
                System.out.println("Salary: " + employeeObject.get("salary").getAsInt());

                if (employeeObject.has("cars")) {
                    System.out.println("Cars:");
                    JsonArray cars = employeeObject.getAsJsonObject("cars")
                            .getAsJsonArray("car");
                    for (JsonElement car : cars) {
                        System.out.println("- " + car.getAsString());
                    }
                }

                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
