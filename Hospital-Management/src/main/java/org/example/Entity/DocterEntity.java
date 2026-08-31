package org.example.Entity;



import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "docter")
// Select
@NamedQuery(name = "getAllDocters", query = "select d from DocterEntity d")
@NamedQuery(name = "findDocterByName", query = "select d from DocterEntity d where d.name = :name")
@NamedQuery(name = "findDocterBySpecialization", query = "select d from DocterEntity d where d.specialization = :specialization")
@NamedQuery(name = "findDocterByHospitalName", query = "select d from DocterEntity d where d.hospitalName = :hospitalName")
@NamedQuery(name = "findDocterByPhoneNumber", query = "select d from DocterEntity d where d.phoneNumber = :phoneNumber")

// Update
@NamedQuery(name = "updateDocterName", query = "update DocterEntity d set d.name = :name where d.id = :id")
@NamedQuery(name = "updateDocterSpecialization", query = "update DocterEntity d set d.specialization = :specialization where d.id = :id")

// Delete
@NamedQuery(name = "deleteDocter", query = "delete from DocterEntity d where d.id = :id")
public class DocterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "phone_number")
    private String phoneNumber;
}
