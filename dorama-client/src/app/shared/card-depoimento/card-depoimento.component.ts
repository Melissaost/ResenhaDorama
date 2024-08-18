import { Component, Input, OnInit } from '@angular/core';
import { Resenha } from 'src/app/core/types/resenha';

@Component({
  selector: 'app-card-depoimento',
  templateUrl: './card-depoimento.component.html',
  styleUrls: ['./card-depoimento.component.css']
})
export class CardDepoimentoComponent {
  @Input() resenha!: Resenha;
}