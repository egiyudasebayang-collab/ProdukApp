package kelas.data;

/**
 *
 * @author egiyuda
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Produk;
import kelas.model.ProdukMakanan;
import kelas.model.ProdukMinuman;

public class DataProduk {

    private final ObservableList<Produk> daftar = FXCollections.observableArrayList();
    private int urutan = 1;

    public ObservableList<Produk> getDaftar() {
        return FXCollections.unmodifiableObservableList(daftar);
    }

    public String buatKodeOtomatis() {
        return String.format("PRD%03d", urutan);
    }

    public Produk tambah(String kodeInput, String nama, String kategori, long harga, int jumlah, String uri) {
        String kodeFinal = (kodeInput == null || kodeInput.isBlank())
                ? String.format("PRD%03d", urutan)
                : kodeInput.trim().toUpperCase();

        Produk p;
        if ("Minuman".equals(kategori)) {
            p = new ProdukMinuman(kodeFinal, nama, harga, jumlah, uri);
        } else {
            p = new ProdukMakanan(kodeFinal, nama, harga, jumlah, uri);
        }

        daftar.add(p);
        urutan++;
        return p;
    }

    public void hapus(Produk p) {
        daftar.remove(p);
    }
}