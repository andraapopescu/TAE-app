package ebusiness.tae.project.domain;

import javax.persistence.*;

@Entity
@Table(name = "function")
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long function_id;
    private String name;
    private String description;

    public Function(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Function() {

    }

    public long getId() {
        return function_id;
    }

    public void setId(long id) {
        this.function_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
