package cn.tiankafei.spring.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode()
public class Book {
    private String name;
    private String author;
    private Double price;

    public Book() {
    }

    public Book(String name, String author, Double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
}