import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Uppgift1 {
    public static void main(String[] args) {
        System.out.println("- Assignment 1: Staff register -");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Create relevant ArrayLists
        ArrayList<String> staffNames = new ArrayList<String>();
        ArrayList<Double> staffSalaries = new ArrayList<Double>();
        ArrayList<String> staffDepartments = new ArrayList<String>();

        // Add some staff members
        addNewEmployee(staffNames, staffSalaries, staffDepartments, "Alexander", random.nextDouble(10000, 50000), "A");
        addNewEmployee(staffNames, staffSalaries, staffDepartments, "James", random.nextDouble(10000, 50000), "B");
        addNewEmployee(staffNames, staffSalaries, staffDepartments, "Natdanai", random.nextDouble(10000, 50000), "C");
        addNewEmployee(staffNames, staffSalaries, staffDepartments, "Sebastian", random.nextDouble(10000, 50000), "A");
        addNewEmployee(staffNames, staffSalaries, staffDepartments, "Valentin", random.nextDouble(10000, 50000), "B");
        addNewEmployee(staffNames, staffSalaries, staffDepartments, "Alexandra", random.nextDouble(10000, 50000), "C");

        // Main menu-loop
        boolean flag = true;
        while (flag) {
            int menuChoice;
            do {
                System.out.println("\n1. Add new employee");
                System.out.println("2. Show all employees");
                System.out.println("3. Search employee");
                System.out.println("4. Show average salary");
                System.out.println("5. Show highest salary");
                System.out.println("6. Check department employee count");
                System.out.println("0. Exit");
                System.out.print(": ");
            } while ((menuChoice = scanner.nextInt()) < 0 || menuChoice > 6);

            switch (menuChoice) {
                case 0:
                    flag = false;
                    break;
                case 1: // Add new employee
                    System.out.print("New employee name: ");
                    String newEmployeeName = scanner.next();
                    System.out.print("New employee salary: ");
                    double newEmployeeSalary = scanner.nextDouble();
                    System.out.print("New employee department: ");
                    String newEmployeeDepartment = scanner.next();
                    addNewEmployee(
                            staffNames,
                            staffSalaries,
                            staffDepartments,
                            newEmployeeName,
                            newEmployeeSalary,
                            newEmployeeDepartment
                    );
                    break;
                case 2: // Show all employees
                    printAllEmployees(staffNames, staffSalaries, staffDepartments);
                    break;
                case 3: // Search employee
                    while (true) {
                        String search;
                        do {
                            System.out.print("Search for employee (or \"exit\"): ");
                        } while ((search = scanner.next()).isEmpty());

                        System.out.println(getEmployeeSearchString(staffNames, search));

                        if (search.equals("exit"))
                            break;
                    }
                    break;
                case 4: // Show average salary
                    System.out.printf("Average staff salary: %.2f\n", getAverageSalary(staffSalaries));
                    break;
                case 5: // Show the highest salary
                    System.out.printf("Highest salary: %.2f\n", getHighestSalary(staffSalaries));
                    break; // Check department employee count
                case 6:
                    String search;
                    do {
                        System.out.print("Enter department: ");
                    } while ((search = scanner.next()).isEmpty());
                    int depCount = employeesInDepartment(staffDepartments, search);
                    System.out.printf("Found %d employees in department \"%s\"", depCount, search);
                    break;
            }
        }
    }

    public static void addNewEmployee(
            ArrayList<String> staffNames,
            ArrayList<Double> staffSalaries,
            ArrayList<String> staffDepartments,
            String name,
            double salary,
            String department
    ) {
        staffNames.add(name);
        staffSalaries.add(salary);
        staffDepartments.add(department);
        System.out.printf("Added %s (%.2f) to %s!\n", name, salary, department);
    }

    public static void printAllEmployees(
            ArrayList<String> staffNames,
            ArrayList<Double> staffSalaries,
            ArrayList<String> staffDepartments
    ) {
        System.out.println("All employees: ");
        for (int i = 0; i < staffNames.size(); i++) {
            System.out.printf(
                    "%d. %s (%.2f) | %s\n",
                    i + 1,
                    staffNames.get(i),
                    staffSalaries.get(i),
                    staffDepartments.get(i));
        }
    }

    public static String getEmployeeSearchString(ArrayList<String> staffNames, String search) {
        String result = "";
        for (String name : staffNames)
            if (name.contains(search))
                result += name + "\n";
        return result;
    }

    public static double getAverageSalary(ArrayList<Double> staffSalaries) {
        double totalSalary = 0;
        for (double salary : staffSalaries)
            totalSalary += salary;
        return totalSalary / (double) staffSalaries.size();
    }

    public static double getHighestSalary(ArrayList<Double> staffSalaries) {
        double highestSalary = 0;
        for (double salary : staffSalaries)
            if (salary > highestSalary)
                highestSalary = salary;
        return highestSalary;
    }

    public static int employeesInDepartment(
            ArrayList<String> staffDepartments,
            String department
    ) {
        int employeeCountInDepartment = 0;
        for (var dep : staffDepartments)
            if (dep.equals(department))
                employeeCountInDepartment++;
        return employeeCountInDepartment;
    }
}
