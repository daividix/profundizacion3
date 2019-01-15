export class Site {
    id: Number
    name: String
    address: String
    city: String
    latitude: String
    longitude: String
    phoneNumber: String
    eslogan: String
    information: String
    category: Number
    calification: Number

    constructor(id: Number, name: String,
        address: String,
        city: String,
        latitude: String,
        longitude: String,
        phoneNumber: String,
        eslogan: String,
        information: String,
        category: Number,
        calification: Number){
            this.id = id
            this.name = name
            this.address = address
            this.city = city
            this.latitude = latitude
            this.longitude = longitude
            this.phoneNumber = phoneNumber
            this.eslogan = eslogan
            this.information = information
            this.category = category
            this.calification = calification
    }
}