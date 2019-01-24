import { Component, OnInit, Input } from '@angular/core';
import { Site } from 'src/app/models/site';

@Component({
  selector: 'app-sites',
  templateUrl: './sites.component.html',
  styleUrls: ['./sites.component.css']
})
export class SitesComponent implements OnInit {

  // tslint:disable-next-line:no-input-rename
  @Input('sitios') sitios: Number[];
  constructor() { }

  ngOnInit() {
  }

}
