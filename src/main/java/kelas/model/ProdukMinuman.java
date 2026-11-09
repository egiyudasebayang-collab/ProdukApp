/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas.model;

/**
 *
 * @author egiyuda
 */

public class ProdukMinuman extends Produk {

    public ProdukMinuman(String kode, String nama, long harga, int jumlah, String gambarUri) {
        super(kode, nama, "Minuman", harga, jumlah, gambarUri);
    }

    @Override
    public long hitungTotal() {
        long subtotal = getHarga() * getJumlah();
        long biayaKemasan = 1000L * getJumlah(); // Biaya cup/kemasan Rp1.000 per item
        return subtotal + biayaKemasan;
    }

    @Override
    public String getInfoTambahan() {
        return "Termasuk biaya kemasan Rp1.000/item";
    }
}