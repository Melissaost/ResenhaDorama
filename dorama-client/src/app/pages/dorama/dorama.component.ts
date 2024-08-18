import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoramaService } from 'src/app/core/service/dorama.service';
import { Dorama } from 'src/app/core/types/dorama';
import { DoramaResenha } from 'src/app/core/types/doramaResenha';

@Component({
  selector: 'app-dorama',
  templateUrl: './dorama.component.html',
  styleUrls: ['./dorama.component.css']
})
export class DoramaComponent implements OnInit {

  dorama!: DoramaResenha;
  idDorama!: string;

  constructor(
    private serviceDorama: DoramaService,
    private route: ActivatedRoute,
    public router: Router,
    public http: HttpClient,
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const parametro = params.get('id');
      if (parametro) {
        this.idDorama = parametro;
        this.loadDorama(this.idDorama);
      }
    });
  }

  loadDorama(id: string): void {
    this.serviceDorama.doramaId(+id).subscribe(
      (dorama: DoramaResenha) => {
        this.dorama = dorama;
        console.log(this.dorama)
      },
      (error) => {
        console.error('Erro ao carregar o dorama:', error);
      }
    );
  }
}