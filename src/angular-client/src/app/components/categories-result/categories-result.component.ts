import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';




@Component({
  selector: 'app-categories-result',
  templateUrl: './categories-result.component.html',
  styleUrls: ['./categories-result.component.scss']
})
export class CategoriesResultComponent implements OnInit {

  result$: Object;
  category$: Object;

  constructor( private route: ActivatedRoute, private data: DataService ) {
    this.route.params.subscribe( params => this.result$ = params.id);
  }

  ngOnInit() {
    this.data.getCategoriesResult(this.result$).subscribe(
      data => this.result$ = data
    );
    this.data.getSitios().subscribe(
      data => this.category$ = data
    );
  }
  //Con Ruta Activa + id

  /*constructor(private route: ActivatedRoute, private data: DataService) {
    this.route.params.subscribe( params => this.result$ = params.id );
   }

  ngOnInit() {
    this.data.getCategoriesResult(this.result$).subscribe(
      data => this.result$ = data
    );
  }*/

}
