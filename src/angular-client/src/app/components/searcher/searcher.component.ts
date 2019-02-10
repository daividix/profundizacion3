import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-searcher',
  templateUrl: './searcher.component.html',
  styleUrls: ['./searcher.component.scss']
})
export class SearcherComponent implements OnInit {

  constructor(private data: DataService) { }

  categoriaPopular$: object;

  ngOnInit() {
    this.data.getCategories().subscribe(
      data => this.categoriaPopular$ = data
    );
  }

}
