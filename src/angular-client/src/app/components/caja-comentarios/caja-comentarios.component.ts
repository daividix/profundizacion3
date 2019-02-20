import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-caja-comentarios',
  templateUrl: './caja-comentarios.component.html',
  styleUrls: ['./caja-comentarios.component.scss']
})
export class CajaComentariosComponent implements OnInit {

  calificacion= '';//calificacion de cada usuario
  comentarios: object;
  comentario: string = '';//area text

  constructor(/** asigno variable data para servicio de comentar  */) { }

  ngOnInit() {this.getComentarios(); }

  onSubmit() {
    alert("Thanks for comment!" );
  }

  getComentarios(){ //metodo que consulta al servicio web listar comentarios
    //this.comentariosService.listarComentarios().subscribe( res=> {
    //  this.comentarios = res;
   // },error=>{});
  }

  hacerEstrellas(calificacion){
    let estrellas = [];
    for (let i = 0; i < calificacion*1; i++) {
        estrellas.push(i);
      }
      return estrellas;
  }

}
