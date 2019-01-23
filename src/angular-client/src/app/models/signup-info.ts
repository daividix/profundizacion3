export class SignUpInfo {
    name: string;
    lastName: string;
    gender: string;
    image: string;
    username: string;
    email: string;
    password: string;
    // role: string[];
    constructor(name: string, lastName: string, gender: string, image: string, username: string,
        email: string, password: string) {

            this.name = name;
            this.lastName = lastName;
            this.gender = gender;
            this.image = image;
            this.username = username;
            this.email = email;
            this.password = password;
            // this.role = role;
    }
}
