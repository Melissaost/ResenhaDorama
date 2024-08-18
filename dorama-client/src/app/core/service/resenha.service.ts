import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Resenha } from '../types/resenha';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResenhaService {

  private apiUrl: string = environment.apiUrl;

  constructor(private httpClient: HttpClient) { }

  listar(): Observable<Resenha[]>{
    return this.httpClient.get<Resenha[]>(`${this.apiUrl}/api/resenhas`)
  }
}
