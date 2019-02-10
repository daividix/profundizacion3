import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-sitios-result',
  templateUrl: './sitios-result.component.html',
  styleUrls: ['./sitios-result.component.scss']
})
export class SitiosResultComponent implements OnInit {

  sitiosAll$: object;

  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getSitios().subscribe(
      data => this.sitiosAll$ = data
    );
  }

}
