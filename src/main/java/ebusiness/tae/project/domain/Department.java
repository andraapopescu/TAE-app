package ebusiness.tae.project.domain;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long department_id;
    private String name;


    public Department() {

    }

    public Department(String name) {
        this.name = name;
    }

    public long getId() {
        return department_id;
    }

    public void setId(long id) {
        this.department_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", name='" + name + '\'' +
                '}';
    }
}