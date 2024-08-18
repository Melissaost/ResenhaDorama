import { Component, OnInit } from '@angular/core';
import { ResenhaService } from 'src/app/core/service/resenha.service';

@Component({
  selector: 'app-resenha',
  templateUrl: './resenha.component.html',
  styleUrls: ['./resenha.component.css']
})
export class ResenhaComponent implements OnInit {
  resenhas: any;

  constructor(private resenhaService: ResenhaService) { }

  ngOnInit(): void {
    this.obterResenhas();
  }

  obterResenhas(){
    this.resenhaService.listar()
    .subscribe(resposta => {
      this.resenhas = resposta;
      console.log(resposta)
    });
  }


}
