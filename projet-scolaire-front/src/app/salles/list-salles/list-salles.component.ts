import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Salle } from 'src/app/model/salle';
import { SalleService } from 'src/app/service/salle.service';

@Component({
  selector: 'app-list-salles',
  templateUrl: './list-salles.component.html',
  styleUrls: ['./list-salles.component.css']
})
export class ListSallesComponent implements OnInit {

  salles: Salle[] = [];


  constructor(private salleService : SalleService, private router: Router) { }

  ngOnInit(): void {
    this.init();
  }

  public init() {
    this.salleService.allSalle().subscribe((data) => {
      this.salles = data;

      console.log(data);
    });
  }
  public delete(id: number) {
    this.salleService.delete(id).subscribe((result) => {
      this.init();
    });
  }


 public findById(){}

    }

