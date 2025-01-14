import java.util.Scanner;

public class kalkuator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double angkapertama, angkakedua, hasil = 0;
        int aritmatika = 0;
        String continueChoice;

        do {
            System.out.println("Pilihan Operator Aritmatika");
            System.out.println("1. Pertambahan");
            System.out.println("2. Pengurangan");
            System.out.println("3. Perkalian");
            System.out.println("4. Pembagian");

            System.out.print("Operator yang dipilih : ");
            aritmatika = input.nextInt();

            System.out.print("Input nilai 1 : ");
            angkapertama = input.nextDouble();

            System.out.print("Input nilai 2 : ");
            angkakedua = input.nextDouble();

            switch (aritmatika) {
                case 1:
                    hasil = angkapertama + angkakedua;
                    System.out.println("Hasil Penjumlahan : " + hasil);
                    break;

                case 2:
                    hasil = angkapertama - angkakedua;
                    System.out.println("Hasil Pengurangan : " + hasil);
                    break;

                case 3:
                    hasil = angkapertama * angkakedua;
                    System.out.println("Hasil Perkalian : " + hasil);
                    break;

                case 4:
                    if (angkakedua != 0) {
                        hasil = angkapertama / angkakedua;
                        System.out.println("Hasil Pembagian : " + hasil);
                    } else {
                        System.out.println("Hasil Tidak Terdefinisi");
                    }
                    break;

                default:
                    System.out.println("Tidak Ada Operator");
                    break;
            }

            System.out.print("Apakah Anda ingin melanjutkan? (ya/tidak): ");
            continueChoice = input.next();

        } while (continueChoice.equalsIgnoreCase("ya"));

        System.out.println("Terima kasih telah menggunakan kalkulator.");
    }
}

