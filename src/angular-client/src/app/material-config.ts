import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MatButtonModule, MatCheckboxModule,
MatInputModule, MatToolbarModule, MatFormFieldModule, MatSidenavModule,
MatSelectModule, MatCardModule, MatStepperModule, MatGridListModule, MatSnackBarModule} from '@angular/material';
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
    MatSelectModule,
    MatCardModule,
    MatStepperModule,
    MatGridListModule,
    MatSnackBarModule
  ],
  exports: [MatButtonModule,
    MatCheckboxModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    MatToolbarModule,
    FormsModule,
    MatSidenavModule,
    MatSelectModule,
    MatCardModule,
    MatStepperModule,
    MatGridListModule,
    MatSnackBarModule
  ],
})
export class MaterialModule { }
