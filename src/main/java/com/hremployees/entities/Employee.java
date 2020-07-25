package com.hremployees.entities;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="employee")
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;

    String address;
    @Pattern(regexp = "^([0-9]{8,10})$")
    String phone;

    int grade;

    int score;



    @Column(name="created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name="modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @ManyToOne(fetch= FetchType.EAGER)
    private Departement departement;

    @ManyToOne(fetch= FetchType.EAGER)
    private Remuneration remuneration;

    public Employee(long id,String name, String address, String phone,int grade, int score, Departement departement, Remuneration remuneration) {
        this.id=id;
        this.name = name;
        this.address= address;
        this.phone = phone;
        this.grade = grade;
        this.score = score;
        this.departement = departement;
        this.remuneration = remuneration;
    }

    public void addScore(){
        this.score++;
    }

    public void subbsScore(){
        this.score--;
    }

    public void reinitialiseScore(){
        this.score = 0;
    }

    public abstract void setSousAdjacents(List<NormalEmployee> normalEmployeeList);

    public NormalEmployee  managerToNormal(ManagerEmployee managerEmployee){
        NormalEmployee normalEmployee = new NormalEmployee();
        normalEmployee.setScore(managerEmployee.getScore());
        normalEmployee.setAddress(managerEmployee.getAddress());
        normalEmployee.setGrade(managerEmployee.getGrade());
        normalEmployee.setName(managerEmployee.getName());
        normalEmployee.setPhone(managerEmployee.getPhone());
        normalEmployee.setDepartement(managerEmployee.getDepartement());
        normalEmployee.setRemuneration(managerEmployee.getRemuneration());
        normalEmployee.setCreated(managerEmployee.getCreated());
        normalEmployee.setModified(new Timestamp(System.currentTimeMillis()));
        return normalEmployee;
    };

    public String type() {
       Class<?> employeeClass = this.getClass();
       if(employeeClass.getName() == "com.employees.entities.ManagerEmployee"){
           return "manager";
       }else if (employeeClass.getName() == "com.employees.entities.NormalEmployee"){
           return "normal";
       }else{
           return "non reconnue";
       }
    }

    public abstract List<NormalEmployee> getNormalEmployees();
}

