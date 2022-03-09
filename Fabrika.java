public class Fabrika {
    private int calisansay;
    private int maas;
    private int urunstok;
    private int kapital;
    private int uruncap;
//constructor
public Fabrika(int urunstok,int kapasite,int uruncap) {
    calisansay = 0;
    maas = 0;
    if ((urunstok <= 0) || (uruncap <= 0) || (kapital <= 0)) throw new RuntimeException("Girilen değerler negative sayı olmamalıdır");
    if (urunstok > uruncap) throw new RuntimeException("Stok miktarı kapasiteden büyük olmamalıdır");
}
//getters
public int getCalisan_sayisi() {
    return calisansay;
}
public int getMaas() {
    return maas;
}
public int getStok_miktari() {
    return urunstok;
}
public int getKapasite() {
    return uruncap;
}
public int getKapital() {
    return kapital;
}
//setters
private void setCalisan_sayisi(int n) {
    if (n<0) return;
    calisansay = n;
}
private void setKapital(int n) {
    if (n<0) return;
    kapital = n;
}
public void setMaas(int n) {
    if (n<0) return;
    maas = n;
}
public void setStok_Miktari(int n) {
    if (n<0) return;
    urunstok = n;
}

public int calisanAl(int n) {
    if (n<0) return getCalisan_sayisi();
    int temp = getCalisan_sayisi();
    setCalisan_sayisi(temp+n);
    return getCalisan_sayisi();
}
public int maasZam(int n) {
    if (n<0) return getMaas();
    int temp = getMaas();
    setMaas(temp+n);
    return getMaas();
}
public int urunSat(int n, int m) {
    if (n>(getStok_miktari())) throw new RuntimeException("Stoktan fazla ürün satamazsınız");
    int temp = getStok_miktari();
    temp -= n;
    setStok_Miktari(temp);    
    temp = getKapital();
    temp += n*m;
    setKapital(temp);
    return getKapital();
}
public int urunAl (int n, int m) {
    if ((getKapasite() < (getStok_miktari()+n)) || ((getKapital() < n*m))) throw new RuntimeException("Kapasiteden veya kapitalinizden fazla ürün alamazsınız");
    int temp = getStok_miktari();
    temp += n;
    setStok_Miktari(temp);
    temp = getKapital();
    temp -= n*m;
    setKapital(temp);
    return getStok_miktari();
}

public String toString() {
    return "Çalışan sayısı: " + calisansay + "/nMaaş: " + maas + "/nÜrün stok miktarı: " + urunstok + "/nKapital miktarı: " + kapital + "/nFabrika ürün kapasitesi miktarı: " + uruncap;
}
    
}
