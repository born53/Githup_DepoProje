import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UrunMethod extends UrunListesi {

    public static Integer urunTanimlama(){
        System.out.print("Urun ismini giriniz:");
        String urunAdi=scan.nextLine();
        scan.nextLine();
        System.out.print("Ureticiyi giriniz:");
        String ureticiAdi=scan.nextLine();
        System.out.print("Birim giriniz:");
        String urunBirim=scan.next();
        UrunListesi urun=new UrunListesi(urunAdi,ureticiAdi,urunBirim,urunId);
        List<UrunListesi> urun1=new ArrayList<>();
        urun1.add(urun);

        urunId++;
       UrunMethod obj=new UrunMethod();
       obj.urunListele();


return urunId;

    }
    public void urunListele(){
        System.out.println("  id      ismi     ureticisi     miktari      birimi      raf");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-6d   %-10s  %-10s %-6d %-7s %-5d",urunId,getUreticiAdi(),getUrunMiktari(),getUrunBirim(),getRafNumarasi());
    }

}
