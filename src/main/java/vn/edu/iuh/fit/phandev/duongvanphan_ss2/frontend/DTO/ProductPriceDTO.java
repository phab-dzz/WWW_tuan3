package vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.DTO;

import java.time.Instant;

public class ProductPriceDTO {
    private  int id;

    private Instant applydate;
    private double value;
    private String note;


    public ProductPriceDTO(int id, ProductDTO productDTO, Instant applydate, double value, String note) {
        this.id = id;

        this.applydate = applydate;
        this.value = value;
        this.note = note;
    }

    public ProductPriceDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Instant getApplydate() {
        return applydate;
    }

    public void setApplydate(Instant applydate) {
        this.applydate = applydate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPriceDTO{" +
                "id=" + id +

                ", applydate=" + applydate +
                ", value=" + value +
                ", note='" + note + '\'' +
                '}';
    }
}
