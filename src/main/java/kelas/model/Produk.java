/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas.model;

/**
 *
 * @author egiyuda
 */

public class Produk {

    private final String kode;
    private final String nama;
    private final String kategori;
    private final long harga;
    private final int jumlah;
    private final String gambarUri;

    public Produk(String kode, String nama, String kategori, long harga, int jumlah, String gambarUri) {
        if (kode == null || kode.isBlank()) {
            throw new IllegalArgumentException("Kode produk wajib diisi.");
        }
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
        if (kategori == null || (!kategori.equals("Makanan") && !kategori.equals("Minuman"))) {
            throw new IllegalArgumentException("Kategori harus Makanan atau Minuman.");
        }
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga produk harus lebih dari nol.");
        }
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah produk harus lebih dari nol.");
        }

        this.kode = kode.trim();
        this.nama = nama.trim();
        this.kategori = kategori;
        this.harga = harga;
        this.jumlah = jumlah;
        this.gambarUri = gambarUri;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public long getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getGambarUri() {
        return gambarUri;
    }

    public long hitungTotal() {
        return harga * jumlah;
    }

    public String getInfoTambahan() {
        return "Tanpa biaya tambahan";
    }
}