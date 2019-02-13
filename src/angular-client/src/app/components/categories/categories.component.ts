import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss']
})
export class CategoriesComponent implements OnInit {

  categories$: object;

  constructor() { }


  ngOnInit() {
    /*
    this.data.getCategories().subscribe(
      data => this.categories$ = data
    );
    */
  }

}
