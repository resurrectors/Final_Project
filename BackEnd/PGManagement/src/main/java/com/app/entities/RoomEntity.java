package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="rooms")
@Getter
@Setter
public class RoomEntity extends BaseEntity{
	
	@Column(name="rent")
	private double rent;
	
	@ManyToOne(fetch = FetchType.LAZY) //MANDATORY --o.w will get org.hib.MappingExc
	@JoinColumn(name="building",nullable = false) //optional to specify FK column name n constraints
	private BuildingEntity building;
	
}
//[
// {
//     "id": 5,
//     "rent": 800.0,
//     "building": {
//         "id": 2,
//         "name": "b2",
//         "building_addr": {
//             "id": 1,
//             "addrl1": "firstline",
//             "addrl2": "secondline",
//             "city": "nashik",
//             "state": "maharashtra",
//             "country": "india",
//             "zipCode": "422008"
//         },
//         "owner": {
//             "id": 1,
//             "firstName": "rahun",
//             "lastName": "Patil",
//             "country_code": "91",
//             "contact_no": "9876543215",
//             "user_addr": {
//                 "id": 15,
//                 "addrl1": "new",
//                 "addrl2": "new",
//                 "city": "nashik",
//                 "state": "maharashtra",
//                 "country": "india",
//                 "zipCode": "422008"
//             },
//             "email": "shubh@gmail.com"
//         }
//     }
// },
// {
//     "id": 6,
//     "rent": 1800.0,
//     "building": {
//         "id": 2,
//         "name": "b2",
//         "building_addr": {
//             "id": 1,
//             "addrl1": "firstline",
//             "addrl2": "secondline",
//             "city": "nashik",
//             "state": "maharashtra",
//             "country": "india",
//             "zipCode": "422008"
//         },
//         "owner": {
//             "id": 1,
//             "firstName": "rahun",
//             "lastName": "Patil",
//             "country_code": "91",
//             "contact_no": "9876543215",
//             "user_addr": {
//                 "id": 15,
//                 "addrl1": "new",
//                 "addrl2": "new",
//                 "city": "nashik",
//                 "state": "maharashtra",
//                 "country": "india",
//                 "zipCode": "422008"
//             },
//             "email": "shubh@gmail.com"
//         }
//     }
// }
//]