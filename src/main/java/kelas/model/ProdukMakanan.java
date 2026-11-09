/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas.model;

/**
 *
 * @author egiyuda
 */

public class ProdukMakanan extends Produk {

    public ProdukMakanan(String kode, String nama, long harga, int jumlah, String gambarUri) {
        super(kode, nama, "Makanan", harga, jumlah, gambarUri);
    }

    @Override
    public long hitungTotal() {
        long subtotal = getHarga() * getJumlah();
        long pajak = Math.round(subtotal * 0.10); // Pajak PPN Makanan 10%
        return subtotal + pajak;
    }

    @Override
    public String getInfoTambahan() {
        return "Termasuk PPN Makanan 10%";
    }
}