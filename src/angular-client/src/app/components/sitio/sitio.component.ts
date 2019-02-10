import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from '../services/data.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-sitio',
  templateUrl: './sitio.component.html',
  styleUrls: ['./sitio.component.scss']
})
export class SitioComponent implements OnInit {

  sitio$: Object;

  constructor(private route: ActivatedRoute, private data: DataService ) {
   this.route.params.subscribe( params => this.sitio$ = params.id);
  }

  ngOnInit() {
    this.data.getSitio(this.sitio$).subscribe(
      data => this.sitio$ = data
    );
  }

}
