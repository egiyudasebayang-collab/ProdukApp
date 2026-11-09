# Aplikasi Daftar Produk Toko (ProdukApp)

Aplikasi desktop pencatatan dan manajemen daftar produk toko berbasis **JavaFX 21** dan **Maven**[cite: 1, 3, 49]. Proyek ini menerapkan konsep Pemrograman Berorientasi Objek (OOP) meliputi *Encapsulation*, *Inheritance*, dan *Polymorphism* dengan arsitektur terpisah antara Model, Data, Controller, dan View (FXML/CSS)[cite: 1, 3].

## Fitur Utama
- **Form Tambah Produk:** Input kode produk (otomatis/manual), nama produk, kategori (`Makanan` / `Minuman`), harga satuan, jumlah stok/item, serta lampiran foto produk lokal (PNG/JPEG maks. 5 MB)[cite: 1, 22].
- **Validasi Input:** Menolak input nama produk kosong atau harga/jumlah yang tidak valid ($\le 0$)[cite: 1].
- **Perhitungan Otomatis (Inheritance & Polymorphism):**
  - `ProdukMakanan`: Menghitung total nilai transaksi ditambah PPN 10%.
  - `ProdukMinuman`: Menghitung total nilai transaksi ditambah biaya kemasan Rp1.000/item.
- **Tabel & Pencarian Daftar Produk:** Menampilkan seluruh produk dalam `TableView` dengan fitur pencarian kata kunci (nama/kode) melalui tombol **Cari**, filter kategori, serta opsi sembunyikan/tampilkan kolom[cite: 1, 19, 20].
- **Halaman Detail Produk:** Menampilkan rincian lengkap objek `Produk` yang dipilih beserta pratinjau gambar lokal[cite: 1, 22].

## Struktur Proyek
```text
ProdukApp/
├── pom.xml
├── nbactions.xml
└── src/main/
    ├── java/kelas/
    │   ├── MainApp.java
    │   ├── Navigator.java
    │   ├── model/ (Produk, ProdukMakanan, ProdukMinuman)
    │   ├── data/ (DataProduk)
    │   └── controller/ (FormController, DetailController, DaftarController)
    └── resources/kelas/
        ├── form.fxml
        ├── detail.fxml
        ├── daftar.fxml
        └── styles/app.css