package org.develnotes.examples;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Report implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    @Column(name="login")
    private String login;    
    @Column(name="number1")
    private String number1;
    @Column(name="operation")
    private String operation;
    @Column(name="number2")
    private String number2;
    @Column(name="result")
    private String result;
    @Column(name="datetime")
    private Date datetime;  
    
    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        this._id = id;
    }

    public String getUsername() {
        return login;
    }

    public void setUsername(String login) {
        this.login = login;
    }
    
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    
    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }
    
    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }
    
    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
    
    public Date getDateTime() {
        return datetime;
    }

    public void setDateTime(Date datetime) {
        this.datetime = datetime;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (_id != null ? _id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {   
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this._id == null && other._id != null) || (this._id != null && !this._id.equals(other._id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Entity.Log[ id=" + _id + " ]";
    }
    
}
