package model.data;

// class bergantung di atk.java
import model.entity.atk;
public class atkList {
    private atk head;
    //DLL
    public atkList() {
        head = null;

        atk product1 = new atk("P001", "Pulpen", 1000.0, 100);
        atk product2 = new atk("P002", "Buku", 5000.0, 50);
        atk product3 = new atk("P003", "Penghapus", 2000.0, 200);

        // head menunjuk ke product1
        // product1 terhubung ke product2
        // dst
        head = product1; 
        product1.setNext(product2);
        product2.setPrevious(product1);
        product2.setNext(product3);
        product3.setPrevious(product2);
    }

    // tambah produk
    public void addProduct(atk product) {
        if (head == null) {
            head = product;  
        } else {
            atk current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            // smbungkan produk baru ke node terakhir.
            current.setNext(product);
            product.setPrevious(current);
        }
    }

    public atk getHead() {
        return head;
    }

    //cari produk dengan ID
    public atk findProductById(String id) {
        atk current = head;
        while (current != null) {
            //cari id yang diacari
            if (current.getId().equals(id)) {
                return current;
            }
            //cocok? kembalikan node tersebut
            current = current.getNext();
        }
        return null;
    }

    // edit produk
    public void editProduct(String id, String newName, double newPrice, int newStock) {
        // findProductById(id) untuk mencari produknya
        atk product = findProductById(id);
        if (product != null) {
            product.setName(newName);
            product.setPrice(newPrice);
            product.setStock(newStock);
            System.out.println("Produk berhasil diperbarui:");
            System.out.println(product);
        } else {
            System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
        }
    }

    // hapus produk
    public void removeProduct(atk product) {
        if (head == null) return; 
        atk current = head;

        if (current.equals(product)) {
            head = current.getNext();
            if (head != null) {
                head.setPrevious(null); 
            }
            return;
        }

        while (current != null && !current.equals(product)) {
            current = current.getNext();
        }

        if (current != null) {
            atk prev = current.getPrevious();
            atk next = current.getNext();
            if (prev != null) {
                prev.setNext(next);
            }
            if (next != null) {
                next.setPrevious(prev);
            }
        }
    }

    // print peoduk atk
    public void printProducts() {
        atk current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }
}
