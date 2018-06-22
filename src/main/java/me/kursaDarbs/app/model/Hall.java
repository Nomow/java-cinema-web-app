package me.kursaDarbs.app.model;
import javax.persistence.*;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table(name = "Hall")
public class Hall {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @Column(name="rows")
    private int rows;

    @Column(name="cols")
    private int cols;


    public Hall(){}

    public Integer GetId() {
        return id;
    }
    public void SetId(Integer id) { this.id = id; }


    public Cinema GetCinema() {
        return cinema;
    }
    public void SetCinema(Cinema cinema) { this.cinema = cinema; }


    public Integer GetRows() {
        return rows;
    }
    public void SetRows(Integer row) { this.rows = rows; }

    public Integer GetCols() {
        return cols;
    }
    public void SetCols(Integer col) { this.cols = cols; }


    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id", id);
            jsonObj.put("cinema_name", cinema.GetName());
            jsonObj.put("rows", rows);
            jsonObj.put("cols", cols);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj.toString();
    }

}
