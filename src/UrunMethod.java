import java.util.*;

public class UrunMethod extends UrunListesi {
    public static Map<Integer, String> urunListesi = new HashMap<>();

    public static void girisEkrani() {

        System.out.println("Yapmak istediginiz islemi seciniz:\n 1- Urun Tanimlama\n2- Urun Listeleme\n3- Urun Girisi\n4- Urunu Rafa Koy" +
                "\n5- Urun Cikisi ");
        String secim = scan.next();
        switch (secim) {
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
            default:
                System.out.println("Hatali giris yaptiniz. lutfen tekrar deneyiniz.");
                girisEkrani();
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

        urunListesi.put(urunId, urun.getUrunAdi() + " - " + urun.getUreticiAdi() +
                " - " + urun.getUrunBirim() + " - " + urun.getUrunMiktari() + " - " + urun.getRafNumarasi());


        urunId++;


        urunListele();
        girisEkrani();


    }

    public static void urunListele() {

        Set<Integer> urunListesiKeyseti = urunListesi.keySet();
        List<Integer> keyList = new ArrayList<>();
        keyList.addAll(urunListesiKeyseti);

        List<String> valueList = new ArrayList<>();
        valueList.addAll(urunListesi.values());


        String arrayMDList[][] = new String[valueList.size()][valueList.get(0).split(" - ").length];
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
        int urunId = scan.nextInt();
        System.out.println("miktar giriniz");
        Integer miktar = scan.nextInt();
        Set<Integer> urunListesiKeyseti = urunListesi.keySet();
        List<Integer> keyList = new ArrayList<>();
        keyList.addAll(urunListesiKeyseti);
        String yeniMDarr[][] = mapValueArrayDonustur(urunListesi);

        for (int i = 0; i < yeniMDarr.length; i++) {
            if (keyList.get(i) == urunId) {
                yeniMDarr[i][3] = miktar.toString();
                String arrayMDList = "";
                for (String each : yeniMDarr[i]
                ) {
                    arrayMDList += each+" - " ;
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
                yeniMDarr[i][4] = "raf "+(keyList.get(i)%10+1);
                String arrayMDList = "";
                for (String each : yeniMDarr[i]
                ) {
                    arrayMDList += each+" - " ;
                    urunListesi.put(keyList.get(i), arrayMDList);
                }
            }

        }


        urunListele();
        girisEkrani();


    }

    public static void urunCikisi() {

    }

    public static String[][] mapValueArrayDonustur(Map<Integer, String> urunListesi) {
        urunListesi.keySet();
        urunListesi.values();

        Set<Integer> urunListesiKeyseti = urunListesi.keySet();
        List<Integer> keyList = new ArrayList<>();
        keyList.addAll(urunListesiKeyseti);

        List<String> valueList = new ArrayList<>();
        valueList.addAll(urunListesi.values());

        String arrayMDList[][] = new String[valueList.size()][valueList.get(0).split(" - ").length];
        for (int i = 0; i < arrayMDList.length; i++) {
            String tempArr[] = valueList.get(i).split(" - ");

            for (int j = 0; j < arrayMDList[i].length; j++) {
                arrayMDList[i][j] = tempArr[j];
            }
        }
        return arrayMDList;
    }

}
