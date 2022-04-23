import java.util.Scanner;

public class UrunListesi {
  public  static Scanner scan = new Scanner(System.in);
  public static Integer urunId=1000;
  private int urunMiktari;
  private String rafNumarasi;
 private  String urunAdi;
 private  String ureticiAdi;
 private  String urunBirim;

    public int getUrunMiktari() {
        return urunMiktari;
    }

    public void setUrunMiktari(int urunMiktari) {
        this.urunMiktari = urunMiktari;
    }

    public String getRafNumarasi() {
        return rafNumarasi;
    }

    public void setRafNumarasi(String rafNumarasi) {
        this.rafNumarasi = rafNumarasi;
    }

    public UrunListesi() {
    }

    public UrunListesi(String urunAdi, String ureticiAdi, String urunBirim,Integer urunId) {
        this.urunAdi = urunAdi;
        this.ureticiAdi = ureticiAdi;
        this.urunBirim = urunBirim;

    }


    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getUreticiAdi() {
        return ureticiAdi;
    }

    public void setUreticiAdi(String ureticiAdi) {
        this.ureticiAdi = ureticiAdi;
    }

    public String getUrunBirim() {
        return urunBirim;
    }

    public void setUrunBirim(String urunBirim) {
        this.urunBirim = urunBirim;
    }


    }

