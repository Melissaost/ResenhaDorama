import { Dorama } from 'src/app/core/types/dorama';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-card-busca',
  templateUrl: './card-busca.component.html',
  styleUrls: ['./card-busca.component.css']
})
export class CardBuscaComponent implements OnInit {
  @Input() dorama!: Dorama;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  verMais(id: number): void {
    this.router.navigate([`/dorama/${id}`]);
  }

}
