//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Masukkan nama anda: ");
    String nama = sc.nextLine();
    System.out.print("Masukkan alamat anda: ");
    String alamat = sc.nextLine();
    System.out.print("Masukkan umur anda: ");
    int umur = sc.nextInt();

    System.out.println("===== Biodata =====");
    System.out.println("Nama \t: " + nama);
    System.out.println("Alamat \t: " + alamat);
    System.out.println("Umur \t: " + umur);
    System.out.println("===== ===== =====");

}