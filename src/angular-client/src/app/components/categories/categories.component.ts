import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss']
})
export class CategoriesComponent implements OnInit {

  categories$: object;

  constructor(private data: DataService) { }


  ngOnInit() {
    this.data.getCategories().subscribe(
      data => this.categories$ = data
    );
  }

}
