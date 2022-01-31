package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> map = new TreeMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee newEmployee;
            if (tokens.length == 4) {
                newEmployee = new Employee(name, salary, position, department);
            } else if (tokens.length == 5) {
                if (isNumeric(tokens[4])) {
                    // if we have age without email
                    newEmployee = new Employee(name, salary, position, department, Integer.parseInt(tokens[4]));
                } else {
                    //if we have email without age
                    newEmployee = new Employee(name, salary, position, department, tokens[4]);
                }
            } else {
                newEmployee = new Employee(name, salary, position, department, tokens[4], Integer.parseInt(tokens[5]));
            }
            map.putIfAbsent(department, new ArrayList<>());
            List<Employee> employees = map.get(department);
            employees.add(newEmployee);

        }
        double maxSalary = 0;
        String nameOfDepartment = null;
        for (Map.Entry<String, List<Employee>> stringListEntry : map.entrySet()) {
            double currentSalary = stringListEntry.getValue().stream().mapToDouble(Employee::getSalary).sum();
            if (currentSalary > maxSalary) {
                maxSalary = currentSalary;
                nameOfDepartment = stringListEntry.getKey();
            }
        }

        System.out.printf("Highest Average Salary: %s%n", nameOfDepartment);
        List<Employee> employees = map.get(nameOfDepartment);
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        employees.forEach(System.out::println);

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
