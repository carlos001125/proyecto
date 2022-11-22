import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../dto/Cliente.dto';
import { IClienteService } from '../interfaces/IClienteService';
import { Response } from '../models/Response.dto';
import { environment } from 'environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClienteService implements IClienteService<Cliente>{

  baseUrl: string = environment.baseUrl;
  getAllUrl: string = `${this.baseUrl}/api/proyecto/clientes/getAll`;
  getByIdUrl: string = `${this.baseUrl}/api/proyecto/clientes/getById`; // aqui falta el id
  createOrUpdateUrl: string = `${this.baseUrl}/api/proyecto/clientes/createOrUpdate`;
  deleteByIdUrl: string = `${this.baseUrl}/api/proyecto/clientes/deleteById`; // aqui falta el id

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Response<Cliente[]>> {
    return this.httpClient.get<Response<Cliente[]>>(`${this.getAllUrl}`);
  }
  getById(id: number): Observable<Response<Cliente>> {
    return this.httpClient.get<Response<Cliente>>(`${this.getByIdUrl}/${id}`);
  }
  createOrUpdate(entity: Cliente): Observable<Response<Cliente>> {
    return this.httpClient.post<Response<Cliente>>(`${this.createOrUpdateUrl}`, entity);
  }
  deleteById(id: number): Observable<Response<Cliente>> {
    return this.httpClient.delete<Response<Cliente>>(`${this.deleteByIdUrl}/${id}`);
  }


}
