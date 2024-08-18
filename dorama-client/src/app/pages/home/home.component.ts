import { ResenhaService } from './../../core/service/resenha.service';
import { Component, OnInit } from '@angular/core';
import { DoramaService } from 'src/app/core/service/dorama.service';
import { Dorama } from 'src/app/core/types/dorama';
import { Resenha } from 'src/app/core/types/resenha';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  listDorama: Dorama[] = [];
  resenhas: any;

  constructor(private serviceDorama: DoramaService,
    private resenhaService: ResenhaService
  ) { }

  ngOnInit(): void {
    this.obterDoramas();
    this.obterResenhas();
  }

  obterDoramas(){
    this.serviceDorama.listar()
    .subscribe(resposta => {
      this.listDorama = resposta;
      console.log(resposta)
    });
  }

  obterResenhas(){
    this.resenhaService.listar()
    .subscribe(resposta => {
      this.resenhas = resposta;
      console.log(resposta)
    });
  }

}
