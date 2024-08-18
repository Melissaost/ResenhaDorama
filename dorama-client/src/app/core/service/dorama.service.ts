import { Dorama } from '../types/dorama';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { DoramaResenha } from '../types/doramaResenha';

@Injectable({
  providedIn: 'root'
})
export class DoramaService {

  private apiUrl: string = environment.apiUrl;

  constructor(
    private httpClient: HttpClient
  ) {
  }

  listar(): Observable<Dorama[]>{
    return this.httpClient.get<Dorama[]>(`${this.apiUrl}/dorama`)
  }

  doramaId(id: number): Observable<DoramaResenha> {
    return this.httpClient.get<DoramaResenha>(`${this.apiUrl}/dorama/${id}`);
  }
}
