package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="pastpapers")

public class Doc {
    @Column(name="Id")
    @Id

    private Integer Id;

    public String DocName;

    public String DocType;

    @Lob
    private byte[] data;

    public Doc(String docName, String docType, byte[] data) {
        super();
        DocName = docName;
        DocType = docType;
        this.data = data;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDocName() {
        return DocName;
    }

    public void setDocName(String docName) {
        DocName = docName;
    }

    public String getDocType() {
        return DocType;
    }

    public void setDocType(String docType) {
        DocType = docType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
