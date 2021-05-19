package io.kameloon.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "quotes")
@Data
@AllArgsConstructor
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String title;
    private String text;
    @CreatedDate
    private Date createDate;

    public Quote() {}

    public Quote(String author, String title, String text) {
        this.author = author;
        this.title = title;
        this.text = text;
        this.createDate = new Date();
    }

    public String getDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(createDate);
    }
}
