import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgSelectModule } from '@ng-select/ng-select';
import { PaginationModule } from 'ngx-bootstrap/pagination';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule, MatSnackBarModule, MatButtonModule, MatSidenavModule } from '@angular/material';
import { MatToolbarModule, MatIconModule, MatMenuModule } from '@angular/material';
import { MatDividerModule, MatInputModule, MatTableModule, MatPaginatorModule } from '@angular/material';
import { MatCardModule, MatDatepickerModule } from '@angular/material';
import { MatNativeDateModule, MatSelectModule } from '@angular/material';

@NgModule({
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule,
    MatDividerModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatCardModule,
    MatSnackBarModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule,
    NgSelectModule,
    PaginationModule.forRoot(),
    MatSelectModule
  ],
  exports: [
    MatButtonModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule,
    MatDividerModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatCardModule,
    MatSnackBarModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule,
    NgSelectModule,
    PaginationModule,
    MatSelectModule
  ],
  providers: []
})
export class MaterialModule { }
