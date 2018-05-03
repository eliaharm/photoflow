package com.eliaharm.photoflow.jpa;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import lombok.ToString;

import lombok.Data;

/**
 * @author elia_harmouche
 */
//@ToString
@Entity
@Table(name = "tbl_imported_files")
public @Data class Imported_files {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String job_id;

    @Basic
    private String file_name_path;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJob_id() {
        return this.job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getFile_name_path() {
        return this.file_name_path;
    }

    public void setFile_name_path(String file_name_path) {
        this.file_name_path = file_name_path;
    }

}