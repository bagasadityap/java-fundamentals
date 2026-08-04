package mvc.view;

import mvc.controller.EmployeeController;
import mvc.model.Employee;

import java.util.Scanner;

public class EmployeeView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeController controller = new EmployeeController();

        int menu = -1;

        while (menu != 0) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Tambah Employee");
            System.out.println("2. Tampilkan Semua Employee");
            System.out.println("3. Cari Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Hapus Employee");
            System.out.println("0. Exit");
            System.out.print("Pilih Menu : ");

            menu = Integer.parseInt(sc.nextLine());

            if (menu == 1) {
                System.out.println("\n=== Tambah Employee ===");

                System.out.print("Nama : ");
                String name = sc.nextLine();

                System.out.print("ID Number : ");
                String id = sc.nextLine();

                System.out.print("Umur : ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Direktorat : ");
                String directorate = sc.nextLine();

                Employee employee = new Employee(name, id, age, directorate);

                if (controller.addEmployee(employee)) {
                    System.out.println("Data berhasil ditambahkan.");
                } else {
                    System.out.println("Data gagal ditambahkan.");
                }
            } else if (menu == 2) {
                System.out.println("\n=== Daftar Employee ===");

                if (controller.getAllEmployees().isEmpty()) {
                    System.out.println("Belum ada data.");
                } else {
                    for (Employee emp : controller.getAllEmployees()) {
                        System.out.println("-------------------------");
                        System.out.println("Nama        : " + emp.getName());
                        System.out.println("ID Number   : " + emp.getIdNumber());
                        System.out.println("Umur        : " + emp.getAge());
                        System.out.println("Direktorat  : " + emp.getDirectorate());
                    }
                }

            } else if (menu == 3) {
                System.out.print("Masukkan ID Number : ");
                String id = sc.nextLine();
                Employee emp = controller.getEmployeeById(id);

                if (emp != null) {
                    System.out.println("\n=== Data Employee ===");
                    System.out.println("Nama        : " + emp.getName());
                    System.out.println("ID Number   : " + emp.getIdNumber());
                    System.out.println("Umur        : " + emp.getAge());
                    System.out.println("Direktorat  : " + emp.getDirectorate());
                } else {
                    System.out.println("Data tidak ditemukan.");
                }
            } else if (menu == 4) {
                System.out.print("Masukkan ID Number yang akan diupdate : ");
                String id = sc.nextLine();

                System.out.print("Nama Baru : ");
                String name = sc.nextLine();

                System.out.print("Umur Baru : ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Direktorat Baru : ");
                String directorate = sc.nextLine();

                Employee employee = new Employee(name, id, age, directorate);

                if (controller.updateEmployee(id, employee)) {
                    System.out.println("Data berhasil diupdate.");
                } else {
                    System.out.println("Data gagal diupdate.");
                }
            } else if (menu == 5) {
                System.out.print("Masukkan ID Number yang akan dihapus : ");
                String id = sc.nextLine();

                if (controller.deleteEmployee(id)) {
                    System.out.println("Data berhasil dihapus.");
                } else {
                    System.out.println("Data gagal dihapus.");
                }
            } else if (menu == 0) {
                System.out.println("Terima kasih.");
            } else {
                System.out.println("Menu tidak tersedia.");
            }
        }
        sc.close();
    }
}