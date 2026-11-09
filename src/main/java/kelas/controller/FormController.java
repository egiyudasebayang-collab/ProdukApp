package kelas.controller;

/**
 *
 * @author egiyuda
 */
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.FileChooser;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {

    @FXML
    private TextField kodeField, namaField, hargaField, jumlahField;
    @FXML
    private ComboBox<String> kategoriBox;
    @FXML
    private Label pesanLabel;
    @FXML
    private ImageView gambarView;

    private Navigator navigator;
    private DataProduk data;
    private String gambarUri;

    @FXML
    private void initialize() {
        kategoriBox.getItems().addAll("Makanan", "Minuman");
        kategoriBox.setValue("Makanan");
        jumlahField.setText("1");
    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
        kodeField.setText(data.buatKodeOtomatis());
    }

    @FXML
    private void pilihGambar() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Pilih foto produk");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Gambar PNG/JPEG", "*.png", "*.jpg", "*.jpeg"));
        File file = chooser.showOpenDialog(namaField.getScene().getWindow());
        if (file == null) {
            return;
        }
        if (file.length() > 5L * 1024 * 1024) {
            pesanLabel.setText("Maksimum gambar 5 MB.");
            return;
        }
        Image image = new Image(file.toURI().toString(), 640, 480, true, true);
        if (image.isError()) {
            pesanLabel.setText("Gambar tidak dapat dibaca.");
            return;
        }
        gambarUri = file.toURI().toString();
        gambarView.setImage(image);
        pesanLabel.setText("Gambar dipilih, belum diunggah ke server.");
    }

    @FXML
    private void hapusGambar() {
        gambarUri = null;
        gambarView.setImage(null);
        pesanLabel.setText("Lampiran gambar dihapus.");
    }

    @FXML
    private void simpan() {
        Produk p;
        try {
            String teksHarga = hargaField.getText().trim();
            if (teksHarga.isEmpty()) {
                pesanLabel.setText("Harga produk harus diisi dan lebih dari nol.");
                return;
            }
            long harga = Long.parseLong(teksHarga);

            String teksJumlah = jumlahField.getText().trim();
            int jumlah = teksJumlah.isEmpty() ? 1 : Integer.parseInt(teksJumlah);

            p = data.tambah(
                    kodeField.getText(),
                    namaField.getText(),
                    kategoriBox.getValue(),
                    harga,
                    jumlah,
                    gambarUri
            );
        } catch (NumberFormatException e) {
            pesanLabel.setText("Harga dan jumlah harus berupa angka bulat yang valid.");
            return;
        } catch (IllegalArgumentException e) {
            pesanLabel.setText(e.getMessage());
            return;
        }

        try {
            navigator.bukaDetail(p);
        } catch (IOException e) {
            data.hapus(p);
            pesanLabel.setText("Halaman detail gagal dibuka; data dibatalkan. Periksa FXML.");
            e.printStackTrace();
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka daftar produk.");
            e.printStackTrace();
        }
    }
}