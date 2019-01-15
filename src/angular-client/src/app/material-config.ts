import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'
import {MatButtonModule, MatCheckboxModule, 
MatInputModule,MatToolbarModule,MatFormFieldModule} from '@angular/material';
import {MatIconModule} from '@angular/material/icon';

@NgModule({
  imports: [MatButtonModule, MatCheckboxModule,MatInputModule,MatFormFieldModule,MatIconModule,
    MatToolbarModule,FormsModule],
  exports: [MatButtonModule, MatCheckboxModule,MatInputModule,MatFormFieldModule,MatIconModule,
    MatToolbarModule,FormsModule],
})
export class MaterialModule { }