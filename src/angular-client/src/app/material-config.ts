import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MatButtonModule, MatCheckboxModule,
MatInputModule, MatToolbarModule, MatFormFieldModule, MatSidenavModule,
MatSelectModule} from '@angular/material';
import {MatIconModule} from '@angular/material/icon';

@NgModule({
  imports: [MatButtonModule,
     MatCheckboxModule,
     MatInputModule,
     MatFormFieldModule,
     MatIconModule,
    MatToolbarModule,
    FormsModule,
    MatSidenavModule,
    MatSelectModule
  ],
  exports: [MatButtonModule,
    MatCheckboxModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    MatToolbarModule,
    FormsModule,
    MatSidenavModule,
    MatSelectModule
  ],
})
export class MaterialModule { }
