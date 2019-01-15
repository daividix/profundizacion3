import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../../services/register.service'
import { Site } from '../../models/site'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  modelSitio: any = {}
  constructor(private service: RegisterService) { }

  ngOnInit() {
  }
  
  registrarSitio(event){
    event.preventDefault()
    const sitio: Site = {
      id: 0,
      name: this.modelSitio.name,
      address: this.modelSitio.address,
      city: this.modelSitio.city,
      latitude: this.modelSitio.latitude,
      longitude: this.modelSitio.longitude,
      phoneNumber: this.modelSitio.phoneNumber,
      eslogan: this.modelSitio.eslogan,
      information: this.modelSitio.information,
      category: parseInt(this.modelSitio.category),
      calification: parseFloat(this.modelSitio.calification)
    }
    this.service.agregarSitio(sitio)
    .subscribe(sitio=>{
      this.modelSitio.name = ''
      this.modelSitio.address = ''
      this.modelSitio.city = ''
      this.modelSitio.latitude = ''
      this.modelSitio.longitude = ''
      this.modelSitio.phoneNumber = ''
      this.modelSitio.eslogan = ''
      this.modelSitio.information = ''
      this.modelSitio.category = ''
      this.modelSitio.calification = ''
    })
  }

}
