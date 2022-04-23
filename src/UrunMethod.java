import java.util.*;

public class UrunMethod extends UrunListesi {
    public static Map<Integer, String> urunListesi = new HashMap<>();

    public static void girisEkrani() {

        System.out.println("Yapmak istediginiz islemi seciniz:\n1- Urun Tanimlama\n2- Urun Listeleme\n3- Urun Girisi\n4- Urunu Rafa Koy" +
                "\n5- Urun Cikisi\n6- Programdan cikis ");
        String secim = scan.next();
        switch (secim) {
            default:
                System.out.println("Hatali giris yaptiniz. lutfen tekrar deneyiniz.");
                girisEkrani();
                break;
            case "1":
                scan.nextLine();
                urunTanimlama();
                break;
            case "2":
                urunListele();
                break;
            case "3":
                urunGirisi();
                break;
            case "4":
                urunuRafaKoy();
                break;
            case "5":
                urunCikisi();
                break;
            case "6":
                cikis();
                break;

        }
    }


    public static void urunTanimlama() {
        System.out.print("Urun ismini giriniz:");
        String urunAdi = scan.nextLine();
        System.out.print("Ureticiyi giriniz:");
        String ureticiAdi = scan.nextLine();
        System.out.print("Birim giriniz:");
        String urunBirim = scan.next();
        UrunListesi urun = new UrunListesi(urunAdi, ureticiAdi, urunBirim, urunId);

        urunListesi.put(urunId++, urun.getUrunAdi() + " - " + urun.getUreticiAdi() +
                " - " + urun.getUrunBirim() + " - " + urun.getUrunMiktari() + " - " + urun.getRafNumarasi());


        // urunId++;


        urunListele();
        girisEkrani();


    }

    public static void urunListele() {

        Set<Integer> urunListesiKeyseti = urunListesi.keySet();
        List<Integer> keyList = new ArrayList<>();
        keyList.addAll(urunListesiKeyseti);


        List<String> valueList = new ArrayList<>();
        valueList.addAll(urunListesi.values());


        String arrayMDList[][] = new String[0][];
        try {
            arrayMDList = new String[valueList.size()][valueList.get(0).split(" - ").length];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Depo suanda bos.Lutfen once urun tanimlayin");
            girisEkrani();
        }
        System.out.println(" id       ismi      ureticisi    birimi    miktari      raf");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < arrayMDList.length; i++) {
            String tempArr[] = valueList.get(i).split(" - ");
            System.out.printf("%-9d", keyList.get(i));

            for (int j = 0; j < arrayMDList[i].length; j++) {
                arrayMDList[i][j] = tempArr[j];

                System.out.printf("%-12s", arrayMDList[i][j]);
            }
            System.out.println();
        }
        girisEkrani();
    }

    public static void urunGirisi() {
        System.out.println("giris yapmak istediginiz urunun id'sini giriniz:");
        int urunId = 0;
        try {
            urunId = scan.nextInt();
            //1001
            if (urunId < 1000 || urunId > 9999) {
                System.out.println("Urun id 1000-9999 arasinda olmalidir");
                urunGirisi();
            }
        } catch (Exception e) {
            String hataliGiris = scan.nextLine();
            System.out.println("Urun id'yi hatali girdiniz. tekrar deneyiniz");
            urunGirisi();
        }
        int miktar = 0;
        while (true) {
            System.out.println("miktar giriniz");

            try {
                miktar = scan.nextInt();
                break;
            } catch (Exception e) {
                String hataliGiris = scan.nextLine();
                System.out.println("Hatali giris yaptiniz. Miktar rakamlardan olusmali");

            }
        }

        Set<Integer> urunListesiKeyseti = urunListesi.keySet();
        List<Integer> keyList = new ArrayList<>();
        keyList.addAll(urunListesiKeyseti);

        String yeniMDarr[][] = mapValueArrayDonustur(urunListesi);

        for (int i = 0; i < yeniMDarr.length; i++) {
            if (keyList.get(i) == urunId) {

                yeniMDarr[i][3] = Integer.valueOf(yeniMDarr[i][3]) + miktar + "";
                String arrayMDList = "";
                for (String each : yeniMDarr[i]
                ) {
                    arrayMDList += each + " - ";
                    urunListesi.put(keyList.get(i), arrayMDList);
                }
            }
        }


        urunListele();
        girisEkrani();


    }

    public static void urunuRafaKoy() {
        System.out.println("Rafa koyacaginiz urunun id'sini giriniz:");
        int urunId = scan.nextInt();

        Set<Integer> urunListesiKeyseti = urunListesi.keySet();
        List<Integer> keyList = new ArrayList<>();
        keyList.addAll(urunListesiKeyseti);
        String yeniMDarr[][] = mapValueArrayDonustur(urunListesi);

        for (int i = 0; i < yeniMDarr.length; i++) {
            if (keyList.get(i) == urunId) {
                yeniMDarr[i][4] = "raf " + (keyList.get(i) % 10 + 1);
                String arrayMDList = "";
                for (String each : yeniMDarr[i]
                ) {
                    arrayMDList += each + " - ";
                    urunListesi.put(keyList.get(i), arrayMDList);
                }
            }

        }


        urunListele();
        girisEkrani();


    }

    public static void urunCikisi() {
        System.out.println("cikis yapmak istediginiz urunun id'sini giriniz:");
        int urunId = scan.nextInt();
        System.out.println("miktar giriniz");
        Integer miktar = scan.nextInt();
        Set<Integer> urunListesiKeyseti = urunListesi.keySet();
        List<Integer> keyList = new ArrayList<>();
        keyList.addAll(urunListesiKeyseti);
        String yeniMDarr[][] = mapValueArrayDonustur(urunListesi);

        for (int i = 0; i < yeniMDarr.length; i++) {
            if (keyList.get(i) == urunId) {
                yeniMDarr[i][3] = Integer.valueOf(yeniMDarr[i][3]) - miktar + "";
                String arrayMDList = "";
                for (String each : yeniMDarr[i]
                ) {
                    arrayMDList += each + " - ";
                    urunListesi.put(keyList.get(i), arrayMDList);
                }
            }

        }


        urunListele();
        girisEkrani();
    }

    public static String[][] mapValueArrayDonustur(Map<Integer, String> urunListesi) {


        Set<Integer> urunListesiKeyseti = urunListesi.keySet();
        List<Integer> keyList = new ArrayList<>();
        keyList.addAll(urunListesiKeyseti);

        List<String> valueList = new ArrayList<>();
        valueList.addAll(urunListesi.values());

        String arrayMDList[][] = new String[0][];
        try {
            arrayMDList = new String[valueList.size()][valueList.get(0).split(" - ").length];
        } catch (Exception e) {
            System.out.println("Depo suanda bos.Lutfen once urun tanimlayin");
            girisEkrani();
        }
        for (int i = 0; i < arrayMDList.length; i++) {
            String tempArr[] = valueList.get(i).split(" - ");

            for (int j = 0; j < arrayMDList[i].length; j++) {
                arrayMDList[i][j] = tempArr[j];
            }
        }
        return arrayMDList;
    }

    public static void cikis() {
        System.out.println("Depo programimizi kulladiginiz icin tesekkurler. Iyi gunler");
    }

}
