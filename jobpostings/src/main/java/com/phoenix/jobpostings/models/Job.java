package com.phoenix.jobpostings.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;


@Entity
@Table(name="jobs") //You may need to rename me if this is the third table in a MANY TO MANY relationship...
public class Job {
    //PrimaryKey
    @Id
    //PrimaryKey AutoGeneration
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(min = 1, max = 30)
    private String company;

    @Size(min = 1, max = 50)
    private String title;

    private String summary;

    private Integer salary;

    private String location;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    //RELATIONSHIPS BETWEEN TABLES

    @OneToMany(mappedBy="job", fetch=FetchType.LAZY)
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


    @OneToMany(mappedBy="job", fetch=FetchType.LAZY)
    private List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }


    //END OF RELATIONSHIPS BETWEEN TABLES


    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
}
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
}
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
}
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
}
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
}

    //END OF GETTERS AND SETTERS


    // CONSTRUCTORS 
    public Job() { 
    } 
    // creates object 
    public Job(String company,  String title,  String summary,  Integer salary,  String location ){ 
        this.company = company; 
        this.title = title; 
        this.summary = summary; 
        this.salary = salary; 
        this.location = location; 
    } 

    // updates object
    public Job(Long id, String company, String title, String summary, Integer salary, String location ){ 
        this.id = id; 
        this.company = company; 
        this.title = title; 
        this.summary = summary; 
        this.salary = salary; 
        this.location = location; 
    } 

    //END OF CONSTRUCTORS 

    @PrePersist 
    protected void onCreate(){ 
        this.createdAt = new Date(); 
    } 
    @PreUpdate 
    protected void onUpdate(){ 
        this.updatedAt = new Date(); 
    } 
} 
